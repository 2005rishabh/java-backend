package in.rishabh.react_project.entities;

import jakarta.persistence.Column;
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

public class Book {
    @Id
    private Long isbn;

    @Column(nullable = false)
    @NotBlank(message = "This field cannot be empty")
    private String title;
    
    @Column(nullable = false)
    @NotBlank(message = "This field cannot be empty")
    private String author;

    @Column(nullable = false)
    @NotBlank(message = "This field cannot be empty")
    private String description;    

    @Column(nullable = false)
    @NotBlank(message = "This field cannot be empty")
    private String category;
    
    @Column(nullable = false)
    @NotNull(message = "This field cannot be empty")
    private Double price;
    
    @Column(nullable = false)
    @NotNull(message = "This field cannot be empty")
    private Integer quantity;
    
    private String bookCover;
    
    private String bookCoverUrl;

}
