package main;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import system.massage.popup.dialogLupaPassword;
import service.connect;
import system.notification.Notification;

public class test extends javax.swing.JFrame {

    public test() {
        initComponents();
        
        titleBar.init(this);
        
        this.getRootPane().setDefaultButton(buttonLogin);
        
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        showNotification = new javax.swing.JToggleButton();
        mainBackgroundPanel = new component.swing.panelRound();
        titleBar = new component.model.titleBar.titleBar();
        mainAccessPanel = new javax.swing.JPanel();
        accessBeforeLogin = new javax.swing.JPanel();
        panelCoverLogin = new component.swing.panelTransparent();
        panelLogin = new component.swing.panelRound();
        iconLogin = new javax.swing.JLabel();
        buttonLogin = new component.swing.button();
        labelLupaPassword = new javax.swing.JLabel();
        panelRound1 = new component.swing.panelRound();
        fieldUsername = new component.swing.textField();
        panelRound2 = new component.swing.panelRound();
        fieldPassword = new component.swing.passwordField();
        accessAfterLogin = new component.swing.panelTransparent();
        accessHome = new javax.swing.JPanel();
        mainHome = new javax.swing.JPanel();
        homeAdministrator = new javax.swing.JPanel();
        panelCardTransaksi = new component.swing.panelCard();
        buttonCardTransaksi = new component.swing.button();
        labelCardTransaksi = new javax.swing.JLabel();
        panelCardSkemaPenjualan = new component.swing.panelCard();
        buttonCardSkemaPenjualan = new component.swing.button();
        labelCardSkemaPenjualan = new javax.swing.JLabel();
        panelCardDashboard = new component.swing.panelCard();
        buttonCardDashboard = new component.swing.button();
        labelCardDashboard = new javax.swing.JLabel();
        panelCardSetting = new component.swing.panelCard();
        buttonCardSetting = new component.swing.button();
        labelCardSetting = new javax.swing.JLabel();
        homeKaryawan = new javax.swing.JPanel();
        panelCard5 = new component.swing.panelCard();
        button5 = new component.swing.button();
        jLabel6 = new javax.swing.JLabel();
        panelCard6 = new component.swing.panelCard();
        button6 = new component.swing.button();
        jLabel7 = new javax.swing.JLabel();
        accessTransaksi = new javax.swing.JPanel();
        panelTransaksi1 = new main.access.panelTransaksi();
        accessSkemaPenjualan = new javax.swing.JPanel();
        panelSkemaPenjualan1 = new main.access.panelSkemaPenjualan();
        accessDashboard = new javax.swing.JPanel();
        panelRound4 = new component.swing.panelRound();
        kornerDashboard = new javax.swing.JPanel();
        l = new javax.swing.JLabel();
        buttonClose = new component.swing.button();
        dashboardNavPanel = new component.swing.panelGradient();
        buttonDataBarangDashboard = new component.swing.button();
        buttonDataPenjualanDashboard = new component.swing.button();
        buttonDataPembelianDashboard = new component.swing.button();
        buttonDataPengeluaranDashboard = new component.swing.button();
        buttonDataSupplierDashboard = new component.swing.button();
        buttonKategoriDashboard = new component.swing.button();
        buttonLaporanDashboard = new component.swing.button();
        dashboardMainAccess = new javax.swing.JPanel();
        panelDataBarang1 = new main.access.panelDataBarang();
        panelDataPenjualan1 = new report.panelDataPenjualan();
        panelDataPembelian1 = new report.panelDataPembelian();
        panelDataPengeluaran1 = new report.panelDataPengeluaran();
        panelDataSupplier1 = new report.panelDataSupplier();
        panelKategori1 = new main.access.panelKategori();
        accessSetting = new javax.swing.JPanel();
        panelRound3 = new component.swing.panelRound();
        kornerSetting = new javax.swing.JPanel();
        l1 = new javax.swing.JLabel();
        buttonClose1 = new component.swing.button();
        settingMainPanel = new javax.swing.JPanel();
        panelManagementAkun1 = new main.access.panelManagementAkun();
        settingNavPanel = new component.swing.panelGradient();
        buttonBantuanSetting = new component.swing.button();
        buttonManagementAkunSetting = new component.swing.button();
        buttonTambahAkunSetting = new component.swing.button();
        buttonThemeSetting = new component.swing.button();
        buttonTentangSetting = new component.swing.button();
        imageBackground = new component.swing.imageItem();

        showNotification.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainBackgroundPanel.setShadowSize(new java.awt.Insets(5, 5, 5, 5));
        mainBackgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleBar.setOpaque(false);
        mainBackgroundPanel.add(titleBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 10, 1010, -1));

        mainAccessPanel.setOpaque(false);
        mainAccessPanel.setLayout(new java.awt.CardLayout());

        accessBeforeLogin.setOpaque(false);

