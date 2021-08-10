package com.dpanda.stickynotes.service;

import com.dpanda.stickynotes.model.Note;
import com.dpanda.stickynotes.model.NoteRequest;
import com.dpanda.stickynotes.model.User;
import com.dpanda.stickynotes.repository.NoteRepository;
import com.dpanda.stickynotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNote(Long id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isPresent()) {
            return note;
        } else {
            throw new IllegalStateException("Note is not available");
        }
    }

    public void saveNote(NoteRequest note) {
        User user = userRepository.getOne(note.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("Invalid user id!");
        }

        Note userNote = new Note(
                note.getTitle(),
                note.getContent(),
                new Date(),
                new Date(),
                user
        );
        noteRepository.save(userNote);
    }

    public void updateNote(Long id, NoteRequest note) {
        boolean exists = noteRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Note doesn't exist!");
        }
        Note existingNote = noteRepository.getOne(id);
        existingNote.setTitle(note.getTitle());
        existingNote.setContent((note.getContent()));
        existingNote.setModified(new Date());
        noteRepository.save(existingNote);
    }

    public void deleteNote(Long id) {
        boolean exists = noteRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Note doesn't exist!");
        }
        noteRepository.deleteById(id);
    }
}
