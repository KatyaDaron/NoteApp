package com.devmountain.noteApp.controllers;

import com.devmountain.noteApp.dtos.NoteDto;
import com.devmountain.noteApp.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    //Getting All Notes By User
    @GetMapping("/user/{userId}")
    public List<NoteDto> getNoteByUser(@PathVariable Long userId) {
        return noteService.getAllNotesByUserId(userId);
    }

    //Adding a new Note
    @PostMapping("/user/{userId}")
    public void addNote(@RequestBody NoteDto noteDto, @PathVariable Long userId) {
        noteService.addNote(noteDto, userId);
    }

    //Deleting a Note
    @DeleteMapping("/{noteId}")
    public void deleteNoteById(@PathVariable Long noteId) {
        noteService.deleteNoteById(noteId);
    }

    //Updating an existing Note
    @PutMapping
    public void updateNoteById(@RequestBody NoteDto noteDto) {
        noteService.updateNoteById(noteDto);
    }

    //Getting a Note by Note's id
    @GetMapping("/{noteId}")
    public Optional<NoteDto> getNoteById(@PathVariable Long noteId) {
        return noteService.getNoteById(noteId);
    }
}