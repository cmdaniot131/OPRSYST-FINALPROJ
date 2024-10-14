import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainMenu {

    JPanel landingPage;
    private Main main;
    JButton encryptButton, decryptButton;
    JLabel textFieldLabel;

    public MainMenu(Main main) {
        this.main = main;

        landingPage = new JPanel();
        landingPage.setLayout(null);
        landingPage.setOpaque(false);

        // Choose encryption or decryption
        textFieldLabel = new JLabel("Choose to encrypt or decrypt:");
        textFieldLabel.setBounds(100, 50, 300, 30);
        textFieldLabel.setFont(new Font("Arial", Font.BOLD, 20));
        landingPage.add(textFieldLabel);

        // Buttons
        encryptButton = new JButton("Encrypt");
        encryptButton.setBounds(610, 100, 150, 50); // x, y, width, height
        landingPage.add(encryptButton);

        decryptButton = new JButton("Decrypt");
        decryptButton.setBounds(610, 180, 150, 50); // x, y, width, height
        landingPage.add(decryptButton);

        // Place textFieldLabel and Buttons in the middle
        Dimension labelSize = textFieldLabel.getPreferredSize();
        int labelX = (1366 - labelSize.width) / 2;
        textFieldLabel.setBounds(labelX, 50, labelSize.width, labelSize.height);
        landingPage.add(textFieldLabel);

        // Add MouseListener to encryptButton
        encryptButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                main.encryptionPage.CTEpanel.setVisible(true);
                landingPage.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
}