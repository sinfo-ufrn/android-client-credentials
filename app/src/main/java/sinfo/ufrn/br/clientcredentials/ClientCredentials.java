package sinfo.ufrn.br.clientcredentials;

import java.io.IOException;

import ca.mimic.oauth2library.OAuth2Client;
import ca.mimic.oauth2library.OAuthResponse;

/**
 * Created by victor on 21/09/17.
 */

public class ClientCredentials {

    public String getClientCredentials(String urlBase, String clientId, String clientSecret) throws IOException {
        String url = urlBase + "authz-server/oauth/token";

        OAuth2Client client = new OAuth2Client.Builder(clientId, clientSecret, url)
                .grantType("client_credentials")
                .build();

        OAuthResponse response = client.requestAccessToken();

        if (response.isSuccessful()) {
            System.out.println(response.getBody());

            return response.getAccessToken();
        }

        throw new IOException(response.getCode() + "," + response.getBody());
    }
}
