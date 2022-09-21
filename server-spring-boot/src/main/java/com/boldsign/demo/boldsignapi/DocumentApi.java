package com.boldsign.demo.boldsignapi;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;
import org.springframework.stereotype.Component;

import com.boldsign.demo.models.boldsignModel.DocumentCreated;
import com.boldsign.demo.models.boldsignModel.EmbeddedDocumentCreated;
import com.boldsign.demo.models.boldsignModel.FieldPosition;
import com.boldsign.demo.models.boldsignModel.FormField;
import com.boldsign.demo.models.boldsignModel.Signer;
import com.boldsign.demo.models.userInputs.SendDocumentInput;
import com.boldsign.demo.models.userInputs.SendTemplateInput;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DocumentApi extends BaseApi {
    /**
     * API reference https://api.boldsign.com/swagger/index.html
     */
    public DocumentCreated sendDocument(SendDocumentInput model) throws IOException {
        var req = new HttpPost(this.sendDocumentUrl());

        var builder = MultipartEntityBuilder.create();

        var bounds = new FieldPosition(100, 100, 100, 50);
        var formField = new FormField("sign1", "Signature", true, null, 1, bounds);

        var formFields = Arrays.asList(formField);

        var signer = new Signer(model.name, model.email, "Signer", formFields);

        var jsonMapper = new ObjectMapper();

        var signerStr = jsonMapper.writeValueAsString(signer);

        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addPart("files", new ByteArrayBody(model.file.getBytes(), PdfMime, model.file.getName()));
        builder.addPart("signers", new StringBody(signerStr, ContentType.MULTIPART_FORM_DATA));
        builder.addPart("title", new StringBody("Random document title", ContentType.MULTIPART_FORM_DATA));

        var entity = builder.build();
        req.setEntity(entity);

        var responseStr = this.executeHttp(req);

        return jsonMapper.readValue(responseStr, DocumentCreated.class);
    }

    /**
     * API reference https://api.boldsign.com/swagger/index.html
     */
    public EmbeddedDocumentCreated createEmbeddedDocument(SendDocumentInput model) throws IOException {
        var req = new HttpPost(this.sendEmbeddedDocumentUrl());

        var builder = MultipartEntityBuilder.create();

        var signer = new Signer(model.name, model.email, "Signer");

        var jsonMapper = new ObjectMapper();

        var signerStr = jsonMapper.writeValueAsString(signer);

        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addPart("files", new ByteArrayBody(model.file.getBytes(), PdfMime, model.file.getName()));
        builder.addPart("signers", new StringBody(signerStr, ContentType.MULTIPART_FORM_DATA));
        builder.addPart("title", new StringBody("Random document title", ContentType.MULTIPART_FORM_DATA));
        builder.addPart("showToolbar", new StringBody("true", ContentType.MULTIPART_FORM_DATA));
        builder.addPart("redirectUrl",
                new StringBody("http://localhost:4200/embed-document/completed", ContentType.MULTIPART_FORM_DATA));

        var entity = builder.build();
        req.setEntity(entity);

        var responseStr = this.executeHttp(req);

        return jsonMapper.readValue(responseStr, EmbeddedDocumentCreated.class);
    }

    /**
     * API reference https://api.boldsign.com/swagger/index.html
     */
    public String getDocumentProperties(String documentId)
            throws URISyntaxException, ClientProtocolException, IOException {
        var req = new HttpGet(this.documentPropertiesUrl());

        URI uri = new URIBuilder(req.getURI())
                .addParameter("documentId", documentId)
                .build();
        req.setURI(uri);

        return this.executeHttp(req);
    }

    /**
     * API reference https://api.boldsign.com/swagger/index.html
     */
    public String getEmbeddedSignLink(DocumentCreated documentCreated, SendTemplateInput model)
            throws IOException, URISyntaxException {

        var req = new HttpGet(this.getSignLinkUrl());
        URI uri = new URIBuilder(req.getURI())
                .addParameter("documentId", documentCreated.documentId)
                .addParameter("signerEmail", model.email)
                .addParameter("redirectUrl", "http://localhost:4200/embed-document/completed")
                .build();
        req.setURI(uri);

        return this.executeHttp(req);
    }
}
