package com.okancezik.financeai.entity.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "summary_news")
public class SummaryNew {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "summary")
    private String summary;

    @Column(name = "date")
    private LocalDateTime loadDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "news_id")
    private News news;
}
