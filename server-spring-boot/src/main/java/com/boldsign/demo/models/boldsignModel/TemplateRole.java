package com.boldsign.demo.models.boldsignModel;

public class TemplateRole {
    public int roleIndex;
    public String signerName;
    public String signerEmail;

    public TemplateRole(int roleIndex, String signerName, String signerEmail) {
        this.roleIndex = roleIndex;
        this.signerName = signerName;
        this.signerEmail = signerEmail;
    }

    public int getRoleIndex() {
        return roleIndex;
    }

    public void setRoleIndex(int roleIndex) {
        this.roleIndex = roleIndex;
    }

    public String getSignerName() {
        return signerName;
    }

    public void setSignerName(String signerName) {
        this.signerName = signerName;
    }

    public String getSignerEmail() {
        return signerEmail;
    }

    public void setSignerEmail(String signerEmail) {
        this.signerEmail = signerEmail;
    }

}
