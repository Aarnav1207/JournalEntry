package com.example.journalApp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class JournalEntry {
    @Id
    private String id;
    private String name;
    private String content;
    
    public String getid(){
        return id;
    }
    public void setid(String id){
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
    
}
