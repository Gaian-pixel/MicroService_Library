package gai.giorgio.microservices_library.book.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Book not found...:(")
public class bookOptionalNotFoundException extends RuntimeException {
}
