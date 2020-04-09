package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Student;

public interface StudentRepository  extends JpaRepository<Student,String> {

}
