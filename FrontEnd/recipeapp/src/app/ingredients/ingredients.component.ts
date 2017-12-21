import { Component, OnInit } from "@angular/core";
import { Ingredient } from "../ingredient";
import { INGREDIENTS } from "../mock-ingredients";
import { UNITS } from "../mock-unit";
import { HttpClient } from '@angular/common/http';

@Component({
  selector: "app-ingredients",
  templateUrl: "./ingredients.component.html",
  styleUrls: ["./ingredients.component.css"]
})
export class IngredientsComponent implements OnInit {
  ingredients = INGREDIENTS;
  units = UNITS;
  newIngredient = new Ingredient();
  onSave(newIngredient) {
    this.http.post('http://jsonplaceholder.typicode.com/posts', this.newIngredient)
      .subscribe(
        res => {
          //this.ingredients.push(res);
        },
        err => {
          console.log("Error occured");
        }
      );

  }
  deleteIngredient(id) {
    this.http.delete('https://api.github.com/users/seeschweiler').subscribe(data => {
      /*this.ingredients = this.ingredients.filter(
        ingredient => ingredient.id !== data
      );*/
    });

  }
  constructor(private http: HttpClient) {}

  ngOnInit() :void {
    this.http.get('https://api.github.com/users/seeschweiler').subscribe(data => {
     // this.ingredients=data;

      //this.ingredients=INGREDIENTS;
    });
  }
}
