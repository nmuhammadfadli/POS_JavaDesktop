package report;

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
        
        tableCustom.apply(scrollPaneDataPengeluaran, tableCustom.TableType.MULTI_LINE);
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

        panelGradient6 = new component.swing.panelGradient();
        panelRound16 = new component.swing.panelRound();
        fieldNominalDataPengeluaran = new component.swing.textField();
        panelRound17 = new component.swing.panelRound();
        fieldIDDataPengeluaran = new component.swing.textField();
        panelRound19 = new component.swing.panelRound();
        fieldNamaDataPengeluaran = new component.swing.textField();
        panelRound20 = new component.swing.panelRound();
        fieldTanggalDataPengeluaran = new component.swing.textField();
        panelRound21 = new component.swing.panelRound();
        fieldPenggunaDataPengeluaran = new component.swing.textField();
        panelGradient5 = new component.swing.panelGradient();
        scrollPaneDataPengeluaran = new javax.swing.JScrollPane();
        tableDataPengeluaran = new javax.swing.JTable();
        buttonEditDataPengeluaran = new component.swing.button();
        buttonHapusDataPengeluaran = new component.swing.button();
        panelRound15 = new component.swing.panelRound();
        fieldCariDataPengeluaran = new component.swing.textField();
        buttonResetDataPengeluaran = new component.swing.button();
        buttonSimpanDataPengeluaran = new component.swing.button();

        panelGradient6.setBackground(new java.awt.Color(238, 238, 238));
        panelGradient6.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelGradient6.setColorGradient(new java.awt.Color(242, 242, 242));
        panelGradient6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldNominalDataPengeluaran.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldNominalDataPengeluaran.setLabelText("Nominal");
        panelRound16.add(fieldNominalDataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 50));

        panelGradient6.add(panelRound16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 200, 70));

        fieldIDDataPengeluaran.setEditable(false);
        fieldIDDataPengeluaran.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldIDDataPengeluaran.setLabelText("ID Pengeluaran");

        javax.swing.GroupLayout panelRound17Layout = new javax.swing.GroupLayout(panelRound17);
        panelRound17.setLayout(panelRound17Layout);
        panelRound17Layout.setHorizontalGroup(
            panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldIDDataPengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        panelRound17Layout.setVerticalGroup(
            panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldIDDataPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panelGradient6.add(panelRound17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 70));

        fieldNamaDataPengeluaran.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldNamaDataPengeluaran.setLabelText("Nama Pengeluaran");

        javax.swing.GroupLayout panelRound19Layout = new javax.swing.GroupLayout(panelRound19);
        panelRound19.setLayout(panelRound19Layout);
        panelRound19Layout.setHorizontalGroup(
            panelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldNamaDataPengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        panelRound19Layout.setVerticalGroup(
            panelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound19Layout.createSequentialGroup()
                .addComponent(fieldNamaDataPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelGradient6.add(panelRound19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, 70));

        panelRound20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldTanggalDataPengeluaran.setEditable(false);
        fieldTanggalDataPengeluaran.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldTanggalDataPengeluaran.setLabelText("Tanggal");
        panelRound20.add(fieldTanggalDataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 180, -1));

        panelGradient6.add(panelRound20, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 200, 70));

        fieldPenggunaDataPengeluaran.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldPenggunaDataPengeluaran.setLabelText("Pengguna");

        javax.swing.GroupLayout panelRound21Layout = new javax.swing.GroupLayout(panelRound21);
        panelRound21.setLayout(panelRound21Layout);
        panelRound21Layout.setHorizontalGroup(
            panelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldPenggunaDataPengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        panelRound21Layout.setVerticalGroup(
            panelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(fieldPenggunaDataPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelGradient6.add(panelRound21, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 200, 70));

        panelGradient5.setBackground(new java.awt.Color(238, 238, 238));
        panelGradient5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelGradient5.setColorGradient(new java.awt.Color(242, 242, 242));
        panelGradient5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableDataPengeluaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableDataPengeluaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataPengeluaranMouseClicked(evt);
            }
        });
        scrollPaneDataPengeluaran.setViewportView(tableDataPengeluaran);

        panelGradient5.add(scrollPaneDataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 86, 630, 190));

        buttonEditDataPengeluaran.setBackground(new java.awt.Color(0, 0, 204));
        buttonEditDataPengeluaran.setForeground(new java.awt.Color(255, 255, 255));
        buttonEditDataPengeluaran.setText("Edit");
        buttonEditDataPengeluaran.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonEditDataPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditDataPengeluaranActionPerformed(evt);
            }
        });
        panelGradient5.add(buttonEditDataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 90, 50));

        buttonHapusDataPengeluaran.setBackground(new java.awt.Color(204, 0, 0));
        buttonHapusDataPengeluaran.setForeground(new java.awt.Color(255, 255, 255));
        buttonHapusDataPengeluaran.setText("Hapus");
        buttonHapusDataPengeluaran.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonHapusDataPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusDataPengeluaranActionPerformed(evt);
            }
        });
        panelGradient5.add(buttonHapusDataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 90, 50));

        panelRound15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldCariDataPengeluaran.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldCariDataPengeluaran.setLabelText("Cari");
        fieldCariDataPengeluaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariDataPengeluaranKeyReleased(evt);
            }
        });
        panelRound15.add(fieldCariDataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 11, 240, 50));

        panelGradient5.add(panelRound15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 70));

        buttonResetDataPengeluaran.setBackground(new java.awt.Color(102, 102, 102));
        buttonResetDataPengeluaran.setForeground(new java.awt.Color(255, 255, 255));
        buttonResetDataPengeluaran.setText("Reset");
        buttonResetDataPengeluaran.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonResetDataPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetDataPengeluaranActionPerformed(evt);
            }
        });
        panelGradient5.add(buttonResetDataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 90, 50));

        buttonSimpanDataPengeluaran.setBackground(new java.awt.Color(0, 204, 0));
        buttonSimpanDataPengeluaran.setForeground(new java.awt.Color(255, 255, 255));
        buttonSimpanDataPengeluaran.setText("Simpan");
        buttonSimpanDataPengeluaran.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonSimpanDataPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanDataPengeluaranActionPerformed(evt);
            }
        });
        panelGradient5.add(buttonSimpanDataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 90, 50));

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

    private void tableDataPengeluaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataPengeluaranMouseClicked
        fieldIDDataPengeluaran.setText(tableDataPengeluaran.getValueAt(tableDataPengeluaran.getSelectedRow(),0)+"");
        fieldNamaDataPengeluaran.setText(tableDataPengeluaran.getValueAt(tableDataPengeluaran.getSelectedRow(),1)+"");
        fieldTanggalDataPengeluaran.setText(tableDataPengeluaran.getValueAt(tableDataPengeluaran.getSelectedRow(),2)+"");
        fieldNominalDataPengeluaran.setText(tableDataPengeluaran.getValueAt(tableDataPengeluaran.getSelectedRow(),3)+"");
        fieldPenggunaDataPengeluaran.setText(tableDataPengeluaran.getValueAt(tableDataPengeluaran.getSelectedRow(),4)+"");

        buttonEditDataPengeluaran.setEnabled(true);
        buttonHapusDataPengeluaran.setEnabled(true);
    }//GEN-LAST:event_tableDataPengeluaranMouseClicked

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

    private void buttonResetDataPengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetDataPengeluaranActionPerformed
        resetDataPengeluaran();
    }//GEN-LAST:event_buttonResetDataPengeluaranActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button buttonEditDataPengeluaran;
    private component.swing.button buttonHapusDataPengeluaran;
    private component.swing.button buttonResetDataPengeluaran;
    private component.swing.button buttonSimpanDataPengeluaran;
    private component.swing.textField fieldCariDataPengeluaran;
    private component.swing.textField fieldIDDataPengeluaran;
    private component.swing.textField fieldNamaDataPengeluaran;
    private component.swing.textField fieldNominalDataPengeluaran;
    private component.swing.textField fieldPenggunaDataPengeluaran;
    public static component.swing.textField fieldTanggalDataPengeluaran;
    private component.swing.panelGradient panelGradient5;
    private component.swing.panelGradient panelGradient6;
    private component.swing.panelRound panelRound15;
    private component.swing.panelRound panelRound16;
    private component.swing.panelRound panelRound17;
    private component.swing.panelRound panelRound19;
    private component.swing.panelRound panelRound20;
    private component.swing.panelRound panelRound21;
    private javax.swing.JScrollPane scrollPaneDataPengeluaran;
    private javax.swing.JTable tableDataPengeluaran;
    // End of variables declaration//GEN-END:variables
}
