
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class EgyptianFraction extends JFrame implements ActionListener {

    JLabel num, dom;
    JFormattedTextField numTextField, domTextField;
    JButton addButton;
    JTextArea resultArea;

    public EgyptianFraction() {
        super("Egyptian Fraction");

        num = new JLabel("Enter Numerator: ");
        num.setFont(new Font("Ralewal", Font.BOLD, 20));
        num.setBounds(200, 70, 200, 30);
        add(num);

        numTextField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        numTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        numTextField.setBounds(450, 70, 100, 30);
        add(numTextField);

        dom = new JLabel("Enter Denominator: ");
        dom.setFont(new Font("Ralewal", Font.BOLD, 20));
        dom.setBounds(200, 120, 200, 30);
        add(dom);

        domTextField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        domTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        domTextField.setBounds(450, 120, 100, 30);
        add(domTextField);

        addButton = new JButton("Calculate");
        addButton.setFont(new Font("Raleway", Font.BOLD, 15));
        addButton.setBounds(400, 170, 150, 30);
        addButton.setForeground(Color.WHITE);
        addButton.setBackground(Color.BLACK);
        addButton.addActionListener(this);
        add(addButton);

        resultArea = new JTextArea();
        resultArea.setFont(new Font("Raleway", Font.BOLD, 15));
        resultArea.setBounds(200, 220, 400, 200);
        add(resultArea);


        getContentPane().setBackground(new Color(225, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);
        
    }

    public void calculateEgyptianFraction(int n, int d) {
        StringBuilder result = new StringBuilder();
        while (n != 0) {
            int ceil = (int) Math.ceil((double) d / n);
            result.append("1/").append(ceil);

            n = n * ceil - d;
            d = d * ceil;

            if (n != 0) {
                result.append(" + ");
            }
        }
        resultArea.setText(result.toString());
    }

    public static void main(String[] args) {

        new EgyptianFraction();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        int n = Integer.parseInt(numTextField.getText());
        int d = Integer.parseInt(domTextField.getText());
        calculateEgyptianFraction(n, d);
    } catch (NumberFormatException E) {
        JOptionPane.showMessageDialog(this, "Fill all the fields with Integers only");
        }
    }

}
