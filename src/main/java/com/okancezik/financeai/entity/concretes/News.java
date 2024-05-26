package com.okancezik.financeai.entity.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "news")
public class News {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "url")
    private String url;

    @Column(name = "date")
    private LocalDateTime loadDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "lot_id")
    private Lot lot;

    @OneToMany(mappedBy = "news")
    private List<SummaryNew> summary;
}
