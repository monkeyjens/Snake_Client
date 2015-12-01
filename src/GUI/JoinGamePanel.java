package GUI;

/**
 * Created by jenssillasen on 24/11/2015.
 */

import model.Game;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public class JoinGamePanel extends JPanel {
    private JButton joingamereturnBtn;
    private JButton btnJoinGame;
    private JTable table;
    /**
     * Create the panel.
     */
    public JoinGamePanel() {
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Join game");
        lblNewLabel.setBounds(26, 39, 83, 24);
        add(lblNewLabel);

        table = new JTable(new DefaultTableModel(new Object[]{"Gamename", "Size", "Created"}, 0));
        table.setBounds(39, 60, 179, 184);
        add(table);

        btnJoinGame = new JButton("Join game");
        btnJoinGame.setBounds(105, 236, 182, 29);
        btnJoinGame.setActionCommand("btnJoinGame");
        add(btnJoinGame);

        joingamereturnBtn = new JButton("Return");
        joingamereturnBtn.setBounds(327, 251, 117, 29);
        joingamereturnBtn.setActionCommand("joingamereturnBtn");
        add(joingamereturnBtn);


    }
    public void addActionListener(ActionListener l) {
        joingamereturnBtn.addActionListener(l);
        btnJoinGame.addActionListener(l);
    }

    public void populateOpenGameTable(Game[] games){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for(Game game : games){
            model.addRow(new Object[]{game.getName(), game.getMapSize(), game.getCreated()});
        }
    }

    public int getSelectedGame(){
        return table.getSelectedRow();
    }
}
