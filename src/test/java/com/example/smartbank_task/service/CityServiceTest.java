package com.example.smartbank_task.service;

import com.example.smartbank_task.dao.dto.CityDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CityServiceTest {
    @Autowired
    private CityService cityService;


    @Test
    void testSortByName() {
        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                TextToByte()
        );
        List<CityDto> cityDtoList = new ArrayList<>();
        cityDtoList.add(new CityDto(498366L, "Forked River"));
        cityDtoList.add(new CityDto(251186L, "Iquitos"));
        cityDtoList.add(new CityDto(157900L, "Kingston"));
        cityDtoList.add(new CityDto(2906L, "Perth"));
        cityDtoList.add(new CityDto(208177L, "Rabat"));

        try {
            List<CityDto> result = cityService.sortByName(file);
            Assertions.assertNotNull(result);
            Assertions.assertEquals(result.get(0).getName(), cityDtoList.get(0).getName());
            Assertions.assertEquals(result.get(1).getName(), cityDtoList.get(1).getName());
            Assertions.assertEquals(result.get(2).getName(), cityDtoList.get(2).getName());
            Assertions.assertEquals(result.get(3).getName(), cityDtoList.get(3).getName());
            Assertions.assertEquals(result.get(4).getName(), cityDtoList.get(4).getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testSortByNumber() {
        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                TextToByte()
        );
        List<CityDto> cityDtoList = new ArrayList<>();
        cityDtoList.add(new CityDto(498366L, "Forked River"));
        cityDtoList.add(new CityDto(251186L, "Iquitos"));
        cityDtoList.add(new CityDto(157900L, "Kingston"));
        cityDtoList.add(new CityDto(2906L, "Perth"));
        cityDtoList.add(new CityDto(208177L, "Rabat"));

        try {
            List<CityDto> result = cityService.sortByName(file);
            Assertions.assertNotNull(result);
            Assertions.assertEquals(result.get(0).getNumber(), cityDtoList.get(0).getNumber());
            Assertions.assertEquals(result.get(1).getNumber(), cityDtoList.get(1).getNumber());
            Assertions.assertEquals(result.get(2).getNumber(), cityDtoList.get(2).getNumber());
            Assertions.assertEquals(result.get(3).getNumber(), cityDtoList.get(3).getNumber());
            Assertions.assertEquals(result.get(4).getNumber(), cityDtoList.get(4).getNumber());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testSaveAll() {
        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                TextToByte()
        );
        try {
            String result = cityService.saveAll(file);
            Assertions.assertNotNull(result);
            Assertions.assertEquals(result, "All data saved");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void testGetAll() {
        List<CityDto> cityDtoList = new ArrayList<>();
        cityDtoList.add(new CityDto(251186L, "Iquitos"));
        cityDtoList.add(new CityDto(208177L, "Rabat"));
        cityDtoList.add(new CityDto(157900L, "Kingston"));
        cityDtoList.add(new CityDto(2906L, "Perth"));
        cityDtoList.add(new CityDto(498366L, "Forked River"));


        List<CityDto> result = cityService.getAll();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.get(0).getNumber(), cityDtoList.get(0).getNumber());
        Assertions.assertEquals(result.get(1).getNumber(), cityDtoList.get(1).getNumber());
        Assertions.assertEquals(result.get(2).getNumber(), cityDtoList.get(2).getNumber());
        Assertions.assertEquals(result.get(3).getNumber(), cityDtoList.get(3).getNumber());
        Assertions.assertEquals(result.get(4).getNumber(), cityDtoList.get(4).getNumber());

        Assertions.assertEquals(result.get(0).getName(), cityDtoList.get(0).getName());
        Assertions.assertEquals(result.get(1).getName(), cityDtoList.get(1).getName());
        Assertions.assertEquals(result.get(2).getName(), cityDtoList.get(2).getName());
        Assertions.assertEquals(result.get(3).getName(), cityDtoList.get(3).getName());
        Assertions.assertEquals(result.get(4).getName(), cityDtoList.get(4).getName());

    }

    private byte[] TextToByte() {
        String text = """
                city_code,city
                251186,Iquitos
                208177,Rabat
                157900,Kingston
                2906,Perth
                498366,Forked River
                """;
        return text.getBytes();
    }
}