package main;

import static main.gbrandapplication.accessHome;
import static main.gbrandapplication.mainAccessPanel;

public class panelDashboard extends javax.swing.JPanel {

    public panelDashboard() {
        initComponents();
        setOpaque(false);
        
        panelTransparent1.removeAll();
        panelTransparent1.add(panelDataBarang1);
        panelTransparent1.repaint();
        panelTransparent1.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTransparent1 = new component.swing.panelTransparent();
        panelDataBarang1 = new main.access.panelDataBarang();
        panelDataPenjualan2 = new main.access.panelDataPenjualan();
        panelDataPembelian2 = new main.access.panelDataPembelian();
        panelDataPengeluaran2 = new main.access.panelDataPengeluaran();
        panelDataSupplier2 = new main.access.panelDataSupplier();
        panelKategori2 = new main.access.panelKategori();
        panelLaporan1 = new main.access.panelLaporan();
        button1 = new component.swing.button();
        jLabel8 = new javax.swing.JLabel();
        labelDataBarangDashboard = new javax.swing.JLabel();
        labelPenjualanDashboard = new javax.swing.JLabel();
        labelPembelianDashboard = new javax.swing.JLabel();
        labelPengeluaranDashboard = new javax.swing.JLabel();
        labelSupplierDashboard = new javax.swing.JLabel();
        labelKategoriDashboard = new javax.swing.JLabel();
        labelLaporanDashboard = new javax.swing.JLabel();
        imageItem2 = new component.swing.imageItem();
        imageItem3 = new component.swing.imageItem();
        imageItem4 = new component.swing.imageItem();
        imageItem5 = new component.swing.imageItem();
        imageItem6 = new component.swing.imageItem();
        imageItem7 = new component.swing.imageItem();
        imageItem1 = new component.swing.imageItem();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTransparent1.setBackground(new java.awt.Color(225, 225, 225));
        panelTransparent1.setAlpha(0.8F);
        panelTransparent1.setRound(25);
        panelTransparent1.setLayout(new java.awt.CardLayout());
        panelTransparent1.add(panelDataBarang1, "card2");
        panelTransparent1.add(panelDataPenjualan2, "card3");
        panelTransparent1.add(panelDataPembelian2, "card4");
        panelTransparent1.add(panelDataPengeluaran2, "card5");
        panelTransparent1.add(panelDataSupplier2, "card6");
        panelTransparent1.add(panelKategori2, "card7");
        panelTransparent1.add(panelLaporan1, "card8");

        add(panelTransparent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 860, 530));

