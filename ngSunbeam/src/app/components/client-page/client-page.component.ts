import { Component, OnInit } from '@angular/core';
import { Elder } from 'src/app/models/elder';
import { AuthService } from 'src/app/services/auth.service';
import { User } from "src/app/models/user";

@Component({
  selector: 'app-client-page',
  templateUrl: './client-page.component.html',
  styleUrls: ['./client-page.component.css']
})
export class ClientPageComponent implements OnInit{

  user: User = new User();
  elder: Elder = new Elder();

  constructor(private auth: AuthService){}
  ngOnInit(): void {
   this.auth.getCredentials();
   this.auth.getUser(this.auth.getUsername()!).subscribe((user) => {
    this.user = user;
   });

  }
}
