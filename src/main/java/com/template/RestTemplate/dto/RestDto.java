package com.template.RestTemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestDto {
    private Integer id;

    private String title;

    private String body;

    private Integer userId;
}
