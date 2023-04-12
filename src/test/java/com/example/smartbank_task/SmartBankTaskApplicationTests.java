package com.example.smartbank_task;

import com.example.smartbank_task.dao.dto.CityDto;
import com.example.smartbank_task.service.CityService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SmartBankTaskApplicationTests {

    @Test
    void contextLoads() {

    }

    @Autowired
    private CityService cityService;
    @Test
    void testSortByName()
    {
        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                TextToByte()
        );
//        List<CityDto> cityDtoList = new ArrayList<>();
//        cityDtoList.add(new CityDto(251186L, "Iquitos"));
//        cityDtoList.add(new CityDto(498366L, "Forked River"));
//        cityDtoList.add(new CityDto(157900L, "Kingston"));
//        cityDtoList.add(new CityDto(2906L, "Perth"));
//        cityDtoList.add(new CityDto(208177L, "Rabat"));

        try {
//            Mockito.when(cityService.sortByName(file)).thenReturn(cityDtoList);
            Assert.assertNotNull(cityService.sortByName(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private byte[] TextToByte(){
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
