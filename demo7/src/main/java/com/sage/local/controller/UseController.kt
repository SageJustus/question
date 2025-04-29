package com.sage.local.controller

import com.sage.local.security.annotation.HasRole
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/user")
@RestController
class UseController {

    // not working
    @GetMapping("/v1/self")
    @HasRole("ROLE_ORDINARY")
    fun getSelf(): String {
        return "success!"
    }

    // working fine
    @GetMapping("/v2/self")
    @PreAuthorize("hasRole('ROLE_ORDINARY')")
    fun getSelf2(): String {
        return "success!"
    }

}