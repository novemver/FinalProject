import { Appointment } from "./appointment";
import { Familymember } from "./familymember";
import { Medication } from "./medication";
import { Note } from "./note";
import { User } from "./user";

export class Elder {
  id: number;
  firstName: string;
  lastName: string;
  weight: string;
  height: string;
  birthdate: Date;
  accessCode: string;
  elderOverview: string;
  gender: string;
  createDate: Date;
  lastUpdate: Date;
  imageUrl: string;
  elderBio: string;
  enabled: boolean;
  elderNotes: Note;
  appointments: Appointment;
  comments: Comment;
  familyMembers: Familymember [];
  medications: Medication;
  elderCaretakers: User;

constructor(
  id: number = 0,
  firstName: string = "",
  lastName: string = "",
  weight: string = "",
  height: string = "",
  birthdate: Date = new Date(),
  accessCode: string = "",
  elderOverview: string = "",
  gender: string = "",
  createDate: Date = new Date(),
  lastUpdate: Date = new Date(),
  imageUrl: string = "",
  elderBio: string = "",
  enabled: boolean = false,
  elderNotes: Note = new Note(),
  appointments: Appointment = new Appointment(),
  comments: Comment = new Comment(),
  familyMembers: Familymember[] = [],
  medications: Medication = new Medication(),
  elderCaretakers: User = new User(),
){
  this.id = id;
  this.firstName = firstName;
  this.lastName = lastName;
  this.weight = weight;
  this.height = height;
  this.birthdate = birthdate;
  this.accessCode = accessCode;
  this.elderOverview = elderOverview;
  this.gender = gender;
  this.createDate = createDate;
  this.lastUpdate = lastUpdate;
  this.imageUrl = imageUrl;
  this.elderBio = elderBio;
  this.enabled = enabled;
  this.elderNotes = elderNotes;
  this.appointments = appointments;
  this.comments = comments;
  this.familyMembers = familyMembers;
  this.medications = medications;
  this.elderCaretakers = elderCaretakers;
}
}
