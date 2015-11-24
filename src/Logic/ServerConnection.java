package Logic;

import com.google.gson.Gson;
import model.ServerResponse;
import model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jenssillasen on 24/11/2015.
 */
public class ServerConnection {

    private static final String LOGIN_URL = "http://localhost:8888/api/login/";

    public User login(User user) throws IOException {
        String payload = new Gson().toJson(user, User.class);
        System.out.println("Payload to send: " + payload);
        URL obj = new URL(LOGIN_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(payload.getBytes());
        os.flush();
        os.close();

        int responseCode = con.getResponseCode();

        if (responseCode != 200) return null;

        System.out.println("Status code: " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());

        User usr = new User();
        usr.setUsername(user.getUsername());
        usr.setPassword(user.getPassword());
        usr.setId(new Gson().fromJson(response.toString(), ServerResponse.class).getUserid());

        return usr;
    }

}
