package gai.giorgio.microservices_library.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Customer not found...:(")
public class customerOptionalNotFoundException extends RuntimeException {
}
