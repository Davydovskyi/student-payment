package edu.jcourse.student.domain;

import edu.jcourse.student.domain.office.RegisterOffice;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "jc_student_order_2")
public class StudentOrder {

    @Id
    @Column(name = "student_order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentOrderId;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_order_status_id")
    private StudentOrderStatus studentOrderStatus;
    @Column(name = "student_order_date")
    private LocalDateTime studentOrderDate;

    @AssociationOverrides({
            @AssociationOverride(name = "address.street", joinColumns = @JoinColumn(name = "h_street_code")),
            @AssociationOverride(name = "passport.issueDepartment", joinColumns = @JoinColumn(name = "h_passport_office_id")),
            @AssociationOverride(name = "university", joinColumns = @JoinColumn(name = "h_university_id"))
    })
    @AttributeOverrides({
            @AttributeOverride(name = "surName", column = @Column(name = "h_sur_name")),
            @AttributeOverride(name = "givenName", column = @Column(name = "h_given_name")),
            @AttributeOverride(name = "patronymic", column = @Column(name = "h_patronymic")),
            @AttributeOverride(name = "dateOfBirth", column = @Column(name = "h_date_of_birth")),
            @AttributeOverride(name = "address.postCode", column = @Column(name = "h_post_index")),
            @AttributeOverride(name = "address.building", column = @Column(name = "h_building")),
            @AttributeOverride(name = "address.extension", column = @Column(name = "h_extension")),
            @AttributeOverride(name = "address.apartment", column = @Column(name = "h_apartment")),
            @AttributeOverride(name = "passport.passportSeries", column = @Column(name = "h_passport_series")),
            @AttributeOverride(name = "passport.passportNumber", column = @Column(name = "h_passport_number")),
            @AttributeOverride(name = "passport.issueDate", column = @Column(name = "h_passport_date")),
            @AttributeOverride(name = "studentId", column = @Column(name = "h_student_number"))
    })
    @Embedded
    private Adult husband;

    @AssociationOverrides({
            @AssociationOverride(name = "address.street", joinColumns = @JoinColumn(name = "w_street_code")),
            @AssociationOverride(name = "passport.issueDepartment", joinColumns = @JoinColumn(name = "w_passport_office_id")),
            @AssociationOverride(name = "university", joinColumns = @JoinColumn(name = "w_university_id"))
    })
    @AttributeOverrides({
            @AttributeOverride(name = "surName", column = @Column(name = "w_sur_name")),
            @AttributeOverride(name = "givenName", column = @Column(name = "w_given_name")),
            @AttributeOverride(name = "patronymic", column = @Column(name = "w_patronymic")),
            @AttributeOverride(name = "dateOfBirth", column = @Column(name = "w_date_of_birth")),
            @AttributeOverride(name = "address.postCode", column = @Column(name = "w_post_index")),
            @AttributeOverride(name = "address.building", column = @Column(name = "w_building")),
            @AttributeOverride(name = "address.extension", column = @Column(name = "w_extension")),
            @AttributeOverride(name = "address.apartment", column = @Column(name = "w_apartment")),
            @AttributeOverride(name = "passport.passportSeries", column = @Column(name = "w_passport_series")),
            @AttributeOverride(name = "passport.passportNumber", column = @Column(name = "w_passport_number")),
            @AttributeOverride(name = "passport.issueDate", column = @Column(name = "w_passport_date")),
            @AttributeOverride(name = "studentId", column = @Column(name = "w_student_number"))
    })
    @Embedded
    private Adult wife;
    @Column(name = "certificate_number")
    private String certificateNumber;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "register_office_id")
    private RegisterOffice registerOffice;
    @Column(name = "marriage_date")
    private LocalDate marriageDate;
    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "studentOrder")
    private List<StudentOrderChild> children;

    public Long getStudentOrderId() {
        return studentOrderId;
    }

    public void setStudentOrderId(Long studentOrderId) {
        this.studentOrderId = studentOrderId;
    }

    public StudentOrderStatus getStudentOrderStatus() {
        return studentOrderStatus;
    }

    public void setStudentOrderStatus(StudentOrderStatus studentOrderStatus) {
        this.studentOrderStatus = studentOrderStatus;
    }

    public LocalDateTime getStudentOrderDate() {
        return studentOrderDate;
    }

    public void setStudentOrderDate(LocalDateTime studentOrderDate) {
        this.studentOrderDate = studentOrderDate;
    }

    public Adult getHusband() {
        return husband;
    }

    public void setHusband(Adult husband) {
        this.husband = husband;
    }

    public Adult getWife() {
        return wife;
    }

    public void setWife(Adult wife) {
        this.wife = wife;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public RegisterOffice getRegisterOffice() {
        return registerOffice;
    }

    public void setRegisterOffice(RegisterOffice registerOffice) {
        this.registerOffice = registerOffice;
    }

    public LocalDate getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(LocalDate marriageDate) {
        this.marriageDate = marriageDate;
    }

    public List<StudentOrderChild> getChildren() {
        return children;
    }

    public void setChildren(List<StudentOrderChild> children) {
        this.children = children;
    }
}
