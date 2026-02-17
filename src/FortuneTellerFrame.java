import javax.swing.*;
import java.awt.*;

public class FortuneTellerFrame extends JFrame{
    JPanel mainPanel;
    JPanel iconPanel = new JPanel();
    JPanel displayPanel;
    JPanel controlPanel;

    JTextArea displayTA;
    JScrollPane scroller;

    JLabel titleLabel = new JLabel();
    ImageIcon icon;

    JButton readFortuneBtn;
    JButton quitBtn;

    public static void main (String[] args) {
        new FortuneTellerFrame();
    }
    public FortuneTellerFrame() {
        JPanel contentPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        createTopPanel();
        mainPanel.add(iconPanel, BorderLayout.NORTH);


        createMiddlePanel();
        createBottomPanel();
        JPanel top = new JPanel();

        JFrame ftFrame = new JFrame();

        ftFrame.setTitle("Fortune Teller");
        // MUST GIVE THESE FOR EACH JFRAME
        ftFrame.setSize(400,400); // makes the width and height 400
        ftFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make the program finish when you close the window
        ftFrame.setVisible(true); // make it visible
    }

    private void createTopPanel() {
        JPanel iconPanel = new JPanel();
        ImageIcon icon = new ImageIcon("src/ftImage.jpg");
        titleLabel.setLayout(new BorderLayout());
        titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        iconPanel.add(titleLabel);
    }

    private void createMiddlePanel() {
    }

    private void createBottomPanel() {
    }
}