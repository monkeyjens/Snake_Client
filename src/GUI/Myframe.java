package GUI;

import javax.swing.*;
import java.awt.*;


public class Myframe extends JFrame {


    public static final String LOGIN = "LOGIN";
    public static final String HIGHSCORE = "HIGHSCORE";
    public static final String MENU = "MENU";
    public static final String PLAYGAME = "PLAYGAME";
    public static final String USERMENU = "USERMENU";
    public static final String JOINGAME = "JOINGAME";
    public static final String DELETE = "DELETE";
    public static final String CREATE = "CREATE";



    private JPanel contentPane;
    private LoginUI loginui;
    private HighscorePanel highscore;
    private JoinGamePanel joingame;
    private DeletePanel deletepanel;
    private PlayGamePanel playgame;
    private UserMenuPanel usermenu;
    private CreateGamePanel creategame;
    private CardLayout c;

    /** * Create the frame.*/
    public Myframe() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 350);

        contentPane = new JPanel();
        c = new CardLayout();
        contentPane.setLayout(c);
        add(contentPane);

        loginui = new LoginUI();
        contentPane.add(loginui, LOGIN);

        highscore = new HighscorePanel();
        contentPane.add(highscore, HIGHSCORE);

        deletepanel = new DeletePanel();
        contentPane.add(deletepanel, DELETE);

        playgame = new PlayGamePanel();
        contentPane.add(playgame, PLAYGAME);

        joingame = new JoinGamePanel();
        contentPane.add(joingame, JOINGAME);

        usermenu = new UserMenuPanel();
        contentPane.add(usermenu, USERMENU);

        creategame = new CreateGamePanel();
        contentPane.add(creategame, CREATE);
    }
    public void show (String card) {
        c.show(contentPane,card);

    }
    public LoginUI getLoginUI()
    {
        return loginui;
    }
    public HighscorePanel getHighscorePanel()
    {
        return highscore;
    }
    public DeletePanel getDeletePanel()
    {
        return deletepanel;
    }
    public JoinGamePanel getJoinGamePanel(){
        return joingame;
    }
    public PlayGamePanel getPlayGamePanel()
    {
        return playgame;
    }
    public UserMenuPanel getUserMenuPanel()
    {
        return usermenu;
    }
    public CreateGamePanel getCreategame() { return creategame; }

}
