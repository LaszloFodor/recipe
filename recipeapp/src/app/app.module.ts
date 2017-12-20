import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppComponent } from "./app.component";
import { FormsModule, NgSelectOption } from "@angular/forms";

import { AlertModule } from "ngx-bootstrap";
import { AppRoutingModule } from ".//app-routing.module";

import { HttpClientModule } from "@angular/common/http";

import { Routes, RouterModule } from "@angular/router";
import { LoginComponent } from "./login/login.component";
import { RegisterComponent } from "./register/register.component";

export const ROUTES: Routes = [
  { path: "", component: LoginComponent },
  { path: "register", component: RegisterComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    RouterModule.forRoot(ROUTES),
    AlertModule.forRoot(),
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
