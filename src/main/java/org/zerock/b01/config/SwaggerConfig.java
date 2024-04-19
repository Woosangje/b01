package org.zerock.b01.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "Zerock App", version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig { // json 테스트용 코드 필수 -> http://localhost:8080/swagger-ui/index.html

    @Bean
    public GroupedOpenApi chatOpenApi(){
        String[] paths = {"/**"};

        return GroupedOpenApi.builder()
                .group("Zerock OPEN API v1")
                .pathsToMatch(paths)
                .build();
    }

    // 부트 3 안됨
    // json 테스트용 코드 필수 -> http://localhost/swagger-ui/index.html
    // CustomServletConfig 필수
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.OAS_30)
//                .useDefaultResponseMessages(false)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("org.zerock.b01.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Boot 01 Project Swagger")
//                .build();
//    }
}
