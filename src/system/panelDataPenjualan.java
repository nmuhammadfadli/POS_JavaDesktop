package system;

import component.model.table.tableCustom;

public class panelDataPenjualan extends javax.swing.JPanel {

    public panelDataPenjualan() {
        initComponents();
        setOpaque(false);
        tableCustom.apply(ScrollPanePenjualan, tableCustom.TableType.MULTI_LINE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textField1 = new component.swing.textField();
        button1 = new component.swing.button();
        panel1 = new component.swing.panelRound();
        jLabel1 = new javax.swing.JLabel();
        ScrollPanePenjualan = new javax.swing.JScrollPane();
        tableDataPenjualan = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(725, 591));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textField1.setLabelText("Cari");
        textField1.setOpaque(false);
        jPanel1.add(textField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 136, 550, 50));

        button1.setBackground(new java.awt.Color(255, 0, 0));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Hapus");
        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 151, 150, 40));

        panel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 45)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Penjualan");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel1.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 110));

        tableDataPenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        ScrollPanePenjualan.setViewportView(tableDataPenjualan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPanePenjualan)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPanePenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPanePenjualan;
    private component.swing.button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private component.swing.panelRound panel1;
    private javax.swing.JTable tableDataPenjualan;
    private component.swing.textField textField1;
    // End of variables declaration//GEN-END:variables
}
