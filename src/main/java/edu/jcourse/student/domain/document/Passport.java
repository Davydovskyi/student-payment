package edu.jcourse.student.domain.document;

import edu.jcourse.student.domain.office.PassportOffice;
import jakarta.persistence.*;

import java.time.LocalDate;

@Embeddable
public class Passport {
    private String passportSeries;
    private String passportNumber;
    private LocalDate issueDate;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private PassportOffice issueDepartment;

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public PassportOffice getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(PassportOffice issueDepartment) {
        this.issueDepartment = issueDepartment;
    }
}
