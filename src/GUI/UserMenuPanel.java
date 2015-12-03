package GUI;
        import javax.swing.*;
import java.awt.event.ActionListener;

public class UserMenuPanel extends JPanel {

    private JButton playBtn;
    private JButton highscoreBtn;
    private JButton deleteBtn;
    private JButton logoutBtn;
    /**
     * Create the panel.
     */
    public UserMenuPanel() {


        setLayout(null);
        setOpaque(false);

        playBtn = new JButton("Play Snake");
        playBtn.setBounds(17, 28, 143, 29);
        playBtn.setActionCommand("playBtn");
        add(playBtn);

        highscoreBtn = new JButton("Highscores");
        highscoreBtn.setBounds(17, 59, 143, 29);
        highscoreBtn.setActionCommand("highscoreBtn");
        add(highscoreBtn);

        deleteBtn = new JButton("Delete Matches");
        deleteBtn.setBounds(17, 89, 143, 29);
        deleteBtn.setActionCommand("deleteBtn");
        add(deleteBtn);

        logoutBtn = new JButton("Log out");
        logoutBtn.setBounds(327, 245, 117, 29);
        logoutBtn.setActionCommand("logoutBtn");
        add(logoutBtn);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(UserMenuPanel.class.getResource("/Resources/snakeBW.png")));
        lblNewLabel.setBounds(154, 18, 278, 235);
        add(lblNewLabel);



    }
    public void addActionListener(ActionListener l)
    {
        playBtn.addActionListener(l);
        highscoreBtn.addActionListener(l);
        deleteBtn.addActionListener(l);
        logoutBtn.addActionListener(l);

    }


}

