package com.gli.clic.Controller;

import com.gli.clic.dto.VirtualAccountRequest;
import com.gli.clic.dto.VirtualAccountResponse;
import com.gli.clic.security.JwtTokenProvider;
import com.gli.clic.service.VirtualAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/va")
@CrossOrigin(origins = "*", allowedHeaders = {"Authorization", "Content-Type"}) // Explicitly add Authorization
public class VirtualAccountController {

    @Autowired
    private VirtualAccountService virtualAccountService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/inquiry")
    public ResponseEntity<VirtualAccountResponse> createVAInquiry(
            @RequestHeader("Authorization") String token,
            @RequestBody VirtualAccountRequest request) {

        if (token == null || !token.startsWith("Bearer ")) {
            VirtualAccountResponse response = new VirtualAccountResponse();
            response.setResponseCode("401");
            response.setResponseMessage("Missing or invalid token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        String cleanToken = token.replace("Bearer ", "");
        if (!jwtTokenProvider.validateToken(cleanToken)) {
            VirtualAccountResponse response = new VirtualAccountResponse();
            response.setResponseCode("401");
            response.setResponseMessage("Invalid token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        String usrUid = jwtTokenProvider.extractEmail(cleanToken);

        System.out.println("Received request from user: " + usrUid + ", customerNo: " + request.getCustomerNo());

        if (request.getCustomerNo() == null || request.getVirtualAccountNo() == null) {
            VirtualAccountResponse response = new VirtualAccountResponse();
            response.setResponseCode("024");
            response.setResponseMessage("Missing required fields");
            return ResponseEntity.badRequest().body(response);
        }

        String virtualAccountNo = request.getVirtualAccountNo();
        String partnerServiceId = virtualAccountNo.substring(0, 4);

        String inquiryRequestId = request.getInquiryRequestId();

        VirtualAccountResponse response = virtualAccountService.createVirtualAccount(
                request.getCustomerNo(), partnerServiceId, virtualAccountNo, inquiryRequestId);

        System.out.println("Inquiry request ID: " + inquiryRequestId);

        return ResponseEntity.ok(response);
    }
}