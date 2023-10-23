package report;

import com.mysql.jdbc.Statement;
import component.model.table.tableCustom;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class panelDataPenjualan extends javax.swing.JPanel {

    public panelDataPenjualan() {
        initComponents();
        setOpaque(false);
        
        tableDataPenjualan();
        
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy");
        
        fieldTahunDataPenjualan.setText(s.format(date));
        
        tableCustom.apply(scrollPaneDataPenjualan, tableCustom.TableType.MULTI_LINE);
    }
    
    public void tableDataPenjualan() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Transaksi");
        model.addColumn("ID Pengguna");
        model.addColumn("Tanggal Transaksi"); 
        model.addColumn("Total Harga");
        model.addColumn("Bayar");
        model.addColumn("Kembalian");
        
        tableDataPenjualan.setModel(model);
        
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_transaksi WHERE tanggal_transaksi LIKE '___"+ comboBoxBulanDataPenjualan.getSelectedItem() +"%'");
            while(result.next()){
                model.addRow(new Object[]{
                    result.getString("id_transaksi"),
                    result.getString("id_pengguna"),
                    result.getString("tanggal_transaksi"),
                    result.getString("total_harga"),
                    result.getString("bayar"),
                    result.getString("kembalian")
                });
                tableDataPenjualan.setModel(model);
            }        
        }
        catch(Exception e){
            System.out.print("Gagal terhubung");
            JOptionPane.showMessageDialog(null,"Koneksi databases error");
        }
    }
    
    private void tanggalDataPenjualan(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Transaksi");
        model.addColumn("ID Pengguna");
        model.addColumn("Tanggal Transaksi"); 
        model.addColumn("Total Harga");
        model.addColumn("Bayar");
        model.addColumn("Kembalian");
        
        tableDataPenjualan.setModel(model);
        
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_transaksi WHERE tanggal_transaksi LIKE '______" + fieldTahunDataPenjualan.getText() + "' AND tanggal_transaksi LIKE '___" + comboBoxBulanDataPenjualan.getSelectedItem() + "%'");
            int no = 1;
            int row = tableDataPenjualan.getRowCount();
            for (int a = 0; a < row; a++) {
                model.removeRow(0);
            }
            while (result.next()) {
                String data[] = {
                    result.getString(1), 
                    result.getString(2), 
                    result.getString(3), 
                    result.getString(4), 
                    result.getString(5),
                    result.getString(6)
                };
                model.addRow(data);
            }
            tableDataPenjualan.setModel(model); no++;        
        }
        catch(Exception e){
            System.out.print("Gagal menampilkan... ");
            JOptionPane.showMessageDialog(null,"Tidak bisa mencari data");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient5 = new component.swing.panelGradient();
        scrollPaneDataPenjualan = new javax.swing.JScrollPane();
        tableDataPenjualan = new javax.swing.JTable();
        labelDataPenjualan = new javax.swing.JLabel();
        panelRound1 = new component.swing.panelRound();
        comboBoxBulanDataPenjualan = new component.swing.comboBoxSuggestion();
        fieldTahunDataPenjualan = new component.swing.textFieldMain();

        panelGradient5.setBackground(new java.awt.Color(238, 238, 238));
        panelGradient5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelGradient5.setColorGradient(new java.awt.Color(242, 242, 242));
        panelGradient5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableDataPenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrollPaneDataPenjualan.setViewportView(tableDataPenjualan);

        panelGradient5.add(scrollPaneDataPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 96, 630, 350));

        labelDataPenjualan.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        labelDataPenjualan.setText("Data Record Penjualan");
        labelDataPenjualan.setIconTextGap(15);
        panelGradient5.add(labelDataPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 60));

        comboBoxBulanDataPenjualan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        comboBoxBulanDataPenjualan.setEditable(false);
        comboBoxBulanDataPenjualan.setMaximumRowCount(5);
        comboBoxBulanDataPenjualan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        comboBoxBulanDataPenjualan.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        comboBoxBulanDataPenjualan.setName("Bulan"); // NOI18N
        comboBoxBulanDataPenjualan.setOpaque(false);
        comboBoxBulanDataPenjualan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comboBoxBulanDataPenjualanKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(comboBoxBulanDataPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboBoxBulanDataPenjualan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        panelGradient5.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 80, 60));

        fieldTahunDataPenjualan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldTahunDataPenjualan.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldTahunDataPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTahunDataPenjualanActionPerformed(evt);
            }
        });
        fieldTahunDataPenjualan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldTahunDataPenjualanKeyReleased(evt);
            }
        });
        panelGradient5.add(fieldTahunDataPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 100, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient5, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient5, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxBulanDataPenjualanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboBoxBulanDataPenjualanKeyReleased
        tanggalDataPenjualan();
    }//GEN-LAST:event_comboBoxBulanDataPenjualanKeyReleased

    private void fieldTahunDataPenjualanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTahunDataPenjualanKeyReleased
        tanggalDataPenjualan();
    }//GEN-LAST:event_fieldTahunDataPenjualanKeyReleased

    private void fieldTahunDataPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTahunDataPenjualanActionPerformed
        tanggalDataPenjualan();
    }//GEN-LAST:event_fieldTahunDataPenjualanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.comboBoxSuggestion comboBoxBulanDataPenjualan;
    private component.swing.textFieldMain fieldTahunDataPenjualan;
    private javax.swing.JLabel labelDataPenjualan;
    private component.swing.panelGradient panelGradient5;
    private component.swing.panelRound panelRound1;
    private javax.swing.JScrollPane scrollPaneDataPenjualan;
    private javax.swing.JTable tableDataPenjualan;
    // End of variables declaration//GEN-END:variables
}
