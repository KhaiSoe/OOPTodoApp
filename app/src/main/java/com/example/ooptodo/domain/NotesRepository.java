package com.example.ooptodo.domain;

import com.example.ooptodo.data.model.Note;

import java.util.List;

public interface NotesRepository {

    boolean addNote(Note note);

    boolean deleteNote(long id);

    boolean updateNote(Note note);

    Note getNote(long id);

    List<Note> getAllNotes();
}
