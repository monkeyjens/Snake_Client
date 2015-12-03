package GUI;

/**
 * Created by jenssillasen on 24/11/2015.
 */

import model.Game;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class JoinGamePanel extends JPanel {
    private JButton joingamereturnBtn;
    private JButton btnJoinGame;
    private JTable table;
    private JButton htpBtn;
    private JTextField opponentMovesTF;
    private String omoves;

    public JoinGamePanel() {
        setLayout(null);

        table = new JTable(new DefaultTableModel(new Object[]{"Gamename", "Size", "Created"}, 0));
        table.setBounds(39, 60, 350, 150);
        add(table);

        btnJoinGame = new JButton("Join game");
        btnJoinGame.setBounds(40, 250, 182, 29);
        btnJoinGame.setActionCommand("btnJoinGame");
        add(btnJoinGame);

        htpBtn = new JButton("How to play");
        htpBtn.setBounds(327, 220, 117, 29);
        htpBtn.setActionCommand("howtoplayBtn");
        add(htpBtn);

        joingamereturnBtn = new JButton("Return");
        joingamereturnBtn.setBounds(327, 250, 117, 29);
        joingamereturnBtn.setActionCommand("joingamereturnBtn");
        add(joingamereturnBtn);


        opponentMovesTF = new JTextField();
        opponentMovesTF.setBounds(280, 20, 200, 72);
        opponentMovesTF.setActionCommand("opponentMovesTF");
        opponentMovesTF.setColumns(10);
        add(opponentMovesTF);

        JLabel lblNewLabel = new JLabel("Open Games");
        lblNewLabel.setFont(new Font("Lithos Pro", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(144, 12, 178, 29);
        add(lblNewLabel);

        JLabel gameNameLbl = new JLabel("Game Name");
        gameNameLbl.setBounds(40, 39, 83, 24);
        add(gameNameLbl);

        JLabel mapSizeLbl = new JLabel("Map Size");
        mapSizeLbl.setBounds(159, 39, 83, 24);
        add(mapSizeLbl);

        JLabel createdLbl = new JLabel("Created");
        createdLbl.setBounds(274, 39, 83, 24);
        add(createdLbl);


    }
    public void addActionListener(ActionListener l) {
        joingamereturnBtn.addActionListener(l);
        btnJoinGame.addActionListener(l);
        htpBtn.addActionListener(l);
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
    public String opponentMovesTF() {
        omoves = opponentMovesTF.getText();
        return omoves;
    }
}
