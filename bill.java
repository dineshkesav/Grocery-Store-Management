import java.awt.HeadlessException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class bill extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    public bill() {
        initComponents();
        populateComboBoxes();
        addSliderChangeListener();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jSlider1 = new javax.swing.JSlider();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BILL GENERATION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setText("CUSTOMER NAME   :");

        jLabel5.setText("PRODUCT NAME      :");

        jLabel6.setText("ORDER DATE           :");

        jLabel7.setText("QUANTITY                :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 102));
        jLabel8.setText("1");

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setText("<-BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 0));
        jButton2.setText("SUBMIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField1))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jButton1)
                        .addGap(267, 267, 267)
                        .addComponent(jButton2)))
                .addContainerGap(212, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
           mainform mf=new mainform();
           mf.setVisible(true);
           this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        String selectedProduct = jComboBox2.getSelectedItem().toString();
        updateSliderMaxValue(selectedProduct);
    }//GEN-LAST:event_jComboBox2ActionPerformed
    private void populateComboBoxes() {
    try {
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "dinesh07");

        // Populate Customer ComboBox
        String customerSql = "SELECT DISTINCT cname FROM dcustomers";
        st = con.prepareStatement(customerSql);
        rs = st.executeQuery();
        DefaultComboBoxModel<String> customerModel = new DefaultComboBoxModel<>();
        while (rs.next()) {
            customerModel.addElement(rs.getString("cname"));
        }
        jComboBox1.setModel(customerModel);

        // Populate Product ComboBox
        String productSql = "SELECT DISTINCT pname FROM dproduct";
        st = con.prepareStatement(productSql);
        rs = st.executeQuery();
        DefaultComboBoxModel<String> productModel = new DefaultComboBoxModel<>();
        while (rs.next()) {
            productModel.addElement(rs.getString("pname"));
        }
        jComboBox2.setModel(productModel);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}

    private void addSliderChangeListener() {
        jSlider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jLabel8.setText(String.valueOf(jSlider1.getValue()));
            }
        });
    }
    private void updateSliderMaxValue(String productName) {
        try {
            String sql = "SELECT quantity FROM dproduct WHERE pname = ?";
            st = con.prepareStatement(sql);
            st.setString(1, productName);
            rs = st.executeQuery();
            if (rs.next()) {
                int maxQuantity = rs.getInt("quantity");
                jSlider1.setMaximum(maxQuantity);
                jLabel8.setText(String.valueOf(jSlider1.getValue()));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jSlider1StateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here
        try {
        String customerName = jComboBox1.getSelectedItem().toString();
        int customerId = getCustomerId(customerName);
        String productName = jComboBox2.getSelectedItem().toString();
        int productId = getProductId(productName); 
        String dateString = jFormattedTextField1.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsedDate = null;
        try {
        parsedDate = dateFormat.parse(dateString);
        } catch (ParseException ex) {
                Logger.getLogger(bill.class.getName()).log(Level.SEVERE, null, ex);
            }
        java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
        int quantity = jSlider1.getValue();
        double totalPrice = calculateTotalPrice(productId, quantity);
        String insertSql = "INSERT INTO dbill VALUES (?, ?, ?, ?, ?,?,?)";
        st = con.prepareStatement(insertSql);
        st.setInt(1, customerId);
        st.setString(2, customerName);
        st.setInt(3, productId);
        st.setString(4, productName);
        st.setDate(5, sqlDate);
        st.setInt(6, quantity);
        st.setDouble(7, totalPrice);
        st.executeUpdate();       
        JOptionPane.showMessageDialog(null, "Data inserted successfully!");
        int remainingQuantity = getRemainingQuantity(productId) - quantity;
        // Update the product quantity in the database
        updateProductQuantity(productId, remainingQuantity);
        // Show a warning if the remaining quantity is less than five
        if (remainingQuantity < 5) {
            JOptionPane.showMessageDialog(null, "Product quantity is less than 5. Add this Product to the cart .");
        }
        history mf=new history();
        mf.setVisible(true);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
    private int getRemainingQuantity(int productId) throws SQLException {
    String sql = "SELECT quantity FROM dproduct WHERE pid = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, productId);
        try (ResultSet resultSet = ps.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("quantity");
            } else {
                System.out.println("Product quantity not found for product ID: " + productId);
                return -1; // Return -1 if product quantity is not found
            }
        }
    } catch (SQLException e) {
        System.err.println("Error retrieving product quantity: " + e.getMessage());
        return -1; // Return -1 in case of an error
    }
}

private void updateProductQuantity(int productId, int newQuantity) throws SQLException {
    String sql = "UPDATE dproduct SET quantity = ? WHERE pid = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, newQuantity);
        ps.setInt(2, productId);
        ps.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Error updating product quantity: " + e.getMessage());
    }
}
private int getCustomerId(String customerName) throws SQLException {
    String sql = "SELECT cid FROM dcustomers WHERE cname = ?";
    st = con.prepareStatement(sql);
    st.setString(1, customerName);
    rs = st.executeQuery();
    if (rs.next()) {
        int customerId = rs.getInt("cid");
        return customerId;
    } else {
        System.out.println("Customer ID not found for customer name: " + customerName);
        return -1;
    } 
}
private int getProductId(String productName) throws SQLException {
    String sql = "SELECT pid FROM dproduct WHERE pname = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, productName);
        try (ResultSet resultSet = ps.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("pid");
            } else {
                System.out.println("Product ID not found for product name: " + productName);
                return -1; // Return -1 if product ID is not found
            }
        }
    } catch (SQLException e) {
        System.err.println("Error retrieving product ID: " + e.getMessage());
        return -1; // Return -1 in case of an error
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    private double calculateTotalPrice(int productId, int quantity) throws SQLException {
    double totalPrice = 0.0;

    try (CallableStatement cs = con.prepareCall("{ ? = call cal_price(?, ?) }")) {
        cs.registerOutParameter(1, java.sql.Types.DOUBLE);
        cs.setInt(2, productId);
        cs.setInt(3, quantity);
        cs.execute();
        totalPrice = cs.getDouble(1);
    }

    return totalPrice;
}

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
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bill().setVisible(true);
            }
        });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
