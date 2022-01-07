package com.homework.java.homework05;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpGetTest {
    private final String testURL = "http://localhost:8801";

    public String test() {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet getTest = new HttpGet(testURL);

        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
            @Override
            public String handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                if (statusCode == 200) {
                    HttpEntity entity = httpResponse.getEntity();
                    return entity == null ? "EMPTY BODY" : EntityUtils.toString(entity);
                } else {
                    return "ERROE: STATUS CODE " + statusCode;
                }
            }
        };

        String response = "";
        try {
            response = client.execute(getTest, responseHandler);
            System.out.println(response);
            client.close();
        } catch (IOException e) {
            return "ERROE: " + e.getMessage();
        }

        return response;
    }
}
