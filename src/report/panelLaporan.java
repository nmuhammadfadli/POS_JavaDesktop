package report;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import component.model.chart.pieChart;
import component.model.chart.modelPieChart;

public class panelLaporan extends javax.swing.JPanel {

    private DefaultTableModel model;
    
    private int a;
    
    public panelLaporan() {
        initComponents();
        String[] judul = {"Id Kategori", "Kategori", "Terjual"};
        model = new DefaultTableModel(judul, 0);
        tableLaporan.setModel(model);
        omset();
        pengeluaran();
        keuntungan();
        tampilkan();
        
//        pieChart1.setChartType(pieChart.PeiChartType.DONUT_CHART);
//        pieChart1.addData(new modelPieChart("Tigher", setText(jLabel3), new Color(23, 126, 238)));
//        pieChart1.addData(new modelPieChart("ABC", 100, new Color(221, 65, 65)));
//        pieChart1.addData(new modelPieChart("Coca", 120, new Color(47, 157, 64)));
//        pieChart1.addData(new modelPieChart("Vita", 60, new Color(196, 151, 58)));
    }
    

    private void tampilkan() {
        int row = tableLaporan.getRowCount();
        for (int a = 0; a < row; a++) {
            model.removeRow(0);
            
        }
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gbrand", "root", "");
            ResultSet rs = cn.createStatement().executeQuery("select data_kategori.id_kategori, data_kategori.nama_kategori,count(detail_transaksi.id_kategori) as Terjual from detail_transaksi left join data_kategori on data_kategori.id_kategori=detail_transaksi.id_kategori group by detail_transaksi.id_kategori");
            while (rs.next()) {
                String data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)};
                
              //tableLaporan.addData(new modelPieChart("Tigher", rs.getString(), new Color(23, 126, 238)));
                
                model.addRow(data); 
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(panelLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void omset(){
        String myomset =  "CALL `pemasukan`()";
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gbrand", "root", "");
        
            ResultSet rs = cn.createStatement().executeQuery(myomset);
            while (rs.next()) {
                jLabel3.setText(rs.getString(1));
            }
     
        } catch (Exception ex) {
            Logger.getLogger(panelLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void pengeluaran(){
        String pengeluaran = "CALL `pengeluaran`()";
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gbrand", "root", "");
            ResultSet rs = cn.createStatement().executeQuery(pengeluaran);
            while (rs.next()) {
                jLabel6.setText(rs.getString(1));
            }
        } catch (Exception ex) {
            Logger.getLogger(panelLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void keuntungan(){
        int omzet,minus;
        int untung;
        omzet = Integer.valueOf(jLabel3.getText());
        minus = Integer.valueOf(jLabel6.getText());
        untung = omzet - minus;
        jLabel9.setText(String.valueOf("Rp. " + untung));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient5 = new component.swing.panelGradient();
        scrollPaneKategori = new javax.swing.JScrollPane();
        tableLaporan = new javax.swing.JTable();
        panelGradient1 = new component.swing.panelGradient();
        panelCard1 = new component.swing.panelCard();
        panelRound1 = new component.swing.panelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelCard2 = new component.swing.panelCard();
        panelRound2 = new component.swing.panelRound();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelCard3 = new component.swing.panelCard();
        panelRound3 = new component.swing.panelRound();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        panelGradient5.setBackground(new java.awt.Color(238, 238, 238));
        panelGradient5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelGradient5.setColorGradient(new java.awt.Color(242, 242, 242));
        panelGradient5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableLaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrollPaneKategori.setViewportView(tableLaporan);

        panelGradient5.add(scrollPaneKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 620, 220));

        panelGradient1.setBackground(new java.awt.Color(238, 238, 238));
        panelGradient1.setColorGradient(new java.awt.Color(242, 242, 242));
        panelGradient1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGO");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Omset");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel3.setText("Rp. 0");

        javax.swing.GroupLayout panelCard1Layout = new javax.swing.GroupLayout(panelCard1);
        panelCard1.setLayout(panelCard1Layout);
        panelCard1Layout.setHorizontalGroup(
            panelCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCard1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCard1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                        .addGap(79, 79, 79))
                    .addGroup(panelCard1Layout.createSequentialGroup()
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelCard1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panelCard1Layout.setVerticalGroup(
            panelCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCard1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelGradient1.add(panelCard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("LOGO");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Pengeluaran");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel6.setText("Rp. 0");

        javax.swing.GroupLayout panelCard2Layout = new javax.swing.GroupLayout(panelCard2);
        panelCard2.setLayout(panelCard2Layout);
        panelCard2Layout.setHorizontalGroup(
            panelCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCard2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCard2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelCard2Layout.createSequentialGroup()
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelCard2Layout.setVerticalGroup(
            panelCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCard2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        panelGradient1.add(panelCard2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, -1, 190));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("LOGO");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Keuntungan");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel9.setText("Rp. 0");

        javax.swing.GroupLayout panelCard3Layout = new javax.swing.GroupLayout(panelCard3);
        panelCard3.setLayout(panelCard3Layout);
        panelCard3Layout.setHorizontalGroup(
            panelCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCard3Layout.createSequentialGroup()
                .addGroup(panelCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCard3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelCard3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelCard3Layout.setVerticalGroup(
            panelCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCard3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        panelGradient1.add(panelCard3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient5, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelGradient5, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private component.swing.panelCard panelCard1;
    private component.swing.panelCard panelCard2;
    private component.swing.panelCard panelCard3;
    private component.swing.panelGradient panelGradient1;
    private component.swing.panelGradient panelGradient5;
    private component.swing.panelRound panelRound1;
    private component.swing.panelRound panelRound2;
    private component.swing.panelRound panelRound3;
    private javax.swing.JScrollPane scrollPaneKategori;
    private javax.swing.JTable tableLaporan;
    // End of variables declaration//GEN-END:variables
}
