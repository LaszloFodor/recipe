import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppComponent } from "./app.component";
import { FormsModule, NgSelectOption } from "@angular/forms";
import { IngredientsComponent } from "./ingredients/ingredients.component";
import { RecepiesComponent } from "./recepies/recepies.component"; // <-- NgModel lives here

import { AlertModule } from "ngx-bootstrap";
import { AppRoutingModule } from ".//app-routing.module";

import { HttpClientModule } from "@angular/common/http";

import { Routes, RouterModule } from "@angular/router";
import { LoginComponent } from "./login/login.component";
import { RegisterComponent } from "./register/register.component";

export const ROUTES: Routes = [
  { path: "ingredients", component: IngredientsComponent },
  { path: "recepies", component: RecepiesComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    IngredientsComponent,
    RecepiesComponent,
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
