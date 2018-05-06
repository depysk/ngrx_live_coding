import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { UsersService } from './services/users.service';
import {PortfoliosService} from './services/portfolios.service';

import {HttpClientModule} from '@angular/common/http';
import {APP_CONFIG} from "./utils/app-config";
import {environment} from "../environments/environment";
import {WsClient} from "./utils/ws-client";
import {UriBuilderService} from "./utils/uri-builder.service";
import {HomeComponent} from "./components/home/home.component";
import {FormsModule} from "@angular/forms";
import {WebsocketService} from "./utils/websocket.service";
import {ProductsService} from "./services/products.service";


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    PortfoliosService,
    ProductsService,
    UsersService,
    UriBuilderService,
    WsClient,
    WebsocketService,
    {provide: APP_CONFIG, useValue: environment.config},
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
