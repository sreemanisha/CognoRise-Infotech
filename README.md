import java.util.ArrayList;

// Book class with title, author, and status attributes
class Book {
    private String title;
    private String author;
    private boolean checkedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.checkedOut = false; // By default, book is available
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}

// LibraryCatalog class to manage books
class LibraryCatalog {
    private ArrayList<Book> books;

    public LibraryCatalog() {
        books = new ArrayList<>();
    }

    // Add book to the catalog
    public void addBook(Book book) {
        books.add(book);
    }

    // Search books by title
    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    // Search books by author
    public ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // Check out a book
    public boolean checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isCheckedOut()) {
                book.setCheckedOut(true);
                return true; // Book checked out successfully
            }
        }
        return false; // Book not found or already checked out
    }

    // Return a book
    public boolean returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isCheckedOut()) {
                book.setCheckedOut(false);
                return true; // Book returned successfully
            }
        }
        return false; // Book not found or not checked out
    }
}

public class Main {
    public static void main(String[] args) {
        // Sample usage
        LibraryCatalog library = new LibraryCatalog();

        // Adding books
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("1984", "George Orwell"));

        // Searching by title
        ArrayList<Book> booksByTitle = library.searchByTitle("To Kill a Mockingbird");
        System.out.println("Books found by title:");
        for (Book book : booksByTitle) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }

        // Checking out a book
        boolean checkedOut = library.checkOutBook("1984");
        System.out.println("Book checked out: " + checkedOut);

        // Returning a book
        boolean returned = library.returnBook("1984");
        System.out.println("Book returned: " + returned);
    }
}
