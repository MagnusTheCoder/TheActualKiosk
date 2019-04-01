/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import java.util.HashMap;

/**
 *Creates a list to store objects of the class Journal
 * @author stava
 * @version v1.1
 */
public class JournalList 
{
    private int total;
    private HashMap<String, Journal> journalList;
    private int numberOfJournals;

    /**
 * Constructor for object of class JournalList
 */
public JournalList()
{
    this.numberOfJournals = 0;
    journalList = new HashMap<>();    
}
/**
 * Add a journal to HashMap journalList
 * @param header of journal
 * @param journal of type journal
 */
public void addJournal(String header, Journal journal)
{
    this.journalList.put(header, journal);
    updateNumberOfJournals();
    
}

public void removeJournal(String headline)
{
    for (Journal journal : this.journalList.values())
    {
        if(journal.getCaption().toUpperCase().equals(headline.toUpperCase()))
        {
            this.journalList.remove(headline, journal);
            updateNumberOfJournals();
            break;
        }
    }
}

    /**
     * Checks is the hashmap journallist contains a given value
     * @param value Is the value to be checked if exists.
     * @return Returns true if the journallist contains the given value, else returns false.
     */
    public boolean containValue(String value)
    {
        boolean contains = false;
        if (journalList.containsKey(value)) {
            contains = true;
        }
        return contains;
    }

/**
 * Updates number of journals when adding another journal
 */
private void updateNumberOfJournals()
{
    this.numberOfJournals = numberOfJournals++;
}
/**
 * 
 */
public void viewAllJournals()
{
  this.journalList.values().stream().forEach((journal)->
  {
      ApplicationUI applicationUI = new ApplicationUI();
      
      String header = journal.getCaption();
      String publisher = journal.getPublisher();
      String publishDate = journal.getPublishDate();
      journalExistance(header);
      String edition = journal.getEdition();
      
       applicationUI.printJournall(journal);
    });
}

public int totalJournals()
{
    total = JournalList.this.journalList.size();
    return total;
}
 /**
  * 
  * @param header
  * @return 
  */
  public boolean journalExistance(String header)
  {
      boolean doesExist = false;
        for (Journal journal : this.journalList.values())
        {
            if (journal.getCaption().toUpperCase().equals(header.toUpperCase())) {
                doesExist = true;
            }
        }
        return doesExist;
  }
 
    
 /**
     * Sends all current publications of the searched publisher to 
     * printer of the class Printer.
     *@return journal published by searched publisher
     * @param publisher Is the searchword for the searchengine.
     */
    public HashMap<String, Journal> searchByPublisher(String publisher)
    {
        HashMap<String, Journal> journals = new HashMap<>();
        this.journalList.values().stream().filter((journal) -> (journal.getPublisher().toUpperCase().equals(publisher
                .toUpperCase()))).forEach((journal) -> {
                    journals.put(journal.getCaption(), journal);
                    
                });
        return journals;
}
    
//    public void addEdition()
//    {
//        
//    }
    
    public boolean isEmpty()
    {
        boolean empty = false;
        if (this.journalList.isEmpty())
                {
                   empty = true;
                }
        return empty;
    }
}

