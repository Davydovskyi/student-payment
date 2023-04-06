package edu.jcourse.student.business;

import edu.jcourse.student.dao.StreetRepository;
import edu.jcourse.student.dao.StudentOrderRepository;
import edu.jcourse.student.domain.Address;
import edu.jcourse.student.domain.Adult;
import edu.jcourse.student.domain.Street;
import edu.jcourse.student.domain.StudentOrder;
import edu.jcourse.student.domain.document.Passport;
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

    private StudentOrderRepository studentOrderRepository;
    private StreetRepository streetRepository;

    @Autowired
    public void setStudentOrderRepository(StudentOrderRepository studentOrderRepository) {
        this.studentOrderRepository = studentOrderRepository;
    }

    @Autowired
    public void setStreetRepository(StreetRepository streetRepository) {
        this.streetRepository = streetRepository;
    }

    @Transactional
    public void testSave() {
        StudentOrder studentOrder = new StudentOrder();
        studentOrder.setWife(buildPerson(1));
        studentOrder.setHusband(buildPerson(2));
        studentOrderRepository.saveAndFlush(studentOrder);
    }

    @Transactional
    public void testFindAll() {
        List<StudentOrder> studentOrders = studentOrderRepository.findAll();
        LOGGER.info(studentOrders.get(0).getWife().getGivenName());
        LOGGER.info("size : {}", studentOrders.size());
    }

    private Adult buildPerson(int sex) {
        Adult adult = new Adult();
        adult.setDateOfBirth(LocalDate.now());

        Address address = new Address();
        address.setPostCode("190000");
        address.setBuilding("21");
        address.setExtension("B");
        address.setApartment("199");
        Street street = streetRepository.findById(1L).orElse(null);
        address.setStreet(street);
        adult.setAddress(address);

        Passport passport = new Passport();
        adult.setPassport(passport);

        if (sex == 1) {
            adult.setSurName("Петрова 2");
            adult.setGivenName("Елена");
            adult.setPatronymic("Васильевна");

            passport.setPassportSeries("WIFE_S");
            passport.setPassportNumber("WIFE_N");
            passport.setIssueDate(LocalDate.now());
        } else if (sex == 2) {
            adult.setSurName("Грозный 2");
            adult.setGivenName("Иван");
            adult.setPatronymic("Васильевич");
            passport.setPassportSeries("HUSBAND_S");
            passport.setPassportNumber("HUSBAND_N");
            passport.setIssueDate(LocalDate.now());
        }

        return adult;
    }
}
