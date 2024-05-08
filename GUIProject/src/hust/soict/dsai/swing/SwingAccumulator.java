/**
 * @project GUIProject
 * @author Mitchell Vu
 * @since December 2023
 */

package hust.soict.dsai.swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0; // Accumulated sum, init to 0

    // Constructor to set up the GUI components and event handlers
    public SwingAccumulator() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));

        cp.add(new JLabel("Enter an Integer: "));

        tfInput = new JTextField(10);
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        cp.add(new JLabel("The Accumulated Sum is: "));

        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        // Frame settings
        setTitle("Swing Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }

    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the String entered into the TextField tfInput, convert to int
            int numberIn = Integer.parseInt(tfInput.getText());

            sum += numberIn; // Accumulate numbers entered into sum
            tfInput.setText(""); // Clear input TextField
            tfOutput.setText(sum + ""); // Display sum on the output TextField
        }
    }
}
