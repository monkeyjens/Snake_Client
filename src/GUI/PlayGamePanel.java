package GUI;
import javax.swing.*;
import java.awt.event.ActionListener;



public class PlayGamePanel extends JPanel {
    private JButton playgamereturnBtn;
    private JButton howtoplayBtn;
    private JTextField userMovesTF;
    private JTextField mapsizeTF;
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

        JLabel lblCreateGame = new JLabel("In here you can choose if you want to host or");
        lblCreateGame.setBounds(27, 29, 391, 16);
        add(lblCreateGame);

        JLabel lblMakeYouMoves = new JLabel("Insert your moves in the field below\n");
        lblMakeYouMoves.setBounds(27, 95, 236, 16);
        add(lblMakeYouMoves);

        JLabel lblSetTheSize = new JLabel("Set the size of the map:");
        lblSetTheSize.setBounds(27, 199, 191, 16);
        add(lblSetTheSize);

        JLabel lblW = new JLabel("w ( ↑ ) , a ( ←) , s ( ↓ ) , d ( → )");
        lblW.setBounds(27, 111, 326, 16);
        add(lblW);

        userMovesTF = new JTextField();
        userMovesTF.setBounds(27, 123, 200, 72);
        userMovesTF.setActionCommand("userMovesTF");
        userMovesTF.setColumns(10);
        add(userMovesTF);

        mapsizeTF = new JTextField();
        mapsizeTF.setBounds(27, 217, 134, 26);
        mapsizeTF.setActionCommand("mapsizeTF");
        mapsizeTF.setColumns(10);
        add(mapsizeTF);

        createGameBtn  = new JButton("Create game");
        createGameBtn.setBounds(27, 243, 117, 40);
        createGameBtn.setActionCommand("createGameBtn");
        add(createGameBtn);

        btnJoinGame  = new JButton("Join game");
        btnJoinGame.setBounds(315, 24, 117, 29);
        btnJoinGame.setActionCommand("btnJoinGame");
        add(btnJoinGame);

        howtoplayBtn = new JButton("How to play");
        howtoplayBtn.setBounds(27, 57, 117, 29);
        howtoplayBtn.setActionCommand("howtoplayBtn");
        add(howtoplayBtn);


    }
    public void addActionListener(ActionListener l)
    {
        playgamereturnBtn.addActionListener(l);
        howtoplayBtn.addActionListener(l);
        createGameBtn.addActionListener(l);
        btnJoinGame.addActionListener(l);
    }

}
