package report;

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
        
        tableCustom.apply(scrollPaneDataPembelian, tableCustom.TableType.MULTI_LINE);
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

        panelGradient6 = new component.swing.panelGradient();
        panelRound19 = new component.swing.panelRound();
        fieldKategoriDataPembelian = new component.swing.textField();
        button12 = new component.swing.button();
        panelRound20 = new component.swing.panelRound();
        fieldQuantityDataPembelian = new component.swing.textField();
        panelRound21 = new component.swing.panelRound();
        fieldTanggalDataPembelian = new component.swing.textField();
        panelRound16 = new component.swing.panelRound();
        fieldIDDataPembelian = new component.swing.textField();
        panelRound17 = new component.swing.panelRound();
        fieldSupplierDataPembelian = new component.swing.textField();
        button14 = new component.swing.button();
        panelRound22 = new component.swing.panelRound();
        fieldHargaDataPembelian = new component.swing.textField();
        panelGradient5 = new component.swing.panelGradient();
        buttonEditDataPembelian = new component.swing.button();
        buttonHapusDataPembelian = new component.swing.button();
        panelRound15 = new component.swing.panelRound();
        fieldCariDataPembelian = new component.swing.textField();
        buttonResetDataPembelian = new component.swing.button();
        buttonSimpanDataPembelian = new component.swing.button();
        scrollPaneDataPembelian = new javax.swing.JScrollPane();
        tableDataPembelian = new javax.swing.JTable();

        panelGradient6.setBackground(new java.awt.Color(238, 238, 238));
        panelGradient6.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelGradient6.setColorGradient(new java.awt.Color(242, 242, 242));
        panelGradient6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldKategoriDataPembelian.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldKategoriDataPembelian.setLabelText("Kategori");
        panelRound19.add(fieldKategoriDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 128, -1));

        button12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/align.png"))); // NOI18N
        button12.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        button12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button12ActionPerformed(evt);
            }
        });
        panelRound19.add(button12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 50, 50));

        panelGradient6.add(panelRound19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 190, 70));

        panelRound20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldQuantityDataPembelian.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldQuantityDataPembelian.setLabelText("Quantity");
        panelRound20.add(fieldQuantityDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 170, -1));

        panelGradient6.add(panelRound20, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 190, 70));

        fieldTanggalDataPembelian.setEditable(false);
        fieldTanggalDataPembelian.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldTanggalDataPembelian.setLabelText("Tanggal");

        javax.swing.GroupLayout panelRound21Layout = new javax.swing.GroupLayout(panelRound21);
        panelRound21.setLayout(panelRound21Layout);
        panelRound21Layout.setHorizontalGroup(
            panelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldTanggalDataPembelian, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );
        panelRound21Layout.setVerticalGroup(
            panelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(fieldTanggalDataPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelGradient6.add(panelRound21, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 190, 70));

        panelRound16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldIDDataPembelian.setEditable(false);
        fieldIDDataPembelian.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldIDDataPembelian.setLabelText("ID Pembelian");
        panelRound16.add(fieldIDDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 50));

        panelGradient6.add(panelRound16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 70));

        panelRound17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldSupplierDataPembelian.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldSupplierDataPembelian.setLabelText("Supplier");
        panelRound17.add(fieldSupplierDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 130, -1));

        button14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/align.png"))); // NOI18N
        button14.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        button14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button14ActionPerformed(evt);
            }
        });
        panelRound17.add(button14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 50, 50));

        panelGradient6.add(panelRound17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 190, 70));

        fieldHargaDataPembelian.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldHargaDataPembelian.setLabelText("Harga");

        javax.swing.GroupLayout panelRound22Layout = new javax.swing.GroupLayout(panelRound22);
        panelRound22.setLayout(panelRound22Layout);
        panelRound22Layout.setHorizontalGroup(
            panelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldHargaDataPembelian, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );
        panelRound22Layout.setVerticalGroup(
            panelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound22Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(fieldHargaDataPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelGradient6.add(panelRound22, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, 70));

        panelGradient5.setBackground(new java.awt.Color(238, 238, 238));
        panelGradient5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelGradient5.setColorGradient(new java.awt.Color(242, 242, 242));
        panelGradient5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonEditDataPembelian.setBackground(new java.awt.Color(0, 0, 204));
        buttonEditDataPembelian.setForeground(new java.awt.Color(255, 255, 255));
        buttonEditDataPembelian.setText("Edit");
        buttonEditDataPembelian.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonEditDataPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditDataPembelianActionPerformed(evt);
            }
        });
        panelGradient5.add(buttonEditDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 90, 50));

        buttonHapusDataPembelian.setBackground(new java.awt.Color(204, 0, 0));
        buttonHapusDataPembelian.setForeground(new java.awt.Color(255, 255, 255));
        buttonHapusDataPembelian.setText("Hapus");
        buttonHapusDataPembelian.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonHapusDataPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusDataPembelianActionPerformed(evt);
            }
        });
        panelGradient5.add(buttonHapusDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 90, 50));

        panelRound15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldCariDataPembelian.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldCariDataPembelian.setLabelText("Cari");
        fieldCariDataPembelian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariDataPembelianKeyReleased(evt);
            }
        });
        panelRound15.add(fieldCariDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 11, 240, 50));

        panelGradient5.add(panelRound15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 70));

        buttonResetDataPembelian.setBackground(new java.awt.Color(102, 102, 102));
        buttonResetDataPembelian.setForeground(new java.awt.Color(255, 255, 255));
        buttonResetDataPembelian.setText("Reset");
        buttonResetDataPembelian.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonResetDataPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetDataPembelianActionPerformed(evt);
            }
        });
        panelGradient5.add(buttonResetDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 90, 50));

        buttonSimpanDataPembelian.setBackground(new java.awt.Color(0, 204, 0));
        buttonSimpanDataPembelian.setForeground(new java.awt.Color(255, 255, 255));
        buttonSimpanDataPembelian.setText("Simpan");
        buttonSimpanDataPembelian.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonSimpanDataPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanDataPembelianActionPerformed(evt);
            }
        });
        panelGradient5.add(buttonSimpanDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 90, 50));

        tableDataPembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableDataPembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataPembelianMouseClicked(evt);
            }
        });
        scrollPaneDataPembelian.setViewportView(tableDataPembelian);

        panelGradient5.add(scrollPaneDataPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 630, 190));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient6, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelGradient5, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradient6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(panelGradient5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fieldCariDataPembelianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariDataPembelianKeyReleased
        String key = fieldCariDataPembelian.getText();
        System.out.println(key);

        if(key!=""){
            searchDataPembelian(key);
        }else{
            tableDataPembelian();
        }
    }//GEN-LAST:event_fieldCariDataPembelianKeyReleased

    private void buttonSimpanDataPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanDataPembelianActionPerformed
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
    }//GEN-LAST:event_buttonSimpanDataPembelianActionPerformed

    private void buttonResetDataPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetDataPembelianActionPerformed
        resetDataPembelian();
    }//GEN-LAST:event_buttonResetDataPembelianActionPerformed

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

    private void button12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button12ActionPerformed

    private void button14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button14ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button button12;
    private component.swing.button button14;
    private component.swing.button buttonEditDataPembelian;
    private component.swing.button buttonHapusDataPembelian;
    private component.swing.button buttonResetDataPembelian;
    private component.swing.button buttonSimpanDataPembelian;
    private component.swing.textField fieldCariDataPembelian;
    private component.swing.textField fieldHargaDataPembelian;
    private component.swing.textField fieldIDDataPembelian;
    private component.swing.textField fieldKategoriDataPembelian;
    private component.swing.textField fieldQuantityDataPembelian;
    private component.swing.textField fieldSupplierDataPembelian;
    private component.swing.textField fieldTanggalDataPembelian;
    private component.swing.panelGradient panelGradient5;
    private component.swing.panelGradient panelGradient6;
    private component.swing.panelRound panelRound15;
    private component.swing.panelRound panelRound16;
    private component.swing.panelRound panelRound17;
    private component.swing.panelRound panelRound19;
    private component.swing.panelRound panelRound20;
    private component.swing.panelRound panelRound21;
    private component.swing.panelRound panelRound22;
    private javax.swing.JScrollPane scrollPaneDataPembelian;
    private javax.swing.JTable tableDataPembelian;
    // End of variables declaration//GEN-END:variables
}
