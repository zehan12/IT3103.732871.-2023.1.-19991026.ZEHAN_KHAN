package hust.soict.dsai.lab01.Exercises;

import javax.swing.*;

public class ChoosingOption {
    public static void main(String[] args) {
        Object[] options = {"I do", "I don't"};

        int option = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket?", "A Silly Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        System.out.print(option);
        JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        System.exit(0);
    }
}
