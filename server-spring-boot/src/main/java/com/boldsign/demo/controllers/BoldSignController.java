package com.boldsign.demo.controllers;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boldsign.demo.boldsignapi.DocumentApi;
import com.boldsign.demo.boldsignapi.TemplateApi;
import com.boldsign.demo.models.boldsignModel.DocumentCreated;
import com.boldsign.demo.models.boldsignModel.EmbeddedDocumentCreated;
import com.boldsign.demo.models.userInputs.SendDocumentInput;
import com.boldsign.demo.models.userInputs.SendTemplateInput;

@Controller
@CrossOrigin
public class BoldSignController {
    private final DocumentApi documentApi;
    private final TemplateApi templateApi;

    @Autowired
    public BoldSignController(DocumentApi documentApi, TemplateApi templateApi) {
        this.documentApi = documentApi;
        this.templateApi = templateApi;
    }

    @RequestMapping(path = "/api/document/send", method = RequestMethod.POST, consumes = {
            MediaType.MULTIPART_FORM_DATA_VALUE })
    @ResponseBody
    public DocumentCreated sendDocument(@ModelAttribute SendDocumentInput model) throws IOException {
        return this.documentApi.sendDocument(model);
    }

    @PostMapping("/api/template/send")
    @ResponseBody
    public DocumentCreated sendDocumentUsingTemplate(@RequestBody SendTemplateInput model)
            throws IOException, URISyntaxException {
        return this.templateApi.sendTemplate(model);
    }

    @GetMapping("/api/getDocumentProperties")
    @ResponseBody
    public String getDocumentProperties(String documentId)
            throws ClientProtocolException, URISyntaxException, IOException {
        return this.documentApi.getDocumentProperties(documentId);
    }

    @PostMapping("/api/embedSigning")
    @ResponseBody
    public String embedSigning(@RequestBody SendTemplateInput model) throws IOException, URISyntaxException {
        var documentCreated = this.templateApi.sendTemplate(model);

        return this.documentApi.getEmbeddedSignLink(documentCreated, model);
    }

    @RequestMapping(path = "/api/document/createEmbeddedRequestUrl", method = RequestMethod.POST, consumes = {
            MediaType.MULTIPART_FORM_DATA_VALUE })
    @ResponseBody
    public EmbeddedDocumentCreated embedSendDocument(@ModelAttribute SendDocumentInput model) throws IOException {
        return this.documentApi.createEmbeddedDocument(model);
    }

    @PostMapping("/api/template/createEmbeddedRequestUrl")
    @ResponseBody
    public EmbeddedDocumentCreated embedSendDocumentUsingTemplate(@RequestBody SendTemplateInput model)
            throws IOException, URISyntaxException {
        return this.templateApi.embeddedSendTemplate(model);
    }
}
