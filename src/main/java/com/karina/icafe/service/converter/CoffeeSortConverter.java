package com.karina.icafe.service.converter;

import com.karina.icafe.dto.CoffeeSortDto;
import com.karina.icafe.model.CoffeeSort;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class CoffeeSortConverter {

    @Autowired
    private Mapper dozerMapper;

    public CoffeeSort convertTo(CoffeeSortDto dto) {
        return dozerMapper.map(dto, CoffeeSort.class);
    }

    public CoffeeSortDto convertTo(CoffeeSort entity) {
        return dozerMapper.map(entity, CoffeeSortDto.class);
    }

    public List<CoffeeSortDto> convertToDtoList(List<CoffeeSort> modelList) {
        return modelList.stream().map(entity -> dozerMapper.
                map(entity, CoffeeSortDto.class)).collect(Collectors.toList());
    }
}
