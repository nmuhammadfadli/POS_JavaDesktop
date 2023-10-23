package main;

import com.sun.prism.impl.shape.BasicRoundRectRep;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import service.connect;

public class gbrandapplication extends javax.swing.JFrame {

    public gbrandapplication() {
        initComponents();
        
        titleBar.init(this);
        
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessLogin);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
        
        this.getRootPane().setDefaultButton(main.panelLogin.buttonLogin);
        
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new component.swing.panelGradient();
        mainPanel = new javax.swing.JPanel();
        titleBar = new component.model.titleBar.titleBar();
        mainAccessPanel = new javax.swing.JPanel();
        accessLogin = new javax.swing.JPanel();
        panelLogin1 = new main.panelLogin();
        accessHome = new javax.swing.JPanel();
        panelHome2 = new main.panelHome();
        accessTransaksi = new javax.swing.JPanel();
        panelTransaksi1 = new main.panelTransaksi();
        accessSkemaPenjualan = new javax.swing.JPanel();
        panelSkemaPenjualan1 = new main.panelSkemaPenjualan();
        accessDashboard = new javax.swing.JPanel();
        panelDashboard1 = new main.panelDashboard();
        accessSetting = new javax.swing.JPanel();
        panelSetting1 = new main.panelSetting();
        imageItem = new component.swing.imageItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        backgroundPanel.setBackground(new java.awt.Color(245, 245, 245));
        backgroundPanel.setColorGradient(new java.awt.Color(248, 248, 248));
        backgroundPanel.setRadius(35);

        mainPanel.setOpaque(false);

        mainAccessPanel.setOpaque(false);
        mainAccessPanel.setLayout(new java.awt.CardLayout());

        accessLogin.setOpaque(false);
        accessLogin.setLayout(new java.awt.BorderLayout());
        accessLogin.add(panelLogin1, java.awt.BorderLayout.CENTER);

        mainAccessPanel.add(accessLogin, "card2");

        accessHome.setOpaque(false);
        accessHome.add(panelHome2);

        mainAccessPanel.add(accessHome, "card3");

        accessTransaksi.setOpaque(false);
        accessTransaksi.add(panelTransaksi1);

        mainAccessPanel.add(accessTransaksi, "card4");

        accessSkemaPenjualan.setOpaque(false);
        accessSkemaPenjualan.add(panelSkemaPenjualan1);

        mainAccessPanel.add(accessSkemaPenjualan, "card5");

        accessDashboard.setOpaque(false);
        accessDashboard.add(panelDashboard1);

        mainAccessPanel.add(accessDashboard, "card6");

        accessSetting.setOpaque(false);
        accessSetting.add(panelSetting1);

        mainAccessPanel.add(accessSetting, "card7");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainAccessPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainAccessPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        imageItem.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/wallpaper/background-waith.png"))); // NOI18N

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(imageItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(imageItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private static JFrame notify;
    
    public static JFrame getNotify(){
        return notify;
    }
    
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
            java.util.logging.Logger.getLogger(gbrandapplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gbrandapplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gbrandapplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gbrandapplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                notify = new gbrandapplication();
                new gbrandapplication().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel accessDashboard;
    public static javax.swing.JPanel accessHome;
    public static javax.swing.JPanel accessLogin;
    public static javax.swing.JPanel accessSetting;
    public static javax.swing.JPanel accessSkemaPenjualan;
    public static javax.swing.JPanel accessTransaksi;
    public static component.swing.panelGradient backgroundPanel;
    public static component.swing.imageItem imageItem;
    public static javax.swing.JPanel mainAccessPanel;
    private javax.swing.JPanel mainPanel;
    private main.panelDashboard panelDashboard1;
    private main.panelHome panelHome2;
    private main.panelLogin panelLogin1;
    private main.panelSetting panelSetting1;
    private main.panelSkemaPenjualan panelSkemaPenjualan1;
    private main.panelTransaksi panelTransaksi1;
    private component.model.titleBar.titleBar titleBar;
    // End of variables declaration//GEN-END:variables
}
