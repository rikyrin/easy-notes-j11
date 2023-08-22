package com.example.easynotesj11.controller;

import com.example.easynotesj11.model.Note;
import com.example.easynotesj11.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public ResponseEntity<String> addNote(@RequestBody Note note){
        noteService.addNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).body("Nota creada con exito");
    }
    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editNote(@PathVariable Long id, @RequestBody Note note) {
        boolean success = noteService.editNote(id, note);
        if (success) {
            return ResponseEntity.ok("Note updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Long id) {
        boolean success = noteService.deleteNote(id);
        if (success) {
            return ResponseEntity.ok("Note deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
