package com.okancezik.financeai.entity.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lots")
public class Lot {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "value")
    private double value;

    @Column(name = "company")
    private String company;

    @OneToMany(mappedBy = "lot")
    private List<Comment> comments;

    @OneToMany(mappedBy = "lot")
    private List<AIComment> aiComments;
}
