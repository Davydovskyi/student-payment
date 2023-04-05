package edu.jcourse.student.dao;

import edu.jcourse.student.domain.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street, Long> {
}
