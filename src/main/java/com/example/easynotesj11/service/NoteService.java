package com.example.easynotesj11.service;

import com.example.easynotesj11.model.Note;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class NoteService {
    private List<Note> noteList = new ArrayList<>();
    private long nextId = 1;

    public void addNote(Note note) {
        note.setId(nextId++);
        noteList.add(note);
    }

    public List<Note> getAllNotes() {
        return noteList;
    }

    public boolean editNote(Long id, Note updatedNote) {
        for (Note note : noteList) {
            if (Objects.equals(note.getId(), id)) {
                note.setTitle(updatedNote.getTitle());
                note.setContent(updatedNote.getContent());
                return true;
            }
        }
        return false;
    }

    public boolean deleteNote(Long id) {
        Note noteToRemove = null;
        for (Note note : noteList) {
            if (Objects.equals(note.getId(), id)) {
                noteToRemove = note;
                break;
            }
        }
        if (noteToRemove != null) {
            noteList.remove(noteToRemove);
            return true;
        }
        return false;
    }
}
