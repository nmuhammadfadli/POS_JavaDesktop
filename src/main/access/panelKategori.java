package main.access;

import com.mysql.jdbc.Statement;
import component.model.table.tableCustom;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class panelKategori extends javax.swing.JPanel {

    public panelKategori() {
        initComponents();
        setOpaque(false);
        
        tableKategori();
        
        tableKategori.fixTable(scrollPaneKategori);    
    }

    public void tableKategori(){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("ID Kategori");
        isi.addColumn("Nama Kategori");
        
        tableKategori.setModel(isi);
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_kategori");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("id_kategori"),
                    result.getString("nama_kategori"),

                });
                tableKategori.setModel(isi);
            }        
        }
        catch(Exception e){
            System.out.print("Gagal terhubung");
            JOptionPane.showMessageDialog(null,"Koneksi databases error");
        }
        buttonHapusKategori.setEnabled(false);
        buttonEditKategori.setEnabled(false);
    }
    
    private void searchKategori(String key){
         DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("ID Kategori");
        isi.addColumn("Nama Kategori");
        
        tableKategori.setModel(isi);
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_kategori WHERE id_kategori LIKE '%"+key+"%' OR nama_kategori LIKE '%"+key+"%';");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("id_kategori"),
                    result.getString("nama_kategori"),

                });
                tableKategori.setModel(isi);
            }        
        }
        catch(Exception e){
            System.out.print("Gagal menampilkan... ");
            JOptionPane.showMessageDialog(null,"Tidak bisa mencari data");
        }
    }
    
    private void resetKategori(){
        fieldNamaKategori.setText("");

        tableKategori();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonEditKategori = new component.swing.button();
        buttonHapusKategori = new component.swing.button();
        buttonSimpanKategori = new component.swing.button();
        buttonResetKategori = new component.swing.button();
        fieldCariKategori = new component.swing.textFieldMain();
        jLabel1 = new javax.swing.JLabel();
        fieldIDKategori = new component.swing.textFieldMain();
        fieldNamaKategori = new component.swing.textFieldMain();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelRound1 = new component.swing.panelRound();
        scrollPaneKategori = new javax.swing.JScrollPane();
        tableKategori = new component.model.tableCustom.table();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonEditKategori.setBackground(new java.awt.Color(0, 0, 204));
        buttonEditKategori.setForeground(new java.awt.Color(255, 255, 255));
        buttonEditKategori.setText("Edit");
        buttonEditKategori.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonEditKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditKategoriActionPerformed(evt);
            }
        });
        add(buttonEditKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 100, 50));

        buttonHapusKategori.setBackground(new java.awt.Color(204, 0, 0));
        buttonHapusKategori.setForeground(new java.awt.Color(255, 255, 255));
        buttonHapusKategori.setText("Hapus");
        buttonHapusKategori.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonHapusKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusKategoriActionPerformed(evt);
            }
        });
        add(buttonHapusKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, 100, 50));

        buttonSimpanKategori.setBackground(new java.awt.Color(0, 204, 0));
        buttonSimpanKategori.setForeground(new java.awt.Color(255, 255, 255));
        buttonSimpanKategori.setText("Simpan");
        buttonSimpanKategori.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonSimpanKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanKategoriActionPerformed(evt);
            }
        });
        add(buttonSimpanKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 100, 50));

        buttonResetKategori.setBackground(new java.awt.Color(102, 102, 102));
        buttonResetKategori.setForeground(new java.awt.Color(255, 255, 255));
        buttonResetKategori.setText("Reset");
        buttonResetKategori.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonResetKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetKategoriActionPerformed(evt);
            }
        });
        add(buttonResetKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 100, 50));

        fieldCariKategori.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldCariKategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariKategoriKeyReleased(evt);
            }
        });
        add(fieldCariKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 400, 60));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel1.setText("Cari");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        fieldIDKategori.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldIDKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 400, 60));

        fieldNamaKategori.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldNamaKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 430, 60));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel2.setText("ID Kategori");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel3.setText("Nama Kategori");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        panelRound1.setShadowSize(new java.awt.Insets(5, 5, 5, 5));
        panelRound1.setLayout(new java.awt.CardLayout());

        scrollPaneKategori.setBorder(null);

        tableKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKategoriMouseClicked(evt);
            }
        });
        scrollPaneKategori.setViewportView(tableKategori);

        panelRound1.add(scrollPaneKategori, "card2");

        add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 840, 330));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEditKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditKategoriActionPerformed
        String ID = fieldIDKategori.getText();
        String Nama = fieldNamaKategori.getText();

        if(ID.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"ID tidak boleh kosong"); 
            fieldIDKategori.requestFocus(); 
        }else if(Nama.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Kategori tidak boleh kosong"); 
            fieldNamaKategori.requestFocus(); 
        } else{
            
            try{
                Statement statement = (Statement) service.connect.GetConnection().createStatement();
                statement.executeUpdate("UPDATE data_kategori SET id_kategori='"+ ID +"', nama_kategori='"+ Nama +"' WHERE id_kategori='"+ID+"';");
                statement.close ();
            }catch (Exception t){
                JOptionPane.showMessageDialog(null, "data gagal disimpan");
            }
        
            tableKategori();
            resetKategori();
        }
    }//GEN-LAST:event_buttonEditKategoriActionPerformed

    private void buttonHapusKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusKategoriActionPerformed
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            statement.executeUpdate("DELETE FROM data_kategori WHERE id_kategori = ('"+ fieldIDKategori.getText() +"');");
            
            fieldIDKategori.requestFocus();
            fieldIDKategori.getText();
            fieldNamaKategori.getText();
        }
        catch(Exception t){
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }
        
        tableKategori();
        resetKategori();
    }//GEN-LAST:event_buttonHapusKategoriActionPerformed

    private void buttonResetKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetKategoriActionPerformed
        resetKategori();
    }//GEN-LAST:event_buttonResetKategoriActionPerformed

    private void buttonSimpanKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanKategoriActionPerformed
        String ID = fieldIDKategori.getText();
        String Nama = fieldNamaKategori.getText();

        
        if(ID.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"ID tidak boleh kosong"); 
            fieldIDKategori.requestFocus(); 
        }else if(Nama.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong"); 
            fieldNamaKategori.requestFocus(); 
        } else{
            
            try{
                Statement statement = (Statement) service.connect.GetConnection().createStatement();
                statement.executeUpdate("INSERT INTO data_kategori VALUES ('" + ID + "','" + Nama +"');");
                statement.close ();
            }catch (Exception t){
                JOptionPane.showMessageDialog(null, "data gagal disimpan");
            }
        
            tableKategori();
            resetKategori();
        }
    }//GEN-LAST:event_buttonSimpanKategoriActionPerformed

    private void fieldCariKategoriKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariKategoriKeyReleased
        String key = fieldCariKategori.getText();
        System.out.println(key);

        if(key!=""){
            searchKategori(key);
        }else{
            tableKategori();
        }
    }//GEN-LAST:event_fieldCariKategoriKeyReleased

    private void tableKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKategoriMouseClicked
        fieldIDKategori.setText(tableKategori.getValueAt(tableKategori.getSelectedRow(),0)+"");
        fieldNamaKategori.setText(tableKategori.getValueAt(tableKategori.getSelectedRow(),1)+"");
        
        buttonEditKategori.setEnabled(true);
        buttonHapusKategori.setEnabled(true);
    }//GEN-LAST:event_tableKategoriMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button buttonEditKategori;
    private component.swing.button buttonHapusKategori;
    private component.swing.button buttonResetKategori;
    private component.swing.button buttonSimpanKategori;
    private component.swing.textFieldMain fieldCariKategori;
    private component.swing.textFieldMain fieldIDKategori;
    private component.swing.textFieldMain fieldNamaKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private component.swing.panelRound panelRound1;
    private javax.swing.JScrollPane scrollPaneKategori;
    private component.model.tableCustom.table tableKategori;
    // End of variables declaration//GEN-END:variables
}
