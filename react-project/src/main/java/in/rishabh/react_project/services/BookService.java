package in.rishabh.react_project.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import in.rishabh.react_project.dtos.BookDto;

public interface BookService {
    BookDto addBook(BookDto bookDto, MultipartFile multipartFile);

    BookDto getBook(Long isbn);

    List<BookDto> getAllBooks();

    BookDto updateBook(Long isbn, BookDto bookDto, MultipartFile multipartFile);

    String deleteBook(Long isbn);
    
}
