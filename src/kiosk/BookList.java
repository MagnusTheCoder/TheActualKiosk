/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import java.util.HashMap;

/**
 * Creates a list to store objects of the class Book.
 *
 * @author Gaasholt, Markus. Sperre, Linda. Stava, Magnus
 * @version v1.0
 */
public class BookList  
{
    private int total;
    private int numberOfBooks;
    private HashMap<String, Book> bookList;

    /**
     * Constructor for objects of class BookList.
     *
     */
    public BookList()
    {
        this.numberOfBooks = 0;
        bookList = new HashMap<>();
    }

    /**
     * Adds a book to the list.
     * @param bookTitle of object book
     * @param book Is of the class Book.
     */
    public void addBook(String bookTitle, Book book)
    {
        this.bookList.put(bookTitle,book);
        updateNumberOfBooks();
    }

    /**
     * Removes a book from the list.
     * @param title of book
     */
    public void removeBook(String title)
    {
        for (Book book : this.bookList.values()) {
            if (book.getCaption().toUpperCase().equals(title.toUpperCase())) {
                this.bookList.remove(title, book);
                updateNumberOfBooks();
                break;
            }
        }
    }

    
     /**
     * Checks if the hashmap booklist is empty
     * @return Returns true if booklist is empty, else returns false.
     */
    public boolean isEmpty() {
        boolean empty = false;
        if (bookList.isEmpty()) {
            empty = true;
        }
        return empty;
    }

    /**
     * Sends all current publications to printer of the class Printer.
     */
    public void viewAllBooks() {
        // int totalBooks = 0;
        this.bookList.values().stream().forEach((Book book) -> {
            ApplicationUI applicationUI = new ApplicationUI();
            String bookTitle = book.getCaption();
            String author = book.getAuthor();
            String bookPublisher = book.getPublisher();
            String publishDate = book.getPublishDate();
            String edition = book.getEdition();
            String seriesTitle = book.getSeriesTitle();
            String cost = book.getPrice();
            int numberOfBooksInSeries = booksInSeries(seriesTitle) - 1;
            boolean isStandAlone = book.isStandAlone();
            if (isStandAlone == true) {
                applicationUI.printStandAlone(bookTitle, author, bookPublisher, publishDate, edition, cost);
            } else {
                applicationUI.printSeries(bookTitle, author, bookPublisher, publishDate, seriesTitle, numberOfBooksInSeries, cost);
            }
            //totalBooks++;
        });
    }

    public int totalPublications() {
        total = BookList.this.bookList.size();
        return total;
    }

    /**
     * Checks is the hashmap booklist contains a given value
     * @param value Is the value to be checked if exists.
     * @return Returns true if the booklist contains the given value, else returns false.
     */
    public boolean containValue(String value)
    {
        boolean contains = false;
        if (bookList.containsKey(value)) {
            contains = true;
        }
        return contains;
    }

    


    /**
     * Adds an edition to a standalone book
     * @param title Is the title of the book the edition is being added to
     * @return Returns the new edition of the book
     */
    public String addEdition(String title)
    {
        String edition = "";
        for (Book book : this.bookList.values())
        {
            if (book.getCaption().toUpperCase().equals(title.toUpperCase())) {
                book.addNewEdition();
                edition = book.getEdition();
                return edition;
            }
        }
        return edition;
    }

    /**
     * Converts a standalone book to a series.
     * @param title Is the title of the book to be converted
     * @param seriesTitle Is the title of the series of the book
     * @param numberOfBooksInSeries Is the number of books with the same title of series
     */
    public void convertToSeries(String title, String seriesTitle, int numberOfBooksInSeries)
    {
        for (Book book : this.bookList.values())
        {
            if (book.getCaption().toUpperCase().equals(title.toUpperCase())) {
                if (book.isStandAlone() == true) {
                    book.convertBookToSeries(seriesTitle,numberOfBooksInSeries);
                }
            }
        }
    }

    /**
     * Checks if a book is a stand-alone book
     * @param title Is the title of the book to be checked
     * @return Returns true if the book is a stand-alone, else returns false.
     */
    public boolean isAlreadySeries(String title)
    {
        boolean trueOrFalse = false;
        for (Book book : this.bookList.values())
        {
            if (book.getCaption().toUpperCase().equals(title.toUpperCase())) {
                if (book.isStandAlone() == true) {
                    trueOrFalse = true;
                }
            }
        }
        return trueOrFalse;
    }



