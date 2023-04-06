package minio.upload;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableConfigurationProperties
@MapperScan("minio.upload.**.mapper")
@SpringBootApplication
public class MinioUploadApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinioUploadApiApplication.class, args);
    }

}
