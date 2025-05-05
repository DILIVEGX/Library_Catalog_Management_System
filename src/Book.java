public class Book {
    private static int idCounter = 1;

    private final String bookId;
    private final String title;
    private final String author;
    private final String genre;
    private boolean available;

    public Book(String title, String author, String genre) {
        this.bookId = generateBookId();
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = true;
    }
    private String generateBookId() {
        return Integer.toString(idCounter++);
    }
    public String getBookId() { return bookId; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "[" + bookId + "] " + title + " by " + author + " | Genre: " + genre + " | " +
                (available ? "Available" : "Checked Out");
    }
}
