package com.template.RestTemplate.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestModel {
    @Id
    private Integer id;

    private String title;

    private String body;

    private Integer userId;

}
