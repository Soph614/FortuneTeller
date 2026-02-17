import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    // initialize panels
    JPanel mainPnl;
    JPanel iconPnl;  // Top
    JPanel displayPnl; // Center
    JPanel buttonPnl; // Bottom

    // initialize icon and label for top panel (iconPanel)
    JLabel titleLabel;
    ImageIcon icon;

    // initialize text area, scrollbar, randomizer,
    // and arrayList of fortunes for middle panel (displayPanel)
    JTextArea displayTextArea;
    JScrollPane scrollbar;
    Random rnd = new Random();
    ArrayList<String> fortunes = new ArrayList<>();

    // initialize buttons and label for bottom panel (buttonPanel)
    JButton readFortuneBtn;
    JButton quitBtn;

    public static void main (String[] args) {
            JFrame frame = new FortuneTellerFrame();
    }

    public FortuneTellerFrame()
    {
        fortunes.add("Death is in your future.");
        fortunes.add("A large pepperoni pizza is awaiting you.");
        fortunes.add("Your next roommate will be very unorganized.");
        fortunes.add("You need to take a shower more often.");
        fortunes.add("Your next best friend will listen without saying anything! Aside from a meow here and there.");
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createIconPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(buttonPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setTitle("Fortune Teller");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
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
            int index = rnd.nextInt(fortunes.size());
            String fortune = fortunes.get(index);
            displayTextArea.append(fortune +"\n");
        });

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        buttonPnl.add(readFortuneBtn);
        buttonPnl.add(quitBtn);

    }
}
