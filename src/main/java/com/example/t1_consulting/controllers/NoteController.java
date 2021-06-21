package com.example.t1_consulting.controllers;

import com.example.t1_consulting.models.entity.Note;
import com.example.t1_consulting.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;


    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addNote(@RequestBody Note note) {
        final Note result = noteService.addNote(note);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity changeNote(@RequestBody Note note) {

        final Note result = noteService.changeNote(note);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        noteService.deleteById(id);
        return ResponseEntity.ok().body(id);
    }


    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Note> getNotes(@RequestBody Note note) {
        return noteService.getNotes(note);
    }

    @PostMapping(value = "/like", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Note> getNotesLike(@RequestBody Note text) {
        return noteService.getNotesLike(text);
    }

}
