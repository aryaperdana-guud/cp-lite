package com.gli.clic.dto;

import jakarta.validation.constraints.*;

public class UserDTO {

    @NotBlank(message = "UID is required")
    private String usrUid;

    @NotBlank(message = "Account ID is required")
    private String usrAccnId;

    @NotBlank(message = "Password is required")
    private String usrPassword;

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

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }
}