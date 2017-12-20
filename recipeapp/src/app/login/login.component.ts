import { Component, OnInit } from "@angular/core";
import { HttpClient } from '@angular/common/http';

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent implements OnInit {
  username = "";
  password = "";
  constructor(private http: HttpClient) {}

  ngOnInit() {}
  onLoginClick() {
    this.http.post('http://jsonplaceholder.typicode.com/posts', {
      username: this.username,
      password: this.password
    })
      .subscribe(
        res => {
          console.log(res);
          //should redirect
        },
        err => {
          console.log("Error occured");
        }
      );
  }
}
