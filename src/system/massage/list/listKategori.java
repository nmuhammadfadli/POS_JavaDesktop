package system.massage.list;

import com.mysql.jdbc.Statement;
import component.model.table.tableCustom;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class listKategori extends system.massage.massageDialog {

    
    public listKategori(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadDataListKategori();
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        tableCustom.apply(ScrollPaneListKategori, tableCustom.TableType.MULTI_LINE);
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
        
        main.access.panelDataBarang.fieldKategoriDataBarang.setText(id);
//        system.panelDataPembelian.pekategori.setText(id);
        
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textFieldMain1 = new component.swing.textFieldMain();
        buttonListKategoriPilih = new component.swing.button();
        buttonListKategoriBatal = new component.swing.button();
        ScrollPaneListKategori = new javax.swing.JScrollPane();
        listTableKategori = new javax.swing.JTable();
        textFieldListKategoriCari = new component.swing.textField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(450, 557));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textFieldMain1.setEditable(false);
        textFieldMain1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldMain1.setText("List Kategori");
        textFieldMain1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        textFieldMain1.setRound(18);
        getContentPane().add(textFieldMain1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 53));

        buttonListKategoriPilih.setText("Pilih");
        buttonListKategoriPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListKategoriPilihActionPerformed(evt);
            }
        });
        getContentPane().add(buttonListKategoriPilih, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 100, -1));

        buttonListKategoriBatal.setText("Batal");
        buttonListKategoriBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListKategoriBatalActionPerformed(evt);
            }
        });
        getContentPane().add(buttonListKategoriBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 100, -1));

        listTableKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        listTableKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listTableKategoriMouseClicked(evt);
            }
        });
        ScrollPaneListKategori.setViewportView(listTableKategori);

        getContentPane().add(ScrollPaneListKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 166, 430, 380));

        textFieldListKategoriCari.setLabelText("Cari");
        textFieldListKategoriCari.setOpaque(false);
        getContentPane().add(textFieldListKategoriCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 210, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonListKategoriBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListKategoriBatalActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonListKategoriBatalActionPerformed

    private void buttonListKategoriPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListKategoriPilihActionPerformed
        pilihListKategori();
    }//GEN-LAST:event_buttonListKategoriPilihActionPerformed

    private void listTableKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTableKategoriMouseClicked
        main.access.panelDataBarang.fieldIDKategoriDataBarang.setText(listTableKategori.getValueAt(listTableKategori.getSelectedRow(),1)+"");
        main.access.panelDataBarang.fieldKategoriDataBarang.setText(listTableKategori.getValueAt(listTableKategori.getSelectedRow(),0)+"");
        
        dispose();
    }//GEN-LAST:event_listTableKategoriMouseClicked

    
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
            java.util.logging.Logger.getLogger(listKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                listKategori dialog = new listKategori(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPaneListKategori;
    private component.swing.button buttonListKategoriBatal;
    private component.swing.button buttonListKategoriPilih;
    private javax.swing.JTable listTableKategori;
    private component.swing.textField textFieldListKategoriCari;
    private component.swing.textFieldMain textFieldMain1;
    // End of variables declaration//GEN-END:variables
}
