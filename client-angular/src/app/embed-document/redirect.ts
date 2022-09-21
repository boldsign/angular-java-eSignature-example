import { Component } from '@angular/core';

@Component({
  templateUrl: './redirect.html',
})
export class EmbedSendDocumentRedirect {
  documentId!: string;
  status!: string;
  constructor() {}

  ngOnInit() {
    this.documentId = sessionStorage.getItem('documentId') as string;
    this.status = sessionStorage.getItem('status') as string;
  }
}
