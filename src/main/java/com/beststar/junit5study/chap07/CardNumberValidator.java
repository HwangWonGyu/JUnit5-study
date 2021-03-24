package com.beststar.junit5study.chap07;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class CardNumberValidator {
    public CardValidity validate(String cardNumber) {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost request = new HttpPost("https://some-external-pg.com/card");
        request.setHeader("Content-Type", "text/plain");
        try {
            request.setEntity(new StringEntity(cardNumber));
        } catch (UnsupportedEncodingException e) {
            return CardValidity.ERROR;
        }

        try {

            CloseableHttpResponse response = httpClient.execute(request);
            String json = EntityUtils.toString(response.getEntity(), "UTF-8");
            switch (json) {
                case "ok": return CardValidity.VALID;
                case "bad": return CardValidity.INVALID;
                case "expired": return CardValidity.EXPIRED;
                case "theft": return CardValidity.THEFT;
                default: return CardValidity.UNKNOWN;
            }
        } catch (IOException e) {
            return CardValidity.ERROR;
        }
    }
}
