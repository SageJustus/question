package com.sage.local.security.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class TestFilter : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val context = SecurityContextHolder.createEmptyContext()
        val authentication  = UsernamePasswordAuthenticationToken.authenticated("username", "password", listOf(SimpleGrantedAuthority("ROLE_ORDINARY")) )
        context.authentication = authentication
        SecurityContextHolder.setContext(context)
        filterChain.doFilter(request, response)
    }
}