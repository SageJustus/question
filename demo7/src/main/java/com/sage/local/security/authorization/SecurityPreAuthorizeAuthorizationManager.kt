package com.sage.local.security.authorization

import org.aopalliance.intercept.MethodInvocation
import org.springframework.security.authorization.AuthorizationDecision
import org.springframework.security.authorization.AuthorizationManager
import org.springframework.security.authorization.method.PreAuthorizeAuthorizationManager
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Component
import java.util.function.Supplier

@Component
class SecurityPreAuthorizeAuthorizationManager : AuthorizationManager<MethodInvocation> {

    private val manager = PreAuthorizeAuthorizationManager()

    override fun check(
        authentication: Supplier<Authentication>,
        o: MethodInvocation
    ): AuthorizationDecision? {
        val auth = authentication.get()
        // SUPER ADMIN 允许通行所有的
        if (auth.authorities.contains(SimpleGrantedAuthority("ROLE_SUPER_ADMIN"))){
            return AuthorizationDecision(true)
        }

        return manager.check(authentication, o)
    }

}