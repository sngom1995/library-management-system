package sam.spangular.librarymanagementsystem.services;

import sam.spangular.librarymanagementsystem.entities.Book;

import java.util.Optional;
import java.util.Set;

public interface BookService {

    Book saveBook(Book book);

    Set<Book> getAllBooks();

    Optional<Book> getBookById(Long id);

    Book updateBook(Book book, Long id);

    void deleteBookById(Long id);

    void deleteAllBooks();

    boolean isBookExist(Book book);

    boolean isBookExistById(Long id);

    void deleteBook(Book book);

}
