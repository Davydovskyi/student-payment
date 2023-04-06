package edu.jcourse.student.dao;

import edu.jcourse.student.domain.CountryArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryAreaRepository extends JpaRepository<CountryArea, Long> {
}
