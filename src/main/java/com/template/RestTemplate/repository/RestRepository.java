package com.template.RestTemplate.repository;

import com.template.RestTemplate.model.RestModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestRepository extends JpaRepository<RestModel, Integer > {
}
