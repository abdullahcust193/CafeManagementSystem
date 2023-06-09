/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Dao.billDao;
import Dao.categoryDao;
import Dao.productDao;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import FileController.OpenPdf;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Bill;
import model.Category;
import model.Product;
import javax.swing.JOptionPane;

/**
 *
 * @author chabd
 */
public class PlaceOrder extends javax.swing.JFrame {

    public String userEmail;
    public int billId = 1;
    public int grandTotal = 0;
    public int productPrice = 0;
    public int productTotal = 0;
    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobileNoPattern = "^[0-9]*$";

    /**
     * Creates new form PlaceOrder
     */
    public PlaceOrder() {
        initComponents();

    }

    public PlaceOrder(String email) {
        initComponents();
        txtProdPrice.setEditable(false);
        txtProdName.setEditable(false);
        txtProdTotal.setEditable(false);
        btnAddToCart.setEnabled(false);
        btnPrintBill.setEnabled(false);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) txtProdQuntity.getEditor()).getTextField();
        tf.setEnabled(false);
        userEmail = email;
    }

    public void productNameByCategory(String category) {

        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = productDao.getAllRecordsByCategory(category);
        Iterator<Product> itr = list.iterator();
        while (itr.hasNext()) {
            Product productObj = itr.next();
            dtm.addRow(new Object[]{productObj.getName()});
        }
    }

    public void filterProductByname(String name, String category) {

        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = productDao.filterProductByname(name, category);
        Iterator<Product> itr = list.iterator();
        while (itr.hasNext()) {
            Product productObj = itr.next();
            dtm.addRow(new Object[]{productObj.getName()});
        }
    }

    public void clearProductFields() {

        txtProdName.setText("");
        txtProdPrice.setText("");
        txtProdQuntity.setValue(1);
        txtProdTotal.setText("");
        btnAddToCart.setEnabled(false);
    }

    public void validateFields() {
        String customerName = txtCusName.getText();
        String customerEmail = txtCusEmail.getText();
        String customerMobileNumber = txtCusMobileNo.getText();
        if (!customerEmail.equals("") && customerEmail.matches(emailPattern) && customerMobileNumber.matches(mobileNoPattern) && customerMobileNumber.length() == 11 && grandTotal > 0) {
            btnPrintBill.setEnabled(true);
        } else {
            btnPrintBill.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        jLabel_billid = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCusName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCusMobileNo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCusEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtProdName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtProdQuntity = new javax.swing.JSpinner();
        btnClear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtProdPrice = new javax.swing.JTextField();
        btnAddToCart = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtProdTotal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lblGrandTotal = new javax.swing.JLabel();
        btnPrintBill = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\chabd\\OneDrive\\Documents\\NetBeansProjects\\CMSystem\\src\\main\\java\\images\\place order.png")); // NOI18N
        jLabel1.setText("Place Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 180, -1));

        btnClose.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon("C:\\Users\\chabd\\OneDrive\\Documents\\NetBeansProjects\\CMSystem\\src\\main\\java\\images\\close.png")); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1324, 13, 30, 30));

        jLabel_billid.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_billid.setText("Bill ID: --");
        getContentPane().add(jLabel_billid, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 105, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Customer Details:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 158, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 236, -1, -1));

        txtCusName.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtCusName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCusNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtCusName, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 276, 250, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mobile Number");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        txtCusMobileNo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtCusMobileNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCusMobileNoKeyReleased(evt);
            }
        });
        getContentPane().add(txtCusMobileNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 250, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        txtCusEmail.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtCusEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCusEmailKeyReleased(evt);
            }
        });
        getContentPane().add(txtCusEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 250, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Category");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 105, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 156, 230, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Search");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 236, -1, -1));

        txtSearch.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 276, 230, -1));

        jTable1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 347, 230, 340));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Name");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(683, 105, -1, -1));

        txtProdName.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        getContentPane().add(txtProdName, new org.netbeans.lib.awtextra.AbsoluteConstraints(683, 157, 230, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Quantity");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(683, 236, -1, -1));

        txtProdQuntity.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtProdQuntity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtProdQuntityStateChanged(evt);
            }
        });
        getContentPane().add(txtProdQuntity, new org.netbeans.lib.awtextra.AbsoluteConstraints(683, 276, 230, -1));

        btnClear.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon("C:\\Users\\chabd\\OneDrive\\Documents\\NetBeansProjects\\CMSystem\\src\\main\\java\\images\\clear.png")); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(683, 345, 114, -1));

        jTable2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Quantity", "Total"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(683, 394, 578, 290));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Price");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1031, 105, -1, -1));

        txtProdPrice.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        getContentPane().add(txtProdPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1031, 157, 230, -1));

        btnAddToCart.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnAddToCart.setIcon(new javax.swing.ImageIcon("C:\\Users\\chabd\\OneDrive\\Documents\\NetBeansProjects\\CMSystem\\src\\main\\java\\images\\add to cart.png")); // NOI18N
        btnAddToCart.setText("Add To Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1102, 345, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Total");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1031, 236, -1, -1));

        txtProdTotal.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        getContentPane().add(txtProdTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1031, 276, 230, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setText("Grand Total: Rs.");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 710, -1, -1));

        lblGrandTotal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblGrandTotal.setText("000");
        getContentPane().add(lblGrandTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 710, -1, -1));

        btnPrintBill.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnPrintBill.setIcon(new javax.swing.ImageIcon("C:\\Users\\chabd\\OneDrive\\Documents\\NetBeansProjects\\CMSystem\\src\\main\\java\\images\\generate bill & print.png")); // NOI18N
        btnPrintBill.setText("Generate Bills & Report");
        btnPrintBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintBillActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrintBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(998, 710, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\chabd\\OneDrive\\Documents\\NetBeansProjects\\CMSystem\\src\\main\\java\\images\\full-page-background.PNG")); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Home(userEmail).setVisible(true);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearProductFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        billId = Integer.parseInt(billDao.getId());
        jLabel_billid.setText(billDao.getId());
        ArrayList<Category> list = categoryDao.getAllRecords();
        Iterator<Category> itr = list.iterator();
        while (itr.hasNext()) {
            Category categoryObj = itr.next();
            jComboBox1.addItem(categoryObj.getName());
        }
        String category = (String) jComboBox1.getSelectedItem();
        productNameByCategory(category);

    }//GEN-LAST:event_formComponentShown

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String name = txtSearch.getText();
        String category = (String) jComboBox1.getSelectedItem();
        filterProductByname(name, category);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String productName = model.getValueAt(index, 0).toString();
        Product product = productDao.getProductByname(productName);
        txtProdName.setText(product.getName());
        txtProdPrice.setText(product.getPrice());
        txtProdQuntity.setValue(1);
        txtProdTotal.setText(product.getPrice());
        productPrice = Integer.parseInt(product.getPrice());
        productTotal = Integer.parseInt(product.getPrice());
        btnAddToCart.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtProdQuntityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtProdQuntityStateChanged
        // TODO add your handling code here:
        int quantity = (Integer) txtProdQuntity.getValue();
        if (quantity <= 1) {
            txtProdQuntity.setValue(1);
            quantity = 1;
        }
        productTotal = productPrice * quantity;
        txtProdTotal.setText(String.valueOf(productTotal));
    }//GEN-LAST:event_txtProdQuntityStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String category = (String) jComboBox1.getSelectedItem();
        productNameByCategory(category);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        String name = txtProdName.getText();
        String price = txtProdPrice.getText();
        String quantity = String.valueOf(txtProdQuntity.getValue());
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        dtm.addRow(new Object[]{name, price, quantity, productTotal});
        grandTotal = grandTotal + productTotal;
        lblGrandTotal.setText(String.valueOf(grandTotal));
        clearProductFields();
        validateFields();


    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void txtCusNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCusNameKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtCusNameKeyReleased

    private void txtCusMobileNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCusMobileNoKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtCusMobileNoKeyReleased

    private void txtCusEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCusEmailKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtCusEmailKeyReleased

    private void btnPrintBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintBillActionPerformed
        // TODO add your handling code here:
        String customerName = txtCusName.getText();
        String customerMobileNo = txtCusMobileNo.getText();
        String customerEmail = txtCusEmail.getText();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String todayDate = dFormat.format(date);
        String total = String.valueOf(grandTotal);
        String createBy = userEmail;
        Bill bill = new Bill();
        bill.setId(billId);
        bill.setName(customerName);
        bill.setMobileNumber(customerMobileNo);
        bill.setEmail(customerEmail);
        bill.setDate(todayDate);
        bill.setTotal(total);
        bill.setCreateBy(createBy);

        billDao.save(bill);
        // now creating Document
        String path = "D:\\";
        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "" + billId + ".pdf"));
            doc.open();
            Paragraph cafeName = new Paragraph("                                                     Cafe Management System\n");
            doc.add(cafeName);
            Paragraph startLine = new Paragraph("************************************************************************************************************");
            doc.add(startLine);
            Paragraph p3 = new Paragraph("\tBill ID:" + billId + "\nCustomer Name: " + customerName + "Total Paid: " + grandTotal);
            doc.add(p3);
            doc.add(startLine);
            PdfPTable tb1 = new PdfPTable(4);
            tb1.addCell("Name");
            tb1.addCell("Price");
            tb1.addCell("Quantity");
            tb1.addCell("Total");
            for (int i = 0; i < jTable2.getRowCount(); i++) {
                String n = jTable2.getValueAt(i, 0).toString();
                String d = jTable2.getValueAt(i, 1).toString();
                String r = jTable2.getValueAt(i, 2).toString();
                String q = jTable2.getValueAt(i, 3).toString();
                tb1.addCell(n);
                tb1.addCell(d);
                tb1.addCell(r);
                tb1.addCell(q);
            }
            doc.add(tb1);
            doc.add(startLine);
            Paragraph msg = new Paragraph("Thank You, Please visit Again.");
            doc.add(msg);
            OpenPdf.openById(String.valueOf(billId));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        doc.close();
        setVisible(false);
        new PlaceOrder(createBy).setVisible(true);
    }//GEN-LAST:event_btnPrintBillActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int index = jTable2.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove the Product ", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            TableModel model = jTable2.getModel();
            String total = model.getValueAt(index, 3).toString();
            grandTotal = grandTotal - Integer.parseInt(total);
            lblGrandTotal.setText(String.valueOf(grandTotal));
            ((DefaultTableModel) jTable2.getModel()).removeRow(index);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaceOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnPrintBill;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_billid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblGrandTotal;
    private javax.swing.JTextField txtCusEmail;
    private javax.swing.JTextField txtCusMobileNo;
    private javax.swing.JTextField txtCusName;
    private javax.swing.JTextField txtProdName;
    private javax.swing.JTextField txtProdPrice;
    private javax.swing.JSpinner txtProdQuntity;
    private javax.swing.JTextField txtProdTotal;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
