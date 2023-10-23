package main.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class panelLaporan extends javax.swing.JPanel {

    private DefaultTableModel model;
    
    private int a;
    
    public panelLaporan() {
        initComponents();
        setOpaque(false);
        
        String[] judul = {"ID Kategori", "Nama Kategori", "Jumlah Terjual"};
        model = new DefaultTableModel(judul, 0);
        tableDataLaporan.setModel(model);
        
        omset();
        pengeluaran();
        keuntungan();
        tampilkan();
        
        tableDataLaporan.fixTable(scrollPaneDataLaporan);
    }
    
    private void tampilkan() {
        int row = tableDataLaporan.getRowCount();
        for (int a = 0; a < row; a++) {
            model.removeRow(0);
            
        }
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gbrand", "root", "");
            ResultSet rs = cn.createStatement().executeQuery("select data_kategori.id_kategori, data_kategori.nama_kategori,count(detail_transaksi.id_kategori) as Terjual from detail_transaksi left join data_kategori on data_kategori.id_kategori=detail_transaksi.id_kategori group by detail_transaksi.id_kategori order by Terjual desc");
            while (rs.next()) {
                String data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)
                };                
                model.addRow(data);                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(panelLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void omset(){
        String myomset =  "CALL `pemasukan`()";
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gbrand", "root", "");
        
            ResultSet rs = cn.createStatement().executeQuery(myomset);
            while (rs.next()) {
                labelOmsetDataLaporan.setText(rs.getString(1));
            }
     
        } catch (Exception ex) {
            Logger.getLogger(panelLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void pengeluaran(){
        String pengeluaran = "CALL `pengeluaran`()";
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gbrand", "root", "");
            ResultSet rs = cn.createStatement().executeQuery(pengeluaran);
            while (rs.next()) {
                labelPengeluaranDataLaporan.setText(rs.getString(1));
            }
        } catch (Exception ex) {
            Logger.getLogger(panelLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void keuntungan(){
        int omzet, minus;
        int untung;
        omzet = Integer.valueOf(labelOmsetDataLaporan.getText());
        minus = Integer.valueOf(labelPengeluaranDataLaporan.getText());
        untung = omzet - minus;
        labelKeuntunganDataLaporan.setText(String.valueOf(untung));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new component.swing.panelRound();
        scrollPaneDataLaporan = new javax.swing.JScrollPane();
        tableDataLaporan = new component.model.tableCustom.table();
        jLabel3 = new javax.swing.JLabel();
        panelRound2 = new component.swing.panelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelOmsetDataLaporan = new javax.swing.JLabel();
        panelRound3 = new component.swing.panelRound();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelPengeluaranDataLaporan = new javax.swing.JLabel();
        panelRound4 = new component.swing.panelRound();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelKeuntunganDataLaporan = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setLayout(new java.awt.BorderLayout());

        scrollPaneDataLaporan.setBorder(null);

        tableDataLaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollPaneDataLaporan.setViewportView(tableDataLaporan);

        panelRound1.add(scrollPaneDataLaporan, java.awt.BorderLayout.CENTER);

        add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 840, 290));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel3.setText("Data Barang Terlaku");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        panelRound2.setBackground(new java.awt.Color(255, 255, 153));
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel1.setText("Omset");
        panelRound2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel5.setText("Rp.");
        panelRound2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        labelOmsetDataLaporan.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        labelOmsetDataLaporan.setText("000");
        panelRound2.add(labelOmsetDataLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 190, 30));

        add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 160));

        panelRound3.setBackground(new java.awt.Color(153, 255, 153));
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel2.setText("Pengeluaran");
        panelRound3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel7.setText("Rp.");
        panelRound3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        labelPengeluaranDataLaporan.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        labelPengeluaranDataLaporan.setText("000");
        panelRound3.add(labelPengeluaranDataLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 180, 30));

        add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 260, 160));

        panelRound4.setBackground(new java.awt.Color(153, 0, 255));
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel4.setText("Keuntungan");
        panelRound4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel9.setText("Rp.");
        panelRound4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        labelKeuntunganDataLaporan.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        labelKeuntunganDataLaporan.setText("000");
        panelRound4.add(labelKeuntunganDataLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 190, 30));

        add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 270, 160));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelKeuntunganDataLaporan;
    private javax.swing.JLabel labelOmsetDataLaporan;
    private javax.swing.JLabel labelPengeluaranDataLaporan;
    private component.swing.panelRound panelRound1;
    private component.swing.panelRound panelRound2;
    private component.swing.panelRound panelRound3;
    private component.swing.panelRound panelRound4;
    private javax.swing.JScrollPane scrollPaneDataLaporan;
    private component.model.tableCustom.table tableDataLaporan;
    // End of variables declaration//GEN-END:variables
}
