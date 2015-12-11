package Logic;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import model.Game;
import model.Highscore;
import model.ServerResponse;
import model.User;

/**
 * This class contains the internal API that communicates with the game server API.
 */
public class ServerCon {
    /**
     * specifies default protocol, address and port of the server
     */
    public ServerCon() {
        this.hostAddress = "http://localhost";
        this.port = 8888;
    }

    private String hostAddress;
    private int port;

    /**
     * tell the client the server protocol and address
     * @param hostAddress protocol and address of the server
     */
    public void setHostAddress(String hostAddress) {

        this.hostAddress = hostAddress;
    }

    /**
     * tell the client the server TCP port
     *
     * @param port server port number
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * get the server address
     * @return the server address
     */
    public String getHostAddress() {
        return hostAddress;
    }

    /**
     * gets the port number on the server
     * @return the port number
     */
    public int getPort() {
        return port;
    }

    private String httpGet(String path) {
        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        if (response.getStatus() != 200 && response.getStatus() != 201) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        return response.getEntity(String.class);
    }
    // Method to post a generic Json using the HTTP POST method.
    private String httpPost(String json, String path) {
        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

        //throws exception if something went wrong
        if (response.getStatus() != 200 && response.getStatus() != 201) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        return response.getEntity(String.class);
    }
    // Method to put a generic Json using the HTTP POST method.
    private String httpPut(String json, String path) {
        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);

        if (response.getStatus() != 200 && response.getStatus() != 201) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        return response.getEntity(String.class);
    }
    // Method to delete a generic String using the HTTP Delete method.

    private String httpDelete(String path) {
        Client client = Client.create();
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);

        if (response.getStatus() != 200 && response.getStatus() != 201) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        return response.getEntity(String.class);
    }

    /**
     * Logs user in on the game server.
     *
     * @param user User to login, user.username and user.password must be set
     * @return user object with user.id set if true, else null
     */
    //Serveren kontrollerer om det rette brugernavn/kodeord findes og er det korrekt får du bruger id tilbage
    public User login(User user) {
        String payload = new Gson().toJson(user, User.class);
        String response;

        try {
            response = httpPost(payload, "login/");
        } catch (Exception ex) {
            return null;
        }

        User usr = new User();
        usr.setUsername(user.getUsername());
        usr.setPassword(user.getPassword());
        usr.setId(new Gson().fromJson(response.toString(), ServerResponse.class).getUserid());

        return usr;
    }

    /**
     * Deletes a specified game from the game server.
     *
     * @param gameId the server ID of the game to delete
     * @return true if the game is deleted, otherwise false
     */
    public boolean deleteGame(String gameId) {
        String path = "games/" + gameId;
        try {
            httpDelete(path);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    /**
     * Gets high score from the game server.
     *
     * @return the high scores
     */
    public Highscore[] getHighscore() {
        String path = "scores/";
        String response;
        try {
            response = httpGet(path);
        } catch (Exception ex) {
            return null;
        }
        Highscore[] scores = new Gson().fromJson(response, Highscore[].class);
        return scores;
    }

    /**
     * Creates a game on the game server.
     *
     * @param game the game to create, needs game.host.id, game.name, game.host.controls and game.mapSize.
     * @return true is the game is created correctly, otherwise false
     */
    public boolean CreateGame(Game game) {
        String path = "games/";
        String payload = new Gson().toJson(game, Game.class);

        try {
            httpPost(payload, path);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    /**
     * Request list of open games from the game server
     *
     * @return list of open games
     */
    public Game[] listOpenGames() {
        String path = "games/open/";
        String response;

        try {
            response = httpGet(path);

        } catch (Exception ex) {
            //HttpGet throws exception if something went wrong
            return null;
        }
        // Converts JSON into Java object
        Game[] games = new Gson().fromJson(response, Game[].class);
        return games;
    }

    /**
     * Contacts game server to join a specified game.
     *
     * @param requestGame the game to be joined. requestGame.gameId and requestGame.opponent.id has to be set.
     * @return true if the game was succesfully joined otherwise false
     */
    public boolean joinGame(Game requestGame) {
        String path = "games/join/";
        String payload = new Gson().toJson(requestGame, Game.class);

        try {
            httpPut(payload, path);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    /**
     * Ask the server to start the game
     * @param game the game to be started. requestGame.gameId and requestGame.opponent.id has to be set.
     * @return  true if the game was succesfully played otherwise false
     */
    public boolean startGame(Game game) {

        String path = "games/start/";
        String payload = new Gson().toJson(game);

        try {
            httpPut(payload, path);
        } catch (Exception ex) {
            return false;
        }
        return true;

    }
}


