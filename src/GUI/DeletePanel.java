package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class DeletePanel extends JPanel {
    private JTextField deleteTF;
    private JButton deletegameBtn;
    private JButton returndeleteBtn;
    /**
     * Create the panel.
     */
    public DeletePanel() {
        setLayout(null);

        JLabel lblDeleteGame = new JLabel("Delete the games that emb(h)arrass you");
        lblDeleteGame.setBounds(33, 28, 256, 16);
        add(lblDeleteGame);

        JLabel lblInsertGameId = new JLabel("Insert Game ID here:");
        lblInsertGameId.setBounds(19, 73, 128, 16);
        add(lblInsertGameId);

        deleteTF = new JTextField();
        deleteTF.setBounds(148, 68, 130, 26);
        add(deleteTF);
        deleteTF.setColumns(10);

        deletegameBtn = new JButton("Delete forever");
        deletegameBtn.setActionCommand("deletegameBtn");
        deletegameBtn.setBounds(148, 118, 117, 29);
        add(deletegameBtn);


        returndeleteBtn = new JButton("Return");
        returndeleteBtn.setBounds(327, 245, 117, 29);
        returndeleteBtn.setActionCommand("returndeleteBtn");
        add(returndeleteBtn);


    }
    public void addActionListener(ActionListener l) {
        deletegameBtn.addActionListener(l);
        returndeleteBtn.addActionListener(l);
    }

    public String getGameId(){
        return deleteTF.getText();
    }

}
