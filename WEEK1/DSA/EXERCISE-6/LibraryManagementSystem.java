import java.util.Arrays;
import java.util.Scanner;

// Book class representing a book with attributes
class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + "]";
    }
}

// LibraryManagementSystem class for managing books and searching
public class LibraryManagementSystem {
    private Book[] books;
    private int size;

    public LibraryManagementSystem(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public void addBook(Book book) {
        if (size < books.length) {
            books[size++] = book;
            Arrays.sort(books, 0, size, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
        } else {
            System.out.println("Library is full.");
        }
    }

    // Linear Search for finding a book by title
    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book != null && book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Binary Search for finding a book by title (sorted list required)
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);

            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Book not found
    }

    public void displayBooks() {
        for (Book book : books) {
            if (book != null) {
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManagementSystem library = new LibraryManagementSystem(10);

        boolean exit = false;

        while (!exit) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title (Linear Search)");
            System.out.println("3. Search Book by Title (Binary Search)");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter book details:");
                    System.out.print("Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();

                    library.addBook(new Book(bookId, title, author));
                    break;

                case 2:
                    System.out.print("Enter Title to search (Linear Search): ");
                    String searchTitleLinear = scanner.nextLine();
                    Book foundBookLinear = library.linearSearchByTitle(searchTitleLinear);
                    System.out.println("Search Result: " + (foundBookLinear != null ? foundBookLinear : "Book not found"));
                    break;

                case 3:
                    System.out.print("Enter Title to search (Binary Search): ");
                    String searchTitleBinary = scanner.nextLine();
                    Book foundBookBinary = library.binarySearchByTitle(searchTitleBinary);
                    System.out.println("Search Result: " + (foundBookBinary != null ? foundBookBinary : "Book not found"));
                    break;

                case 4:
                    System.out.println("Books in the Library:");
                    library.displayBooks();
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
