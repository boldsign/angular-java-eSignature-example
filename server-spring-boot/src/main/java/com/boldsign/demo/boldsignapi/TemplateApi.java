package com.boldsign.demo.boldsignapi;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Component;

import com.boldsign.demo.models.boldsignModel.DocumentCreated;
import com.boldsign.demo.models.boldsignModel.EmbeddedDocumentCreated;
import com.boldsign.demo.models.boldsignModel.EmbeddedSendTemplate;
import com.boldsign.demo.models.boldsignModel.TemplateRole;
import com.boldsign.demo.models.boldsignModel.TemplateSend;
import com.boldsign.demo.models.userInputs.SendTemplateInput;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TemplateApi extends BaseApi {
    /**
     * API reference https://api.boldsign.com/swagger/index.html
     */
    public DocumentCreated sendTemplate(SendTemplateInput model) throws IOException, URISyntaxException {
        var req = new HttpPost(this.templateSendUrl());

        URI uri = new URIBuilder(req.getURI())
                .addParameter("templateId", model.templateId)
                .build();
        req.setURI(uri);

        var templateRole = new TemplateRole(1, model.name, model.email);
        var templateRoles = Arrays.asList(templateRole);

        var sendTemplate = new TemplateSend(templateRoles);

        req = (HttpPost) this.prepareJsonEntity(req, sendTemplate);

        var responseStr = this.executeHttp(req);

        return new ObjectMapper().readValue(responseStr, DocumentCreated.class);
    }

    /**
     * API reference https://api.boldsign.com/swagger/index.html
     */
    public EmbeddedDocumentCreated embeddedSendTemplate(SendTemplateInput model)
            throws IOException, URISyntaxException {
        var req = new HttpPost(this.embeddedTemplateSendUrl());

        URI uri = new URIBuilder(req.getURI())
                .addParameter("templateId", model.templateId)
                .build();
        req.setURI(uri);

        var templateRole = new TemplateRole(1, model.name, model.email);
        var templateRoles = Arrays.asList(templateRole);

        var sendTemplate = new EmbeddedSendTemplate(templateRoles, "PreparePage", true, true, true,
                "http://localhost:4200/embed-document/completed");

        req = (HttpPost) this.prepareJsonEntity(req, sendTemplate);

        var responseStr = this.executeHttp(req);

        return new ObjectMapper().readValue(responseStr, EmbeddedDocumentCreated.class);
    }
}
