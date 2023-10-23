package main;

import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import static main.gbrandapplication.accessHome;
import static main.gbrandapplication.mainAccessPanel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import system.daftar_barang;
import system.notification.Notification;
import system.pengguna;

public class panelTransaksi extends javax.swing.JPanel {
    
    public panelTransaksi() {
        initComponents();
        setOpaque(false);
        
        tableDataTransaksi();
        pendapatanHariIni();

        fieldIDTransaksi.setText("");
        fieldIDBarangTransaksi.setText("");
        fieldNamaBarangTransaksi.setText("");
        fieldKategoriTransaksi.setText("");
        fieldHargaTransaksi.setText("");
        
        autoNumber();
        
        Date Tanggal = new Date();
        SimpleDateFormat TanggalFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        fieldTanggalTransaksi.setText(TanggalFormat.format(Tanggal));
        fieldTotalBayarTransaksi.setText("0");
        fieldBayarTransaksi.setText("0");
        fieldKembalianTransaksi.setText("0");
        fieldJumlahTotalHargaTransaksi.setText("Rp. 0");
        
        tableTransaksi.fixTable(scrollPaneTransaksi);
    }
    
    boolean aksi = true;
    
    public void changeIcon(JButton align, String iconSet) {
        ImageIcon set = new ImageIcon(getClass().getResource(iconSet));
        align.setIcon(set);   
    }
    
    public void tableDataTransaksi() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Transaksi");
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang"); 
        model.addColumn("Harga");
        model.addColumn("Kategori");
        model.addColumn("Total");
        
