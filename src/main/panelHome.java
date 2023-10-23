package main;

import component.swing.scrollBarCustom;
import java.awt.Color;
import static main.gbrandapplication.accessTransaksi;
import static main.gbrandapplication.accessSkemaPenjualan;
import static main.gbrandapplication.accessDashboard;
import static main.gbrandapplication.accessSetting;
import static main.gbrandapplication.getNotify;
import static main.gbrandapplication.mainAccessPanel;
import system.massage.popup.dialogHomeProfile;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import static main.gbrandapplication.accessLogin;
import service.connect;

public class panelHome extends javax.swing.JPanel {

    public panelHome() {
        initComponents();
        setOpaque(false);
        
        jScrollPane1.setVerticalScrollBar(new scrollBarCustom());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldIDPenggunaProfile = new javax.swing.JTextField();
        panelTransparent2 = new component.swing.panelTransparent();
        imageProfileHome = new component.swing.imageItem();
        labelProfileHome = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        homeAccess = new javax.swing.JPanel();
        homeUser = new javax.swing.JPanel();
        homeAdministrator = new javax.swing.JPanel();
        imageSettingHome = new javax.swing.JLabel();
        imageDashboardHome = new javax.swing.JLabel();
        imageSkemaPenjualanHome = new javax.swing.JLabel();
        imageTransaksiHome = new javax.swing.JLabel();
        panelSettingHome = new component.swing.panelRound();
        labelSettingHome = new javax.swing.JLabel();
        panelDashboardHome = new component.swing.panelRound();
        labelDashboardHome = new javax.swing.JLabel();
        panelSkemaPenjualanHome = new component.swing.panelRound();
        labelSkemaPenjualanHome = new javax.swing.JLabel();
        panelTransaksiHome = new component.swing.panelRound();
        labelTransaksiHome = new javax.swing.JLabel();
        homeKaryawan = new javax.swing.JPanel();
        imageTransaksiHome1 = new javax.swing.JLabel();
        imageSkemaPenjualanHome1 = new javax.swing.JLabel();
        panelSkemaPenjualanHome1 = new component.swing.panelRound();
        labelSkemaPenjualanHome1 = new javax.swing.JLabel();
        panelTransaksiHome1 = new component.swing.panelRound();
        labelTransaksiHome1 = new javax.swing.JLabel();
        homeProfile = new javax.swing.JPanel();
        panelGradient1 = new component.swing.panelGradient();
        panelRound1 = new component.swing.panelRound();
        imageItem2 = new component.swing.imageItem();
        imageItem1 = new component.swing.imageItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        button1 = new component.swing.button();
        button2 = new component.swing.button();
        titleIconProfile = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        fieldUsernameProfile = new component.swing.textFieldMain();
        fieldNamaProfile = new component.swing.textFieldMain();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldEmailProfile = new component.swing.textFieldMain();
        jLabel7 = new javax.swing.JLabel();
        fieldTipeAkunProfile = new component.swing.textFieldMain();
        fieldNoTelphoneProfile = new component.swing.textFieldMain();
        jLabel8 = new javax.swing.JLabel();
        fieldPasswordProfile = new component.swing.passwordFieldMain();
        fieldConfirmationPasswordProfile = new component.swing.passwordFieldMain();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        panelRound3 = new component.swing.panelRound();
        textPaneAlamatProfile = new javax.swing.JTextPane();
        buttonSimpanProfile = new component.swing.button();

        panelTransparent2.setBackground(new java.awt.Color(225, 225, 225));
        panelTransparent2.setAlpha(0.8F);
        panelTransparent2.setRound(35);
        panelTransparent2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imageProfileHome.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/user (1).png"))); // NOI18N
        imageProfileHome.setRound(25);
        imageProfileHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageProfileHomeMouseClicked(evt);
            }
        });
        panelTransparent2.add(imageProfileHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, 50, 50));

        labelProfileHome.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        labelProfileHome.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelProfileHome.setText("Hallo, Muhammad Ilham");
        labelProfileHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelProfileHomeMouseClicked(evt);
            }
        });
        panelTransparent2.add(labelProfileHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 250, 40));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Administrator");
        panelTransparent2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 40, 190, -1));

        homeAccess.setOpaque(false);
        homeAccess.setLayout(new java.awt.CardLayout());

        homeUser.setOpaque(false);
        homeUser.setLayout(new java.awt.CardLayout());

        homeAdministrator.setOpaque(false);
        homeAdministrator.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imageSettingHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/Setting-icon.png"))); // NOI18N
        imageSettingHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageSettingHomeMouseClicked(evt);
            }
        });
        homeAdministrator.add(imageSettingHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 280, -1, -1));

        imageDashboardHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/Dashboard-icon.png"))); // NOI18N
        imageDashboardHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageDashboardHomeMouseClicked(evt);
            }
        });
        homeAdministrator.add(imageDashboardHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        imageSkemaPenjualanHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/skema-penjualan.png"))); // NOI18N
        imageSkemaPenjualanHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageSkemaPenjualanHomeMouseClicked(evt);
            }
        });
        homeAdministrator.add(imageSkemaPenjualanHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, -1, -1));

        imageTransaksiHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/transaksi.png"))); // NOI18N
        imageTransaksiHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageTransaksiHomeMouseClicked(evt);
            }
        });
        homeAdministrator.add(imageTransaksiHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, -1, -1));

        panelSettingHome.setRound(25);
        panelSettingHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelSettingHomeMouseClicked(evt);
            }
        });
        panelSettingHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelSettingHome.setFont(new java.awt.Font("Dialog", 1, 35)); // NOI18N
        labelSettingHome.setText("Setting");
        labelSettingHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSettingHomeMouseClicked(evt);
            }
        });
        panelSettingHome.add(labelSettingHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 130, -1));

        homeAdministrator.add(panelSettingHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 330, 310, 190));

        panelDashboardHome.setRound(25);
        panelDashboardHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelDashboardHomeMouseClicked(evt);
            }
        });
        panelDashboardHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelDashboardHome.setFont(new java.awt.Font("Dialog", 1, 35)); // NOI18N
        labelDashboardHome.setText("Dashboard");
        labelDashboardHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelDashboardHomeMouseClicked(evt);
            }
        });
        panelDashboardHome.add(labelDashboardHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 180, -1));

        homeAdministrator.add(panelDashboardHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 310, 190));

        panelSkemaPenjualanHome.setRound(25);
        panelSkemaPenjualanHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelSkemaPenjualanHomeMouseClicked(evt);
            }
        });
        panelSkemaPenjualanHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelSkemaPenjualanHome.setFont(new java.awt.Font("Dialog", 1, 33)); // NOI18N
        labelSkemaPenjualanHome.setText("Skema Penjualan");
        labelSkemaPenjualanHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSkemaPenjualanHomeMouseClicked(evt);
            }
        });
        panelSkemaPenjualanHome.add(labelSkemaPenjualanHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 270, -1));

        homeAdministrator.add(panelSkemaPenjualanHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 310, 190));

        panelTransaksiHome.setRound(25);
        panelTransaksiHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelTransaksiHomeMouseClicked(evt);
            }
        });
        panelTransaksiHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTransaksiHome.setFont(new java.awt.Font("Dialog", 1, 35)); // NOI18N
        labelTransaksiHome.setText("Transaksi");
        labelTransaksiHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelTransaksiHomeMouseClicked(evt);
            }
        });
        panelTransaksiHome.add(labelTransaksiHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 160, 40));

        homeAdministrator.add(panelTransaksiHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 310, 190));

        homeUser.add(homeAdministrator, "card2");

        homeKaryawan.setOpaque(false);
        homeKaryawan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imageTransaksiHome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/transaksi.png"))); // NOI18N
        imageTransaksiHome1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageTransaksiHome1MouseClicked(evt);
            }
        });
        homeKaryawan.add(imageTransaksiHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        imageSkemaPenjualanHome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/skema-penjualan.png"))); // NOI18N
        imageSkemaPenjualanHome1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageSkemaPenjualanHome1MouseClicked(evt);
            }
        });
        homeKaryawan.add(imageSkemaPenjualanHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, -1, -1));

        panelSkemaPenjualanHome1.setRound(25);
        panelSkemaPenjualanHome1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelSkemaPenjualanHome1MouseClicked(evt);
            }
        });
        panelSkemaPenjualanHome1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelSkemaPenjualanHome1.setFont(new java.awt.Font("Dialog", 1, 33)); // NOI18N
        labelSkemaPenjualanHome1.setText("Skema Penjualan");
        labelSkemaPenjualanHome1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSkemaPenjualanHome1MouseClicked(evt);
            }
        });
        panelSkemaPenjualanHome1.add(labelSkemaPenjualanHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 270, -1));

        homeKaryawan.add(panelSkemaPenjualanHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 310, 190));

        panelTransaksiHome1.setRound(25);
        panelTransaksiHome1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelTransaksiHome1MouseClicked(evt);
            }
        });
        panelTransaksiHome1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTransaksiHome1.setFont(new java.awt.Font("Dialog", 1, 35)); // NOI18N
        labelTransaksiHome1.setText("Transaksi");
        labelTransaksiHome1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelTransaksiHome1MouseClicked(evt);
            }
        });
        panelTransaksiHome1.add(labelTransaksiHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 160, 40));

        homeKaryawan.add(panelTransaksiHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 310, 190));

        homeUser.add(homeKaryawan, "card3");

        homeAccess.add(homeUser, "card5");

        homeProfile.setOpaque(false);
        homeProfile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGradient1.setRadius(45);
        panelGradient1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(242, 242, 242));
        panelRound1.setRound(35);
        panelRound1.setShadowSize(new java.awt.Insets(5, 5, 8, 5));
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imageItem2.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/user (1).png"))); // NOI18N
        imageItem2.setRound(20);
        panelRound1.add(imageItem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 100, 100));

        imageItem1.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/wallpaper/slide2.jpg"))); // NOI18N
        imageItem1.setRound(20);
        panelRound1.add(imageItem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 350, 180));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Username");
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 320, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tipe Akun");
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 350, -1));

        button1.setText("Keluar");
        button1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelRound1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 120, 60));

        button2.setBackground(new java.awt.Color(204, 0, 0));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Log Out");
        button2.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        panelRound1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 230, 60));

        panelGradient1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 390, 450));

        titleIconProfile.setFont(new java.awt.Font("Dialog", 1, 35)); // NOI18N
        titleIconProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleIconProfile.setText("Change Your Profile User");
        titleIconProfile.setIconTextGap(15);
        panelGradient1.add(titleIconProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 630, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel3.setText("Username");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        fieldUsernameProfile.setBackground(new java.awt.Color(242, 242, 242));
        fieldUsernameProfile.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jPanel2.add(fieldUsernameProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 620, 60));

        fieldNamaProfile.setBackground(new java.awt.Color(242, 242, 242));
        fieldNamaProfile.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jPanel2.add(fieldNamaProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 620, 60));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel4.setText("Nama");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel5.setText("Email");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        fieldEmailProfile.setBackground(new java.awt.Color(242, 242, 242));
        fieldEmailProfile.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jPanel2.add(fieldEmailProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 620, 60));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel7.setText("Password");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        fieldTipeAkunProfile.setBackground(new java.awt.Color(242, 242, 242));
        fieldTipeAkunProfile.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jPanel2.add(fieldTipeAkunProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 620, 60));

        fieldNoTelphoneProfile.setBackground(new java.awt.Color(242, 242, 242));
        fieldNoTelphoneProfile.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jPanel2.add(fieldNoTelphoneProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 620, 60));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel8.setText("Ulangi Password");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        fieldPasswordProfile.setBackground(new java.awt.Color(242, 242, 242));
        fieldPasswordProfile.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jPanel2.add(fieldPasswordProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 620, 60));

        fieldConfirmationPasswordProfile.setBackground(new java.awt.Color(242, 242, 242));
        fieldConfirmationPasswordProfile.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jPanel2.add(fieldConfirmationPasswordProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 620, 60));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel9.setText("Tipe Akun");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel10.setText("No Telphone");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel11.setText("Alamat");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, -1, -1));

        panelRound3.setBackground(new java.awt.Color(242, 242, 242));

        textPaneAlamatProfile.setBackground(new java.awt.Color(242, 242, 242));
        textPaneAlamatProfile.setBorder(null);
        textPaneAlamatProfile.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textPaneAlamatProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addComponent(textPaneAlamatProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel2.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 620, 160));

        buttonSimpanProfile.setText("Simpan Profile");
        buttonSimpanProfile.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonSimpanProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanProfileActionPerformed(evt);
            }
        });
        jPanel2.add(buttonSimpanProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 840, 150, 50));

        jScrollPane1.setViewportView(jPanel2);

        panelGradient1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 660, 360));

        homeProfile.add(panelGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1090, 490));

        homeAccess.add(homeProfile, "card4");

        panelTransparent2.add(homeAccess, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1090, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTransparent2, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTransparent2, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void imageProfileHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageProfileHomeMouseClicked
//        dialogHomeProfile profile = new dialogHomeProfile(getNotify());
//        profile.showMessage("Verify Username and Email \n for Your User to change Password.");
        homeAccess.removeAll();
        homeAccess.add(homeProfile);
        homeAccess.repaint();
        homeAccess.revalidate();
    }//GEN-LAST:event_imageProfileHomeMouseClicked

    private void labelProfileHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelProfileHomeMouseClicked
