import { Component, OnInit } from '@angular/core';
import { Note } from 'src/app/models/note.model';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})

export class NotesComponent implements OnInit {
  note: Note
  noteList: Note[]

  constructor( private authService: AuthService) { 
  this.note = new Note( 0,'', '',0);
  this.noteList =[]
}

ngOnInit(): void {
  const userId: number = JSON.parse(localStorage.getItem('currentUser') as string).id;
  this.authService.getNotesByUserId(userId).subscribe(
    (notes) => {
      this.noteList = notes;
    }
  )
}


removeNote(id: number, index: number){
  console.log("Borrando la nota: ", id)
  this.authService.deleteNote(id).subscribe(() => {
        this.noteList.splice(index, 1);
        console.log(this.noteList);
      }
    )
  }
}
