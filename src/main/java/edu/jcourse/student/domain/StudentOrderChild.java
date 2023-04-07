package edu.jcourse.student.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "jc_student_child")
public class StudentOrderChild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_child_id")
    private Long studentOrderChild;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_order_id")
    private StudentOrder studentOrder;

    @AssociationOverrides({
            @AssociationOverride(name = "address.street", joinColumns = @JoinColumn(name = "c_street_code")),
            @AssociationOverride(name = "registerOffice", joinColumns = @JoinColumn(name = "c_register_office_id"))
    })
    @AttributeOverrides({
            @AttributeOverride(name = "surName", column = @Column(name = "c_sur_name")),
            @AttributeOverride(name = "givenName", column = @Column(name = "c_given_name")),
            @AttributeOverride(name = "patronymic", column = @Column(name = "c_patronymic")),
            @AttributeOverride(name = "dateOfBirth", column = @Column(name = "c_date_of_birth")),
            @AttributeOverride(name = "address.postCode", column = @Column(name = "c_post_index")),
            @AttributeOverride(name = "address.building", column = @Column(name = "c_building")),
            @AttributeOverride(name = "address.extension", column = @Column(name = "c_extension")),
            @AttributeOverride(name = "address.apartment", column = @Column(name = "c_apartment")),
            @AttributeOverride(name = "certificateNumber", column = @Column(name = "c_certificate_number")),
            @AttributeOverride(name = "certificateDate", column = @Column(name = "c_certificate_date"))
    })
    @Embedded
    private Child child;

    public Long getStudentOrderChild() {
        return studentOrderChild;
    }

    public void setStudentOrderChild(Long studentOrderChild) {
        this.studentOrderChild = studentOrderChild;
    }

    public StudentOrder getStudentOrder() {
        return studentOrder;
    }

    public void setStudentOrder(StudentOrder studentOrder) {
        this.studentOrder = studentOrder;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
