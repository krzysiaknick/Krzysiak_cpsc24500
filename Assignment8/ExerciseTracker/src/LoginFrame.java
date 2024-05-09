import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LoginFrame extends JDialog {
    private static LoginFrame instance;

    public static LoginFrame getInstance(JFrame parent) {
        if (instance == null)
            instance = new LoginFrame(parent);
        return instance;
    }

    private final JLabel lblUsername = new JLabel("Username");
    private final JLabel lblPassword = new JLabel("Password");

    private final JTextField txtUsername = new JTextField(15);
    private final JPasswordField txtPassword = new JPasswordField();

    private final JButton btnLogin = new JButton("Login");
    private final JButton btnCancel = new JButton("Cancel");

    private LoginFrame(JFrame parent) {
        super(parent, "Login Window", true);
        setSize(300, 200);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(3, 2, 5, 5));

        add(lblUsername);
        add(txtUsername);
        add(lblPassword);
        add(txtPassword);
        add(btnLogin);
        add(btnCancel);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText().trim();
                String password = new String(txtPassword.getPassword());
                if (verifyLogin(username, password)) {
                    JOptionPane.showMessageDialog(parent, "Login Successful!", "Login", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);  // hide the login window
                } else {
                    JOptionPane.showMessageDialog(parent, "Incorrect username/password", "Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPassword.setText("");
                txtUsername.setText("");
                setVisible(false);  // hide the login window
            }
        });
    }

    private boolean verifyLogin(String username, String password) {
        return "healthy".equals(username) && "donut".equals(password);
    }
}
