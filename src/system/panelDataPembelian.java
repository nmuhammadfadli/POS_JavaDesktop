package system;

import component.model.table.tableCustom;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class panelDataPembelian extends javax.swing.JPanel {

    
    public panelDataPembelian() {
        initComponents();
        setOpaque(false);
        DataTablePembelian();
        AutonumberPembelian();
        tableCustom.apply(ScrollPanePembelian, tableCustom.TableType.MULTI_LINE);
    }

    public void DataTablePembelian(){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("No");
        isi.addColumn("Supplier");
        isi.addColumn("Kategori");
        isi.addColumn("Quantity");
        isi.addColumn("Harga");
        isi.addColumn("Tanggal");
        
        tableDataPembelian.setModel(isi);
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM pembelian");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("id_pembelian"),
                    result.getString("kode_supplier"),
                    result.getString("id_kategori"),
                    result.getString("quantity"),
                    result.getString("harga_beli"),
                    result.getString("tanggal")

                });
                tableDataPembelian.setModel(isi);
            }        
        }
        catch(Exception e){
            System.out.print("Gagal terhubung");
            JOptionPane.showMessageDialog(null,"Koneksi databases error");
        }
        buttonDataPembelianHapus.setEnabled(false);
        buttonDataPembelianEdit.setEnabled(false);
    }
    
    private void SearchPembelian(String key){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("No");
        isi.addColumn("Supplier");
        isi.addColumn("Kategori");
        isi.addColumn("Quantity");
        isi.addColumn("Harga");
        isi.addColumn("Tanggal");
        
        tableDataPembelian.setModel(isi);
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM pembelian WHERE id_pembelian LIKE '%"+key+"%' OR kode_supplier LIKE '%"+key+"%' OR id_kategori LIKE '%"+key+"%' OR quantity LIKE '%"+key+"%' OR harga_beli LIKE '%"+key+"%' OR tanggal LIKE '%"+key+"%'");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("id_pembelian"),
                    result.getString("kode_supplier"),
                    result.getString("id_kategori"),
                    result.getString("quantity"),
                    result.getString("harga_beli"),
                    result.getString("tanggal")

                });
                tableDataPembelian.setModel(isi);
            }        
        }
        catch(Exception e){
            System.out.print("Gagal menampilkan... ");
            JOptionPane.showMessageDialog(null,"Tidak bisa mencari data");
        }
    }
    
    private void AutonumberPembelian(){
        try {
        Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM pembelian order by id_pembelian desc");
            if(result.next()){
                String id_pembelian = result.getString("id_pembelian");
                String AN = ""+(Integer.parseInt(id_pembelian)+1);
                String Nol = "";
                
                if(AN.length()==1)
                    {Nol="00";}
                else if (AN.length()==2)
                    {Nol="0";}
                else if (AN.length()==3)
                    {Nol="";}
                
                peid.setText( Nol + AN);
                
            } else {
                peid.setText("001");
            }
            statement.close();
            result.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    private void SimpanPembelian(){
        String No = peid.getText();
        String Supplier = pesupplier.getText();
        String Kategori = pekategori.getText();
        String Quantity = pequantity.getText();
        String Harga = peharga.getText();

        java.util.Date Tanggal = new java.util.Date(); 
        java.text.SimpleDateFormat TanggalFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        String tgl_pembelian = TanggalFormat.format(Tanggal);
        if(No.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"No tidak boleh kosong"); 
            peid.requestFocus(); 
        }else if(Supplier.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Supplier tidak boleh kosong"); 
            pesupplier.requestFocus(); 
        }else if(Kategori.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Kategori tidak boleh kosong"); 
            pekategori.requestFocus(); 
        }else if(Quantity.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"quantity tidak boleh kosong"); 
            pequantity.requestFocus(); 
        }else if(Harga.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Harga tidak boleh kosong"); 
            peharga.requestFocus(); 
        } else{
            
        try{
            Statement statement = (Statement) service.connect.GetConnection().createStatement();
            statement.executeUpdate("INSERT INTO pembelian VALUES ('"+ No +"','" + Quantity + "','"+ Harga +"','"+ tgl_pembelian +"','"+ Supplier +"','" + Kategori +"');");
            statement.close ();
        }catch (Exception t){
            JOptionPane.showMessageDialog(null, "data gagal disimpan");
            }
        DataTablePembelian();
        ResetPembelian();
        AutonumberPembelian();
        }
    }
    
    private void EditPembelian(){
        String No = peid.getText();
        String Supplier = pesupplier.getText();
        String Kategori = pekategori.getText();
        String Quantity = pequantity.getText();
        String Harga = peharga.getText();

        java.util.Date Tanggal = new java.util.Date(); 
        java.text.SimpleDateFormat TanggalFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        String tgl_pembelian = TanggalFormat.format(Tanggal);
        
        if(No.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"No tidak boleh kosong"); 
            peid.requestFocus(); 
        }else if(Supplier.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Supplier tidak boleh kosong"); 
            pesupplier.requestFocus(); 
        }else if(Kategori.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Kategori tidak boleh kosong"); 
            pekategori.requestFocus(); 
        }else if(Quantity.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"quantity tidak boleh kosong"); 
            pequantity.requestFocus(); 
        }else if(Harga.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Harga tidak boleh kosong"); 
            peharga.requestFocus(); 
        } else{
            
        try{
            Statement statement = (Statement) service.connect.GetConnection().createStatement();
            statement.executeUpdate("UPDATE pembelian SET id_pembelian='"+ No +"',quantity='"+ Quantity +"', harga_beli='"+ Harga +"',tanggal='"+ tgl_pembelian +"',kode_supplier='"+ Supplier +"',id_kategori='"+ Kategori +"' WHERE id_pembelian='"+ No +"';");
            statement.close ();
        }catch (Exception t){
            JOptionPane.showMessageDialog(null, "data gagal disimpan");
            }
        DataTablePembelian();
        ResetPembelian();
        AutonumberPembelian();
        }
    }
    
    private void HapusPembelian(){
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            statement.executeUpdate("DELETE FROM pembelian WHERE id_pembelian = ('"+ peid.getText() +"');");
            peid.requestFocus();
            peid.getText();
            pequantity.getText();
            peharga.getText();
            petanggal.getText();
            pesupplier.getText();
            pekategori.getText();

        }
        catch(Exception t){
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }
        DataTablePembelian();
        ResetPembelian();
        AutonumberPembelian();
    }
    
    private void ResetPembelian(){
        pequantity.setText("");
        peharga.setText("");
        petanggal.setText("");
        pesupplier.setText("");
        pekategori.setText("");
        
        DataTablePembelian();
        AutonumberPembelian();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pesupplier = new component.swing.textFieldMain();
        jLabel2 = new javax.swing.JLabel();
        pequantity = new component.swing.textFieldMain();
        buttonListSupplier = new component.swing.button();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        peharga = new component.swing.textFieldMain();
        peid = new component.swing.textFieldMain();
        jLabel5 = new javax.swing.JLabel();
        petanggal = new component.swing.textFieldMain();
        textFieldDataPembelianCari = new component.swing.textField();
        buttonDataPembelianHapus = new component.swing.button();
        buttonDataPembelianEdit = new component.swing.button();
        buttonDataPembelianReset = new component.swing.button();
        buttonDataPembelianSimpan = new component.swing.button();
        jLabel6 = new javax.swing.JLabel();
        pekategori = new component.swing.textFieldMain();
        buttonListKategori = new component.swing.button();
        panel1 = new component.swing.panelRound();
        jLabel7 = new javax.swing.JLabel();
        ScrollPanePembelian = new javax.swing.JScrollPane();
        tableDataPembelian = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(725, 591));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Supplier");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 70, 50));

        pesupplier.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.add(pesupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 110, 50));

        jLabel2.setText("Quantity");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 70, 50));

        pequantity.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(pequantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 140, 50));

        buttonListSupplier.setBackground(new java.awt.Color(153, 153, 153));
        buttonListSupplier.setText("...");
        jPanel1.add(buttonListSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 30, 30));

        jLabel3.setText("No Pembelian");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 80, 50));

        jLabel4.setText("Harga ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 60, 50));

        peharga.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(peharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 140, 50));

        peid.setEditable(false);
        peid.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(peid, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 140, 50));

        jLabel5.setText("Tanggal");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 80, 50));

        petanggal.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(petanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 140, 50));

        textFieldDataPembelianCari.setLabelText("Cari");
        textFieldDataPembelianCari.setOpaque(false);
        textFieldDataPembelianCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldDataPembelianCariKeyReleased(evt);
            }
        });
        jPanel1.add(textFieldDataPembelianCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 300, -1));

        buttonDataPembelianHapus.setBackground(new java.awt.Color(255, 0, 0));
        buttonDataPembelianHapus.setForeground(new java.awt.Color(255, 255, 255));
        buttonDataPembelianHapus.setText("Hapus");
        buttonDataPembelianHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataPembelianHapusActionPerformed(evt);
            }
        });
        jPanel1.add(buttonDataPembelianHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 100, -1));

        buttonDataPembelianEdit.setBackground(new java.awt.Color(0, 0, 255));
        buttonDataPembelianEdit.setForeground(new java.awt.Color(255, 255, 255));
        buttonDataPembelianEdit.setText("Edit");
        buttonDataPembelianEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataPembelianEditActionPerformed(evt);
            }
        });
        jPanel1.add(buttonDataPembelianEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 100, -1));

        buttonDataPembelianReset.setBackground(new java.awt.Color(102, 102, 102));
        buttonDataPembelianReset.setForeground(new java.awt.Color(255, 255, 255));
        buttonDataPembelianReset.setText("Reset");
        buttonDataPembelianReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataPembelianResetActionPerformed(evt);
            }
        });
        jPanel1.add(buttonDataPembelianReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 100, -1));

        buttonDataPembelianSimpan.setBackground(new java.awt.Color(0, 255, 0));
        buttonDataPembelianSimpan.setForeground(new java.awt.Color(255, 255, 255));
        buttonDataPembelianSimpan.setText("Simpan");
        buttonDataPembelianSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataPembelianSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(buttonDataPembelianSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 100, -1));

        jLabel6.setText("Kategori");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 60, 50));

        pekategori.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.add(pekategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 110, 50));

        buttonListKategori.setBackground(new java.awt.Color(153, 153, 153));
        buttonListKategori.setText("button6");
        buttonListKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListKategoriActionPerformed(evt);
            }
        });
        jPanel1.add(buttonListKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 30, 30));

        panel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 45)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Data Pembelian");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel1.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 110));

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
        ScrollPanePembelian.setViewportView(tableDataPembelian);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPanePembelian)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPanePembelian, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDataPembelianSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataPembelianSimpanActionPerformed
       SimpanPembelian();
    }//GEN-LAST:event_buttonDataPembelianSimpanActionPerformed

    private void buttonDataPembelianResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataPembelianResetActionPerformed
       ResetPembelian();
    }//GEN-LAST:event_buttonDataPembelianResetActionPerformed

    private void buttonDataPembelianEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataPembelianEditActionPerformed
       EditPembelian();
    }//GEN-LAST:event_buttonDataPembelianEditActionPerformed

    private void buttonDataPembelianHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataPembelianHapusActionPerformed
       HapusPembelian();
    }//GEN-LAST:event_buttonDataPembelianHapusActionPerformed

    private void textFieldDataPembelianCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldDataPembelianCariKeyReleased
        String key =textFieldDataPembelianCari.getText();
        System.out.println(key);
        
        if(key!=""){
            SearchPembelian(key);
        }else{
            DataTablePembelian();
       }
    }//GEN-LAST:event_textFieldDataPembelianCariKeyReleased

    private void tableDataPembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataPembelianMouseClicked
        peid.setText(tableDataPembelian.getValueAt(tableDataPembelian.getSelectedRow(),0)+"");
        pequantity.setText(tableDataPembelian.getValueAt(tableDataPembelian.getSelectedRow(),1)+"");
        peharga.setText(tableDataPembelian.getValueAt(tableDataPembelian.getSelectedRow(),2)+"");
        petanggal.setText(tableDataPembelian.getValueAt(tableDataPembelian.getSelectedRow(),3)+"");
        pesupplier.setText(tableDataPembelian.getValueAt(tableDataPembelian.getSelectedRow(),4)+"");
        pekategori.setText(tableDataPembelian.getValueAt(tableDataPembelian.getSelectedRow(),5)+"");
        
        buttonDataPembelianHapus.setEnabled(true);
        buttonDataPembelianEdit.setEnabled(true);
    }//GEN-LAST:event_tableDataPembelianMouseClicked

    private void buttonListKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListKategoriActionPerformed
        pekategori.setText("");
        system.massage.list.listKategori list = new system.massage.list.listKategori(null, true);
        list.show();
    }//GEN-LAST:event_buttonListKategoriActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPanePembelian;
    private component.swing.button buttonDataPembelianEdit;
    private component.swing.button buttonDataPembelianHapus;
    private component.swing.button buttonDataPembelianReset;
    private component.swing.button buttonDataPembelianSimpan;
    public static component.swing.button buttonListKategori;
    private component.swing.button buttonListSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private component.swing.panelRound panel1;
    private component.swing.textFieldMain peharga;
    private component.swing.textFieldMain peid;
    public static component.swing.textFieldMain pekategori;
    private component.swing.textFieldMain pequantity;
    public static component.swing.textFieldMain pesupplier;
    private component.swing.textFieldMain petanggal;
    private javax.swing.JTable tableDataPembelian;
    private component.swing.textField textFieldDataPembelianCari;
    // End of variables declaration//GEN-END:variables
}
