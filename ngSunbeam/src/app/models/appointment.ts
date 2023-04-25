import { Category } from './category';
import { Elder } from './elder';
import { Reminder } from './reminder';
import { User } from './user';

export class Appointment {
  id: number;
  description: string;
  apptDate: Date;
  apptTime: Date;
  title: string;
  createDate: Date;
  updateDate: Date;
  userAppointment: User | null;
  elderAppointment: Elder | null;
  category: Category | null;
  location: Location | null;
  reminders: Reminder [];

  constructor(
  id: number = 0,
  description: string = "",
  apptDate: Date = new Date(),
  apptTime: Date = new Date(),
  title: string = "",
  createDate: Date = new Date(),
  updateDate: Date = new Date(),
  userAppointment: User | null = null,
  elderAppointment: Elder | null = null,
  category: Category | null = null,
  location: Location | null = null,
  reminders: Reminder[] = [],
  ){
    this.id = id;
    this.description = description;
    this.apptDate = apptDate;
    this.apptTime = apptTime;
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
