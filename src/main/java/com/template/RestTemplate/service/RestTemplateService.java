package com.template.RestTemplate.service;

import com.template.RestTemplate.dto.RestDto;
import com.template.RestTemplate.exception.ResourceNotFoundException;
import com.template.RestTemplate.model.RestModel;
import com.template.RestTemplate.repository.RestRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
public class RestTemplateService {

    private final RestRepository repository;
    private final RestTemplate restTemplate;

    public RestTemplateService(RestRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }


    public List<RestModel>  saveListApi(){
        RestDto[] dto = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts",RestDto[].class );
        if( dto==null) {
            throw new ResourceNotFoundException("Error");
        }
        List<RestModel> list = Arrays.stream(dto).map(i->RestModel
                .builder()
                .id(i.getId())
                .body(i.getBody())
                .title(i.getTitle())
                .userId(i.getUserId())
                .build()).toList();

        this.repository.saveAll(list);
        return list;
    }

    public List<RestDto> getAllDataFromDb() {
        return repository.findAll().stream().map(post -> RestDto
                .builder()
                .id(post.getId())
                .userId(post.getUserId())
                .title(post.getTitle())
                .body(post.getBody())
                .build()).toList();
    }

    public RestDto saveOnePostById(Integer id){
        RestDto dto = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/"+id, RestDto.class);
        this.repository.save(RestModel
                .builder().id(dto.getId())
                        .userId(dto.getUserId())
                        .body(dto.getBody())
                        .title(dto.getTitle())
                .build());
        return dto;
    }

    public RestDto getOnePostByIDFromDb(Integer id){
        RestModel findOne =  repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("id not found"));
        return RestDto.builder()
                .id(findOne.getId())
                .body(findOne.getBody())
                .title(findOne.getTitle())
                .userId(findOne.getUserId())
                .build();
    }
}
