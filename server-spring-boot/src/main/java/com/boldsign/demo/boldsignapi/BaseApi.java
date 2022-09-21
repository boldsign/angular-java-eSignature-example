package com.boldsign.demo.boldsignapi;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class BaseApi {
    // BoldSign API host from environmental variable (https://api.boldsign.com)
    protected String apiHost = "https://api.boldsign.com";

    // BoldSign API key from environmental variable
    @Value("${apiKey}")
    protected String apiKey;

    protected CloseableHttpClient http;
    protected ContentType PdfMime = ContentType.create("application/pdf");

    public BaseApi() {
        this.http = HttpClients.createDefault();
    }

    protected String sendDocumentUrl() {
        return this.apiHost + "/v1/document/send";
    }

    protected String sendEmbeddedDocumentUrl() {
        return this.apiHost + "/v1/document/createEmbeddedRequestUrl";
    }

    protected String documentPropertiesUrl() {
        return this.apiHost + "/v1/document/properties";
    }

    protected String getSignLinkUrl() {
        return this.apiHost + "/v1/document/getEmbeddedSignLink";
    }

    protected String templateSendUrl() {
        return this.apiHost + "/v1/template/send/";
    }

    protected String embeddedTemplateSendUrl() {
        return this.apiHost + "/v1/template/createEmbeddedRequestUrl/";
    }

    protected void setHeaderAuth(HttpRequestBase req) {
        req.addHeader("X-API-KEY", this.apiKey);
    }

    protected HttpEntityEnclosingRequestBase prepareJsonEntity(HttpEntityEnclosingRequestBase req, Object data)
            throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer();
        String strJson = ow.writeValueAsString(data);

        StringEntity strEntity = new StringEntity(strJson, ContentType.APPLICATION_JSON);
        req.setEntity(strEntity);
        req.setHeader("Content-type", "application/json");

        return req;
    }

    protected String executeHttp(HttpRequestBase req) throws ClientProtocolException, IOException {
        this.setHeaderAuth(req);

        var response = this.http.execute(req);

        var str = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

        response.close();

        return str;
    }

    protected String executeHttp(HttpEntityEnclosingRequestBase req) throws ClientProtocolException, IOException {
        this.setHeaderAuth(req);

        var response = this.http.execute(req);

        var str = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

        response.close();

        return str;
    }
}
