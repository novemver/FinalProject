import { MedicationService } from './../../services/medication.service';
import { ElderService } from './../../services/elder.service';
import { Component, OnInit } from '@angular/core';
import { Elder } from 'src/app/models/elder';
import { AuthService } from 'src/app/services/auth.service';
import { User } from "src/app/models/user";
import { Appointment } from 'src/app/models/appointment';
import { Note } from 'src/app/models/note';
import { ReminderService } from 'src/app/services/reminder.service';
import { Reminder } from 'src/app/models/reminder';
import { Medication } from 'src/app/models/medication';


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

  newMedication: Medication = new Medication();

  medication: Medication[] =[];


  constructor(private auth: AuthService, private elderService: ElderService, private reminderService: ReminderService, private medicationService: MedicationService){}
  ngOnInit(): void {
    this.loadElders();
    this.loadReminder();
    this.createReminder();
    this.loadMedication();
    this.createMedication();
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

    deleteReminder(reminderId: number) {
      this.reminderService.destroy(reminderId).subscribe({
        next: () => {
          this.loadReminder();
        },
        error: (didNotWork) => {
          console.log('Error handiling delete');
          console.error(didNotWork);
        },
      });

    }

    loadMedication(){
      this.medicationService.getMedication().subscribe({
        next: (data) => {
          this.medication = data;
        },
        error: (errr) => {
          console.log("Error loading medications" + errr)
        }
      })
    }
    createMedication(){
      this.medicationService.addMedication(this.newMedication).subscribe({
        next: (newOne) => {
          this.newMedication = new Medication();
        },
        error: (ohno) => {
          console.log("error creating Medication " + ohno)
        }
      })
    }
  }


















