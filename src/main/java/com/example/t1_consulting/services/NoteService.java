package com.example.t1_consulting.services;

import com.example.t1_consulting.models.entity.Note;
import com.example.t1_consulting.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public Note addNote(Note note) {

        return noteRepository.save(note);
    }

    public void deleteById(Integer id) {

        noteRepository.delete(id);
    }

    public List<Note> getNotes(Note note) {
        return noteRepository.getAll(note);
    }

    public Note changeNote(Note note) {
        return noteRepository.update(note);
    }

    public List<Note> getNotesLike(Note text) {
        return noteRepository.getNotesLike(text);
    }
}
