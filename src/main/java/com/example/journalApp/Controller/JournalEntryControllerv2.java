package com.example.journalApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.service.JournalEntryService;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerv2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return null;
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntryService.saveEntry(myEntry);
        return true;
    } 

    @GetMapping("id/{myid}")
    public JournalEntry GetGenralEnrtyById(@PathVariable long myid){
        return null;
    }

    @DeleteMapping("id/{myid}")
    public JournalEntry DeleteGenralEnrtyById(@PathVariable long myid){
        return null;
    }
    @PutMapping("id/{id}")
    public JournalEntry UpdateGenralEnrtyById(@PathVariable long id, @RequestBody JournalEntry myEntry){
        return null;
    }
}

