import { User } from './../../models/user';
import { Component, OnInit } from '@angular/core';
import { Appointment } from 'src/app/models/appointment';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-appointments',
  templateUrl: './appointments.component.html',
  styleUrls: ['./appointments.component.css'],
})
export class AppointmentsComponent implements OnInit {
  title: String = 'Sunbeam Appointments';
  /// Fields ///
  newAppointment = new Appointment();
  editAppointment: Appointment | null = null;
  selected: Appointment | null = null;
  user: User = new User();

  /// Methods ///
  constructor(private auth: AuthService) {}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  // ngOnInIt(): void {
  //   this.auth.getCredentials();
  //   this.auth.getUser(this.auth.getUserAppointment()!).subscribe((user) => {
  //     this.user = user;
  //   });
  // }
}
