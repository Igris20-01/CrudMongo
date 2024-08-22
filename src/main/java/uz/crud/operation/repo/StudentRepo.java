package uz.crud.operation.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uz.crud.operation.model.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {
}
