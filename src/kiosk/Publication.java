/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;
import java.util.Calendar;
/**
 *
 * @author stava
 */
public class Publication 
{
private String publisher;
private String caption;
private String publishDate; //dd.MM.YY
private  int edition;
private String price;
//Calendar PublicationCal = Calendar.getInstance();

    public Publication(String caption, String publisher,String publishDate, int edition, String price) 
    {
         if (caption != null ) 
         {
            this.caption = caption;
        }
        else 
         {
            this.caption = "INVALID VALUE";
        }
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.edition = edition;
        this.price = price;
    }
/**
 * Returns the price of publication
 * @return the price of publication
 */
    public String getPrice()
    {
        return this.price;
    }
    
    /**
     * Returns the publisher of the publication.
     * @return The publisher of the publication.
     */
    public String getPublisher() 
    {
        return this.publisher;
    }

    /**
     * Return the header of the publication
     * @return header of the publication
     */
    public String getCaption()
    {
        return this.caption;
    }

    
    /**
     * Returns the publishdate of the publication.
     * @return The publishdate of the publication.
     */
    public String getPublishDate() 
    {
        return this.publishDate;
    }
    
    /**
     * Returns the edition of the publication.
     * @return The edition of the publication.
     */
    public String getEdition() {
        String edition = this.edition + ". Edition";
        return edition;
    }
    //TODO add edition method to superclass
    //
    
      /**
     * Increases the editionnumber by one.
     * @return new edition
     */
    public int addNewEdition()
    {
       return edition++;
    }
    
    /**
     * 
     * @param caption of publication who is to be removed
     */
//    public void removePublication(String caption)
//    {
//        for()
//        {
//            if()
//            {
//            break;    
//            }
//            
//        }
//    
}
