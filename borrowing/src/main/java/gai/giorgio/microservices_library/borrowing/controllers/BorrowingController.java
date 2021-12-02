package gai.giorgio.microservices_library.borrowing.controllers;


import gai.giorgio.microservices_library.borrowing.exceptions.BorrowingNotFoundException;
import gai.giorgio.microservices_library.borrowing.model.Borrowing;
import gai.giorgio.microservices_library.borrowing.repos.BorrowingRepository;
import gai.giorgio.microservices_library.borrowing.services.NotificationClient;
import gai.giorgio.microservices_library.borrowing.services.TraceService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping(value = "/v2/borrowing")
public class BorrowingController {

    @Autowired
    TraceService traceService;

    @Autowired
    NotificationClient notificationClient;

    @Value("${kafka.sms.message}")
    private String message;

    @Autowired
    private final BorrowingRepository borrowingRepository;

    public BorrowingController(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }

    // CREATE
    @RequestMapping(method = RequestMethod.POST)
    public Borrowing addNewBorrowing(@Valid @RequestBody Borrowing borrowing) {
        notificationClient.sendSMS(borrowing);
        return borrowingRepository.save(borrowing);
    }


    // READ
    @RequestMapping(value = "/{borrowingId}", method = RequestMethod.GET)
    public Borrowing getBorrowing(@PathVariable String borrowingId) {
        Optional<Borrowing> borrowingOptional = borrowingRepository.findById(borrowingId);
        if(borrowingOptional.isPresent()){
            return borrowingOptional.get();
        }else{
            throw new BorrowingNotFoundException();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Borrowing> getAllBorrowings() {
        log.info("Get all borrowings");
        return borrowingRepository.findAll();
    }


    // UPDATE
    @RequestMapping(value = "/{borrowingId}", method = RequestMethod.PUT)
    public Borrowing modifyBorrowing(@RequestBody Borrowing borrowing, @RequestBody String borrowingId ) {
        return borrowingRepository.save(borrowing);
    }


    // DELETE
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllBorrowings() {
        borrowingRepository.deleteAll();
    }

    @RequestMapping(value = "/{borrowingId}", method = RequestMethod.DELETE)
    public void deleteBorrowing(@PathVariable String borrowingId) {
        borrowingRepository.deleteById(borrowingId);
    }
}


