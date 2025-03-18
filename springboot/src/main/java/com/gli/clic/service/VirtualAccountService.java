package com.gli.clic.service;

import com.gli.clic.dto.VirtualAccountResponse;
import com.gli.clic.model.Account;
import com.gli.clic.model.CreationVA;
import com.gli.clic.repository.CoreAccnRepository;
import com.gli.clic.repository.CreationVARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VirtualAccountService {

    @Autowired
    private CoreAccnRepository coreAccnRepository;

    @Autowired
    private CreationVARepository creationVARepository;

    public VirtualAccountResponse createVirtualAccount(String customerNo, String partnerServiceId, String virtualAccountNo) {
        VirtualAccountResponse response = new VirtualAccountResponse();

        System.out.println("MASUK 1 " );
        // Fetch customer account details
        Account account = coreAccnRepository.findById(customerNo).orElse(null);
        if (account == null) {
            response.setResponseCode("124");
            response.setResponseMessage("Invalid Customer Account");
            return response;
        }

        System.out.println("MASUK 2 " );
        // Fetch virtual account details
        CreationVA creationVA = creationVARepository.findByVirtualNumber(virtualAccountNo);
        if (creationVA == null) {
            response.setResponseCode("124");
            response.setResponseMessage("Invalid Virtual Account");
            return response;
        }

        System.out.println("MASUK 3 " );
        // Get response
        VirtualAccountResponse.VirtualAccountData virtualAccountData = new VirtualAccountResponse.VirtualAccountData();
        virtualAccountData.setPartnerServiceId(partnerServiceId);
        virtualAccountData.setCustomerNo(customerNo);
        virtualAccountData.setVirtualAccountNo(virtualAccountNo);
        virtualAccountData.setVirtualAccountName(creationVA.getVirtualName() != null ? creationVA.getVirtualName() : account.getAccnName());
        virtualAccountData.setVirtualAccountEmail(creationVA.getVirtualEmail() != null ? creationVA.getVirtualEmail() : account.getAccnEmail());
        virtualAccountData.setVirtualAccountPhone(creationVA.getVirtualPhone() != null ? creationVA.getVirtualPhone().toString() : account.getAccnTel().toString());

        System.out.println("MASUK 4 " );
        response.setVirtualAccountData(virtualAccountData);
        response.setResponseCode("2002400");
        response.setResponseMessage("Successful");

        return response;
    }
}