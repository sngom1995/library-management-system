package sam.spangular.librarymanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sam.spangular.librarymanagementsystem.entities.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
