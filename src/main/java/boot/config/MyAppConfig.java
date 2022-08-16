package boot.config;


import boot.service.HelloService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

     public HelloService helloService02(){
         System.out.printf("配置类#bean给容器中添加组件了");
         return  new  HelloService();
     }
}
