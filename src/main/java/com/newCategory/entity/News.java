package com.newCategory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class News {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String category;
    private String description;
    private String imageUrl;
}
