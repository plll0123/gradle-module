package org.example;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public void doSomeThing() {
        // module-api에서 api로 제공하는 기능인 httpclient를 implementation으로 변경 시 컴파일 에러 발생
        new HttpClientWrapper(new CloseableHttpClient() {
            @Override
            protected CloseableHttpResponse doExecute(HttpHost target, HttpRequest request, HttpContext context) throws IOException, ClientProtocolException {
                return null;
            }

            @Override
            public void close() throws IOException {

            }

            @Override
            public HttpParams getParams() {
                return null;
            }

            @Override
            public ClientConnectionManager getConnectionManager() {
                return null;
            }
        });
    }
}