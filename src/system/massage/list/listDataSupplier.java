
package system.massage.list;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class listDataSupplier extends javax.swing.JFrame {

    
    public listDataSupplier() {
        initComponents();
        loadDataListSupplier();
    }

    public void loadDataListSupplier(){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("ID Supplier");
        isi.addColumn("Nama");
        isi.addColumn("Alamat");
        isi.addColumn("No Telp");
        
        listDataSupplier.setModel(isi);
        
        isi.getDataVector().removeAllElements();
        isi.fireTableDataChanged();
        
        try {
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_supplier");           
            while(result.next()){
                Object[] obj = new Object[4];
                obj [0] =  result.getString("id_supplier");
                obj [1] =  result.getString("nama_supplier");
                obj [2] =  result.getString("alamat_supplier");
                obj [3] =  result.getString("no_telphone_supplier");

                isi.addRow(obj);
            }
            result.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("terjadi kesalahan");
        }
    }
    
    private void SearchListSupplier(String key){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("ID Supplier");
        isi.addColumn("Nama");
        isi.addColumn("Alamat");
        isi.addColumn("No Telp");
        
        listDataSupplier.setModel(isi);
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_supplier WHERE id_supplier LIKE '%"+key+"%' OR nama_supplier LIKE '%"+key+"%'"
                    + "OR alamat_supplier LIKE '%"+key+"%' OR no_telphone_supplier LIKE '%"+key+"%'");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("id_supplier"),
                    result.getString("nama_supplier"),
                    result.getString("alamat_supplier"),
                    result.getString("no_telphone_supplier")

                });
                listDataSupplier.setModel(isi);
            }        
        }
        catch(Exception e){
            System.out.print("Gagal menampilkan... ");
            JOptionPane.showMessageDialog(null,"Tidak bisa mencari data");
        }
    }
    
    private void pilihListSupplier(){
        int i = listDataSupplier.getSelectedRow();
        
        String id = listDataSupplier.getValueAt(i, 0).toString();
        
//        system.panelDataBarang.textFieldDataBarangKategori.setText(id);
//        system.panelDataPembelian.pekategori.setText(id);

        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTransparent1 = new component.swing.panelTransparent();
        panelRound1 = new component.swing.panelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        listDataSupplier = new component.model.tableCustom.table();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelTransparent1.setBackground(new java.awt.Color(225, 225, 225));
        panelTransparent1.setAlpha(0.8F);
        panelTransparent1.setRound(35);
        panelTransparent1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelTransparent1MouseClicked(evt);
            }
        });
        panelTransparent1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setRound(25);
        panelRound1.setShadowSize(new java.awt.Insets(5, 5, 5, 5));
        panelRound1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);

        listDataSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        listDataSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listDataSupplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listDataSupplier);

        panelRound1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelTransparent1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 500, 330));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel1.setText("List Supplier");
        panelTransparent1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 290, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listDataSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDataSupplierMouseClicked
        main.access.panelDataPembelian.fieldSupplierDataPembelian.setText(listDataSupplier.getValueAt(listDataSupplier.getSelectedRow(),1)+"");
//        main.access.panelDataPembelian.fieldKategoriDataBarang.setText(listDataSupplier.getValueAt(listDataSupplier.getSelectedRow(),0)+"");

        dispose();
        pilihListSupplier();
    }//GEN-LAST:event_listDataSupplierMouseClicked

    private void panelTransparent1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTransparent1MouseClicked
        dispose();
    }//GEN-LAST:event_panelTransparent1MouseClicked

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(listDataSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listDataSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listDataSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listDataSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listDataSupplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private component.model.tableCustom.table listDataSupplier;
    private component.swing.panelRound panelRound1;
    private component.swing.panelTransparent panelTransparent1;
    // End of variables declaration//GEN-END:variables
}
