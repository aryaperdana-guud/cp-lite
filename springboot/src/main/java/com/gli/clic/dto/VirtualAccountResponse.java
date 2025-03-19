package com.gli.clic.dto;

import java.util.List;

public class VirtualAccountResponse {
	private VirtualAccountData virtualAccountData;
	/* private AdditionalInfo additionalInfo; */
    private String responseCode;
    private String responseMessage;
	
    public VirtualAccountData getVirtualAccountData() {
		return virtualAccountData;
	}

	public void setVirtualAccountData(VirtualAccountData virtualAccountData) {
		this.virtualAccountData = virtualAccountData;
	}

	/*
	 * public AdditionalInfo getAdditionalInfo() { return additionalInfo; }
	 * 
	 * public void setAdditionalInfo(AdditionalInfo additionalInfo) {
	 * this.additionalInfo = additionalInfo; }
	 */

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public static class VirtualAccountData {
		private String partnerServiceId;
	     private String customerNo;
	     private String virtualAccountNo;
	     private String virtualAccountName;
	     private String virtualAccountEmail;
	     private String virtualAccountPhone;
	     private String inquiryRequestId;
	     private TotalAmount totalAmount;
	     private String virtualAccountTrxType;
	     private FeeAmount feeAmount;    	
		
		
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
		public String getVirtualAccountName() {
			return virtualAccountName;
		}
		public void setVirtualAccountName(String virtualAccountName) {
			this.virtualAccountName = virtualAccountName;
		}
		public String getVirtualAccountEmail() {
			return virtualAccountEmail;
		}
		public void setVirtualAccountEmail(String virtualAccountEmail) {
			this.virtualAccountEmail = virtualAccountEmail;
		}
		public String getVirtualAccountPhone() {
			return virtualAccountPhone;
		}
		public void setVirtualAccountPhone(String virtualAccountPhone) {
			this.virtualAccountPhone = virtualAccountPhone;
		}
		public String getInquiryRequestId() {
			return inquiryRequestId;
		}
		public void setInquiryRequestId(String inquiryRequestId) {
			this.inquiryRequestId = inquiryRequestId;
		}
		public TotalAmount getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(TotalAmount totalAmount) {
			this.totalAmount = totalAmount;
		}
		public String getVirtualAccountTrxType() {
			return virtualAccountTrxType;
		}
		public void setVirtualAccountTrxType(String virtualAccountTrxType) {
			this.virtualAccountTrxType = virtualAccountTrxType;
		}
		public FeeAmount getFeeAmount() {
			return feeAmount;
		}
		public void setFeeAmount(FeeAmount feeAmount) {
			this.feeAmount = feeAmount;
		}    	
    }

    public static class TotalAmount {
		private Long value;
        private String currency;
        public Long getValue() {
			return value;
		}
		public void setValue(Long value) {
			this.value = value;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
    }

    public static class BillDetails {
		private String billCode;
        private String billNo;
        private String billName;
        private String billShortName;
        private TotalAmount billAmount;

    	
        public String getBillCode() {
			return billCode;
		}
		public void setBillCode(String billCode) {
			this.billCode = billCode;
		}
		public String getBillNo() {
			return billNo;
		}
		public void setBillNo(String billNo) {
			this.billNo = billNo;
		}
		public String getBillName() {
			return billName;
		}
		public void setBillName(String billName) {
			this.billName = billName;
		}
		public String getBillShortName() {
			return billShortName;
		}
		public void setBillShortName(String billShortName) {
			this.billShortName = billShortName;
		}		
		public TotalAmount getBillAmount() {
			return billAmount;
		}
		public void setBillAmount(TotalAmount billAmount) {
			this.billAmount = billAmount;
		}
    }

//    public static class BillDescription {
//		private String english;
//        private String indonesia;
//
//        
//        public String getEnglish() {
//			return english;
//		}
//		public void setEnglish(String english) {
//			this.english = english;
//		}
//		public String getIndonesia() {
//			return indonesia;
//		}
//		public void setIndonesia(String indonesia) {
//			this.indonesia = indonesia;
//		}
//    }

    public static class FeeAmount {
		private Long value;
        private String currency;

        
        public Long getValue() {
			return value;
		}
		public void setValue(Long value) {
			this.value = value;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
    }

	/*
	 * public static class AdditionalInfo { private String billType;
	 * 
	 * public String getBillType() { return billType; }
	 * 
	 * public void setBillType(String billType) { this.billType = billType; }
	 * 
	 * }
	 */
}
