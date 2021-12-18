package gai.giorgio.microservices_library.borrowing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Borrowing not found")
public class BorrowingNotFoundException extends  RuntimeException{

}
