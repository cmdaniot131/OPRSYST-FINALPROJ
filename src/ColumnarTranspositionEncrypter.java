import javax.swing.*;

public class ColumnarTranspositionEncrypter {

    JPanel CTEpanel;
    JButton returnB, encryptButton;
    JTextField inputTextField, keyTextField;
    JLabel resultLabel, keyFieldLabel;
    private Main main;

    public ColumnarTranspositionEncrypter(Main main) {
        this.main = main;

        CTEpanel = new JPanel();
        CTEpanel.setLayout(null);

        returnB = new JButton("Return");
        returnB.setBounds(610, 260, 150, 50); // x, y, width, height
        CTEpanel.add(returnB);

        returnB.addActionListener(e -> {
            CTEpanel.setVisible(false);
            main.mainMenu.landingPage.setVisible(true);
        });

        // Input text field
        inputTextField = new JTextField();
        inputTextField.setBounds(100, 100, 300, 30);
        CTEpanel.add(inputTextField);

        // Key text field
        keyFieldLabel = new JLabel("Enter key: (Should be a number)");
        keyFieldLabel.setBounds(100, 150, 300, 30);
        CTEpanel.add(keyFieldLabel);
        keyTextField = new JTextField();
        keyTextField.setBounds(100, 180, 300, 30);
        CTEpanel.add(keyTextField);

        // Encrypt button
        encryptButton = new JButton("Encrypt");
        encryptButton.setBounds(100, 220, 150, 50);
        CTEpanel.add(encryptButton);

        // Result label
        resultLabel = new JLabel("Encrypted Text: ");
        resultLabel.setBounds(100, 280, 500, 30);
        CTEpanel.add(resultLabel);

        encryptButton.addActionListener(e -> {
            String text = inputTextField.getText();
            int key = Integer.parseInt(keyTextField.getText());
            String encryptedText = encrypt(text, key);
            resultLabel.setText("Encrypted Text: " + encryptedText);
        });
    }

    public String encrypt(String text, int key) {
        int textLength = text.length();
        int numRows = (int) Math.ceil((double) textLength / key);
        char[][] grid = new char[numRows][key];

        int index = 0;
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < key; c++) {
                if (index < textLength) {
                    grid[r][c] = text.charAt(index++);
                } else {
                    grid[r][c] = ' ';
                }
            }
        }

        StringBuilder encryptedText = new StringBuilder();
        for (int c = 0; c < key; c++) {
            for (int r = 0; r < numRows; r++) {
                encryptedText.append(grid[r][c]);
            }
        }

        return encryptedText.toString();
    }
}
