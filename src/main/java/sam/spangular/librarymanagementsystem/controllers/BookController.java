package sam.spangular.librarymanagementsystem.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sam.spangular.librarymanagementsystem.services.BookService;

@RequiredArgsConstructor
@Controller
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/books/{bookId}/delete")
    public String deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBookById(bookId);
        return "redirect:/books";
    }

    @GetMapping("/books/{bookId}/edit")
    public String editBook(@PathVariable("bookId") Long bookId, Model model) {
        model.addAttribute("book", bookService.getBookById(bookId));
        return "books/editBook";
    }
}
