package main.access;

import com.mysql.jdbc.Statement;
import component.model.chart.ModelChart;
import component.model.chart.ModelData;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static main.test.accessAfterLogin;
import static main.test.accessHome;

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
            ResultSet result = statement.executeQuery("SELECT DATE_FORMAT(tanggal,'%M') AS Tanggal, SUM(omset) AS Omset, SUM(pengeluaran) AS Pengeluaran, SUM(keuntungan) AS Keuntungan FROM laporan_transaksi GROUP BY DATE_FORMAT(tanggal,'%m%Y') ORDER BY tanggal DESC LIMIT 7");
//            ResultSet result = statement.executeQuery("SELECT DATE_FORMAT(tanggal_transaksi,'%M') AS Tanggal, SUM(data_transaksi.total_harga) as Omset, SUM(b.nominal) as Pengeluaran,(SUM(data_transaksi.total_harga)-SUM(b.nominal)) as Keuntungan from data_transaksi join data_pengeluaran b GROUP BY DATE_FORMAT(tanggal,'%m%Y') ORDER BY tanggal DESC LIMIT 7");
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

        mainSkemaPenjualan = new component.swing.panelRound();
        navSkemaPenjualan = new javax.swing.JPanel();
        LabelSkemaPenjualan = new javax.swing.JLabel();
        buttonCloseSkemaPenjualan = new component.swing.button();
        panelGradient = new component.swing.panelGradient();
        curveLineChart = new component.model.chart.CurveLineChart();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainSkemaPenjualan.setShadowSize(new java.awt.Insets(5, 5, 5, 5));

        navSkemaPenjualan.setOpaque(false);
        navSkemaPenjualan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelSkemaPenjualan.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        LabelSkemaPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/monitor-smile.png"))); // NOI18N
        LabelSkemaPenjualan.setText("Skema Penjualan");
        LabelSkemaPenjualan.setIconTextGap(15);
        navSkemaPenjualan.add(LabelSkemaPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, 799, -1));

        buttonCloseSkemaPenjualan.setBackground(new java.awt.Color(255, 0, 0));
        buttonCloseSkemaPenjualan.setForeground(new java.awt.Color(255, 255, 255));
        buttonCloseSkemaPenjualan.setText("Close");
        buttonCloseSkemaPenjualan.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonCloseSkemaPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseSkemaPenjualanActionPerformed(evt);
            }
        });
        navSkemaPenjualan.add(buttonCloseSkemaPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(823, 25, 133, 55));

        panelGradient.setBackground(new java.awt.Color(238, 238, 238));
        panelGradient.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelGradient.setColorGradient(new java.awt.Color(242, 242, 242));
        panelGradient.setLayout(new java.awt.CardLayout());

        curveLineChart.setBackground(new java.awt.Color(0, 0, 0));
        curveLineChart.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 6, 12, 15));
        curveLineChart.setForeground(new java.awt.Color(0, 0, 0));
        curveLineChart.setColor1(null);
        curveLineChart.setColor2(null);
        curveLineChart.setFillColor(true);
        panelGradient.add(curveLineChart, "card2");

        javax.swing.GroupLayout mainSkemaPenjualanLayout = new javax.swing.GroupLayout(mainSkemaPenjualan);
        mainSkemaPenjualan.setLayout(mainSkemaPenjualanLayout);
        mainSkemaPenjualanLayout.setHorizontalGroup(
            mainSkemaPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainSkemaPenjualanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(navSkemaPenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainSkemaPenjualanLayout.setVerticalGroup(
            mainSkemaPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainSkemaPenjualanLayout.createSequentialGroup()
                .addComponent(navSkemaPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelGradient, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(mainSkemaPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 590));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCloseSkemaPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseSkemaPenjualanActionPerformed
        accessAfterLogin.removeAll();
        accessAfterLogin.add(accessHome);
        accessAfterLogin.repaint();
        accessAfterLogin.revalidate();
    }//GEN-LAST:event_buttonCloseSkemaPenjualanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelSkemaPenjualan;
    private component.swing.button buttonCloseSkemaPenjualan;
    private component.model.chart.CurveLineChart curveLineChart;
    private component.swing.panelRound mainSkemaPenjualan;
    private javax.swing.JPanel navSkemaPenjualan;
    private component.swing.panelGradient panelGradient;
    // End of variables declaration//GEN-END:variables
}
