package com.jaderbittencourt.springSecurityPOC.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SimpleController {

    @GetMapping("/index")
    @PreAuthorize("hasAuthority('PERMISSION_READ')")
    public String getIndex() {
        return "Hi :)";
    }

    @GetMapping("/multiple")
    @PreAuthorize("hasAnyAuthority('PERMISSION_HELLO', 'PERMISSION_SOMETHING')")
    public String getMultiple() {
        return "Hello :)";
    }

    @GetMapping("/secured")
    @PreAuthorize("hasAuthority('PERMISSION_SECURED')")
    public String getSecuredIndex() {
        return "You shouldn't see me :)";
    }
}
