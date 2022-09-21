import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  templateUrl: './send.html',
})
export class SendDocumentUsingTemplateComponent implements OnInit {
  userForm!: FormGroup;
  isDocumentSend!: boolean;
  showLoading!: boolean;
  documentId!: string;

  constructor(private formBuilder: FormBuilder, private http: HttpClient) {}

  onSubmit(): void {
    this.isDocumentSend = false;
    if (this.userForm.invalid) {
      console.warn('Fill required fields');
    } else {
      this.showLoading = true;
      this.http
        .post('http://localhost:8080/api/template/send', this.userForm.value)
        .subscribe((data) => {
          this.showLoading = false;
          this.isDocumentSend = true;
          this.documentId = (data as any).documentId;
        });
    }
  }

  ngOnInit() {
    this.isDocumentSend = false;
    this.showLoading = false;
    this.userForm = this.formBuilder.group({
      templateId: ['', Validators.required],
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
    });
  }
}
