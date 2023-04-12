package com.example.smartbank_task.controller;

import com.example.smartbank_task.dao.dto.CityDto;
import com.example.smartbank_task.service.CityService;
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
    public ResponseEntity<List<CityDto>> sortByName(@RequestPart("files") MultipartFile multipartFile) throws IOException {
        return ResponseEntity.ok(service.sortByName(multipartFile));
    }

    @PostMapping(value = "/sortByNumber", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<List<CityDto>> sortByNumber(@RequestParam("files") MultipartFile multipartFile) throws IOException {
        return ResponseEntity.ok(service.sortByNumber(multipartFile));
    }

    @PostMapping(value = "/saveAll", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> saveAll(@RequestParam("files") MultipartFile multipartFile) throws IOException {
        return ResponseEntity.ok(service.saveAll(multipartFile));
    }
}
