/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

/**
 *Represents a journal by header, publisher, publishdate and
 * edition. Differentiate between newspaper and magazines
 * @author stava
 * @version v1.1
 */
public class Journal extends Publication
{
    //Represents journal headline
    private String header;
    //Check if journal is newspaper
    private boolean newsPaper;

    /**
     * Constructor for objects of class Journal 
     * 
     * @param header
     * @param publisher
     * @param publishDate 
     */
    public Journal (String caption, String publisher, String publishDate, int edition)
    {
        super(caption, publisher, publishDate, edition);
          
    }
    
    
        
//    /**
//     * Return the header of the journal
//     * @return header of the journal
//     */
//    public String getCaption()
//    {
//        return this.caption;
//    }

}
