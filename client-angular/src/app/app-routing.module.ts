import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmbedSendDocumentCompleted } from './embed-document/completed';
import { EmbedSendDocumentRedirect } from './embed-document/redirect';
import { EmbedSendDocumentUsingTemplateComponent } from './embed-send-document-using-template/send';
import { EmbedSendDocumentComponent } from './embed-send-document/send';
import { EmbedSigningComponent } from './embed-signing/embedSigning';
import { DocumentPropertiesComponent } from './get-document-properties/document';
import { LayoutComponent } from './layout.component';
import { SendDocumentUsingTemplateComponent } from './send-document-using-template/send';
import { SendDocumentComponent } from './send-document/send';

const routes: Routes = [
  { path: 'embed-document/completed', component: EmbedSendDocumentCompleted },
  { path: 'embed-document/redirect', component: EmbedSendDocumentRedirect },
  { path: 'embed-send-document', component: EmbedSendDocumentComponent },
  {
    path: 'embed-send-document-using-template',
    component: EmbedSendDocumentUsingTemplateComponent,
  },
  { path: 'embed-signing', component: EmbedSigningComponent },
  { path: 'get-document-properties', component: DocumentPropertiesComponent },
  { path: 'send-document', component: SendDocumentComponent },
  {
    path: 'send-document-using-template',
    component: SendDocumentUsingTemplateComponent,
  },
  { path: '', component: LayoutComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
