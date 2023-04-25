import { ElderService } from './../../services/elder.service';
import { Component, OnInit } from '@angular/core';
import { Elder } from 'src/app/models/elder';
import { AuthService } from 'src/app/services/auth.service';
import { User } from "src/app/models/user";
import { Appointment } from 'src/app/models/appointment';
import { Note } from 'src/app/models/note';

@Component({
  selector: 'app-client-page',
  templateUrl: './client-page.component.html',
  styleUrls: ['./client-page.component.css']
})
export class ClientPageComponent implements OnInit{

  selected: Elder | null = null;

  elders: Elder[] = [];

  constructor(private auth: AuthService, private elderService: ElderService){}
  ngOnInit(): void {
    this.loadElders();
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
}
