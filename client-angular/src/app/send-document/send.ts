import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  templateUrl: './send.html',
})
export class SendDocumentComponent implements OnInit {
  userForm!: FormGroup;
  isDocumentSend!: boolean;
  showLoading!: boolean;
  documentId!: string;
  selectedFile!: File;

  constructor(private formBuilder: FormBuilder, private http: HttpClient) {}

  onFileSelct(event: any): void {
    this.isDocumentSend = false;
    this.selectedFile = <File>event.target.files[0];
  }

  onSubmit(): void {
    this.isDocumentSend = false;
    if (this.userForm.invalid) {
      console.warn('Fill required fields');
    } else {
      this.showLoading = true;
      const formData = new FormData();
      formData.append('name', this.userForm.value.name);
      formData.append('email', this.userForm.value.email);
      formData.append('file', this.selectedFile, this.selectedFile.name);
      this.http
        .post('http://localhost:8080/api/document/send', formData)
        .subscribe((data) => {
          this.showLoading = false;
          this.isDocumentSend = true;
          this.documentId = (data as any).documentId;
          console.log(this.documentId);
        });
    }
  }

  ngOnInit() {
    this.isDocumentSend = false;
    this.showLoading = false;
    this.userForm = this.formBuilder.group({
      file: ['', Validators.required],
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
    });
  }
}
