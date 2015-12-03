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
        lblNewLabel.setBounds(144, 23, 142, 30);
        add(lblNewLabel);

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

    public void populateHighScoreTable(Highscore[] scores) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for(Highscore score : scores) {
            model.addRow(new Object[]{score.getUser().getUsername(), score.getScore()});
        }
    }
}
