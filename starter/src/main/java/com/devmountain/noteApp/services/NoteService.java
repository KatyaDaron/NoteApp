package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.NoteDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    //Adding a Note
    @Transactional
    void addNote(NoteDto noteDto, Long userId);

    //Deleting a Note
    @Transactional
    void deleteNoteById(Long noteId);

    //Updating a Note
    @Transactional
    void updateNoteById(NoteDto noteDto);

    //Finding all notes by User id
    List<NoteDto> getAllNotesByUserId(Long userId);

    //Getting a Note by Note id
    Optional<NoteDto> getNoteById(Long noteId);
}
