import { RecepieIngredient } from "./recepieIngredient";

export class Recepie {
  id: number = null;
  name: string = "";
  description: string = "";
  ingredients: RecepieIngredient[] = [];
}