        panelCoverLogin.setAlpha(0.8F);

        panelLogin.setShadowSize(new java.awt.Insets(5, 5, 5, 5));

        iconLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/profile-m.png"))); // NOI18N

        buttonLogin.setBackground(new java.awt.Color(48, 144, 216));
        buttonLogin.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogin.setText("LOGIN");
        buttonLogin.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        labelLupaPassword.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        labelLupaPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLupaPassword.setText("Lupa Password ?");
        labelLupaPassword.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelLupaPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLupaPasswordMouseClicked(evt);
            }
        });

        panelRound1.setBackground(new java.awt.Color(238, 238, 238));
        panelRound1.setShadowColor(new java.awt.Color(153, 153, 153));

        fieldUsername.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldUsername.setLabelText("Username");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(fieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelRound2.setBackground(new java.awt.Color(238, 238, 238));
        panelRound2.setShadowColor(new java.awt.Color(153, 153, 153));

        fieldPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldPassword.setLabelText("Password");
        fieldPassword.setShowAndHide(true);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iconLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(labelLupaPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(iconLogin)
                .addGap(18, 18, 18)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelLupaPassword)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelCoverLoginLayout = new javax.swing.GroupLayout(panelCoverLogin);
        panelCoverLogin.setLayout(panelCoverLoginLayout);
        panelCoverLoginLayout.setHorizontalGroup(
            panelCoverLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelCoverLoginLayout.setVerticalGroup(
            panelCoverLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout accessBeforeLoginLayout = new javax.swing.GroupLayout(accessBeforeLogin);
        accessBeforeLogin.setLayout(accessBeforeLoginLayout);
        accessBeforeLoginLayout.setHorizontalGroup(
            accessBeforeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accessBeforeLoginLayout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(panelCoverLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(280, 280, 280))
        );
        accessBeforeLoginLayout.setVerticalGroup(
            accessBeforeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accessBeforeLoginLayout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(panelCoverLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        mainAccessPanel.add(accessBeforeLogin, "card2");

        accessAfterLogin.setAlpha(0.5F);
        accessAfterLogin.setPreferredSize(new java.awt.Dimension(1010, 590));
        accessAfterLogin.setLayout(new java.awt.CardLayout());

        accessHome.setOpaque(false);

        mainHome.setOpaque(false);
        mainHome.setLayout(new java.awt.CardLayout());

        homeAdministrator.setOpaque(false);

        panelCardTransaksi.setRound(25);
        panelCardTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCardTransaksiMouseClicked(evt);
            }
        });

        buttonCardTransaksi.setBackground(new java.awt.Color(238, 238, 238));
        buttonCardTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/shopping.png"))); // NOI18N
        buttonCardTransaksi.setRound(25);
        buttonCardTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCardTransaksiActionPerformed(evt);
            }
        });

        labelCardTransaksi.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        labelCardTransaksi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCardTransaksi.setText("Transaksi");
        labelCardTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCardTransaksiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCardTransaksiLayout = new javax.swing.GroupLayout(panelCardTransaksi);
        panelCardTransaksi.setLayout(panelCardTransaksiLayout);
        panelCardTransaksiLayout.setHorizontalGroup(
            panelCardTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardTransaksiLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelCardTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonCardTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(labelCardTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        panelCardTransaksiLayout.setVerticalGroup(
            panelCardTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardTransaksiLayout.createSequentialGroup()
                .addComponent(buttonCardTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCardTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panelCardSkemaPenjualan.setRound(25);
        panelCardSkemaPenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCardSkemaPenjualanMouseClicked(evt);
            }
        });

        buttonCardSkemaPenjualan.setBackground(new java.awt.Color(238, 238, 238));
        buttonCardSkemaPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/monitor.png"))); // NOI18N
        buttonCardSkemaPenjualan.setRound(25);
        buttonCardSkemaPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCardSkemaPenjualanActionPerformed(evt);
            }
        });

        labelCardSkemaPenjualan.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        labelCardSkemaPenjualan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCardSkemaPenjualan.setText("Skema Penjualan");
        labelCardSkemaPenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCardSkemaPenjualanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCardSkemaPenjualanLayout = new javax.swing.GroupLayout(panelCardSkemaPenjualan);
        panelCardSkemaPenjualan.setLayout(panelCardSkemaPenjualanLayout);
        panelCardSkemaPenjualanLayout.setHorizontalGroup(
            panelCardSkemaPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardSkemaPenjualanLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(buttonCardSkemaPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCardSkemaPenjualanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCardSkemaPenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCardSkemaPenjualanLayout.setVerticalGroup(
            panelCardSkemaPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardSkemaPenjualanLayout.createSequentialGroup()
                .addComponent(buttonCardSkemaPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(labelCardSkemaPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelCardDashboard.setRound(25);
        panelCardDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCardDashboardMouseClicked(evt);
            }
        });

        buttonCardDashboard.setBackground(new java.awt.Color(238, 238, 238));
        buttonCardDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/admin.png"))); // NOI18N
        buttonCardDashboard.setRound(25);
        buttonCardDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCardDashboardActionPerformed(evt);
            }
        });

        labelCardDashboard.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        labelCardDashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCardDashboard.setText("Dashboard");
        labelCardDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCardDashboardMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCardDashboardLayout = new javax.swing.GroupLayout(panelCardDashboard);
        panelCardDashboard.setLayout(panelCardDashboardLayout);
        panelCardDashboardLayout.setHorizontalGroup(
            panelCardDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardDashboardLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelCardDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonCardDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(labelCardDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        panelCardDashboardLayout.setVerticalGroup(
            panelCardDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardDashboardLayout.createSequentialGroup()
                .addComponent(buttonCardDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCardDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panelCardSetting.setRound(25);
        panelCardSetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCardSettingMouseClicked(evt);
            }
        });

        buttonCardSetting.setBackground(new java.awt.Color(238, 238, 238));
        buttonCardSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/cogwheel.png"))); // NOI18N
        buttonCardSetting.setRound(25);
        buttonCardSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCardSettingActionPerformed(evt);
            }
        });

        labelCardSetting.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        labelCardSetting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCardSetting.setText("Setting");
        labelCardSetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCardSettingMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCardSettingLayout = new javax.swing.GroupLayout(panelCardSetting);
        panelCardSetting.setLayout(panelCardSettingLayout);
        panelCardSettingLayout.setHorizontalGroup(
            panelCardSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardSettingLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelCardSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonCardSetting, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(labelCardSetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCardSettingLayout.setVerticalGroup(
            panelCardSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardSettingLayout.createSequentialGroup()
                .addComponent(buttonCardSetting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCardSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout homeAdministratorLayout = new javax.swing.GroupLayout(homeAdministrator);
        homeAdministrator.setLayout(homeAdministratorLayout);
        homeAdministratorLayout.setHorizontalGroup(
            homeAdministratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeAdministratorLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(homeAdministratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCardTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelCardDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addGroup(homeAdministratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCardSkemaPenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCardSetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
        );
        homeAdministratorLayout.setVerticalGroup(
            homeAdministratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeAdministratorLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(homeAdministratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCardSkemaPenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCardTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(homeAdministratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCardDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCardSetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );

        mainHome.add(homeAdministrator, "card2");

        homeKaryawan.setOpaque(false);

        panelCard5.setRound(25);

        button5.setBackground(new java.awt.Color(238, 238, 238));
        button5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/shopping.png"))); // NOI18N
        button5.setRound(25);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Transaksi");

        javax.swing.GroupLayout panelCard5Layout = new javax.swing.GroupLayout(panelCard5);
        panelCard5.setLayout(panelCard5Layout);
        panelCard5Layout.setHorizontalGroup(
            panelCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCard5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button5, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        panelCard5Layout.setVerticalGroup(
            panelCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCard5Layout.createSequentialGroup()
                .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panelCard6.setRound(25);

        button6.setBackground(new java.awt.Color(238, 238, 238));
        button6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/monitor.png"))); // NOI18N
        button6.setRound(25);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Skema Penjualan");

        javax.swing.GroupLayout panelCard6Layout = new javax.swing.GroupLayout(panelCard6);
        panelCard6.setLayout(panelCard6Layout);
        panelCard6Layout.setHorizontalGroup(
            panelCard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCard6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCard6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCard6Layout.setVerticalGroup(
            panelCard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCard6Layout.createSequentialGroup()
                .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout homeKaryawanLayout = new javax.swing.GroupLayout(homeKaryawan);
        homeKaryawan.setLayout(homeKaryawanLayout);
        homeKaryawanLayout.setHorizontalGroup(
            homeKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
            .addGroup(homeKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(homeKaryawanLayout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(panelCard5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(86, 86, 86)
                    .addComponent(panelCard6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(69, 69, 69)))
        );
        homeKaryawanLayout.setVerticalGroup(
            homeKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
            .addGroup(homeKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(homeKaryawanLayout.createSequentialGroup()
                    .addGap(186, 186, 186)
                    .addGroup(homeKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panelCard6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelCard5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(186, Short.MAX_VALUE)))
        );

        mainHome.add(homeKaryawan, "card3");

        javax.swing.GroupLayout accessHomeLayout = new javax.swing.GroupLayout(accessHome);
        accessHome.setLayout(accessHomeLayout);
        accessHomeLayout.setHorizontalGroup(
            accessHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accessHomeLayout.createSequentialGroup()
                .addComponent(mainHome, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(327, 327, 327))
        );
        accessHomeLayout.setVerticalGroup(
            accessHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        accessAfterLogin.add(accessHome, "card2");

        accessTransaksi.setOpaque(false);

        javax.swing.GroupLayout accessTransaksiLayout = new javax.swing.GroupLayout(accessTransaksi);
        accessTransaksi.setLayout(accessTransaksiLayout);
        accessTransaksiLayout.setHorizontalGroup(
            accessTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accessTransaksiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelTransaksi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        accessTransaksiLayout.setVerticalGroup(
            accessTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accessTransaksiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelTransaksi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        accessAfterLogin.add(accessTransaksi, "card3");

        accessSkemaPenjualan.setOpaque(false);

        javax.swing.GroupLayout accessSkemaPenjualanLayout = new javax.swing.GroupLayout(accessSkemaPenjualan);
        accessSkemaPenjualan.setLayout(accessSkemaPenjualanLayout);
        accessSkemaPenjualanLayout.setHorizontalGroup(
            accessSkemaPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accessSkemaPenjualanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelSkemaPenjualan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        accessSkemaPenjualanLayout.setVerticalGroup(
            accessSkemaPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accessSkemaPenjualanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelSkemaPenjualan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        accessAfterLogin.add(accessSkemaPenjualan, "card4");

        accessDashboard.setOpaque(false);

        panelRound4.setShadowSize(new java.awt.Insets(5, 5, 5, 5));

        kornerDashboard.setOpaque(false);
        kornerDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        l.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/admin-smile.png"))); // NOI18N
        l.setText("Dashboard");
        l.setIconTextGap(15);
        kornerDashboard.add(l, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, 800, -1));

        buttonClose.setBackground(new java.awt.Color(255, 0, 0));
        buttonClose.setForeground(new java.awt.Color(255, 255, 255));
        buttonClose.setText("Close");
        buttonClose.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });
        kornerDashboard.add(buttonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(823, 25, 133, 55));

        dashboardNavPanel.setBackground(new java.awt.Color(204, 204, 204));
        dashboardNavPanel.setColorGradient(new java.awt.Color(153, 153, 153));

        buttonDataBarangDashboard.setText("Data Barang");
        buttonDataBarangDashboard.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonDataBarangDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataBarangDashboardActionPerformed(evt);
            }
        });
        dashboardNavPanel.add(buttonDataBarangDashboard);
        buttonDataBarangDashboard.setBounds(30, 30, 240, 50);

        buttonDataPenjualanDashboard.setText("Data Penjualan");
        buttonDataPenjualanDashboard.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonDataPenjualanDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataPenjualanDashboardActionPerformed(evt);
            }
        });
        dashboardNavPanel.add(buttonDataPenjualanDashboard);
        buttonDataPenjualanDashboard.setBounds(30, 90, 240, 50);

        buttonDataPembelianDashboard.setText("Data Pembelian");
        buttonDataPembelianDashboard.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonDataPembelianDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataPembelianDashboardActionPerformed(evt);
            }
        });
        dashboardNavPanel.add(buttonDataPembelianDashboard);
        buttonDataPembelianDashboard.setBounds(30, 150, 240, 50);

        buttonDataPengeluaranDashboard.setText("Data Pengeluaran");
        buttonDataPengeluaranDashboard.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonDataPengeluaranDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataPengeluaranDashboardActionPerformed(evt);
            }
        });
        dashboardNavPanel.add(buttonDataPengeluaranDashboard);
        buttonDataPengeluaranDashboard.setBounds(30, 210, 240, 50);

        buttonDataSupplierDashboard.setText("Data Supplier");
        buttonDataSupplierDashboard.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonDataSupplierDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataSupplierDashboardActionPerformed(evt);
            }
        });
        dashboardNavPanel.add(buttonDataSupplierDashboard);
        buttonDataSupplierDashboard.setBounds(30, 270, 240, 50);

        buttonKategoriDashboard.setText("Kategori");
        buttonKategoriDashboard.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonKategoriDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKategoriDashboardActionPerformed(evt);
            }
        });
        dashboardNavPanel.add(buttonKategoriDashboard);
        buttonKategoriDashboard.setBounds(30, 330, 240, 50);

        buttonLaporanDashboard.setText("Laporan");
        buttonLaporanDashboard.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonLaporanDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLaporanDashboardActionPerformed(evt);
            }
        });
        dashboardNavPanel.add(buttonLaporanDashboard);
        buttonLaporanDashboard.setBounds(30, 390, 240, 50);

        dashboardMainAccess.setOpaque(false);
        dashboardMainAccess.setLayout(new java.awt.CardLayout());
        dashboardMainAccess.add(panelDataBarang1, "card2");
        dashboardMainAccess.add(panelDataPenjualan1, "card3");
        dashboardMainAccess.add(panelDataPembelian1, "card4");
        dashboardMainAccess.add(panelDataPengeluaran1, "card7");
        dashboardMainAccess.add(panelDataSupplier1, "card6");
        dashboardMainAccess.add(panelKategori1, "card7");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kornerDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addComponent(dashboardMainAccess, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dashboardNavPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addComponent(kornerDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dashboardNavPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addComponent(dashboardMainAccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout accessDashboardLayout = new javax.swing.GroupLayout(accessDashboard);
        accessDashboard.setLayout(accessDashboardLayout);
        accessDashboardLayout.setHorizontalGroup(
            accessDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        accessDashboardLayout.setVerticalGroup(
            accessDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        accessAfterLogin.add(accessDashboard, "card5");

        accessSetting.setOpaque(false);

        panelRound3.setShadowSize(new java.awt.Insets(5, 5, 5, 5));

        kornerSetting.setOpaque(false);
        kornerSetting.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l1.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/setting-smile.png"))); // NOI18N
        l1.setText("Setting");
        l1.setIconTextGap(15);
        kornerSetting.add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, 800, -1));

        buttonClose1.setBackground(new java.awt.Color(255, 0, 0));
        buttonClose1.setForeground(new java.awt.Color(255, 255, 255));
        buttonClose1.setText("Close");
        buttonClose1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClose1ActionPerformed(evt);
            }
        });
        kornerSetting.add(buttonClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(823, 25, 133, 55));

        settingMainPanel.setOpaque(false);
        settingMainPanel.setLayout(new java.awt.CardLayout());
        settingMainPanel.add(panelManagementAkun1, "card2");

        settingNavPanel.setBackground(new java.awt.Color(204, 204, 204));
        settingNavPanel.setColorGradient(new java.awt.Color(153, 153, 153));

        buttonBantuanSetting.setText("Bantuan");
        buttonBantuanSetting.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonBantuanSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBantuanSettingActionPerformed(evt);
            }
        });
        settingNavPanel.add(buttonBantuanSetting);
        buttonBantuanSetting.setBounds(30, 30, 240, 50);

        buttonManagementAkunSetting.setText("Management Akun");
        buttonManagementAkunSetting.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonManagementAkunSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonManagementAkunSettingActionPerformed(evt);
            }
        });
        settingNavPanel.add(buttonManagementAkunSetting);
        buttonManagementAkunSetting.setBounds(30, 90, 240, 50);

        buttonTambahAkunSetting.setText("Tambah Akun");
        buttonTambahAkunSetting.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonTambahAkunSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahAkunSettingActionPerformed(evt);
            }
        });
        settingNavPanel.add(buttonTambahAkunSetting);
        buttonTambahAkunSetting.setBounds(30, 150, 240, 50);

        buttonThemeSetting.setText("Theme");
        buttonThemeSetting.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonThemeSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThemeSettingActionPerformed(evt);
            }
        });
        settingNavPanel.add(buttonThemeSetting);
        buttonThemeSetting.setBounds(30, 210, 240, 50);

        buttonTentangSetting.setText("Tentang");
        buttonTentangSetting.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonTentangSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTentangSettingActionPerformed(evt);
            }
        });
        settingNavPanel.add(buttonTentangSetting);
        buttonTentangSetting.setBounds(30, 270, 240, 50);

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addComponent(kornerSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addComponent(settingMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(settingNavPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addComponent(kornerSetting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(settingNavPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(settingMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout accessSettingLayout = new javax.swing.GroupLayout(accessSetting);
        accessSetting.setLayout(accessSettingLayout);
        accessSettingLayout.setHorizontalGroup(
            accessSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        accessSettingLayout.setVerticalGroup(
            accessSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accessSettingLayout.createSequentialGroup()
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        accessAfterLogin.add(accessSetting, "card6");

        mainAccessPanel.add(accessAfterLogin, "card3");

        mainBackgroundPanel.add(mainAccessPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 1010, 590));

        imageBackground.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/wallpaper/LogoBackground.png"))); // NOI18N

        javax.swing.GroupLayout imageBackgroundLayout = new javax.swing.GroupLayout(imageBackground);
        imageBackground.setLayout(imageBackgroundLayout);
        imageBackgroundLayout.setHorizontalGroup(
            imageBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        imageBackgroundLayout.setVerticalGroup(
            imageBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        mainBackgroundPanel.add(imageBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1030, 630));

        getContentPane().add(mainBackgroundPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        try{
            Statement getLogin = (Statement)connect.GetConnection().createStatement();
            ResultSet rest = getLogin.executeQuery("SELECT * FROM data_pengguna WHERE username = '" + fieldUsername.getText() + "'");
            if(rest.next()){
                if(fieldPassword.getText().equals(rest.getString("password"))){

                    mainAccessPanel.removeAll();
                    mainAccessPanel.add(accessAfterLogin);
                    mainAccessPanel.repaint();
                    mainAccessPanel.revalidate();
                    
                    if(rest.getString("tipe_akun").equals("Administrator")){
                        mainHome.removeAll();
                        mainHome.add(homeAdministrator);
                        mainHome.repaint();
                        mainHome.revalidate();
                    } else {
                        mainHome.removeAll();
                        mainHome.add(homeKaryawan);
                        mainHome.repaint();
                        mainHome.revalidate();
                    }
//                    
//                    accessHome.removeAll();
//                    accessHome.repaint();
//                    accessHome.revalidate();
//                    
//                    accessHome.add(panelTransaksi1);
//                    accessHome.repaint();
//                    accessHome.revalidate();
//                    
//                    homeLabelUsername.setText(rest.getString("Username"));
//                    homeLabelTipeAkun.setText(rest.getString("TypeAkun"));
//                    
//                    system.panelProfile.profileUsername.setText(rest.getString("Username"));
//                    system.panelProfile.profileName.setText(rest.getString("Name"));
//                    system.panelProfile.profileEmail.setText(rest.getString("Email"));
//                    system.panelProfile.profilePassword.setText(rest.getString("Password"));
//                    system.panelProfile.profileTipeAkun.setText(rest.getString("TypeAkun"));

                    system.massage.popup.popupLogin wellcome = new system.massage.popup.popupLogin(this, true);
                    system.massage.popup.popupLogin.labelSelamatDatang.setText(rest.getString("nama_pengguna"));
                    wellcome.showAlert();               
                } else {
                    fieldUsername.requestFocus();
                    fieldPassword.setText("");
                    Notification notif = new Notification(this, Notification.Type.INFO, Notification.Location.TOP_CENTER, "Password yang anda masukkan salah !");
                    notif.showNotification();   
                }
            } else {
                fieldUsername.requestFocus();
                fieldUsername.setText("");
                Notification notif = new Notification(this, Notification.Type.INFO, Notification.Location.TOP_CENTER, "Username tidak ditemukan !");
                notif.showNotification();
            }
        } catch (SQLException ex) {
            Notification notif = new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Koneksi Databases Error !");
            notif.showNotification();
        }
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void labelLupaPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLupaPasswordMouseClicked
        dialogLupaPassword message = new dialogLupaPassword(this);
        message.showMessage("Lupa Password ?", "Verify Username and Email \n for Your User to change Password.");
    }//GEN-LAST:event_labelLupaPasswordMouseClicked

    private void buttonCardTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCardTransaksiActionPerformed
        accessAfterLogin.removeAll();
        accessAfterLogin.add(accessTransaksi);
        accessAfterLogin.repaint();
        accessAfterLogin.revalidate();
    }//GEN-LAST:event_buttonCardTransaksiActionPerformed

    private void labelCardTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCardTransaksiMouseClicked
        accessAfterLogin.removeAll();
        accessAfterLogin.add(accessTransaksi);
        accessAfterLogin.repaint();
        accessAfterLogin.revalidate();
    }//GEN-LAST:event_labelCardTransaksiMouseClicked

    private void panelCardTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCardTransaksiMouseClicked
        accessAfterLogin.removeAll();
        accessAfterLogin.add(accessTransaksi);
        accessAfterLogin.repaint();
        accessAfterLogin.revalidate();
    }//GEN-LAST:event_panelCardTransaksiMouseClicked

    private void buttonCardSkemaPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCardSkemaPenjualanActionPerformed
        accessAfterLogin.removeAll();
        accessAfterLogin.add(accessSkemaPenjualan);
        accessAfterLogin.repaint();
        accessAfterLogin.revalidate();
    }//GEN-LAST:event_buttonCardSkemaPenjualanActionPerformed

    private void labelCardSkemaPenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCardSkemaPenjualanMouseClicked
        accessAfterLogin.removeAll();
        accessAfterLogin.add(accessSkemaPenjualan);
        accessAfterLogin.repaint();
        accessAfterLogin.revalidate();
    }//GEN-LAST:event_labelCardSkemaPenjualanMouseClicked

    private void panelCardSkemaPenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCardSkemaPenjualanMouseClicked
        accessAfterLogin.removeAll();
        accessAfterLogin.add(accessSkemaPenjualan);
        accessAfterLogin.repaint();
        accessAfterLogin.revalidate();
    }//GEN-LAST:event_panelCardSkemaPenjualanMouseClicked

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        accessAfterLogin.removeAll();
        accessAfterLogin.add(accessHome);
        accessAfterLogin.repaint();
        accessAfterLogin.revalidate();
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void buttonDataBarangDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataBarangDashboardActionPerformed
        dashboardMainAccess.removeAll();
        dashboardMainAccess.add(panelDataBarang1);
        dashboardMainAccess.repaint();
        dashboardMainAccess.revalidate();
    }//GEN-LAST:event_buttonDataBarangDashboardActionPerformed

    private void buttonDataPenjualanDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataPenjualanDashboardActionPerformed
        dashboardMainAccess.removeAll();
        dashboardMainAccess.add(panelDataPenjualan1);
        dashboardMainAccess.repaint();
        dashboardMainAccess.revalidate();
    }//GEN-LAST:event_buttonDataPenjualanDashboardActionPerformed

    private void buttonDataPembelianDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataPembelianDashboardActionPerformed
        dashboardMainAccess.removeAll();
        dashboardMainAccess.add(panelDataPembelian1);
        dashboardMainAccess.repaint();
        dashboardMainAccess.revalidate();
    }//GEN-LAST:event_buttonDataPembelianDashboardActionPerformed

    private void buttonDataPengeluaranDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataPengeluaranDashboardActionPerformed
        dashboardMainAccess.removeAll();
        dashboardMainAccess.add(panelDataPengeluaran1);
        dashboardMainAccess.repaint();
        dashboardMainAccess.revalidate();
    }//GEN-LAST:event_buttonDataPengeluaranDashboardActionPerformed

    private void buttonDataSupplierDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataSupplierDashboardActionPerformed
        dashboardMainAccess.removeAll();
        dashboardMainAccess.add(panelDataSupplier1);
        dashboardMainAccess.repaint();
        dashboardMainAccess.revalidate();
    }//GEN-LAST:event_buttonDataSupplierDashboardActionPerformed

    private void buttonKategoriDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKategoriDashboardActionPerformed
        dashboardMainAccess.removeAll();
        dashboardMainAccess.add(panelKategori1);
        dashboardMainAccess.repaint();
        dashboardMainAccess.revalidate();
    }//GEN-LAST:event_buttonKategoriDashboardActionPerformed

    private void buttonLaporanDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLaporanDashboardActionPerformed
        dashboardMainAccess.removeAll();
