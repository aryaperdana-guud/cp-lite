package com.gli.clic.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_CORE_ACCN") 
public class Account {
	@Id
    @Column(name = "ACCN_ID", unique = true, nullable = false)
    private String accnId;

    @Column(name = "ACCN_STATUS", nullable = false)
    private char accnStatus;

    @Column(name = "ACCN_NAME", nullable = false)
    private String accnName;

    @Column(name = "ACCN_NAME_OTH")
    private String accnNameOth;

    @Column(name = "ACCN_TYPE", nullable = false)
    private String accnType;

    @Column(name = "ACCN_COY_REGN", nullable = false)
    private Long accnCoyRegn;

    @Column(name = "ACCN_PASS_NID")
    private String accnPassNid;

    @Column(name = "ACCN_NATIONALITY")
    private String accnNationality;

    @Column(name = "ACCN_VAT_FLAG")
    private String accnVatFlag;

    @Column(name = "ACCN_VAT_NO")
    private String accnVatNo;

    @Column(name = "ACCN_ADDR1")
    private String accnAddr1;

    @Column(name = "ACCN_ADDR2")
    private String accnAddr2;

    @Column(name = "ACCN_ADDR3")
    private String accnAddr3;

    @Column(name = "ACCN_PCODE")
    private Long accnPcode;

    @Column(name = "ACCN_CITY")
    private String accnCity;

    @Column(name = "ACCN_PROV")
    private String accnProv;

    @Column(name = "ACCN_CTYCODE", length = 2)
    private String accnCtyCode;

    @Column(name = "ACCN_TEL")
    private String accnTel;

    @Column(name = "ACCN_FAX")
    private String accnFax;

    @Column(name = "ACCN_EMAIL")
    private String accnEmail;

    @Column(name = "ACCN_LOCALE_CD")
    private String accnLocaleCd;

    @Column(name = "ACCN_DT_AGREE")
    private Date accnDtAgree;

