package main.access;

import com.mysql.jdbc.Statement;
import component.model.table.tableCustom;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class panelDataPembelian extends javax.swing.JPanel {

    public panelDataPembelian() {
        initComponents();
        setOpaque(false);
        
        tableDataPembelian();
        autoNumberDataPembelian();
        
        java.util.Date Tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat = new java.text.SimpleDateFormat("YYYY-MM-dd");
        fieldTanggalDataPembelian.setText(TanggalFormat.format(Tanggal));
        
        tableDataPembelian.fixTable(scrollPaneDataPembelian);
    }
    
    public void tableDataPembelian(){
        DefaultTableModel isi = new DefaultTableModel();
        
        isi.addColumn("ID Pembelian");
        isi.addColumn("Supplier");
        isi.addColumn("Kategori");
        isi.addColumn("Harga");
        isi.addColumn("Quantity");
        isi.addColumn("Tanggal");
        
        tableDataPembelian.setModel(isi);
        
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_pembelian");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("id_pembelian"),
                    result.getString("id_supplier"),
                    result.getString("id_kategori"),
                    result.getString("harga_beli"),
                    result.getString("quantity"),
                    result.getString("tanggal_pembelian")
                    
                });
                tableDataPembelian.setModel(isi);
            }        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Koneksi databases error");
        }
        
        buttonEditDataPembelian.setEnabled(false);
        buttonHapusDataPembelian.setEnabled(false);        
    }
    
    private void searchDataPembelian(String key){
        DefaultTableModel isi = new DefaultTableModel();
        
        isi.addColumn("ID Pembelian");
        isi.addColumn("Supplier");
        isi.addColumn("Kategori");
        isi.addColumn("Harga");
        isi.addColumn("Quantity");
        isi.addColumn("Tanggal");

        tableDataPembelian.setModel(isi);
        
        try{
            java.sql.Statement statement = (java.sql.Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_pembelian WHERE id_pembelian LIKE '%"+key+"%' OR id_supplier LIKE '%"+key+"%' OR id_kategori LIKE '%"+key+"%' OR tanggal_pembelian LIKE '%"+key+"%' OR harga_beli LIKE '%"+key+"%' OR quantity LIKE '%"+key+"%'");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("id_pembelian"),
                    result.getString("id_supplier"),
                    result.getString("id_kategori"),
                    result.getString("tanggal_pembelian"),
                    result.getString("quantity"),
                    result.getString("harga_beli")                    
                });
                tableDataPembelian.setModel(isi);
            }        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tidak bisa mencari data");
        }
    }
    
    private void resetDataPembelian(){
        fieldIDDataPembelian.setText("");
        fieldSupplierDataPembelian.setText("");
        fieldKategoriDataPembelian.setText(""); 
        fieldHargaDataPembelian.setText("");
        fieldQuantityDataPembelian.setText("");
        
        java.util.Date Tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat = new java.text.SimpleDateFormat("YYYY-MM-dd");
        fieldTanggalDataPembelian.setText(TanggalFormat.format(Tanggal));

        tableDataPembelian();
        autoNumberDataPembelian();
    }
    
    private void autoNumberDataPembelian(){
        try {
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_pembelian ORDER BY id_pembelian DESC;");
            if(result.next()){
                String id_pembelian = result.getString("id_pembelian");
                String AND = "" + (Integer.parseInt(id_pembelian)+1);
                String ID = "";
                
                if(AND.length()==1)
                    {ID="000";}
                else if (AND.length()==2)
                    {ID="00";}
                else if (AND.length()==3)
                    {ID="0";}
                else if (AND.length()==4)
                    {ID="";}
                
                fieldIDDataPembelian.setText(ID + AND); 
            } else {
                fieldIDDataPembelian.setText("0001");
            }
            
            statement.close();
            result.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button12 = new component.swing.button();
        jLabel1 = new javax.swing.JLabel();
        fieldIDDataPembelian = new component.swing.textFieldMain();
        fieldSupplierDataPembelian = new component.swing.textFieldMain();
        buttonSimpanDataBarang = new component.swing.button();
        buttonResetDataBarang = new component.swing.button();
        buttonEditDataPembelian = new component.swing.button();
        buttonHapusDataPembelian = new component.swing.button();
        panelRound1 = new component.swing.panelRound();
        scrollPaneDataPembelian = new javax.swing.JScrollPane();
        tableDataPembelian = new component.model.tableCustom.table();
        jLabel2 = new javax.swing.JLabel();
        fieldCariDataPembelian = new component.swing.textFieldMain();
        jLabel3 = new javax.swing.JLabel();
        fieldKategoriDataPembelian = new component.swing.textFieldMain();
        fieldHargaDataPembelian = new component.swing.textFieldMain();
        button13 = new component.swing.button();
        fieldTanggalDataPembelian = new component.swing.textFieldMain();
        fieldQuantityDataPembelian = new component.swing.textFieldMain();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/align.png"))); // NOI18N
        button12.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        button12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button12ActionPerformed(evt);
            }
        });
        add(button12, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 60, 60));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel1.setText("ID Pembelian");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        fieldIDDataPembelian.setEditable(false);
        fieldIDDataPembelian.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldIDDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 280, 60));

        fieldSupplierDataPembelian.setEditable(false);
        fieldSupplierDataPembelian.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldSupplierDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 220, 60));

        buttonSimpanDataBarang.setBackground(new java.awt.Color(0, 204, 0));
        buttonSimpanDataBarang.setForeground(new java.awt.Color(255, 255, 255));
        buttonSimpanDataBarang.setText("Simpan");
        buttonSimpanDataBarang.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonSimpanDataBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanDataBarangActionPerformed(evt);
            }
        });
        add(buttonSimpanDataBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 100, 50));

        buttonResetDataBarang.setBackground(new java.awt.Color(102, 102, 102));
        buttonResetDataBarang.setForeground(new java.awt.Color(255, 255, 255));
        buttonResetDataBarang.setText("Reset");
        buttonResetDataBarang.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonResetDataBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetDataBarangActionPerformed(evt);
            }
        });
        add(buttonResetDataBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 100, 50));

        buttonEditDataPembelian.setBackground(new java.awt.Color(0, 0, 204));
        buttonEditDataPembelian.setForeground(new java.awt.Color(255, 255, 255));
        buttonEditDataPembelian.setText("Edit");
        buttonEditDataPembelian.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonEditDataPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditDataPembelianActionPerformed(evt);
            }
        });
        add(buttonEditDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 100, 50));

        buttonHapusDataPembelian.setBackground(new java.awt.Color(204, 0, 0));
        buttonHapusDataPembelian.setForeground(new java.awt.Color(255, 255, 255));
        buttonHapusDataPembelian.setText("Hapus");
        buttonHapusDataPembelian.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonHapusDataPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusDataPembelianActionPerformed(evt);
            }
        });
        add(buttonHapusDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, 100, 50));

        panelRound1.setLayout(new java.awt.BorderLayout());

        tableDataPembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableDataPembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataPembelianMouseClicked(evt);
            }
        });
        scrollPaneDataPembelian.setViewportView(tableDataPembelian);

        panelRound1.add(scrollPaneDataPembelian, java.awt.BorderLayout.CENTER);

        add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 840, 250));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel2.setText("Supplier");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        fieldCariDataPembelian.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldCariDataPembelian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariDataPembelianKeyReleased(evt);
            }
        });
        add(fieldCariDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 400, 60));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel3.setText("Cari");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        fieldKategoriDataPembelian.setEditable(false);
        fieldKategoriDataPembelian.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldKategoriDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 200, 60));

        fieldHargaDataPembelian.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldHargaDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 260, 60));

        button13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/align.png"))); // NOI18N
        button13.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        button13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button13ActionPerformed(evt);
            }
        });
        add(button13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 60, 60));

        fieldTanggalDataPembelian.setEditable(false);
        fieldTanggalDataPembelian.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldTanggalDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 280, 60));

        fieldQuantityDataPembelian.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldQuantityDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 120, 280, 60));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel4.setText("Kategori");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel5.setText("Harga");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel6.setText("Tanggal");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel7.setText("Quantity");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void button12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button12ActionPerformed
