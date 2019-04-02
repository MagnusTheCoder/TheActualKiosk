/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

/**
 *
 * @author stava
 */
public class Magazines extends Journal{
    
    //int totalMagazines;
    /**
     *
     * @param headline of the magazine
     * @param publisher of the magazine
     * @param publishDate of the magazine
     * @param edition of the magazine
     * @param subscriptionFee of the magazine
     * @param type of journal
     */
    public Magazines(String headline, String publisher, String publishDate, int edition, String subscriptionFee, String type)
            {
                super(headline, publisher, publishDate, edition, subscriptionFee, type);
              
//                totalMagazines++;
            }
    /**
     * 
     * @return the monthly sybscriptionFee for the magazine
     */
     

// /**
//  * 
//  * @return 
//  */
// public int totalMagazines()
// {
//     return this.totalMagazines;
// }
}
