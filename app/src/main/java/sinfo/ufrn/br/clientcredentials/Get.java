package sinfo.ufrn.br.clientcredentials;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by victor on 21/09/17.
 */

public class Get {
    private String serviceCurso = "curso/<VERSAO>/cursos";

    public void getCurso(String urlBase, String token, String apiKey) throws IOException {
        String url = urlBase + serviceCurso;

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "bearer " + token)
                .addHeader("x-api-key", apiKey)
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
