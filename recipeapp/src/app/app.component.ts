import { Component } from "@angular/core";

@Component({
  styleUrls: ["./app.component.css"],
  selector: "app-root",
  template: `
    <div class="app container">
      <h3><a href="/ingredients">ingredients</a> | <a href="/recepies">recepies</a></h3>
      <router-outlet></router-outlet>
    </div>
  `
})
export class AppComponent {
  title = "app";
}
