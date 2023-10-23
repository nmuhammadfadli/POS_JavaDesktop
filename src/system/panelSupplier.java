package system;

import com.mysql.jdbc.Statement;
import component.model.table.tableCustom;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class panelSupplier extends javax.swing.JPanel {

    
    public panelSupplier() {
        initComponents();
        DataTableSupplier();
        AutonumberSupplier();
        tableCustom.apply(ScrollPaneSupplier, tableCustom.TableType.MULTI_LINE);
        setOpaque(false);
    }

    public void DataTableSupplier(){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("ID Supplier");
        isi.addColumn("Nama");
        isi.addColumn("No Telp");
        isi.addColumn("Alamat");
        
        tableSupplier.setModel(isi);
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM supplier");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("kode_supplier"),
                    result.getString("nama_supplier"),
                    result.getString("telp_supplier"),
                    result.getString("alamat_supplier")

                });
                tableSupplier.setModel(isi);
            }        
        }
        catch(Exception e){
            System.out.print("Gagal terhubung");
            JOptionPane.showMessageDialog(null,"Koneksi databases error");
        }
        buttonSupplierHapus.setEnabled(false);
        buttonSupplierEdit.setEnabled(false);
    }    
    
    private void SearchSupplier(String key){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("ID Supplier");
        isi.addColumn("Nama");
        isi.addColumn("No Telp");
        isi.addColumn("Alamat");
        
            
        tableSupplier.setModel(isi);
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM supplier WHERE kode_supplier LIKE '%"+key+"%' OR nama_supplier LIKE '%"+key+"%' OR telp_supplier LIKE '%"+key+"%' OR alamat_supplier LIKE '%"+key+"%'");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("kode_supplier"),
                    result.getString("nama_supplier"),
                    result.getString("telp_supplier"),
                    result.getString("alamat_supplier"),
                });
            tableSupplier.setModel(isi);
            }
        }
        catch(Exception e){
            System.out.print("Gagal menampilkan... ");
            JOptionPane.showMessageDialog(null,"Tidak bisa mencari data");
        }
    }
    
    private void AutonumberSupplier(){
        try {
        Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM supplier order by kode_supplier desc");
            if(result.next()){
                String kode_supplier = result.getString("kode_supplier").substring(5);
                String AN = ""+(Integer.parseInt(kode_supplier)+1);
                String Nol = "";
                
                if(AN.length()==1)
                    {Nol="00";}
                else if (AN.length()==2)
                    {Nol="0";}
                else if (AN.length()==3)
                    {Nol="";}
                
                suid.setText("SuPlL" + Nol + AN);
                
            } else {
                suid.setText("SuPlL001");
            }
            statement.close();
            result.close();
        }catch (Exception t){
            JOptionPane.showMessageDialog(null, t);
        }
        
    }
    
    private void HapusSupplier(){
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            statement.executeUpdate("DELETE FROM supplier WHERE kode_supplier = ('"+ suid.getText() +"');");
            suid.requestFocus();
            suid.getText();
            sunama.getText();
            sunotelp.getText();
            sualamat.getText();
            
            ResetSupplier();
            JOptionPane.showMessageDialog(null,"Data berhasil di hapus");
        }
        catch(Exception t){
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }
        DataTableSupplier();
        AutonumberSupplier();
    }
    
    private void SimpanSupplier(){
        String ID = suid.getText();
        String Nama = sunama.getText();
        String No_Telp = sunotelp.getText();
        String Alamat = sualamat.getText();
        
        if(ID.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"ID tidak boleh kosong"); 
            suid.requestFocus(); 
        }else if(Nama.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong"); 
            sunama.requestFocus(); 
        }else if (No_Telp.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"No Telp tidak boleh kosong"); 
            sunotelp.requestFocus(); 
        }else if (Alamat.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Alamat tidak boleh kosong"); 
            sualamat.requestFocus(); 
        }else{
        try{
            Statement statement = (Statement) service.connect.GetConnection().createStatement();
            statement.executeUpdate("insert into supplier VALUES ('" + ID + "','" + Nama +"','" + No_Telp +"','"+ Alamat +"');");
            statement.close ();
            ResetSupplier();
            JOptionPane.showMessageDialog(null,"Data berhasil di simpan");
        }catch (Exception t){
            JOptionPane.showMessageDialog(null, "data gagal disimpan");
            }
        DataTableSupplier();
        AutonumberSupplier();
        }
    }
    
    private void EditSupplier(){
        String ID = suid.getText();
        String Nama = sunama.getText();
        String No_Telp = sunotelp.getText();
        String Alamat = sualamat.getText();
        
        if(ID.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"ID tidak boleh kosong"); 
            suid.requestFocus(); 
        }else if(Nama.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong"); 
            sunama.requestFocus(); 
        }else if (No_Telp.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"No Telp tidak boleh kosong"); 
            sunotelp.requestFocus(); 
        }else if (Alamat.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Alamat tidak boleh kosong"); 
            sualamat.requestFocus(); 
        }else{ 
            try{
                Statement statement = (Statement)service.connect.GetConnection().createStatement();
                statement.executeUpdate("UPDATE supplier SET kode_supplier='"+ ID +"', nama_supplier='"+ Nama +"', telp_supplier='"+ No_Telp +"', alamat_supplier='"+ Alamat +"' WHERE kode_supplier='"+ID+"';");
                statement.close();
                ResetSupplier();
                JOptionPane.showMessageDialog(null,"Data berhasil di edit");
            }
            catch(Exception t){
                JOptionPane.showMessageDialog(null, "Data gagal di edit");
            }
            DataTableSupplier();
            AutonumberSupplier();
        }
    }
    
    public void ResetSupplier(){
        sunama.setText("");
        sualamat.setText("");
        sunotelp.setText("");
        
        DataTableSupplier();
        AutonumberSupplier();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        laid = new javax.swing.JLabel();
        suid = new component.swing.textFieldMain();
        lanama = new javax.swing.JLabel();
        sualamat = new component.swing.textFieldMain();
        lanotelp = new javax.swing.JLabel();
        laalamat = new javax.swing.JLabel();
        sucari = new component.swing.textField();
        buttonSupplierHapus = new component.swing.button();
        buttonSupplierEdit = new component.swing.button();
        buttonSupplierReset = new component.swing.button();
        buttonSupplierSimpan = new component.swing.button();
        sunama = new component.swing.textFieldMain();
        sunotelp = new component.swing.textFieldMain();
        panel1 = new component.swing.panelRound();
        jLabel1 = new javax.swing.JLabel();
        ScrollPaneSupplier = new javax.swing.JScrollPane();
        tableSupplier = new javax.swing.JTable();

        setBackground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(725, 591));

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(701, 310));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        laid.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        laid.setForeground(new java.awt.Color(255, 255, 255));
        laid.setText("No Supplier");
        jPanel1.add(laid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 90, 50));

        suid.setEditable(false);
        suid.setBackground(new java.awt.Color(153, 153, 153));
        suid.setForeground(new java.awt.Color(255, 255, 255));
        suid.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        suid.setShadowColor(new java.awt.Color(51, 51, 51));
        jPanel1.add(suid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 219, 50));

        lanama.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lanama.setForeground(new java.awt.Color(255, 255, 255));
        lanama.setText("Nama");
        jPanel1.add(lanama, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 90, 50));

        sualamat.setBackground(new java.awt.Color(204, 204, 204));
        sualamat.setForeground(new java.awt.Color(51, 51, 51));
        sualamat.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        sualamat.setSelectionColor(new java.awt.Color(102, 102, 102));
        sualamat.setShadowColor(new java.awt.Color(51, 51, 51));
        jPanel1.add(sualamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 220, 50));

        lanotelp.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lanotelp.setForeground(new java.awt.Color(255, 255, 255));
        lanotelp.setText("No.Telphone");
        jPanel1.add(lanotelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 100, 50));

        laalamat.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        laalamat.setForeground(new java.awt.Color(255, 255, 255));
        laalamat.setText("Alamat");
        jPanel1.add(laalamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 100, 50));

        sucari.setForeground(new java.awt.Color(255, 255, 255));
        sucari.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        sucari.setLabelText("Cari");
        sucari.setLineColor(new java.awt.Color(204, 204, 204));
        sucari.setOpaque(false);
        sucari.setSelectionColor(new java.awt.Color(102, 102, 102));
        sucari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sucariKeyReleased(evt);
            }
        });
        jPanel1.add(sucari, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 300, -1));

        buttonSupplierHapus.setBackground(new java.awt.Color(255, 0, 0));
        buttonSupplierHapus.setForeground(new java.awt.Color(255, 255, 255));
        buttonSupplierHapus.setText("Hapus");
        buttonSupplierHapus.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonSupplierHapus.setShadowColor(new java.awt.Color(51, 51, 51));
        buttonSupplierHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSupplierHapusActionPerformed(evt);
            }
        });
        jPanel1.add(buttonSupplierHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 100, -1));

        buttonSupplierEdit.setBackground(new java.awt.Color(0, 0, 255));
        buttonSupplierEdit.setForeground(new java.awt.Color(255, 255, 255));
        buttonSupplierEdit.setText("Edit");
        buttonSupplierEdit.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonSupplierEdit.setShadowColor(new java.awt.Color(51, 51, 51));
        buttonSupplierEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSupplierEditActionPerformed(evt);
            }
        });
        jPanel1.add(buttonSupplierEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 100, -1));

        buttonSupplierReset.setBackground(new java.awt.Color(102, 102, 102));
        buttonSupplierReset.setForeground(new java.awt.Color(255, 255, 255));
        buttonSupplierReset.setText("Reset");
        buttonSupplierReset.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonSupplierReset.setShadowColor(new java.awt.Color(51, 51, 51));
        buttonSupplierReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSupplierResetActionPerformed(evt);
            }
        });
        jPanel1.add(buttonSupplierReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 100, -1));

        buttonSupplierSimpan.setBackground(new java.awt.Color(0, 255, 0));
        buttonSupplierSimpan.setForeground(new java.awt.Color(255, 255, 255));
        buttonSupplierSimpan.setText("Simpan");
        buttonSupplierSimpan.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonSupplierSimpan.setShadowColor(new java.awt.Color(51, 51, 51));
        buttonSupplierSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSupplierSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(buttonSupplierSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 100, -1));

        sunama.setBackground(new java.awt.Color(204, 204, 204));
        sunama.setForeground(new java.awt.Color(51, 51, 51));
        sunama.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        sunama.setSelectionColor(new java.awt.Color(102, 102, 102));
        sunama.setShadowColor(new java.awt.Color(51, 51, 51));
        jPanel1.add(sunama, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 219, 50));

        sunotelp.setBackground(new java.awt.Color(204, 204, 204));
        sunotelp.setForeground(new java.awt.Color(51, 51, 51));
        sunotelp.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        sunotelp.setSelectionColor(new java.awt.Color(102, 102, 102));
        sunotelp.setShadowColor(new java.awt.Color(51, 51, 51));
        jPanel1.add(sunotelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 220, 50));

        panel1.setBackground(new java.awt.Color(153, 153, 153));
        panel1.setShadowColor(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 45)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Supplier");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel1.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        ScrollPaneSupplier.setAutoscrolls(true);
        ScrollPaneSupplier.setFocusCycleRoot(true);

        tableSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSupplierMouseClicked(evt);
            }
        });
        ScrollPaneSupplier.setViewportView(tableSupplier);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneSupplier)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPaneSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSupplierSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupplierSimpanActionPerformed
        SimpanSupplier();
    }//GEN-LAST:event_buttonSupplierSimpanActionPerformed

    private void buttonSupplierResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupplierResetActionPerformed
        ResetSupplier();
    }//GEN-LAST:event_buttonSupplierResetActionPerformed

    private void buttonSupplierEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupplierEditActionPerformed
        EditSupplier();
    }//GEN-LAST:event_buttonSupplierEditActionPerformed

    private void buttonSupplierHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupplierHapusActionPerformed
        HapusSupplier();
    }//GEN-LAST:event_buttonSupplierHapusActionPerformed

    private void sucariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sucariKeyReleased
        String key =sucari.getText();
        System.out.println(key);
        
        if(key!=""){
            SearchSupplier(key);
        }else{
            DataTableSupplier();
        }
    }//GEN-LAST:event_sucariKeyReleased

    private void tableSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSupplierMouseClicked
        suid.setText(tableSupplier.getValueAt(tableSupplier.getSelectedRow(),0)+"");
        sunama.setText(tableSupplier.getValueAt(tableSupplier.getSelectedRow(),1)+"");
        sunotelp.setText(tableSupplier.getValueAt(tableSupplier.getSelectedRow(),2)+"");
        sualamat.setText(tableSupplier.getValueAt(tableSupplier.getSelectedRow(),3)+"");
        
        buttonSupplierHapus.setEnabled(true);
        buttonSupplierEdit.setEnabled(true);
    }//GEN-LAST:event_tableSupplierMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPaneSupplier;
    private component.swing.button buttonSupplierEdit;
    private component.swing.button buttonSupplierHapus;
    private component.swing.button buttonSupplierReset;
    private component.swing.button buttonSupplierSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel laalamat;
    private javax.swing.JLabel laid;
    private javax.swing.JLabel lanama;
    private javax.swing.JLabel lanotelp;
    private component.swing.panelRound panel1;
    private component.swing.textFieldMain sualamat;
    private component.swing.textField sucari;
    private component.swing.textFieldMain suid;
    private component.swing.textFieldMain sunama;
    private component.swing.textFieldMain sunotelp;
    private javax.swing.JTable tableSupplier;
    // End of variables declaration//GEN-END:variables
}
