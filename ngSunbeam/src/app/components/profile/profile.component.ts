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


constructor(private auth: AuthService){}
  ngOnInit(): void {
   this.auth.getCredentials();
   this.auth.getUser(this.auth.getUsername()!).subscribe((user) => {
    this.user = user;
   });

  }

  // user: User = new User();
  // userService: any;
  // editUser = new User();

  // constructor(private authService: AuthService){}

  // ngOnInit(): void {
  //   this.loadUser();


  // }



  // loadUser() {
  //   this.userService.getUserByUsername().subscribe(
  //     data => { this.editUser = data;
  //       // console.log("The password value is: " + data.password);
  //       this.editUser.password = '';
  //       this.user = data;
  //     },

  //     error => { console.error('Error retrieving user from userService: ' + error);}
  //   );
  // }


  // updateUser(user: User) {
  //   console.log('Entering updateUser from ProfileComponent, Username: ' + user.username + ' Password: ' + user.password);
  //   this.userService.updateUser(user).subscribe(
  //     () => {
  //     this.authService.logout();

  //     this.authService.login(user.username, user.password).subscribe(
  //      () => {
  //        console.log('Logged in')
  //      },
  //      () => {
  //        console.error('Error logging back in.')
  //      }
  //     );
  //      },

  //     error => { console.error('Error retrieving user from userService: ' + error);}
  //   );
  // }


}
