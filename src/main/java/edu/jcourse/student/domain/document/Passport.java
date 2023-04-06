package edu.jcourse.student.domain.document;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class Passport {
    private String passportSeries;
    private String passportNumber;
    private LocalDate issueDate;

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
}
