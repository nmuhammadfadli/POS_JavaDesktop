package main.access;

import com.mysql.jdbc.Statement;
import component.model.table.tableCustom;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class panelDataPengeluaran extends javax.swing.JPanel {

    public panelDataPengeluaran() {
        initComponents();
        setOpaque(false);
        
        tableDataPengeluaran();
        autoNumberDataPengeluaran();
        
        java.util.Date Tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat = new java.text.SimpleDateFormat("dd-MM-YYYY");
        String CreateDate = TanggalFormat.format(Tanggal);
        
        fieldTanggalDataPengeluaran.setText(CreateDate);
        
        tableDataPengeluaran.fixTable(scrollPaneDataPengeluaran);
    }

    public void tableDataPengeluaran(){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("ID Pengeluaran");
        isi.addColumn("Nama Pengeluaran");
        isi.addColumn("Tanggal");
        isi.addColumn("Nominal");
        isi.addColumn("Pengguna");
        
        tableDataPengeluaran.setModel(isi);
        
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_pengeluaran;");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("id_pengeluaran"),
                    result.getString("nama_pengeluaran"),
                    result.getString("tanggal_pengeluaran"),
                    result.getString("nominal"),
                    result.getString("pengguna")
                });
                tableDataPengeluaran.setModel(isi);
            }        
        }
        catch(Exception e){
            System.err.print(e);
            JOptionPane.showMessageDialog(null,"Koneksi databases error");
        }
        
        buttonHapusDataPengeluaran.setEnabled(false);
        buttonEditDataPengeluaran.setEnabled(false);
    }    
    
    private void searchDataPengeluaran(String key){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("ID Pengeluaran");
        isi.addColumn("Nama Pengeluaran");
        isi.addColumn("Tanggal");
        isi.addColumn("Nominal");
        isi.addColumn("Pengguna");
  
        tableDataPengeluaran.setModel(isi);
        
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_pengeluaran WHERE id_pengeluaran LIKE '%"+key+"%' OR nama_pengeluaran LIKE '%"+key+"%' OR tanggal_pengeluaran LIKE '%"+key+"%' OR nominal LIKE '%"+key+"%' OR pengguna LIKE '%"+key+"%';");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("id_pengeluaran"),
                    result.getString("nama_pengeluaran"),
                    result.getString("tanggal_pengeluaran"),
                    result.getString("nominal"),
                    result.getString("pengguna") 
                });
            tableDataPengeluaran.setModel(isi);
            }
        }
        
        catch(Exception e){
            System.err.print(e);
            JOptionPane.showMessageDialog(null,"Tidak bisa mencari data");
        }
    }
    
    private void resetDataPengeluaran(){
        fieldIDDataPengeluaran.setText("");
        fieldNamaDataPengeluaran.setText(""); 
        fieldNominalDataPengeluaran.setText("");
        fieldPenggunaDataPengeluaran.setText("");

        tableDataPengeluaran();
        autoNumberDataPengeluaran();
    }
    
    private void autoNumberDataPengeluaran(){
        try {
        Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_pengeluaran ORDER BY id_pengeluaran DESC;");
            if(result.next()){
                String ID = result.getString("id_pengeluaran").substring(4);
                String AND = ""+(Integer.parseInt(ID)+1);
                String Nol = "";
                
                if(AND.length()==1)
                    {Nol="000";}
                else if (AND.length()==2)
                    {Nol="00";}
                else if (AND.length()==3)
                    {Nol="0";}
                else if (AND.length()==4)
                    {Nol="";}
                
                fieldIDDataPengeluaran.setText("PGeR" + Nol + AND);
                
            } else {
                fieldIDDataPengeluaran.setText("PGeR0001");
            }
            
            statement.close();
            result.close();
        }catch (Exception t){
            JOptionPane.showMessageDialog(null, t);
        }  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fieldIDDataPengeluaran = new component.swing.textFieldMain();
        fieldNamaDataPengeluaran = new component.swing.textFieldMain();
        buttonSimpanDataPengeluaran = new component.swing.button();
        buttonResetDataPengeluaran = new component.swing.button();
        buttonEditDataPengeluaran = new component.swing.button();
        buttonHapusDataPengeluaran = new component.swing.button();
        panelRound1 = new component.swing.panelRound();
        scrollPaneDataPengeluaran = new javax.swing.JScrollPane();
        tableDataPengeluaran = new component.model.tableCustom.table();
        jLabel2 = new javax.swing.JLabel();
        fieldCariDataPengeluaran = new component.swing.textFieldMain();
        jLabel3 = new javax.swing.JLabel();
        fieldPenggunaDataPengeluaran = new component.swing.textFieldMain();
        fieldNominalDataPengeluaran = new component.swing.textFieldMain();
        fieldTanggalDataPengeluaran = new component.swing.textFieldMain();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel1.setText("ID Pengeluaran");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        fieldIDDataPengeluaran.setEditable(false);
        fieldIDDataPengeluaran.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldIDDataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 270, 60));

        fieldNamaDataPengeluaran.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldNamaDataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 270, 60));

        buttonSimpanDataPengeluaran.setBackground(new java.awt.Color(0, 204, 0));
        buttonSimpanDataPengeluaran.setForeground(new java.awt.Color(255, 255, 255));
        buttonSimpanDataPengeluaran.setText("Simpan");
        buttonSimpanDataPengeluaran.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonSimpanDataPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanDataPengeluaranActionPerformed(evt);
            }
        });
        add(buttonSimpanDataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 100, 50));

        buttonResetDataPengeluaran.setBackground(new java.awt.Color(102, 102, 102));
        buttonResetDataPengeluaran.setForeground(new java.awt.Color(255, 255, 255));
        buttonResetDataPengeluaran.setText("Reset");
        buttonResetDataPengeluaran.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonResetDataPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetDataPengeluaranActionPerformed(evt);
            }
        });
        add(buttonResetDataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 100, 50));

        buttonEditDataPengeluaran.setBackground(new java.awt.Color(0, 0, 204));
        buttonEditDataPengeluaran.setForeground(new java.awt.Color(255, 255, 255));
        buttonEditDataPengeluaran.setText("Edit");
        buttonEditDataPengeluaran.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonEditDataPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditDataPengeluaranActionPerformed(evt);
            }
        });
        add(buttonEditDataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 100, 50));

        buttonHapusDataPengeluaran.setBackground(new java.awt.Color(204, 0, 0));
        buttonHapusDataPengeluaran.setForeground(new java.awt.Color(255, 255, 255));
        buttonHapusDataPengeluaran.setText("Hapus");
        buttonHapusDataPengeluaran.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonHapusDataPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusDataPengeluaranActionPerformed(evt);
            }
        });
        add(buttonHapusDataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, 100, 50));

        panelRound1.setLayout(new java.awt.BorderLayout());

        scrollPaneDataPengeluaran.setBorder(null);

        tableDataPengeluaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableDataPengeluaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataPengeluaranMouseClicked(evt);
            }
        });
        scrollPaneDataPengeluaran.setViewportView(tableDataPengeluaran);

        panelRound1.add(scrollPaneDataPengeluaran, java.awt.BorderLayout.CENTER);

        add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 840, 250));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel2.setText("Nama Pengeluaran");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        fieldCariDataPengeluaran.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldCariDataPengeluaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariDataPengeluaranKeyReleased(evt);
            }
        });
        add(fieldCariDataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 400, 60));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel3.setText("Cari");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        fieldPenggunaDataPengeluaran.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldPenggunaDataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 280, 60));

        fieldNominalDataPengeluaran.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldNominalDataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 280, 60));

        fieldTanggalDataPengeluaran.setEditable(false);
        fieldTanggalDataPengeluaran.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldTanggalDataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 270, 60));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel4.setText("Pengguna");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel5.setText("Nominal");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel6.setText("Tanggal");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSimpanDataPengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanDataPengeluaranActionPerformed
        String ID = fieldIDDataPengeluaran.getText();
        String Nama = fieldNamaDataPengeluaran.getText();
        String Nominal = fieldNominalDataPengeluaran.getText();
        String Pengguna = fieldPenggunaDataPengeluaran.getText();

        java.util.Date Tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat = new java.text.SimpleDateFormat("dd-MM-YYYY");
        String CreateDate = TanggalFormat.format(Tanggal);
        
        if(ID.isEmpty()){
            JOptionPane.showMessageDialog(null,"No tidak boleh kosong");
            fieldIDDataPengeluaran.requestFocus();
        }else if(Nama.isEmpty()){
            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong");
            fieldNamaDataPengeluaran.requestFocus();
        }else if(Nominal.isEmpty()){
            JOptionPane.showMessageDialog(null,"Ukuran tidak boleh kosong");
            fieldNominalDataPengeluaran.requestFocus();
        }else if(Pengguna.isEmpty()){
            JOptionPane.showMessageDialog(null,"Harga tidak boleh kosong");
            fieldPenggunaDataPengeluaran.requestFocus();
        } else{

            try{
                Statement statement = (Statement) service.connect.GetConnection().createStatement();
                statement.executeUpdate("INSERT INTO data_pengeluaran VALUES ('" + ID + "', '" + Nama +"', '"+ Nominal +"', '"+ CreateDate +"', '"+ Pengguna +"');");
                statement.close ();
                resetDataPengeluaran();
            }catch (Exception t){
                JOptionPane.showMessageDialog(null, t);
            }
            tableDataPengeluaran();
            autoNumberDataPengeluaran();
        }
    }//GEN-LAST:event_buttonSimpanDataPengeluaranActionPerformed

    private void buttonResetDataPengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetDataPengeluaranActionPerformed
        resetDataPengeluaran();
    }//GEN-LAST:event_buttonResetDataPengeluaranActionPerformed

    private void buttonEditDataPengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditDataPengeluaranActionPerformed
        String ID = fieldIDDataPengeluaran.getText();
        String Nama = fieldNamaDataPengeluaran.getText();
        String Nominal = fieldNominalDataPengeluaran.getText();
        String Pengguna = fieldPenggunaDataPengeluaran.getText();

        if(ID.isEmpty()){
            JOptionPane.showMessageDialog(null,"No tidak boleh kosong");
            fieldIDDataPengeluaran.requestFocus();
        }else if(Nama.isEmpty()){
            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong");
            fieldNamaDataPengeluaran.requestFocus();
        }else if(Nominal.isEmpty()){
            JOptionPane.showMessageDialog(null,"Ukuran tidak boleh kosong");
            fieldNominalDataPengeluaran.requestFocus();
        }else if(Pengguna.isEmpty()){
            JOptionPane.showMessageDialog(null,"Harga tidak boleh kosong");
            fieldPenggunaDataPengeluaran.requestFocus();
        } else{

            try{
                Statement statement = (Statement) service.connect.GetConnection().createStatement();
                statement.executeUpdate("UPDATE data_pengeluaran SET id_pengeluaran='"+ ID +"', nama_pengeluaran='"+ Nama +"', nominal='"+ Nominal +"', pengguna='"+ Pengguna +"' WHERE id_pengeluaran='"+ ID +"';");
                statement.close ();
                resetDataPengeluaran();
            }catch (Exception t){
                JOptionPane.showMessageDialog(null, "data gagal disimpan");
            }

            tableDataPengeluaran();
            autoNumberDataPengeluaran();
        }
    }//GEN-LAST:event_buttonEditDataPengeluaranActionPerformed

    private void buttonHapusDataPengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusDataPengeluaranActionPerformed
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            statement.executeUpdate("DELETE FROM data_pengeluaran WHERE id_pengeluaran = ('"+ fieldIDDataPengeluaran.getText() +"');");

            fieldIDDataPengeluaran.requestFocus();
            fieldIDDataPengeluaran.getText();
            fieldNamaDataPengeluaran.getText();
            fieldTanggalDataPengeluaran.getText();
            fieldNominalDataPengeluaran.getText();
            fieldPenggunaDataPengeluaran.getText();
        }
        catch(Exception t){
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }

        tableDataPengeluaran();
        resetDataPengeluaran();
        autoNumberDataPengeluaran();
    }//GEN-LAST:event_buttonHapusDataPengeluaranActionPerformed

    private void fieldCariDataPengeluaranKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariDataPengeluaranKeyReleased
        String key = fieldCariDataPengeluaran.getText();
        System.out.println(key);

        if(key!=""){
            searchDataPengeluaran(key);
        }else{
            tableDataPengeluaran();
        }
    }//GEN-LAST:event_fieldCariDataPengeluaranKeyReleased

    private void tableDataPengeluaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataPengeluaranMouseClicked
        fieldIDDataPengeluaran.setText(tableDataPengeluaran.getValueAt(tableDataPengeluaran.getSelectedRow(),0)+"");
        fieldNamaDataPengeluaran.setText(tableDataPengeluaran.getValueAt(tableDataPengeluaran.getSelectedRow(),1)+"");
        fieldTanggalDataPengeluaran.setText(tableDataPengeluaran.getValueAt(tableDataPengeluaran.getSelectedRow(),2)+"");
        fieldNominalDataPengeluaran.setText(tableDataPengeluaran.getValueAt(tableDataPengeluaran.getSelectedRow(),3)+"");
        fieldPenggunaDataPengeluaran.setText(tableDataPengeluaran.getValueAt(tableDataPengeluaran.getSelectedRow(),4)+"");

        buttonEditDataPengeluaran.setEnabled(true);
        buttonHapusDataPengeluaran.setEnabled(true);
    }//GEN-LAST:event_tableDataPengeluaranMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button buttonEditDataPengeluaran;
    private component.swing.button buttonHapusDataPengeluaran;
    private component.swing.button buttonResetDataPengeluaran;
    private component.swing.button buttonSimpanDataPengeluaran;
    private component.swing.textFieldMain fieldCariDataPengeluaran;
    private component.swing.textFieldMain fieldIDDataPengeluaran;
    private component.swing.textFieldMain fieldNamaDataPengeluaran;
    private component.swing.textFieldMain fieldNominalDataPengeluaran;
    private component.swing.textFieldMain fieldPenggunaDataPengeluaran;
    private component.swing.textFieldMain fieldTanggalDataPengeluaran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private component.swing.panelRound panelRound1;
    private javax.swing.JScrollPane scrollPaneDataPengeluaran;
    private component.model.tableCustom.table tableDataPengeluaran;
    // End of variables declaration//GEN-END:variables
}
