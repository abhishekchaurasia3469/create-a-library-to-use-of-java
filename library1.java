
     /*
     create a library management system which is capable of issusing to the students.
     Book should have info like :
     1 . Book name 
     2 . Book Author
     3 . Issused to4 . Issued on
     user should be able to add books , return Issused books , issuse books
     Assume that all the user are registred with their names in the central datebase
     */

import java.util.ArrayList;
import java.util.Date;

// -------- Book Class --------
class Book {
    String name;
    String author;
    String issuedTo;
    Date issuedOn;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.issuedTo = null;
        this.issuedOn = null;
    }

    public boolean isIssued() {
        return issuedTo != null;
    }
}

// -------- Library Class --------
class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(String name, String author) {
        books.add(new Book(name, author));
        System.out.println("Book Added Successfully!");
    }

    public void issueBook(String bookName, String studentName) {

        for (Book b : books) {

            if (b.name.equalsIgnoreCase(bookName)) {

                if (b.isIssued()) {
                    System.out.println("Book already issued to " + b.issuedTo);
                } 
                else {
                    b.issuedTo = studentName;
                    b.issuedOn = new Date();
                    System.out.println("Book issued to " + studentName);
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }
}

// -------- Main Class --------
public class library1 {

    public static void main(String[] args) {

        Library lib = new Library();

        lib.addBook("Java Programming", "James Gosling");
        lib.addBook("Data Structures", "Mark Weiss");

        lib.issueBook("Java Programming", "Amit");
    }
}