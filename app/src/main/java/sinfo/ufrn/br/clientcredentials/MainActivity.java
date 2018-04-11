package sinfo.ufrn.br.clientcredentials;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;

/**
 * Created by victor on 21/09/17.
 */

public class MainActivity extends AppCompatActivity {

    private final String urlBase = "https://autenticacao.info.ufrn.br/";
    private final String clientId = "CLIENT_ID";
    private final String clientSecret = "CLIENT_SECRET";
    private final String apiKey = "API_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ServiceTask serviceTask = new ServiceTask();
        serviceTask.execute();
    }

    private class ServiceTask extends AsyncTask<Void, Void, Void> {

        protected Void doInBackground(Void... params) {
            try {
                ClientCredentials clientCredentials = new ClientCredentials();
                Get get = new Get();
                try {
                    String token = clientCredentials.getClientCredentials(urlBase, clientId, clientSecret);
                    get.getCurso(urlBase, token, apiKey);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

    }

}
