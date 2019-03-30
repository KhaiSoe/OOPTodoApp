package com.example.ooptodo.domain;

import android.support.annotation.NonNull;

import com.example.ooptodo.data.model.Note;
import com.example.ooptodo.ui.NotesUsecase;

import java.util.Date;
import java.util.List;

/**
 * Usecase implementation of my note app. See how all my logic and model creation is done here.
 * Everything is then passed to my repository.
 * Also, check the tests I wrote for this class.
 */
public class NotesUsecaseImpl implements NotesUsecase {
    private final NotesRepository repository;

    public NotesUsecaseImpl(@NonNull final NotesRepository repository) {
        this.repository = repository;
    }

    /**
     * Adding a new note to our repository isn't hard, but it does require passing in a Date instead
     * of instantiating one within. If you instantiate it inside, you'll have a hard time testing
     * as the Date will be different everytime you run the test.
     * My id is just the initial Date when the note was created. This does NOT change when the note is updated.
     *
     * @param title Title of my note
     * @param body  Body of my note
     * @param date  The current date. See that I'm passing it in as it makes testing easier.
     */
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

    /**
     * Even though my method is "updateNote", you can see I'm not "updating" my old note.
     * In fact, I'm creating a completely new one. This is called defensive copying and is used to
     * prevent mutability. (Effective Java 3rd Edition: Item 50)
     *
     * @param oldNote The note I'm editing
     * @param date    The current date.
     */
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
