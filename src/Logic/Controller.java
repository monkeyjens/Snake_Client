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

    public Controller() {



        mainframe = new Myframe();

        injectActionListeners();

        mainframe.setVisible(true);
        mainframe.show(Myframe.LOGIN);
    }
    public void injectActionListeners()
    {
        mainframe.getLoginUI().addActionListener(new MainActionlistener());
        mainframe.getUserMenuPanel().addActionListener(new MainActionlistener());
        mainframe.getJoinGamePanel().addActionListener(new MainActionlistener());
        mainframe.getHighscorePanel().addActionListener(new MainActionlistener());
        mainframe.getDeletePanel().addActionListener(new MainActionlistener());
        mainframe.getPlayGamePanel().addActionListener(new MainActionlistener());
        mainframe.getCreategame().addActionListener(new MainActionlistener());

    }
    private class MainActionlistener implements ActionListener
    {

        public void actionPerformed(ActionEvent l)
        {
            try
            {
                switch (l.getActionCommand())
                {

                    //login menu muligheder
                    case "LoginBtn":
                        user = new User();
                        user.setUsername(mainframe.getLoginUI().getUsername());
                        user.setPassword(mainframe.getLoginUI().getPassword());
                        user = con.login(user);
                        if (user != null) mainframe.show(Myframe.USERMENU);
                        mainframe.getLoginUI().clearTextFields();
                        break;

                    case "playBtn":
                        mainframe.show(Myframe.PLAYGAME);
                        break;

                    case "playGameBtn":
                        Gamer gamer = new Gamer();
                        gamer.setControls(mainframe.getCreategame().getUserMoves());
                        gamer.setId(user.getId());

                        Game game = new Game();
                        game.setMapSize(mainframe.getCreategame().getMapSize());
                        game.setName(mainframe.getCreategame().getGameName());
                        game.setHost(gamer);
                        con.CreateGame(game);
                        break;

                    case "btnJoinGame":
                        mainframe.show(Myframe.JOINGAME);
                        break;

                    case "createGameBtn":
                        mainframe.show(Myframe.CREATE);
                        break;

                    case "joingamereturnBtn":

                        mainframe.show(Myframe.PLAYGAME);
                        break;

                    case "howtoplayBtn":

                        JOptionPane.showMessageDialog(mainframe, "The game is controlled with w ( ↑ ) , a ( ←) , s ( ↓ ) , d ( → )\n "
                                + "∞ What you insert is your snakes path,\n ∞ and if you're the host you will set the size of the map \n ∞ For example if the field is set to be '9',\n" +
                                " ∞ Its possible to move 9 times before you hit a wall \n ∞ The opponent will now insert his moves\n ∞ When both players have comitted their moves, the game starts.  \n ∞ The player that runs further, without going into ur opponents snake or the wall \n ∞ ... Wins the game! Good Luck, Have Fun and play safe");
                        break;

                    case "playgamereturnBtn":

                        mainframe.show(Myframe.PLAYGAME);
                        break;

                    case "highscoreBtn":
                        Highscore[] highscores = con.getHighscore();
                        mainframe.show(Myframe.HIGHSCORE);
                        mainframe.getHighscorePanel().populateHighScoreTable(highscores);

                        break;

                    case "returnhighscoreBtn":

                        mainframe.show(Myframe.USERMENU);
                        break;

                    case "deleteBtn":
                        mainframe.show(Myframe.DELETE);
                        break;

                    case "deletegameBtn":
                        String gameId = mainframe.getDeletePanel().getGameId();

                        boolean success = con.deleteGame(gameId);
                        if (success) {
                            JOptionPane.showMessageDialog(mainframe, "Game " + gameId + " was deleted");
                        }
                        else {
                            JOptionPane.showMessageDialog(mainframe, "Game " + gameId + " was not deleted");
                        }
                        break;

                    case "returndeleteBtn":

                        mainframe.show(Myframe.USERMENU);
                        break;
                    case "logoutBtn":

                        mainframe.show(Myframe.LOGIN);
                        break;
                }
            }
            catch (Exception e)
            {

            }
        }
    }

}
