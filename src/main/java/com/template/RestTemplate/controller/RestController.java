package com.template.RestTemplate.controller;


import com.template.RestTemplate.dto.RestDto;
import com.template.RestTemplate.model.RestModel;
import com.template.RestTemplate.service.RestTemplateService;
import com.template.RestTemplate.utils.GenerateExcel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {

    private final RestTemplateService service;

    public RestController(RestTemplateService service) {
        this.service = service;
    }

    @GetMapping("/save-api")
    public ResponseEntity<List<RestModel>> sveListApi(){
        return ResponseEntity.ok(this.service.saveListApi());
    }

    @GetMapping
    public ResponseEntity<List<RestDto>> getAllDataFromDb(){
        return ResponseEntity.ok(this.service.getAllDataFromDb());
    }

    @GetMapping("/saveOne/{id}")
    public ResponseEntity<RestDto> saveOnePostById(@PathVariable Integer id){
        return ResponseEntity.ok(this.service.saveOnePostById(id));
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<RestDto> getOnePostById(@PathVariable Integer id){
        return ResponseEntity.ok(this.service.getOnePostByIDFromDb(id));
    }

    @GetMapping("/export-excel")
    public void exportExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=generate" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<RestDto> list = service.getAllDataFromDb();
        GenerateExcel generateExcel = new GenerateExcel(list);
        generateExcel.generateExcelFile(response);
    }

}
