package com.meesho.core.request;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HttpPost {

    public static Response sendPostRequest(String baseUri, String endPoint, RequestSpecification requestSpecification) {

        Response response = requestSpecification.when()
                .baseUri(baseUri)
                .basePath(endPoint)
                .log()
                .all()
                .post()
                .then()
                .log().status().log().body().extract().response();
        return response;
    }
}
