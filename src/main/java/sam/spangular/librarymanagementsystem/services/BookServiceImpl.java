package sam.spangular.librarymanagementsystem.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sam.spangular.librarymanagementsystem.entities.Book;
import sam.spangular.librarymanagementsystem.repositories.BookRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
       return bookRepository.save(book);
    }

    @Override
    public Set<Book> getAllBooks() {
        return new HashSet<>(bookRepository.findAll());
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book updateBook(Book book, Long id) {
        if (!bookRepository.existsById(id)) {
          throw new IllegalStateException("Book with id " + id + " does not exist");
        }
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new IllegalStateException("Book with id " + id + " does not exist");
        }
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }

    @Override
    public boolean isBookExist(Book book) {
        if (bookRepository.existsById(book.getId()))
            return true;
        else
            return false;

    }

    @Override
    public boolean isBookExistById(Long id) {
        return bookRepository.existsById(id);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }
}
