package in.rishabh.react_project.services;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import in.rishabh.react_project.dtos.BookDto;
import in.rishabh.react_project.repositories.BookRepository;

public class BookServiceImpl implements BookService{

    @Value("${project.images}")
    private String path;
    
    @Value("${base.url}")
    private String baseUrl;
    
    private final FileService fileService;
    private final BookRepository bookRepository;

    public BookServiceImpl(FileService fileService, BookRepository bookRepository) {
        this.fileService = fileService;
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto addBook(BookDto bookDto, MultipartFile file) throws FileAlreadyExistsException {
        if(Files.exists(Paths.get(path + File.separator + file.getOriginalFilename()))) {
            throw new FileAlreadyExistsException("File already exists by this name. Please give other file");
        }

        String uploadFileName = 

        
    }

    @Override
    public BookDto getBook(Long isbn) {
        
    }

    @Override
    public List<BookDto> getAllBooks() {
        
    }

    @Override
    public BookDto updateBook(Long isbn, BookDto bookDto, MultipartFile multipartFile) {
        
    }

    @Override
    public String deleteBook(Long isbn) {
        
    }

}
