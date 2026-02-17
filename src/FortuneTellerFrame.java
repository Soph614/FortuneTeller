import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    // declare panels
    JPanel mainPnl;
    JPanel iconPnl;     // will be top panel
    JPanel displayPnl;  // will be center panel
    JPanel buttonPnl;   // will be bottom panel

    // declare variables for top panel (iconPanel)
    JLabel titleLabel;
    ImageIcon icon;

    // declare variables for middle panel (displayPnl)
    JTextArea displayTextArea;
    JScrollPane scrollbar;
    Random rnd = new Random();
    ArrayList<String> fortunes = new ArrayList<>();
    int index;
    String fortune;
    int oldFortune = -1;
    int newFortune;

    // declare variables for bottom panel (buttonPnl)
    JButton readFortuneBtn;
    JButton quitBtn;

    // HERE'S THE CODE THAT RUNS THE FORTUNE TELLER
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
        setSize(800, 650);                 // give JFrame a size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make sure the program ends when the user closes the JFrame
        setVisible(true);                               // make JFrame visible
    }

    private void createIconPanel()
    {
        iconPnl = new JPanel();
        icon = new ImageIcon("src/fortuneTellerImage.jpg");

        // HAVE TO RESIZE THE IMAGE
        // got idea from trolologuy, https://stackoverflow.com/a/18335435 on 02/16/2026... License - CC BY-SA 3.0
        Image tooBigImage = icon.getImage();
        Image smallerImage = tooBigImage.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        icon = new ImageIcon(smallerImage);
        // resizing complete

        titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);        // give the icon a label
        titleLabel.setFont(new Font("Chalkduster", Font.PLAIN, 34));     // make the label authentic
        titleLabel.setVerticalTextPosition(JLabel.TOP);                             // label goes to top
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);                        // label gets centered in the screen

        iconPnl.add(titleLabel);                                                    // add label to icon panel
    }

    private void createDisplayPanel()
    {
        displayPnl = new JPanel();                                                  // initialize display panel
        displayTextArea = new JTextArea(10, 40);                      // set size of display -- is dependent on font and size of font!
        displayTextArea.setEditable(false);                                         // make sure the user can't edit the display
        displayTextArea.setFont(new Font("Herculanum", Font.PLAIN, 20)); // set font, font style, and font size for display
        scrollbar = new JScrollPane(displayTextArea);                               // make the display scrollable
        displayPnl.add(scrollbar);                                                  // add scrollbar to display panel
    }


    private void createControlPanel()
    {
        buttonPnl = new JPanel();                                                   // initialize button panel
        buttonPnl.setLayout(new GridLayout(1, 2));                       // set layout for border panel to a grid layout

        readFortuneBtn = new JButton("Read My Fortune!");                      // title the fortune button
        readFortuneBtn.addActionListener((ActionEvent ae) -> {                      // make the button clickable
            do {                                                                    // this is a loop to make sure no fortune is printed twice IN A ROW
                index = rnd.nextInt(fortunes.size());                               // collect a random integer no bigger than the size of the fortunes ArrayList and name it "index"
                fortune = fortunes.get(index);                                      // get that number fortune from ArrayList of fortunes and set it to variable "fortune"
                newFortune = index;                                                 // assign that index number to integer "newFortune"
            } while (oldFortune == newFortune);                                     // this will keep looping until it gets a new fortune that doesn't match the old fortune
            oldFortune = index;                                                     // assign old index number to "oldFortune"
            displayTextArea.append(fortune + "\n");                                 // display this fortune in the display text area, and move cursor to a new line so  next fortune doesn't get displayed on the same line
        });

        // make the quit button actionable
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        // add the buttons to the button panel
        buttonPnl.add(readFortuneBtn);
        buttonPnl.add(quitBtn);
    }
}
