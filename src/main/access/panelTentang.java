package main.access;

import component.swing.scrollBarCustom;
import java.awt.Color;

public class panelTentang extends javax.swing.JPanel {

    public panelTentang() {
        initComponents();
        setOpaque(false);
        
        jScrollPane2.setVerticalScrollBar(new scrollBarCustom());
        jScrollPane2.setBackground(new Color(242,242,242));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new component.swing.panelRound();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        imageAvatar1 = new component.swing.imageAvatar();
        imageAvatar2 = new component.swing.imageAvatar();
        imageAvatar3 = new component.swing.imageAvatar();
        imageAvatar4 = new component.swing.imageAvatar();
        jTextPane1 = new javax.swing.JTextPane();
        jTextPane2 = new javax.swing.JTextPane();
        jTextPane3 = new javax.swing.JTextPane();
        jTextPane4 = new javax.swing.JTextPane();
        jTextPane5 = new javax.swing.JTextPane();
        imageAvatar5 = new component.swing.imageAvatar();
        jPanel2 = new javax.swing.JPanel();

        panelRound1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelRound1.setRound(25);
        panelRound1.setShadowSize(new java.awt.Insets(8, 8, 8, 8));
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 45)); // NOI18N
        jLabel2.setText("Team Developer Pengembang");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/Muhammad-Ilham.jpeg"))); // NOI18N
        jPanel1.add(imageAvatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 160, 140));

        imageAvatar2.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/DSC_1235 copy.jpg"))); // NOI18N
        jPanel1.add(imageAvatar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 160, 140));

        imageAvatar3.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/Compress_20220423_114112_2022.jpg"))); // NOI18N
        jPanel1.add(imageAvatar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 160, 140));

        imageAvatar4.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/MUHAMMAD ANAS SAIFULLAH.JPG"))); // NOI18N
        jPanel1.add(imageAvatar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 160, 140));

        jTextPane1.setEditable(false);
        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jTextPane1.setText("Muhammad Ilham\nE41220495");
        jPanel1.add(jTextPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 170, -1));

        jTextPane2.setEditable(false);
        jTextPane2.setBorder(null);
        jTextPane2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jTextPane2.setText("Aditya Nico Bagaskara\nE41222811");
        jPanel1.add(jTextPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 220, -1));

        jTextPane3.setEditable(false);
        jTextPane3.setBorder(null);
        jTextPane3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jTextPane3.setText("Nur Muhammad Fadli\nE41220464");
        jPanel1.add(jTextPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, -1, -1));

        jTextPane4.setEditable(false);
        jTextPane4.setBorder(null);
        jTextPane4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jTextPane4.setText("Muhammad Anas Saifulloh\nE41220329");
        jPanel1.add(jTextPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 260, -1));

        jTextPane5.setEditable(false);
        jTextPane5.setBorder(null);
        jTextPane5.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jTextPane5.setText("Mohammad Tegar Aditya Saputra\nE41220330");
        jPanel1.add(jTextPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 520, 320, -1));

        imageAvatar5.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/IMG-20220117-WA0002.jpg"))); // NOI18N
        jPanel1.add(imageAvatar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 160, 140));

        jPanel2.setOpaque(false);
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 790, 30));

        jScrollPane2.setViewportView(jPanel1);

        panelRound1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 840, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.imageAvatar imageAvatar1;
    private component.swing.imageAvatar imageAvatar2;
    private component.swing.imageAvatar imageAvatar3;
    private component.swing.imageAvatar imageAvatar4;
    private component.swing.imageAvatar imageAvatar5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private component.swing.panelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
