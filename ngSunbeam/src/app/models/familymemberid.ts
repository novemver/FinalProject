import { Familymember } from './familymember';
export class Familymemberid {
  userId: number;
  elderId: number;

  constructor(
  userId: number = 0,
  elderId: number = 0
  ){
    this.userId = userId;
    this.elderId = elderId;
  }
}
