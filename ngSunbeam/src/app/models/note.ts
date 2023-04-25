export class Note {
  id: number;
  title: string;
  description: string;
  flagged: string;
  createDate: Date;

constructor(
  id: number = 0,
  title: string = '',
  description: string = '',
  flagged: string = '',
  createDate: Date = new Date()
){
  this.id = id;
  this.title = title;
  this.description = description;
  this.flagged = flagged;
  this.createDate = createDate;
}

}
