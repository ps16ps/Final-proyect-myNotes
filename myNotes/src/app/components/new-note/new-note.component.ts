import { Component, OnInit } from '@angular/core';
import { Note } from 'src/app/models/note.model';
import { AuthService } from 'src/app/services/auth.service';
import { User } from 'src/app/models/user.model';
@Component({
  selector: 'app-new-note',
  templateUrl: './new-note.component.html',
  styleUrls: ['./new-note.component.css']
})
export class NewNoteComponent implements OnInit {

  note: Note
  noteList: Note[]

  constructor( private authService: AuthService) { 
      this.note = new Note( 0,'', '',0);
      this.noteList =[]
  } 

  ngOnInit(): void {
  }

  onSubmit() {
    const userId: number = JSON.parse(localStorage.getItem('currentUser') as string).id;
    console.log(userId)
    this.note.userId = userId;
    console.log(this.note)
    this.authService.addNote(this.note).subscribe((note) =>{
      this.noteList.push(note);
    });
  }
}
