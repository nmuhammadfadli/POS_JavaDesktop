package main.access;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class panelDataBarang extends javax.swing.JPanel {

    public panelDataBarang() {
        initComponents();
        setOpaque(false);
        
        tableDataBarang();
        autoNumberDataBarang();
        
        tableDataBarang.fixTable(scrollPaneDataBarang);
    }
    
    private boolean aksi;
    
    public void changeIcon(JButton align, String iconSet) {
        ImageIcon set = new ImageIcon(getClass().getResource(iconSet));
        align.setIcon(set);   
    }
    
    public void tableDataBarang(){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("ID Barang");
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
                    result.getString("harga_barang")

                });
                tableDataBarang.setModel(isi);
            }        
        }
        catch(Exception e){
            System.out.print("Gagal terhubung");
            JOptionPane.showMessageDialog(null,"Koneksi databases error");
        }
        buttonEditDataBarang.setEnabled(false);
        buttonHapusDataBarang.setEnabled(false);
    }
    
    private void searchDataBarang(String key){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("ID Barang");
        isi.addColumn("Kategori");
        isi.addColumn("Nama");
        isi.addColumn("Ukuran");
        isi.addColumn("Harga");
        
        tableDataBarang.setModel(isi);
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_barang WHERE id_barang LIKE '%"+key+"%' OR id_kategori LIKE '%"+key+"%' OR nama_barang LIKE '%"+key+"%' OR ukuran LIKE '%"+key+"%' OR harga_barang LIKE '%"+key+"%'");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("id_barang"),
                    result.getString("id_kategori"),
                    result.getString("nama_barang"),
                    result.getString("ukuran"),
                    result.getString("harga_barang")
                });
                tableDataBarang.setModel(isi);
            }        
        }
        catch(Exception e){
            System.out.print("Gagal menampilkan... ");
            JOptionPane.showMessageDialog(null,"Tidak bisa mencari data");
        }
    }
    
    private void resetDataBarang(){
        fieldIDDataBarang.setText("");
        fieldNamaDataBarang.setText("");
        fieldUkuranDataBarang.setText("");
        fieldHargaDataBarang.setText("");

        tableDataBarang();
        autoNumberDataBarang();
    }
    
    private void autoNumberDataBarang(){
        try {
        Statement statement = (Statement)service.connect.GetConnection().createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM data_barang ORDER BY id_barang DESC;");
        if(result.next()){
            String id_barang = result.getString("id_barang").substring(4);
            String AN = ""+(Integer.parseInt(id_barang)+1);
            String Nol = "";
                
            if(AN.length()==1)
                {Nol="00";}
            else if (AN.length()==2)
                {Nol="0";}
            else if (AN.length()==3)
                {Nol="";}
                
            fieldIDDataBarang.setText("BrNG" + Nol + AN);    
        } else {
            fieldIDDataBarang.setText("BrNG001");
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

        fieldIDKategoriDataBarang = new javax.swing.JTextField();
        button12 = new component.swing.button();
        jLabel1 = new javax.swing.JLabel();
        fieldIDDataBarang = new component.swing.textFieldMain();
        fieldNamaDataBarang = new component.swing.textFieldMain();
        buttonSimpanDataBarang = new component.swing.button();
        buttonResetDataBarang = new component.swing.button();
        buttonEditDataBarang = new component.swing.button();
        buttonHapusDataBarang = new component.swing.button();
        panelRound1 = new component.swing.panelRound();
        scrollPaneDataBarang = new javax.swing.JScrollPane();
        tableDataBarang = new component.model.tableCustom.table();
        jLabel2 = new javax.swing.JLabel();
        fieldCariDataBarang = new component.swing.textFieldMain();
        jLabel3 = new javax.swing.JLabel();
        fieldKategoriDataBarang = new component.swing.textFieldMain();
        fieldUkuranDataBarang = new component.swing.textFieldMain();
        fieldHargaDataBarang = new component.swing.textFieldMain();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        fieldIDKategoriDataBarang.setText("jTextField1");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/align.png"))); // NOI18N
        button12.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        button12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button12ActionPerformed(evt);
            }
        });
        add(button12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 60, 60));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel1.setText("ID Barang");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        fieldIDDataBarang.setEditable(false);
        fieldIDDataBarang.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldIDDataBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 260, 60));

        fieldNamaDataBarang.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldNamaDataBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 260, 60));

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

        buttonEditDataBarang.setBackground(new java.awt.Color(0, 0, 204));
        buttonEditDataBarang.setForeground(new java.awt.Color(255, 255, 255));
        buttonEditDataBarang.setText("Edit");
        buttonEditDataBarang.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonEditDataBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditDataBarangActionPerformed(evt);
            }
        });
        add(buttonEditDataBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 100, 50));

        buttonHapusDataBarang.setBackground(new java.awt.Color(204, 0, 0));
        buttonHapusDataBarang.setForeground(new java.awt.Color(255, 255, 255));
        buttonHapusDataBarang.setText("Hapus");
        buttonHapusDataBarang.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonHapusDataBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusDataBarangActionPerformed(evt);
            }
        });
        add(buttonHapusDataBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, 100, 50));

        panelRound1.setLayout(new java.awt.BorderLayout());

        scrollPaneDataBarang.setBorder(null);

        tableDataBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollPaneDataBarang.setViewportView(tableDataBarang);

        panelRound1.add(scrollPaneDataBarang, java.awt.BorderLayout.CENTER);

        add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 840, 250));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel2.setText("Nama Barang");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        fieldCariDataBarang.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldCariDataBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariDataBarangKeyReleased(evt);
            }
        });
        add(fieldCariDataBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 400, 60));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel3.setText("Cari");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        fieldKategoriDataBarang.setEditable(false);
        fieldKategoriDataBarang.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldKategoriDataBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 240, 60));

        fieldUkuranDataBarang.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldUkuranDataBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 300, 60));

        fieldHargaDataBarang.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldHargaDataBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 260, 60));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel4.setText("Kategori");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel5.setText("Ukuran");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel6.setText("Harga");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSimpanDataBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanDataBarangActionPerformed
        String No = fieldIDDataBarang.getText();
        String Kategori = fieldKategoriDataBarang.getText();
        String Nama = fieldNamaDataBarang.getText();
        String Ukuran = fieldUkuranDataBarang.getText();
        String Harga = fieldHargaDataBarang.getText();

        java.util.Date Tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat = new java.text.SimpleDateFormat("dd-MM-YYYY");
        String CreateDate = TanggalFormat.format(Tanggal);
        
        if(No.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"No tidak boleh kosong"); 
            fieldIDDataBarang.requestFocus(); 
        }else if(Kategori.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Kategori tidak boleh kosong"); 
            fieldKategoriDataBarang.requestFocus(); 
        }else if(Nama.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong"); 
            fieldNamaDataBarang.requestFocus(); 
        }else if(Ukuran.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Ukuran tidak boleh kosong"); 
            fieldUkuranDataBarang.requestFocus(); 
        }else if(Harga.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Harga tidak boleh kosong"); 
            fieldHargaDataBarang.requestFocus(); 
        } else{
            
        try{
            Statement statement = (Statement) service.connect.GetConnection().createStatement();
            statement.executeUpdate("INSERT INTO data_barang (id_barang, id_kategori, nama_barang, harga_barang, ukuran) VALUES ('" + No + "', '" + Kategori +"', '"+ Nama +"', '"+ Harga +"', '"+ Ukuran +"');");
            statement.close ();
            resetDataBarang();
        }catch (Exception t){
            JOptionPane.showMessageDialog(null, t);
            }
        tableDataBarang();
        autoNumberDataBarang();
        }
    }//GEN-LAST:event_buttonSimpanDataBarangActionPerformed

    private void buttonResetDataBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetDataBarangActionPerformed
        resetDataBarang();
    }//GEN-LAST:event_buttonResetDataBarangActionPerformed

    private void buttonEditDataBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditDataBarangActionPerformed
        String No = fieldIDDataBarang.getText();
        String Kategori = fieldKategoriDataBarang.getText();
        String Nama = fieldNamaDataBarang.getText();
        String Ukuran = fieldUkuranDataBarang.getText();
        String Harga = fieldHargaDataBarang.getText();

        if(No.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"No tidak boleh kosong"); 
            fieldIDDataBarang.requestFocus(); 
        }else if(Kategori.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Kategori tidak boleh kosong"); 
            fieldKategoriDataBarang.requestFocus(); 
        }else if(Nama.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong"); 
            fieldNamaDataBarang.requestFocus(); 
        }else if(Ukuran.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Ukuran tidak boleh kosong"); 
            fieldUkuranDataBarang.requestFocus(); 
        }else if(Harga.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Harga tidak boleh kosong"); 
            fieldHargaDataBarang.requestFocus(); 
        } else{
            
        try{
            Statement statement = (Statement) service.connect.GetConnection().createStatement();
            statement.executeUpdate("UPDATE data_barang SET id_barang='"+ No +"', nama_barang='"+ Nama +"', harga_barang='"+ Harga +"', ukuran='"+ Ukuran +"', id_kategori='"+ Kategori +"' WHERE id_barang='"+ No +"';");
            statement.close ();
            resetDataBarang();
        }catch (Exception t){
            JOptionPane.showMessageDialog(null, "data gagal disimpan");
            }
        
        tableDataBarang();
        autoNumberDataBarang();
        }
    }//GEN-LAST:event_buttonEditDataBarangActionPerformed

    private void buttonHapusDataBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusDataBarangActionPerformed
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            statement.executeUpdate("DELETE FROM data_barang WHERE id_barang = ('"+ fieldIDDataBarang.getText() +"');");
            
            fieldIDDataBarang.requestFocus();
            fieldIDDataBarang.getText();
            fieldNamaDataBarang.getText();
            fieldKategoriDataBarang.getText();
            fieldUkuranDataBarang.getText();
            fieldHargaDataBarang.getText();

        }
        catch(Exception t){
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }
        
        tableDataBarang();
        resetDataBarang();
        autoNumberDataBarang();
    }//GEN-LAST:event_buttonHapusDataBarangActionPerformed

    private void button12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button12ActionPerformed
