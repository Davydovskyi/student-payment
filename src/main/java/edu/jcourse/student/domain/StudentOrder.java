package edu.jcourse.student.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "jc_student_order_tmp")
public class StudentOrder {

    @Id
    @Column(name = "student_order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentOrderId;

    @AttributeOverrides({
            @AttributeOverride(name = "surName", column = @Column(name = "h_sur_name")),
            @AttributeOverride(name = "givenName", column = @Column(name = "h_given_name")),
            @AttributeOverride(name = "patronymic", column = @Column(name = "h_patronymic")),
            @AttributeOverride(name = "dateOfBirth", column = @Column(name = "h_date_of_birth")),
    })
    private Person husband;
    @AttributeOverrides({
            @AttributeOverride(name = "surName", column = @Column(name = "w_sur_name")),
            @AttributeOverride(name = "givenName", column = @Column(name = "w_given_name")),
            @AttributeOverride(name = "patronymic", column = @Column(name = "w_patronymic")),
            @AttributeOverride(name = "dateOfBirth", column = @Column(name = "w_date_of_birth")),
    })
    private Person wife;

    public Long getStudentOrderId() {
        return studentOrderId;
    }

    public void setStudentOrderId(Long studentOrderId) {
        this.studentOrderId = studentOrderId;
    }

    public Person getHusband() {
        return husband;
    }

    public void setHusband(Person husband) {
        this.husband = husband;
    }

    public Person getWife() {
        return wife;
    }

    public void setWife(Person wife) {
        this.wife = wife;
    }
}