        tableTransaksi.setModel(model);
    }
    
    public void loadData() {
        DefaultTableModel model  =  (DefaultTableModel) tableTransaksi.getModel();
        model.addRow(new Object[]{
            fieldIDTransaksi.getText(),
            fieldIDBarangTransaksi.getText(),
            fieldNamaBarangTransaksi.getText(),
            fieldHargaTransaksi.getText(),
            fieldKategoriTransaksi.getText(),
            fieldTotalBayarTransaksi.getText()       
        });
        totalBiaya();
    }
    
    void pendapatanHariIni() {
        try {
            java.util.Date Tanggal = new java.util.Date();
            java.text.SimpleDateFormat TanggalFormat = new java.text.SimpleDateFormat("dd-MM-YYYY");
            String CreateDate = TanggalFormat.format(Tanggal);
            
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT SUM(total_harga) t_harga FROM data_transaksi WHERE tanggal_transaksi='" + CreateDate+ "';");
            
            if (result.next()) {
                if (result.getString(1) == null) {
                    fieldPendapatanHariIniTransaksi.setText(("0"));
                } else {
                    fieldPendapatanHariIniTransaksi.setText((result.getString(1)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void totalBiaya() {
        int jumlahBaris = tableTransaksi.getRowCount();
        int totalBiaya = 0;
        int jumlahBarang = 1;
        int hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            hargaBarang = Integer.parseInt(tableTransaksi.getValueAt(i, 3).toString());
            totalBiaya = totalBiaya + (jumlahBarang * hargaBarang);
        }
        fieldTotalBayarTransaksi.setText(String.valueOf(totalBiaya));
        fieldJumlahTotalHargaTransaksi.setText("Rp. " + totalBiaya + ",00");
    }
    
    public void bayar() {
        int total, bayar, kembalian;
        
        total =  Integer.valueOf(fieldTotalBayarTransaksi.getText());
        bayar = Integer.valueOf(fieldBayarTransaksi.getText());
        
        if (total > bayar){
            Notification notif = new Notification(test.getJFram(), Notification.Type.INFO, Notification.Location.TOP_CENTER, "Uang tidak cukup !");
            notif.showNotification();
            
            if(main.test.showNotification.isSelected()){
                main.test.showNotification.setText("Transaksi");
            }
            
        }else{
            kembalian = bayar - total;
            fieldKembalianTransaksi.setText(String.valueOf(kembalian));
        }
    }
    
    private void autoNumber() {
        try{
        java.util.Date Tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat = new java.text.SimpleDateFormat("dd-MM-YYYY");
        String CreateDate = TanggalFormat.format(Tanggal);
        java.text.SimpleDateFormat Tnggl = new java.text.SimpleDateFormat("ddMMYYYY");
        String Tgl = Tnggl.format(Tanggal);
        
        Statement statement = (Statement)service.connect.GetConnection().createStatement();
        ResultSet result = statement.executeQuery("SELECT MAX(RIGHT(id_transaksi,3)) AS faktur FROM data_transaksi WHERE tanggal_transaksi LIKE '" + "%" + CreateDate + "%" + "';");
                    
        while (result.next()){
            if (result.first()== false){
                fieldIDTransaksi.setText("TRsK/" + Tgl + "/" + "0001");
            }else{
                result.last();
                int setID = result.getInt(1)+1;
                String No = String.valueOf(setID);
                int IDNext = No.length();
                for (int a = 0; a<4 - IDNext; a++){
                    No = "0" + No;
                }
                fieldIDTransaksi.setText("TRsK-" + Tgl + "-" + No);
                }
            }
        }
        catch(Exception e){
             Logger.getLogger(system.panelTransaksi.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTransparent1 = new component.swing.panelTransparent();
        panelRound1 = new component.swing.panelRound();
        scrollPaneTransaksi = new javax.swing.JScrollPane();
        tableTransaksi = new component.model.tableCustom.table();
        buttonIDBarangTransaksi = new component.swing.button();
        buttonKasirTransaksi = new component.swing.button();
        jLabel2 = new javax.swing.JLabel();
        buttonHapusTransaksi = new component.swing.button();
        buttonTambahTransaksi = new component.swing.button();
        fieldKasirTransaksi = new component.swing.textFieldMain();
        fieldNamaBarangTransaksi = new component.swing.textFieldMain();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fieldKategoriTransaksi = new component.swing.textFieldMain();
        fieldHargaTransaksi = new component.swing.textFieldMain();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fieldIDTransaksi = new component.swing.textFieldMain();
        fieldIDBarangTransaksi = new component.swing.textFieldMain();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        fieldTanggalTransaksi = new component.swing.textFieldMain();
        fieldPendapatanHariIniTransaksi = new component.swing.textFieldMain();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonEnterTransaksi = new component.swing.button();
        buttonRefreshTransaksi = new component.swing.button();
        buttonSimpanTransaksi = new component.swing.button();
        buttonPrintTransaksi = new component.swing.button();
        fieldTotalBayarTransaksi = new component.swing.textFieldMain();
        fieldBayarTransaksi = new component.swing.textFieldMain();
        fieldKembalianTransaksi = new component.swing.textFieldMain();
        fieldJumlahTotalHargaTransaksi = new component.swing.textFieldMain();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        button1 = new component.swing.button();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTransparent1.setBackground(new java.awt.Color(225, 225, 225));
        panelTransparent1.setAlpha(0.8F);
        panelTransparent1.setRound(35);
        panelTransparent1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setRound(25);
        panelRound1.setLayout(new java.awt.BorderLayout());

        tableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        scrollPaneTransaksi.setViewportView(tableTransaksi);

        panelRound1.add(scrollPaneTransaksi, java.awt.BorderLayout.CENTER);

        panelTransparent1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 690, 270));

        buttonIDBarangTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/align.png"))); // NOI18N
        buttonIDBarangTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIDBarangTransaksiActionPerformed(evt);
            }
        });
        panelTransparent1.add(buttonIDBarangTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 60, 60));

        buttonKasirTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/align.png"))); // NOI18N
        buttonKasirTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKasirTransaksiActionPerformed(evt);
            }
        });
        panelTransparent1.add(buttonKasirTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 60, 60));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel2.setText("Table Data Transaksi");
        panelTransparent1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        buttonHapusTransaksi.setBackground(new java.awt.Color(204, 0, 0));
        buttonHapusTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        buttonHapusTransaksi.setText("Hapus");
        buttonHapusTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonHapusTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusTransaksiActionPerformed(evt);
            }
        });
        panelTransparent1.add(buttonHapusTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 120, 50));

        buttonTambahTransaksi.setBackground(new java.awt.Color(0, 204, 0));
        buttonTambahTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        buttonTambahTransaksi.setText("Tambah");
        buttonTambahTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonTambahTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahTransaksiActionPerformed(evt);
            }
        });
        panelTransparent1.add(buttonTambahTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 120, 50));

        fieldKasirTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        panelTransparent1.add(fieldKasirTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 210, 60));

        fieldNamaBarangTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        panelTransparent1.add(fieldNamaBarangTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 270, 60));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel7.setText("Kasir");
        panelTransparent1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel8.setText("Nama Barang");
        panelTransparent1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, -1, -1));

        fieldKategoriTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        panelTransparent1.add(fieldKategoriTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 270, 60));

        fieldHargaTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        panelTransparent1.add(fieldHargaTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 270, 60));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel9.setText("Kategori");
        panelTransparent1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel10.setText("Harga");
        panelTransparent1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, -1, -1));

        fieldIDTransaksi.setEditable(false);
        fieldIDTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldIDTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIDTransaksiActionPerformed(evt);
            }
        });
        panelTransparent1.add(fieldIDTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 270, 60));

        fieldIDBarangTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        panelTransparent1.add(fieldIDBarangTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 210, 60));

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel13.setText("ID Transaksi");
        panelTransparent1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel14.setText("ID Barang");
        panelTransparent1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        fieldTanggalTransaksi.setEditable(false);
        fieldTanggalTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        panelTransparent1.add(fieldTanggalTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, 280, 60));

        fieldPendapatanHariIniTransaksi.setEditable(false);
        fieldPendapatanHariIniTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        panelTransparent1.add(fieldPendapatanHariIniTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 120, 280, 60));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel3.setText("Tanggal");
        panelTransparent1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel4.setText("Pendapatan Hari Ini");
        panelTransparent1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 100, -1, -1));

        buttonEnterTransaksi.setBackground(new java.awt.Color(0, 153, 255));
        buttonEnterTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        buttonEnterTransaksi.setText("Enter");
        buttonEnterTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonEnterTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnterTransaksiActionPerformed(evt);
            }
        });
        panelTransparent1.add(buttonEnterTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, 90, 50));

        buttonRefreshTransaksi.setBackground(new java.awt.Color(0, 153, 255));
        buttonRefreshTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        buttonRefreshTransaksi.setText("Refresh");
        buttonRefreshTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonRefreshTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshTransaksiActionPerformed(evt);
            }
        });
        panelTransparent1.add(buttonRefreshTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 200, 90, 50));

        buttonSimpanTransaksi.setBackground(new java.awt.Color(0, 204, 0));
        buttonSimpanTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        buttonSimpanTransaksi.setText("Simpan");
        buttonSimpanTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonSimpanTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanTransaksiActionPerformed(evt);
            }
        });
        panelTransparent1.add(buttonSimpanTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 200, 120, 50));

        buttonPrintTransaksi.setBackground(new java.awt.Color(102, 102, 102));
        buttonPrintTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        buttonPrintTransaksi.setText("Print");
        buttonPrintTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonPrintTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrintTransaksiActionPerformed(evt);
            }
        });
        panelTransparent1.add(buttonPrintTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 200, 120, 50));

        fieldTotalBayarTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldTotalBayarTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTotalBayarTransaksiActionPerformed(evt);
            }
        });
        panelTransparent1.add(fieldTotalBayarTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 280, 210, 60));

        fieldBayarTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldBayarTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBayarTransaksiActionPerformed(evt);
            }
        });
        panelTransparent1.add(fieldBayarTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 280, 210, 60));

        fieldKembalianTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        panelTransparent1.add(fieldKembalianTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 360, 420, 60));

        fieldJumlahTotalHargaTransaksi.setEditable(false);
        fieldJumlahTotalHargaTransaksi.setFont(new java.awt.Font("Dialog", 0, 22)); // NOI18N
        fieldJumlahTotalHargaTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldJumlahTotalHargaTransaksiActionPerformed(evt);
            }
        });
        panelTransparent1.add(fieldJumlahTotalHargaTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 440, 420, 80));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel5.setText("Total Bayar");
        panelTransparent1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel6.setText("Bayar");
        panelTransparent1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 260, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel11.setText("Kembalian");
        panelTransparent1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel12.setText("Jumlah Total Harga");
        panelTransparent1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, -1, -1));

        add(panelTransparent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 112, 1156, 530));

        button1.setText("Keluar Dari Skema Penjualan");
        button1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, 230, 60));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setText("Transaksi");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/transaksi-icon.png"))); // NOI18N
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/penghasilan.png"))); // NOI18N
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, 310));
    }// </editor-fold>//GEN-END:initComponents

    private void fieldIDTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIDTransaksiActionPerformed
        autoNumber();
    }//GEN-LAST:event_fieldIDTransaksiActionPerformed

    private void fieldTotalBayarTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTotalBayarTransaksiActionPerformed
        bayar();
    }//GEN-LAST:event_fieldTotalBayarTransaksiActionPerformed

    private void fieldBayarTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBayarTransaksiActionPerformed
        bayar();
    }//GEN-LAST:event_fieldBayarTransaksiActionPerformed

    private void fieldJumlahTotalHargaTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldJumlahTotalHargaTransaksiActionPerformed
        totalBiaya();
    }//GEN-LAST:event_fieldJumlahTotalHargaTransaksiActionPerformed

    private void buttonTambahTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahTransaksiActionPerformed
        int harga, total;
        int jumlah = 1;
        harga = Integer.valueOf(fieldHargaTransaksi.getText());
      
        total = (jumlah * harga);
        fieldTotalBayarTransaksi.setText(String.valueOf(total));
        
        loadData();
        
        totalBiaya();
        
        fieldIDBarangTransaksi.requestFocus();
        fieldIDBarangTransaksi.setText("");
        fieldNamaBarangTransaksi.setText("");
        fieldKategoriTransaksi.setText("");
        fieldHargaTransaksi.setText("");
    }//GEN-LAST:event_buttonTambahTransaksiActionPerformed

    private void buttonHapusTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusTransaksiActionPerformed
        DefaultTableModel model = (DefaultTableModel) tableTransaksi.getModel();
        int row = tableTransaksi.getSelectedRow();
        model.removeRow(row);
        
        totalBiaya();
    }//GEN-LAST:event_buttonHapusTransaksiActionPerformed

    private void buttonEnterTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnterTransaksiActionPerformed
        bayar();
    }//GEN-LAST:event_buttonEnterTransaksiActionPerformed

    private void buttonRefreshTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshTransaksiActionPerformed
        DefaultTableModel model = (DefaultTableModel) tableTransaksi.getModel();
        
        fieldIDBarangTransaksi.setText("");
        fieldNamaBarangTransaksi.setText("");
        fieldKasirTransaksi.setText("");
        fieldKategoriTransaksi.setText("");
        fieldHargaTransaksi.setText("0");
        fieldTotalBayarTransaksi.setText("0");
        fieldBayarTransaksi.setText("0");
        fieldKembalianTransaksi.setText("0");
        fieldJumlahTotalHargaTransaksi.setText("0");
        
        while (model.getRowCount()>0) {
           model.removeRow(0);
        }

        fieldJumlahTotalHargaTransaksi.setText("Rp. 0");
        fieldIDTransaksi.setText("");
        fieldIDBarangTransaksi.setText("");
        fieldNamaBarangTransaksi.setText("");
        fieldKategoriTransaksi.setText("");
        fieldHargaTransaksi.setText("");
        
        autoNumber();
    }//GEN-LAST:event_buttonRefreshTransaksiActionPerformed

    private void buttonSimpanTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanTransaksiActionPerformed
        String IDTransaksi = fieldIDTransaksi.getText();
        String IDUser = fieldKasirTransaksi.getText();
        String Tanggal = fieldTanggalTransaksi.getText();
        String Total = fieldTotalBayarTransaksi.getText();
        String Nominal = fieldBayarTransaksi.getText();
        String Kembalian = fieldKembalianTransaksi.getText();
        
        try {
            Statement statement = (Statement) service.connect.GetConnection().createStatement();
            statement.executeUpdate("INSERT INTO data_transaksi VALUES ('"+IDTransaksi+"', '"+IDUser+"', '"+Tanggal+"', '"+Total+"', '"+Nominal+"', '"+Kembalian+"');");
            statement.close();
        } catch (Exception e) {
            Logger.getLogger(system.panelTransaksi.class.getName()).log(Level.SEVERE, null, e);
        }
        
        try {
            int baris = tableTransaksi.getRowCount();

            for (int i = 0; i < baris; i++) {
                Statement statement = (Statement) service.connect.GetConnection().createStatement();
                statement.executeUpdate("INSERT INTO detail_transaksi(id_transaksi, id_barang, id_kategori) VALUES('"+ tableTransaksi.getValueAt(i, 0) +"','"+ tableTransaksi.getValueAt(i, 1) +"','"+ tableTransaksi.getValueAt(i, 4) +"');");
                statement.close();
            }
            
        } catch (Exception e) {
            Logger.getLogger(system.panelTransaksi.class.getName()).log(Level.SEVERE, null, e);
        }
        
        pendapatanHariIni();
    }//GEN-LAST:event_buttonSimpanTransaksiActionPerformed

    private void buttonPrintTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrintTransaksiActionPerformed
        try{
            String file = "/report/StrukPembelian.jasper";

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            HashMap param = new HashMap();

            param.put("id_transaksi",fieldIDTransaksi.getText());

            JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream(file),param,service.connect.GetConnection());
            JasperViewer.viewReport(print, false);
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | JRException e){
            System.out.println(e);
        } catch (SQLException ex) {
            Logger.getLogger(panelTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonPrintTransaksiActionPerformed

    private void buttonIDBarangTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIDBarangTransaksiActionPerformed
//        if(aksi == true){
//            changeIcon(buttonIDBarangTransaksi, "/resource/icon/align_hover.png");
//            buttonIDBarangTransaksi.setBackground(new Color(242, 242, 242));
//            new daftar_barang().setVisible(true);
//            aksi = false;
//        } else {
//            changeIcon(buttonIDBarangTransaksi, "/resource/icon/align.png");
//            buttonIDBarangTransaksi.setBackground(new Color(255, 255, 255));
//            aksi = true;
//        }
          new system.massage.list.listDataBarang().setVisible(true);
    }//GEN-LAST:event_buttonIDBarangTransaksiActionPerformed

    private void buttonKasirTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKasirTransaksiActionPerformed
//        if(aksi == true){
//            changeIcon(buttonKasirTransaksi, "/resource/icon/align_hover.png");
//            buttonKasirTransaksi.setBackground(new Color(242, 242, 242));
//            new pengguna().setVisible(true);
//            aksi = false;
//        } else {
//            changeIcon(buttonKasirTransaksi, "/resource/icon/align.png");
//            buttonKasirTransaksi.setBackground(new Color(255, 255, 255));
//            aksi = true;
//        }
          new system.massage.list.listDataKasir().setVisible(true);
    }//GEN-LAST:event_buttonKasirTransaksiActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessHome);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button button1;
    private component.swing.button buttonEnterTransaksi;
    private component.swing.button buttonHapusTransaksi;
    public static component.swing.button buttonIDBarangTransaksi;
    public static component.swing.button buttonKasirTransaksi;
    private component.swing.button buttonPrintTransaksi;
    private component.swing.button buttonRefreshTransaksi;
    private component.swing.button buttonSimpanTransaksi;
    private component.swing.button buttonTambahTransaksi;
    public static component.swing.textFieldMain fieldBayarTransaksi;
    public static component.swing.textFieldMain fieldHargaTransaksi;
    public static component.swing.textFieldMain fieldIDBarangTransaksi;
    private component.swing.textFieldMain fieldIDTransaksi;
    private component.swing.textFieldMain fieldJumlahTotalHargaTransaksi;
    public static component.swing.textFieldMain fieldKasirTransaksi;
    public static component.swing.textFieldMain fieldKategoriTransaksi;
    public static component.swing.textFieldMain fieldKembalianTransaksi;
    public static component.swing.textFieldMain fieldNamaBarangTransaksi;
    private component.swing.textFieldMain fieldPendapatanHariIniTransaksi;
    private component.swing.textFieldMain fieldTanggalTransaksi;
    public static component.swing.textFieldMain fieldTotalBayarTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private component.swing.panelRound panelRound1;
    private component.swing.panelTransparent panelTransparent1;
    private javax.swing.JScrollPane scrollPaneTransaksi;
    private component.model.tableCustom.table tableTransaksi;
    // End of variables declaration//GEN-END:variables
}
