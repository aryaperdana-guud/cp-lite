package com.gli.clic.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_CORE_USR")
public class User {

	@Id
    @Column(name = "USR_UID", unique = true, nullable = false)
    private String usrUid;

    @Column(name = "USR_ACCNID", nullable = false)
    private String usrAccnId;

    @Column(name = "USR_STATUS")
    private char usrStatus;

    @Column(name = "USR_TYPE_ONLINE")
    private char usrTypeOnline;

    @Column(name = "USR_TYPE_MBOX")
    private char usrTypeMbox;

    @Column(name = "USR_NAME")
    private String usrName;

    @Column(name = "USR_PASS_NID")
    private String usrPassNid;
    
    @Column(name = "USR_TITLE")
    private String usrTitle;

    @Column(name = "USR_DEPT")
    private String usrDept;

    @Column(name = "USR_DT_REG",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrDtReg;

    @Column(name = "USR_DT_COMM", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrDtComm;
    
    @Column(name = "USR_DT_PWD_LUPD", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrDtPwdLupd;
    
    @PrePersist
    protected void onCreate() {
        Date now = new Date();
        if (usrDtReg == null) {
            usrDtReg = now;
        }
        if (usrDtComm == null) {
            usrDtComm = now;
        }
        if(usrDtPwdLupd == null) {
        	usrDtPwdLupd = now;
    	}
    }

    @Column(name = "USR_DT_DEREG")
    private Date usrDtDereg;

    @Column(name = "USR_DT_REREG")
    private Date usrDtRereg;

    @Column(name = "USR_CLASS")
    private String usrClass;

    @Column(name = "USR_ADDR1")
    private String usrAddress1;

    @Column(name = "USR_ADDR2")
    private String usrAddress2;

    @Column(name = "USR_ADDR3")
    private String usrAddress3;

    @Column(name = "USR_PCODE")
    private Integer usrPCode;

    @Column(name = "USR_CITY")
    private String usrCity;

    @Column(name = "USR_PROV")
    private String usrProv;

    @Column(name = "USR_CTYCODE", length = 2)
    private String usrCityCode;

    @Column(name = "USR_TEL")
    private Integer usrTelephone;

    @Column(name = "USR_FAX")
    private Integer usrFax;

    @Column(name = "USR_EMAIL")
    private String usrEmail;

    @Column(name = "USR_PWD")
    private String usrPassword;

    @Column(name = "USR_PWD_1")
    private String usrPassword1;

    @Column(name = "USR_PWD_2")
    private String usrPassword2;

    @Column(name = "USR_PWD_3")
    private String usrPassword3;

    @Column(name = "USR_PWD_4")
    private String usrPassword4;

    @Column(name = "USR_PWD_VALIDTY")
    private Integer usrPwdValidty;

    @Column(name = "USR_PWD_FORCE")
    private char usrPwdForce;

    @Column(name = "USR_LOGIN_INVCNT", nullable = false)
    private Integer usrLoginInvCnt = 0;

    @Column(name = "USR_DT_LOGINOK")
    private Date usrDtLoginOk;

    @Column(name = "USR_DT_LOGINERR")
    private Date usrDtLoginErr;

    @Column(name = "USR_MBOX_ID", nullable = false)
    private String usrMboxId = "Default";

    @Column(name = "USR_MBOX_MAXCNT")
    private Integer usrMboxMaxCnt;

    @Column(name = "USR_MBOX_MAXSIZ")
    private Integer usrMboxMaxSiz;

    @Column(name = "USR_DUR_INBX")
    private Integer usrDurInbx;

    @Column(name = "USR_DUR_ARCH")
    private Integer usrDurArch;

    @Column(name = "USR_DT_CREATE")
    private Date usrDtCreate;

    @Column(name = "USR_UID_CREATE")
    private String usrUidCreate;

    @Column(name = "USR_DT_LUPD")
    private Date usrDtLupd;

    @Column(name = "USR_UID_LUPD")
    private String usrUidLupd;
    
    
	
    public String getUsrUid() {
		return usrUid;
	}

	public void setUsrUid(String usrUid) {
		this.usrUid = usrUid;
	}

	public String getUsrAccnId() {
		return usrAccnId;
	}

	public void setUsrAccnId(String usrAccnId) {
		this.usrAccnId = usrAccnId;
	}

	public char getUsrStatus() {
		return usrStatus;
	}

	public void setUsrStatus(char usrStatus) {
		this.usrStatus = usrStatus;
	}

	public char getUsrTypeOnline() {
		return usrTypeOnline;
	}

	public void setUsrTypeOnline(char usrTypeOnline) {
		this.usrTypeOnline = usrTypeOnline;
	}

	public char getUsrTypeMbox() {
		return usrTypeMbox;
	}

	public void setUsrTypeMbox(char usrTypeMbox) {
		this.usrTypeMbox = usrTypeMbox;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getUsrPassNid() {
		return usrPassNid;
	}

	public void setUsrPassNid(String usrPassNid) {
		this.usrPassNid = usrPassNid;
	}

	public String getUsrTitle() {
		return usrTitle;
	}

	public void setUsrTitle(String usrTitle) {
		this.usrTitle = usrTitle;
	}

	public String getUsrDept() {
		return usrDept;
	}

	public void setUsrDept(String usrDept) {
		this.usrDept = usrDept;
	}

	public Date getUsrDtReg() {
		return usrDtReg;
	}

	public void setUsrDtReg(Date usrDtReg) {
		this.usrDtReg = usrDtReg;
	}

	public Date getUsrDtComm() {
		return usrDtComm;
	}

	public void setUsrDtComm(Date usrDtComm) {
		this.usrDtComm = usrDtComm;
	}

	public Date getUsrDtDereg() {
		return usrDtDereg;
	}

	public void setUsrDtDereg(Date usrDtDereg) {
		this.usrDtDereg = usrDtDereg;
	}

	public Date getUsrDtRereg() {
		return usrDtRereg;
	}

	public void setUsrDtRereg(Date usrDtRereg) {
		this.usrDtRereg = usrDtRereg;
	}

	public String getUsrClass() {
		return usrClass;
	}

	public void setUsrClass(String usrClass) {
		this.usrClass = usrClass;
	}

	public String getUsrAddress1() {
		return usrAddress1;
	}

	public void setUsrAddress1(String usrAddress1) {
		this.usrAddress1 = usrAddress1;
	}

	public String getUsrAddress2() {
		return usrAddress2;
	}

	public void setUsrAddress2(String usrAddress2) {
		this.usrAddress2 = usrAddress2;
	}

	public String getUsrAddress3() {
		return usrAddress3;
	}

	public void setUsrAddress3(String usrAddress3) {
		this.usrAddress3 = usrAddress3;
	}

	public Integer getUsrPCode() {
		return usrPCode;
	}

	public void setUsrPCode(Integer usrPCode) {
		this.usrPCode = usrPCode;
	}

	public String getUsrCity() {
		return usrCity;
	}

	public void setUsrCity(String usrCity) {
		this.usrCity = usrCity;
	}

	public String getUsrProv() {
		return usrProv;
	}

	public void setUsrProv(String usrProv) {
		this.usrProv = usrProv;
	}

	public String getUsrCityCode() {
		return usrCityCode;
	}

	public void setUsrCityCode(String usrCityCode) {
		this.usrCityCode = usrCityCode;
	}

	public Integer getUsrTelephone() {
		return usrTelephone;
	}

	public void setUsrTelephone(Integer usrTelephone) {
		this.usrTelephone = usrTelephone;
	}

	public Integer getUsrFax() {
		return usrFax;
	}

	public void setUsrFax(Integer usrFax) {
		this.usrFax = usrFax;
	}

	public String getUsrEmail() {
		return usrEmail;
	}

	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
	}

	public String getUsrPassword() {
		return usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	public String getUsrPassword1() {
		return usrPassword1;
	}

	public void setUsrPassword1(String usrPassword1) {
		this.usrPassword1 = usrPassword1;
	}

	public String getUsrPassword2() {
		return usrPassword2;
	}

	public void setUsrPassword2(String usrPassword2) {
		this.usrPassword2 = usrPassword2;
	}

	public String getUsrPassword3() {
		return usrPassword3;
	}

	public void setUsrPassword3(String usrPassword3) {
		this.usrPassword3 = usrPassword3;
	}

	public String getUsrPassword4() {
		return usrPassword4;
	}

	public void setUsrPassword4(String usrPassword4) {
		this.usrPassword4 = usrPassword4;
	}

	public Date getUsrDtPwdLupd() {
		return usrDtPwdLupd;
	}

	public void setUsrDtPwdLupd(Date usrDtPwdLupd) {
		this.usrDtPwdLupd = usrDtPwdLupd;
	}

	public Integer getUsrPwdValidty() {
		return usrPwdValidty;
	}

	public void setUsrPwdValidty(Integer usrPwdValidty) {
		this.usrPwdValidty = usrPwdValidty;
	}

	public char getUsrPwdForce() {
		return usrPwdForce;
	}

	public void setUsrPwdForce(char usrPwdForce) {
		this.usrPwdForce = usrPwdForce;
	}

	public Integer getUsrLoginInvCnt() {
		return usrLoginInvCnt;
	}

	public void setUsrLoginInvCnt(Integer usrLoginInvCnt) {
		this.usrLoginInvCnt = usrLoginInvCnt;
	}

	public Date getUsrDtLoginOk() {
		return usrDtLoginOk;
	}

	public void setUsrDtLoginOk(Date usrDtLoginOk) {
		this.usrDtLoginOk = usrDtLoginOk;
	}

	public Date getUsrDtLoginErr() {
		return usrDtLoginErr;
	}

	public void setUsrDtLoginErr(Date usrDtLoginErr) {
		this.usrDtLoginErr = usrDtLoginErr;
	}

	public String getUsrMboxId() {
		return usrMboxId;
	}

	public void setUsrMboxId(String usrMboxId) {
		this.usrMboxId = usrMboxId;
	}

	public Integer getUsrMboxMaxCnt() {
		return usrMboxMaxCnt;
	}

	public void setUsrMboxMaxCnt(Integer usrMboxMaxCnt) {
		this.usrMboxMaxCnt = usrMboxMaxCnt;
	}

	public Integer getUsrMboxMaxSiz() {
		return usrMboxMaxSiz;
	}

	public void setUsrMboxMaxSiz(Integer usrMboxMaxSiz) {
		this.usrMboxMaxSiz = usrMboxMaxSiz;
	}

	public Integer getUsrDurInbx() {
		return usrDurInbx;
	}

	public void setUsrDurInbx(Integer usrDurInbx) {
		this.usrDurInbx = usrDurInbx;
	}

	public Integer getUsrDurArch() {
		return usrDurArch;
	}

	public void setUsrDurArch(Integer usrDurArch) {
		this.usrDurArch = usrDurArch;
	}

	public Date getUsrDtCreate() {
		return usrDtCreate;
	}

	public void setUsrDtCreate(Date usrDtCreate) {
		this.usrDtCreate = usrDtCreate;
	}

	public String getUsrUidCreate() {
		return usrUidCreate;
	}

	public void setUsrUidCreate(String usrUidCreate) {
		this.usrUidCreate = usrUidCreate;
	}

	public Date getUsrDtLupd() {
		return usrDtLupd;
	}

	public void setUsrDtLupd(Date usrDtLupd) {
		this.usrDtLupd = usrDtLupd;
	}

	public String getUsrUidLupd() {
		return usrUidLupd;
	}

	public void setUsrUidLupd(String usrUidLupd) {
		this.usrUidLupd = usrUidLupd;
	}
}