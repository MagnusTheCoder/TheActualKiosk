/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

/**
 * Represents a book by booktitle, author, publisher, publishdate and 
 * edition. If the book is in a series it is also represented by seriestitle and 
 * the number of books in the series.
 *
 * @author Gaasholt, Markus. Sperre, Linda. Stava, Magnus
 * @version v1.1
 */
public class Book extends Publication
{
   // private String bookTitle;
    private String author;
//    private String publisher;
//    private String publishDate; //dd.MM.YY
   
    private String seriesTitle;
    private int numberOfBooksInSeries;
    private boolean standAlone;

    /**
     * Constructor for objects of class Book who is standalone.
     *
     * @param title is the title of the book.
     * @param author is the author of the book.
     * @param publisher is the publisher of the book.
     * @param publishDate is the publishdate of the book (dd.MM.YY).
     * @param edition is the edition of the book.
     */
    public Book(String title, String author, String publisher,
               String publishDate , int edition, String price)
    {
        super(title, publisher, publishDate, edition, price);
//        if (bookTitle != null ) {
//            this.bookTitle = bookTitle;
//        }
//        else {
//            this.bookTitle = "INVALID VALUE";
//        }
        this.author = author;
//        this.publisher = publisher;
//        this.publishDate = publishDate;
        this.seriesTitle = "";
//        this.edition = edition;
        this.standAlone = true;
    }

    /**
     * Constructor for objects of class Book who is in a series.
     *
     * @param bookTitle is the title of the book.
     * @param author is the author of the book.
     * @param publisher is the publisher of the book.
     * @param publishDate is the publishdate of the book (dd.MM.YY).
     * @param seriesTitle is the title of the books series.
     * @param numberOfBooksInSeries is the amount of books in the series.
     */
    public Book(String caption, String author, String publisher,
                 String seriesTitle, int numberOfBooksInSeries,String publishDate, int edition, String price)
    {
 super(caption, publisher, publishDate, edition, price);
        this.author = author;
        this.seriesTitle = seriesTitle;
        this.numberOfBooksInSeries = numberOfBooksInSeries;
        this.standAlone = false;
    }

//    /**
//     * Returns the title of the book.
//     * @return The title of the book.
//     */
//    public String getBookTitle()
//    {
//        return this.bookTitle;
//    }

    /**
     * Returns the author of the book.
     * @return The author of the book.
     */
    public String getAuthor()
    {
        return this.author;
    }


    /**
     * Returns the title of the series.
     * @return The title of the series.
     */
    public String getSeriesTitle()
    {
        return this.seriesTitle;
    }

    /**
     * Returns the number of books in the series.
     * @return The number of books in the series.
     */
    public int getNumberOfBooksInSeries()
    {
        return this.numberOfBooksInSeries;
    }

    /**
     * Returns true if the book is standalone. if not, it returns false.
     * @return True if the book is standalone. if not, it returns false.
     */
    public boolean isStandAlone()
    {
        return this.standAlone;
    }

    /**
     * Converts a standalone book to a book in a series.
     * @param seriesTitle Is the title of the books series.
     * @param numberOfBooksInSeries Is the amount of books in the series.
     */
    public void convertBookToSeries(String seriesTitle, int numberOfBooksInSeries)
    {
        this.seriesTitle = seriesTitle;
        this.numberOfBooksInSeries = numberOfBooksInSeries;
        this.standAlone = false;
    }

    /**
     * Increases the editionnumber by one.
     */
//    public void addNewEdition()
//    {
//        this.edition++;
//    }

    /**
     * Increases the number og books in the series by one.
     */
    public void addNumberOfBooksInSeries()
    {
        this.numberOfBooksInSeries++;
    }
    
//     /**
//     * Returns the edition of the book.
//     * @return The edition of the book.
//     */
//    public String getEdition() {
//        String edition = this.edition + ". Edition";
//        return edition;
//    }
}