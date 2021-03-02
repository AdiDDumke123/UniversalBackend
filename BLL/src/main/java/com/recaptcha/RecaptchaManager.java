package com.recaptcha;

import com.recaptcha.constants.RecaptchaParams;
import com.recaptcha.interfaces.IRecaptchaManager;

import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequestScoped
public class RecaptchaManager implements IRecaptchaManager {

    public String verify(String token) throws IOException, InterruptedException {

        String url = RecaptchaParams.SECURE_URL+"?secret="+RecaptchaParams.SECURE_TOKEN+"&response="+token;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).POST(HttpRequest.BodyPublishers.noBody()).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return  response.body();
    }
}
