package com.meesho.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.meesho.core.common.Constant;
import com.meesho.core.dto.UsersDto;
import com.meesho.core.request.HttpPut;
import com.meesho.core.request.RequestSpec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PutApi extends BaseTest{
    @Test
    public void putApi() throws JsonProcessingException {

        // Create request body using lombok and convert into json using jackson lib
        UsersDto usersDto = UsersDto.builder().name("Bob").job("Automation Testing").build(); //lombok
        ObjectMapper objectMapper = new ObjectMapper();                                       //jackson
        String jsonRequest = objectMapper.writeValueAsString(usersDto);                       //jackson

        // Create headers
        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        //Creating pathParam
        Map<String, Object> pathParam = new HashMap<>();
        pathParam.put("userId", 2);

        // build request Specification
        RequestSpecification requestSpecification = RequestSpec.getRSpec(headers, jsonRequest, pathParam, null);

        // sending put request
        Response response = HttpPut.sendPutRequest(Constant.BASE_URL, Constant.putUserEndPoint, requestSpecification);

        // Verifying api response status code
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        //Assert put response body
        String actualName = JsonPath.parse(response.getBody().asString()).read("$.name");
        Assert.assertEquals(actualName, "Bob");

        String actualJob = JsonPath.parse(response.getBody().asString()).read("$.job");
        Assert.assertEquals(actualJob, "Automation Testing");

        String actualId = JsonPath.parse(response.getBody().asString()).read("$.updatedAt");
        Assert.assertNotNull(actualId);
    }
}

