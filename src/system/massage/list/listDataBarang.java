package system.massage.list;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import system.daftar_barang;

public class listDataBarang extends javax.swing.JFrame {

    private DefaultTableModel model;
    public listDataBarang() {
        initComponents();
        String[] judul = {"ID Barang", "Nama Barang", "Harga",  "Ukuran", "Kategori"};
        model = new DefaultTableModel(judul, 0);
        listTableBarang.setModel(model);
        tampilkan();
        
    }

    private void tampilkan() {
        int row = listTableBarang.getRowCount();
        for (int a = 0; a < row; a++) {
            model.removeRow(0);
        }
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gbrand", "root", "");
            ResultSet rs = cn.createStatement().executeQuery("SELECT id_barang, nama_barang, harga_barang, ukuran, id_kategori FROM data_barang WHERE stok = 1;");
            while (rs.next()) {
                String data[] = {rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)};
                model.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daftar_barang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTransparent1 = new component.swing.panelTransparent();
        panelRound1 = new component.swing.panelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTableBarang = new component.model.tableCustom.table();
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

        listTableBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        listTableBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listTableBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listTableBarang);

        panelRound1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelTransparent1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 500, 330));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("List Data Barang");
        panelTransparent1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 290, 40));

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

    private void listTableBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTableBarangMouseClicked
        int i = listTableBarang.getSelectedRow();
        
        String id = listTableBarang.getValueAt(i, 0).toString();
        String nama = listTableBarang.getValueAt(i, 1).toString();
        String harga = listTableBarang.getValueAt(i, 2).toString();
        String Kategori=listTableBarang.getValueAt(i, 4).toString();
        
        main.panelTransaksi.fieldIDBarangTransaksi.setText(id);
        main.panelTransaksi.fieldNamaBarangTransaksi.setText(nama);
        main.panelTransaksi.fieldHargaTransaksi.setText(harga);
        main.panelTransaksi.fieldKategoriTransaksi.setText(Kategori);
        
        dispose();
        
//        main.panelTransaksi.fieldSupplierDataPembelian.setText(listDataSupplier.getValueAt(listDataSupplier.getSelectedRow(),1)+"");
    }//GEN-LAST:event_listTableBarangMouseClicked

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
            java.util.logging.Logger.getLogger(listDataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listDataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listDataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listDataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listDataBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private component.model.tableCustom.table listTableBarang;
    private component.swing.panelRound panelRound1;
    private component.swing.panelTransparent panelTransparent1;
    // End of variables declaration//GEN-END:variables
}
