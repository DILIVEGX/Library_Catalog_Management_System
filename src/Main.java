import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryCatalog catalog = new LibraryCatalog();
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Add New Book");
            System.out.println("2. View All Books");
            System.out.println("3. View Book Details");
            System.out.println("4. Check Book Availability");
            System.out.println("5. Update Availability");
            System.out.println("6. Show Available Genres");
            System.out.println("7. Add New Genre");
            System.out.println("8. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.println("Select a Genre:");
                    catalog.showGenresWithNumbers();
                    System.out.print("Choose a genre number: ");
                    int genreChoice = scanner.nextInt();
                    scanner.nextLine();
                    String genre = catalog.getGenreByIndex(genreChoice);
                    if (genre == null) {
                        System.out.println("Invalid genre selection.");
                        break;
                    }
                    catalog.addBook(title, author, genre);
                    break;
                case 2:
                    catalog.displayAllBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    catalog.viewBookDetails(bookId);
                    break;
                case 4:
                    System.out.print("Enter Book ID: ");
                    String bookIdToCheck = scanner.nextLine();
                    catalog.checkAvailability(bookIdToCheck);
                    break;
                case 5:
                    System.out.print("Enter Book ID: ");
                    String bookIdToUpdate = scanner.nextLine();

                    Book bookToUpdate = catalog.getBookById(bookIdToUpdate);
                    if (bookToUpdate == null) {
                        System.out.println("Book not found.");
                        break;
                    }

                    System.out.println("Current status: " + (bookToUpdate.isAvailable() ? "Available" : "Checked Out"));
                    System.out.print("Set as Available? (1 = Yes, 0 = No): ");
                    int availabilityInput = scanner.nextInt();
                    scanner.nextLine();

                    if (availabilityInput == 1) {
                        catalog.updateAvailability(bookIdToUpdate, true);
                    } else if (availabilityInput == 0) {
                        catalog.updateAvailability(bookIdToUpdate, false);
                    } else {
                        System.out.println("Invalid input. Must be 1 or 0.");
                    }
                    break;
                case 6:
                    System.out.println("Available Genres:");
                    catalog.showGenresWithNumbers();
                    break;
                case 7:
                    System.out.print("Enter new genre name: ");
                    String newGenre = scanner.nextLine();
                    catalog.addGenre(newGenre);
                    break;
                case 8:
                    exit = true;
                    System.out.println("Exiting Library Catalog. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        scanner.close();
    }
}
