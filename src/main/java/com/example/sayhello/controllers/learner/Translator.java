package com.example.sayhello.controllers.learner;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

public class Translator {
    private static String key = "1f7ecfee5060477d80ea75fd407c5f21";
    private static String location = "southeastasia";

    // Instantiates the HttpClient.
    HttpClient client = HttpClient.newHttpClient();

    // This function performs a POST request.
    public String Post(String text,String lang_n,String lang_l) throws IOException, InterruptedException {
        String jsonBody = "[{\"Text\": \""+text+"\"}]";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&from="+lang_n+"&to="+lang_l))
                .header("Content-Type", "application/json")
                .header("Ocp-Apim-Subscription-Key", key)
                .header("Ocp-Apim-Subscription-Region", location)
                .POST(BodyPublishers.ofString(jsonBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }

    public static String trans(String args,String lang_n,String lang_l) {
        try {
            Translator translateRequest = new Translator();
            String response = translateRequest.Post(args,lang_n,lang_l);

            return response.substring(response.indexOf("text")+7,response.indexOf(",")-1);
        } catch (Exception e) {
            return "Error";
        }
    }
}
