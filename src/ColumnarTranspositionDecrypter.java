import javax.swing.*;

public class ColumnarTranspositionDecrypter {

    JPanel CTDpanel;
    JButton returnB, decryptButton;
    JTextField inputTextField, keyTextField, resultTextField;
    JLabel inputTextFieldLabel, keyFieldLabel;
    private Main main;

    public ColumnarTranspositionDecrypter(Main main) {
        this.main = main;

        CTDpanel = new JPanel();
        CTDpanel.setLayout(null);

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

        // Decrypt button
        decryptButton = new JButton("Decrypt");
        decryptButton.setBounds(100, 220, 150, 50);

        // Result text field
        resultTextField = new JTextField();
        resultTextField.setBounds(100, 280, 500, 30);
        resultTextField.setEditable(false);

        CTDpanel.add(decryptButton);
        CTDpanel.add(inputTextField);
        CTDpanel.add(inputTextFieldLabel);
        CTDpanel.add(keyFieldLabel);
        CTDpanel.add(keyTextField);
        CTDpanel.add(returnB);
        CTDpanel.add(resultTextField);

        // Resets the text fields when returning to the selection menu
        returnB.addActionListener(e -> {
            resetFields();
            CTDpanel.setVisible(false);
            main.mainMenu.landingPage.setVisible(true);
        });

        decryptButton.addActionListener(e -> {
            try {
                String text = inputTextField.getText();
                int key = Integer.parseInt(keyTextField.getText());
                String decryptedText = decrypt(text, key);
                resultTextField.setText(decryptedText);
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

    public String decrypt(String text, int key) {
        int textLength = text.length();
        int numRows = (int) Math.ceil((double) textLength / key);
        char[][] grid = new char[numRows][key];

        int index = 0;
        for (int c = 0; c < key; c++) {
            for (int r = 0; r < numRows; r++) {
                if (index < textLength) {
                    grid[r][c] = text.charAt(index++);
                } else {
                    grid[r][c] = ' ';
                }
            }
        }

        StringBuilder decryptedText = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < key; c++) {
                decryptedText.append(grid[r][c]);
            }
        }

        return decryptedText.toString().trim();
    }
}