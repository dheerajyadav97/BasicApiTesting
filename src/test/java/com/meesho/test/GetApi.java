package com.meesho.test;

import com.jayway.jsonpath.JsonPath;
import com.meesho.core.common.Constant;
import com.meesho.core.request.HttpGet;
import com.meesho.core.request.RequestSpec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONArray;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetApi extends BaseTest {

    @Test(groups = "group1")
    public void getApi() {

        // Create headers
        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        //Creating queryParam
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("pageId", 1);

        // build request Specification
        RequestSpecification requestSpecification = RequestSpec.getRSpec(headers, null, null, queryParam);

        // sending get request
        Response response = HttpGet.sendGetRequest(Constant.BASE_URL, Constant.getUsersEndPoints, requestSpecification);

        // Verifying api response status code
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        // Get Email from response and verify email format
//        JSONArray actualEmails = JsonPath.parse(response.getBody().asString()).read("$..email");
//        System.out.println(actualEmails);
//        String regex = "^(.+)@(.+)$";
//        Pattern pattern = Pattern.compile(regex);
//        for (Object email : actualEmails) {
//            Matcher matcher = pattern.matcher(email.toString()); // return boolean after validation email
//            Assert.assertTrue(matcher.matches());
//        }

    }

    @Test(groups = "group2")
    public void getApiWithMultipleHeader() {

        // Create headers
        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Cache-Control", "no-cache");

        //Creating queryParam
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("pageId", 2);

        // build request Specification
        RequestSpecification requestSpecification = RequestSpec.getRSpec(headers, null, null, queryParam);

        // sending get request
        Response response = HttpGet.sendGetRequest(Constant.BASE_URL, Constant.getUsersEndPoints, requestSpecification);

        // Verifying api response status code
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);


    }
}

