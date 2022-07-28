import { Component, OnInit } from '@angular/core';
import { Note } from 'src/app/models/note.model';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-note',
  templateUrl: './new-note.component.html',
  styleUrls: ['./new-note.component.css']
})
export class NewNoteComponent implements OnInit {

  note: Note
  noteList: Note[]

  constructor( private authService: AuthService, private router: Router) { 
      this.note = new Note( 0,'', '',0);
      this.noteList = [];
  } 

  ngOnInit(): void {
  }

  onSubmit() {
    const userId: number = JSON.parse(localStorage.getItem('currentUser') as string).id;
    this.authService.addNote(this.note.name, this.note.content, userId).subscribe((note) =>{
      this.noteList.push(note);
      this.note = new Note( 0,'', '', 0);
      this.router.navigate(['/notes']);
    });
  }
}
