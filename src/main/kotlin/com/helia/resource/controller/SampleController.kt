package com.helia.resource.controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController {
    @PreAuthorize("hasAuthority('read')")
    @GetMapping("/resource/read")
    fun read(@AuthenticationPrincipal jwt: Jwt): Map<String, Any> {
        return jwt.claims
    }

    @PreAuthorize("hasAuthority('write')")
    @GetMapping("/resource/write")
    fun write(@RequestParam name: String): String {
        return "success"
    }

    @GetMapping("/resource/test")
    fun test(@RequestParam name: String): String {
        return "success"
    }
}
