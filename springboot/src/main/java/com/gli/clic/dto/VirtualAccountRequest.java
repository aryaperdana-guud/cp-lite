package com.gli.clic.dto;
import jakarta.validation.constraints.Pattern;

public class VirtualAccountRequest {
	private String partnerServiceId;
    
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String customerNo;
    
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String virtualAccountNo;
    
	private String trxDateInit;
    
	private int channelCode;
    
	private String language;
    
	private String hashedSourceAccountNo;
    
	private String sourceBankCode;
    
	private String inquiryRequestId;

	
    public String getPartnerServiceId() {
		return partnerServiceId;
	}
	public void setPartnerServiceId(String partnerServiceId) {
		this.partnerServiceId = partnerServiceId;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getVirtualAccountNo() {
		return virtualAccountNo;
	}
	public void setVirtualAccountNo(String virtualAccountNo) {
		this.virtualAccountNo = virtualAccountNo;
	}
	public String getTrxDateInit() {
		return trxDateInit;
	}
	public void setTrxDateInit(String trxDateInit) {
		this.trxDateInit = trxDateInit;
	}
	public int getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(int channelCode) {
		this.channelCode = channelCode;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getHashedSourceAccountNo() {
		return hashedSourceAccountNo;
	}
	public void setHashedSourceAccountNo(String hashedSourceAccountNo) {
		this.hashedSourceAccountNo = hashedSourceAccountNo;
	}
	public String getSourceBankCode() {
		return sourceBankCode;
	}
	public void setSourceBankCode(String sourceBankCode) {
		this.sourceBankCode = sourceBankCode;
	}
	public String getInquiryRequestId() {
		return inquiryRequestId;
	}
	public void setInquiryRequestId(String inquiryRequestId) {
		this.inquiryRequestId = inquiryRequestId;
	}
}
