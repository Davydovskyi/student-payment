package edu.jcourse.student.dao;

import edu.jcourse.student.domain.StudentOrderChild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentOrderChildRepository extends JpaRepository<StudentOrderChild, Long> {
}
