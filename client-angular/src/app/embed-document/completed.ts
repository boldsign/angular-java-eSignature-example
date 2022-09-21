import { Component, OnInit } from '@angular/core';

@Component({
  templateUrl: './completed.html',
})
export class EmbedSendDocumentCompleted implements OnInit {
  constructor() {}

  ngOnInit(): void {
    window.parent.location.href = 'embed-document/redirect';
  }
}
