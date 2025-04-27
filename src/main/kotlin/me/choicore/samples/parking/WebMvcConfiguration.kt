package me.choicore.samples.parking

import me.choicore.samples.parking.security.CredentialsHandlerMethodArgumentResolver
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration(proxyBeanMethods = false)
class WebMvcConfiguration {
    @Configuration(proxyBeanMethods = false)
    inner class WebMvcConfigurerAdapter(
        private val credentialsHandlerMethodArgumentResolver: CredentialsHandlerMethodArgumentResolver,
    ) : WebMvcConfigurer {
        override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
            resolvers.add(credentialsHandlerMethodArgumentResolver)
        }
    }
}
