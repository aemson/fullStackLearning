package com.fsl.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
@EnableWebSecurity
class AdminConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        println(passwordEncoder().encode("admin"))
        auth.inMemoryAuthentication()
            .withUser("admin")
            .password(passwordEncoder().encode("admin"))
            .authorities("ADMIN")
    }

    override fun configure(http: HttpSecurity) {
        http
            .antMatcher("/api/admin/**")
            .authorizeRequests()
            .anyRequest()
            .hasAnyAuthority("ADMIN")
            .and()
            .httpBasic()
    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()
}