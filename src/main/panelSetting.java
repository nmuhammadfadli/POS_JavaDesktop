package main;

import javax.swing.JOptionPane;
import static main.gbrandapplication.accessHome;
import static main.gbrandapplication.mainAccessPanel;

public class panelSetting extends javax.swing.JPanel {

    public panelSetting() {
        initComponents();
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTransparent1 = new component.swing.panelTransparent();
        panelBantuan1 = new main.access.panelBantuan();
        panelTambahAkun1 = new main.access.panelTambahAkun();
        panelManagementAkun1 = new main.access.panelManagementAkun();
        panelTentang1 = new main.access.panelTentang();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        imageItem2 = new component.swing.imageItem();
        imageItem3 = new component.swing.imageItem();
        imageItem4 = new component.swing.imageItem();
        imageItem5 = new component.swing.imageItem();
        imageItem6 = new component.swing.imageItem();
        button1 = new component.swing.button();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTransparent1.setBackground(new java.awt.Color(225, 225, 225));
        panelTransparent1.setAlpha(0.8F);
        panelTransparent1.setRound(25);
        panelTransparent1.setLayout(new java.awt.CardLayout());
        panelTransparent1.add(panelBantuan1, "card3");
        panelTransparent1.add(panelTambahAkun1, "card5");
        panelTransparent1.add(panelManagementAkun1, "card4");
        panelTransparent1.add(panelTentang1, "card2");

        add(panelTransparent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 860, 530));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Bantuan");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 190, 40));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Tambah Akun");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 190, 40));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Management Akun");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 190, 40));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Theme");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 190, 40));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Tentang");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 190, 40));

        imageItem2.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/user (1).png"))); // NOI18N
        imageItem2.setRound(25);
        add(imageItem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 40, 40));

        imageItem3.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/user (1).png"))); // NOI18N
        imageItem3.setRound(25);
        add(imageItem3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 40, 40));

        imageItem4.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/user (1).png"))); // NOI18N
        imageItem4.setRound(25);
        add(imageItem4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 40, 40));

        imageItem5.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/user (1).png"))); // NOI18N
        imageItem5.setRound(25);
        add(imageItem5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 40, 40));

        imageItem6.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/user (1).png"))); // NOI18N
        imageItem6.setRound(25);
        add(imageItem6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 40, 40));

        button1.setText("Keluar Tampilan Setting");
        button1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, 230, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        panelTransparent1.removeAll();
        panelTransparent1.add(panelBantuan1);
        panelTransparent1.repaint();
        panelTransparent1.revalidate();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        panelTransparent1.removeAll();
        panelTransparent1.add(panelTambahAkun1);
        panelTransparent1.repaint();
        panelTransparent1.revalidate();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        panelTransparent1.removeAll();
        panelTransparent1.add(panelManagementAkun1);
        panelTransparent1.repaint();
        panelTransparent1.revalidate();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        int dialogButton =JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Akan segera hadir","PERINGATAN", dialogButton);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        panelTransparent1.removeAll();
        panelTransparent1.add(panelTentang1);
        panelTransparent1.repaint();
        panelTransparent1.revalidate();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessHome);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button button1;
    private component.swing.imageItem imageItem2;
    private component.swing.imageItem imageItem3;
    private component.swing.imageItem imageItem4;
    private component.swing.imageItem imageItem5;
    private component.swing.imageItem imageItem6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private main.access.panelBantuan panelBantuan1;
    private main.access.panelManagementAkun panelManagementAkun1;
    private main.access.panelTambahAkun panelTambahAkun1;
    private main.access.panelTentang panelTentang1;
    private component.swing.panelTransparent panelTransparent1;
    // End of variables declaration//GEN-END:variables
}
