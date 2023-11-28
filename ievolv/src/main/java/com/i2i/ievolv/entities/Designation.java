package com.i2i.ievolv.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "DESIGNATION")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Designation {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name =  "DESCRIPTION")
    private String description;

    @Column(name =  "IS_ACTIVE")
    private boolean isactive;

}
