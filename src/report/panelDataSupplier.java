package report;

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
        
        tableCustom.apply(scrollPaneDataSupplier, tableCustom.TableType.MULTI_LINE);
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

        panelGradient6 = new component.swing.panelGradient();
        panelRound16 = new component.swing.panelRound();
        fieldNoTelphoneSupplier = new component.swing.textField();
        panelRound17 = new component.swing.panelRound();
        fieldIDSupplier = new component.swing.textField();
        panelRound19 = new component.swing.panelRound();
        fieldNamaSupplier = new component.swing.textField();
        panelRound20 = new component.swing.panelRound();
        fieldAlamatSupplier = new component.swing.textField();
        panelGradient5 = new component.swing.panelGradient();
        panelRound15 = new component.swing.panelRound();
        fieldCariDataSupplier = new component.swing.textField();
        buttonSimpanDataSupplier = new component.swing.button();
        buttonResetDataSupplier = new component.swing.button();
        buttonEditDataSupplier = new component.swing.button();
        buttonHapusDataSupplier = new component.swing.button();
        scrollPaneDataSupplier = new javax.swing.JScrollPane();
        tableDataSupplier = new javax.swing.JTable();

        panelGradient6.setBackground(new java.awt.Color(238, 238, 238));
        panelGradient6.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelGradient6.setColorGradient(new java.awt.Color(242, 242, 242));
        panelGradient6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldNoTelphoneSupplier.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldNoTelphoneSupplier.setLabelText("No Telphone");
        panelRound16.add(fieldNoTelphoneSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 50));

        panelGradient6.add(panelRound16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 360, 70));

        fieldIDSupplier.setEditable(false);
        fieldIDSupplier.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldIDSupplier.setLabelText("ID Supplier");

        javax.swing.GroupLayout panelRound17Layout = new javax.swing.GroupLayout(panelRound17);
        panelRound17.setLayout(panelRound17Layout);
        panelRound17Layout.setHorizontalGroup(
            panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldIDSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
        );
        panelRound17Layout.setVerticalGroup(
            panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldIDSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panelGradient6.add(panelRound17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 70));

        fieldNamaSupplier.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldNamaSupplier.setLabelText("Nama Supplier");

        javax.swing.GroupLayout panelRound19Layout = new javax.swing.GroupLayout(panelRound19);
        panelRound19.setLayout(panelRound19Layout);
        panelRound19Layout.setHorizontalGroup(
            panelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldNamaSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
        );
        panelRound19Layout.setVerticalGroup(
            panelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound19Layout.createSequentialGroup()
                .addComponent(fieldNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelGradient6.add(panelRound19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 260, 70));

        panelRound20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldAlamatSupplier.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldAlamatSupplier.setLabelText("Alamat");
        panelRound20.add(fieldAlamatSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 340, -1));

        panelGradient6.add(panelRound20, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 360, 70));

        panelGradient5.setBackground(new java.awt.Color(238, 238, 238));
        panelGradient5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelGradient5.setColorGradient(new java.awt.Color(242, 242, 242));
        panelGradient5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldCariDataSupplier.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldCariDataSupplier.setLabelText("Cari");
        fieldCariDataSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariDataSupplierKeyReleased(evt);
            }
        });
        panelRound15.add(fieldCariDataSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 11, 240, 50));

        panelGradient5.add(panelRound15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 70));

        buttonSimpanDataSupplier.setBackground(new java.awt.Color(0, 204, 0));
        buttonSimpanDataSupplier.setForeground(new java.awt.Color(255, 255, 255));
        buttonSimpanDataSupplier.setText("Simpan");
        buttonSimpanDataSupplier.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonSimpanDataSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanDataSupplierActionPerformed(evt);
            }
        });
        panelGradient5.add(buttonSimpanDataSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 90, 50));

        buttonResetDataSupplier.setBackground(new java.awt.Color(102, 102, 102));
        buttonResetDataSupplier.setForeground(new java.awt.Color(255, 255, 255));
        buttonResetDataSupplier.setText("Reset");
        buttonResetDataSupplier.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonResetDataSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetDataSupplierActionPerformed(evt);
            }
        });
        panelGradient5.add(buttonResetDataSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 90, 50));

        buttonEditDataSupplier.setBackground(new java.awt.Color(0, 0, 204));
        buttonEditDataSupplier.setForeground(new java.awt.Color(255, 255, 255));
        buttonEditDataSupplier.setText("Edit");
        buttonEditDataSupplier.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonEditDataSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditDataSupplierActionPerformed(evt);
            }
        });
        panelGradient5.add(buttonEditDataSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 90, 50));

        buttonHapusDataSupplier.setBackground(new java.awt.Color(204, 0, 0));
        buttonHapusDataSupplier.setForeground(new java.awt.Color(255, 255, 255));
        buttonHapusDataSupplier.setText("Hapus");
        buttonHapusDataSupplier.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonHapusDataSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusDataSupplierActionPerformed(evt);
            }
        });
        panelGradient5.add(buttonHapusDataSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 90, 50));

        tableDataSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableDataSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataSupplierMouseClicked(evt);
            }
        });
        scrollPaneDataSupplier.setViewportView(tableDataSupplier);

        panelGradient5.add(scrollPaneDataSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 630, 200));

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

    private void fieldCariDataSupplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariDataSupplierKeyReleased
        String key = fieldCariDataSupplier.getText();
        System.out.println(key);

        if(key!=""){
            searchDataSupplier(key);
        }else{
            tableDataSupplier();
        }
    }//GEN-LAST:event_fieldCariDataSupplierKeyReleased

    private void buttonResetDataSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetDataSupplierActionPerformed
        resetDataSupplier();
    }//GEN-LAST:event_buttonResetDataSupplierActionPerformed

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

    private void tableDataSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataSupplierMouseClicked
        fieldIDSupplier.setText(tableDataSupplier.getValueAt(tableDataSupplier.getSelectedRow(),0)+"");
        fieldNamaSupplier.setText(tableDataSupplier.getValueAt(tableDataSupplier.getSelectedRow(),1)+"");
        fieldAlamatSupplier.setText(tableDataSupplier.getValueAt(tableDataSupplier.getSelectedRow(),2)+"");
        fieldNoTelphoneSupplier.setText(tableDataSupplier.getValueAt(tableDataSupplier.getSelectedRow(),3)+"");

        buttonEditDataSupplier.setEnabled(true);
        buttonHapusDataSupplier.setEnabled(true);
    }//GEN-LAST:event_tableDataSupplierMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button buttonEditDataSupplier;
    private component.swing.button buttonHapusDataSupplier;
    private component.swing.button buttonResetDataSupplier;
    private component.swing.button buttonSimpanDataSupplier;
    private component.swing.textField fieldAlamatSupplier;
    private component.swing.textField fieldCariDataSupplier;
    private component.swing.textField fieldIDSupplier;
    private component.swing.textField fieldNamaSupplier;
    private component.swing.textField fieldNoTelphoneSupplier;
    private component.swing.panelGradient panelGradient5;
    private component.swing.panelGradient panelGradient6;
    private component.swing.panelRound panelRound15;
    private component.swing.panelRound panelRound16;
    private component.swing.panelRound panelRound17;
    private component.swing.panelRound panelRound19;
    private component.swing.panelRound panelRound20;
    private javax.swing.JScrollPane scrollPaneDataSupplier;
    private javax.swing.JTable tableDataSupplier;
    // End of variables declaration//GEN-END:variables
}
