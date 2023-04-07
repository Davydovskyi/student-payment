package edu.jcourse.student.domain;

import edu.jcourse.student.domain.office.RegisterOffice;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Embeddable
public class Child extends Person {

    private String certificateNumber;
    private LocalDate certificateDate;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private RegisterOffice registerOffice;

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public LocalDate getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(LocalDate certificateDate) {
        this.certificateDate = certificateDate;
    }

    public RegisterOffice getRegisterOffice() {
        return registerOffice;
    }

    public void setRegisterOffice(RegisterOffice registerOffice) {
        this.registerOffice = registerOffice;
    }
}