    @Column(name = "ACCN_DT_REG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date accnDtReg;

    @Column(name = "ACCN_DT_DEREG")
    private Date accnDtDereg;

    @Column(name = "ACCN_DT_REREG")
    private Date accnDtRereg;

    @Column(name = "ACCN_DT_REINS")
    private Date accnDtReins;

    @Column(name = "ACCN_DT_CREATE")
    private Date accnDtCreate;

    @Column(name = "ACCN_UID_CREATE")
    private String accnUidCreate;

    @Column(name = "ACCN_DT_LUPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date accnDtLupd;

    @Column(name = "ACCN_UID_LUPD")
    private String accnUidLupd;

    @Column(name = "ACCN_OWNER_NAME")
    private String accnOwnerName;

    @Column(name = "ACCN_BUSS_ACT")
    private String accnBussAct;

    @Column(name = "ACCN_OWN_NATIONALITY")
    private String accnOwnNationality;

    @Column(name = "ACCN_CITY_CODE")
    private Long accnCityCode;

    @PrePersist
    protected void onCreate() {
        Date now = new Date();
        if (accnDtLupd == null) {
        	accnDtLupd = now;
        }
        if (accnDtReg == null) {
        	accnDtReg = now;
        }
    }

	
    public String getAccnId() {
		return accnId;
	}

	public void setAccnId(String accnId) {
		this.accnId = accnId;
	}

	public char getAccnStatus() {
		return accnStatus;
	}

	public void setAccnStatus(char accnStatus) {
		this.accnStatus = accnStatus;
	}

	public String getAccnName() {
		return accnName;
	}

	public void setAccnName(String accnName) {
		this.accnName = accnName;
	}

	public String getAccnNameOth() {
		return accnNameOth;
	}

	public void setAccnNameOth(String accnNameOth) {
		this.accnNameOth = accnNameOth;
	}

	public String getAccnType() {
		return accnType;
	}

	public void setAccnType(String accnType) {
		this.accnType = accnType;
	}

	public Long getAccnCoyRegn() {
		return accnCoyRegn;
	}

	public void setAccnCoyRegn(Long accnCoyRegn) {
		this.accnCoyRegn = accnCoyRegn;
	}

	public String getAccnPassNid() {
		return accnPassNid;
	}

	public void setAccnPassNid(String accnPassNid) {
		this.accnPassNid = accnPassNid;
	}

	public String getAccnNationality() {
		return accnNationality;
	}

	public void setAccnNationality(String accnNationality) {
		this.accnNationality = accnNationality;
	}

	public String getAccnVatFlag() {
		return accnVatFlag;
	}

	public void setAccnVatFlag(String accnVatFlag) {
		this.accnVatFlag = accnVatFlag;
	}

	public String getAccnVatNo() {
		return accnVatNo;
	}

	public void setAccnVatNo(String accnVatNo) {
		this.accnVatNo = accnVatNo;
	}

	public String getAccnAddr1() {
		return accnAddr1;
	}

	public void setAccnAddr1(String accnAddr1) {
		this.accnAddr1 = accnAddr1;
	}

	public String getAccnAddr2() {
		return accnAddr2;
	}

	public void setAccnAddr2(String accnAddr2) {
		this.accnAddr2 = accnAddr2;
	}

	public String getAccnAddr3() {
		return accnAddr3;
	}

	public void setAccnAddr3(String accnAddr3) {
		this.accnAddr3 = accnAddr3;
	}

	public Long getAccnPcode() {
		return accnPcode;
	}

	public void setAccnPcode(Long accnPcode) {
		this.accnPcode = accnPcode;
	}

	public String getAccnCity() {
		return accnCity;
	}

	public void setAccnCity(String accnCity) {
		this.accnCity = accnCity;
	}

	public String getAccnProv() {
		return accnProv;
	}

	public void setAccnProv(String accnProv) {
		this.accnProv = accnProv;
	}

	public String getAccnCtyCode() {
		return accnCtyCode;
	}

	public void setAccnCtyCode(String accnCtyCode) {
		this.accnCtyCode = accnCtyCode;
	}

	public String getAccnTel() {
		return accnTel;
	}

	public void setAccnTel(String accnTel) {
		this.accnTel = accnTel;
	}

	public String getAccnFax() {
		return accnFax;
	}

	public void setAccnFax(String accnFax) {
		this.accnFax = accnFax;
	}

	public String getAccnEmail() {
		return accnEmail;
	}

	public void setAccnEmail(String accnEmail) {
		this.accnEmail = accnEmail;
	}

	public String getAccnLocaleCd() {
		return accnLocaleCd;
	}

	public void setAccnLocaleCd(String accnLocaleCd) {
		this.accnLocaleCd = accnLocaleCd;
	}

	public Date getAccnDtAgree() {
		return accnDtAgree;
	}

	public void setAccnDtAgree(Date accnDtAgree) {
		this.accnDtAgree = accnDtAgree;
	}

	public Date getAccnDtReg() {
		return accnDtReg;
	}

	public void setAccnDtReg(Date accnDtReg) {
		this.accnDtReg = accnDtReg;
	}

	public Date getAccnDtDereg() {
		return accnDtDereg;
	}

	public void setAccnDtDereg(Date accnDtDereg) {
		this.accnDtDereg = accnDtDereg;
	}

	public Date getAccnDtRereg() {
		return accnDtRereg;
	}

	public void setAccnDtRereg(Date accnDtRereg) {
		this.accnDtRereg = accnDtRereg;
	}

	public Date getAccnDtReins() {
		return accnDtReins;
	}

	public void setAccnDtReins(Date accnDtReins) {
		this.accnDtReins = accnDtReins;
	}

	public Date getAccnDtCreate() {
		return accnDtCreate;
	}

	public void setAccnDtCreate(Date accnDtCreate) {
		this.accnDtCreate = accnDtCreate;
	}

	public String getAccnUidCreate() {
		return accnUidCreate;
	}

	public void setAccnUidCreate(String accnUidCreate) {
		this.accnUidCreate = accnUidCreate;
	}

	public Date getAccnDtLupd() {
		return accnDtLupd;
	}

	public void setAccnDtLupd(Date accnDtLupd) {
		this.accnDtLupd = accnDtLupd;
	}

	public String getAccnUidLupd() {
		return accnUidLupd;
	}

	public void setAccnUidLupd(String accnUidLupd) {
		this.accnUidLupd = accnUidLupd;
	}

	public String getAccnOwnerName() {
		return accnOwnerName;
	}

	public void setAccnOwnerName(String accnOwnerName) {
		this.accnOwnerName = accnOwnerName;
	}

	public String getAccnBussAct() {
		return accnBussAct;
	}

	public void setAccnBussAct(String accnBussAct) {
		this.accnBussAct = accnBussAct;
	}

	public String getAccnOwnNationality() {
		return accnOwnNationality;
	}

	public void setAccnOwnNationality(String accnOwnNationality) {
		this.accnOwnNationality = accnOwnNationality;
	}

	public Long getAccnCityCode() {
		return accnCityCode;
	}

	public void setAccnCityCode(Long accnCityCode) {
		this.accnCityCode = accnCityCode;
	}

}
