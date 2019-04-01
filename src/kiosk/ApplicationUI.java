/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Makes up the user interface (text based) of the application. Responsible for
 * all user interaction, like displaying the menu and receiving input from the
 * user.
 *
 * @author Gaasholt, Markus. Sperre, Linda. Stava, Magnus
 * @version 1.0
 */
public class ApplicationUI {

    // The menu that will be displayed. Please edit/alter the menu
    // to fit your application (i.e. replace "prodct" with "litterature"
    // etc.
     boolean quit = false;
    private String[] menuItems = {
        "1. Book menu",
        "2. Journal menu",
        "3. Search for books or journals", 
        "4. Publications in store"
    //            "1. List all books",
    //            "2. Add new book",
    //            "3. Remove a book",
    //            "4. Find a book by publisher",
    //            "5. Find a book by publisher and title",
    //            "6. Add a new edition to a book",
    //            "7. Convert a book to a series",
    //            "8. Add new journal",
    //            "9. List all journals",
    //            "10. Remove a journal",
    //            "11. Find a journal by publisher",
    //            "12. List all publications",
    };
    
    /**
     * Menu that will be listed for literatur of type book
     */
    private String[] menuItemsBook
            = {
                "1. List all books",
                "2. Add new book",
                "3. Remove a book",
                //                "4. Find a book by publisher",
                //                "5. Find a book by publisher and title",
                "4. Add a new edition to a book",
                "5. Convert a book to a series",
                "6. Main menu",
            };
    /**
     * Menu that will be listed for literatur of type journals
     */
    private String[] menuItemsJournal
            = {
                "1. Add new journals",
                "2. List all journals",
                "3. Remove a journal",
                "4. Main menu",
            };
    /**
     * Menu that will be listed for search methods
     */
    private String[] menuSearchfor
            = {
                "1. Search by publisher",
                "2. Search by title and publisher",
                "3. Main menu",
            };
    
    private BookList bookList = new BookList();
    private JournalList journalList = new JournalList();
    private Scanner reader;         // source of command input
    private String inputLine = null;
    private Book book;
    private Journal journal;
//    private int a;

