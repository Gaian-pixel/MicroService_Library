package gai.giorgio.microservices_library.borrowing.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@Document
public class Borrowing {
    @Id
    private String borrowingId;
    @NotBlank(message = "bookId is mandatory")
    private String bookId;
    @NotBlank(message = "customerId is mandatory")
    private String customerId;
    @NotBlank(message = "borrowingDate is mandatory")
    private String borrowingDate;
    @NotBlank(message = "borrowingExpDate is mandatory")
    private String borrowingExpDate;
}
