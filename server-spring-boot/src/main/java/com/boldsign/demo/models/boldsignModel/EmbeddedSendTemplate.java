package com.boldsign.demo.models.boldsignModel;

import java.util.List;

public class EmbeddedSendTemplate {
    public List<TemplateRole> roles;
    public String sendViewOption;
    public boolean showToolbar;
    public boolean showSaveButton;
    public boolean showSendButton;
    public String redirectUrl;

    public EmbeddedSendTemplate(List<TemplateRole> roles, String sendViewOption, boolean showToolbar,
            boolean showSaveButton, boolean showSendButton, String redirectUrl) {
        this.roles = roles;
        this.sendViewOption = sendViewOption;
        this.showToolbar = showToolbar;
        this.showSaveButton = showSaveButton;
        this.showSendButton = showSendButton;
        this.redirectUrl = redirectUrl;
    }

    public List<TemplateRole> getRoles() {
        return roles;
    }

    public void setRoles(List<TemplateRole> roles) {
        this.roles = roles;
    }

    public String getSendViewOption() {
        return sendViewOption;
    }

    public void setSendViewOption(String sendViewOption) {
        this.sendViewOption = sendViewOption;
    }

    public boolean isShowToolbar() {
        return showToolbar;
    }

    public void setShowToolbar(boolean showToolbar) {
        this.showToolbar = showToolbar;
    }

    public boolean isShowSaveButton() {
        return showSaveButton;
    }

    public void setShowSaveButton(boolean showSaveButton) {
        this.showSaveButton = showSaveButton;
    }

    public boolean isShowSendButton() {
        return showSendButton;
    }

    public void setShowSendButton(boolean showSendButton) {
        this.showSendButton = showSendButton;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
