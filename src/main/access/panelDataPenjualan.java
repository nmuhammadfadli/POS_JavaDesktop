package main.access;

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
        
        Date tahun = new Date();
        SimpleDateFormat simpleTahun = new SimpleDateFormat("yyyy");
        fieldTahunDataPenjualan.setText(simpleTahun.format(tahun));
        
        totalBiaya();
        
        tableDataPenjualan.fixTable(scrollPaneDataPenjualan);
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
    
    public void totalBiaya(){
        int jumlahBaris = tableDataPenjualan.getRowCount();
        int totalBiaya = 0;
        int jumlahbarang =1;
        int hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            //Membuat kondisi aritmatika dengan mengambil value di table
            hargaBarang = Integer.parseInt(tableDataPenjualan.getValueAt(i, 3).toString());
            totalBiaya = totalBiaya + (jumlahbarang * hargaBarang);
        }
        //Meng-set field total bayar dan Jumlah Harga
        fieldTotalPendapatanPenjualan.setText(String.valueOf(totalBiaya));
        fieldTotalPendapatanPenjualan.setText("Rp "+ totalBiaya +",00");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fieldTotalPendapatanPenjualan = new component.swing.textFieldMain();
        panelRound1 = new component.swing.panelRound();
        scrollPaneDataPenjualan = new javax.swing.JScrollPane();
        tableDataPenjualan = new component.model.tableCustom.table();
        fieldTahunDataPenjualan = new component.swing.textFieldMain();
        jLabel8 = new javax.swing.JLabel();
        panelRound2 = new component.swing.panelRound();
        comboBoxBulanDataPenjualan = new component.swing.comboBoxSuggestion();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel1.setText("Total Pendapatan");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        fieldTotalPendapatanPenjualan.setEditable(false);
        fieldTotalPendapatanPenjualan.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldTotalPendapatanPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 240, 60));

        panelRound1.setLayout(new java.awt.BorderLayout());

        scrollPaneDataPenjualan.setBorder(null);

        tableDataPenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollPaneDataPenjualan.setViewportView(tableDataPenjualan);

        panelRound1.add(scrollPaneDataPenjualan, java.awt.BorderLayout.CENTER);

        add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 840, 410));

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
        add(fieldTahunDataPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 110, 60));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel8.setText("Tahun");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));

        panelRound2.setLayout(new java.awt.BorderLayout());

        comboBoxBulanDataPenjualan.setBorder(null);
        comboBoxBulanDataPenjualan.setEditable(false);
        comboBoxBulanDataPenjualan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        comboBoxBulanDataPenjualan.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        comboBoxBulanDataPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxBulanDataPenjualanActionPerformed(evt);
            }
        });
        comboBoxBulanDataPenjualan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                comboBoxBulanDataPenjualanKeyTyped(evt);
            }
        });
        panelRound2.add(comboBoxBulanDataPenjualan, java.awt.BorderLayout.CENTER);

        add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 70, 60));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel2.setText("Bulan");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 50, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void fieldTahunDataPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTahunDataPenjualanActionPerformed
        tanggalDataPenjualan();
        totalBiaya();
    }//GEN-LAST:event_fieldTahunDataPenjualanActionPerformed

    private void fieldTahunDataPenjualanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTahunDataPenjualanKeyReleased
        tanggalDataPenjualan();
        totalBiaya();
    }//GEN-LAST:event_fieldTahunDataPenjualanKeyReleased

    private void comboBoxBulanDataPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxBulanDataPenjualanActionPerformed
        tanggalDataPenjualan();
        totalBiaya();
    }//GEN-LAST:event_comboBoxBulanDataPenjualanActionPerformed

    private void comboBoxBulanDataPenjualanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboBoxBulanDataPenjualanKeyTyped
        tanggalDataPenjualan();
        totalBiaya();
    }//GEN-LAST:event_comboBoxBulanDataPenjualanKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.comboBoxSuggestion comboBoxBulanDataPenjualan;
    private component.swing.textFieldMain fieldTahunDataPenjualan;
    private component.swing.textFieldMain fieldTotalPendapatanPenjualan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private component.swing.panelRound panelRound1;
    private component.swing.panelRound panelRound2;
    private javax.swing.JScrollPane scrollPaneDataPenjualan;
    private component.model.tableCustom.table tableDataPenjualan;
    // End of variables declaration//GEN-END:variables
}
