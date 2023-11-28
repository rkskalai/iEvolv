package com.i2i.ievolv.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PARAMETER")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Parameter {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name =  "DESCRIPTION")
    private String description;

    @Column(name =  "MEASURING_PATTERN")
    private String measuringPattern;

    @Column(name =  "WEIGHTAGE")
    private Integer weightage;

    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @JoinColumn(name = "DESIGNATION_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Designation designation;

    @Column(name =  "IS_ACTIVE")
    private boolean isactive;
}
