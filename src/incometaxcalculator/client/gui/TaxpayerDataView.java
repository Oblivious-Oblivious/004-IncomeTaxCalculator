package incometaxcalculator.client.gui;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import incometaxcalculator.app.receipts.Receipt;
import incometaxcalculator.app.taxpayers.Taxpayer;

public class TaxpayerDataView extends JFrame {
    private JPanel contentPane;

    public TaxpayerDataView(Taxpayer current_taxpayer) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(200, 100, 450, 420);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        DefaultListModel<Integer> receiptsModel = new DefaultListModel<Integer>();

        JList<Integer> receiptsList = new JList<Integer>(receiptsModel);
        receiptsList.setBackground(new Color(153, 204, 204));
        receiptsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        receiptsList.setSelectedIndex(0);
        receiptsList.setVisibleRowCount(3);

        JScrollPane receiptsListScrollPane = new JScrollPane(receiptsList);
        receiptsListScrollPane.setSize(150, 200);
        receiptsListScrollPane.setLocation(100, 170);
        contentPane.add(receiptsListScrollPane);

        HashMap<Integer, Receipt> receipts = current_taxpayer.receiptHashMap;
        Iterator<HashMap.Entry<Integer, Receipt>> iterator = receipts.entrySet().iterator();

        while(iterator.hasNext()) {
            HashMap.Entry<Integer, Receipt> entry = iterator.next();
            Receipt receipt = entry.getValue();
            receiptsModel.addElement(receipt.id);
        }

        AddReceiptView.submit(contentPane, current_taxpayer, receiptsModel);
        DeleteReceiptView.delete(contentPane, current_taxpayer, receiptsModel);
        ViewReportView.produce_report(contentPane, current_taxpayer);
        SaveDataView.export(contentPane, current_taxpayer);

        JTextPane txtpnName = new JTextPane();
        txtpnName.setEditable(false);
        txtpnName.setText("Name :");
        txtpnName.setBounds(10, 34, 92, 20);
        contentPane.add(txtpnName);

        JTextPane txtpnTrn = new JTextPane();
        txtpnTrn.setEditable(false);
        txtpnTrn.setText("TRN :");
        txtpnTrn.setBounds(10, 65, 92, 20);
        contentPane.add(txtpnTrn);

        JTextPane txtpnStatus = new JTextPane();
        txtpnStatus.setEditable(false);
        txtpnStatus.setText("Status :");
        txtpnStatus.setBounds(10, 96, 92, 20);
        contentPane.add(txtpnStatus);

        JTextPane txtpnIncome = new JTextPane();
        txtpnIncome.setEditable(false);
        txtpnIncome.setText("Income :");
        txtpnIncome.setBounds(10, 127, 92, 20);
        contentPane.add(txtpnIncome);

        JTextArea taxpayerName = new JTextArea();
        taxpayerName.setFont(new Font("Tahoma", Font.PLAIN, 11));
        taxpayerName.setEditable(false);
        taxpayerName.setBounds(110, 34, 213, 20);
        taxpayerName.setText(current_taxpayer.fullname);
        contentPane.add(taxpayerName);

        JTextArea taxpayerTRN = new JTextArea();
        taxpayerTRN.setFont(new Font("Tahoma", Font.PLAIN, 11));
        taxpayerTRN.setEditable(false);
        taxpayerTRN.setBounds(110, 65, 213, 20);
        taxpayerTRN.setText(current_taxpayer.taxRegistrationNumber + "");
        contentPane.add(taxpayerTRN);

        JTextArea taxpayerStatus = new JTextArea();
        taxpayerStatus.setFont(new Font("Tahoma", Font.PLAIN, 11));
        taxpayerStatus.setEditable(false);
        taxpayerStatus.setBounds(110, 96, 213, 20);
        taxpayerStatus.setText(current_taxpayer.toString());
        contentPane.add(taxpayerStatus);

        JTextArea taxpayerIncome = new JTextArea();
        taxpayerIncome.setFont(new Font("Tahoma", Font.PLAIN, 11));
        taxpayerIncome.setEditable(false);
        taxpayerIncome.setBounds(112, 127, 213, 20);
        taxpayerIncome.setText("" + current_taxpayer.income);
        contentPane.add(taxpayerIncome);

        JTextPane txtpnReceipts = new JTextPane();
        txtpnReceipts.setEditable(false);
        txtpnReceipts.setText("Receipts :");
        txtpnReceipts.setBounds(10, 170, 80, 20);
        contentPane.add(txtpnReceipts);
    }
}