    /**
     * Creates an instance of the ApplicationUI User interface.
     */
    public ApplicationUI() {

    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start() {
        this.init();

        //boolean quit = false;

        while (!quit) {
            try {
                int menuSelection = this.showMenu();
                switch (menuSelection) {
                    case 1:
                        this.bookStart();
                        break;

                    case 2:
                        this.journalStart();
                        break;

                    case 3:
                        this.searchStart();
                        break;

                    case 4:
                        this.totalPublication();
                        break;

                    case 5:
                        quitApplication();
                        
                        //System.out.println("\nThank you for using Application v0.1. Bye!\n");
                        
                        break;

                    default:
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nERROR: Please provide a number between 1 and " + (this.menuItems.length + 1) + "..\n");
            }

        }
    }
/**
 * 
 * @return quit as true
 */
    public boolean quitApplication() {

        System.out.println("\nThank you for using Application v0.1. Bye!\n");
        quit = true;
        return quit;
    }

    public void journalStart() {
      

        while (!quit) {
            int menuSelection = this.showJournalMenu();
            switch (menuSelection) {
                case 1:
                    this.addNewJournal();
                    break;
                case 2:
                    this.listAllJournals();
                    break;
                case 3:
                    this.removeJournal();
                    break;
                case 4:
                    this.start();
                    break;
                case 5:
                    quitApplication();
                    break;

            }

        }
    }

    /**
     *
     */
    public void searchStart() {
      
        while (!quit) {
            int menuSelection = this.showSearchMenu();
            switch (menuSelection) {
                case 1:
                    this.findPublicationByPublisher();
                    break;
                case 2:
                    this.findPublicationByPublisherAndTitle();
                    //add search by header for journals
                    break;
                case 3:
                    this.start();
                    break;
                case 4:
                    quitApplication();
                    break;
            }
        }
    }

    public void bookStart() {

        while (!quit) {
            int menuSelection = this.showBookMenu();
            switch (menuSelection) {
                case 1:
                    this.listAllBooks();
                    break;
                case 2:
                    this.addNewBook();
                    break;
                case 3:
                    this.removeBook();
                    break;

                case 4:
                    this.addAnEdition();
                    break;
                case 5:
                    this.transformBookIntoSeries();
                    break;
                case 6:
                    this.start();
                    break;
                case 7:
                    quitApplication();
                    break;
            }
        }
    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items.
     * If the user inputs anything else, an InputMismatchException is thrown.
     * The method returns the valid input from the user.
     *
     * @return The menu number (between 1 and max menu item number) provided by
     * the user.
     * @throws InputMismatchException if user enters an invalid number/menu
     * choice
     */
    private int showMenu() throws InputMismatchException {
        System.out.println("\n**** Application v0.1 ****\n");
        // Display the menu
        for (String menuItem : menuItems) {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

    /**
     *
     * @return @throws InputMismatchException
     */
    private int showBookMenu() throws InputMismatchException {
        for (String bookItem : menuItemsBook) {
            System.out.println(bookItem);
        }
        int maxMenuItemNumber = menuItemsBook.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) {
            throw new InputMismatchException();
        }
        return menuSelection;

    }

    /**
     *
     * @return @throws InputMismatchException
     */
    private int showJournalMenu() throws InputMismatchException {
        for (String journalItem : menuItemsJournal) {
            System.out.println(journalItem);
        }
        int maxMenuItemNumber = menuItemsJournal.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

    private int showSearchMenu() throws InputMismatchException {
        for (String searchFor : menuSearchfor) {
            System.out.println(searchFor);
        }
        int maxMenuItemNumber = menuSearchfor.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }
    // ------ The methods below this line are "helper"-methods, used from the menu ----
    // ------ All these methods are made privat, since they are only used by the menu ---

    /**
     * Initializes the application. Typically you would create the
     * LiteratureRegistrer-instance here
     */
    private void init() {
        System.out.println("init() was called");
    }

    /**
     * Lists all the products/literature in the register
     */
    void listAllBooks() {
        System.out.println("Books: ");
        System.out.println("___________________________");
        bookList.viewAllPublications();
        if (bookList.isEmpty()) {
            System.out.println("There are no books in the register \n");
        } else {
            System.out.println("All the books have been delivered");
            System.out.println();
        }
    }

    /**
     *
     */
    void listAllJournals() {
        System.out.println("Journals: ");
        System.out.println("___________________________");
        journalList.viewAllJournals();
        //System.out.println("yes we made it to here");
        //journalList.addMagazine(inputLine, null);
//        journalList.viewAllJournals();
        if (journalList.isEmpty()) {
            System.out.println("There are no journals in the register");
        } else {
            System.out.println("All the journals have been delivered");
        }

    }

    /**
     * Add a new product/literature to the register. In this method you have to
     * add code to ask the user for the necessary information you need to create
     * an instance of the product, which you then send as a parameter to the
     * addNewspaper()- method of the register. Remember to also handle invalid
     * input from the user!!
     */
    void addNewBook() {
        int edition = 1;

        System.out.println("The title of the book: ");
        String bookTitle = getCommand();
        if (bookList.bookExistance(bookTitle) == true) {
            System.out.println("The booktitle is already taken");
        } else {
            System.out.println("The author of the book: ");
            String bookAuthor = getCommand();
            System.out.println("The publisher of the book: ");
            String bookPublisher = getCommand();
            System.out.println("The publish-date of the book: ");
            String bookPublishDate = getCommand();
            System.out.println("Price of book: ");
            String price = getCommand();
            System.out.println("Is the book a part of a series? - Type true if correct, else type false");
            String standAlone = getCommand();
            if (standAlone.equals("true")) {
                System.out.println("The title of the series: ");
                String seriesTitle = getCommand();

                int numberOfBooksInSeries = bookList.booksInSeries(seriesTitle);

                book = new Book(bookTitle, bookAuthor, bookPublisher,
                        seriesTitle, numberOfBooksInSeries, price);
                addBook(bookTitle, book);
            } else if (standAlone.equals("false")) {
                book = new Book(bookTitle, bookAuthor, bookPublisher, bookPublishDate, edition, price);
                addBook(bookTitle, book);
            } else {
                System.out.println("the book has to be in a series (true) or not (false).");
                System.out.println("The book could not be added.");
            }
        }
    }
/**
 * Add a new product/journal to the register. 
 */
    void addNewJournal() {
        int edition = 1;
        boolean search = false;
        while(search != true)
        {
        System.out.println("Do you want to add a newspaper of magazine?");
        String journalType = getCommand();
        
        if(journalType.toUpperCase().contains("NEWSPAPER"))
        {
         System.out.println("The header of the newspaper: ");
        String journalHeader = getCommand();
        System.out.println("The publisher of the newspaper: ");
        String journalPublisher = getCommand();
        System.out.println("The publish-date of the newspaper: ");
        String journalPublishDate = getCommand();
        System.out.println("Price of newspaper: ");
        String price = getCommand();
        System.out.print("Edition: \n");
        journal = new NewsPaper(journalHeader, journalPublisher, journalPublishDate, edition, journalType, price);
        journalList.addNewsPaper(journalHeader, journal);
        search = true;
        }
        else if(journalType.toUpperCase().contains("MAGAZINE"))
        {
        System.out.println("The header of the magazine: ");
        String journalHeader = getCommand();
        System.out.println("The publisher of the magazine: ");
        String journalPublisher = getCommand();
        System.out.println("The publish-date of the magazine: ");
        String journalPublishDate = getCommand();
        System.out.println("What is the monthly subscription fee?");
        String subscriptionFee = getCommand();
        System.out.print("Edition: \n");
        journal = new Magazines(journalHeader, journalPublisher, journalPublishDate, edition, journalType, subscriptionFee);
        journalList.addMagazine(journalHeader, journal);
        search = true;
        }
       
        else
        {
            System.out.println("\nNot a valid type, choose either magazine of newspaper\n");
        }
    }
       
//            System.out.println("Is the book a part of a series? - Type true if correct, else type false");
//            String standAlone = getCommand();
//            if (standAlone.equals("true")) {
//                System.out.println("The title of the series: ");
//                String seriesTitle = getCommand();

    }

    /**
     * Adds a book to the register. Uses refactoring to avoid code-duplication.
     *
     * @param bookTitle The title of the book.
     * @param book The book value.
     */
    private void addBook(String bookTitle, Book book) {
        bookList.addBook(bookTitle, book);
        System.out.println("The book has been added.");
    }

//    private void addMagazine(String header, Journal journal) {
//        journalList.addJournal(header, journal);
//        System.out.println("Journal has been added");
//    }

    /**
     * Removes a book from the register, using the title of the book.
     */
    void removeBook() {
        System.out.println("The title of the book: ");
        String bookTitle = getCommand();
        if (bookList.containValue(bookTitle)) {
            bookList.removeBook(bookTitle);
            System.out.println("The book has been removed.\n");
        } else {
            System.out.println("The book was not found.\n");
        }
    }

    
    /**
     * Lets the user type in the book-information.
     *
     * @return The information of the book.
     */
    private String getCommand() {
        reader = new Scanner(System.in);
        String inputLine;   // will hold the full input line
       
        inputLine = reader.nextLine();
        
        return inputLine;
    }

    /**
     *
     * @param book
     */
    private void printBookInformation(Book book) {
        if (book.isStandAlone() == false) {
            System.out.println("Seriestitle:" + book.getSeriesTitle());
        }
        System.out.println("Price: "+ book.getPrice());
        System.out.println("Booktitle:" + book.getCaption());
        System.out.println("Author:" + book.getAuthor());
        System.out.println("Publisher:" + book.getPublisher());
        System.out.println("Publishdate:" + book.getPublishDate());
        if (book.isStandAlone() == false) {
            System.out.println("Books in series:" + book.getNumberOfBooksInSeries());
        } else {
            System.out.println("Edition:" + book.getEdition());
        }
    }
/**
 * 
 * @param header
 * @param publisher
 * @param publishDate
 * @param edition
 * @param journalType 
 */
     public void printJournal(String header, String publisher, String publishDate, String edition, String journalType, String price)
    {
        System.out.println("Type: " + journalType);
        System.err.println("Price: " + price);
         System.out.println ("Header: " + header);
        System.out.println ("Publisher: " + publisher);
        System.out.println ("PublishDate: " + publishDate);
        System.out.println ("Edition: " + edition);
        System.out.println();
               
    }
     
//     public void getPrice()
//     {
//         String headline = getCommand();
//         if(journalList.containValue(headline))       
//         {
//           System.out.println(+" Kroner");
//         }         
//         
//     }
     
    /**
     * 
     * @param journalList 
     */
    public void printJournall(JournalList journalList) {
        journalList.viewAllJournals();
//        System.out.println("Header: " + );
//        System.out.println("Publisher: " + journal.getPublisher());
//        System.out.println("PublishDate: " + journal.getPublishDate());
//        System.out.println("Edition: " + journal.getEdition());
//        System.out.println();
    }

    /**
     *
     */
    void findPublicationByPublisher() {
        boolean found = false;
        while (found != true) {
            System.out.println("Is publication of the type book or journal? // write either *book* or *journal*");
            String publicationType = getCommand();
            if (publicationType.toUpperCase().contentEquals("BOOK")) {
                System.out.println("Publisher of the book: ");
                String bookPublisher = getCommand();
                HashMap<String, Book> books = bookList.searchByPublisher(bookPublisher);
                if (books.isEmpty()) {
                    System.out.println("Found no books with this title.\n");
                    found = true;
                } else {
                    books.values().stream().map((book) -> {
                        printBookInformation(book);
                        return book;
                    }).forEach((_item) -> {
                        System.out.println();
                    });
                    System.out.println("All books of the requested publisher has been delivered.\n");
                    found = true;
                }
            } else if (publicationType.toUpperCase().contentEquals("JOURNAL")) {
                System.out.println("Publisher of the journal: ");
                String journalPublisher = getCommand();
                HashMap<String, Journal> journals = journalList.searchByPublisher(journalPublisher);
                if (journals.isEmpty()) {
                    System.out.println("Found no journals by this publisher.\n");
                } else {
                    journals.values().stream().map((journal) -> {
                        printJournall(journalList);
                        return journal;
                    }).forEach((_item) -> {
                        System.out.println();
                    });
                    System.out.println("All journals of the requested publisher has been delivered.\n");
                    found = true;
                }
            } else {
                System.out.println("Not a valid type. Valid types are *book* or *journal*.\n" + "Write *exit* to return to menu");
            }
            if (getCommand().toUpperCase().equals("EXIT"))
                    {
                    found = true;
                    }
        }
    }
//    /**
//     * Finds and displays the books with a given publisher.
//     * As with the addNewProduct()-method, you have to
//     * ask the user for the string (name/title/publisher)
//     * to search for, and then use this string as input-
//     * parameter to the method in the register-object.
//     * Then, upon return from the register, you need
//     * to print the details of the found item.
//     */
//    void findBookByPublisher()
//    {
//        
//        System.out.println("Publisher of the book: ");
//        String bookPublisher = getCommand();
//        HashMap<String, Book> books = bookList.searchByPublisher(bookPublisher);
//        if (books.isEmpty()) {
//            System.out.println("Found no books with this title");
//        }
//        else {
//            for (Book book : books.values()) {
//                printBookInformation(book);
//                System.out.println();
//            }
//            System.out.println("All books of the requested publisher has been delivered");
//        }
//    }
//    /**
//     * Finds and display all journals by searched publisher
//     * Asks the user for a publisher
//     * Then checks if searched publisher is listed 
//     * if true then prints out all journals by publisher
//     * if false prints out no results
//     */
//void findJournalByPublisher()
//{
//    System.out.println("Publisher of the journal: ");
//    String journalPublisher = getCommand();
//    HashMap<String, Journal> journals = journalList.searchByPublisher(journalPublisher);
//    if(journals.isEmpty())
//    {
//        System.out.println("Found no journals by this publisher.");
//    }
//        else
//        {
//                for(Journal journal : journals.values())
//                {
//                    printJournall(journal);
//                    System.out.println();
//                }
//                System.out.println("All journals of the requested publisher has been delivered");
//                
//    }
//}

    /**
     * Finds and displays the books with a given publisher and booktitle.
     */
    void findPublicationByPublisherAndTitle() {
       boolean found = false;
        while (found != true)
        {
        System.out.println("Write what publication to search for. Either journal or book\n");
        String publicationType = getCommand();
        if(publicationType.toUpperCase().equals("BOOK"))
        {
        System.out.println("Publisher of the book: ");
        String bookPublisher = getCommand();
        System.out.println("The title of the book: ");
        String bookTitle = getCommand();
        HashMap<String, Book> books = bookList.searchByPublisherAndTitle(bookPublisher, bookTitle);
        if (books.isEmpty()) {
            System.out.println("Found no books with this publisher and title\n");
        }
         else {
            books.values().stream().map((book) -> {
                printBookInformation(book);
                return book;
            }).forEach((_item) -> {
                System.out.println();
            });
            System.out.println("All books of the requested publisher and title has been delivered");
            found = true;
        }
    }
        else if(publicationType.toUpperCase().equals("JOURNAL"))
        {
         System.out.println("Publisher of the journal: ");
        String journalPublisher = getCommand();
        System.out.println("The headline of the journal: ");
        String journalHeadline = getCommand();
        HashMap<String, Journal> journals = journalList.searchByPublisherAndTitle(journalPublisher, journalHeadline);
        if (journals.isEmpty()) {
            System.out.println("Found no journals with this publisher and headline.\n");
        }
         else {
            journals.values().stream().map((journal) -> {
                printJournall(journalList);
               return journal;
            }).forEach((_item) -> {
                System.out.println();
            });
            System.out.println("All journals of the requested publisher and title has been delivered\n");
            found = true;
        }
        }
        }
    }

    /**
     * Adds an edition to a book
     */
    void addAnEdition() {
        System.out.println("The title of the book: ");
        String bookTitle = getCommand();
        if (bookList.containValue(bookTitle)) {
            if (bookList.isAlreadySeries(bookTitle) == false) {
                System.out.println("The book is in a series");
            } else {
                bookList.addEdition(bookTitle);
                System.out.println("The number of editions was increased");
            }
        } else {
            System.out.println("The book was not found.\n");
        }
    }

    /**
     * Transforms a stand-alone book into a series.
     */
    void transformBookIntoSeries() {
        System.out.println("The title of the book: ");
        String bookTitle = getCommand();
        if (bookList.containValue(bookTitle)) {
            if (bookList.isAlreadySeries(bookTitle) == false) {
                System.out.println("The book is already in a series");
            } else {
                System.out.println("The title of the book-series: ");
                String seriesTitle = getCommand();
                int numberOfBooksInSeries = bookList.booksInSeries(seriesTitle);
                bookList.convertToSeries(bookTitle, seriesTitle, numberOfBooksInSeries);
                System.out.println("The book has been converted to a series");
            }
        } else {
            System.out.println("The book was not found.\n");
        }
    }

    /**
     * Prints requested information of a standalone book in the terminal.
     *
     * @param bookTitle Is the title of the book.
     * @param author Is the author of the book.
     * @param bookPublisher Is the publisher of the book.
     * @param publishDate Is the publishdate of the book (dd.MM.YY).
     * @param edition Is the edition of the book.
     */
    public void printStandAlone(String bookTitle, String author,
            String bookPublisher, String publishDate, String edition) {
        System.out.println("Booktitle: " + bookTitle);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + bookPublisher);
        System.out.println("Publishdate: " + publishDate);
        System.out.println("Edition: " + edition);
        System.out.println();
    }

    /**
     * Prints requested information of a book in a series in the terminal.
     *
     * @param bookTitle Is the title of the book.
     * @param author Is the author of the book.
     * @param bookPublisher Is the publisher of the book.
     * @param publishDate Is the publishdate of the book (dd.MM.YY).
     * @param seriesTitle Is the title of the books series.
     * @param numberOfBooksInSeries Is the amount of books in the series.
     */
    public void printSeries(String bookTitle, String author,
            String bookPublisher, String publishDate,
            String seriesTitle, int numberOfBooksInSeries) {
        System.out.println("Seriestitle: " + seriesTitle);
        System.out.println("Booktitle: " + bookTitle);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + bookPublisher);
        System.out.println("Publishdate: " + publishDate);
        System.out.println("Books in series: " + numberOfBooksInSeries);
        System.out.println();
    }

   
    public void removeJournal() {
        System.out.println("Header of the journal");
        String journalHeader = getCommand();
        System.out.println("Publisher of journal");
        String journalPublisher = getCommand();
        if (journalList.containValue(journalHeader) ) {
            journalList.removeJournal(journalHeader);
            System.out.println("The journal has been removed.\n");
        } else {
            System.out.println("The journal was not found.\n");
        }
    }

    public void totalPublication() {
        int totalPublications;
        totalPublications = bookList.totalPublications() + journalList.totalJournal();
        if (totalPublications >= 1) {
            System.out.println("Total number of publications: " + totalPublications + "\n");
            System.out.println("Books: " + bookList.totalPublications());
            System.out.println("Journals: " + journalList.totalJournal());
        journalList.totalJournals();
        System.out.println("\n Do you want to see all details of the books and journals? // Type yes or no");
            String sure = getCommand();
            if (sure.toUpperCase().contains("YES")) {
                listAllBooks();
                listAllJournals();
            } else {
                System.out.println();
            }
        } else {
            System.out.println("There are currently no publications in store. Try again another time.\n");
        }
    }
}
