package com.synergisticit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.synergisticit.domain.UserDtls;
import com.synergisticit.service.UserService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping
    public UserDtls createUser(@RequestBody UserDtls user) {
        return userService.saveUser(user);
    }

    @GetMapping("/email/{email}")
    public UserDtls getUserByEmail(@PathVariable String email) {
        UserDtls user = userService.getUserByEmail(email);
        return user;
    }

    @GetMapping("/role/{role}")
    public List<UserDtls> getUsersByRole(@PathVariable String role) {
        return userService.getUsers(role);
    }

    @PutMapping("/account-status/{id}/{status}")
    public Boolean updateAccountStatus(@PathVariable Integer id, @PathVariable Boolean status) {
        return userService.updateAccountStatus(id, status);
    }

    @PostMapping("/increase-attempts")
    public void increaseFailedAttempt(@RequestBody UserDtls user) {
        userService.increaseFailedAttempt(user);
    }

    @PostMapping("/lock-account")
    public void lockAccount(@RequestBody UserDtls user) {
        userService.userAccountLock(user);
    }

    @PostMapping("/unlock-account")
    public Boolean unlockAccount(@RequestBody UserDtls user) {
        return userService.unlockAccountTimeExpired(user);
    }

    @PutMapping("/reset-attempts/{userId}")
    public void resetAttempt(@PathVariable int userId) {
        userService.resetAttempt(userId);
    }

    @PutMapping("/reset-token")
    public void updateUserResetToken(@RequestParam String email, @RequestParam String resetToken) {
        userService.updateUserResetToken(email, resetToken);
    }

    @GetMapping("/token/{token}")
    public UserDtls getUserByToken(@PathVariable String token) {
        return userService.getUserByToken(token);
    }

    @PutMapping
    public UserDtls updateUser(@RequestBody UserDtls user) {
        return userService.updateUser(user);
    }

    @PutMapping("/profile")
    public UserDtls updateUserProfile(@RequestParam MultipartFile img, @RequestPart UserDtls user) {
        return userService.updateUserProfile(user, img);
    }

    @PostMapping("/admin")
    public UserDtls saveAdmin(@RequestBody UserDtls user) {
        return userService.saveAdmin(user);
    }

    @GetMapping("/exists/email/{email}")
    public Boolean existsEmail(@PathVariable String email) {
        return userService.existsEmail(email);
    }
}
