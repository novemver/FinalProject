export class Category {
  id: number;
  description: string;

  constructor(
    id: number = 0,
    description: string = '',
  ){
    this.id = id;
    this.description = description;
  }
}
