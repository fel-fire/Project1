package com.felfire.project.processor;

import com.felfire.project.entity.Customer;
import com.felfire.project.repository.CustomerRepo;
import com.felfire.project.service.BankAccountService;
import com.felfire.project.service.LoggedUserManagementService;
import com.felfire.project.service.TransferHistorySaverService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Optional;

/**
 * Компонент, отвечающий за проверку соответствия введенного имени пользователя и пароля при входе в систему, их
 * сохранения в LoggedUserManagementService, а также при выходе пользователя из системы -
 * за их удаление из LoggedUserManagementService.
 */
@Component
@RequestScope
@RequiredArgsConstructor
public class LoginProcessor {
    private final BankAccountService bankAccountService;
    private final TransferHistorySaverService transferHistorySaverService;
    private final LoggedUserManagementService loggedUserManagementService;
    private final CustomerRepo customerRepo;

    @Value("manager")
    private String managerUsername;
    @Value("manager")
    private String managerPassword;
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String password;

    public boolean login() {
        boolean loggingResult = false;
        Optional<Customer> optional = customerRepo.findByUsername(username);
        if (optional.isEmpty()) return false;

        Customer customer = optional.get();
        if (customer.getPassword().equals(password)) {
            loggedUserManagementService.setUsername(customer.getUsername());
            loggedUserManagementService.setId(customer.getId());
            loggingResult = true;
        }
        return loggingResult;
    }

    public void logout() {
        loggedUserManagementService.setId(null);
        loggedUserManagementService.setUsername(null);
        resetValues();
    }

    public boolean isManager() {
        return username.equals(managerUsername)&&password.equals(managerPassword);
    }

    private void resetValues() {
        bankAccountService.reset();
        transferHistorySaverService.reset();
    }
}
