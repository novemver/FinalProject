



import { Component, OnInit } from "@angular/core";
import { User } from "src/app/models/user";
import { AuthService } from "src/app/services/auth.service";
import { UserService } from "src/app/services/user.service";




@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']

})
export class ProfileComponent implements OnInit {

  user: User = new User();
  users: User[]= [];
  editUser = new User();

  constructor(private auth: AuthService, private userService: UserService){

  }
  ngOnInit(): void {
   this.auth.getCredentials();
   this.auth.getUser(this.auth.getUsername()!).subscribe((user) => {
    this.user = user;
   });

  }

  updateUser() {
    this.userService.update(this.editUser).subscribe({
      next:(data: any) => {
        this.auth.getLoggedInUser().subscribe({
          next: (user: User) => {
            this.user = user;
            this.editUser = user;
          },
          error: (nojoy) => {
            console.log(nojoy);
          }
         });
       },
      error: (boom: string) => { console.error('Error retrieving user from userService: ' + boom);}
      });
  }

  bindUser(){
    this.editUser = Object.assign({},this.user);
  }
}
