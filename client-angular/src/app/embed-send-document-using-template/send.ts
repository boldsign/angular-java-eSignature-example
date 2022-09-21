import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Component({
    templateUrl: './send.html'
})

export class EmbedSendDocumentUsingTemplateComponent implements OnInit {
    userForm!: FormGroup;
    showiframe!: boolean;
    showLoading!: boolean;
    src!: SafeResourceUrl;

    constructor(
        private formBuilder: FormBuilder,
        private http: HttpClient,
        private sanitizer: DomSanitizer,
    ) { }

    onSubmit(): void {
        if (this.userForm.invalid) {
            console.warn('Fill required fields');
        } else {
            this.showLoading = true;
            this.http.post('http://localhost:8080/api/template/createEmbeddedRequestUrl', this.userForm.value)
                .subscribe((data: any) => {
                    sessionStorage.setItem('documentId', data.documentId);
                    sessionStorage.setItem('status', 'SEND');
                    this.userForm.reset();
                    this.showLoading = false;
                    this.showiframe = true;
                    this.src = this.sanitizer.bypassSecurityTrustResourceUrl(data.sendUrl.toString());
                });
        }
    }

    ngOnInit() {
        this.showiframe = false;
        this.showLoading = false;
        this.userForm = this.formBuilder.group({
            templateId: ['', Validators.required],
            name: ['', Validators.required],
            email: ['', [Validators.required, Validators.email]],
        });
    }
}
