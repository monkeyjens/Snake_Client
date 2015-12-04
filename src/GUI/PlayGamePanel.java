package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;



public class PlayGamePanel extends JPanel {
    private JButton playgamereturnBtn;
    private JButton createGameBtn;
    private JButton btnJoinGamePanel;
    private JLabel snakeLbl;
    private JLabel reverseSnakeLbl;
    /**
     * Create the panel.
     */
    public PlayGamePanel() {
        setLayout(null);

        btnJoinGamePanel = new JButton("Join game");
        btnJoinGamePanel.setBounds(190, 50, 117, 29);
        btnJoinGamePanel.setActionCommand("btnJoinGamePanel");
        add(btnJoinGamePanel);

        createGameBtn  = new JButton("Create game");
        createGameBtn.setBounds(190, 80, 117, 29);
        createGameBtn.setActionCommand("createGameBtn");
        add(createGameBtn);

        playgamereturnBtn = new JButton("Return");
        playgamereturnBtn.setBounds(327, 245, 117, 29);
        playgamereturnBtn.setActionCommand("playgamereturnBtn");
        add(playgamereturnBtn);

        snakeLbl = new JLabel();
        snakeLbl.setIcon(new ImageIcon(LoginUI.class.getResource("/Resources/snake256x256left.png")));
        snakeLbl.setBounds(250, 79, 256, 256);
        add(snakeLbl);

        reverseSnakeLbl = new JLabel();
        reverseSnakeLbl.setIcon(new ImageIcon(LoginUI.class.getResource("/Resources/snake256x256reverse.png")));
        reverseSnakeLbl.setBounds(-6, 79, 256, 256);
        add(reverseSnakeLbl);

        JLabel lblCreateGame = new JLabel("Choose your Destiny");
        lblCreateGame.setFont(new Font("Lithos Pro", Font.BOLD | Font.ITALIC, 20));
        lblCreateGame.setForeground(new Color(255, 0, 0));

        lblCreateGame.setBounds(140, 20, 391, 28);
        add(lblCreateGame);

    }
    public void addActionListener(ActionListener l)
    {
        playgamereturnBtn.addActionListener(l);
        createGameBtn.addActionListener(l);
        btnJoinGamePanel.addActionListener(l);
    }

}
