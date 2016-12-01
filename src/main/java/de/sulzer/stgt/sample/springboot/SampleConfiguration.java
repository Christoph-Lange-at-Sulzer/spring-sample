package de.sulzer.stgt.sample.springboot;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SampleConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfo("Sulzer Sample API", "", "0.0.1-ALPHA", "", "stuttgart@sulzer.de", "", ""))
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("de.sulzer.stgt.sample.springboot.api"))
                .paths(PathSelectors.any())
                .build();
    }
}