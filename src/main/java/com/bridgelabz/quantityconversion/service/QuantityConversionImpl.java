package com.bridgelabz.quantityconversion.service;

import com.bridgelabz.quantityconversion.model.QuantityDto;
import com.bridgelabz.quantityconversion.model.QuantityName;
import com.bridgelabz.quantityconversion.model.Unit;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class QuantityConversionImpl implements IQuantityConversionService{
    public List<String> getQuantity() {
        return Stream.of(QuantityName.values()).map(QuantityName::name)
                .collect(Collectors.toList());
    }

    @Override
    public List<Unit> getQuantityUnits(QuantityName quantity) {
        return Arrays.stream(Unit.values()).filter(unit -> unit.quantityName.equals(quantity)).collect(Collectors.toList());
    }

    @Override
    public QuantityDto convertQuantity(QuantityDto quantityDto, Unit userUnit) {
        double value = quantityDto.getVALUE() * quantityDto.getUNIT().baseUnitConversion
                + quantityDto.getUNIT().additionConstant;
        value = (value - userUnit.additionConstant) / userUnit.baseUnitConversion;
        return new QuantityDto(value, userUnit);
    }
}
