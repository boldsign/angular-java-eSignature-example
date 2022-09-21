package com.boldsign.demo.models.userInputs;

public class SendTemplateInput {
    public String name;
    public String email;
    public String templateId;

    public SendTemplateInput(String name, String email, String templateId) {
        this.name = name;
        this.email = email;
        this.templateId = templateId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

}
