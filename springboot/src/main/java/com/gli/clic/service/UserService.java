package com.gli.clic.service;

import com.gli.clic.dto.*;
import com.gli.clic.model.User;
import com.gli.clic.repository.UserRepository;
import com.gli.clic.security.JwtTokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public RegisterResponse registerUser(UserDTO userDTO) {
        if (userRepository.existsById(userDTO.getUsrUid())) {
            return new RegisterResponse("User already exists", false);
        }

        User user = new User();
        user.setUsrUid(userDTO.getUsrUid());
        user.setUsrAccnId(userDTO.getUsrAccnId()); 
        user.setUsrPassword(md5(userDTO.getUsrUid() + userDTO.getUsrPassword())); 
        userRepository.save(user);

        return new RegisterResponse("User registered successfully", true);
    }


    public String loginUser(UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(userDTO.getUsrUid());
        if (optionalUser.isEmpty()) {
            return null; 
        }

        User user = optionalUser.get();
        String hashedPassword = md5(userDTO.getUsrUid() + userDTO.getUsrPassword());
        if (!hashedPassword.equals(user.getUsrPassword())) {
            return null; 
        }

        return user.getUsrUid(); 
    }

    // Update user email
    public ResponseEntity<ApiResponse> updateEmail(String usrUid, UpdateEmailDTO updateEmailDTO) {
        Optional<User> optionalUser = userRepository.findById(usrUid);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse("User not found", false));
        }

        User user = optionalUser.get();
        user.setUsrEmail(updateEmailDTO.getEmail());
        userRepository.save(user);
        return ResponseEntity.ok(new ApiResponse("Email updated successfully", true));
    }

    // Delete user
    public ResponseEntity<ApiResponse> deleteUser(String usrUid) {
        Optional<User> optionalUser = userRepository.findById(usrUid);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse("User not found", false));
        }

        userRepository.delete(optionalUser.get());
        return ResponseEntity.ok(new ApiResponse("User deleted successfully", true));
    }

    // Helper method to generate MD5 hash
    private String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}