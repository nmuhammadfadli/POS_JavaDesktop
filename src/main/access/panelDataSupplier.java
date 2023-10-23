package main.access;

import com.mysql.jdbc.Statement;
import component.model.table.tableCustom;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class panelDataSupplier extends javax.swing.JPanel {

    public panelDataSupplier() {
        initComponents();
        setOpaque(false);
        
        tableDataSupplier();
        autoNumberDataSupplier();
        
        tableDataSupplier.fixTable(scrollPaneDataSupplier);
    }

    public void tableDataSupplier(){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("ID Supplier");
        isi.addColumn("Nama");
        isi.addColumn("Alamat");
        isi.addColumn("No Telphone");
         
        tableDataSupplier.setModel(isi);
        
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_supplier;");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("id_supplier"),
                    result.getString("nama_supplier"),
                    result.getString("alamat_supplier"),
                    result.getString("no_telphone_supplier")
                });
                tableDataSupplier.setModel(isi);
            }        
        }
        catch(Exception e){
            System.err.print(e);
            JOptionPane.showMessageDialog(null,"Koneksi databases error");
        }
        
        buttonHapusDataSupplier.setEnabled(false);
        buttonEditDataSupplier.setEnabled(false);
    }    
    
    private void searchDataSupplier(String key){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("ID Supplier");
        isi.addColumn("Nama");
        isi.addColumn("Alamat");
        isi.addColumn("No Telphone");
  
        tableDataSupplier.setModel(isi);
        
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_supplier WHERE id_supplier LIKE '%"+key+"%' OR nama_supplier LIKE '%"+key+"%' OR no_telphone_supplier LIKE '%"+key+"%' OR alamat_supplier LIKE '%"+key+"%';");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("id_supplier"),
                    result.getString("nama_supplier"),
                    result.getString("alamat_supplier"),
                    result.getString("no_telphone_supplier") 
                });
            tableDataSupplier.setModel(isi);
            }
        }
        
        catch(Exception e){
            System.err.print(e);
            JOptionPane.showMessageDialog(null,"Tidak bisa mencari data");
        }
    }
    
    private void resetDataSupplier(){
        fieldIDSupplier.setText("");
        fieldNamaSupplier.setText("");
        fieldAlamatSupplier.setText(""); 
        fieldNoTelphoneSupplier.setText("");

        tableDataSupplier();
        autoNumberDataSupplier();
    }
    
    private void autoNumberDataSupplier(){
        try {
        Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_supplier ORDER BY id_supplier DESC;");
            if(result.next()){
                String ID = result.getString("id_supplier").substring(4);
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
                
                fieldIDSupplier.setText("SPiR" + Nol + AND);
                
            } else {
                fieldIDSupplier.setText("SPiR0001");
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
        fieldIDSupplier = new component.swing.textFieldMain();
        fieldNamaSupplier = new component.swing.textFieldMain();
        buttonSimpanDataSupplier = new component.swing.button();
        buttonResetDataSupplier = new component.swing.button();
        buttonEditDataSupplier = new component.swing.button();
        buttonHapusDataSupplier = new component.swing.button();
        panelRound1 = new component.swing.panelRound();
        scrollPaneDataSupplier = new javax.swing.JScrollPane();
        tableDataSupplier = new component.model.tableCustom.table();
        jLabel2 = new javax.swing.JLabel();
        fieldCariDataSupplier = new component.swing.textFieldMain();
        jLabel3 = new javax.swing.JLabel();
        fieldAlamatSupplier = new component.swing.textFieldMain();
        fieldNoTelphoneSupplier = new component.swing.textFieldMain();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel1.setText("ID Supplier");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        fieldIDSupplier.setEditable(false);
        fieldIDSupplier.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldIDSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 400, 60));

        fieldNamaSupplier.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldNamaSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 400, 60));

        buttonSimpanDataSupplier.setBackground(new java.awt.Color(0, 204, 0));
        buttonSimpanDataSupplier.setForeground(new java.awt.Color(255, 255, 255));
        buttonSimpanDataSupplier.setText("Simpan");
        buttonSimpanDataSupplier.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonSimpanDataSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanDataSupplierActionPerformed(evt);
            }
        });
        add(buttonSimpanDataSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 100, 50));

        buttonResetDataSupplier.setBackground(new java.awt.Color(102, 102, 102));
        buttonResetDataSupplier.setForeground(new java.awt.Color(255, 255, 255));
        buttonResetDataSupplier.setText("Reset");
        buttonResetDataSupplier.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonResetDataSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetDataSupplierActionPerformed(evt);
            }
        });
        add(buttonResetDataSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 100, 50));

        buttonEditDataSupplier.setBackground(new java.awt.Color(0, 0, 204));
        buttonEditDataSupplier.setForeground(new java.awt.Color(255, 255, 255));
        buttonEditDataSupplier.setText("Edit");
        buttonEditDataSupplier.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonEditDataSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditDataSupplierActionPerformed(evt);
            }
        });
        add(buttonEditDataSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 100, 50));

        buttonHapusDataSupplier.setBackground(new java.awt.Color(204, 0, 0));
        buttonHapusDataSupplier.setForeground(new java.awt.Color(255, 255, 255));
        buttonHapusDataSupplier.setText("Hapus");
        buttonHapusDataSupplier.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonHapusDataSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusDataSupplierActionPerformed(evt);
            }
        });
        add(buttonHapusDataSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, 100, 50));

        panelRound1.setLayout(new java.awt.BorderLayout());

        scrollPaneDataSupplier.setBorder(null);

        tableDataSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableDataSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataSupplierMouseClicked(evt);
            }
        });
        scrollPaneDataSupplier.setViewportView(tableDataSupplier);

        panelRound1.add(scrollPaneDataSupplier, java.awt.BorderLayout.CENTER);

        add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 840, 250));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel2.setText("Nama Supplier");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        fieldCariDataSupplier.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldCariDataSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariDataSupplierKeyReleased(evt);
            }
        });
        add(fieldCariDataSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 400, 60));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel3.setText("Cari");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        fieldAlamatSupplier.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldAlamatSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 430, 60));

        fieldNoTelphoneSupplier.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldNoTelphoneSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 120, 430, 60));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel6.setText("Alamat");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel7.setText("No Telphone");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSimpanDataSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanDataSupplierActionPerformed
        String ID = fieldIDSupplier.getText();
        String Nama = fieldNamaSupplier.getText();
        String Alamat = fieldAlamatSupplier.getText();
        String NoTelphone = fieldNoTelphoneSupplier.getText();

        if(ID.isEmpty()){
            JOptionPane.showMessageDialog(null," tidak boleh kosong");
            fieldIDSupplier.requestFocus();
        }else if(Nama.isEmpty()){
            JOptionPane.showMessageDialog(null," tidak boleh kosong");
            fieldNamaSupplier.requestFocus();
        }else if(Alamat.isEmpty()){
            JOptionPane.showMessageDialog(null," tidak boleh kosong");
            fieldAlamatSupplier.requestFocus();
        }else if(NoTelphone.isEmpty()){
            JOptionPane.showMessageDialog(null," tidak boleh kosong");
            fieldNoTelphoneSupplier.requestFocus();
        } else{

            try{
                Statement statement = (Statement) service.connect.GetConnection().createStatement();
                statement.executeUpdate("INSERT INTO data_supplier VALUES ('" + ID + "', '"+ Nama +"', '"+ Alamat +"', '"+ NoTelphone +"');");
                statement.close ();
                resetDataSupplier();
            }catch (Exception t){
                JOptionPane.showMessageDialog(null, "data gagal disimpan");
            }
            
            tableDataSupplier();
            autoNumberDataSupplier();
        }
    }//GEN-LAST:event_buttonSimpanDataSupplierActionPerformed

    private void buttonResetDataSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetDataSupplierActionPerformed
        resetDataSupplier();
    }//GEN-LAST:event_buttonResetDataSupplierActionPerformed

    private void buttonEditDataSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditDataSupplierActionPerformed
        String ID = fieldIDSupplier.getText();
        String Nama = fieldNamaSupplier.getText();
        String Alamat = fieldAlamatSupplier.getText();
        String NoTelphone = fieldNoTelphoneSupplier.getText();

        if(ID.isEmpty()){
            JOptionPane.showMessageDialog(null," tidak boleh kosong");
            fieldIDSupplier.requestFocus();
        }else if(Nama.isEmpty()){
            JOptionPane.showMessageDialog(null," tidak boleh kosong");
            fieldNamaSupplier.requestFocus();
        }else if(Alamat.isEmpty()){
            JOptionPane.showMessageDialog(null," tidak boleh kosong");
            fieldAlamatSupplier.requestFocus();
        }else if(NoTelphone.isEmpty()){
            JOptionPane.showMessageDialog(null," tidak boleh kosong");
            fieldNoTelphoneSupplier.requestFocus();
        } else{

            try{
                Statement statement = (Statement) service.connect.GetConnection().createStatement();
                statement.executeUpdate("UPDATE data_supplier SET id_supplier='"+ ID +"', nama_supplier='"+ Nama +"', alamat_supplier='"+ Alamat +"', no_telphone_supplier='"+ NoTelphone +"' WHERE id_supplier='"+ ID +"';");
                statement.close ();
                resetDataSupplier();
            }catch (Exception t){
                JOptionPane.showMessageDialog(null, "data gagal disimpan");
            }

            tableDataSupplier();
            autoNumberDataSupplier();
        }
    }//GEN-LAST:event_buttonEditDataSupplierActionPerformed

    private void buttonHapusDataSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusDataSupplierActionPerformed
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            statement.executeUpdate("DELETE FROM data_supplier WHERE id_supplier = ('"+ fieldIDSupplier.getText() +"');");

            fieldIDSupplier.requestFocus();
            fieldIDSupplier.getText();
            fieldNamaSupplier.getText();
            fieldAlamatSupplier.getText();
            fieldNoTelphoneSupplier.getText();

        }
        catch(Exception t){
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }

        tableDataSupplier();
        resetDataSupplier();
        autoNumberDataSupplier();
    }//GEN-LAST:event_buttonHapusDataSupplierActionPerformed

    private void tableDataSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataSupplierMouseClicked
        fieldIDSupplier.setText(tableDataSupplier.getValueAt(tableDataSupplier.getSelectedRow(),0)+"");
        fieldNamaSupplier.setText(tableDataSupplier.getValueAt(tableDataSupplier.getSelectedRow(),1)+"");
        fieldAlamatSupplier.setText(tableDataSupplier.getValueAt(tableDataSupplier.getSelectedRow(),2)+"");
        fieldNoTelphoneSupplier.setText(tableDataSupplier.getValueAt(tableDataSupplier.getSelectedRow(),3)+"");

        buttonEditDataSupplier.setEnabled(true);
        buttonHapusDataSupplier.setEnabled(true);
    }//GEN-LAST:event_tableDataSupplierMouseClicked

    private void fieldCariDataSupplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariDataSupplierKeyReleased
        String key = fieldCariDataSupplier.getText();
        System.out.println(key);

        if(key!=""){
            searchDataSupplier(key);
        }else{
            tableDataSupplier();
        }
    }//GEN-LAST:event_fieldCariDataSupplierKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button buttonEditDataSupplier;
    private component.swing.button buttonHapusDataSupplier;
    private component.swing.button buttonResetDataSupplier;
    private component.swing.button buttonSimpanDataSupplier;
    private component.swing.textFieldMain fieldAlamatSupplier;
    private component.swing.textFieldMain fieldCariDataSupplier;
    private component.swing.textFieldMain fieldIDSupplier;
    private component.swing.textFieldMain fieldNamaSupplier;
    private component.swing.textFieldMain fieldNoTelphoneSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private component.swing.panelRound panelRound1;
    private javax.swing.JScrollPane scrollPaneDataSupplier;
    private component.model.tableCustom.table tableDataSupplier;
    // End of variables declaration//GEN-END:variables
}
