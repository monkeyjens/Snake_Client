package Logic;

import GUI.Myframe;
import model.Game;
import model.Gamer;
import model.Highscore;
import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jenssillasen on 24/11/2015.
 */
public class Controller  {

    private User user;
    private Myframe mainframe;
    private ServerCon con = new ServerCon();
    private Game[] games;
//
    public Controller() {
        mainframe = new Myframe();
        injectActionListeners();
        mainframe.setVisible(true);
        mainframe.show(Myframe.LOGIN);
    }
    //this method injects action listeners in the class and adds then to each of the UI panels.
    public void injectActionListeners() {
        mainframe.getLoginUI().addActionListener(new MainActionlistener());
        mainframe.getUserMenuPanel().addActionListener(new MainActionlistener());
        mainframe.getJoinGamePanel().addActionListener(new MainActionlistener());
        mainframe.getHighscorePanel().addActionListener(new MainActionlistener());
        mainframe.getDeletePanel().addActionListener(new MainActionlistener());
        mainframe.getPlayGamePanel().addActionListener(new MainActionlistener());
        mainframe.getCreategame().addActionListener(new MainActionlistener());
    }

    private class MainActionlistener implements ActionListener {
        public void actionPerformed(ActionEvent l) {
            try {
                switch (l.getActionCommand()) {
                    case "LoginBtn":
                        user = new User();
                        user.setUsername(mainframe.getLoginUI().getUsername());
                        user.setPassword(mainframe.getLoginUI().getPassword());
                        user = con.login(user);
                        // Shows user menu if user was logged in.
                        if (user != null) mainframe.show(Myframe.USERMENU);
                        mainframe.getLoginUI().clearTextFields();
                        break;

                    case "playBtn":
                        mainframe.show(Myframe.PLAYGAME);
                        break;

                    case "playGameBtn":
                        // Defines a gamer object
                        Gamer gamer = new Gamer();
                        gamer.setControls(mainframe.getCreategame().getUserMoves());
                        gamer.setId(user.getId());

                        // Defines the game object
                        Game game = new Game();
                        game.setMapSize(mainframe.getCreategame().getMapSize());
                        game.setName(mainframe.getCreategame().getGameName());

                        // Specifies gamer as game's host
                        game.setHost(gamer);

                        // Send game object to server and test response
                        if(con.CreateGame(game)) {
                            JOptionPane.showMessageDialog(mainframe, "The Game was succesfully created");
                            mainframe.getCreategame().clearTextFields();
                        } else {
                            JOptionPane.showMessageDialog(mainframe, "An error occured");
                        }
                        break;

                    case "btnJoinGame":
                        int gameNo = mainframe.getJoinGamePanel().getSelectedGame();
                        Game currentGame = games[gameNo];
                        Gamer opponent = new Gamer();
                        opponent.setControls(mainframe.getJoinGamePanel().opponentMovesTF());
                        opponent.setId(user.getId());
                        currentGame.setOpponent(opponent);

                        // User joins the specified game
                        if(con.joinGame(currentGame)) {
                            games = con.listOpenGames();
                            mainframe.getJoinGamePanel().populateOpenGameTable(games);
                            // The game is played
                            if (con.startGame(currentGame)) {
                                mainframe.getJoinGamePanel().clearTextFields();
                                JOptionPane.showMessageDialog(mainframe, "The Game was joined,played and ended. Check highscore to see if you ranked up");
                            } else {
                                JOptionPane.showMessageDialog(mainframe, "The game could not be started. Fix input and/or try again later. Check How To Play for more info ");
                            }
                        } else {
                            JOptionPane.showMessageDialog(mainframe, "The game could not be joined. Fix input and/or try again later. Check How To Play for more info ");
                        }
                        break;

                    case "btnJoinGamePanel":
                        games = con.listOpenGames();
                        mainframe.show(Myframe.JOINGAME);
                        mainframe.getJoinGamePanel().populateOpenGameTable(games);
                        break;

                    case "createGameBtn":
                        mainframe.show(Myframe.CREATE);
                        break;

                    case "howtoplayBtn":
                        JOptionPane.showMessageDialog(mainframe, "The game is controlled with w ( ↑ ) , a ( ←) , s ( ↓ ) , d ( → )\n "
                                + "∞ What you insert is your snakes path,\n ∞ and if you're the host you will set the size of the map \n ∞ For example if the field is set to be '9',\n" +
                                " ∞ Its possible to move 9 times before you hit a wall \n ∞ The opponent will now insert his moves\n ∞ When both players have comitted their moves, the game starts.  \n ∞ The player that runs further, without going into ur opponents snake or the wall \n ∞ ... Wins the game! Good Luck, Have Fun and play safe");
                        break;

                    case "highscoreBtn":
                        Highscore[] highscores = con.getHighscore();
                        mainframe.show(Myframe.HIGHSCORE);
                        mainframe.getHighscorePanel().populateHighScoreTable(highscores);
                        break;

                    case "deleteBtn":
                        mainframe.show(Myframe.DELETE);
                        break;

                    case "deletegameBtn":
                        String gameId = mainframe.getDeletePanel().getGameId();
                        // Tries to delete game, tells user if it was succesfull or not
                        if (con.deleteGame(gameId)) {
                            JOptionPane.showMessageDialog(mainframe, "Game " + gameId + " was deleted");
                        }
                        else {
                            JOptionPane.showMessageDialog(mainframe, "Game " + gameId + " was not deleted");
                        }
                        break;

                    case "playgamereturnBtn":
                        mainframe.show(Myframe.USERMENU);
                        break;

                    case "joingamereturnBtn":
                        mainframe.show(Myframe.PLAYGAME);
                        break;

                    case "createGameReturnBtn":
                        mainframe.show(Myframe.PLAYGAME);
                        break;

                    case "returnhighscoreBtn":
                        mainframe.show(Myframe.USERMENU);
                        break;

                    case "returndeleteBtn":
                        mainframe.show(Myframe.USERMENU);
                        break;

                    case "logoutBtn":
                        mainframe.show(Myframe.LOGIN);
                        break;
                }
            }
            catch (Exception e) {

            }
        }
    }

}
