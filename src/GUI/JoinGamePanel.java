package GUI;

/**
 * Created by jenssillasen on 24/11/2015.
 */
        import javax.swing.*;
import java.awt.event.ActionListener;

public class JoinGamePanel extends JPanel {
    private JButton joingamereturnBtn;
    private JTextField opponentIdTF;
    private JTextField txtGameidtf;
    private JButton btnJoinGame;
    private JButton btnJoinGameFrom;
    /**
     * Create the panel.
     */
    public JoinGamePanel() {
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Join game");
        lblNewLabel.setBounds(26, 39, 83, 24);
        add(lblNewLabel);

        JLabel lblInsertYourOpponents = new JLabel("Insert your opponents ID here");
        lblInsertYourOpponents.setBounds(27, 91, 229, 16);
        add(lblInsertYourOpponents);

        JLabel lblInsertYour = new JLabel("Insert the game ID here ");
        lblInsertYour.setBounds(27, 119, 189, 16);
        add(lblInsertYour);

        JLabel lblPendingGamesReady = new JLabel("Choose between all pending games avaible:");
        lblPendingGamesReady.setBounds(6, 170, 281, 16);
        add(lblPendingGamesReady);

        opponentIdTF = new JTextField();
        opponentIdTF.setBounds(301, 86, 130, 26);
        opponentIdTF.setActionCommand("opponentIdTF");
        add(opponentIdTF);
        opponentIdTF.setColumns(10);

        txtGameidtf = new JTextField();
        txtGameidtf.setBounds(301, 114, 130, 26);
        txtGameidtf.setActionCommand("txtGameidtf");
        add(txtGameidtf);
        txtGameidtf.setColumns(10);

        btnJoinGame = new JButton("Join Game");
        btnJoinGame.setBounds(314, 141, 117, 29);
        btnJoinGame.setActionCommand("btnJoinGame");
        add(btnJoinGame);

        btnJoinGameFrom = new JButton("Join game from this list");
        btnJoinGameFrom.setBounds(105, 236, 182, 29);
        btnJoinGameFrom.setActionCommand("btnJoinGameFrom");
        add(btnJoinGameFrom);

        joingamereturnBtn = new JButton("Return");
        joingamereturnBtn.setBounds(327, 251, 117, 29);
        joingamereturnBtn.setActionCommand("joingamereturnBtn");
        add(joingamereturnBtn);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(108, 198, 179, 26);
        add(comboBox);

    }
    public void addActionListener(ActionListener l)
    {

        joingamereturnBtn.addActionListener(l);
        opponentIdTF.addActionListener(l);
        txtGameidtf.addActionListener(l);
        btnJoinGame.addActionListener(l);
        btnJoinGameFrom.addActionListener(l);
    }
}
