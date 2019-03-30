package com.example.ooptodo;

import com.example.ooptodo.data.model.Note;
import com.example.ooptodo.domain.NotesRepository;
import com.example.ooptodo.domain.NotesUsecaseImpl;
import com.example.ooptodo.ui.NotesUsecase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class NotesUsecaseTest {
    @Mock
    private NotesRepository repository;
    private NotesUsecase testSubject;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        testSubject = new NotesUsecaseImpl(repository);
    }

    @Test
    public void GivenValidNoteWhenAddNoteIsCalledThenReturnTrue() {
        // Given
        String title = "title";
        String body = "body";
        Date date = new Date(2000, 1, 1, 1, 1, 1);
        long id = date.getTime();

        Note expectedNote = new Note(id, title, body, date);

        // When
        boolean result = testSubject.addNote(title, body, date);

        // Then
        ArgumentCaptor<Note> argument = ArgumentCaptor.forClass(Note.class);
        verify(repository).addNote(argument.capture());
        assertEquals(argument.getValue().getId(), id);
        assertEquals(argument.getValue().getTitle(), title);
        assertEquals(argument.getValue().getBody(), body);
        assertEquals(argument.getValue().getDate(), date);
    }

    @Test
    public void GivenValidNoteWhenUpdateNoteIsCalledThenReturnTrue() {
        // Given
        String title = "title";
        String body = "body";
        Date oldDate = new Date(2000, 1, 1, 1, 1, 1);
        long id = oldDate.getTime();
        Note oldNote = new Note(id, title, body, oldDate);

        Date newDate = new Date(2000, 1, 2, 1, 1, 1);

        // When
        boolean result = testSubject.updateNote(oldNote, newDate);

        // Then
        ArgumentCaptor<Note> argument = ArgumentCaptor.forClass(Note.class);
        verify(repository).updateNote(argument.capture());
        assertEquals(argument.getValue().getId(), id);
        assertEquals(argument.getValue().getTitle(), title);
        assertEquals(argument.getValue().getBody(), body);
        assertEquals(argument.getValue().getDate(), newDate);
    }
}
