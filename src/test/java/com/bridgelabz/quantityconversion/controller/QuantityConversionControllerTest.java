package com.bridgelabz.quantityconversion.controller;

import static org.junit.Assert.*;
import com.bridgelabz.quantityconversion.service.IQuantityConversionService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class QuantityConversionControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    IQuantityConversionService quantityConversionService;

    Gson gson = new Gson();
    List<String> quantities = new ArrayList<>();

    public QuantityConversionControllerTest() {
        quantities.add("abcd");
        quantities.add("efgh");
        quantities.add("ijkl");
    }

    @Test
    void whenQuantityConversionGetReq_shouldReturnListOfQuantities() throws Exception {
        when(quantityConversionService.getQuantity()).thenReturn(this.quantities);
        MvcResult mvcResult = this.mockMvc.perform(get("/quantity").contentType(MediaType.APPLICATION_JSON)).andReturn();
        String quantityList = mvcResult.getResponse().getContentAsString();
        List<String> quantity = gson.fromJson(quantityList, new TypeToken<ArrayList<String>>(){
        }.getType());
        Assert.assertEquals(3, quantity.size());
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
    }
}
