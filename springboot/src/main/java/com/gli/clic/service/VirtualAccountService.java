package com.gli.clic.service;

import com.gli.clic.dto.VirtualAccountResponse;
import com.gli.clic.model.Account;
import com.gli.clic.model.AssignmentVA;
import com.gli.clic.model.CreationVA;
import com.gli.clic.repository.AssignmentVARepository;
import com.gli.clic.repository.CoreAccnRepository;
import com.gli.clic.repository.CreationVARepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VirtualAccountService {

    @Autowired
    private CoreAccnRepository coreAccnRepository;

    @Autowired
    private CreationVARepository creationVARepository;

    @Autowired
    private AssignmentVARepository assignmentVARepository;

    public VirtualAccountResponse createVirtualAccount(String customerNo, String partnerServiceId, String virtualAccountNo) {
        VirtualAccountResponse response = new VirtualAccountResponse();

        System.out.println("MASUK 1");
        Account account = coreAccnRepository.findById(customerNo).orElse(null);
        if (account == null) {
            response.setResponseCode("124");
            response.setResponseMessage("Invalid Customer Account");
            return response;
        }
        System.out.println("Customer Account: " + account);

        System.out.println("MASUK 2");
        CreationVA creationVA = creationVARepository.findByVirtualNumber(virtualAccountNo);
        if (creationVA == null) {
            response.setResponseCode("124");
            response.setResponseMessage("Invalid Virtual Account");
            return response;
        }
        System.out.println("Creation VA: " + creationVA);

        System.out.println("MASUK 3");
        List<AssignmentVA> assignmentVAs = assignmentVARepository.findByAsgnVirtualNumber(creationVA.getId().toString());
        if (assignmentVAs == null || assignmentVAs.isEmpty()) {
            System.out.println("Assignment VA not found for CRT_ID: " + creationVA.getId());
            response.setResponseCode("125");
            response.setResponseMessage("No Assignment Data Found");
            return response;
        }
        AssignmentVA assignmentVA = assignmentVAs.get(0);//take the first result.
        System.out.println("Assignment VA: " + assignmentVA);

        
        System.out.println("MASUK 4");
        VirtualAccountResponse.VirtualAccountData virtualAccountData = new VirtualAccountResponse.VirtualAccountData();
        virtualAccountData.setPartnerServiceId(partnerServiceId);
        virtualAccountData.setCustomerNo(customerNo);
        virtualAccountData.setVirtualAccountNo(creationVA.getVirtualNumber());//get the virtual number from the creation table.
        virtualAccountData.setVirtualAccountName(creationVA.getVirtualName() != null ? creationVA.getVirtualName() : account.getAccnName());
        virtualAccountData.setVirtualAccountEmail(creationVA.getVirtualEmail() != null ? creationVA.getVirtualEmail() : account.getAccnEmail());
        virtualAccountData.setVirtualAccountPhone(creationVA.getVirtualPhone() != null ? creationVA.getVirtualPhone() : account.getAccnTel());

        VirtualAccountResponse.TotalAmount totalAmount = new VirtualAccountResponse.TotalAmount();
        totalAmount.setValue(assignmentVA.getAsgnVirtualAmount());
        totalAmount.setCurrency("IDR");
        virtualAccountData.setTotalAmount(totalAmount);

        VirtualAccountResponse.FeeAmount feeAmount = new VirtualAccountResponse.FeeAmount();
        feeAmount.setValue(assignmentVA.getAsgnVirtualAmount());
        feeAmount.setCurrency("IDR");
        virtualAccountData.setFeeAmount(feeAmount);

        response.setVirtualAccountData(virtualAccountData);
        response.setResponseCode("2002400");
        response.setResponseMessage("Successful");

        return response;
    }
}