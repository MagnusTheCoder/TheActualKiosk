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
    private String type;

    /**
     * Constructor for objects of class Journal 
     * 
     * @param caption of the journal
     * @param publisher of the journal
     * @param edition of the journal
     * @param publishDate of the journal
     */
    public Journal (String caption, String publisher, String publishDate, int edition,  String type, String price)
    {
        super(caption, publisher, publishDate, edition, price); 
                this.type = type;

    }
    public String getType()
    {
        return this.type;
    }
    
}
