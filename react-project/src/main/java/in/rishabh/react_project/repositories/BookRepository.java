package in.rishabh.react_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.rishabh.react_project.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