//        if(aksi == true){
//            changeIcon(button12, "/resource/icon/align_hover.png");
//            button12.setBackground(new Color(242, 242, 242));
              new system.massage.list.listKategoriDataPembelian().setVisible(true);
//            system.massage.list.listKategori list = new system.massage.list.listKategori(null, true);
//            list.show();
//            aksi = false;
//        } else {
//            changeIcon(button12, "/resource/icon/align.png");
//            button12.setBackground(new Color(255, 255, 255));
//            aksi = true;
//        }
    }//GEN-LAST:event_button12ActionPerformed

    private void buttonSimpanDataBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanDataBarangActionPerformed
        String IDPembelian = fieldIDDataPembelian.getText();
        String IDSupplier = fieldSupplierDataPembelian.getText();
        String IDKategori = fieldKategoriDataPembelian.getText();
        String Harga = fieldHargaDataPembelian.getText();
        String Quantity = fieldQuantityDataPembelian.getText();
        
        java.util.Date Tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat = new java.text.SimpleDateFormat("YYYY-MM-dd");
        String TanggalHariIni = TanggalFormat.format(Tanggal);
        
        if(IDPembelian.isEmpty()){
            JOptionPane.showMessageDialog(null," tidak boleh kosong");
            fieldIDDataPembelian.requestFocus();
        }else if(IDSupplier.isEmpty()){
            JOptionPane.showMessageDialog(null," tidak boleh kosong");
            fieldSupplierDataPembelian.requestFocus();
        }else if(IDKategori.isEmpty()){
            JOptionPane.showMessageDialog(null," tidak boleh kosong");
            fieldKategoriDataPembelian.requestFocus();
        }else if(Harga.isEmpty()){
            JOptionPane.showMessageDialog(null," tidak boleh kosong");
            fieldHargaDataPembelian.requestFocus();
        }else if(Quantity.isEmpty()){
            JOptionPane.showMessageDialog(null," tidak boleh kosong");
            fieldQuantityDataPembelian.requestFocus();
        } else{

            try{
                Statement statement = (Statement) service.connect.GetConnection().createStatement();
                statement.executeUpdate("INSERT INTO data_pembelian VALUES ('" + IDPembelian + "', '"+ IDSupplier +"', '"+ IDKategori +"', '"+ TanggalHariIni +"', '" + Harga +"', '" + Quantity +"');");
                statement.close ();
                resetDataPembelian();
            }catch (Exception t){
                System.err.println(t);
                JOptionPane.showMessageDialog(null, "data gagal disimpan");
            }
            
            tableDataPembelian();
            autoNumberDataPembelian();
        }
    }//GEN-LAST:event_buttonSimpanDataBarangActionPerformed

    private void buttonResetDataBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetDataBarangActionPerformed
        resetDataPembelian();
    }//GEN-LAST:event_buttonResetDataBarangActionPerformed

    private void buttonEditDataPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditDataPembelianActionPerformed
        String IDPembelian = fieldIDDataPembelian.getText();
        String IDSupplier = fieldSupplierDataPembelian.getText();
        String IDKategori = fieldKategoriDataPembelian.getText();
        String Harga = fieldHargaDataPembelian.getText();
        String Quantity = fieldQuantityDataPembelian.getText();
        
        if(IDSupplier.isEmpty()){
            JOptionPane.showMessageDialog(null," tidak boleh kosong");
            fieldSupplierDataPembelian.requestFocus();
        }else if(IDKategori.isEmpty()){
            JOptionPane.showMessageDialog(null," tidak boleh kosong");
            fieldKategoriDataPembelian.requestFocus();
        }else if(Harga.isEmpty()){
            JOptionPane.showMessageDialog(null," tidak boleh kosong");
            fieldHargaDataPembelian.requestFocus();
        }else if(Quantity.isEmpty()){
            JOptionPane.showMessageDialog(null," tidak boleh kosong");
            fieldQuantityDataPembelian.requestFocus();
        } else{

            try{
                Statement statement = (Statement) service.connect.GetConnection().createStatement();
                statement.executeUpdate("UPDATE data_pembelian SET id_supplier='"+ IDSupplier +"', id_kategori='"+ IDKategori +"', harga_beli='"+ Harga +"', quantity='"+ Quantity +"' WHERE id_pembelian='"+ IDPembelian +"';");
                statement.close ();
                resetDataPembelian();
            }catch (Exception t){
                JOptionPane.showMessageDialog(null, "data gagal disimpan");
            }

            tableDataPembelian();
            autoNumberDataPembelian();
        }
    }//GEN-LAST:event_buttonEditDataPembelianActionPerformed

    private void buttonHapusDataPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusDataPembelianActionPerformed
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            statement.executeUpdate("DELETE FROM data_pembelian WHERE id_pembelian = ('"+ fieldIDDataPembelian.getText() +"');");

            fieldIDDataPembelian.requestFocus();
            fieldIDDataPembelian.getText();
            fieldSupplierDataPembelian.getText();
            fieldKategoriDataPembelian.getText();
            fieldHargaDataPembelian.getText();
            fieldQuantityDataPembelian.getText();
        }
        catch(Exception t){
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }

        tableDataPembelian();
        resetDataPembelian();
        autoNumberDataPembelian();                                                
    }//GEN-LAST:event_buttonHapusDataPembelianActionPerformed

    private void button13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button13ActionPerformed
        new system.massage.list.listDataSupplier().setVisible(true);
    }//GEN-LAST:event_button13ActionPerformed

    private void fieldCariDataPembelianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariDataPembelianKeyReleased
        String key = fieldCariDataPembelian.getText();
        System.out.println(key);

        if(key!=""){
            searchDataPembelian(key);
        }else{
            tableDataPembelian();
        }
    }//GEN-LAST:event_fieldCariDataPembelianKeyReleased

    private void tableDataPembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataPembelianMouseClicked
        fieldIDDataPembelian.setText(tableDataPembelian.getValueAt(tableDataPembelian.getSelectedRow(),0)+"");
        fieldSupplierDataPembelian.setText(tableDataPembelian.getValueAt(tableDataPembelian.getSelectedRow(),1)+"");
        fieldKategoriDataPembelian.setText(tableDataPembelian.getValueAt(tableDataPembelian.getSelectedRow(),2)+"");
        fieldHargaDataPembelian.setText(tableDataPembelian.getValueAt(tableDataPembelian.getSelectedRow(),3)+"");
        fieldQuantityDataPembelian.setText(tableDataPembelian.getValueAt(tableDataPembelian.getSelectedRow(),4)+"");
        fieldTanggalDataPembelian.setText(tableDataPembelian.getValueAt(tableDataPembelian.getSelectedRow(),5)+"");
        
        buttonEditDataPembelian.setEnabled(true);
        buttonHapusDataPembelian.setEnabled(true);
    }//GEN-LAST:event_tableDataPembelianMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button button12;
    public static component.swing.button button13;
    private component.swing.button buttonEditDataPembelian;
    private component.swing.button buttonHapusDataPembelian;
    private component.swing.button buttonResetDataBarang;
    private component.swing.button buttonSimpanDataBarang;
    private component.swing.textFieldMain fieldCariDataPembelian;
    private component.swing.textFieldMain fieldHargaDataPembelian;
    private component.swing.textFieldMain fieldIDDataPembelian;
    public static component.swing.textFieldMain fieldKategoriDataPembelian;
    private component.swing.textFieldMain fieldQuantityDataPembelian;
    public static component.swing.textFieldMain fieldSupplierDataPembelian;
    private component.swing.textFieldMain fieldTanggalDataPembelian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private component.swing.panelRound panelRound1;
    private javax.swing.JScrollPane scrollPaneDataPembelian;
    private component.model.tableCustom.table tableDataPembelian;
    // End of variables declaration//GEN-END:variables
}
