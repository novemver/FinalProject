import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']

})
export class ProfileComponent implements OnInit {

  user: User = new User();


constructor(private auth: AuthService){}
  ngOnInit(): void {
   this.auth.getCredentials();
   this.auth.getUser(this.auth.getUsername()!).subscribe((user) => {
    this.user = user;

    console.log('in profile.ts get user');

   });

  }


}
