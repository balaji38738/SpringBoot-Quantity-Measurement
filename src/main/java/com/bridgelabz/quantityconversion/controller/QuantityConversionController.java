package com.bridgelabz.quantityconversion.controller;

import com.bridgelabz.quantityconversion.model.QuantityDto;
import com.bridgelabz.quantityconversion.model.QuantityName;
import com.bridgelabz.quantityconversion.model.Unit;
import com.bridgelabz.quantityconversion.service.IQuantityConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuantityConversionController {
    @Autowired
    IQuantityConversionService quantityConversionService;

    @GetMapping("/quantity")
    public ResponseEntity getQuanityList() {
        return new ResponseEntity(quantityConversionService.getQuantity(), HttpStatus.OK);
    }

    @GetMapping("/quantity/{quantityName}")
    public ResponseEntity getUnitList(@PathVariable QuantityName quantityName) {
        return new ResponseEntity(quantityConversionService.getQuantityUnits(quantityName), HttpStatus.OK);
    }

    @PostMapping("/quantity/conversion/{userUnit}")
    public ResponseEntity convertQuantityInUnit(@RequestBody QuantityDto quantityDto, @PathVariable Unit userUnit) {
        return new ResponseEntity(quantityConversionService.convertQuantity(quantityDto, userUnit), HttpStatus.OK);
    }
}
