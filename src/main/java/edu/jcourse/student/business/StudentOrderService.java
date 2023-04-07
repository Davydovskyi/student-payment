package edu.jcourse.student.business;

import edu.jcourse.student.dao.*;
import edu.jcourse.student.domain.*;
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

    private StudentOrderRepository daoStudentOrder;
    private StreetRepository daoStreet;
    private StudentOrderStatusRepository daoStatus;
    private PassportOfficeRepository daoPassport;
    private RegisterOfficeRepository daoRegister;
    private UniversityRepository daoUniversity;
    private StudentOrderChildRepository daoChild;

    @Autowired
    public void setDaoStudentOrder(StudentOrderRepository daoStudentOrder) {
        this.daoStudentOrder = daoStudentOrder;
    }

    @Autowired
    public void setDaoStreet(StreetRepository daoStreet) {
        this.daoStreet = daoStreet;
    }

    @Autowired
    public void setDaoStatus(StudentOrderStatusRepository daoStatus) {
        this.daoStatus = daoStatus;
    }

    @Autowired
    public void setDaoPassport(PassportOfficeRepository daoPassport) {
        this.daoPassport = daoPassport;
    }

    @Autowired
    public void setDaoRegister(RegisterOfficeRepository daoRegister) {
        this.daoRegister = daoRegister;
    }

    @Autowired
    public void setDaoUniversity(UniversityRepository daoUniversity) {
        this.daoUniversity = daoUniversity;
    }

    @Autowired
    public void setDaoChild(StudentOrderChildRepository daoChild) {
        this.daoChild = daoChild;
    }

    @Transactional
    public void testSave() {
        StudentOrder studentOrder = new StudentOrder();
        studentOrder.setStudentOrderDate(LocalDateTime.now());
        studentOrder.setStudentOrderStatus(daoStatus.findById(1L).orElse(null));
        studentOrder.setWife(buildPerson(1));
        studentOrder.setHusband(buildPerson(2));
        studentOrder.setCertificateNumber("CERTIFICATE");
        studentOrder.setRegisterOffice(daoRegister.findById(1L).orElse(null));
        studentOrder.setMarriageDate(LocalDate.now());
        daoStudentOrder.saveAndFlush(studentOrder);

        StudentOrderChild child = buildChild(studentOrder);
        daoChild.saveAndFlush(child);
    }

    @Transactional
    public void testFindAll() {
        List<StudentOrder> studentOrders = daoStudentOrder.findAll();
        LOGGER.info(studentOrders.get(0).getWife().getGivenName());
        LOGGER.info("size : {}", studentOrders.size());
        LOGGER.info(studentOrders.get(0).getChildren().get(0).getGivenName());
    }

    private Adult buildPerson(int sex) {
        Adult adult = new Adult();
        adult.setDateOfBirth(LocalDate.now());

        Address address = new Address();
        address.setPostCode("190000");
        address.setBuilding("21");
        address.setExtension("B");
        address.setApartment("199");
        Street street = daoStreet.findById(1L).orElse(null);
        address.setStreet(street);
        adult.setAddress(address);

        adult.setUniversity(daoUniversity.findById(2L).orElse(null));

        Passport passport = new Passport();
        passport.setIssueDate(LocalDate.now());
        passport.setIssueDepartment(daoPassport.findById(1L).orElse(null));
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

    private StudentOrderChild buildChild(StudentOrder studentOrder) {
        StudentOrderChild child = new StudentOrderChild();
        child.setDateOfBirth(LocalDate.now());
        child.setStudentOrder(studentOrder);

        Address address = new Address();
        address.setPostCode("190000");
        address.setBuilding("21");
        address.setExtension("B");
        address.setApartment("199");
        Street street = daoStreet.findById(1L).orElse(null);
        address.setStreet(street);
        child.setAddress(address);

        child.setSurName("Петров");
        child.setGivenName("Дмитрий");
        child.setPatronymic("Иванович");

        child.setCertificateNumber("BIRTH N");
        child.setCertificateDate(LocalDate.now());
        child.setRegisterOffice(daoRegister.findById(1L).orElse(null));

        return child;
    }
}
