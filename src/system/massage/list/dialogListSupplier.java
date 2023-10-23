package system.massage.list;

import system.massage.popup.*;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import component.swing.glass;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import static system.massage.popup.dialogLupaPassword.fieldEmailLupaPassword;
import static system.massage.popup.dialogLupaPassword.fieldUsernameLupaPassword;
import system.notification.Notification;

public class dialogListSupplier extends javax.swing.JDialog {

    private final JFrame fram;
    private Animator animator;
    private glass glass;
    private boolean show;
    private MessageType messageType = MessageType.CANCEL;

    public dialogListSupplier(JFrame fram) {
        super(fram, true);
        this.fram = fram;
        initComponents();
        init();
    }

    private void init() {
        setBackground(new Color(0, 0, 0, 0));
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeMessage();
            }
        });
        animator = new Animator(350, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                float f = show ? fraction : 1f - fraction;
                glass.setAlpha(f - f * 0.3f);
                setOpacity(f);
            }

            @Override
            public void end() {
                if (show == false) {
                    dispose();
                    glass.setVisible(false);
                }
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        setOpacity(0f);
        glass = new glass();
    }

    private void startAnimator(boolean show) {
        if (animator.isRunning()) {
            float f = animator.getTimingFraction();
            animator.stop();
            animator.setStartFraction(1f - f);
        } else {
            animator.setStartFraction(0f);
        }
        this.show = show;
        animator.start();
    }

    public void showMessage() {
        fram.setGlassPane(glass);
        glass.setVisible(true);
        setLocationRelativeTo(fram);
        startAnimator(true);
        setVisible(true);
    }

    public void closeMessage() {
        if (animator.isRunning()) {
            animator.stop();
        }
        show = false;
        animator.setDuration(200);
        animator.start();
    }

    public MessageType getMessageType() {
        return messageType;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTransparent1 = new component.swing.panelTransparent();
        panelRound1 = new component.swing.panelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new component.model.tableCustom.table();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        panelTransparent1.setBackground(new java.awt.Color(225, 225, 225));
        panelTransparent1.setAlpha(0.8F);
        panelTransparent1.setRound(35);
        panelTransparent1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelTransparent1MouseClicked(evt);
            }
        });
        panelTransparent1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setRound(25);
        panelRound1.setShadowSize(new java.awt.Insets(5, 5, 5, 5));
        panelRound1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table1);

        panelRound1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelTransparent1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 510, 330));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel1.setText("List Kategori Pembelian");
        panelTransparent1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 290, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        closeMessage();
    }//GEN-LAST:event_formMouseClicked

    private void panelTransparent1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTransparent1MouseClicked
        closeMessage();
    }//GEN-LAST:event_panelTransparent1MouseClicked

    public static enum MessageType {
        CANCEL, OK
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private component.swing.panelRound panelRound1;
    private component.swing.panelTransparent panelTransparent1;
    private component.model.tableCustom.table table1;
    // End of variables declaration//GEN-END:variables
}
