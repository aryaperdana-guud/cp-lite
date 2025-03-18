package com.gli.clic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gli.clic.dto.VirtualAccountResponse;
import com.gli.clic.dto.VirtualAccountRequest;
import com.gli.clic.service.VirtualAccountService;

@RestController
@RequestMapping("/va")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VirtualAccountController {

    @Autowired
    private VirtualAccountService virtualAccountService;

    @PostMapping("/inquiry")
    public VirtualAccountResponse createVAInquiry(@RequestBody VirtualAccountRequest request) {
        System.out.println("Received request: " + request.getCustomerNo());

        // Check for missing fields
        if (request.getCustomerNo() == null || request.getVirtualAccountNo() == null) {
            VirtualAccountResponse response = new VirtualAccountResponse();
            response.setResponseCode("024");
            response.setResponseMessage("Missing required fields");
            return response;
        }

        // Extract partnerServiceId from virtualAccountNo (first 4 digits)
        String virtualAccountNo = request.getVirtualAccountNo();
        String partnerServiceId = virtualAccountNo.substring(0, 4);

        return virtualAccountService.createVirtualAccount(request.getCustomerNo(), partnerServiceId, virtualAccountNo);
    }
}