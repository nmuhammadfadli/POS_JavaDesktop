
package system.massage.list;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class listKategoriDataBarang extends javax.swing.JFrame {

   
    public listKategoriDataBarang() {
        initComponents();
        loadDataListKategori();
        
        listTableKategori.fixTable(jScrollPane1);
    }

    public void loadDataListKategori(){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("No");
        isi.addColumn("Kategori");
        
        listTableKategori.setModel(isi);
        
        isi.getDataVector().removeAllElements();
        isi.fireTableDataChanged();
        
        try {
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_kategori");           
            while(result.next()){
                Object[] obj = new Object[2];
                obj [0] =  result.getString("id_kategori");
                obj [1] =  result.getString("nama_kategori");

                
                isi.addRow(obj);
            }
            result.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("terjadi kesalahan");
        }
    }
    
    private void SearchListKategori(String key){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("No");
        isi.addColumn("Kategori");
        
        listTableKategori.setModel(isi);
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_kategori WHERE id_kategori LIKE '%"+key+"%' OR nama_kategori LIKE '%"+key+"%'");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("id_kategori"),
                    result.getString("nama_kategori"),

                });
                listTableKategori.setModel(isi);
            }        
        }
        catch(Exception e){
            System.out.print("Gagal menampilkan... ");
            JOptionPane.showMessageDialog(null,"Tidak bisa mencari data");
        }
    }
    
    private void pilihListKategori(){
        int i = listTableKategori.getSelectedRow();
        
        String id = listTableKategori.getValueAt(i, 0).toString();
        String nama = listTableKategori.getValueAt(i, 1).toString();
        main.access.panelDataBarang.fieldKategoriDataBarang.setText(id);
        main.access.panelDataBarang.fieldNamaDataBarang.setText(nama);
        
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTransparent1 = new component.swing.panelTransparent();
        panelRound1 = new component.swing.panelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTableKategori = new component.model.tableCustom.table();
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

        listTableKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        listTableKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listTableKategoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listTableKategori);

        panelRound1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelTransparent1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 500, 330));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel1.setText("List Kategori Barang");
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

    private void listTableKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTableKategoriMouseClicked
        main.access.panelDataBarang.fieldIDKategoriDataBarang.setText(listTableKategori.getValueAt(listTableKategori.getSelectedRow(),1)+"");
        main.access.panelDataBarang.fieldKategoriDataBarang.setText(listTableKategori.getValueAt(listTableKategori.getSelectedRow(),0)+"");

        dispose();
        pilihListKategori();
    }//GEN-LAST:event_listTableKategoriMouseClicked

    private void panelTransparent1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTransparent1MouseClicked
        dispose();
    }//GEN-LAST:event_panelTransparent1MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(listKategoriDataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listKategoriDataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listKategoriDataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listKategoriDataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listKategoriDataBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private component.model.tableCustom.table listTableKategori;
    private component.swing.panelRound panelRound1;
    private component.swing.panelTransparent panelTransparent1;
    // End of variables declaration//GEN-END:variables
}
