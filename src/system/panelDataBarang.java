package system;

import com.mysql.jdbc.Statement;
import component.model.table.tableCustom;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import system.massage.list.listKategori;


public class panelDataBarang extends javax.swing.JPanel {

    
    public panelDataBarang() {
        initComponents();
        setOpaque(false);
        DataTableBarang();
        AutonumberBarang();
        tableCustom.apply(ScrollPaneDataBarang, tableCustom.TableType.MULTI_LINE);
    }
    
    public void DataTableBarang(){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("No Barang");
        isi.addColumn("Nama");
        isi.addColumn("Kategori");
        isi.addColumn("Ukuran");
        isi.addColumn("Harga");
        
        tableDataBarang.setModel(isi);
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_barang");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("id_barang"),
                    result.getString("nama_barang"),
                    result.getString("id_kategori"),
                    result.getString("ukuran"),
                    result.getString("harga")

                });
                tableDataBarang.setModel(isi);
            }        
        }
        catch(Exception e){
            System.out.print("Gagal terhubung");
            JOptionPane.showMessageDialog(null,"Koneksi databases error");
        }
        buttonDataBarangHapus.setEnabled(false);
        buttonDataBarangEdit.setEnabled(false);
    }
    
    private void SearchBarang(String key){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("No Barang");
        isi.addColumn("Kategori");
        isi.addColumn("Nama");
        isi.addColumn("Ukuran");
        isi.addColumn("Harga");
        
        tableDataBarang.setModel(isi);
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_barang WHERE id_barang LIKE '%"+key+"%' OR id_kategori LIKE '%"+key+"%' OR nama_barang LIKE '%"+key+"%' OR ukuran LIKE '%"+key+"%' OR harga LIKE '%"+key+"%'");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("id_barang"),
                    result.getString("id_kategori"),
                    result.getString("nama_barang"),
                    result.getString("ukuran"),
                    result.getString("harga")

                });
                tableDataBarang.setModel(isi);
            }        
        }
        catch(Exception e){
            System.out.print("Gagal menampilkan... ");
            JOptionPane.showMessageDialog(null,"Tidak bisa mencari data");
        }
    }
    
    private void AutonumberBarang(){
        try {
        Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_barang order by id_barang desc");
            if(result.next()){
                String id_barang = result.getString("id_barang").substring(2);
                String AN = ""+(Integer.parseInt(id_barang)+1);
                String Nol = "";
                
                if(AN.length()==1)
                    {Nol="00";}
                else if (AN.length()==2)
                    {Nol="0";}
                else if (AN.length()==3)
                    {Nol="";}
                
                fieldIDBarang.setText("BA" + Nol + AN);
                
            } else {
                fieldIDBarang.setText("BA001");
            }
            statement.close();
            result.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    private void SimpanBarang(){
        String No = fieldIDBarang.getText();
        String Kategori = fieldKategoriBarang.getText();
        String Nama = fieldNamaBarang.getText();
        String Ukuran = fieldUkuranBarang.getText();
        String Harga = fieldHargaBarang.getText();

        if(No.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"No tidak boleh kosong"); 
            fieldIDBarang.requestFocus(); 
        }else if(Kategori.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Kategori tidak boleh kosong"); 
            fieldKategoriBarang.requestFocus(); 
        }else if(Nama.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong"); 
            fieldNamaBarang.requestFocus(); 
        }else if(Ukuran.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Ukuran tidak boleh kosong"); 
            fieldUkuranBarang.requestFocus(); 
        }else if(Harga.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Harga tidak boleh kosong"); 
            fieldHargaBarang.requestFocus(); 
        } else{
            
        try{
            Statement statement = (Statement) service.connect.GetConnection().createStatement();
            statement.executeUpdate("INSERT INTO data_barang VALUES ('" + No + "','"+ Nama +"', '"+ Harga +"', '"+ Ukuran +"', '" + Kategori +"');");
            statement.close ();
            ResetBarang();
        }catch (Exception t){
            JOptionPane.showMessageDialog(null, "data gagal disimpan");
            }
        DataTableBarang();
        AutonumberBarang();
        }
    }
    
    private void EditBarang(){
        String No = fieldIDBarang.getText();
        String Kategori = fieldKategoriBarang.getText();
        String Nama = fieldNamaBarang.getText();
        String Ukuran = fieldUkuranBarang.getText();
        String Harga = fieldHargaBarang.getText();

        
        if(No.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"No tidak boleh kosong"); 
            fieldIDBarang.requestFocus(); 
        }else if(Kategori.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Kategori tidak boleh kosong"); 
            fieldKategoriBarang.requestFocus(); 
        }else if(Nama.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong"); 
            fieldNamaBarang.requestFocus(); 
        }else if(Ukuran.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Ukuran tidak boleh kosong"); 
            fieldUkuranBarang.requestFocus(); 
        }else if(Harga.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Harga tidak boleh kosong"); 
            fieldHargaBarang.requestFocus(); 
        } else{
            
        try{
            Statement statement = (Statement) service.connect.GetConnection().createStatement();
            statement.executeUpdate("UPDATE data_barang SET id_barang='"+ No +"', nama_barang='"+ Nama +"',harga='"+ Harga +"',ukuran='"+ Ukuran +"',id_kategori='"+ Kategori +"' WHERE id_barang='"+ No +"';");
            statement.close ();
            ResetBarang();
        }catch (Exception t){
            JOptionPane.showMessageDialog(null, "data gagal disimpan");
            }
        DataTableBarang();
        AutonumberBarang();
        }
    }
    
    private void HapusBarang(){
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            statement.executeUpdate("DELETE FROM data_barang WHERE id_barang = ('"+ fieldIDBarang.getText() +"');");
            fieldIDBarang.requestFocus();
            fieldIDBarang.getText();
            fieldNamaBarang.getText();
            fieldKategoriBarang.getText();
            fieldUkuranBarang.getText();
            fieldHargaBarang.getText();

        }
        catch(Exception t){
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }
        DataTableBarang();
        ResetBarang();
        AutonumberBarang();
    }
    
    private void ResetBarang(){
        fieldIDBarang.setText("");
        fieldNamaBarang.setText("");
        fieldUkuranBarang.setText("");
        fieldHargaBarang.setText("");

        DataTableBarang();
        AutonumberBarang();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldIDBarang = new component.swing.textFieldMain();
        fieldKategoriBarang = new component.swing.textFieldMain();
        fieldNamaBarang = new component.swing.textFieldMain();
        fieldUkuranBarang = new component.swing.textFieldMain();
        fieldHargaBarang = new component.swing.textFieldMain();
        DataBarangCari = new component.swing.textField();
        buttonDataBarangHapus = new component.swing.button();
        buttonDataBarangEdit = new component.swing.button();
        buttonDataBarangReset = new component.swing.button();
        buttonDataBarangSimpan = new component.swing.button();
        buttonListKategori = new component.swing.button();
        buttonListUkuran = new component.swing.button();
        panel1 = new component.swing.panelRound();
        jLabel6 = new javax.swing.JLabel();
        ScrollPaneDataBarang = new javax.swing.JScrollPane();
        tableDataBarang = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(725, 591));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("No Barang");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 70, 50));

        jLabel2.setText("Kategori");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 60, 50));

        jLabel3.setText("Nama");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 70, 50));

        jLabel4.setText("Ukuran");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 60, 50));

        jLabel5.setText("Harga");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 50, 50));

        fieldIDBarang.setEditable(false);
        fieldIDBarang.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(fieldIDBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 170, 50));

        fieldKategoriBarang.setEditable(false);
        fieldKategoriBarang.setBackground(new java.awt.Color(153, 153, 153));
        fieldKategoriBarang.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(fieldKategoriBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 110, 50));

        fieldNamaBarang.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(fieldNamaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 170, 50));

        fieldUkuranBarang.setBackground(new java.awt.Color(153, 153, 153));
        fieldUkuranBarang.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(fieldUkuranBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 110, 50));

        fieldHargaBarang.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(fieldHargaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 150, 50));

        DataBarangCari.setLabelText("Cari");
        DataBarangCari.setOpaque(false);
        DataBarangCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DataBarangCariKeyReleased(evt);
            }
        });
        jPanel1.add(DataBarangCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 300, -1));

        buttonDataBarangHapus.setBackground(new java.awt.Color(255, 0, 0));
        buttonDataBarangHapus.setForeground(new java.awt.Color(255, 255, 255));
        buttonDataBarangHapus.setText("Hapus");
        buttonDataBarangHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataBarangHapusActionPerformed(evt);
            }
        });
        jPanel1.add(buttonDataBarangHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 100, -1));

        buttonDataBarangEdit.setBackground(new java.awt.Color(0, 0, 255));
        buttonDataBarangEdit.setForeground(new java.awt.Color(255, 255, 255));
        buttonDataBarangEdit.setText("Edit");
        buttonDataBarangEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataBarangEditActionPerformed(evt);
            }
        });
        jPanel1.add(buttonDataBarangEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 100, -1));

        buttonDataBarangReset.setBackground(new java.awt.Color(102, 102, 102));
        buttonDataBarangReset.setForeground(new java.awt.Color(255, 255, 255));
        buttonDataBarangReset.setText("Reset");
        buttonDataBarangReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataBarangResetActionPerformed(evt);
            }
        });
        jPanel1.add(buttonDataBarangReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 100, -1));

        buttonDataBarangSimpan.setBackground(new java.awt.Color(0, 255, 0));
        buttonDataBarangSimpan.setForeground(new java.awt.Color(255, 255, 255));
        buttonDataBarangSimpan.setText("Simpan");
        buttonDataBarangSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataBarangSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(buttonDataBarangSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 100, -1));

        buttonListKategori.setBackground(new java.awt.Color(153, 153, 153));
        buttonListKategori.setForeground(new java.awt.Color(255, 255, 255));
        buttonListKategori.setText("button5");
        buttonListKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListKategoriActionPerformed(evt);
            }
        });
        jPanel1.add(buttonListKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 30, 30));

        buttonListUkuran.setBackground(new java.awt.Color(153, 153, 153));
        buttonListUkuran.setForeground(new java.awt.Color(255, 255, 255));
        buttonListUkuran.setText("button5");
        buttonListUkuran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListUkuranActionPerformed(evt);
            }
        });
        jPanel1.add(buttonListUkuran, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 30, 30));

        panel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 45)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Data Barang");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 110));

        tableDataBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableDataBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataBarangMouseClicked(evt);
            }
        });
        ScrollPaneDataBarang.setViewportView(tableDataBarang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(ScrollPaneDataBarang)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPaneDataBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDataBarangSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataBarangSimpanActionPerformed
        SimpanBarang();
    }//GEN-LAST:event_buttonDataBarangSimpanActionPerformed

    private void buttonDataBarangResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataBarangResetActionPerformed
        ResetBarang();
    }//GEN-LAST:event_buttonDataBarangResetActionPerformed
        
    private void buttonDataBarangEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataBarangEditActionPerformed
        EditBarang();
    }//GEN-LAST:event_buttonDataBarangEditActionPerformed

    private void buttonDataBarangHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataBarangHapusActionPerformed
        HapusBarang();
    }//GEN-LAST:event_buttonDataBarangHapusActionPerformed

    private void DataBarangCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DataBarangCariKeyReleased
        String key =DataBarangCari.getText();
        System.out.println(key);
        
        if(key!=""){
            SearchBarang(key);
        }else{
            DataTableBarang();
        }
    }//GEN-LAST:event_DataBarangCariKeyReleased

    private void buttonListKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListKategoriActionPerformed
        system.massage.list.listKategori list = new system.massage.list.listKategori(null, true);
        list.show(); 
    }//GEN-LAST:event_buttonListKategoriActionPerformed

    private void tableDataBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataBarangMouseClicked
        fieldIDBarang.setText(tableDataBarang.getValueAt(tableDataBarang.getSelectedRow(),0)+"");
        fieldKategoriBarang.setText(tableDataBarang.getValueAt(tableDataBarang.getSelectedRow(),1)+"");
        fieldNamaBarang.setText(tableDataBarang.getValueAt(tableDataBarang.getSelectedRow(),2)+"");
        fieldUkuranBarang.setText(tableDataBarang.getValueAt(tableDataBarang.getSelectedRow(),3)+"");
        fieldHargaBarang.setText(tableDataBarang.getValueAt(tableDataBarang.getSelectedRow(),4)+"");
        
        buttonDataBarangHapus.setEnabled(true);
        buttonDataBarangEdit.setEnabled(true);
    }//GEN-LAST:event_tableDataBarangMouseClicked

    private void buttonListUkuranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListUkuranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonListUkuranActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.textField DataBarangCari;
    private javax.swing.JScrollPane ScrollPaneDataBarang;
    private component.swing.button buttonDataBarangEdit;
    private component.swing.button buttonDataBarangHapus;
    private component.swing.button buttonDataBarangReset;
    private component.swing.button buttonDataBarangSimpan;
    public static component.swing.button buttonListKategori;
    public static component.swing.button buttonListUkuran;
    private component.swing.textFieldMain fieldHargaBarang;
    private component.swing.textFieldMain fieldIDBarang;
    public static component.swing.textFieldMain fieldKategoriBarang;
    private component.swing.textFieldMain fieldNamaBarang;
    private component.swing.textFieldMain fieldUkuranBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private component.swing.panelRound panel1;
    private javax.swing.JTable tableDataBarang;
    // End of variables declaration//GEN-END:variables
}
