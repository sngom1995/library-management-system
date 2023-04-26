package sam.spangular.librarymanagementsystem.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sam.spangular.librarymanagementsystem.services.BookService;

import org.springframework.web.bind.annotation.*;
import sam.spangular.librarymanagementsystem.entities.Book;

import java.util.Optional;
import java.util.Set;

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
    @GetMapping("/")
    public String getAllBooks(Model model){
        Set<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "index";
    }

    @PostMapping("/addBook")
    public String addNewBook(Book book){
        Book result = bookService.saveBook(book);
        if(result == null){
            return "redirect:/";
        }
        return "redirect:/";
    }

    @RequestMapping({"/edit", "/edit/{id}"})
    public String editBook(Model model, @PathVariable("id") Optional<Long> id) {
        {
            if (id.isPresent()) {
                Optional<Book> book = bookService.getBookById(id.get());
                if (book.isPresent())
                    model.addAttribute("book", book);
            } else {
                model.addAttribute("book", new Book());
            }
            return "add-edit-book";
        }
    }

}
