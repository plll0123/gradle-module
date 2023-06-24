package org.example;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.io.ByteArrayOutputStream;

public class HttpClientWrapper {

    private final HttpClient client; // private member로 사용됩니다.

    // HttpClient 는 public 메서드의 파라미터로 사용됩니다.
    public HttpClientWrapper(HttpClient client) {
        this.client = client;
    }

    public byte[] doRawGet(String url) {
        HttpGet request = new HttpGet(url);
        try {
            HttpEntity entity = doGet(request);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            entity.writeTo(baos);
            return baos.toByteArray();
        } catch (Exception e) {
            ExceptionUtils.rethrow(e); // ExceptionUtils는 메서드 내부에서만 사용됩니다.
        } finally {
            request.releaseConnection();
        }
        return null;
    }

    // HttpGet 와 HttpEntity 는 private 메서드에서만 사용되므로, API에 속하지 않습니다.
    private HttpEntity doGet(HttpGet get) throws Exception {
        HttpResponse response = client.execute(get);
        if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            System.err.println("Method failed: " + response.getStatusLine());
        }
        return response.getEntity();
    }
}
