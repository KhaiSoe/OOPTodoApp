package com.example.ooptodo.ui;

import com.example.ooptodo.data.model.Note;

import java.util.Date;
import java.util.List;

public interface NotesUsecase {

    boolean addNote(String title,
                    String body,
                    Date date);

    boolean deleteNote(long id);

    boolean updateNote(Note note,
                       Date date);

    Note getNote(int id);

    List<Note> getAllNotes();
}
