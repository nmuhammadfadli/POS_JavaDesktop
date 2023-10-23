package main.access;

import component.model.table.tableCustom;

public class panelHomeProfile extends javax.swing.JPanel {

    public panelHomeProfile() {
        initComponents();
        
        setOpaque(false);
        
        tableCustom.apply(scrollPaneProfile, tableCustom.TableType.MULTI_LINE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneProfile = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        panelRound20 = new component.swing.panelRound();
        fieldAlamatSupplier = new component.swing.textField();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldAlamatSupplier.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldAlamatSupplier.setLabelText("Alamat");
        panelRound20.add(fieldAlamatSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 610, -1));

        jPanel1.add(panelRound20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 630, 70));

        scrollPaneProfile.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneProfile)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneProfile)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.textField fieldAlamatSupplier;
    private javax.swing.JPanel jPanel1;
    private component.swing.panelRound panelRound20;
    private javax.swing.JScrollPane scrollPaneProfile;
    // End of variables declaration//GEN-END:variables
}
