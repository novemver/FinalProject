
import { Elder } from "./elder";
import { User } from "./user";
import { Familymemberid } from './familymemberid';

export class Familymember {
  id: Familymemberid ;
  relationship: string;
  enabled: boolean;
  isEmergencyContact: boolean;
  user: User;
  elder: Elder;

  constructor(
    id: Familymemberid = new Familymemberid(),
    relationship: string = "",
    enabled: boolean = false,
    isEmergencyContact: boolean = false,
    user:  User = new User(),
    elder: Elder = new Elder()
  ){
    this.id = id;
    this.relationship = relationship;
    this.enabled = enabled;
    this.isEmergencyContact = isEmergencyContact;
    this.user = user;
    this.elder = elder;
  }

}
