package com.example.journalApp.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
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
        return journalEntryService.getAll();
    }
    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setdate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    } 

    @GetMapping("id/{myid}")
    public JournalEntry GetGenralEnrtyById(@PathVariable ObjectId myid){
        return journalEntryService.findById(myid).orElse(null); 
    }

    @DeleteMapping("id/{myid}")
    public boolean DeleteGenralEnrtyById(@PathVariable ObjectId myid){
        journalEntryService.deleteById(myid);
        return true;
    }
    @PutMapping("id/{id}")
    public JournalEntry UpdateGenralEnrtyById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry){
        JournalEntry old = journalEntryService.findById(id).orElse(null); 
        if(old != null){
            old.setname(newEntry.getname()!=null&&!newEntry.getname().equals("")? newEntry.getname():old.getname());
            old.setcontent(newEntry.getcontent()!=null&&!newEntry.getcontent().equals("")? newEntry.getcontent():old.getcontent());
        }
        journalEntryService.saveEntry(old);
        return old;
    }
}

