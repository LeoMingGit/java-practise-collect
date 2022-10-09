package com.fs.springbootds.controller;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class DsController {
    @ApiOperation("SayHello")
    @RequestMapping(value = "/SayHello", method = RequestMethod.GET)
    @ResponseBody
    public String SayHello() {

        return "hello world!!!";
    }

    /**
     * java stream api 示例代码
     * @return
     */
    @ApiOperation("java stream api 示例代码")
    @RequestMapping(value = "/StreamApi", method = RequestMethod.GET)
    @ResponseBody
    public String StreamApi() {

        //https://blog.csdn.net/qq_27005889/article/details/121053641?spm=1001.2101.3001.6650.2&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-2-121053641-blog-124370414.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-2-121053641-blog-124370414.pc_relevant_default&utm_relevant_index=3
        // 流的方式操作数组233
        List<String> strings = Arrays.asList("lily","bob","tom","cat","mom");

        List<String> res = strings.stream()
                .map(e->e.substring(0,1))
                .filter(e->e.charAt(0) >= 'c')
                .sorted()
                .limit(2)
                .collect(Collectors.toList());

        res.forEach(s -> {System.out.println("截取第一位字母且大于c的有： " + s);});

        return "StreamApi!!!";
    }

    /**
     * 容器_存取二维表格信息
     * @return
     */
    @ApiOperation("容器_存取二维表格信息")
    @RequestMapping(value = "/HashList", method = RequestMethod.GET)
    @ResponseBody
    public String HashList()  {
        Map<String,Object> m1=new HashMap<>();
        m1.put("id",10001);
        m1.put("title","java test");
        m1.put("createTime","2022-10-10");
        m1.put("length",300);

        Map<String,Object> m2=new HashMap<>();
        m2.put("id",10002);
        m2.put("title","spring test");
        m2.put("createTime","2022-10-12");
        m2.put("length",100);

        List<Map<String,Object>> lst=new ArrayList<>();
        lst.add(m1);
        lst.add(m2);
        System.out.println("id\t\ttitle\t\tcreateTime\tlength");
        for(int i=0;i<lst.size();i++) {
            Map<String,Object> temp = lst.get(i);
            System.out.println(temp.get("id")+"\t"
                    +temp.get("title")+"\t\t"
                    +temp.get("createTime")+"\t"
                    +temp.get("length"));
        }



        return "容器_存取二维表格信息!!!";
    }

}
