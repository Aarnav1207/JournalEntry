package com.example.journalApp.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAll(){
        List<JournalEntry> all = journalEntryService.getAll();
        if(all!=null&&!all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry){
        try {
            myEntry.setdate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
    } 
         catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
        

    @GetMapping("id/{myid}")
    public ResponseEntity<?> GetGenralEnrtyById(@PathVariable ObjectId myid){
        Optional<JournalEntry> cont = journalEntryService.findById(myid);
        if(cont.isPresent()){
            return new ResponseEntity<>(cont.get(),HttpStatus.OK);
        } 
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myid}")
    public ResponseEntity<?> DeleteGenralEnrtyById(@PathVariable ObjectId myid){
        journalEntryService.deleteById(myid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("id/{id}")
    public ResponseEntity<JournalEntry> UpdateGenralEnrtyById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry){
        JournalEntry old = journalEntryService.findById(id).orElse(null); 
        if(old != null){
            old.setname(newEntry.getname()!=null&&!newEntry.getname().equals("")? newEntry.getname():old.getname());
            old.setcontent(newEntry.getcontent()!=null&&!newEntry.getcontent().equals("")? newEntry.getcontent():old.getcontent());
            journalEntryService.saveEntry(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }
}

