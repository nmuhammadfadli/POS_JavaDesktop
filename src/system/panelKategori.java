package system;

import com.mysql.jdbc.Statement;
import component.model.table.tableCustom;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class panelKategori extends javax.swing.JPanel {

    
    public panelKategori() {
        initComponents();
        setOpaque(false);
        DataTableKategori();
        AutonumberKategori();
        tableCustom.apply(ScrollPaneKategori, tableCustom.TableType.MULTI_LINE);    
    }
    
    public void DataTableKategori(){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("No");
        isi.addColumn("Kategori");
        
        tableKategori.setModel(isi);
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM kategori");
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
        
        buttonKategoriHapus.setEnabled(false);
        buttonKategoriEdit.setEnabled(false);
    }
    
    private void SearchKategori(String key){
         DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("No");
        isi.addColumn("Kategori");
        
        tableKategori.setModel(isi);
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM kategori WHERE id_kategori LIKE '%"+key+"%' OR nama_kategori LIKE '%"+key+"%'");
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
    
    private void AutonumberKategori(){
        try {
        Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM kategori order by id_kategori desc");
            if(result.next()){
                String id_kategori = result.getString("id_kategori").substring(4);
                String AN = ""+(Integer.parseInt(id_kategori)+1);
                String Nol = "";
                
                if(AN.length()==1)
                    {Nol="00";}
                else if (AN.length()==2)
                    {Nol="0";}
                else if (AN.length()==3)
                    {Nol="";}
                
                kaid.setText("KTgI" + Nol + AN);
                
            } else {
                kaid.setText("KTgI001");
            }
            statement.close();
            result.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    private void SimpanKategori(){
        String ID = kaid.getText();
        String Nama = kanama.getText();

        
        if(ID.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"ID tidak boleh kosong"); 
            kaid.requestFocus(); 
        }else if(Nama.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong"); 
            kanama.requestFocus(); 
        } else{
        try{
            Statement statement = (Statement) service.connect.GetConnection().createStatement();
            statement.executeUpdate("insert into kategori VALUES ('" + ID + "','" + Nama +"');");
            statement.close ();
        }catch (Exception t){
            JOptionPane.showMessageDialog(null, "data gagal disimpan");
            }
        DataTableKategori();
        ResetKategori();
        AutonumberKategori();
        }
    }
    
    private void EditKategori(){
        String ID = kaid.getText();
        String Nama = kanama.getText();

        
        if(ID.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"ID tidak boleh kosong"); 
            kaid.requestFocus(); 
        }else if(Nama.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Kategori tidak boleh kosong"); 
            kanama.requestFocus(); 
        } else{
        try{
            Statement statement = (Statement) service.connect.GetConnection().createStatement();
            statement.executeUpdate("UPDATE kategori SET id_kategori='"+ ID +"', nama_kategori='"+ Nama +"' WHERE id_kategori='"+ID+"';");
            statement.close ();
        }catch (Exception t){
            JOptionPane.showMessageDialog(null, "data gagal disimpan");
            }
        DataTableKategori();
        ResetKategori();
        AutonumberKategori();
        }
    }
    
    private void HapusKategori(){
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            statement.executeUpdate("DELETE FROM kategori WHERE id_kategori = ('"+ kaid.getText() +"');");
            kaid.requestFocus();
            kaid.getText();
            kanama.getText();

        }
        catch(Exception t){
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }
        
        DataTableKategori();
        ResetKategori();
        AutonumberKategori();
    }
    
    private void ResetKategori(){
        kanama.setText("");

        DataTableKategori();
        AutonumberKategori();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kaid = new component.swing.textFieldMain();
        buttonKategoriHapus = new component.swing.button();
        buttonKategoriEdit = new component.swing.button();
        buttonKategoriSimpan = new component.swing.button();
        textFieldKategoriCari = new component.swing.textField();
        kanama = new component.swing.textFieldMain();
        panel1 = new component.swing.panelRound();
        jLabel3 = new javax.swing.JLabel();
        ScrollPaneKategori = new javax.swing.JScrollPane();
        tableKategori = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(725, 591));
        setPreferredSize(new java.awt.Dimension(725, 591));

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(701, 276));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("No Kategori");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 80, 50));

        jLabel2.setText("Kategori");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 60, 50));

        kaid.setEditable(false);
        kaid.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(kaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 220, 50));

        buttonKategoriHapus.setBackground(new java.awt.Color(255, 0, 0));
        buttonKategoriHapus.setForeground(new java.awt.Color(255, 255, 255));
        buttonKategoriHapus.setText("Hapus");
        buttonKategoriHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKategoriHapusActionPerformed(evt);
            }
        });
        jPanel1.add(buttonKategoriHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 100, -1));

        buttonKategoriEdit.setBackground(new java.awt.Color(0, 0, 255));
        buttonKategoriEdit.setForeground(new java.awt.Color(255, 255, 255));
        buttonKategoriEdit.setText("Edit");
        buttonKategoriEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKategoriEditActionPerformed(evt);
            }
        });
        jPanel1.add(buttonKategoriEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 100, -1));

        buttonKategoriSimpan.setBackground(new java.awt.Color(0, 255, 0));
        buttonKategoriSimpan.setForeground(new java.awt.Color(255, 255, 255));
        buttonKategoriSimpan.setText("Simpan");
        buttonKategoriSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKategoriSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(buttonKategoriSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 100, -1));

        textFieldKategoriCari.setLabelText("Cari");
        textFieldKategoriCari.setOpaque(false);
        textFieldKategoriCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldKategoriCariKeyReleased(evt);
            }
        });
        jPanel1.add(textFieldKategoriCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 400, -1));

        kanama.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(kanama, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 300, 50));

        panel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 45)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Kategori");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel1.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 110));

        tableKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKategoriMouseClicked(evt);
            }
        });
        ScrollPaneKategori.setViewportView(tableKategori);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(ScrollPaneKategori)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPaneKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonKategoriSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKategoriSimpanActionPerformed
        SimpanKategori();
    }//GEN-LAST:event_buttonKategoriSimpanActionPerformed

    private void buttonKategoriEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKategoriEditActionPerformed
        EditKategori();
    }//GEN-LAST:event_buttonKategoriEditActionPerformed

    private void buttonKategoriHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKategoriHapusActionPerformed
        HapusKategori();
    }//GEN-LAST:event_buttonKategoriHapusActionPerformed

    private void textFieldKategoriCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldKategoriCariKeyReleased
        String key =textFieldKategoriCari.getText();
        System.out.println(key);
        
        if(key!=""){
            SearchKategori(key);
        }else{
            DataTableKategori();
        }
    }//GEN-LAST:event_textFieldKategoriCariKeyReleased

    private void tableKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKategoriMouseClicked
        kaid.setText(tableKategori.getValueAt(tableKategori.getSelectedRow(),0)+"");
        kanama.setText(tableKategori.getValueAt(tableKategori.getSelectedRow(),1)+"");
        
        buttonKategoriHapus.setEnabled(true);
        buttonKategoriEdit.setEnabled(true);
    }//GEN-LAST:event_tableKategoriMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPaneKategori;
    private component.swing.button buttonKategoriEdit;
    private component.swing.button buttonKategoriHapus;
    private component.swing.button buttonKategoriSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private component.swing.textFieldMain kaid;
    private component.swing.textFieldMain kanama;
    private component.swing.panelRound panel1;
    private javax.swing.JTable tableKategori;
    private component.swing.textField textFieldKategoriCari;
    // End of variables declaration//GEN-END:variables
}
