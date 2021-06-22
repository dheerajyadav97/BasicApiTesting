package com.meesho.core.request;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HttpGet {

    public static Response sendGetRequest(String baseUri, String endPoint, RequestSpecification requestSpecification) {

        Response response = requestSpecification.when()
                .baseUri(baseUri)
                .basePath(endPoint)
                .log()
                .all()
                .get()
                .then()
                .log().status().log().body().extract().response();
        return response;
    }
}
