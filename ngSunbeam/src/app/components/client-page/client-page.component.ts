import { ElderService } from './../../services/elder.service';
import { Component, OnInit } from '@angular/core';
import { Elder } from 'src/app/models/elder';
import { AuthService } from 'src/app/services/auth.service';
import { User } from "src/app/models/user";
import { Appointment } from 'src/app/models/appointment';
import { Note } from 'src/app/models/note';
import { ReminderService } from 'src/app/services/reminder.service';
import { Reminder } from 'src/app/models/reminder';

@Component({
  selector: 'app-client-page',
  templateUrl: './client-page.component.html',
  styleUrls: ['./client-page.component.css']
})
export class ClientPageComponent implements OnInit{

  selected: Elder | null = null;

  elders: Elder[] = [];

  reminder: Reminder[] =[];

  newReminder: Reminder = new Reminder();

  constructor(private auth: AuthService, private elderService: ElderService, private reminderService: ReminderService){}
  ngOnInit(): void {
    this.loadElders();
    this.loadReminder();
    this.createReminder();
  }

  loadElders(){
    this.elderService.getEldersForUser().subscribe({
      next: (data) => {
        this.elders = data;
      },
      error: (err) => {
        console.log("Error loading  elders" + err);

      }
    });
  }
    loadReminder(){
      this.reminderService.getReminder().subscribe({
        next: (data) => {
          this.reminder = data;
        },
        error: (errr) => {
          console.log("Error loading reminders" + errr)
        }
      })
    }
    createReminder(){
      this.reminderService.addReminder(this.newReminder).subscribe({
        next: (newOne) => {
          this.newReminder = new Reminder();
        },
        error: (ohno) => {
          console.log("error creating reminder " + ohno)
        }
      })
    }
  }

















