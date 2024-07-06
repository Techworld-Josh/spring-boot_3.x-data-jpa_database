package org.techworldwithjosh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.techworldwithjosh.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
