package com.fsl.configuration

import io.swagger.v3.oas.models.OpenAPI
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import io.swagger.v3.oas.models.info.Info;

@Configuration
class Swagger {
    /*
    @Bean
    fun api(): Docket =
           Docket(SWAGGER_2)
               .select()
               .apis(RequestHandlerSelectors.basePackage("com.fsl.controller"))
               .build()*/

    @Bean
    fun api(): OpenAPI = OpenAPI().info(Info().title("My Api"))

}