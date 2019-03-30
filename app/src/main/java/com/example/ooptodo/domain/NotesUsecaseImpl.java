package com.example.ooptodo.domain;

import android.support.annotation.NonNull;

import com.example.ooptodo.data.model.Note;
import com.example.ooptodo.ui.NotesUsecase;

import java.util.Date;
import java.util.List;

public class NotesUsecaseImpl implements NotesUsecase {
    private final NotesRepository repository;

    public NotesUsecaseImpl(@NonNull final NotesRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean addNote(@NonNull final String title,
                           @NonNull final String body,
                           @NonNull final Date date) {
        final long id = date.getTime();
        final Note newNote = new Note(id, title, body, date);
        return repository.addNote(newNote);
    }

    @Override
    public boolean deleteNote(final long id) {
        return repository.deleteNote(id);
    }

    @Override
    public boolean updateNote(@NonNull final Note oldNote,
                              @NonNull final Date date) {
        final Note updatedNote = new Note(oldNote.getId(), oldNote.getTitle(), oldNote.getBody(), date);
        return repository.updateNote(updatedNote);
    }

    @Override
    public Note getNote(final int id) {
        return repository.getNote(id);
    }

    @Override
    public List<Note> getAllNotes() {
        return repository.getAllNotes();
    }
}
