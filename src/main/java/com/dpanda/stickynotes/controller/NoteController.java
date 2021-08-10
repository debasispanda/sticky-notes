package com.dpanda.stickynotes.controller;

import com.dpanda.stickynotes.model.Note;
import com.dpanda.stickynotes.model.NoteRequest;
import com.dpanda.stickynotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<Note> getNotes() {
        return noteService.getNotes();
    }

    @GetMapping("/{id}")
    public Optional<Note> getNote(@PathVariable("id") Long id) {
        return noteService.getNote(id);
    }

    @PostMapping
    public void saveNote(@RequestBody NoteRequest note) {
        noteService.saveNote(note);
    }

    @PutMapping("/{id}")
    public void updateNote(@PathVariable("id") Long id, @RequestBody NoteRequest note) {
        noteService.updateNote(id, note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable("id") Long id) {
        noteService.deleteNote(id);
    }
}
