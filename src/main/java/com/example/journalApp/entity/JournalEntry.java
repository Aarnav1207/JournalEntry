package com.example.journalApp.entity;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class JournalEntry {
    @Id
    private ObjectId id;
    private String name;
    private String content;
    private LocalDateTime date;
    
    public ObjectId getid(){
        return id;
    }
    public void setid(ObjectId id){
        this.id = id;
    }

    public String getname(){
        return name;
    }
    public void setname(String name){
        this.name = name;
    }
    

    public String getcontent(){
        return content;
    }
    public void setcontent(String content){
        this.content = content;
    }
    public LocalDateTime getdate(){
        return date;
    }
    public void setdate(LocalDateTime date){
        this.date = date;
    }
    
}
