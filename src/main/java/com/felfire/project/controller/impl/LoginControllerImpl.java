package com.felfire.project.controller.impl;

import com.felfire.project.controller.LoginController;
import com.felfire.project.processor.LoginProcessor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@AllArgsConstructor
public class LoginControllerImpl implements LoginController {
    private final LoginProcessor loginProcessor;

    @Override
    public ResponseEntity<String> loginPost(String username, String password) {
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        if (loginProcessor.isManager())
            return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("/managerservice.html"))
                .build();


        if (loginProcessor.login())
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create("/startpage.html"))
                    .build();

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("/index.html"))
                .body("Authentification failed");
    }

    @Override
    public ResponseEntity<Void> logout() {
        loginProcessor.logout();
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("/index.html"))
                .build();
    }
}
