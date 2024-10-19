import javax.swing.*;

public class ColumnarTranspositionEncrypter {

    JPanel CTEpanel;
    JButton returnB, encryptButton;
    JTextField inputTextField, keyTextField, resultTextField;
    JLabel inputTextFieldLabel, keyFieldLabel;
    private Main main;

    public ColumnarTranspositionEncrypter(Main main) {
        this.main = main;

        CTEpanel = new JPanel();
        CTEpanel.setLayout(null);

        returnB = new JButton("Return");
        returnB.setBounds(100, 500, 150, 50);

        // Input text field
        inputTextFieldLabel = new JLabel("Input text:");
        inputTextFieldLabel.setBounds(100, 70, 300, 30);
        inputTextField = new JTextField();
        inputTextField.setBounds(100, 100, 300, 30);

        // Key text field
        keyFieldLabel = new JLabel("Enter Integer Key/Offset:");
        keyFieldLabel.setBounds(100, 150, 300, 30);
        keyTextField = new JTextField();
        keyTextField.setBounds(100, 180, 300, 30);

        // Encrypt button
        encryptButton = new JButton("Encrypt");
        encryptButton.setBounds(100, 220, 150, 50);

        // Result text field
        resultTextField = new JTextField();
        resultTextField.setBounds(100, 280, 500, 30);
        resultTextField.setEditable(false);

        CTEpanel.add(encryptButton);
        CTEpanel.add(inputTextField);
        CTEpanel.add(inputTextFieldLabel);
        CTEpanel.add(keyFieldLabel);
        CTEpanel.add(keyTextField);
        CTEpanel.add(returnB);
        CTEpanel.add(resultTextField);

        // Resets the text fields when returning to the selection menu
        returnB.addActionListener(e -> {
            resetFields();
            CTEpanel.setVisible(false);
            main.mainMenu.landingPage.setVisible(true);
        });

        encryptButton.addActionListener(e -> {
            try {
                String text = inputTextField.getText();
                int key = Integer.parseInt(keyTextField.getText());
                String encryptedText = encrypt(text, key);
                resultTextField.setText(encryptedText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer key/offset.");
            }
        });
    }

    private void resetFields() {
        inputTextField.setText("");
        keyTextField.setText("");
        resultTextField.setText("");
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
