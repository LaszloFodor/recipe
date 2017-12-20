import { Component, OnInit } from "@angular/core";
import {HttpClient} from '@angular/common/http';

@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"]
})
export class RegisterComponent implements OnInit {
  username = "";
  password = "";
  constructor(private http: HttpClient) {}

  ngOnInit() {}
  onRegisterClick() {
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
