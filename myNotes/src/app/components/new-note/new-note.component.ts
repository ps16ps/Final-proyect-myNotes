import { Component, OnInit } from '@angular/core';
import { Note } from 'src/app/models/note.model';

@Component({
  selector: 'app-new-note',
  templateUrl: './new-note.component.html',
  styleUrls: ['./new-note.component.css']
})
export class NewNoteComponent implements OnInit {

  note: Note

  constructor() { 
    this.note = new Note( 0,'', '',0);
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    console.log(this.note);
  }

}
