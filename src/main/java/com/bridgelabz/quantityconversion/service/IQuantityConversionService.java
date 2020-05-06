package com.bridgelabz.quantityconversion.service;

import com.bridgelabz.quantityconversion.model.QuantityDto;
import com.bridgelabz.quantityconversion.model.QuantityName;
import com.bridgelabz.quantityconversion.model.Unit;

import java.util.List;

public interface IQuantityConversionService {
    List<String> getQuantity();
    List<Unit> getQuantityUnits(QuantityName quantity);
    QuantityDto convertQuantity(QuantityDto quantityDto, Unit userUnit);
}
