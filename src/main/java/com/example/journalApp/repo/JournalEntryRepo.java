package com.example.journalApp.repo;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.journalApp.entity.JournalEntry;


public interface JournalEntryRepo extends MongoRepository<JournalEntry,String>{

}
