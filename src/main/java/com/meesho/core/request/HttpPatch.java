package com.meesho.core.request;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HttpPatch {

    public static Response sendPatchRequest(String baseUri, String endPoint, RequestSpecification requestSpecification){

        Response response = requestSpecification.when()
                .baseUri(baseUri)
                .basePath(endPoint)
                .log()
                .all()
                .patch()
                .then()
                .log().status().log().body().extract().response();
        return response;
    }
}
