package GUI;

/**
 * Created by jenssillasen on 24/11/2015.
 */

import model.Highscore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class HighscorePanel extends JPanel {

    private JTable table;
    private JButton returnhighscoreBtn;

    /**
     * Create the panel.
     */
    public HighscorePanel() {
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Highscores:");
        lblNewLabel.setFont(new Font("Lithos Pro", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setForeground(new Color(255, 0, 0));
        lblNewLabel.setBounds(144, 17, 142, 30);
        add(lblNewLabel);

        JLabel usernameLbl = new JLabel("Username");
        usernameLbl.setBounds(145, 37 , 83, 24);
        add(usernameLbl);

        JLabel scoreLbl = new JLabel("Score");
        scoreLbl.setBounds(233, 37, 83, 24);
        add(scoreLbl);

        table = new JTable(new DefaultTableModel(new Object[]{"username", "score"}, 0));
        table.setBounds(144, 60, 179, 184);
        add(table);

        returnhighscoreBtn = new JButton("Return");
        returnhighscoreBtn.setBounds(327, 245, 117, 29);
        returnhighscoreBtn.setActionCommand("returnhighscoreBtn");
        add(returnhighscoreBtn);

    }
    public void addActionListener(ActionListener l)
    {
        returnhighscoreBtn.addActionListener(l);
    }

    /**
     * This method fills in my Highscoretabel with my Highscore[]
     *  after that i set my RowCount to 0, so the table doesnt load the same info over and over
     * @param scores  highscores from the server
     */

    public void populateHighScoreTable(Highscore[] scores) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Highscore score : scores) {
            model.addRow(new Object[]{score.getUser().getUsername(), score.getScore()});
        }
    }
}


