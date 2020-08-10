package com.keycloak.keyCloak.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@JsonSerialize
public class IndexController {

    private final HttpServletRequest request;

    public IndexController(HttpServletRequest request) {
        this.request = request;
    }

    @GetMapping("/")
    public KeycloakSecurityContext index() {
        return
                getKeycloakSecurityContext();
    }

    /**
     * The KeycloakSecurityContext provides access to several pieces of information
     * contained in the security token, such as user profile information.
     */
    private KeycloakSecurityContext getKeycloakSecurityContext() {
        return (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
    }

}
