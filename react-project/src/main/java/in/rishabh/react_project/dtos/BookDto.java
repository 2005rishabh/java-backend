package in.rishabh.react_project.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class BookDto {

    @Id
    private Long isbn;

    @NotBlank(message = "This field cannot be empty")
    private String title;
    
    @NotBlank(message = "This field cannot be empty")
    private String author;

    @NotBlank(message = "This field cannot be empty")
    private String description;    

    @NotBlank(message = "This field cannot be empty")
    private String category;
    
    @NotNull(message = "This field cannot be empty")
    private Double price;
    
    @NotNull(message = "This field cannot be empty")
    private Integer quantity;
    
    private String bookCover;
    
    private String bookCoverUrl;
}
