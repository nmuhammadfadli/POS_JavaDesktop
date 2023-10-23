package system;

import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import component.model.chart.*;
import static main.gbrandapplication.mainPanel;
import static main.gbrandapplication.panelHome;
import service.connect;

public class panelSkemaPenjualan extends javax.swing.JPanel {

    public panelSkemaPenjualan() {
        initComponents();
        chart.setTitle("Chart Data");
        chart.addLegend("Amount", Color.decode("#7b4397"), Color.decode("#dc2430"));
        chart.addLegend("Cost", Color.decode("#e65c00"), Color.decode("#F9D423"));
        chart.addLegend("Profit", Color.decode("#0099F7"), Color.decode("#F11712"));
        setData();
    }
    
    private void setData() {
        try {
            List<ModelData> lists = new ArrayList<>();
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT DATE_FORMAT(Date,'%M') AS `Month`, SUM(TotalAmount) AS Amount, SUM(TotalCost) AS Cost, SUM(TotalProfit) AS Profit FROM orders GROUP BY DATE_FORMAT(Date,'%m%Y') ORDER BY Date DESC LIMIT 7");
            while (result.next()) {
                String month = result.getString("Month");
                double amount = result.getDouble("Amount");
                double cost = result.getDouble("Cost");
                double profit = result.getDouble("Profit");
                lists.add(new ModelData(month, amount, cost, profit));
            }
            result.close();
            //  Add Data to chart
            for (int i = lists.size() - 1; i >= 0; i--) {
                ModelData d = lists.get(i);
                chart.addData(new ModelChart(d.getMonth(), new double[]{d.getAmount(), d.getCost(), d.getProfit()}));
            }
            //  Start to show data with animation
            chart.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow = new component.swing.panelShadow();
        panel2 = new component.swing.panelRound();
        button1 = new component.swing.button();
        jLabel1 = new javax.swing.JLabel();
        buttonTransaksiHome = new component.swing.button();
        chart = new component.model.chart.CurveLineChart();

        panelShadow.setBackground(new java.awt.Color(225, 225, 225));
        panelShadow.setForeground(new java.awt.Color(50, 50, 50));
        panelShadow.setColorGradient(new java.awt.Color(245, 245, 245));
        panelShadow.setShadowColor(new java.awt.Color(51, 51, 51));
        panelShadow.setShadowSize(2);
        panelShadow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel2.setBackground(new java.awt.Color(153, 153, 153));

        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/monitor-smile.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 45)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Skema Penjualan");

        buttonTransaksiHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/home.png"))); // NOI18N
        buttonTransaksiHome.setText("Home");
        buttonTransaksiHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonTransaksiHome.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        buttonTransaksiHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonTransaksiHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTransaksiHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 434, Short.MAX_VALUE)
                .addComponent(buttonTransaksiHome, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonTransaksiHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelShadow.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1010, 110));

        chart.setForeground(new java.awt.Color(50, 50, 50));
        panelShadow.add(chart, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 129, 1002, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTransaksiHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTransaksiHomeActionPerformed
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(panelHome);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_buttonTransaksiHomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button button1;
    public static component.swing.button buttonTransaksiHome;
    private component.model.chart.CurveLineChart chart;
    private javax.swing.JLabel jLabel1;
    private component.swing.panelRound panel2;
    private component.swing.panelShadow panelShadow;
    // End of variables declaration//GEN-END:variables
}
