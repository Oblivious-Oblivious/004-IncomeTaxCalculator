package incometaxcalculator.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import incometaxcalculator.app.add_receipt.AddReceipt;
import incometaxcalculator.app.delete_receipt.DeleteReceipt;
import incometaxcalculator.app.save_data.SaveData;
import incometaxcalculator.app.view_report.ViewReport;
import incometaxcalculator.data.management.Receipt;
import incometaxcalculator.data.management.TaxpayerManager;

public class TaxpayerData extends JFrame {
  private JPanel contentPane;

  public TaxpayerData(int taxRegistrationNumber, TaxpayerManager taxpayerManager) {
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

    HashMap<Integer, Receipt> receipts = taxpayerManager.getReceiptHashMap(taxRegistrationNumber);
    Iterator<HashMap.Entry<Integer, Receipt>> iterator = receipts.entrySet().iterator();

    while (iterator.hasNext()) {
      HashMap.Entry<Integer, Receipt> entry = iterator.next();
      Receipt receipt = entry.getValue();
      receiptsModel.addElement(receipt.getId());
    }

    JButton btnAddReceipt = new JButton("Add Receipt");
    btnAddReceipt.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new AddReceipt(taxpayerManager, receiptsModel).submit(taxRegistrationNumber);
      }
    });
    btnAddReceipt.setBounds(0, 0, 102, 23);
    contentPane.add(btnAddReceipt);

    JButton btnDeleteReceipt = new JButton("Delete Receipt");
    btnDeleteReceipt.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new DeleteReceipt(taxpayerManager, receiptsModel).delete();
      }
    });
    btnDeleteReceipt.setBounds(100, 0, 120, 23);
    contentPane.add(btnDeleteReceipt);

    JButton btnViewReport = new JButton("View Report");
    btnViewReport.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new ViewReport(taxpayerManager, taxRegistrationNumber).produce_report();
      }
    });
    btnViewReport.setBounds(214, 0, 109, 23);
    contentPane.add(btnViewReport);

    JButton btnSaveData = new JButton("Save Data");
    btnSaveData.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new SaveData(taxpayerManager, taxRegistrationNumber).export();
      }
    });
    btnSaveData.setBounds(322, 0, 102, 23);
    contentPane.add(btnSaveData);

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
    taxpayerName.setText(taxpayerManager.getTaxpayerName(taxRegistrationNumber));
    contentPane.add(taxpayerName);

    JTextArea taxpayerTRN = new JTextArea();
    taxpayerTRN.setFont(new Font("Tahoma", Font.PLAIN, 11));
    taxpayerTRN.setEditable(false);
    taxpayerTRN.setBounds(110, 65, 213, 20);
    taxpayerTRN.setText(taxRegistrationNumber + "");
    contentPane.add(taxpayerTRN);

    JTextArea taxpayerStatus = new JTextArea();
    taxpayerStatus.setFont(new Font("Tahoma", Font.PLAIN, 11));
    taxpayerStatus.setEditable(false);
    taxpayerStatus.setBounds(110, 96, 213, 20);
    taxpayerStatus.setText(taxpayerManager.getTaxpayerStatus(taxRegistrationNumber));
    contentPane.add(taxpayerStatus);

    JTextArea taxpayerIncome = new JTextArea();
    taxpayerIncome.setFont(new Font("Tahoma", Font.PLAIN, 11));
    taxpayerIncome.setEditable(false);
    taxpayerIncome.setBounds(112, 127, 213, 20);
    taxpayerIncome.setText(taxpayerManager.getTaxpayerIncome(taxRegistrationNumber));
    contentPane.add(taxpayerIncome);

    JTextPane txtpnReceipts = new JTextPane();
    txtpnReceipts.setEditable(false);
    txtpnReceipts.setText("Receipts :");
    txtpnReceipts.setBounds(10, 170, 80, 20);
    contentPane.add(txtpnReceipts);
  }
}
