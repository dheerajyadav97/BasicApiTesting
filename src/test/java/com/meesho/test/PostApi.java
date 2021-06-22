package com.meesho.test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.meesho.core.common.Constant;
import com.meesho.core.dataprovider.UserDataProvider;
import com.meesho.core.dto.UsersDto;
import com.meesho.core.request.HttpPost;
import com.meesho.core.request.RequestSpec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PostApi extends BaseTest {

    @Test(dataProvider = "userPostData", dataProviderClass = UserDataProvider.class)
    public void postApi(String name, String job) throws JsonProcessingException {

        // Create request body using lombok and convert into json using jackson lib
        UsersDto usersDto = UsersDto.builder().name(name).job(job).build();                   //lombok
        ObjectMapper objectMapper = new ObjectMapper();                                       //jackson
        String jsonRequest = objectMapper.writeValueAsString(usersDto);                       //jackson

        // Create headers
        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        // build request Specification
        RequestSpecification requestSpecification = RequestSpec.getRSpec(headers, jsonRequest, null , null);

        // sending post request
        Response response = HttpPost.sendPostRequest(Constant.BASE_URL, Constant.postUserEndPoint, requestSpecification);

        // Verifying api response status code
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);

        //Assert post response body
        String actualName = JsonPath.parse(response.getBody().asString()).read("$.name");
        Assert.assertEquals(actualName, name);

        String actualJob = JsonPath.parse(response.getBody().asString()).read("$.job");
        Assert.assertEquals(actualJob, job);

        String actualId = JsonPath.parse(response.getBody().asString()).read("$.id");
        Assert.assertNotNull(actualId);
    }
}