//        dialogHomeProfile profile = new dialogHomeProfile(getNotify());
//        profile.showMessage("Verify Username and Email \n for Your User to change Password.");
        homeAccess.removeAll();
        homeAccess.add(homeProfile);
        homeAccess.repaint();
        homeAccess.revalidate();
    }//GEN-LAST:event_labelProfileHomeMouseClicked

    private void imageTransaksiHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageTransaksiHomeMouseClicked
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessTransaksi);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_imageTransaksiHomeMouseClicked

    private void labelTransaksiHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTransaksiHomeMouseClicked
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessTransaksi);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_labelTransaksiHomeMouseClicked

    private void panelTransaksiHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTransaksiHomeMouseClicked
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessTransaksi);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_panelTransaksiHomeMouseClicked

    private void imageSkemaPenjualanHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageSkemaPenjualanHomeMouseClicked
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessSkemaPenjualan);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_imageSkemaPenjualanHomeMouseClicked

    private void labelSkemaPenjualanHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSkemaPenjualanHomeMouseClicked
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessSkemaPenjualan);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_labelSkemaPenjualanHomeMouseClicked

    private void panelSkemaPenjualanHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSkemaPenjualanHomeMouseClicked
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessSkemaPenjualan);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_panelSkemaPenjualanHomeMouseClicked

    private void imageDashboardHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageDashboardHomeMouseClicked
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessDashboard);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_imageDashboardHomeMouseClicked

    private void labelDashboardHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelDashboardHomeMouseClicked
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessDashboard);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_labelDashboardHomeMouseClicked

    private void panelDashboardHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDashboardHomeMouseClicked
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessDashboard);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_panelDashboardHomeMouseClicked

    private void imageSettingHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageSettingHomeMouseClicked
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessSetting);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_imageSettingHomeMouseClicked

    private void labelSettingHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSettingHomeMouseClicked
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessSetting);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_labelSettingHomeMouseClicked

    private void panelSettingHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSettingHomeMouseClicked
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessSetting);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_panelSettingHomeMouseClicked

    private void imageTransaksiHome1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageTransaksiHome1MouseClicked
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessTransaksi);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_imageTransaksiHome1MouseClicked

    private void imageSkemaPenjualanHome1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageSkemaPenjualanHome1MouseClicked
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessSkemaPenjualan);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_imageSkemaPenjualanHome1MouseClicked

    private void labelSkemaPenjualanHome1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSkemaPenjualanHome1MouseClicked
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessSkemaPenjualan);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_labelSkemaPenjualanHome1MouseClicked

    private void panelSkemaPenjualanHome1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSkemaPenjualanHome1MouseClicked
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessSkemaPenjualan);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_panelSkemaPenjualanHome1MouseClicked

    private void labelTransaksiHome1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTransaksiHome1MouseClicked
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessTransaksi);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_labelTransaksiHome1MouseClicked

    private void panelTransaksiHome1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTransaksiHome1MouseClicked
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessTransaksi);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_panelTransaksiHome1MouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        homeAccess.removeAll();
        homeAccess.add(homeUser);
        homeAccess.repaint();
        homeAccess.revalidate();
    }//GEN-LAST:event_button1ActionPerformed

    private void buttonSimpanProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanProfileActionPerformed
        String IDPengguna = fieldIDPenggunaProfile.getText();
        String Username = fieldUsernameProfile.getText();
        String Name = fieldNamaProfile.getText();
        String Email = fieldEmailProfile.getText();
        String Password = fieldPasswordProfile.getText();
        String TipeAkun = fieldTipeAkunProfile.getText();
        String NoTelphone = fieldNoTelphoneProfile.getText();
        String Alamat = textPaneAlamatProfile.getText();

        if(Username.isEmpty()){
            JOptionPane.showMessageDialog(null,"Username Tidak Boleh Kosong");
            fieldUsernameProfile.requestFocus();
        } else if(Name.isEmpty()){
            JOptionPane.showMessageDialog(null,"Name Tidak Boleh Kosong");
            fieldNamaProfile.requestFocus();
        } else if(Email.isEmpty()){
            JOptionPane.showMessageDialog(null,"Email Tidak Boleh Kosong");
            fieldEmailProfile.requestFocus();
        } else if(Password.isEmpty()){
            JOptionPane.showMessageDialog(null,"Password Tidak Boleh Kosong");
            fieldPasswordProfile.requestFocus();
        } else{

            try{
                Statement statement = (Statement)connect.GetConnection().createStatement();
                statement.executeUpdate("UPDATE data_pengguna SET username='"+ Username +"', password='"+ Password +"', nama_pengguna='"+ Name +"', email='"+ Email +"', no_telphone='"+ NoTelphone +"',alamat='"+ Alamat +"' , tipe_akun='"+ TipeAkun +"' WHERE id_pengguna='"+ IDPengguna +"';");

                //                DataTableManagementAkun();
                //                main.gbrandapplication.homeLabelUsername.setText(Username);
                statement.close ();
            } catch (Exception t){
                JOptionPane.showMessageDialog(null, "data gagal disimpan");
            }

        }
    }//GEN-LAST:event_buttonSimpanProfileActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        int dialogButton =JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "ANDA YAKIN AKAN KELUAR ","PERINGATAN", dialogButton);
        
        if (dialogResult == 0){
            mainAccessPanel.removeAll();
            mainAccessPanel.add(accessLogin);
            mainAccessPanel.repaint();
            mainAccessPanel.revalidate();

            homeAccess.removeAll();
            homeAccess.add(homeUser);
            homeAccess.repaint();
            homeAccess.revalidate();
            
            main.panelLogin.fieldUsername.requestFocus();
            main.panelLogin.fieldUsername.setText("");
            main.panelLogin.fieldPassword.setText("");
        }else{
            this.getRootPane().setDefaultButton(button2);
        }
    }//GEN-LAST:event_button2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button button1;
    private component.swing.button button2;
    private component.swing.button buttonSimpanProfile;
    public static component.swing.passwordFieldMain fieldConfirmationPasswordProfile;
    public static component.swing.textFieldMain fieldEmailProfile;
    public static javax.swing.JTextField fieldIDPenggunaProfile;
    public static component.swing.textFieldMain fieldNamaProfile;
    public static component.swing.textFieldMain fieldNoTelphoneProfile;
    public static component.swing.passwordFieldMain fieldPasswordProfile;
    public static component.swing.textFieldMain fieldTipeAkunProfile;
    public static component.swing.textFieldMain fieldUsernameProfile;
    public static javax.swing.JPanel homeAccess;
    public static javax.swing.JPanel homeAdministrator;
    public static javax.swing.JPanel homeKaryawan;
    private javax.swing.JPanel homeProfile;
    public static javax.swing.JPanel homeUser;
    private javax.swing.JLabel imageDashboardHome;
    private component.swing.imageItem imageItem1;
    private component.swing.imageItem imageItem2;
    private component.swing.imageItem imageProfileHome;
    private javax.swing.JLabel imageSettingHome;
    private javax.swing.JLabel imageSkemaPenjualanHome;
    private javax.swing.JLabel imageSkemaPenjualanHome1;
    private javax.swing.JLabel imageTransaksiHome;
    private javax.swing.JLabel imageTransaksiHome1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDashboardHome;
    private javax.swing.JLabel labelProfileHome;
    private javax.swing.JLabel labelSettingHome;
    private javax.swing.JLabel labelSkemaPenjualanHome;
    private javax.swing.JLabel labelSkemaPenjualanHome1;
    private javax.swing.JLabel labelTransaksiHome;
    private javax.swing.JLabel labelTransaksiHome1;
    private component.swing.panelRound panelDashboardHome;
    private component.swing.panelGradient panelGradient1;
    private component.swing.panelRound panelRound1;
    private component.swing.panelRound panelRound3;
    private component.swing.panelRound panelSettingHome;
    private component.swing.panelRound panelSkemaPenjualanHome;
    private component.swing.panelRound panelSkemaPenjualanHome1;
    private component.swing.panelRound panelTransaksiHome;
    private component.swing.panelRound panelTransaksiHome1;
    private component.swing.panelTransparent panelTransparent2;
    public static javax.swing.JTextPane textPaneAlamatProfile;
    private javax.swing.JLabel titleIconProfile;
    // End of variables declaration//GEN-END:variables
}
