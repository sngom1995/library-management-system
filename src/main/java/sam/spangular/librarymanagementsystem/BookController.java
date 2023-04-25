package sam.spangular.librarymanagementsystem;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.spangular.librarymanagementsystem.entities.Book;
import sam.spangular.librarymanagementsystem.services.BookService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService bookService;
    @GetMapping
    public ResponseEntity<?> getBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable("bookId") Long bookId) {
        if (bookService.getBookById(bookId).isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<?> updateBook(@PathVariable("bookId") Long bookId, @RequestBody Book book) {
        try {
            return ResponseEntity.ok(bookService.updateBook(book, bookId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable("bookId") Long bookId) {

        try {
            bookService.deleteBookById(bookId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
