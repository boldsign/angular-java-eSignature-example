import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { NgxJsonViewerModule } from 'ngx-json-viewer';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmbedSendDocumentRedirect } from './embed-document/redirect';
import { EmbedSendDocumentUsingTemplateComponent } from './embed-send-document-using-template/send';
import { EmbedSendDocumentComponent } from './embed-send-document/send';
import { EmbedSigningComponent } from './embed-signing/embedSigning';
import { DocumentPropertiesComponent } from './get-document-properties/document';
import { LayoutComponent } from './layout.component';
import { MenuComponent } from './menu.component';
import { SendDocumentUsingTemplateComponent } from './send-document-using-template/send';
import { SendDocumentComponent } from './send-document/send';

@NgModule({
  declarations: [
    AppComponent,

    LayoutComponent,
    MenuComponent,
    EmbedSendDocumentComponent,
    EmbedSendDocumentUsingTemplateComponent,
    EmbedSigningComponent,
    DocumentPropertiesComponent,
    SendDocumentComponent,
    SendDocumentUsingTemplateComponent,
    EmbedSendDocumentRedirect,
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule,
    NgxJsonViewerModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
