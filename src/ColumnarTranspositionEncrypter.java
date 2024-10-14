import javax.swing.*;

public class ColumnarTranspositionEncrypter {

    JPanel CTEpanel;
    JButton returnB;
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
    }
}
