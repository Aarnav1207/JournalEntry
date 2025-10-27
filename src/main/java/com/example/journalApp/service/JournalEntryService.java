package com.example.journalApp.service;

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
}
