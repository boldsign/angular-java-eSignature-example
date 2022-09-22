package com.boldsign.demo.models.boldsignModel;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class SendDocument {
    public String title;
    public List<Signer> signers;
    public List<MultipartFile> files;

    public SendDocument(String title, List<Signer> signers, List<MultipartFile> files) {
        this.title = title;
        this.signers = signers;
        this.files = files;
    }
}
