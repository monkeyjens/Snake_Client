package GUI;
import javax.swing.*;
import java.awt.event.ActionListener;



public class CreateGamePanel extends JPanel {
    private JButton playgamereturnBtn;
    private JButton howtoplayBtn;
    private JTextField userMovesTF;
    private JTextField mapsizeTF;
    private JButton playGameBtn;
    /**
     * Create the panel.
     */
    public CreateGamePanel() {
        setLayout(null);

        playgamereturnBtn = new JButton("Return");
        playgamereturnBtn.setBounds(297, 251, 117, 29);
        playgamereturnBtn.setActionCommand("playgamereturnBtn");
        add(playgamereturnBtn);


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

        playGameBtn = new JButton("Play Game");
        playGameBtn.setBounds(27, 243, 117, 40);
        playGameBtn.setActionCommand("playGameBtn");
        add(playGameBtn);


        howtoplayBtn = new JButton("How to play");
        howtoplayBtn.setBounds(27, 57, 117, 29);
        howtoplayBtn.setActionCommand("howtoplayBtn");
        add(howtoplayBtn);


    }
    public void addActionListener(ActionListener l)
    {
        playgamereturnBtn.addActionListener(l);
        howtoplayBtn.addActionListener(l);
        playGameBtn.addActionListener(l);
    }

}
