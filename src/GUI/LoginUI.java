package GUI;

        import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class LoginUI extends JPanel {
    private JTextField usernametf;
    private JTextField userpwfield;

    private JButton loginBtn;

    /**
     * Create the panel.
     */
    public LoginUI() {
        setLayout(null);

        JLabel lblADifferentQuake = new JLabel("Guided Snakes On A Plane");
        lblADifferentQuake.setForeground(new Color(255, 0, 0));
        lblADifferentQuake.setFont(new Font("Luminari", Font.PLAIN, 15));
        lblADifferentQuake.setBounds(149, 5, 192, 44);
        add(lblADifferentQuake);

        JLabel lblNewLabel_1 = new JLabel("Username:");
        lblNewLabel_1.setForeground(new Color(0, 153, 0));
        lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel_1.setBounds(48, 61, 110, 26);
        add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Password:");
        lblNewLabel_2.setForeground(new Color(0, 153, 0));
        lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel_2.setBounds(48, 135, 87, 26);
        add(lblNewLabel_2);

        usernametf = new JTextField();
        usernametf.setBounds(149, 62, 131, 26);
        add(usernametf);
        usernametf.setColumns(10);

        userpwfield = new JTextField();
        userpwfield.setBounds(149, 136, 131, 26);
        add(userpwfield);
        userpwfield.setColumns(10);

        loginBtn = new JButton();
        loginBtn.setIcon(new ImageIcon(LoginUI.class.getResource("/Resources/presstoplay.png")));
        loginBtn.setBounds(292, 61, 152, 172);
        loginBtn.setActionCommand("LoginBtn");
        add(loginBtn);


    }
    public void addActionListener(ActionListener l)
    {
        loginBtn.addActionListener(l);
    }

    public JTextField getUsernametf() {
        return usernametf;
    }

    public JTextField getUserpwfield() {
        return userpwfield;
    }


    public JButton getLoginBtn() {
        return loginBtn;
    }




}

