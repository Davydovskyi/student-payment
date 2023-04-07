package edu.jcourse.student.business;

import edu.jcourse.student.dao.*;
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
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentOrderService.class);

    private StudentOrderRepository studentOrderRepository;
    private StreetRepository streetRepository;
    private StudentOrderStatusRepository studentOrderStatusRepository;
    private PassportOfficeRepository passportOfficeRepository;
    private RegisterOfficeRepository registerOfficeRepository;
    private UniversityRepository universityRepository;

    @Autowired
    public void setStudentOrderRepository(StudentOrderRepository studentOrderRepository) {
        this.studentOrderRepository = studentOrderRepository;
    }

    @Autowired
    public void setStreetRepository(StreetRepository streetRepository) {
        this.streetRepository = streetRepository;
    }

    @Autowired
    public void setStudentOrderStatusRepository(StudentOrderStatusRepository studentOrderStatusRepository) {
        this.studentOrderStatusRepository = studentOrderStatusRepository;
    }

    @Autowired
    public void setPassportOfficeRepository(PassportOfficeRepository passportOfficeRepository) {
        this.passportOfficeRepository = passportOfficeRepository;
    }

    @Autowired
    public void setRegisterOfficeRepository(RegisterOfficeRepository registerOfficeRepository) {
        this.registerOfficeRepository = registerOfficeRepository;
    }

    @Autowired
    public void setUniversityRepository(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Transactional
    public void testSave() {
        StudentOrder studentOrder = new StudentOrder();
        studentOrder.setStudentOrderDate(LocalDateTime.now());
        studentOrder.setStudentOrderStatus(studentOrderStatusRepository.findById(1L).orElse(null));
        studentOrder.setWife(buildPerson(1));
        studentOrder.setHusband(buildPerson(2));
        studentOrder.setCertificateNumber("CERTIFICATE");
        studentOrder.setRegisterOffice(registerOfficeRepository.findById(1L).orElse(null));
        studentOrder.setMarriageDate(LocalDate.now());
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

        adult.setUniversity(universityRepository.findById(2L).orElse(null));

        Passport passport = new Passport();
        passport.setIssueDate(LocalDate.now());
        passport.setIssueDepartment(passportOfficeRepository.findById(1L).orElse(null));
        adult.setPassport(passport);

        if (sex == 1) {
            adult.setSurName("Петрова 2");
            adult.setGivenName("Елена");
            adult.setPatronymic("Васильевна");

            passport.setPassportSeries("WIFE_S");
            passport.setPassportNumber("WIFE_N");

            adult.setStudentId("12345");
        } else if (sex == 2) {
            adult.setSurName("Грозный 2");
            adult.setGivenName("Иван");
            adult.setPatronymic("Васильевич");

            passport.setPassportSeries("HUSBAND_S");
            passport.setPassportNumber("HUSBAND_N");

            adult.setStudentId("67890");
        }

        return adult;
    }
}
