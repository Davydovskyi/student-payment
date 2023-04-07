package edu.jcourse.student.domain;

import edu.jcourse.student.domain.document.Passport;
import jakarta.persistence.*;

@Embeddable
public class Adult extends Person {

    private Passport passport;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private University university;
    private String studentId;

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
