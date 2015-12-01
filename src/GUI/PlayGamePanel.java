package GUI;
import javax.swing.*;
import java.awt.event.ActionListener;



public class PlayGamePanel extends JPanel {
    private JButton playgamereturnBtn;
    private JButton createGameBtn;
    private JButton btnJoinGame;
    /**
     * Create the panel.
     */
    public PlayGamePanel() {
        setLayout(null);

        playgamereturnBtn = new JButton("Return");
        playgamereturnBtn.setBounds(297, 251, 117, 29);
        playgamereturnBtn.setActionCommand("playgamereturnBtn");
        add(playgamereturnBtn);

        createGameBtn  = new JButton("Create game");
        createGameBtn.setBounds(27, 243, 117, 40);
        createGameBtn.setActionCommand("createGameBtn");
        add(createGameBtn);

        btnJoinGame  = new JButton("Join game");
        btnJoinGame.setBounds(315, 24, 117, 29);
        btnJoinGame.setActionCommand("btnJoinGame");
        add(btnJoinGame);

        JLabel lblCreateGame = new JLabel("GAME");
        lblCreateGame.setBounds(27, 29, 391, 16);
        add(lblCreateGame);


    }
    public void addActionListener(ActionListener l)
    {
        playgamereturnBtn.addActionListener(l);
        createGameBtn.addActionListener(l);
        btnJoinGame.addActionListener(l);
    }

}