        button1.setText("Keluar Tampilan Dashboard");
        button1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 230, 60));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/transaksi-icon.png"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        labelDataBarangDashboard.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelDataBarangDashboard.setText("Data Barang");
        labelDataBarangDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelDataBarangDashboardMouseClicked(evt);
            }
        });
        add(labelDataBarangDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 190, 40));

        labelPenjualanDashboard.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelPenjualanDashboard.setText("Data Penjualan");
        labelPenjualanDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPenjualanDashboardMouseClicked(evt);
            }
        });
        add(labelPenjualanDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 190, 40));

        labelPembelianDashboard.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelPembelianDashboard.setText("Data Pembelian");
        labelPembelianDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPembelianDashboardMouseClicked(evt);
            }
        });
        add(labelPembelianDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 190, 40));

        labelPengeluaranDashboard.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelPengeluaranDashboard.setText("Data Pengeluaran");
        labelPengeluaranDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPengeluaranDashboardMouseClicked(evt);
            }
        });
        add(labelPengeluaranDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 190, 40));

        labelSupplierDashboard.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelSupplierDashboard.setText("Data Supplier");
        labelSupplierDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSupplierDashboardMouseClicked(evt);
            }
        });
        add(labelSupplierDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 190, 40));

        labelKategoriDashboard.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelKategoriDashboard.setText("Kategori");
        labelKategoriDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelKategoriDashboardMouseClicked(evt);
            }
        });
        add(labelKategoriDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 190, 40));

        labelLaporanDashboard.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelLaporanDashboard.setText("Laporan");
        labelLaporanDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLaporanDashboardMouseClicked(evt);
            }
        });
        add(labelLaporanDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, 190, 40));

        imageItem2.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/user (1).png"))); // NOI18N
        imageItem2.setRound(25);
        add(imageItem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 40, 40));

        imageItem3.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/user (1).png"))); // NOI18N
        imageItem3.setRound(25);
        add(imageItem3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 40, 40));

        imageItem4.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/user (1).png"))); // NOI18N
        imageItem4.setRound(25);
        add(imageItem4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 40, 40));

        imageItem5.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/user (1).png"))); // NOI18N
        imageItem5.setRound(25);
        add(imageItem5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 40, 40));

        imageItem6.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/user (1).png"))); // NOI18N
        imageItem6.setRound(25);
        add(imageItem6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 40, 40));

        imageItem7.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/user (1).png"))); // NOI18N
        imageItem7.setRound(25);
        add(imageItem7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 40, 40));

        imageItem1.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/user (1).png"))); // NOI18N
        imageItem1.setRound(25);
        add(imageItem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 40, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void labelDataBarangDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelDataBarangDashboardMouseClicked
        panelTransparent1.removeAll();
        panelTransparent1.add(panelDataBarang1);
        panelTransparent1.repaint();
        panelTransparent1.revalidate();
    }//GEN-LAST:event_labelDataBarangDashboardMouseClicked

    private void labelPenjualanDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPenjualanDashboardMouseClicked
        panelTransparent1.removeAll();
        panelTransparent1.add(panelDataPenjualan2);
        panelTransparent1.repaint();
        panelTransparent1.revalidate();
    }//GEN-LAST:event_labelPenjualanDashboardMouseClicked

    private void labelPembelianDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPembelianDashboardMouseClicked
        panelTransparent1.removeAll();
        panelTransparent1.add(panelDataPembelian2);
        panelTransparent1.repaint();
        panelTransparent1.revalidate();
    }//GEN-LAST:event_labelPembelianDashboardMouseClicked

    private void labelPengeluaranDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPengeluaranDashboardMouseClicked
        panelTransparent1.removeAll();
        panelTransparent1.add(panelDataPengeluaran2);
        panelTransparent1.repaint();
        panelTransparent1.revalidate();
    }//GEN-LAST:event_labelPengeluaranDashboardMouseClicked

    private void labelSupplierDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSupplierDashboardMouseClicked
        panelTransparent1.removeAll();
        panelTransparent1.add(panelDataSupplier2);
        panelTransparent1.repaint();
        panelTransparent1.revalidate();
    }//GEN-LAST:event_labelSupplierDashboardMouseClicked

    private void labelKategoriDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelKategoriDashboardMouseClicked
        panelTransparent1.removeAll();
        panelTransparent1.add(panelKategori2);
        panelTransparent1.repaint();
        panelTransparent1.revalidate();
    }//GEN-LAST:event_labelKategoriDashboardMouseClicked

    private void labelLaporanDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLaporanDashboardMouseClicked
        panelTransparent1.removeAll();
        panelTransparent1.add(panelLaporan1);
        panelTransparent1.repaint();
        panelTransparent1.revalidate();
    }//GEN-LAST:event_labelLaporanDashboardMouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessHome);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button button1;
    private component.swing.imageItem imageItem1;
    private component.swing.imageItem imageItem2;
    private component.swing.imageItem imageItem3;
    private component.swing.imageItem imageItem4;
    private component.swing.imageItem imageItem5;
    private component.swing.imageItem imageItem6;
    private component.swing.imageItem imageItem7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel labelDataBarangDashboard;
    private javax.swing.JLabel labelKategoriDashboard;
    private javax.swing.JLabel labelLaporanDashboard;
    private javax.swing.JLabel labelPembelianDashboard;
    private javax.swing.JLabel labelPengeluaranDashboard;
    private javax.swing.JLabel labelPenjualanDashboard;
    private javax.swing.JLabel labelSupplierDashboard;
    private main.access.panelDataBarang panelDataBarang1;
    private main.access.panelDataPembelian panelDataPembelian2;
    private main.access.panelDataPengeluaran panelDataPengeluaran2;
    private main.access.panelDataPenjualan panelDataPenjualan2;
    private main.access.panelDataSupplier panelDataSupplier2;
    private main.access.panelKategori panelKategori2;
    private main.access.panelLaporan panelLaporan1;
    private component.swing.panelTransparent panelTransparent1;
    // End of variables declaration//GEN-END:variables
}
