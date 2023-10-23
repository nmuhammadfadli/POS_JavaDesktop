package main;

import component.model.chart.ModelChart;
import component.model.chart.ModelData;
import component.model.chart.modelPieChartData;
import component.model.chart.pieChart;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static main.gbrandapplication.accessHome;
import static main.gbrandapplication.mainAccessPanel;

public class panelSkemaPenjualan extends javax.swing.JPanel {

    public panelSkemaPenjualan() {
        initComponents();
        setOpaque(false);
        curveLineChart.setTitle("Data Penjualan Perbulan");
        curveLineChart.addLegend("Omset", Color.decode("#7b4397"), Color.decode("#dc2430"));
        curveLineChart.addLegend("Pengeluaran", Color.decode("#e65c00"), Color.decode("#F9D423"));
        curveLineChart.addLegend("Keuntungan", Color.decode("#0099F7"), Color.decode("#F11712"));
        setData();
    }
    
    private void setData() {
        try {
            List<ModelData> lists = new ArrayList<>();
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT DATE_FORMAT(tanggal_transaksi,'%M') AS `Tanggal`, SUM(omset) AS Omset, SUM(pengeluaran) AS Pengeluaran, SUM(keuntungan) AS Keuntungan FROM laporan_transaksi GROUP BY DATE_FORMAT(tanggal_transaksi,'%m%Y') ORDER BY tanggal_transaksi DESC LIMIT 7");
//            ResultSet result = statement.executeQuery("SELECT DATE_FORMAT(tanggal_transaksi,'%M') AS Tanggal, SUM(data_transaksi.total_harga) AS Omset, SUM(b.nominal) AS Pengeluaran,(SUM(data_transaksi.total_harga)-SUM(b.nominal)) AS Keuntungan from data_transaksi join data_pengeluaran b GROUP BY DATE_FORMAT(tanggal,'%m%Y') ORDER BY tanggal DESC LIMIT 7");
            while (result.next()) {
                String month = result.getString("Tanggal");
                double amount = result.getDouble("Omset");
                double cost = result.getDouble("Pengeluaran");
                double profit = result.getDouble("Keuntungan");
                lists.add(new ModelData(month, amount, cost, profit));
            }
            result.close();
            //  Add Data to chart
            for (int i = lists.size() - 1; i >= 0; i--) {
                ModelData d = lists.get(i);
                curveLineChart.addData(new ModelChart(d.getMonth(), new double[]{d.getAmount(), d.getCost(), d.getProfit()}));
            }
            //  Start to show data with animation
            curveLineChart.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.print(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new component.swing.button();
        jLabel2 = new javax.swing.JLabel();
        panelTransparent1 = new component.swing.panelTransparent();
        curveLineChart = new component.model.chart.CurveLineChart();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelTransparent2 = new component.swing.panelTransparent();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button1.setText("Keluar Dari Skema Penjualan");
        button1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 230, 60));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 35)); // NOI18N
        jLabel2.setText("Skema Penjualan");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        panelTransparent1.setBackground(new java.awt.Color(225, 225, 225));
        panelTransparent1.setBorder(javax.swing.BorderFactory.createEmptyBorder(18, 18, 18, 18));
        panelTransparent1.setAlpha(0.8F);
        panelTransparent1.setRound(25);
        panelTransparent1.setLayout(new java.awt.CardLayout());

        curveLineChart.setForeground(new java.awt.Color(51, 51, 51));
        curveLineChart.setFillColor(true);
        panelTransparent1.add(curveLineChart, "card2");

        add(panelTransparent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 830, 530));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/skema.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 120));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/chart.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, -1, -1));

        panelTransparent2.setBackground(new java.awt.Color(225, 225, 225));
        panelTransparent2.setAlpha(0.8F);
        panelTransparent2.setRound(25);
        add(panelTransparent2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 110, 300, 530));
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        mainAccessPanel.removeAll();
        mainAccessPanel.add(accessHome);
        mainAccessPanel.repaint();
        mainAccessPanel.revalidate();
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button button1;
    private component.model.chart.CurveLineChart curveLineChart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private component.swing.panelTransparent panelTransparent1;
    private component.swing.panelTransparent panelTransparent2;
    // End of variables declaration//GEN-END:variables
}
