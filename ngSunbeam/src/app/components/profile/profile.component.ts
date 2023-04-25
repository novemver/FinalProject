



import { Component, OnInit } from "@angular/core";
import { User } from "src/app/models/user";
import { AuthService } from "src/app/services/auth.service";




@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']

})
export class ProfileComponent implements OnInit {

  user: User = new User();
  users: User[]= [];
  userService: any;
  editUser = new User();

  constructor(private auth: AuthService){}
  ngOnInit(): void {
   this.auth.getCredentials();
   this.auth.getUser(this.auth.getUsername()!).subscribe((user) => {
    this.user = user;
   });

  }
  loadUser() {
    this.userService.getUserByUsername().subscribe(
      {
        next: (userList: User[]) => {
          this.users = userList;
        },
        error: (failure: any) => {
          console.error('Error getting user list from service');
          console.log(failure);
        },
      }
    );
  }


  updateUser(user: User) {
    console.log('Entering updateUser from ProfileComponent, Username: ' + user.username + ' Password: ' + user.password);
    this.userService.update(user).subscribe({
      next:(data: any) => {
        this.auth.getLoggedInUser().subscribe({
          next: (user: User) => {
            this.user = user;
            this.reload();
          },
          error: (nojoy) => {
            console.log(nojoy);
          }

         });


       },

      error: (boom: string) => { console.error('Error retrieving user from userService: ' + boom);}
      });
  }

  reload(){
    this.userService.index().subscribe({
      //when the next piece of data arrives- without error my todos will go here
      next: (user: User)=>{ this.user = user},
      // or when it goes wrong
      error: (failure: any)=> {
        console.error('Error getting Todo List');
        console.error(failure);
      }
    });

  }



}
