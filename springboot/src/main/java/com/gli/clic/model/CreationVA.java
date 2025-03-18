package com.gli.clic.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_CK_CP_CREATION_VA")
public class CreationVA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CRT_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "CRT_SERVICE_TYPE", nullable = false)
    private String serviceType;

    @Column(name = "CRT_NODE", nullable = false)
    private String node;

    @Column(name = "CRT_CCY", nullable = false)
    private String currency;

    @Column(name = "CRT_VIRTUAL_TYPE", nullable = false)
    private String virtualType;

    @Column(name = "CRT_VIRTUAL_NUMBER", unique = true, nullable = false)
    private String virtualNumber;

    @Column(name = "CRT_VRITUAL_NAME", nullable = false)
    private String virtualName;

    @Column(name = "CRT_VIRTUAL_EMAIL")
    private String virtualEmail;

    @Column(name = "CRT_VIRTUAL_PHONE")
    private String virtualPhone;

    @Column(name = "CRT_DT_VIRTUAL_EXPIRED")
    private Date virtualExpiredDate;

    @Column(name = "CRT_STATUS", nullable = false)
    private String status = "A";

    @Column(name = "CRT_DT_CREATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "CRT_UID_CREATE", nullable = false)
    private String createdBy = "SYS";

    @Column(name = "CRT_DT_LUPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDate;

    @Column(name = "CRT_UID_LUPD", nullable = false)
    private String lastUpdatedBy = "SYS";

    @PrePersist
    protected void onCreate() {
        Date now = new Date();
        if (createdDate == null) {
            createdDate = now;
        }
        if (lastUpdatedDate == null) {
            lastUpdatedDate = now;
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getVirtualType() {
        return virtualType;
    }

    public void setVirtualType(String virtualType) {
        this.virtualType = virtualType;
    }

    public String getVirtualNumber() {
        return virtualNumber;
    }

    public void setVirtualNumber(String virtualNumber) {
        this.virtualNumber = virtualNumber;
    }

    public String getVirtualName() {
        return virtualName;
    }

    public void setVirtualName(String virtualName) {
        this.virtualName = virtualName;
    }

    public String getVirtualEmail() {
        return virtualEmail;
    }

    public void setVirtualEmail(String virtualEmail) {
        this.virtualEmail = virtualEmail;
    }

    public String getVirtualPhone() {
        return virtualPhone;
    }

    public void setVirtualPhone(String virtualPhone) {
        this.virtualPhone = virtualPhone;
    }

    public Date getVirtualExpiredDate() {
        return virtualExpiredDate;
    }

    public void setVirtualExpiredDate(Date virtualExpiredDate) {
        this.virtualExpiredDate = virtualExpiredDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}