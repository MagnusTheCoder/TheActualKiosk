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
    private int totalNewsPaper;
    private int totalMagazines;
    private HashMap<String, Journal> journalList;
    private HashMap<String, Magazines> magazineList;
    private HashMap<String, NewsPaper> newsPaperList;
    private int numberOfJournals;

    /**
 * Constructor for object of class JournalList
 */
public JournalList()
{
    this.numberOfJournals = 0;
    journalList = new HashMap<>();   
//    magazineList = new HashMap<>();
//    newsPaperList = new HashMap<>();
}


/**
 * 
 * @param headline
 * @param magazines 
 */
public void addMagazine(String headline, Journal journal)
{
    this.journalList.put(headline, journal);
    totalMagazines++;
}
/**
 * 
 * @param headline
 * @param newsPaper 
 */
public void addNewsPaper(String headline, Journal journal)
{
    this.journalList.put(headline, journal);
    totalNewsPaper++;
}
///**
// * Add a journal to HashMap journalList
// * @param header of journal
// * @param journal of type journal
// */
//public void addJournal(String header, Journal journal)
//{
//    this.journalList.put(header, journal);
//    updateNumberOfJournals();
//    
//}


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


public HashMap<String, Journal> searchByPublisherAndTitle(String publisher, String headLine)
    {
        HashMap<String, Journal> journals = new HashMap<String, Journal>();
        for (Journal journal : this.journalList.values())
        {
            if ((journal.getPublisher().toUpperCase().equals(publisher
                    .toUpperCase())) && (journal.getCaption().toUpperCase()
                    .equals(headLine.toUpperCase())))
            {
                journals.put(journal.getCaption(), journal);              
            }
        }
        return journals;
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
  this.journalList.values().stream().forEach((Journal)->
  {
      ApplicationUI applicationUI = new ApplicationUI();
      
      String header = Journal.getCaption();
      String publisher = Journal.getPublisher();
      String publishDate = Journal.getPublishDate();
      String edition = Journal.getEdition();
      String journalType = Journal.getType();
      String price = Journal.getPrice();
       applicationUI.printJournal(header, publisher, publishDate, edition, journalType, price);
    });

}
public int totalJournal()
{
    return journalList.size();
}
public void totalJournals()
{
    System.out.println("                     "+"Magazines: "+totalMagazines+"\n"+"                     "+"Newspapers: "+totalNewsPaper);
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
    
    
 /**
     * Checks the amount of books in a series
     * @param title Is the title of the series to be checked
     * @return Returns the number of books in the series
     */
    public int journalEditions(String edition)
    {
        int editions = 1;
        for(Journal journal : this.journalList.values())
        {
            String jPublisher = journal.getPublisher();
            if(jPublisher.toUpperCase().equals(edition.toUpperCase()))
            {
                editions +=1;
            }
        }
        return editions;
    }

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

