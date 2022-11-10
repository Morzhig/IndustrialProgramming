import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI_sum extends JFrame {
    public GUI_sum() {
        super("TwoNumbersSum");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        final int[] a1_ = new int[1];
        final int[] a2_ = new int[1];

        JPanel contents = new JPanel();

        JLabel label1 = new JLabel("Enter first number and press Enter: ");
        contents.add(label1);
        JTextField a1 = new JTextField(5);
        a1.setFont(new Font("Dialog", Font.PLAIN, 20));
        a1.setHorizontalAlignment(JTextField.CENTER);
        a1.setToolTipText("Enter 1st number: ");
        contents.add(a1);

        JLabel label2 = new JLabel("Enter second number and press Enter: ");
        contents.add(label2);
        JTextField a2 = new JTextField(5);
        a2.setFont(new Font("Dialog", Font.PLAIN, 20));
        a2.setHorizontalAlignment(JTextField.CENTER);
        a2.setToolTipText("Enter 2nd number: ");
        contents.add(a2);

        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a1_[0] = Integer.parseInt(a1.getText());
            }
        });

        a2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a2_[0] = Integer.parseInt(a2.getText());
            }
        });

        JButton newButton = new JButton("Sum");
        newButton.setHorizontalAlignment(JButton.CENTER);
        contents.add(newButton);
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = a1_[0] + a2_[0];
                JOptionPane.showMessageDialog(GUI_sum.this,
                        "Ваша сумма: " + res);
            }
        });

        setContentPane(contents);
        setSize(380,170);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI_sum();
    }
}
