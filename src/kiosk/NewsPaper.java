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
public class NewsPaper extends Journal{
    String type;
    
public NewsPaper(String headline, String publisher, String publishDate, int edition, String price, String type)
{
    super(headline, publisher, publishDate, edition, price, type);
}
}
