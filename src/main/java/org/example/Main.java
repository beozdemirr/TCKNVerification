package org.example;

import com.squareup.okhttp.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/soap+xml; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, "" +
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\r\n  <soap12:Body>\r\n    <TCKimlikNoDogrula xmlns=\"http://tckimlik.nvi.gov.tr/WS\">\r\n      " +
                "<TCKimlikNo>41056987280</TCKimlikNo>\r\n      " +
                "<Ad>burak eren</Ad>\r\n      " +
                "<Soyad>özdemir</Soyad>\r\n      " +
                "<DogumYili>1998</DogumYili>\r\n    " +
                "</TCKimlikNoDogrula>\r\n  " +
                "</soap12:Body>\r\n</soap12:Envelope>");
        Request request = new Request.Builder()
                .url("https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx")
                .method("POST", body)
                .addHeader("Content-Type", "application/soap+xml; charset=utf-8")
                .build();
        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());


    }
}