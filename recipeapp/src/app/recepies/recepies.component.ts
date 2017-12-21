import { Component, OnInit } from "@angular/core";
import { Ingredient } from "../ingredient";
import { Recepie } from "../recepie";
import { RecepieIngredient } from "../recepieIngredient";
import {HttpClient} from '@angular/common/http';

@Component({
  selector: " app-recepies ",
  templateUrl: "./recepies.component.html",
  styleUrls: ["./recepies.component.css"]
})
export class RecepiesComponent implements OnInit {
  recepies = [];
  ingredients = [];
  newRecepie = {
    id: null,
    name: "",
    description: "",
    ingredients: []
  };
  newIngredient = {
    id: "",
    amount: ""
  };

  onSave(newRecepie) {
    this.http.post('localhost:8888/api/recipe/add', this.newRecepie)
      .subscribe(
        res => {
          this.recepies.push(res);
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
    this.http.delete('localhost:8888/api/recipe/delete' + id).subscribe(data => {
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
    this.http.get('localhost:8888/api/recipe/getall').subscribe(data => {
      let ingredients = new Ingredient();
      //this.recepies=data;

      //this.recepies=RECEPIES;
    });
  }
}
