import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI_sum extends JFrame {
    public GUI_sum() {
        super("TwoNumbersSum");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        final Integer[] a1_ = new Integer[1];
        final Integer[] a2_ = new Integer[1];


        JPanel contents = new JPanel();

        JLabel label1 = new JLabel("Enter first number and press Enter: ");
        contents.add(label1);
        JTextField a1 = new JTextField(5);
        a1.setFont(new Font("Dialog", Font.PLAIN, 15));
        a1.setHorizontalAlignment(JTextField.CENTER);
        a1.setToolTipText("Enter 1st number: ");
        contents.add(a1);

        JLabel label2 = new JLabel("Enter second number and press Enter: ");
        contents.add(label2);
        JTextField a2 = new JTextField(5);
        a2.setFont(new Font("Dialog", Font.PLAIN, 15));
        a2.setHorizontalAlignment(JTextField.CENTER);
        a2.setToolTipText("Enter 2nd number: ");
        contents.add(a2);

        JLabel label_res = new JLabel("Result is: ");
        contents.add(label_res);
        JTextField result = new JTextField(5);
        result.setFont(new Font("Dialog", Font.PLAIN, 15));
        result.setHorizontalAlignment(JTextField.CENTER);
        contents.add(result);

        JButton newButton = new JButton("Sum");
        newButton.setHorizontalAlignment(JButton.BOTTOM);
        contents.add(newButton);
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = Integer.parseInt(a1.getText()) + Integer.parseInt(a2.getText());

                result.setText(Integer.toString(res));
            }
        });

        setContentPane(contents);
        setSize(350,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI_sum();
    }
}
