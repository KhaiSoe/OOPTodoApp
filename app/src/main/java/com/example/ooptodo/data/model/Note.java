package com.example.ooptodo.data.model;

import android.support.annotation.NonNull;

import java.util.Date;

public class Note {
    private final long id;
    private final String title;
    private final String body;
    private final Date date;

    public Note(final long id,
            @NonNull final String title,
            @NonNull final String body,
            @NonNull final Date date) {
        this.title = title;
        this.body = body;
        this.date = date;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    @NonNull
    public String getBody() {
        return body;
    }

    @NonNull
    public Date getDate() {
        return date;
    }
}
