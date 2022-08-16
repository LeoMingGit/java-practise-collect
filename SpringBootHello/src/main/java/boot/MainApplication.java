package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        // Spring应用启动起来
       SpringApplication.run(MainApplication.class,args);
    }
}
