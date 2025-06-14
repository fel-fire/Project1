package com.felfire.project.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

/**
 * Компонент, отвечающий за хранение сведений о текущем пользователе.
 */
@Service
@SessionScope
@Getter @Setter
public class LoggedUserManagementService {
    private String username;
    private Integer id;

}
