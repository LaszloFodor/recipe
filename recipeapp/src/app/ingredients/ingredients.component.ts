import { Component, OnInit } from "@angular/core";
import { UNITS } from "../mock-unit";
import { HttpClient } from '@angular/common/http';
import {Ingredient} from '../ingredient';

@Component({
  selector: "app-ingredients",
  templateUrl: "./ingredients.component.html",
  styleUrls: ["./ingredients.component.css"]
})
export class IngredientsComponent implements OnInit {
  ingredients = [];
  units = UNITS;
  newIngredient = { name: "", unit: "" };
  onSave(newIngredient) {
    this.http.post('localhost:8888/api/ingredient/add', this.newIngredient)
      .subscribe(
        res => {
          this.ingredients.push(res);
        },
        err => {
          console.log(" Error occured ");
        }
      );

  }
  deleteIngredient(id) {
    this.http.delete('localhost:8888/api/ingredient/delete' + id).subscribe(data => {
      this.ingredients = this.ingredients.filter(
        ingredient => ingredient.id !== data
      );
    });

  }
  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get('localhost:8888/api/ingredient/getall').subscribe(data => {
      let ingredients = new Ingredient();
       // this.ingredients = data;

      // this.ingredients=INGREDIENTS;
    });
  }
}
