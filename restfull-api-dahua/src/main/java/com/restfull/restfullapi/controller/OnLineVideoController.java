package com.restfull.restfullapi.controller;


import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController

public class OnLineVideoController {


    private static String appkey = "25569406";
    private static String secret = "GHvknuGvPPHgqW7kPQWy";
    private static String ip = "10.9.139.20";
    private static int port = 443;

    //分页获取监控点资源
    private static String cameras = "/artemis/api/resource/v1/cameras";
    //获取监控点预览取流URL
    private static String previewURLs = "/artemis/api/video/v1/cameras/previewURLs";
    /**
     * 能力开放平台的网站路径
     */
    private static final String ARTEMIS_PATH = "/artemis/api/video/v2/cameras/playbackURLs";

    /**
     * @description json中传入PageSize,和PageIndex 大小和页数 来获取列表数
     */
    @ApiOperation(value = "获取摄像头列表")
    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    public String Cameras(@RequestBody JSONObject requestval) {

        int pagesize = requestval.getInteger("pageSize");
        if (pagesize == 0) pagesize = 10;
        int pageindex = requestval.getInteger("pageNo");
        if (pageindex == 0) pageindex = 1;

        Map<String, String> path = new HashMap<String, String>(2) {
            {
                put("https://", cameras);//根据现场环境部署确认是http还是https
            }
        };
        ArtemisConfig artemisConfig = new ArtemisConfig();
        artemisConfig.setHost(ip + ":" + port);
        artemisConfig.setAppKey(appkey);
        artemisConfig.setAppSecret(secret);

        String contentType = "application/json";
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("pageSize", pagesize);
        jsonBody.put("pageNo", pageindex);
        String body = jsonBody.toJSONString();
        /**
         * STEP6：调用接口
         */
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, contentType, null);// post请求application/json类型参数
/*        JSONObject object = JSONObject.parseObject(result);
        JSONObject data = (JSONObject) object.get("data");
        JSONArray dataList = (JSONArray) data.get("list");
      //  List<String> cameraCodeList = new ArrayList<>();
        // 获取视频列表
        for (Object obj : dataList) {
            System.out.println(obj);
            // cameraCodeList.add(((JSONObject) obj).getString("cameraIndexCode"));
        }*/


        return result;
    }

    /**
     * @description 根据json中传入的cameraIndexCode,获取url
     */
    @ApiOperation(value = "获取摄像头访问地址")
    @RequestMapping(value = "/queryUrl", method = RequestMethod.POST)
    public String PreviewURLs(@RequestParam String cameraIndexCode) {
        Map<String, String> path = new HashMap<String, String>(2) {
            {
                put("https://", previewURLs);//根据现场环境部署确认是http还是https
            }
        };
        ArtemisConfig artemisConfig = new ArtemisConfig();
        artemisConfig.setHost(ip + ":" + port);
        artemisConfig.setAppKey(appkey);
        artemisConfig.setAppSecret(secret);

        String contentType = "application/json";

        String body = "{\"cameraIndexCode\":\"" + cameraIndexCode + "\",\"streamType\":1,\"protocol\":\"hls\",\"transmode\": 1}";
        //  String body = "{\"cameraIndexCode\":\"" + cameraIndexCode + "\",\"streamType\":1,\"protocol\":\"rtmp\",\"transmode\": 1}";
        //  String body = "{\"cameraIndexCode\":\"" + cameraIndexCode + "\",\"streamType\":0,\"protocol\":\"rtsp\",\"transmode\": 1,\"expand\":\"streamform=rtp\"}";
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, contentType, null);// post请求application/json类型参数
        return result;
    }


    /**
     * 根据每个侯问室的摄像头编号记录审问期间视频
     *
     * @param cameraIndexCode
     * @param beginTime
     * @param endTime
     * @return
     */
    @ApiOperation("获取监控点回放取流url")
    @PostMapping("/indexTime")
    public String indexTime(@RequestParam("cameraIndexCode") @ApiParam(name = "cameraIndexCode", value = "摄像头id") String cameraIndexCode,
                                  @RequestParam("beginTime") @ApiParam(name = "beginTime", value = "开始时间") String beginTime,
                                  @RequestParam("endTime") @ApiParam(name = "endTime", value = "结束时间") String endTime) {

        String cameraPlayBackURL = null;
        try {
            cameraPlayBackURL =getCameraPlayBackURL(cameraIndexCode, beginTime, endTime);
        } catch (Exception e) {

            return  e.getMessage();
        }

        JSONObject json = JSONObject.parseObject(cameraPlayBackURL);
        String resultData = json.getString("data");
        JSONObject da = JSONObject.parseObject(resultData);
        String url = da.getString("url");
        return url;

    }


    /**
     * 获取监控点回放取流url
     */
    public static String getCameraPlayBackURL(String cameraIndexCode, String beginTime, String endTime) {

        Map<String, String> path = new HashMap<String, String>(2) {
            {
                put("https://", ARTEMIS_PATH);
            }
        };
        ArtemisConfig artemisConfig = new ArtemisConfig();
        artemisConfig.setHost(ip + ":" + port);
        artemisConfig.setAppKey(appkey);
        artemisConfig.setAppSecret(secret);

        String contentType = "application/json";

        JSONObject jsonBody = new JSONObject();
        jsonBody.put("cameraIndexCode", cameraIndexCode);
        jsonBody.put("recordLocation", 1);//存储类型,0：中心存储，1：设备存储，默认为中心存储
        jsonBody.put("protocol", "rtsp");
        jsonBody.put("transmode", 1);
        jsonBody.put("beginTime", beginTime);//开始查询时间
        jsonBody.put("endTime", endTime);//结束查询时间,IOS8601格式：yyyy-MM-dd’T’HH:mm:ss.SSSXXX
        jsonBody.put("expand", "streamform=ps");
        String body = jsonBody.toJSONString();

        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, contentType, null);
        return result;
    }


    public static void main(String[] args) {
        String s = new OnLineVideoController().PreviewURLs("xx");
        System.out.println(s);
    }

}
