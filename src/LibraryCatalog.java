import java.util.*;

public class LibraryCatalog {
    private final List<Book> books;
    private final Map<String, Book> bookMap;
    private final List<String> genres;

    public LibraryCatalog() {
        books = new ArrayList<>();
        bookMap = new HashMap<>();
        genres = new ArrayList<>(Arrays.asList(
                "Fiction", "Science", "Fantasy"
        ));
    }

    public void addBook(String title, String author, String genre) {
        Book book = new Book(title, author, genre);
        books.add(book);
        bookMap.put(book.getBookId(), book);
        System.out.println("Book added successfully. Book ID: " + book.getBookId());
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the catalog.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void viewBookDetails(String bookId) {
        Book book = bookMap.get(bookId);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    public void checkAvailability(String bookId) {
        Book book = bookMap.get(bookId);
        if (book != null) {
            System.out.println("Availability: " + (book.isAvailable() ? "Available" : "Checked Out"));
        } else {
            System.out.println("Book not found.");
        }
    }

    public void updateAvailability(String bookId, boolean isAvailable) {
        Book book = bookMap.get(bookId);
        if (book != null) {
            book.setAvailable(isAvailable);
            System.out.println("Availability updated.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void showGenresWithNumbers() {
        for (int i = 0; i < genres.size(); i++) {
            System.out.println((i + 1) + ". " + genres.get(i));
        }
    }

    public Book getBookById(String bookId) {
        return bookMap.get(bookId);
    }

    public String getGenreByIndex(int index) {
        if (index >= 1 && index <= genres.size()) {
            return genres.get(index - 1);
        } else {
            return null;
        }
    }

    public void addGenre(String genre) {
        if (genres.contains(genre)) {
            System.out.println("Genre already exists.");
        } else {
            genres.add(genre);
            System.out.println("Genre added: " + genre);
        }
    }
}
