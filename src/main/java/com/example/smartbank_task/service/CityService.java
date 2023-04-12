package com.example.smartbank_task.service;

import com.example.smartbank_task.dao.dto.CityDto;
import com.example.smartbank_task.dao.mapper.CityMapper;
import com.example.smartbank_task.dao.model.City;
import com.example.smartbank_task.dao.repo.CityRepo;
import com.example.smartbank_task.exeption.DatabaseException;
import com.example.smartbank_task.exeption.handling.ApiMessages;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService extends BaseService<City, CityDto, CityRepo, CityMapper>{

    protected CityService(CityRepo repository, @Qualifier("cityMapperImpl") CityMapper mapper) {
        super(repository, mapper);
    }

    public List<CityDto> sortByNumber(MultipartFile multipartFile) throws IOException {
        List<CityDto> cityDtoList = CvsReader(multipartFile.getInputStream());
        return cityDtoList.stream().
                sorted(Comparator.comparing(CityDto::getNumber)).
                collect(Collectors.toList());
    }

    public List<CityDto> sortByName(MultipartFile multipartFile) throws IOException {
        List<CityDto> cityDtoList = CvsReader(multipartFile.getInputStream());
        return cityDtoList.stream().
                sorted(Comparator.comparing(CityDto::getName)).
                collect(Collectors.toList());
    }


    public String saveAll(MultipartFile multipartFile) throws IOException {
        List<CityDto> cityDtoList = CvsReader(multipartFile.getInputStream());
        List<City> cityList = getMapper().convertFromDtoList(cityDtoList);

            try {
              getRepository().saveAll(cityList);
            } catch (RuntimeException exception) {
                throw new DatabaseException(String.format(ApiMessages.INTERNAL_SERVER_ERROR + " %s", exception.getMessage()));
            }

        return "All data saved";
    }



    private List<CityDto> CvsReader(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<CityDto> cityDtoList = new ArrayList<CityDto>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                CityDto cityDto = new CityDto(
                        Long.parseLong(csvRecord.get("city_code")),
                        csvRecord.get("city")
                        );
                cityDtoList.add(cityDto);
        }
            return cityDtoList;
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


        @Override
    public CityDto update(CityDto dto) {
        return null;
    }
}
