import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Available: " + available;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void displayAllBooks() {
        System.out.println("All Books in the Library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class LibraryBookTracker {
    public static void main(String[] args) {
        Library library = new Library();

        // Add some sample books to the library
        library.addBook(new Book("Java Programming", "John Doe"));
        library.addBook(new Book("Python for Beginners", "Jane Smith"));
        library.addBook(new Book("Data Structures and Algorithms", "Alice Johnson"));
        library.addBook(new Book("DBMS", "Oracle"));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Book Tracker Menu:");
            System.out.println("1. Search for a Book");
            System.out.println("2. View All Books");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the book you want to search for: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = library.findBook(searchTitle);

                    if (foundBook != null) {
                        System.out.println("Book Found:");
                        System.out.println(foundBook);
                    } else {
                        System.out.println("Book not found in the library.");
                    }
                    break;

                case 2:
                    library.displayAllBooks();
                    break;

                case 3:
                    System.out.println("Exiting Library Book Tracker. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }

        scanner.close();
    }
}
