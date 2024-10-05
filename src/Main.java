import javax.swing.*;

public class Main {

    JFrame mainFrame;
    JTextField textField;
    JLabel textFieldLabel;

    public Main() {

        mainFrame = new JFrame("Columnar Transposition Encrypter/Decrypter");
        mainFrame.setLayout(null);
        mainFrame.setSize(1600,900);
        mainFrame.setLocation(150,20);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textFieldLabel = new JLabel("Enter text here:");
        textFieldLabel.setBounds(50, 20, 300, 30); // x, y, width, height
        mainFrame.add(textFieldLabel);

        textField = new JTextField();
        textField.setBounds(50, 50, 300, 30); // x, y, width, height
        mainFrame.add(textField);

        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {

        Main startMain = new Main();

    }
}