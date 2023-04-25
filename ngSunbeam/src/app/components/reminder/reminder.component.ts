import { Component } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Reminder } from 'src/app/models/reminder';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-reminder',
  templateUrl: './reminder.component.html',
  styleUrls: ['./reminder.component.css']
})
export class ReminderComponent {

}
