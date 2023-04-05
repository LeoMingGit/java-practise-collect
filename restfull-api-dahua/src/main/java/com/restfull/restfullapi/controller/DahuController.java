package com.restfull.restfullapi.controller;

import com.restfull.restfullapi.client.util.AESUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;


@RestController
public class DahuController {



    @RequestMapping(value = "/mapgis/gm/xiangjiaba/big-screen/car/callback")
    public void  testCarCapture(@RequestBody String param, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //System.out.println("+++++++++++++++++++接收到新增推送接口数据+++++++++++++++++++++");

     //   param="+HHQVNS5HqR6aApWLS2r1YoL6Aod0Ujw7wY%2F4IyYxUi47W1v3%2FmYfvMjA6WH6WfCitvIG4b0C3uZBReoxU635veq4%2FV8I2qkOwxcX%2F7SPcQt9sAH8FtyHzDMEshrwF7m2avDh7cJd8%2FIdLjcE+Bpf+kV4kyTIYPD9NDB691UfCjqYzah1gHHR631fp6vXMCjgd4dqIKJYB3FjXiv1UrmIyaPG%2FMvJUpomeyamSBmgL9S2Rp+47LIB+OYNkf17j1Yk96yhkedr0hXv%2FCiD%2FBzsTNdTIgWYeTMISodwS034hW7jtl4ST%2Fj2Pb7hoLv1ENrP%2Fashl+1bIQi56CD%2F2nZ9VICdByYmMW8zt0pepJ5Bnai0LTMGYajUKXkLgLF%2F8VXobnE9Hn9vAoBeXWVbjlFH+0OKzEWWIzfzVpKtI+zmJlouynkWChlKrZNELorFShrcGnVJpCrWiPNtwcGlC8UdE7ans47G397MtqeYF9SzM1+ZtnYtnYW7uC0FtWHbuJUrlWcK120f689Ttj0qYyEJwhkLXR5PlIHG+sS1WXnY2rx7Bc7FsLopcxY4m7eGfFbAC24iVc1jhKte9mvIx%2FThAROz3B92Zd+HNWbGeVjJ33iTBv0k77Gt7PlLILiGwzwq9c94rn+K0NPWE%2F7f%2Fv77NKGjqTotkburwQ8zxjYzBYtiHaBr3wWPNr2OsPU5bHaGJ9Yk6LUd0vN7Ui2HYqWRtNT0VWh0EWY2V9NzBy2s7glujXnxHX2oL92NvHQyB0+iqbIeUN2oErmFy1XwFBQpjaGjDVLhTliqKUbptbrNAp%2FWr4ZHqZpRtEVpRSCxE4A9Ee1nTuMoJ8jcnke1Pzkr7NV4mD5zw0Vdzgu%2F4A2C2aHY1ke+wOXU6PEQbKKBF4BjRbhwfRWmuttZE0pZ+HAqg=%3D";

        //System.out.println(param);
        param = URLDecoder.decode(param, "utf-8");
        param = param.replace(" ", "+");
       // System.out.println(param);
        String userAgent = request.getHeader("User-Agent");
      //  userAgent="45833fad48aa095f6228cc979802fc9003f33d89186ac707561";
        //System.out.printf("==================32行=================");
        //System.out.printf(userAgent);
        userAgent = userAgent.substring(userAgent.lastIndexOf("_") + 1, userAgent.length());
        //System.out.printf("***************35行*************************");
        //System.out.println(userAgent);

        String[] nums = userAgent.split("[\\D]+");
        int ciphertnum=0;
        String lastNum = nums[nums.length - 1];
        if(lastNum.length()>1){
           // System.out.println(lastNum.length());
            String   s1=lastNum;
            Integer  b=lastNum.length()-1;
            lastNum = lastNum.substring(lastNum.length() - 1, lastNum.length());
            //System.out.printf(lastNum);

        }
        ciphertnum = Integer.parseInt(lastNum);
        String  ua1=userAgent;
        String key = userAgent.substring(ciphertnum, ciphertnum + 16);
        //System.out.println(key);
//        String s1 = AESUtil.aesDecrypt(param, key);
//        System.out.println(s1);
        //解密
        byte[] raw = key.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE,skeySpec);
        byte[] decode = new Base64().decode(param);
        byte[] bytes = cipher.doFinal(decode);
        String s = new String(bytes, "utf-8");
        System.out.println(s);
    }

}
