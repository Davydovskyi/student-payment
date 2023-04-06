package edu.jcourse.student.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "jc_university")
public class University {

    @Id
    @Column(name = "university_id")
    private Long universityID;
    @Column(name = "university_name")
    private String universityName;

    public Long getUniversityID() {
        return universityID;
    }

    public void setUniversityID(Long universityID) {
        this.universityID = universityID;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
