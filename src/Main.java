import javax.swing.*;

public class Main {

    JFrame mainFrame;
    MainMenu mainMenu;
    ColumnarTranspositionEncrypter encryptionPage;
    ColumnarTranspositionDecrypter decryptionPage;

    public Main() {
        mainFrame = new JFrame("Columnar Transposition Encrypter/Decrypter");
        mainFrame.setLayout(null);
        mainFrame.setSize(1366, 768);
        mainFrame.setLocation(150, 20);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainMenu = new MainMenu(this);
        mainMenu.landingPage.setBounds(0, 0, 1366, 768);
        mainFrame.add(mainMenu.landingPage);

        encryptionPage = new ColumnarTranspositionEncrypter(this);
        encryptionPage.CTEpanel.setBounds(0, 0, 1366, 768);
        encryptionPage.CTEpanel.setVisible(false);
        mainFrame.add(encryptionPage.CTEpanel);

        decryptionPage = new ColumnarTranspositionDecrypter(this);
        decryptionPage.CTDpanel.setBounds(0, 0, 1366, 768);
        decryptionPage.CTDpanel.setVisible(false);
        mainFrame.add(decryptionPage.CTDpanel);

        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Main startMain = new Main();
    }
}
