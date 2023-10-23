package system;

import com.mysql.jdbc.Statement;
import component.model.table.tableCustom;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class panelManagementAkun extends javax.swing.JPanel {

    public panelManagementAkun() {
        initComponents();
        setOpaque(false);
        DataTableManagementAkun();
        tableCustom.apply(scrollManagementAkun, tableCustom.TableType.MULTI_LINE);
    }
    
    public void DataTableManagementAkun(){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("ID User");
        isi.addColumn("Username");
        isi.addColumn("Nama");
        isi.addColumn("Email");
        isi.addColumn("Tipe Akun");
        isi.addColumn("Status");
        
        tableManagementAkun.setModel(isi);
        
        isi.getDataVector().removeAllElements();
        isi.fireTableDataChanged();
        
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM user");
            while(result.next()){
                Object[] obj = new Object[6];
                    
                obj [0] = result.getString("IDUser");
                obj [1] = result.getString("Username");
                obj [2] = result.getString("Name");
                obj [3] = result.getString("Email");
                obj [4] = result.getString("TypeAkun");
                obj [5] = result.getString("Status");

                isi.addRow(obj);
            }
            result.close();
            statement.close();         
        }
        catch(Exception e){
            System.out.print("Gagal terhubung");
            JOptionPane.showMessageDialog(null,"Koneksi databases error");
        }
        buttonHapusManagementAkun.setEnabled(false);
    }
    
    private void SearchManagementAkun(String key){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("Username");
        isi.addColumn("Nama");
        isi.addColumn("Email");
        isi.addColumn("Tipe Akun");
        isi.addColumn("Status");
        
            
        tableManagementAkun.setModel(isi);
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM user WHERE Username LIKE '%"+key+"%' OR Name LIKE '%"+key+"%' OR Email LIKE '%"+key+"%' OR TypeAkun LIKE '%"+key+"%' OR Status LIKE '%"+key+"%'");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("Username"),
                    result.getString("Name"),
                    result.getString("Email"),
                    result.getString("TypeAkun"),
                    result.getString("Status")
                });
            tableManagementAkun.setModel(isi);
            }
        }
        catch(Exception e){
            System.out.print("Gagal menampilkan... ");
            JOptionPane.showMessageDialog(null,"Tidak bisa mencari data");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        componentHapus = new component.swing.textFieldMain();
        mainPanelManagementAkun = new javax.swing.JPanel();
        panel1 = new component.swing.panelRound();
        jLabel1 = new javax.swing.JLabel();
        fieldCariManagementAkun = new component.swing.textField();
        buttonHapusManagementAkun = new component.swing.button();
        scrollManagementAkun = new javax.swing.JScrollPane();
        tableManagementAkun = new javax.swing.JTable();

        componentHapus.setText("textFieldMain1");

        setPreferredSize(new java.awt.Dimension(725, 591));

        mainPanelManagementAkun.setOpaque(false);
        mainPanelManagementAkun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 45)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Management Akun Karyawan");

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

        mainPanelManagementAkun.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 110));

        fieldCariManagementAkun.setLabelText("Cari");
        fieldCariManagementAkun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariManagementAkunKeyReleased(evt);
            }
        });
        mainPanelManagementAkun.add(fieldCariManagementAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 530, -1));

        buttonHapusManagementAkun.setBackground(new java.awt.Color(255, 0, 0));
        buttonHapusManagementAkun.setForeground(new java.awt.Color(255, 255, 255));
        buttonHapusManagementAkun.setText("Hapus");
        buttonHapusManagementAkun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusManagementAkunActionPerformed(evt);
            }
        });
        mainPanelManagementAkun.add(buttonHapusManagementAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 150, 40));

        tableManagementAkun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableManagementAkun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableManagementAkunMouseClicked(evt);
            }
        });
        scrollManagementAkun.setViewportView(tableManagementAkun);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainPanelManagementAkun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollManagementAkun)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanelManagementAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollManagementAkun, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fieldCariManagementAkunKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariManagementAkunKeyReleased
        String key = fieldCariManagementAkun.getText();
        System.out.println(key);
        
        if(key!=""){
            SearchManagementAkun(key);
        }else{
            DataTableManagementAkun();
        }
    }//GEN-LAST:event_fieldCariManagementAkunKeyReleased

    private void buttonHapusManagementAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusManagementAkunActionPerformed
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            
            statement.executeUpdate("DELETE FROM user WHERE IDUser = ('"+ componentHapus.getText() +"');");
            componentHapus.requestFocus();
            componentHapus.getText();
      
        }
        catch(Exception t){
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }
        DataTableManagementAkun();
    }//GEN-LAST:event_buttonHapusManagementAkunActionPerformed

    private void tableManagementAkunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableManagementAkunMouseClicked
        componentHapus.setText(tableManagementAkun.getValueAt(tableManagementAkun.getSelectedRow(),0) + "");
        
        buttonHapusManagementAkun.setEnabled(true);
    }//GEN-LAST:event_tableManagementAkunMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button buttonHapusManagementAkun;
    private component.swing.textFieldMain componentHapus;
    private component.swing.textField fieldCariManagementAkun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainPanelManagementAkun;
    private component.swing.panelRound panel1;
    private javax.swing.JScrollPane scrollManagementAkun;
    public static javax.swing.JTable tableManagementAkun;
    // End of variables declaration//GEN-END:variables
}
