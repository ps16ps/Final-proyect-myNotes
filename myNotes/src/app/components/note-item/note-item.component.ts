import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Note } from 'src/app/models/note.model';

@Component({
  selector: 'app-note-item',
  templateUrl: './note-item.component.html',
  styleUrls: ['./note-item.component.css']
})
export class NoteItemComponent implements OnInit {

  @Input()
  note: Note;

  @Input()
  index: number;

  @Output()
  deleteNoteEvent: EventEmitter<number>; 

  constructor() {
    this.note = new Note( 0,'', '',0);
    this.index = 0;
    this.deleteNoteEvent = new EventEmitter<number>();
  }

  ngOnInit(): void {
  }

}
