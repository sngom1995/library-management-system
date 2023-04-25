package sam.spangular.librarymanagementsystem;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sam.spangular.librarymanagementsystem.entities.Book;
import sam.spangular.librarymanagementsystem.services.BookService;

@RequiredArgsConstructor
@SpringBootApplication
public class LibraryManagementSystemApplication implements ApplicationRunner {

    private final BookService bookService;
    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementSystemApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (!bookService.getAllBooks().isEmpty()) {
            System.out.println("Books already exist!");
        }
        else {
            Book book1 = Book.builder()
                    .name("The Alchemist")
                    .description("The Alchemist is a novel by Paulo Coelho that was first published in 1988.")
                    .price(10.0)
                    .build();
            Book book2 = Book.builder()
                    .name("The Kite Runner")
                    .description("The Kite Runner is the first novel by Afghan-American author Khaled Hosseini.")
                    .price(20.0)
                    .build();
            Book book3 = Book.builder()
                    .name("The Da Vinci Code")
                    .description("The Da Vinci Code is a 2003 mystery-detective novel by Dan Brown.")
                    .price(30.0)
                    .build();
            bookService.saveBook(book1);
            bookService.saveBook(book2);
            bookService.saveBook(book3);
        }
    }
}
