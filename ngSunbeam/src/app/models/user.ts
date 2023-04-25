import { Reminder } from "./reminder";

export class User {
  id: number;
  username: string;
  password: string;
  enabled: boolean;
  role: string;
  email: string;
  phoneNumber: string;
  firstName: string;
  lastName: string;
  image_url: string;
  biography: string;
  createDate: Date;
  updateDate: Date;
  reminders: Reminder[] | null;

  constructor(
    id: number = 0,
    username: string = "",
    password: string = "",
    enabled: boolean = false,
    role: string = "",
    email: string = "",
    phoneNumber: string = "",
    firstName: string = "",
    lastName: string = "",
    image_url: string = "",
    biography: string = "",
    createDate: Date = new Date(),
    updateDate: Date = new Date(),
    reminders: Reminder [] = []
  ){
    this.id = id;
    this.username = username;
    this.password = password;
    this.enabled = enabled;
    this.role = role;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.firstName = firstName;
    this.lastName = lastName;
    this.image_url = image_url;
    this.biography = biography;
    this.createDate = createDate;
    this.updateDate = updateDate;
    this.reminders = reminders;
  }
}
