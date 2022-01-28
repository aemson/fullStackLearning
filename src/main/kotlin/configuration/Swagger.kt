package com.fsl.configuration

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


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


    @Bean
    fun orderDocket(): GroupedOpenApi? =
        GroupedOpenApi.builder()
            .group("welcome")
            .pathsToMatch("/api/welcome/**")
            .build()


    @Bean
    fun inventoryDocket(): GroupedOpenApi? =
        GroupedOpenApi.builder()
            .group("admin")
            .pathsToMatch("/api/admin/**")
            .build()


    @Bean
    fun webMvcConfigurer(): WebMvcConfigurer? {
        return object : WebMvcConfigurer {
            override fun addViewControllers(registry: ViewControllerRegistry) {
                registry.addRedirectViewController("admin-swagger.ui.html", "/swagger-ui.html?urls.primaryName=admin")
                registry.addRedirectViewController(
                    "welcome-swagger.ui.html",
                    "/swagger-ui.html?urls.primaryName=welcome"
                )
            }
        }
    }

}