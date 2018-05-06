package com.practice.bankadvisor.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper
public interface LocalDateMapper {

    LocalDateMapper INSTANCE = Mappers.getMapper( LocalDateMapper.class );

    default LocalDate toLocalDate(String date) {
        if(date == null || StringUtils.isEmpty(date)) {
            return null;
        }
        return LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    default String toString(LocalDate date) {
        if(date == null) {
            return null;
        }
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
