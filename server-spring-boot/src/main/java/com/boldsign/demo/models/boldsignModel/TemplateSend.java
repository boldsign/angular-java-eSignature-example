package com.boldsign.demo.models.boldsignModel;

import java.util.List;

public class TemplateSend {
    public List<TemplateRole> roles;

    public TemplateSend(List<TemplateRole> roles) {
        this.roles = roles;
    }

    public List<TemplateRole> getRoles() {
        return roles;
    }

    public void setRoles(List<TemplateRole> roles) {
        this.roles = roles;
    }

}
