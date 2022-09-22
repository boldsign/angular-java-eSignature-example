import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
    templateUrl: './document.html'
})

export class DocumentPropertiesComponent implements OnInit {
    userForm!: FormGroup;
    showLoading!: boolean;
    documentProperties: any;

    constructor(
        private formBuilder: FormBuilder,
        private http: HttpClient,
    ) { }

    onSubmit(): void {
        if (this.userForm.invalid) {
            console.warn('Fill required fields');
        } else {
            this.showLoading = true;
            this.http.get('http://localhost:8080/api/getDocumentProperties/?documentId=' + this.userForm.value.documentId)
                .subscribe(data => {
                    this.showLoading = false;
                    this.documentProperties = data;
                });
        }
    }

    ngOnInit() {
        this.showLoading = false;
        this.userForm = this.formBuilder.group({
            documentId: ['', Validators.required],
        });
    }
}