//        if(aksi == true){
//            changeIcon(button12, "/resource/icon/align_hover.png");
//            button12.setBackground(new Color(242, 242, 242));
              new system.massage.list.listKategoriDataBarang().setVisible(true);
//            listKategoriDataBarang list = new listKategoriDataBarang(getNotify(), true);
//            list.show(); 
            
//            aksi = false;
//        } else {
//            changeIcon(button12, "/resource/icon/align.png");
//            button12.setBackground(new Color(255, 255, 255));
//            aksi = true;
//        } 
    }//GEN-LAST:event_button12ActionPerformed

    private void fieldCariDataBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariDataBarangKeyReleased
        String key = fieldCariDataBarang.getText();
        System.out.println(key);
        
        if(key!=""){
            searchDataBarang(key);
        }else{
            tableDataBarang();
        }
    }//GEN-LAST:event_fieldCariDataBarangKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static component.swing.button button12;
    private component.swing.button buttonEditDataBarang;
    private component.swing.button buttonHapusDataBarang;
    private component.swing.button buttonResetDataBarang;
    private component.swing.button buttonSimpanDataBarang;
    private component.swing.textFieldMain fieldCariDataBarang;
    private component.swing.textFieldMain fieldHargaDataBarang;
    private component.swing.textFieldMain fieldIDDataBarang;
    public static javax.swing.JTextField fieldIDKategoriDataBarang;
    public static component.swing.textFieldMain fieldKategoriDataBarang;
    public static component.swing.textFieldMain fieldNamaDataBarang;
    private component.swing.textFieldMain fieldUkuranDataBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private component.swing.panelRound panelRound1;
    private javax.swing.JScrollPane scrollPaneDataBarang;
    private component.model.tableCustom.table tableDataBarang;
    // End of variables declaration//GEN-END:variables
}
