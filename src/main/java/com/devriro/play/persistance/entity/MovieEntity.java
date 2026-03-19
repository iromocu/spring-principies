package com.devriro.play.persistance.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "movie")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150, unique = true)
    private String title;

    @Column(nullable = false, length = 3)
    private Integer duration;

    @Column(nullable = false, length = 50)
    private String gender;

    @Column(name = "opening_day")
    private LocalDate openingDay;

    @Column(precision = 3, scale = 2)
    private BigDecimal rankin;

    @Column(nullable = false)
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getOpeningDay() {
        return openingDay;
    }

    public void setOpeningDay(LocalDate openingDay) {
        this.openingDay = openingDay;
    }

    public BigDecimal getRankin() {
        return rankin;
    }

    public void setRankin(BigDecimal rankin) {
        this.rankin = rankin;
    }
}
