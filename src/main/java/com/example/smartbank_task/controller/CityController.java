package com.example.smartbank_task.controller;

import com.example.smartbank_task.dao.dto.CityDto;
import com.example.smartbank_task.exeption.handling.ResponseHandler;
import com.example.smartbank_task.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/city/")
public class CityController extends BaseController<CityService> {

    protected CityController(CityService service) {
        super(service);
    }


    @PostMapping(value = "/sortByName", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> sortByName(@RequestPart("files") MultipartFile multipartFile) throws IOException {
        return ResponseHandler.generateResponse("Sorted By name", HttpStatus.OK, service.sortByName(multipartFile));
    }

    @PostMapping(value = "/sortByNumber", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> sortByNumber(@RequestParam("files") MultipartFile multipartFile) throws IOException {
        return ResponseHandler.generateResponse("Sorted By Code", HttpStatus.OK, service.sortByNumber(multipartFile));
    }

    @PostMapping(value = "/saveAll", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> saveAll(@RequestParam("files") MultipartFile multipartFile) throws IOException {
        return ResponseHandler.generateResponse("All data saved", HttpStatus.OK, service.saveAll(multipartFile));
    }
}
