package com.boldsign.demo.models.boldsignModel;

import java.util.List;

public class Signer {
    public String name;
    public String emailAddress;
    public String signerType;
    public List<FormField> formFields;

    public Signer(String name, String emailAddress, String signerType) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.signerType = signerType;
    }

    public Signer(String name, String emailAddress, String signerType, List<FormField> formFields) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.signerType = signerType;
        this.formFields = formFields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSignerType() {
        return signerType;
    }

    public void setSignerType(String signerType) {
        this.signerType = signerType;
    }

    public List<FormField> getFormFields() {
        return formFields;
    }

    public void setFormFields(List<FormField> formFields) {
        this.formFields = formFields;
    }

}
