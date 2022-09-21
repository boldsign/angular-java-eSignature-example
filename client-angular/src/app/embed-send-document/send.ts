import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Component({
  templateUrl: './send.html',
})
export class EmbedSendDocumentComponent implements OnInit {
  userForm!: FormGroup;
  showiframe!: boolean;
  showLoading!: boolean;
  src!: SafeResourceUrl;
  selectedFile!: File;

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private sanitizer: DomSanitizer
  ) {}

  onFileSelct(event: any): void {
    this.selectedFile = <File>event.target.files[0];
  }

  onSubmit(): void {
    if (this.userForm.invalid) {
      console.warn('Fill required fields');
    } else {
      this.showLoading = true;
      const formData = new FormData();
      formData.append('name', this.userForm.value.name);
      formData.append('email', this.userForm.value.email);
      formData.append('file', this.selectedFile, this.selectedFile.name);
      this.http
        .post(
          'http://localhost:8080/api/document/createEmbeddedRequestUrl',
          formData
        )
        .subscribe((data: any) => {
          sessionStorage.setItem('documentId', data.documentId);
          sessionStorage.setItem('status', 'SEND');
          this.userForm.reset();
          this.showLoading = false;
          this.showiframe = true;
          this.src = this.sanitizer.bypassSecurityTrustResourceUrl(
            data.sendUrl.toString()
          );
        });
    }
  }

  ngOnInit() {
    this.showiframe = false;
    this.showLoading = false;
    this.userForm = this.formBuilder.group({
      file: ['', Validators.required],
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
    });
  }
}
