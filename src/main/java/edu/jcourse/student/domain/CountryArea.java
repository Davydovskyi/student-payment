package edu.jcourse.student.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "jc_country_struct")
public class CountryArea {

    @Id
    @Column(name = "area_id")
    private String areaId;
    @Column(name = "area_name")
    private String areaName;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
