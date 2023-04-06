package edu.jcourse.student.dao;

import edu.jcourse.student.domain.office.PassportOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportOfficeRepository extends JpaRepository<PassportOffice, Long> {
}
