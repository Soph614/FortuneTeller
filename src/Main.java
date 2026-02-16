import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setTitle("HOWDY");
        // MUST GIVE THESE FOR EACH JFRAME
        frame.setSize(400,400); // makes the width and height 400
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make the program finish when you close the window
        frame.setVisible(true); // make it visible
    }
}