package com.sage.local.security.config

import com.sage.local.security.authorization.SecurityPreAuthorizeAuthorizationManager
import com.sage.local.security.filter.TestFilter
import org.springframework.aop.Advisor
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Role
import org.springframework.security.authorization.method.AuthorizationManagerBeforeMethodInterceptor
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.annotation.AnnotationTemplateExpressionDefaults
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.access.ExceptionTranslationFilter

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = false)
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            csrf {
                disable()
            }
            httpBasic {
                disable()
            }
            formLogin {
                disable()
            }
            sessionManagement {
                sessionCreationPolicy = SessionCreationPolicy.STATELESS
            }
            cors {
                disable()
            }
            authorizeHttpRequests {
                authorize("/favicon.ico", permitAll)
                authorize(anyRequest, authenticated)
            }
            addFilterAfter<ExceptionTranslationFilter>(TestFilter())
        }
        return http.build()
    }

    /**
     * We expose`MethodSecurityExpressionHandler`using a`static`method
     * to ensure that Spring publishes it before it initializes
     * Spring Security’s method security`@Configuration`classes
     */
    companion object {

        @Bean
        @JvmStatic
        fun templateExpressionDefaults(): AnnotationTemplateExpressionDefaults {
            return AnnotationTemplateExpressionDefaults()
        }

        @Bean
        @JvmStatic
        @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
        fun preAuthorize(manager: SecurityPreAuthorizeAuthorizationManager): Advisor {
            return AuthorizationManagerBeforeMethodInterceptor.preAuthorize(manager)
        }
    }
}