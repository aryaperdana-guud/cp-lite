package com.gli.clic.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "T_CK_CP_ASSIGNMENT_VA")
public class AssignmentVA {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASGN_ID", unique = true, nullable = false)
    private Long asgnId;

    @Column(name = "ASGN_VIRTUAL_NUMBER", nullable = false)
    private String asgnVirtualNumber;  

    @Column(name = "ASGN_REF_NUMBER", nullable = false)
    private String asgnRefNumber;  

    @Column(name = "ASGN_VIRTUAL_AMOUNT", nullable = false)
    private Long asgnVirtualAmount;  

    @Column(name = "ASGN_VIRTUAL_STATUS", nullable = false)
    private char asgnVirtualStatus;

    @Column(name = "ASGN_CALLBACK_URI", nullable = false)
    private String asgnCallbackUri;

    @Column(name = "ASGN_DT_CREATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date asgnDtCreate;

    @Column(name = "ASGN_UID_CREATE", nullable = false)
    private String asgnUidCreate = "SYS";

    @Column(name = "ASGN_DT_LUPD", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date asgnDtLupd;

    @Column(name = "ASGN_UID_LUPD", nullable = false)
    private String asgnUidLupd = "SYS";

    @PrePersist
    protected void onCreate() {
        Date now = new Date();
        if (asgnDtCreate == null) {
            asgnDtCreate = now;
        }
        if (asgnDtLupd == null) {
            asgnDtLupd = now;
        }
    }
    
    public Long getAsgnId() {
		return asgnId;
	}

	public void setAsgnId(Long asgnId) {
		this.asgnId = asgnId;
	}

	public String getAsgnVirtualNumber() {
		return asgnVirtualNumber;
	}

	public void setAsgnVirtualNumber(String asgnVirtualNumber) {
		this.asgnVirtualNumber = asgnVirtualNumber;
	}

	public String getAsgnRefNumber() {
		return asgnRefNumber;
	}

	public void setAsgnRefNumber(String asgnRefNumber) {
		this.asgnRefNumber = asgnRefNumber;
	}

	public Long getAsgnVirtualAmount() {
		return asgnVirtualAmount;
	}

	public void setAsgnVirtualAmount(Long asgnVirtualAmount) {
		this.asgnVirtualAmount = asgnVirtualAmount;
	}

	public char getAsgnVirtualStatus() {
		return asgnVirtualStatus;
	}

	public void setAsgnVirtualStatus(char asgnVirtualStatus) {
		this.asgnVirtualStatus = asgnVirtualStatus;
	}

	public String getAsgnCallbackUri() {
		return asgnCallbackUri;
	}

	public void setAsgnCallbackUri(String asgnCallbackUri) {
		this.asgnCallbackUri = asgnCallbackUri;
	}

	public Date getAsgnDtCreate() {
		return asgnDtCreate;
	}

	public void setAsgnDtCreate(Date asgnDtCreate) {
		this.asgnDtCreate = asgnDtCreate;
	}

	public String getAsgnUidCreate() {
		return asgnUidCreate;
	}

	public void setAsgnUidCreate(String asgnUidCreate) {
		this.asgnUidCreate = asgnUidCreate;
	}

	public Date getAsgnDtLupd() {
		return asgnDtLupd;
	}

	public void setAsgnDtLupd(Date asgnDtLupd) {
		this.asgnDtLupd = asgnDtLupd;
	}

	public String getAsgnUidLupd() {
		return asgnUidLupd;
	}

	public void setAsgnUidLupd(String asgnUidLupd) {
		this.asgnUidLupd = asgnUidLupd;
	}
    
}