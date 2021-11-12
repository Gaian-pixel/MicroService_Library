package gai.giorgio.microservices_library.book.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@Document
public class Book {

    @Id
    private String bookId;
    @NotBlank(message = "title is mandatory")
    private String title;
    private String author;
    private String publisher;
    private int pageNumber;


}
