package com.example.journalApp.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.repo.JournalEntryRepo;

@Component
public class JournalEntryService {


    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public void saveEntry(JournalEntry journalEntry){
            journalEntryRepo.save(journalEntry);
    }
    public List<JournalEntry> getAll(){
        return journalEntryRepo.findAll();
    }
    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepo.findById(id);
    }
    public void deleteById(ObjectId id){
        journalEntryRepo.deleteById(id);
    }
}