//        dashboardMainAccess.add(panelDataBarang1);
        dashboardMainAccess.repaint();
        dashboardMainAccess.revalidate();
    }//GEN-LAST:event_buttonLaporanDashboardActionPerformed

    private void buttonCardDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCardDashboardActionPerformed
        accessAfterLogin.removeAll();
        accessAfterLogin.add(accessDashboard);
        accessAfterLogin.repaint();
        accessAfterLogin.revalidate();
    }//GEN-LAST:event_buttonCardDashboardActionPerformed

    private void labelCardDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCardDashboardMouseClicked
        accessAfterLogin.removeAll();
        accessAfterLogin.add(accessDashboard);
        accessAfterLogin.repaint();
        accessAfterLogin.revalidate();
    }//GEN-LAST:event_labelCardDashboardMouseClicked

    private void panelCardDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCardDashboardMouseClicked
        accessAfterLogin.removeAll();
        accessAfterLogin.add(accessDashboard);
        accessAfterLogin.repaint();
        accessAfterLogin.revalidate();
    }//GEN-LAST:event_panelCardDashboardMouseClicked

    private void buttonCardSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCardSettingActionPerformed
        accessAfterLogin.removeAll();
        accessAfterLogin.add(accessSetting);
        accessAfterLogin.repaint();
        accessAfterLogin.revalidate();
    }//GEN-LAST:event_buttonCardSettingActionPerformed

    private void labelCardSettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCardSettingMouseClicked
        accessAfterLogin.removeAll();
        accessAfterLogin.add(accessSetting);
        accessAfterLogin.repaint();
        accessAfterLogin.revalidate();
    }//GEN-LAST:event_labelCardSettingMouseClicked

    private void panelCardSettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCardSettingMouseClicked
        accessAfterLogin.removeAll();
        accessAfterLogin.add(accessSetting);
        accessAfterLogin.repaint();
        accessAfterLogin.revalidate();
    }//GEN-LAST:event_panelCardSettingMouseClicked

    private void buttonClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClose1ActionPerformed
        accessAfterLogin.removeAll();
        accessAfterLogin.add(accessHome);
        accessAfterLogin.repaint();
        accessAfterLogin.revalidate();
    }//GEN-LAST:event_buttonClose1ActionPerformed

    private void buttonBantuanSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBantuanSettingActionPerformed
        settingMainPanel.removeAll();
        settingMainPanel.add(panelManagementAkun1);
        settingMainPanel.repaint();
        settingMainPanel.revalidate();
    }//GEN-LAST:event_buttonBantuanSettingActionPerformed

    private void buttonManagementAkunSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonManagementAkunSettingActionPerformed
        settingMainPanel.removeAll();
        settingMainPanel.add(panelManagementAkun1);
        settingMainPanel.repaint();
        settingMainPanel.revalidate();
    }//GEN-LAST:event_buttonManagementAkunSettingActionPerformed

    private void buttonTambahAkunSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahAkunSettingActionPerformed
        settingMainPanel.removeAll();
        settingMainPanel.add(panelManagementAkun1);
        settingMainPanel.repaint();
        settingMainPanel.revalidate();
    }//GEN-LAST:event_buttonTambahAkunSettingActionPerformed

    private void buttonThemeSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThemeSettingActionPerformed
        settingMainPanel.removeAll();
        settingMainPanel.add(panelManagementAkun1);
        settingMainPanel.repaint();
        settingMainPanel.revalidate();
    }//GEN-LAST:event_buttonThemeSettingActionPerformed

    private void buttonTentangSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTentangSettingActionPerformed
        settingMainPanel.removeAll();
        settingMainPanel.add(panelManagementAkun1);
        settingMainPanel.repaint();
        settingMainPanel.revalidate();
    }//GEN-LAST:event_buttonTentangSettingActionPerformed

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
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fram = new test();
                new test().setVisible(true);
            }
        });
    }
    
    private static JFrame fram;
    
    public static JFrame getJFram(){
        return fram;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static component.swing.panelTransparent accessAfterLogin;
    private javax.swing.JPanel accessBeforeLogin;
    private javax.swing.JPanel accessDashboard;
    public static javax.swing.JPanel accessHome;
    private javax.swing.JPanel accessSetting;
    private javax.swing.JPanel accessSkemaPenjualan;
    private javax.swing.JPanel accessTransaksi;
    private component.swing.button button5;
    private component.swing.button button6;
    private component.swing.button buttonBantuanSetting;
    private component.swing.button buttonCardDashboard;
    private component.swing.button buttonCardSetting;
    private component.swing.button buttonCardSkemaPenjualan;
    private component.swing.button buttonCardTransaksi;
    private component.swing.button buttonClose;
    private component.swing.button buttonClose1;
    private component.swing.button buttonDataBarangDashboard;
    private component.swing.button buttonDataPembelianDashboard;
    private component.swing.button buttonDataPengeluaranDashboard;
    private component.swing.button buttonDataPenjualanDashboard;
    private component.swing.button buttonDataSupplierDashboard;
    private component.swing.button buttonKategoriDashboard;
    private component.swing.button buttonLaporanDashboard;
    private component.swing.button buttonLogin;
    private component.swing.button buttonManagementAkunSetting;
    private component.swing.button buttonTambahAkunSetting;
    private component.swing.button buttonTentangSetting;
    private component.swing.button buttonThemeSetting;
    private javax.swing.JPanel dashboardMainAccess;
    private component.swing.panelGradient dashboardNavPanel;
    private component.swing.passwordField fieldPassword;
    private component.swing.textField fieldUsername;
    private javax.swing.JPanel homeAdministrator;
    private javax.swing.JPanel homeKaryawan;
    private javax.swing.JLabel iconLogin;
    private component.swing.imageItem imageBackground;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel kornerDashboard;
    private javax.swing.JPanel kornerSetting;
    private javax.swing.JLabel l;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel labelCardDashboard;
    private javax.swing.JLabel labelCardSetting;
    private javax.swing.JLabel labelCardSkemaPenjualan;
    private javax.swing.JLabel labelCardTransaksi;
    private javax.swing.JLabel labelLupaPassword;
    private javax.swing.JPanel mainAccessPanel;
    public static component.swing.panelRound mainBackgroundPanel;
    private javax.swing.JPanel mainHome;
    private component.swing.panelCard panelCard5;
    private component.swing.panelCard panelCard6;
    private component.swing.panelCard panelCardDashboard;
    private component.swing.panelCard panelCardSetting;
    private component.swing.panelCard panelCardSkemaPenjualan;
    private component.swing.panelCard panelCardTransaksi;
    private component.swing.panelTransparent panelCoverLogin;
    private main.access.panelDataBarang panelDataBarang1;
    private report.panelDataPembelian panelDataPembelian1;
    private report.panelDataPengeluaran panelDataPengeluaran1;
    private report.panelDataPenjualan panelDataPenjualan1;
    private report.panelDataSupplier panelDataSupplier1;
    private main.access.panelKategori panelKategori1;
    private component.swing.panelRound panelLogin;
    private main.access.panelManagementAkun panelManagementAkun1;
    private component.swing.panelRound panelRound1;
    private component.swing.panelRound panelRound2;
    private component.swing.panelRound panelRound3;
    private component.swing.panelRound panelRound4;
    private main.access.panelSkemaPenjualan panelSkemaPenjualan1;
    private main.access.panelTransaksi panelTransaksi1;
    private javax.swing.JPanel settingMainPanel;
    private component.swing.panelGradient settingNavPanel;
    public static javax.swing.JToggleButton showNotification;
    private component.model.titleBar.titleBar titleBar;
    // End of variables declaration//GEN-END:variables
}
