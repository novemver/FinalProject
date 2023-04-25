import { AppointmentService } from './../../services/appointment.service';
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
import { catchError, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';


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

  private url = environment.baseUrl + 'api/';


  constructor(private auth: AuthService, private elderService: ElderService,
    private reminderService: ReminderService,
    private medicationService: MedicationService,
    private appointmentService: AppointmentService){}

  ngOnInit(): void {
    this.loadElders();
    this.loadReminder();
    this.createReminder();
    this.loadMedication();
    this.createMedication();
  }

  getHttpOptions() {
    let options = {
      headers: {
        Authorization: 'Basic ' + this.auth.getCredentials(),
        'X-Requested-With': 'XMLHttpRequest',
      },
    };
    return options;
  }

  loadElders(){
    this.elderService.getEldersForUser().subscribe({
      next: (data) => {
        this.elders = data;
      },
      error: (err) => {
        console.error("Error loading  elders" + err);

      }
    });
  }
    loadReminder(){
      this.reminderService.getReminder().subscribe({
        next: (data) => {
          this.reminder = data;
        },
        error: (errr) => {
          console.error("Error loading reminders" + errr)
        }
      })
    }
    createReminder(){
      this.reminderService.addReminder(this.newReminder).subscribe({
        next: (newOne) => {
          this.newReminder = new Reminder();
        },
        error: (ohno) => {
          console.error("error creating reminder " + ohno)
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
          console.error("Error loading medications" + errr)
        }
      })
    }
    createMedication(){
      this.medicationService.addMedication(this.newMedication).subscribe({
        next: (newOne) => {
          this.newMedication = new Medication();
        },
        error: (ohno) => {
          console.error("error creating Medication " + ohno)
        }
      })
    }

    deleteAppointment(appointmentId: number) {
      this.appointmentService.deleteAppointment(appointmentId).subscribe({
        next: () => {
          if (this.selected?.appointments) {
            for (let index = 0; index < this.selected?.appointments?.length; index++) {
              if (this.selected.appointments[index].id == appointmentId) {
                this.selected.appointments.splice(index,1);
              }
            }
          }
        },
        error: (didNotWork) => {
          console.log('Error handiling delete');
          console.error(didNotWork);
        },
      });
}
}
