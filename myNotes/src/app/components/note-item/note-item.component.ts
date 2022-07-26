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
  removeNoteEvent: EventEmitter<number>; 

  constructor() {
    this.note = new Note( 0,'', '',0);
    this.index = 0;
    this.removeNoteEvent = new EventEmitter<number>();
  }

  ngOnInit(): void {
    console.log(this.note.id)
  }

  deleteNote(): void {
    this.removeNoteEvent.emit(Number(this.note.id));
  }

  showModal(){
    const modal = document.getElementById(`note-item-modal-${this.note.id}`)
    if(modal) {
      modal.classList.remove("note-item-component-modal--hide")
      modal.classList.add("note-item-component-modal--show")
    }
  }

  hideModal() {
    const modal = document.getElementById(`note-item-modal-${this.note.id}`)
    if(modal) {
      modal.classList.add("note-item-component-modal--hide")
      modal.classList.remove("note-item-component-modal--show")
    }
  }
}
