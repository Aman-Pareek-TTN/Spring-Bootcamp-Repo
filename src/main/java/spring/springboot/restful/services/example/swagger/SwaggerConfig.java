package spring.springboot.restful.services.example.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//pt2 Ques 5 6
@Configuration
@EnableSwagger2
public class SwaggerConfig {

/*
    public static final Contact DEFAULT_CONTACT= new Contact(
            "Aman Pareek","http://localhost:8080/welcome",
            "aman.pareek@tothenew.com"
    );
*/


    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Rest Exercise API","Rest Exercise API Documentation"
            ,"1.0","urn:tos","Aman Pareek","Apache 2.0"
            ,"http://www.apache.org/licenses/LICENSE-ApiInfo.DEFAULT2.0"
    );

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO);
    }
}
