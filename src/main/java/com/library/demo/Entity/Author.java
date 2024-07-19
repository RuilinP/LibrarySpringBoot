package com.library.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Author {
    @Id
    @SequenceGenerator(
            name = "author_id_sequence",
            sequenceName = "author_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_id_sequence"
    )
    private Integer authorId;
    private String name;
    private String note;



}
