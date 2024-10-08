import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColumnarTranspositionEncrypter {

    JFrame mainFrame;
    JTextField textField;
    JLabel textFieldLabel;
    JTextField keyField;
    JLabel keyFieldLabel;
    JButton encryptButton;
    JTextField resultField;
    JLabel resultFieldLabel;

    public ColumnarTranspositionEncrypter() {

        mainFrame = new JFrame("Columnar Transposition Encrypter/Decrypter");
        mainFrame.setLayout(null);
        mainFrame.setSize(1600, 900);
        mainFrame.setLocation(150, 20);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textFieldLabel = new JLabel("Enter text:");
        textFieldLabel.setBounds(50, 20, 300, 30);
        mainFrame.add(textFieldLabel);

        textField = new JTextField();
        textField.setBounds(50, 50, 300, 30);
        mainFrame.add(textField);

        keyFieldLabel = new JLabel("Enter key:");
        keyFieldLabel.setBounds(50, 90, 300, 30);
        mainFrame.add(keyFieldLabel);

        keyField = new JTextField();
        keyField.setBounds(50, 120, 300, 30);
        mainFrame.add(keyField);

        encryptButton = new JButton("Encrypt");
        encryptButton.setBounds(50, 160, 100, 30);
        mainFrame.add(encryptButton);

        resultFieldLabel = new JLabel("Encrypted text:");
        resultFieldLabel.setBounds(50, 200, 300, 30);
        mainFrame.add(resultFieldLabel);

        resultField = new JTextField();
        resultField.setBounds(50, 230, 300, 30);
        resultField.setEditable(false);
        mainFrame.add(resultField);

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                int key = Integer.parseInt(keyField.getText());
                String encryptedText = encrypt(text, key);
                resultField.setText(encryptedText);
            }
        });

        mainFrame.setVisible(true);

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

    public static void main(String[] args) {
        new ColumnarTranspositionEncrypter();
    }


}
