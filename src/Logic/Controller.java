package Logic;

import GUI.Myframe;
import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jenssillasen on 24/11/2015.
 */

public class Controller  {

    private Myframe mainframe;
    ServerConnection con = new ServerConnection();

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
                        User user = new User();
                        user.setUsername(mainframe.getLoginUI().getUsernametf().getText());
                        user.setPassword(mainframe.getLoginUI().getUserpwfield().getText());
                        user = con.login(user);
                        if (user != null) mainframe.show(Myframe.USERMENU);
                        clearAllTextFields();
                        break;

                    //Usermenu funktioner

                    case "playBtn":
                        clearAllTextFields();
                        mainframe.show(Myframe.PLAYGAME);
                        break;

                    case "howtoplayBtn":
                        clearAllTextFields();
                        JOptionPane.showMessageDialog(mainframe, "Spillet styres med w ( ↑ ) , a ( ←) , s ( ↓ ) , d ( → )\n "
                                + "Du indtaster den rute som din slange skal bevæge sig,\n hvorefter din modstand indtaster sine moves.\n Banen er 9 ryk i højden og bredden.\n Personen der løber længst, uden at krydse modstanderens rute vinder");

                        break;

                    case "playgamereturnBtn":
                        clearAllTextFields();
                        mainframe.show(Myframe.USERMENU);
                        break;

                    case "highscoreBtn":
                        clearAllTextFields();
                        mainframe.show(Myframe.HIGHSCORE);
                        break;

                    case "returnhighscoreBtn":
                        clearAllTextFields();
                        mainframe.show(Myframe.USERMENU);
                        break;

                    case "deleteBtn":
                        clearAllTextFields();
                        mainframe.show(Myframe.DELETE);
                        break;

                    case "returndeleteBtn":
                        clearAllTextFields();
                        mainframe.show(Myframe.USERMENU);

                    case "logoutBtn":
                        clearAllTextFields();
                        mainframe.show(Myframe.LOGIN);
                        break;
                }
            }
            catch (Exception e)
            {

            }
        }
    }
    public void clearAllTextFields()
    {
        mainframe.getLoginUI().getUsernametf().setText("");
        mainframe.getLoginUI().getUserpwfield().setText("");
        /** mainframe.getLoginUI().getNamecreatetextfield().setText("");
        mainframe.getLoginUI().getUsernamecreatetextfield().setText("");
        mainframe.getLoginUI().getEmailtextfield().setText("");
        mainframe.getLoginUI().getCreateuserpasswordfield().setText("");  **/
    }
}