    /**
     * Checks the amount of books in a series
     * @param title Is the title of the series to be checked
     * @return Returns the number of books in the series
     */
    public int booksInSeries(String title) {
        int numberOfBooksInSeries = 1;
        for (Book book : this.bookList.values()) {
            String tmptitle = book.getSeriesTitle();

            if (tmptitle.toUpperCase().equals(title.toUpperCase())) {
                numberOfBooksInSeries = numberOfBooksInSeries +1;
           }
        }
        return numberOfBooksInSeries;
    }

    /**
     * Sends all current publications of the searched publisher to 
     * printer of the class Printer.
     *@return books published by searches publisher
     * @param publisher Is the searchword for the searchengine.
     */
    public HashMap<String, Book> searchByPublisher(String publisher)
    {
        HashMap<String, Book> books = new HashMap<>();
        this.bookList.values().stream().filter((book) -> (book.getPublisher().toUpperCase().equals(publisher
                .toUpperCase()))).forEach((book) -> {
                    books.put(book.getCaption(), book);
                    /*
                    ApplicationUI applicationUI = new ApplicationUI();
                    
                    String bookTitle = book.getBookTitle();
                    String author = book.getAuthor();
                    String bookPublisher = book.getPublisher();
                    String publishDate = book.getPublishDate();
                    String edition = book.getEdition();
                    String seriesTitle = book.getSeriesTitle();
                    int numberOfBooksInSeries = book.getNumberOfBooksInSeries();
                    boolean isStandAlone = book.isStandAlone();
                    
                    if (isStandAlone == true)
                    {
                    applicationUI.printStandAlone(bookTitle, author,
                    bookPublisher, publishDate, edition);
                    }
                    else
                    {
                    applicationUI.printSeries(bookTitle, author, bookPublisher,
                    publishDate, seriesTitle,
                    numberOfBooksInSeries);
                    }
                    */
                });
        return books;
    }
    
        public boolean bookExistance(String title) {
        boolean doesExist = false;
        for (Book book : this.bookList.values())
        {
            if (book.getCaption().toUpperCase().equals(title.toUpperCase())) {
                doesExist = true;
            }
        }
        return doesExist;
    }
    

    /**
     * Sends all current publications of the searched publisher and 
     * booktitle to printer of the class Printer.
     *
     * @param publisher Is the first searchword for the searchengine.
     * @param title Is the second searchword for the searchengine.
     * @return a book if publisher and title matches searchword
     */
    public HashMap<String, Book> searchByPublisherAndTitle(String publisher, String title)
    {
        HashMap<String, Book> books = new HashMap<String, Book>();
        for (Book book : this.bookList.values())
        {
            if ((book.getPublisher().toUpperCase().equals(publisher
                    .toUpperCase())) && (book.getCaption().toUpperCase()
                    .equals(title.toUpperCase())))
            {
                books.put(book.getCaption(), book);
                /*ApplicationUI applicationUI = new ApplicationUI();

                String bookTitle = book.getBookTitle();
                String author = book.getAuthor();
                String bookPublisher = book.getPublisher();
                String publishDate = book.getPublishDate();
                String edition = book.getEdition();
                String seriesTitle = book.getSeriesTitle();
                int numberOfBooksInSeries = book.getNumberOfBooksInSeries();
                boolean isStandAlone = book.isStandAlone();

                if (isStandAlone == true)
                {
                    applicationUI.printStandAlone(bookTitle, author, bookPublisher,
                            publishDate, edition);
                }
                else
                {
                    applicationUI.printSeries(bookTitle, author, bookPublisher,
                            publishDate, seriesTitle,
                            numberOfBooksInSeries);
                }*/
            }
        }
        return books;
    }

    /**
     * Updates the variable numberOfBooks with the current number of books in the list.
     */
    private void updateNumberOfBooks()
    {
        this.numberOfBooks = this.bookList.size();
    }

    /**
     * Fills the list with dummies for testing purpouses.
     */
    /*private void fillWithDummies()
    {
        this.bookList.add(new Book("A", "B1", "C", "D", 1));
        this.bookList.add(new Book("A", "B2", "C", "D", 1));
        this.bookList.add(new Book("E", "F1", "G", "H", 1));
        this.bookList.add(new Book("E", "F2", "G", "H", 1));
        this.bookList.add(new Book("Q", "W", "E", "R", 1, "T", 9));
        updateNumberOfBooks();
    }*/
}