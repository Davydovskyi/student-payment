package edu.jcourse.student.business;

import edu.jcourse.student.dao.StudentOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentOrderService {

    private StudentOrderRepository dao;

    @Autowired
    public void setDao(StudentOrderRepository dao) {
        this.dao = dao;
    }

    @Transactional
    public void testFindAll() {
        dao.findAll();
    }
}
