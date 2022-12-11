package incometaxcalculator.client.gui.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import incometaxcalculator.client.gui.presenters.DeleteTaxpayerPresenter;
import incometaxcalculator.client.gui.presenters.LoadTaxpayerPresenter;
import incometaxcalculator.client.gui.presenters.SelectTaxpayerPresenter;

public class GraphicalInterface extends JFrame {
    private JPanel contentPane;
    private JTextField txtTaxRegistrationNumber;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GraphicalInterface frame = new GraphicalInterface();
                    frame.setVisible(true);
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

        JPanel fileLoaderPanel = new JPanel(new BorderLayout());
        JPanel boxPanel = new JPanel(new BorderLayout());
        JPanel taxRegistrationNumberPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel TRN = new JLabel("Give the tax registration number:");
        JTextField taxRegistrationNumberField = new JTextField(20);
        taxRegistrationNumberPanel.add(TRN);
        taxRegistrationNumberPanel.add(taxRegistrationNumberField);
        JPanel loadPanel = new JPanel(new GridLayout(1, 2));
        loadPanel.add(taxRegistrationNumberPanel);
        fileLoaderPanel.add(boxPanel, BorderLayout.NORTH);
        fileLoaderPanel.add(loadPanel, BorderLayout.CENTER);
        JCheckBox txtBox = new JCheckBox("Txt file");
        JCheckBox xmlBox = new JCheckBox("Xml file");

        txtBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                xmlBox.setSelected(false);
            }
        });

        xmlBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtBox.setSelected(false);
            }
        });
        txtBox.doClick();
        boxPanel.add(txtBox, BorderLayout.WEST);
        boxPanel.add(xmlBox, BorderLayout.EAST);

        DefaultListModel<String> taxRegisterNumberModel = new DefaultListModel<String>();

        JList<String> taxRegisterNumberList = new JList<String>(taxRegisterNumberModel);
        taxRegisterNumberList.setBackground(new Color(153, 204, 204));
        taxRegisterNumberList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taxRegisterNumberList.setSelectedIndex(0);
        taxRegisterNumberList.setVisibleRowCount(3);

        JScrollPane taxRegisterNumberListScrollPane = new JScrollPane(taxRegisterNumberList);
        taxRegisterNumberListScrollPane.setSize(300, 300);
        taxRegisterNumberListScrollPane.setLocation(70, 100);
        contentPane.add(taxRegisterNumberListScrollPane);

        JButton btnLoadTaxpayer = new JButton("Load Taxpayer");
        btnLoadTaxpayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoadTaxpayerPresenter(taxRegisterNumberModel, fileLoaderPanel, taxRegistrationNumberField, txtBox).load();
            }
        });
        btnLoadTaxpayer.setBounds(0, 0, 146, 23);
        contentPane.add(btnLoadTaxpayer);

        JButton btnSelectTaxpayer = new JButton("Select Taxpayer");
        btnSelectTaxpayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SelectTaxpayerPresenter().select();
            }
        });
        btnSelectTaxpayer.setBounds(147, 0, 139, 23);
        contentPane.add(btnSelectTaxpayer);

        JButton btnDeleteTaxpayer = new JButton("Delete Taxpayer");
        btnDeleteTaxpayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new DeleteTaxpayerPresenter(taxRegisterNumberModel).delete();
            }
        });
        btnDeleteTaxpayer.setBounds(287, 0, 146, 23);
        contentPane.add(btnDeleteTaxpayer);

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
