package main.access;

import com.mysql.jdbc.Statement;
import component.model.table.tableCustom;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.test;
import system.massage.popup.dialogLupaPassword;
import static main.test.accessAfterLogin;
import static main.test.accessHome;
import system.daftar_barang;
import system.notification.Notification;
import system.pengguna;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

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
        
        tableCustom.apply(scrollPaneTransaksi, tableCustom.TableType.MULTI_LINE);
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
                    fieldPendapatanTransaksi.setText(("0"));
                } else {
                    fieldPendapatanTransaksi.setText((result.getString(1)));
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

        mainTransaksi = new component.swing.panelRound();
        navTransaksi = new javax.swing.JPanel();
        LabelTransaksi = new javax.swing.JLabel();
        buttonCloseTransaksi = new component.swing.button();
        panelGradient0 = new component.swing.panelGradient();
        panelRound1 = new component.swing.panelRound();
        fieldIDTransaksi = new component.swing.textField();
        panelRound2 = new component.swing.panelRound();
        fieldIDBarangTransaksi = new component.swing.textField();
        button5 = new component.swing.button();
        panelRound3 = new component.swing.panelRound();
        fieldKasirTransaksi = new component.swing.textField();
        button6 = new component.swing.button();
        panelRound4 = new component.swing.panelRound();
        fieldNamaBarangTransaksi = new component.swing.textField();
        panelRound5 = new component.swing.panelRound();
        fieldKategoriTransaksi = new component.swing.textField();
        panelRound6 = new component.swing.panelRound();
        fieldHargaTransaksi = new component.swing.textField();
        panelRound7 = new component.swing.panelRound();
        fieldTanggalTransaksi = new component.swing.textField();
        panelRound8 = new component.swing.panelRound();
        fieldPendapatanTransaksi = new component.swing.textField();
        panelGradient1 = new component.swing.panelGradient();
        scrollPaneTransaksi = new javax.swing.JScrollPane();
        tableTransaksi = new javax.swing.JTable();
        buttonTambahTransaksi = new component.swing.button();
        buttonHapusTransaksi = new component.swing.button();
        jLabel1 = new javax.swing.JLabel();
        panelGradient2 = new component.swing.panelGradient();
        panelRound9 = new component.swing.panelRound();
        fieldTotalBayarTransaksi = new component.swing.textField();
        panelRound10 = new component.swing.panelRound();
        fieldBayarTransaksi = new component.swing.textField();
        panelRound11 = new component.swing.panelRound();
        fieldKembalianTransaksi = new component.swing.textField();
        panelRound12 = new component.swing.panelRound();
        fieldJumlahTotalHargaTransaksi = new component.swing.textField();
        buttonEnterTransaksi = new component.swing.button();
        buttonPrintStrukTransaksi = new component.swing.button();
        buttonSimpanTransaksi1 = new component.swing.button();
        buttonRefreshTransaksi = new component.swing.button();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainTransaksi.setShadowSize(new java.awt.Insets(5, 5, 5, 5));
        mainTransaksi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        navTransaksi.setOpaque(false);
        navTransaksi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelTransaksi.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        LabelTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/shopping-smile.png"))); // NOI18N
        LabelTransaksi.setText("Transaksi");
        LabelTransaksi.setIconTextGap(15);
        navTransaksi.add(LabelTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, 800, -1));

        buttonCloseTransaksi.setBackground(new java.awt.Color(255, 0, 0));
        buttonCloseTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        buttonCloseTransaksi.setText("Close");
        buttonCloseTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonCloseTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseTransaksiActionPerformed(evt);
            }
        });
        navTransaksi.add(buttonCloseTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(823, 25, 133, 55));

        mainTransaksi.add(navTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 10, 962, -1));

        panelGradient0.setBackground(new java.awt.Color(238, 238, 238));
        panelGradient0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelGradient0.setColorGradient(new java.awt.Color(242, 242, 242));
        panelGradient0.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldIDTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldIDTransaksi.setLabelText("ID Transaksi");
        fieldIDTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIDTransaksiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldIDTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(fieldIDTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelGradient0.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 70));

        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldIDBarangTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldIDBarangTransaksi.setLabelText("ID Barang");
        panelRound2.add(fieldIDBarangTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 160, -1));

        button5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/align.png"))); // NOI18N
        button5.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        panelRound2.add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 50, 50));

        panelGradient0.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, 70));

        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldKasirTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldKasirTransaksi.setLabelText("Kasir");
        panelRound3.add(fieldKasirTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 160, -1));

        button6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/align.png"))); // NOI18N
        button6.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });
        panelRound3.add(button6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 50, 50));

        panelGradient0.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 230, 70));

        fieldNamaBarangTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldNamaBarangTransaksi.setLabelText("Nama Barang");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldNamaBarangTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addComponent(fieldNamaBarangTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelGradient0.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 230, 70));

        fieldKategoriTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldKategoriTransaksi.setLabelText("Kategori");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldKategoriTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addComponent(fieldKategoriTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelGradient0.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 220, 70));

        fieldHargaTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldHargaTransaksi.setLabelText("Harga");

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldHargaTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(fieldHargaTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelGradient0.add(panelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 220, 70));

        fieldTanggalTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldTanggalTransaksi.setLabelText("Tanggal");

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldTanggalTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addComponent(fieldTanggalTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelGradient0.add(panelRound7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 230, 70));

        fieldPendapatanTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldPendapatanTransaksi.setLabelText("Pendapatan Hari Ini");

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldPendapatanTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(fieldPendapatanTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelGradient0.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 230, 70));

        mainTransaksi.add(panelGradient0, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 108, 962, 160));

        panelGradient1.setBackground(new java.awt.Color(238, 238, 238));
        panelGradient1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelGradient1.setColorGradient(new java.awt.Color(242, 242, 242));
        panelGradient1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrollPaneTransaksi.setViewportView(tableTransaksi);

        panelGradient1.add(scrollPaneTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 86, 560, 190));

        buttonTambahTransaksi.setBackground(new java.awt.Color(0, 204, 0));
        buttonTambahTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        buttonTambahTransaksi.setText("Tambah");
        buttonTambahTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonTambahTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahTransaksiActionPerformed(evt);
            }
        });
        panelGradient1.add(buttonTambahTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 110, 50));

        buttonHapusTransaksi.setBackground(new java.awt.Color(204, 0, 0));
        buttonHapusTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        buttonHapusTransaksi.setText("Hapus");
        buttonHapusTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonHapusTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusTransaksiActionPerformed(evt);
            }
        });
        panelGradient1.add(buttonHapusTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 110, 50));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel1.setText("Table Data Transaksi ");
        panelGradient1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 50));

        mainTransaksi.add(panelGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 280, 600, 295));

        panelGradient2.setBackground(new java.awt.Color(238, 238, 238));
        panelGradient2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelGradient2.setColorGradient(new java.awt.Color(242, 242, 242));
        panelGradient2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldTotalBayarTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldTotalBayarTransaksi.setLabelText("Total Bayar");
        fieldTotalBayarTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTotalBayarTransaksiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound9Layout = new javax.swing.GroupLayout(panelRound9);
        panelRound9.setLayout(panelRound9Layout);
        panelRound9Layout.setHorizontalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldTotalBayarTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );
        panelRound9Layout.setVerticalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound9Layout.createSequentialGroup()
                .addComponent(fieldTotalBayarTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelGradient2.add(panelRound9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 160, 70));

        fieldBayarTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldBayarTransaksi.setLabelText("Bayar");
        fieldBayarTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBayarTransaksiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound10Layout = new javax.swing.GroupLayout(panelRound10);
        panelRound10.setLayout(panelRound10Layout);
        panelRound10Layout.setHorizontalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldBayarTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );
        panelRound10Layout.setVerticalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound10Layout.createSequentialGroup()
                .addComponent(fieldBayarTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelGradient2.add(panelRound10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 160, 70));

        fieldKembalianTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldKembalianTransaksi.setLabelText("Kembalian");

        javax.swing.GroupLayout panelRound11Layout = new javax.swing.GroupLayout(panelRound11);
        panelRound11.setLayout(panelRound11Layout);
        panelRound11Layout.setHorizontalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldKembalianTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );
        panelRound11Layout.setVerticalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(fieldKembalianTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelGradient2.add(panelRound11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 330, 70));

        fieldJumlahTotalHargaTransaksi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldJumlahTotalHargaTransaksi.setLabelText("Jumlah Total Harga");
        fieldJumlahTotalHargaTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldJumlahTotalHargaTransaksiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound12Layout = new javax.swing.GroupLayout(panelRound12);
        panelRound12.setLayout(panelRound12Layout);
        panelRound12Layout.setHorizontalGroup(
            panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldJumlahTotalHargaTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );
        panelRound12Layout.setVerticalGroup(
            panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound12Layout.createSequentialGroup()
                .addComponent(fieldJumlahTotalHargaTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelGradient2.add(panelRound12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 330, 70));

        buttonEnterTransaksi.setBackground(new java.awt.Color(102, 102, 102));
        buttonEnterTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        buttonEnterTransaksi.setText("Enter");
        buttonEnterTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonEnterTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnterTransaksiActionPerformed(evt);
            }
        });
        panelGradient2.add(buttonEnterTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 50));

        buttonPrintStrukTransaksi.setBackground(new java.awt.Color(0, 51, 255));
        buttonPrintStrukTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        buttonPrintStrukTransaksi.setText("Print");
        buttonPrintStrukTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonPrintStrukTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrintStrukTransaksiActionPerformed(evt);
            }
        });
        panelGradient2.add(buttonPrintStrukTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 80, 50));

        buttonSimpanTransaksi1.setBackground(new java.awt.Color(0, 204, 0));
        buttonSimpanTransaksi1.setForeground(new java.awt.Color(255, 255, 255));
        buttonSimpanTransaksi1.setText("Simpan");
        buttonSimpanTransaksi1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonSimpanTransaksi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanTransaksi1ActionPerformed(evt);
            }
        });
        panelGradient2.add(buttonSimpanTransaksi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 80, 50));

        buttonRefreshTransaksi.setBackground(new java.awt.Color(102, 102, 102));
        buttonRefreshTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        buttonRefreshTransaksi.setText("Refresh");
        buttonRefreshTransaksi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonRefreshTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshTransaksiActionPerformed(evt);
            }
        });
        panelGradient2.add(buttonRefreshTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 80, 50));

        mainTransaksi.add(panelGradient2, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 280, 350, 295));

        add(mainTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 590));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCloseTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseTransaksiActionPerformed
        accessAfterLogin.removeAll();
        accessAfterLogin.add(accessHome);
        accessAfterLogin.repaint();
        accessAfterLogin.revalidate();
    }//GEN-LAST:event_buttonCloseTransaksiActionPerformed

    private void fieldIDTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIDTransaksiActionPerformed
        autoNumber();
    }//GEN-LAST:event_fieldIDTransaksiActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        if(aksi == true){
            changeIcon(button5, "/resource/icon/align_hover.png");
            button5.setBackground(new Color(242, 242, 242));
            new daftar_barang().setVisible(true);
            aksi = false;
        } else {
            changeIcon(button5, "/resource/icon/align.png");
            button5.setBackground(new Color(255, 255, 255));
            aksi = true;
        }
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        if(aksi == true){
            changeIcon(button6, "/resource/icon/align_hover.png");
            button6.setBackground(new Color(242, 242, 242));
            new pengguna().setVisible(true);
            aksi = false;
        } else {
            changeIcon(button6, "/resource/icon/align.png");
            button6.setBackground(new Color(255, 255, 255));
            aksi = true;
        }
    }//GEN-LAST:event_button6ActionPerformed

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

    private void buttonSimpanTransaksi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanTransaksi1ActionPerformed
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
        
    }//GEN-LAST:event_buttonSimpanTransaksi1ActionPerformed

    private void buttonPrintStrukTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrintStrukTransaksiActionPerformed
        try{
            String file = "/report/reportStruk.jasper";

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
    }//GEN-LAST:event_buttonPrintStrukTransaksiActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTransaksi;
    private component.swing.button button5;
    private component.swing.button button6;
    private component.swing.button buttonCloseTransaksi;
    public static component.swing.button buttonEnterTransaksi;
    private component.swing.button buttonHapusTransaksi;
    private component.swing.button buttonPrintStrukTransaksi;
    private component.swing.button buttonRefreshTransaksi;
    private component.swing.button buttonSimpanTransaksi1;
    private component.swing.button buttonTambahTransaksi;
    public static component.swing.textField fieldBayarTransaksi;
    public static component.swing.textField fieldHargaTransaksi;
    public static component.swing.textField fieldIDBarangTransaksi;
    private component.swing.textField fieldIDTransaksi;
    private component.swing.textField fieldJumlahTotalHargaTransaksi;
    public static component.swing.textField fieldKasirTransaksi;
    public static component.swing.textField fieldKategoriTransaksi;
    public static component.swing.textField fieldKembalianTransaksi;
    public static component.swing.textField fieldNamaBarangTransaksi;
    private component.swing.textField fieldPendapatanTransaksi;
    private component.swing.textField fieldTanggalTransaksi;
    public static component.swing.textField fieldTotalBayarTransaksi;
    private javax.swing.JLabel jLabel1;
    private component.swing.panelRound mainTransaksi;
    private javax.swing.JPanel navTransaksi;
    private component.swing.panelGradient panelGradient0;
    private component.swing.panelGradient panelGradient1;
    private component.swing.panelGradient panelGradient2;
    private component.swing.panelRound panelRound1;
    private component.swing.panelRound panelRound10;
    private component.swing.panelRound panelRound11;
    private component.swing.panelRound panelRound12;
    private component.swing.panelRound panelRound2;
    private component.swing.panelRound panelRound3;
    private component.swing.panelRound panelRound4;
    private component.swing.panelRound panelRound5;
    private component.swing.panelRound panelRound6;
    private component.swing.panelRound panelRound7;
    private component.swing.panelRound panelRound8;
    private component.swing.panelRound panelRound9;
    private javax.swing.JScrollPane scrollPaneTransaksi;
    private javax.swing.JTable tableTransaksi;
    // End of variables declaration//GEN-END:variables
}
