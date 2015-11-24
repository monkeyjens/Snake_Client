package GUI;

        import javax.swing.*;
import java.awt.event.ActionListener;

public class PlayGamePanel extends JPanel {
    private JButton playgamereturnBtn;
    private JButton howtoplayBtn;
    /**
     * Create the panel.
     */
    public PlayGamePanel() {
        setLayout(null);

        playgamereturnBtn = new JButton("Return");
        playgamereturnBtn.setBounds(297, 251, 117, 29);
        playgamereturnBtn.setActionCommand("playgamereturnBtn");
        add(playgamereturnBtn);

        JLabel label = new JLabel("New label");
        label.setBounds(36, 228, 61, 16);
        add(label);

        howtoplayBtn = new JButton("How to play");
        howtoplayBtn.setBounds(6, 6, 117, 29);
        howtoplayBtn.setActionCommand("howtoplayBtn");
        add(howtoplayBtn);


    }
    public void addActionListener(ActionListener l)
    {
        playgamereturnBtn.addActionListener(l);
        howtoplayBtn.addActionListener(l);
    }

}
