import { Component, OnInit } from "@angular/core";
import { Ingredient } from "../ingredient";
import { INGREDIENTS } from "../mock-ingredients";
import { RECEPIES } from "../mock-recepies";
import { UNITS } from "../mock-unit";
import { Recepie } from "../recepie";
import { RecepieIngredient } from "../recepieIngredient";
import {HttpClient} from '@angular/common/http';

@Component({
  selector: "app-recepies",
  templateUrl: "./recepies.component.html",
  styleUrls: ["./recepies.component.css"]
})
export class RecepiesComponent implements OnInit {
  recepies = RECEPIES;
  ingredients = INGREDIENTS;
  newRecepie = new Recepie();
  newIngredient = new RecepieIngredient();

  onSave(newRecepie) {
    this.http.post('http://jsonplaceholder.typicode.com/posts', this.newRecepie)
      .subscribe(
        res => {
          //this.recepies.push(res);
        },
        err => {
          console.log("Error occured");
        }
      );
  }
  addIngredient(asd) {
    this.newRecepie.ingredients.push(
      JSON.parse(JSON.stringify(this.newIngredient))
    );
  }
  deleteIngredient(id) {
    this.newRecepie.ingredients = this.newRecepie.ingredients.filter(
      ingredient => ingredient.id !== id
    );
  }
  getIngredientById(id) {
    return this.ingredients.filter(ingredient => ingredient.id === id)[0];
  }
  deleteRecepie(id) {
    this.http.delete('https://api.github.com/users/seeschweiler'+id).subscribe(data => {
      this.recepies = this.recepies.filter(recepie => recepie.id !== id);
    });

  }
  filteredIngredients() {
    return this.ingredients.filter(ingredient => {
      return !this.newRecepie.ingredients.filter(newIngredient => {
        return ingredient.id === newIngredient.id;
      }).length;
    });
  }
  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.http.get('https://api.github.com/users/seeschweiler').subscribe(data => {
      //let ingredients = new Ingredient();
      //this.recepies=data;

      //this.recepies=RECEPIES;
    });
  }
}
