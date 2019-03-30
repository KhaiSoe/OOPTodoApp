package com.example.ooptodo.data;

import com.example.ooptodo.data.model.Note;
import com.example.ooptodo.domain.NotesRepository;

import java.util.List;

public class NotesRepositoryImpl implements NotesRepository {

    @Override
    public boolean addNote(Note note) {
        return false;
    }

    @Override
    public boolean deleteNote(long id) {
        return false;
    }

    @Override
    public boolean updateNote(Note note) {
        return false;
    }

    @Override
    public Note getNote(long id) {
        return null;
    }

    @Override
    public List<Note> getAllNotes() {
        return null;
    }
}
