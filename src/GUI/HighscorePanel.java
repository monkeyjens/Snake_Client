package GUI;

/**
 * Created by jenssillasen on 24/11/2015.
 */

        import javax.swing.*;
import java.awt.event.ActionListener;

public class HighscorePanel extends JPanel {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTable table;
    private JButton returnhighscoreBtn;

    /**
     * Create the panel.
     */
    public HighscorePanel() {
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Highscores:");
        lblNewLabel.setBounds(41, 23, 142, 16);
        add(lblNewLabel);

        JLabel lblAchievements = new JLabel("Achievements");
        lblAchievements.setBounds(254, 33, 88, 16);
        add(lblAchievements);

        JLabel lblIcon = new JLabel("Games played:");
        lblIcon.setBounds(254, 85, 102, 16);
        add(lblIcon);

        JLabel lblIcon_1 = new JLabel("Games won:");
        lblIcon_1.setBounds(254, 137, 88, 16);
        add(lblIcon_1);

        JLabel lblIcon_2 = new JLabel("Games lost");
        lblIcon_2.setBounds(254, 183, 88, 16);
        add(lblIcon_2);

        textField = new JTextField();
        textField.setBounds(350, 82, 94, 21);
        add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(350, 180, 94, 21);
        add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(350, 134, 94, 21);
        add(textField_2);

        table = new JTable();
        table.setBounds(39, 60, 179, 184);
        add(table);

        returnhighscoreBtn = new JButton("Return");
        returnhighscoreBtn.setBounds(307, 243, 117, 29);
        returnhighscoreBtn.setActionCommand("returnhighscoreBtn");
        add(returnhighscoreBtn);

    }
    public void addActionListener(ActionListener l)
    {
        returnhighscoreBtn.addActionListener(l);
    }
}
