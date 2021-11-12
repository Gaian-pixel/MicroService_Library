package gai.giorgio.microservices_library.book.controllers;

import gai.giorgio.microservices_library.book.model.Book;
import gai.giorgio.microservices_library.book.repos.BookRepository;
import gai.giorgio.microservices_library.book.services.TraceService;
import gai.giorgio.microservices_library.book.exceptions.bookOptionalNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping(value = "/v2/books")
public class BookController {

    @Autowired
    TraceService traceService;

    @Autowired
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CREATE
    @RequestMapping(method = RequestMethod.POST)
    public Book addNewCustomer(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }


    // READ
    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    public Book getBook(@PathVariable String bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if(bookOptional.isPresent()){
            return bookOptional.get();
        }else{
            throw new bookOptionalNotFoundException();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Book> getAllBooks() {
        log.info("Return all books in the library");
        return bookRepository.findAll();
    }


    // UPDATE
    @RequestMapping(value = "/{bookId}", method = RequestMethod.PUT)
    public Book modifyCustomer(@RequestBody Book book, @RequestBody String bookId ) {
        return bookRepository.save(book);
    }


    // DELETE
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable String customerId) {
        bookRepository.deleteById(customerId);
    }
}
