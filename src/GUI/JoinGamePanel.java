package GUI;

/**
 * Created by jenssillasen on 24/11/2015.
 */
        import javax.swing.*;
import java.awt.event.ActionListener;

public class JoinGamePanel extends JPanel {
    private JButton joingamereturnBtn;
    /**
     * Create the panel.
     */
    public JoinGamePanel() {
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Join game");
        lblNewLabel.setBounds(26, 39, 83, 24);
        add(lblNewLabel);

        joingamereturnBtn = new JButton("Return");
        joingamereturnBtn.setBounds(327, 251, 117, 29);
        joingamereturnBtn.setActionCommand("joingamereturnBtn");
        add(joingamereturnBtn);

    }
    public void addActionListener(ActionListener l)
    {
        joingamereturnBtn.addActionListener(l);
    }
}
