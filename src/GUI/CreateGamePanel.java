package GUI;
import javax.swing.*;
import java.awt.event.ActionListener;



public class CreateGamePanel extends JPanel {
    private JButton createGameReturnBtn;
    private JButton howtoplayBtn;
    private JTextField userMovesTF;
    private JTextField mapsizeTF;
    private JButton playGameBtn;
    private JTextField mapNameTF;
    /**
     * Create the panel.
     */
    public CreateGamePanel() {
        setLayout(null);

        userMovesTF = new JTextField();
        userMovesTF.setBounds(27, 123, 200, 35);
        userMovesTF.setActionCommand("userMovesTF");
        userMovesTF.setColumns(10);
        add(userMovesTF);

        mapsizeTF = new JTextField();
        mapsizeTF.setBounds(27, 210, 200, 35);
        mapsizeTF.setActionCommand("mapsizeTF");
        mapsizeTF.setColumns(10);
        add(mapsizeTF);

        playGameBtn = new JButton("Play Game");
        playGameBtn.setBounds(27, 260, 117, 40);
        playGameBtn.setActionCommand("playGameBtn");
        add(playGameBtn);

        howtoplayBtn = new JButton("How to play");
        howtoplayBtn.setBounds(327, 220, 117, 29);
        howtoplayBtn.setActionCommand("howtoplayBtn");
        add(howtoplayBtn);

        mapNameTF = new JTextField();
        mapNameTF.setBounds(27, 50, 134, 26);
        mapNameTF.setActionCommand("mapNameTF");
        mapNameTF.setColumns(10);
        add(mapNameTF);

        createGameReturnBtn = new JButton("Return");
        createGameReturnBtn.setBounds(327, 245, 117, 29);
        createGameReturnBtn.setActionCommand("createGameReturnBtn");
        add(createGameReturnBtn);

        JLabel labelGameName = new JLabel("Game name:");
        labelGameName.setBounds(31, 30, 191, 16);
        add(labelGameName);

        JLabel lblMakeYouMoves = new JLabel("Insert your moves in the field below\n");
        lblMakeYouMoves.setBounds(31, 85, 236, 16);
        add(lblMakeYouMoves);

        JLabel lblSetTheSize = new JLabel("Set the size of the map:");
        lblSetTheSize.setBounds(31, 192, 191, 16);
        add(lblSetTheSize);

        JLabel lblW = new JLabel("w ( ↑ ) , a ( ←) , s ( ↓ ) , d ( → )");
        lblW.setBounds(31, 105, 326, 16);
        add(lblW);

    }
    public void addActionListener(ActionListener l)
    {
        createGameReturnBtn.addActionListener(l);
        howtoplayBtn.addActionListener(l);
        playGameBtn.addActionListener(l);
        mapNameTF.addActionListener(l);
    }

    public int getMapSize(){
        return Integer.parseInt(mapsizeTF.getText());
    }

    public String getGameName(){
        return mapNameTF.getText();
    }

    public String getUserMoves() {
        return userMovesTF.getText();
    }

    public void clearTextFields() {
        mapNameTF.setText("");
        mapsizeTF.setText("");
        userMovesTF.setText("");
    }
}
