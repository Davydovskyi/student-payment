package edu.jcourse.student.business;

import edu.jcourse.student.dao.StudentOrderRepository;
import edu.jcourse.student.domain.Person;
import edu.jcourse.student.domain.StudentOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentOrderService.class);

    private StudentOrderRepository dao;

    @Autowired
    public void setDao(StudentOrderRepository dao) {
        this.dao = dao;
    }

    @Transactional
    public void testSave() {
        StudentOrder studentOrder = new StudentOrder();
        studentOrder.setWife(buildPerson(1));
        studentOrder.setHusband(buildPerson(2));
        dao.saveAndFlush(studentOrder);
    }

    @Transactional
    public void testFindAll() {
        List<StudentOrder> studentOrders = dao.findAll();
        LOGGER.info(studentOrders.get(0).getWife().getGivenName());
        LOGGER.info("size : {}", studentOrders.size());
    }

    private Person buildPerson(int sex) {
        Person person = new Person();
        person.setDateOfBirth(LocalDate.now());

        if (sex == 1) {
            person.setSurName("Петрова");
            person.setGivenName("Елена");
            person.setPatronymic("Васильевна");
        } else if (sex == 2) {
            person.setSurName("Грозный");
            person.setGivenName("Иван");
            person.setPatronymic("Васильевич");
        }

        return person;
    }
}
