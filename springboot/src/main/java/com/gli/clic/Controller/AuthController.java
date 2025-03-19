package com.gli.clic.Controller;

import com.gli.clic.dto.*;
import com.gli.clic.service.UserService;
import com.gli.clic.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody @Valid UserDTO userDTO) {
        System.out.println("Register request received: " + userDTO.getUsrUid() + ", " + userDTO.getUsrAccnId());
        RegisterResponse response = userService.registerUser(userDTO);
        System.out.println("Register response: " + response.getMessage());
        return buildApiResponse(response.getMessage(), response.isSuccess());
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody @Valid UserDTO userDTO) {
        String usrUid = userService.loginUser(userDTO);
        if (usrUid == null) {
            return buildApiResponse("Invalid credentials", false, HttpStatus.UNAUTHORIZED);
        }
        String token = jwtTokenProvider.createToken(usrUid);
        Map<String, Object> data = new HashMap<>();
        data.put("token", "Bearer " + token);
        String inquiryRequestId = UUID.randomUUID().toString();
        data.put("inquiryRequestId", inquiryRequestId);
        return buildApiResponse("Login successful", true, data);
    }

    @PutMapping("/update/email")
    public ResponseEntity<ApiResponse> updateEmail(@RequestHeader("Authorization") String token,
                                                    @RequestBody @Valid UpdateEmailDTO updateEmailDTO) {
        return processAuthenticatedRequest(token, email -> userService.updateEmail(email, updateEmailDTO));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteUser(@RequestHeader("Authorization") String token) {
        return processAuthenticatedRequest(token, userService::deleteUser);
    }

    private ResponseEntity<ApiResponse> processAuthenticatedRequest(String token, AuthAction action) {
        if (token == null || !token.startsWith("Bearer ")) {
            return buildApiResponse("Missing or invalid token", false, HttpStatus.UNAUTHORIZED);
        }

        String cleanToken = token.replace("Bearer ", "");
        if (!jwtTokenProvider.validateToken(cleanToken)) {
            return buildApiResponse("Invalid token", false, HttpStatus.UNAUTHORIZED);
        }

        String authenticatedEmail = jwtTokenProvider.extractEmail(cleanToken);
        return action.execute(authenticatedEmail);
    }

    private ResponseEntity<ApiResponse> buildApiResponse(String message, boolean status) {
        return ResponseEntity.ok(new ApiResponse(message, status));
    }

    private ResponseEntity<ApiResponse> buildApiResponse(String message, boolean status, HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus).body(new ApiResponse(message, status));
    }

    private ResponseEntity<ApiResponse> buildApiResponse(String message, boolean status, Map<String, Object> data) {
        return ResponseEntity.ok(new ApiResponse(message, status, data));
    }

    @FunctionalInterface
    interface AuthAction {
        ResponseEntity<ApiResponse> execute(String authenticatedEmail);
    }
}