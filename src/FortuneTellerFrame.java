import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    // declare panels
    JPanel mainPnl;
    JPanel iconPnl;  // Top
    JPanel displayPnl; // Center
    JPanel buttonPnl; // Bottom

    // declare icon and label for top panel (iconPanel)
    JLabel titleLabel;
    ImageIcon icon;

    // declare text area, scrollbar, randomizer,
    // and arrayList of fortunes for middle panel (displayPanel)
    JTextArea displayTextArea;
    JScrollPane scrollbar;
    Random rnd = new Random();
    ArrayList<String> fortunes = new ArrayList<>();
    int index;
    String fortune;
    int oldFortune = -1;
    int newFortune;

    // declare buttons and label for bottom panel (buttonPanel)
    JButton readFortuneBtn;
    JButton quitBtn;

    // here's the code that runs the Fortune Teller
    public static void main (String[] args) {
            JFrame frame = new FortuneTellerFrame();
    }

    // here's the main method which pulls the other methods together
    public FortuneTellerFrame() {
        // make fortunes
        fortunes.add("Death is in your future.");
        fortunes.add("Pizza is awaiting you.");
        fortunes.add("You should take a shower.");
        fortunes.add("Avoid it, pass not by it, turn from it, and pass away.");
        fortunes.add("The candle of the wicked shall be put out.");
        fortunes.add("Though thou shouldest bray a fool in a mortar among wheat with a pestle, yet will not his foolishness depart from him.");
        fortunes.add("The years of the wicked shall be shortened.");
        fortunes.add("A man of great wrath shall suffer punishment.");
        fortunes.add("Correct thy son, and he shall give thee rest.");
        fortunes.add("A man of understanding shall attain unto wise counsels.");
        fortunes.add("A prating fool shall fall.");
        fortunes.add("He that is surety for a stranger shall smart for it.");
        fortunes.add("The liberal soul shall be made fat.");
        fortunes.add("He that trusteth in his riches shall fall.");
        fortunes.add("The fool shall be servant to the wise of heart.");
        fortunes.add("A wise man will hear, and will increase learning.");
        fortunes.add("The LORD will not suffer the soul of the righteous to famish.");
        fortunes.add("The LORD will destroy the house of the proud.");

        // initialize mainPnl and set layout to borderLayout
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        // run method that creates the icon panel and add it to the main panel
        createIconPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH);

        // run method that creates the display panel (with a text area) and add it to the main panel
        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        // run method that creates the control panel (with buttons) and add it to the main panel
        createControlPanel();
        mainPnl.add(buttonPnl, BorderLayout.SOUTH);

        add(mainPnl);                                   // add the main panel to a JFrame entitled "Fortune Teller"
        setTitle("Fortune Teller");                     // give JFrame a title
        setSize(800, 600);                 // give JFrame a size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make sure the program ends when the user closes the JFrame
        setVisible(true); // make JFrame visible
    }

    private void createIconPanel()
    {
        iconPnl = new JPanel();
        icon = new ImageIcon("src/fortuneTellerImage.jpg");

        // HAVE TO RESIZE THE IMAGE
        // Got idea from trolologuy, https://stackoverflow.com/a/18335435 on 02/16/2026 License - CC BY-SA 3.0
        Image tooBigImage = icon.getImage();
        Image smallerImage = tooBigImage.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        icon = new ImageIcon(smallerImage);
        // resizing complete

        titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLabel.setFont(new Font("Chalkduster", Font.PLAIN, 34));
        // Obscure code to align the text to the Icon!
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        iconPnl.add(titleLabel);
    }

    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        displayTextArea = new JTextArea(10, 50);
        displayTextArea.setEditable(false);
        displayTextArea.setFont(new Font("Herculanum", Font.PLAIN, 16));
        scrollbar = new JScrollPane(displayTextArea);
        displayPnl.add(scrollbar);
    }


    private void createControlPanel()
    {
        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(1, 2));

        readFortuneBtn = new JButton("Read My Fortune!");
        readFortuneBtn.addActionListener((ActionEvent ae) ->
        {
            do {
                index = rnd.nextInt(fortunes.size());
                fortune = fortunes.get(index);
                newFortune = index;
            } while (oldFortune == newFortune);
            oldFortune = index;
            displayTextArea.append(fortune + "\n");
        });

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        buttonPnl.add(readFortuneBtn);
        buttonPnl.add(quitBtn);

    }
}
