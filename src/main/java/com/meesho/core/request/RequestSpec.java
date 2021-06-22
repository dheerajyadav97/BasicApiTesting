package com.meesho.core.request;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestSpec {

    public static RequestSpecification getRSpec(Map<String, Object> headers, String body, Map<String, Object> pathParam, Map<String, Object> queryParam) {
        RequestSpecification requestSpecification = RestAssured.given().headers(headers);

        if (body != null) {
            requestSpecification.body(body);
        }
        if (pathParam != null) {
            if (!pathParam.isEmpty()) {
                requestSpecification.pathParams(pathParam);
            }
        }
        if (queryParam != null) {
            if (!queryParam.isEmpty()) {
                requestSpecification.queryParams(queryParam);
            }
        }
        return requestSpecification;
    }
}
