/**
 * @project GUIProject
 * @author Mitchell Vu
 * @since December 2023
 */

package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0; // Accumulated sum, init to 0

    // Constructor to set up the GUI components and event handlers
    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2));

        // Row 1 - Column 1
        add(new Label("Enter an Integer: "));

        // Row 1 - Column 2
        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        // Row 2 - Column 1
        add(new Label("The Accumulated Sum is: "));

        // Row 2 - Column 2
        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        // Frame settings
        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AWTAccumulator();
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
