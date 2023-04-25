
import { User } from './../../models/user';
import { Component } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';




@Component({
  selector: 'app-appointments',
  templateUrl: './appointments.component.html',
  styleUrls: ['./appointments.component.css']
})
export class AppointmentsComponent {


user: User = new User;
constructor(private auth: AuthService){}


// ngOnInIt(): void {
//   this.auth.getCredentials();
//   this.auth.getUser(this.auth.getUserAppointment()!).subscribe((user) => {
//     this.user = user;
//   });
// }

}
