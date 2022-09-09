package com.ead.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Builder
@Table(name = "courses_users")
@NoArgsConstructor
@AllArgsConstructor
public class CourseUserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CourseModel course;

    @Column(nullable = false)
    private UUID userId;

    public CourseUserModel(CourseModel course, UUID userId) {
        this.course = course;
        this.userId = userId;
    }
}
