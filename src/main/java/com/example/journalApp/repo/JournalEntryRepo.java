package com.example.journalApp.repo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.journalApp.entity.JournalEntry;


public interface JournalEntryRepo extends MongoRepository<JournalEntry,ObjectId>{

}
