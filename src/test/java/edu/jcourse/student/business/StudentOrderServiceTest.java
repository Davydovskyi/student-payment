package edu.jcourse.student.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
class StudentOrderServiceTest {

    @Autowired
    private StudentOrderService service;

    @Test
    void testALL() {
        testSave();
        testFindAll();
    }

    void testSave() {
        service.testSave();
    }

    void testFindAll() {
        service.testFindAll();
    }
}