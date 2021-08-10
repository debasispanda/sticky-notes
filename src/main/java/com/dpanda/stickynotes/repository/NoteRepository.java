package com.dpanda.stickynotes.repository;

import com.dpanda.stickynotes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {}
