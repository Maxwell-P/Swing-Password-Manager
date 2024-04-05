import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

public class PasswordGeneratorGUI extends JFrame {
    private JTextField lengthField;
    private JTextField passwordField;

    public PasswordGeneratorGUI() {
        createUI();
        setTitle("Password Generator");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createUI() {
        setLayout(new FlowLayout());

        add(new JLabel("Password Length:"));
        lengthField = new JTextField(10);
        add(lengthField);

        JButton generateButton = new JButton("Generate");
        add(generateButton);

        passwordField = new JTextField(20);
        passwordField.setEditable(false);
        add(passwordField);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length = Integer.parseInt(lengthField.getText());
                String password = generatePassword(length);
                passwordField.setText(password);
            }
        });
    }

    private String generatePassword(int length) {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*";
        String combinedChars = upperCaseLetters + lowerCaseLetters + numbers + specialCharacters;
        SecureRandom random = new SecureRandom();
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }

        return new String(password);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PasswordGeneratorGUI().setVisible(true);
            }
        });
    }
}
