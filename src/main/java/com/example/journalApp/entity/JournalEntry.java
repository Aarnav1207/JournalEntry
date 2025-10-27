package com.example.journalApp.entity;

public class JournalEntry {
    private long id;
    private String name;
    private String content;
    
    public long getid(){
        return id;
    }
    public void setid(long id){
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
