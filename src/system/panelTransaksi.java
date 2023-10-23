package system;

import component.model.table.tableCustom;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static main.gbrandapplication.mainPanel;
import static main.gbrandapplication.panelHome;

public class panelTransaksi extends javax.swing.JPanel {


    public panelTransaksi() {
        initComponents();
        setOpaque(false);
        
        model = new DefaultTableModel();
        
        tableTransaksi.setModel(model);
        
        model.addColumn("Id Transaksi");
        model.addColumn("Id Barang");
        model.addColumn("Nama Barang"); 
        model.addColumn("Harga");
        model.addColumn("Kategori");
        model.addColumn("Total");
        
        pendapatanHariIni();
        autonumber();
        utama();
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        
        fieldTanggalTransaksi.setText(s.format(date));
        fieldTotalBayarTransaksi.setText("0");
        fieldBayarTransaksi.setText("0");
        fieldKembalianTransaksi.setText("0");
        
        tableCustom.apply(scrollTransaksi, tableCustom.TableType.MULTI_LINE);
    }
    
//    String tanggal;
    private DefaultTableModel model;
   
    public void totalBiaya(){
        int jumlahBaris = tableTransaksi.getRowCount();
        int totalBiaya = 0;
        int jumlahbarang =1;
        int hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            //jumlahbarang = Integer.parseInt(tabel.getValueAt(i, 3).toString());
            hargaBarang = Integer.parseInt(tableTransaksi.getValueAt(i, 3).toString());
            totalBiaya = totalBiaya + (jumlahbarang * hargaBarang);
        }
        fieldTotalBayarTransaksi.setText(String.valueOf(totalBiaya));
        fieldJumlahHargaTransaksi.setText("Rp. "+ totalBiaya +",00");
    }
    
    void pendapatanHariIni() {
        try {
            java.util.Date tanggal = new java.util.Date();
            java.text.SimpleDateFormat TanggalFormat= new java.text.SimpleDateFormat("dd-MM-YYYY");
            String CreateDate=TanggalFormat.format(tanggal);
            java.text.SimpleDateFormat Tggl= new java.text.SimpleDateFormat("ddMMYYYY");
            String p = Tggl.format(tanggal);
            String query = "SELECT SUM(total_harga) t_harga FROM transaksi WHERE tanggal='" + CreateDate+ "'";
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gbrand", "root", "");
            java.sql.Statement stm = cn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(query);
            if (res.next()) {
                if (res.getString(1) == null) {
                    fieldPendapatan.setText(("0"));
                } else {
                    fieldPendapatan.setText((res.getString(1)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void autonumber(){
        try{
        /*DateFormat vblnth = new SimpleDateFormat("ddMMYYYY");
        String blnth = vblnth.format(Calendar.getInstance().getTime());
        
        DateFormat hari = new SimpleDateFormat("dd-MM-yyyy");
        String a = hari.format(Calendar.getInstance().getTime());
        */
        java.util.Date tanggal = new java.util.Date();
            java.text.SimpleDateFormat TanggalFormat= new java.text.SimpleDateFormat("dd-MM-YYYY");
            String CreateDate=TanggalFormat.format(tanggal);
            java.text.SimpleDateFormat Tggl= new java.text.SimpleDateFormat("ddMMYYYY");
            String p=Tggl.format(tanggal);
            
        String query = "SELECT max(right(id_transaksi,3)) as faktur FROM transaksi where tanggal like '"+"%" +CreateDate+"%"+ "'";
        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gbrand", "root", "");
        java.sql.Statement stm = cn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(query);
        
        while (res.next()){
            if (res.first()== false){
                fieldIDTransaksi.setText("TR/"+p+"/"+"001");
            }else{
                res.last();
                 int set_id = res.getInt(1)+1;
                 String no = String.valueOf(set_id);
                 int id_next = no.length();
                 for (int a = 0; a<3 - id_next; a++){
                     no = "0" + no;
                }
                fieldIDTransaksi.setText("TR/"+p+"/"+no);
                }
            }
        }
        catch(Exception e){
             Logger.getLogger(panelTransaksi.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void loadData(){
        DefaultTableModel model  =  (DefaultTableModel) tableTransaksi.getModel();
        model.addRow(new Object[]{
            fieldIDTransaksi.getText(),
            fieldIDBarang.getText(),
            fieldBarangTransaksi.getText(),
            fieldHargaTransaksi.getText(),
            fieldKategori.getText(),
            fieldTotalBayarTransaksi.getText()       
        });
    }
    
    public void kosong(){
        DefaultTableModel model = (DefaultTableModel) tableTransaksi.getModel();
        
        while (model.getRowCount()>0) {
           model.removeRow(0);
        }
    }
    
    public void utama(){
        fieldIDTransaksi.setText("");
        fieldIDBarang.setText("");
        fieldBarangTransaksi.setText("");
        fieldHargaTransaksi.setText("");
        fieldKategori.setText("");
        autonumber();
    }
    
    public void clear(){
        fieldIDBarang.setText("");
        fieldBarangTransaksi.setText("");
        fieldHargaTransaksi.setText("0");
        fieldJumlahHargaTransaksi.setText("0");
        fieldBayarTransaksi.setText("0");
        fieldTotalBayarTransaksi.setText("0");
        fieldKembalianTransaksi.setText("0");
        fieldKategori.setText("");
    }
    public void clear2(){
        fieldIDBarang.setText("");
        fieldBarangTransaksi.setText("");
        fieldHargaTransaksi.setText("");
        fieldKategori.setText("");
    }
    
    public void tambahTransaksi(){
        int harga,total;
        int jumlah = 1;
        harga = Integer.valueOf(fieldHargaTransaksi.getText());
      
        total = (jumlah*harga);
        fieldTotalBayarTransaksi.setText(String.valueOf(total));
        
        loadData();
        totalBiaya();
        clear2();
        
        fieldIDBarang.requestFocus();
    }
            
    private static void koneksi(){
        try {  
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gbrand", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(panelTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMainTransaksi = new component.swing.panelRound();
        button1 = new component.swing.button();
        jLabel1 = new javax.swing.JLabel();
        buttonTransaksiHome = new component.swing.button();
        jLabel2 = new javax.swing.JLabel();
        fieldIDTransaksi = new component.swing.textFieldMain();
        jLabel3 = new javax.swing.JLabel();
        fieldIDBarang = new component.swing.textFieldMain();
        listIDBarang = new component.swing.button();
        jLabel4 = new javax.swing.JLabel();
        fieldKasirTransaksi = new component.swing.textFieldMain();
        jLabel5 = new javax.swing.JLabel();
        fieldBarangTransaksi = new component.swing.textFieldMain();
        listKasir = new component.swing.button();
        jLabel6 = new javax.swing.JLabel();
        fieldTanggalTransaksi = new component.swing.textFieldMain();
        jLabel7 = new javax.swing.JLabel();
        fieldHargaTransaksi = new component.swing.textFieldMain();
        fieldJumlahHargaTransaksi = new component.swing.textFieldMain();
        buttonSimpanTransaksi = new component.swing.button();
        buttonPrintTransaksi = new component.swing.button();
        fieldKembalianTransaksi = new component.swing.textField();
        fieldBayarTransaksi = new component.swing.textField();
        fieldTotalBayarTransaksi = new component.swing.textField();
        buttonTambahTransaksi = new component.swing.button();
        buttonHapusTransaksi = new component.swing.button();
        fieldCariTransaksi = new component.swing.textField();
        dateTransaksi = new component.swing.button();
        fieldPendapatan = new component.swing.textFieldMain();
        fieldKategori = new component.swing.textFieldMain();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        scrollTransaksi = new javax.swing.JScrollPane();
        tableTransaksi = new javaswingdev.swing.table.table();

        setPreferredSize(new java.awt.Dimension(1026, 625));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMainTransaksi.setBackground(new java.awt.Color(153, 153, 153));

        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/shopping-smile.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 45)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Transaksi");

        buttonTransaksiHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/home.png"))); // NOI18N
        buttonTransaksiHome.setText("Home");
        buttonTransaksiHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonTransaksiHome.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        buttonTransaksiHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonTransaksiHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTransaksiHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMainTransaksiLayout = new javax.swing.GroupLayout(panelMainTransaksi);
        panelMainTransaksi.setLayout(panelMainTransaksiLayout);
        panelMainTransaksiLayout.setHorizontalGroup(
            panelMainTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainTransaksiLayout.createSequentialGroup()
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 551, Short.MAX_VALUE)
                .addComponent(buttonTransaksiHome, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelMainTransaksiLayout.setVerticalGroup(
            panelMainTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainTransaksiLayout.createSequentialGroup()
                .addGroup(panelMainTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelMainTransaksiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonTransaksiHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(panelMainTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 970, 110));

        jLabel2.setText("ID Transaksi");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        fieldIDTransaksi.setBackground(new java.awt.Color(153, 153, 153));
        fieldIDTransaksi.setForeground(new java.awt.Color(0, 0, 0));
        fieldIDTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        fieldIDTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIDTransaksiActionPerformed(evt);
            }
        });
        add(fieldIDTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 150, 50));

        jLabel3.setText("ID Barang");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        fieldIDBarang.setBackground(new java.awt.Color(153, 153, 153));
        fieldIDBarang.setForeground(new java.awt.Color(0, 0, 0));
        fieldIDBarang.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        add(fieldIDBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 120, 50));

        listIDBarang.setBackground(new java.awt.Color(153, 153, 153));
        listIDBarang.setForeground(new java.awt.Color(255, 255, 255));
        listIDBarang.setText("...");
        listIDBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listIDBarangActionPerformed(evt);
            }
        });
        add(listIDBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 30, 30));

        jLabel4.setText("Kasir");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, -1, -1));

        fieldKasirTransaksi.setBackground(new java.awt.Color(153, 153, 153));
        fieldKasirTransaksi.setForeground(new java.awt.Color(0, 0, 0));
        fieldKasirTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        add(fieldKasirTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 140, 50));

        jLabel5.setText("Barang");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, -1, -1));

        fieldBarangTransaksi.setBackground(new java.awt.Color(204, 204, 204));
        fieldBarangTransaksi.setForeground(new java.awt.Color(0, 0, 0));
        fieldBarangTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        add(fieldBarangTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 170, 50));

        listKasir.setBackground(new java.awt.Color(153, 153, 153));
        listKasir.setForeground(new java.awt.Color(255, 255, 255));
        listKasir.setText("...");
        listKasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listKasirActionPerformed(evt);
            }
        });
        add(listKasir, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 30, 30));

        jLabel6.setText("Tanggal");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, -1, -1));

        fieldTanggalTransaksi.setBackground(new java.awt.Color(153, 153, 153));
        fieldTanggalTransaksi.setForeground(new java.awt.Color(0, 0, 0));
        fieldTanggalTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        add(fieldTanggalTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 100, 50));

        jLabel7.setText("Harga");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, -1, -1));

        fieldHargaTransaksi.setBackground(new java.awt.Color(204, 204, 204));
        fieldHargaTransaksi.setForeground(new java.awt.Color(0, 0, 0));
        fieldHargaTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        add(fieldHargaTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 130, 50));

        fieldJumlahHargaTransaksi.setBackground(new java.awt.Color(153, 153, 153));
        fieldJumlahHargaTransaksi.setForeground(new java.awt.Color(0, 0, 0));
        fieldJumlahHargaTransaksi.setText("Rp.0");
        fieldJumlahHargaTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        add(fieldJumlahHargaTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 490, 240, 70));

        buttonSimpanTransaksi.setBackground(new java.awt.Color(0, 255, 0));
        buttonSimpanTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        buttonSimpanTransaksi.setText("Simpan");
        buttonSimpanTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonSimpanTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanTransaksiActionPerformed(evt);
            }
        });
        add(buttonSimpanTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, 120, -1));

        buttonPrintTransaksi.setBackground(new java.awt.Color(0, 0, 255));
        buttonPrintTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        buttonPrintTransaksi.setText("Print");
        buttonPrintTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonPrintTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrintTransaksiActionPerformed(evt);
            }
        });
        add(buttonPrintTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 440, 120, -1));

        fieldKembalianTransaksi.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        fieldKembalianTransaksi.setLabelText("Kembalian");
        fieldKembalianTransaksi.setOpaque(false);
        add(fieldKembalianTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, 240, 40));

        fieldBayarTransaksi.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        fieldBayarTransaksi.setLabelText("Bayar");
        fieldBayarTransaksi.setOpaque(false);
        fieldBayarTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBayarTransaksiActionPerformed(evt);
            }
        });
        add(fieldBayarTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, 240, 40));

        fieldTotalBayarTransaksi.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        fieldTotalBayarTransaksi.setLabelText("Total Bayar");
        fieldTotalBayarTransaksi.setOpaque(false);
        fieldTotalBayarTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTotalBayarTransaksiActionPerformed(evt);
            }
        });
        add(fieldTotalBayarTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 240, 40));

        buttonTambahTransaksi.setBackground(new java.awt.Color(0, 255, 0));
        buttonTambahTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        buttonTambahTransaksi.setText("Tambah");
        buttonTambahTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonTambahTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahTransaksiActionPerformed(evt);
            }
        });
        add(buttonTambahTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 130, 50));

        buttonHapusTransaksi.setBackground(new java.awt.Color(255, 0, 0));
        buttonHapusTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        buttonHapusTransaksi.setText("Hapus");
        buttonHapusTransaksi.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonHapusTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusTransaksiActionPerformed(evt);
            }
        });
        add(buttonHapusTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 130, 50));

        fieldCariTransaksi.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        fieldCariTransaksi.setLabelText("Cari");
        fieldCariTransaksi.setOpaque(false);
        add(fieldCariTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 400, 40));

        dateTransaksi.setBackground(new java.awt.Color(153, 153, 153));
        dateTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        dateTransaksi.setText("...");
        add(dateTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 30, 30));

        fieldPendapatan.setEditable(false);
        fieldPendapatan.setBackground(new java.awt.Color(204, 204, 204));
        fieldPendapatan.setForeground(new java.awt.Color(0, 0, 0));
        fieldPendapatan.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        add(fieldPendapatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, 160, 50));

        fieldKategori.setBackground(new java.awt.Color(204, 204, 204));
        fieldKategori.setForeground(new java.awt.Color(0, 0, 0));
        fieldKategori.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        add(fieldKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 210, 160, 50));

        jLabel8.setText("Kategori");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 230, -1, -1));

        jLabel9.setText("Pendapatan");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, -1, -1));

        jLabel10.setText("Hari Ini");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, -1, -1));

        tableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        scrollTransaksi.setViewportView(tableTransaksi);

        add(scrollTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 680, 230));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTransaksiHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTransaksiHomeActionPerformed
            mainPanel.removeAll();
            mainPanel.repaint();
            mainPanel.revalidate();

            mainPanel.add(panelHome);
            mainPanel.repaint();
            mainPanel.revalidate();
    }//GEN-LAST:event_buttonTransaksiHomeActionPerformed

    private void listIDBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listIDBarangActionPerformed
        new daftar_barang().setVisible(true);
    }//GEN-LAST:event_listIDBarangActionPerformed

    private void listKasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listKasirActionPerformed
        new pengguna().setVisible(true);
    }//GEN-LAST:event_listKasirActionPerformed

    private void buttonTambahTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahTransaksiActionPerformed
        tambahTransaksi();
    }//GEN-LAST:event_buttonTambahTransaksiActionPerformed

    private void buttonHapusTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusTransaksiActionPerformed
        DefaultTableModel model = (DefaultTableModel) tableTransaksi.getModel();
        int row = tableTransaksi.getSelectedRow();
        model.removeRow(row);
        
        totalBiaya();
    }//GEN-LAST:event_buttonHapusTransaksiActionPerformed

    private void buttonSimpanTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanTransaksiActionPerformed
        DefaultTableModel model = (DefaultTableModel) tableTransaksi.getModel();
        
        String id_transaksi = fieldIDTransaksi.getText();
        String id_user = fieldKasirTransaksi.getText();
        String tanggal = fieldTanggalTransaksi.getText();
        String total = fieldTotalBayarTransaksi.getText();
        String nominal = fieldBayarTransaksi.getText();
        String kembalian = fieldKembalianTransaksi.getText();
        
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gbrand", "root", "");
            String sql = "INSERT INTO transaksi VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement p = cn.prepareStatement(sql);
            p.setString(1, id_transaksi);
            p.setString(2, id_user);
            p.setString(3, tanggal);
            p.setString(4, total);
            p.setString(5, nominal);
            p.setString(6, kembalian);
            p.executeUpdate();
            p.close();
        } catch (Exception e) {
           Logger.getLogger(panelTransaksi.class.getName()).log(Level.SEVERE, null, e);
        }
        
        try {
             Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gbrand", "root", "");
             int jumlah = 1;
             //jumlah = ("jumlah");
            int baris = tableTransaksi.getRowCount();
            //String id_log = ("id_log");
            //for (int i = 0; i <=id_log ; i++) {
                
            
            
            for (int i = 0; i < baris; i++) {
                String sql = "INSERT INTO detail_transaksi(id_transaksi, id_barang,id_kategori) VALUES('"
                        + tableTransaksi.getValueAt(i, 0) +"','"+ tableTransaksi.getValueAt(i, 1) +"','"+ tableTransaksi.getValueAt(i, 4) +"')";
                
                PreparedStatement p = cn.prepareStatement(sql);
                p.executeUpdate();
                p.close();
            }
        } catch (Exception e) {
            Logger.getLogger(panelTransaksi.class.getName()).log(Level.SEVERE, null, e);
        }
        pendapatanHariIni();
        clear();
        utama();
        autonumber();
        kosong();
        fieldJumlahHargaTransaksi.setText("Rp. 0");
    }//GEN-LAST:event_buttonSimpanTransaksiActionPerformed

    private void buttonPrintTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrintTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonPrintTransaksiActionPerformed

    private void fieldIDTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIDTransaksiActionPerformed
        autonumber();
    }//GEN-LAST:event_fieldIDTransaksiActionPerformed

    private void fieldTotalBayarTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTotalBayarTransaksiActionPerformed
        totalBiaya();
        
        
        int total, bayar, kembalian;
        
        total = Integer.valueOf(fieldTotalBayarTransaksi.getText());
        bayar = Integer.valueOf(fieldBayarTransaksi.getText());
        
        if (total > bayar){
            JOptionPane.showMessageDialog(null, "Uang Tidak Cukup");
        }else{
            kembalian = bayar - total;
            fieldKembalianTransaksi.setText(String.valueOf(kembalian));
        }
    }//GEN-LAST:event_fieldTotalBayarTransaksiActionPerformed

    private void fieldBayarTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBayarTransaksiActionPerformed
        int total,bayar,kembalian;
        
        total =  Integer.valueOf(fieldTotalBayarTransaksi.getText());
        bayar = Integer.valueOf(fieldBayarTransaksi.getText());
        
        if (total>bayar){
            JOptionPane.showMessageDialog(null, "Uang Anda Tidak Cukup");
        }else{
            kembalian = bayar - total;
            fieldKembalianTransaksi.setText(String.valueOf(kembalian));
        }
    }//GEN-LAST:event_fieldBayarTransaksiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button button1;
    private component.swing.button buttonHapusTransaksi;
    private component.swing.button buttonPrintTransaksi;
    private component.swing.button buttonSimpanTransaksi;
    private component.swing.button buttonTambahTransaksi;
    public static component.swing.button buttonTransaksiHome;
    private component.swing.button dateTransaksi;
    public static component.swing.textFieldMain fieldBarangTransaksi;
    private component.swing.textField fieldBayarTransaksi;
    private component.swing.textField fieldCariTransaksi;
    public static component.swing.textFieldMain fieldHargaTransaksi;
    public static component.swing.textFieldMain fieldIDBarang;
    private component.swing.textFieldMain fieldIDTransaksi;
    private component.swing.textFieldMain fieldJumlahHargaTransaksi;
    public static component.swing.textFieldMain fieldKasirTransaksi;
    public static component.swing.textFieldMain fieldKategori;
    private component.swing.textField fieldKembalianTransaksi;
    private component.swing.textFieldMain fieldPendapatan;
    private component.swing.textFieldMain fieldTanggalTransaksi;
    private component.swing.textField fieldTotalBayarTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private component.swing.button listIDBarang;
    private component.swing.button listKasir;
    private component.swing.panelRound panelMainTransaksi;
    private javax.swing.JScrollPane scrollTransaksi;
    private javaswingdev.swing.table.table tableTransaksi;
    // End of variables declaration//GEN-END:variables
}
