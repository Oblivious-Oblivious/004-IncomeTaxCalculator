package incometaxcalculator.client.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class GraphicalInterface extends JFrame {
    private JPanel contentPane;
    private JTextField txtTaxRegistrationNumber;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GraphicalInterface().setVisible(true);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GraphicalInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 204, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e2) {
            e2.printStackTrace();
        }

        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setBackground(new Color(153, 204, 204));
        textPane.setBounds(0, 21, 433, 441);

        DefaultListModel<String> taxRegisterNumberModel = new DefaultListModel<String>();

        LoadTaxpayerView.load(contentPane, taxRegisterNumberModel);
        SelectTaxpayerView.select(contentPane);
        DeleteTaxpayerView.delete(contentPane, taxRegisterNumberModel);

        txtTaxRegistrationNumber = new JTextField();
        txtTaxRegistrationNumber.setEditable(false);
        txtTaxRegistrationNumber.setBackground(new Color(153, 204, 204));
        txtTaxRegistrationNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtTaxRegistrationNumber.setText("Tax Registration Number:");
        txtTaxRegistrationNumber.setBounds(70, 80, 300, 20);
        contentPane.add(txtTaxRegistrationNumber);
        txtTaxRegistrationNumber.setColumns(10);
    }
}
