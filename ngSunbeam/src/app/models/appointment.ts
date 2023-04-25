import { Category } from './category';
import { Elder } from './elder';
import { Reminder } from './reminder';
import { User } from './user';

export class Appointment {
  id: number;
  description: string;
  appDate: Date;
  appTime: Date;
  title: string;
  createDate: Date;
  updateDate: Date;
  userAppointment: User;
  elderAppointment: Elder;
  category: Category;
  location: Location;
  reminders: Reminder [];

  constructor(
  id: number = 0,
  description: string = "",
  appDate: Date = new Date(),
  appTime: Date = new Date(),
  title: string = "",
  createDate: Date = new Date(),
  updateDate: Date = new Date(),
  userAppointment: User = new User,
  elderAppointment: Elder = new Elder(),
  category: Category = new Category(),
  location: Location = new Location(),
  reminders: Reminder[] = [],
  ){
    this.id = id;
    this.description = description;
    this.appDate = appDate;
    this.appTime = appTime;
    this.title = title;
    this.createDate = createDate;
    this.updateDate = updateDate;
    this.userAppointment = userAppointment;
    this.elderAppointment = elderAppointment;
    this.category = category;
    this.location = location;
    this.reminders = reminders;

  }


}
