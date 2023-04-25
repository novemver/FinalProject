import { AppComponent } from "../app.component";
import { Appointment } from "./appointment";
import { User } from "./user";

export class Reminder {
   id: number;
   reminderDate: Date;
   reminderTime: Date;
   title: string;
   description: string;
   apptReminder: Appointment;
   userReminders: User [];

   constructor(
    id: number = 0,
    reminderDate: Date = new Date,
    reminderTime: Date = new Date,
    title: string = "",
    description: string = "",
    apptReminder: Appointment = new Appointment(),
    userReminders: User[] = [],
   ){
    this.id =id;
    this.reminderDate = reminderDate;
    this.reminderTime = reminderTime;
    this.title = title;
    this.description = description;
    this.apptReminder = apptReminder;
    this.userReminders = userReminders;
   }

}
