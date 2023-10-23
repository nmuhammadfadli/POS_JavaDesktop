package system.massage.popup;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import component.swing.glass;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import system.notification.Notification;

public class dialogLupaPassword extends javax.swing.JDialog {

    private final JFrame fram;
    private Animator animator;
    private glass glass;
    private boolean show;
    private MessageType messageType = MessageType.CANCEL;

    public dialogLupaPassword(JFrame fram) {
        super(fram, true);
        this.fram = fram;
        initComponents();
        init();
        
        panelRoundAction.removeAll();
        panelRoundAction.add(panelLupaPassword);
        panelRoundAction.repaint();
        panelRoundAction.revalidate();
    }

    private void init() {
        setBackground(new Color(0, 0, 0, 0));
        StyledDocument docx = text.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        docx.setParagraphAttributes(0, docx.getLength(), center, false);
        text.setOpaque(false);
        text.setBackground(new Color(0, 0, 0, 0));
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

    public void showMessage(String title, String message) {
        fram.setGlassPane(glass);
        glass.setVisible(true);
        titleIcon.setText(title);
        text.setText(message);
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

        panelRoundAction = new component.swing.panelRound();
        panelLupaPassword = new javax.swing.JPanel();
        text = new javax.swing.JTextPane();
        buttonCANCELLupaPassword = new component.swing.button();
        buttonOKLupaPassword = new component.swing.button();
        panelRound4 = new component.swing.panelRound();
        fieldEmailLupaPassword = new component.swing.textField();
        panelRound2 = new component.swing.panelRound();
        fieldUsernameLupaPassword = new component.swing.textField();
        titleIcon = new javax.swing.JLabel();
        panelVerifyPassword = new javax.swing.JPanel();
        titleIcon1 = new javax.swing.JLabel();
        panelRound3 = new component.swing.panelRound();
        fieldOldVerifyPassword = new component.swing.textField();
        panelRound5 = new component.swing.panelRound();
        fieldNewVerifyPassword = new component.swing.passwordField();
        buttonOKVerifyPassword = new component.swing.button();
        buttonCANCELVerifyPassword = new component.swing.button();
        text1 = new javax.swing.JTextPane();
        panelRound6 = new component.swing.panelRound();
        fieldReVerifyPassword = new component.swing.passwordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRoundAction.setShadowSize(new java.awt.Insets(5, 5, 5, 5));
        panelRoundAction.setLayout(new java.awt.CardLayout());

        panelLupaPassword.setOpaque(false);
        panelLupaPassword.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        text.setEditable(false);
        text.setText("Verify Username and Email for Your \nUser to change Password");
        text.setOpaque(false);
        panelLupaPassword.add(text, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 78, 210, 60));

        buttonCANCELLupaPassword.setBackground(new java.awt.Color(204, 0, 0));
        buttonCANCELLupaPassword.setForeground(new java.awt.Color(255, 255, 255));
        buttonCANCELLupaPassword.setText("CANCEL");
        buttonCANCELLupaPassword.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonCANCELLupaPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCANCELLupaPasswordActionPerformed(evt);
            }
        });
        panelLupaPassword.add(buttonCANCELLupaPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 338, 130, 50));

        buttonOKLupaPassword.setBackground(new java.awt.Color(0, 204, 0));
        buttonOKLupaPassword.setForeground(new java.awt.Color(255, 255, 255));
        buttonOKLupaPassword.setText("OK");
        buttonOKLupaPassword.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonOKLupaPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKLupaPasswordActionPerformed(evt);
            }
        });
        panelLupaPassword.add(buttonOKLupaPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 338, 130, 50));

        panelRound4.setBackground(new java.awt.Color(238, 238, 238));

        fieldEmailLupaPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldEmailLupaPassword.setLabelText("Email");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldEmailLupaPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldEmailLupaPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelLupaPassword.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 370, 80));

        panelRound2.setBackground(new java.awt.Color(238, 238, 238));

        fieldUsernameLupaPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldUsernameLupaPassword.setLabelText("Username");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldUsernameLupaPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldUsernameLupaPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelLupaPassword.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 370, 80));

        titleIcon.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        titleIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/password.png"))); // NOI18N
        titleIcon.setText("Lupa Password ?");
        titleIcon.setIconTextGap(15);
        panelLupaPassword.add(titleIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 8, 290, 95));

        panelRoundAction.add(panelLupaPassword, "card2");

        panelVerifyPassword.setOpaque(false);
        panelVerifyPassword.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleIcon1.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        titleIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/password_verify.png"))); // NOI18N
        titleIcon1.setText("Change Password !");
        titleIcon1.setIconTextGap(15);
        panelVerifyPassword.add(titleIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 0, 310, 80));

        panelRound3.setBackground(new java.awt.Color(238, 238, 238));

        fieldOldVerifyPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldOldVerifyPassword.setLabelText("Old Password");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldOldVerifyPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldOldVerifyPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelVerifyPassword.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 110, -1, 70));

        panelRound5.setBackground(new java.awt.Color(238, 238, 238));

        fieldNewVerifyPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldNewVerifyPassword.setLabelText("New Password");
        fieldNewVerifyPassword.setShowAndHide(true);

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldNewVerifyPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addComponent(fieldNewVerifyPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelVerifyPassword.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 190, -1, 70));

        buttonOKVerifyPassword.setBackground(new java.awt.Color(0, 204, 0));
        buttonOKVerifyPassword.setForeground(new java.awt.Color(255, 255, 255));
        buttonOKVerifyPassword.setText("OK");
        buttonOKVerifyPassword.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonOKVerifyPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKVerifyPasswordActionPerformed(evt);
            }
        });
        panelVerifyPassword.add(buttonOKVerifyPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 350, 130, 50));

        buttonCANCELVerifyPassword.setBackground(new java.awt.Color(204, 0, 0));
        buttonCANCELVerifyPassword.setForeground(new java.awt.Color(255, 255, 255));
        buttonCANCELVerifyPassword.setText("CANCEL");
        buttonCANCELVerifyPassword.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonCANCELVerifyPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCANCELVerifyPasswordActionPerformed(evt);
            }
        });
        panelVerifyPassword.add(buttonCANCELVerifyPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 350, 130, 50));

        text1.setEditable(false);
        text1.setText("Change new password \nto old password.");
        text1.setOpaque(false);
        panelVerifyPassword.add(text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 60, 230, 40));

        panelRound6.setBackground(new java.awt.Color(238, 238, 238));

        fieldReVerifyPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldReVerifyPassword.setLabelText("Re Password");
        fieldReVerifyPassword.setShowAndHide(true);

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldReVerifyPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addComponent(fieldReVerifyPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelVerifyPassword.add(panelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 270, -1, 70));

        panelRoundAction.add(panelVerifyPassword, "card3");

        getContentPane().add(panelRoundAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 422));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCANCELLupaPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCANCELLupaPasswordActionPerformed
        messageType = MessageType.CANCEL;
        closeMessage();
    }//GEN-LAST:event_buttonCANCELLupaPasswordActionPerformed

    private void buttonOKLupaPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKLupaPasswordActionPerformed
        messageType = MessageType.OK;
        
        String Username = fieldUsernameLupaPassword.getText();
        String Email = fieldEmailLupaPassword.getText();
        
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet rest = statement.executeQuery("SELECT * FROM data_pengguna WHERE username= '"+ Username +"'");
            if(rest.next()) {
                if(Email.equals(rest.getString("email"))) {
                    panelRoundAction.removeAll();
                    panelRoundAction.add(panelVerifyPassword);
                    panelRoundAction.repaint();
                    panelRoundAction.revalidate();
                    
                    fieldOldVerifyPassword.equals(rest.getString("password"));
                    fieldOldVerifyPassword.setText(rest.getString("password"));
                } else {
                    fieldUsernameLupaPassword.requestFocus();
                    Notification notif = new Notification(main.test.getJFram(), Notification.Type.INFO, Notification.Location.TOP_CENTER, "Email tidak di temukan !");
                    notif.showNotification();
                }   
            } else {
                fieldEmailLupaPassword.requestFocus();
                Notification notif = new Notification(main.test.getJFram(), Notification.Type.INFO, Notification.Location.TOP_CENTER, "Username tidak di temukan !");
                notif.showNotification();
            }
        } catch(Exception e) {
            System.err.print(e);
        } 
    }//GEN-LAST:event_buttonOKLupaPasswordActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        closeMessage();
    }//GEN-LAST:event_formMouseClicked

    private void buttonOKVerifyPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKVerifyPasswordActionPerformed
        messageType = MessageType.OK;
        
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin mengubah Password?");
        
        String New = fieldNewVerifyPassword.getText();
        String Re = fieldReVerifyPassword.getText();
        
        if (confirm == 0) {
            try{
                Statement statement = (Statement)service.connect.GetConnection().createStatement();
                if(Re.equals(New)) {
                    statement.executeUpdate("UPDATE data_pengguna SET password ='" + fieldNewVerifyPassword.getText() + "' where username ='" + fieldUsernameLupaPassword.getText() +"';");
                
                    Notification notif = new Notification(main.test.getJFram(), Notification.Type.INFO, Notification.Location.TOP_CENTER, " Password berhasil diubah !");
                    notif.showNotification();
                } else {
                    fieldEmailLupaPassword.requestFocus();
                    Notification notif = new Notification(main.test.getJFram(), Notification.Type.INFO, Notification.Location.TOP_CENTER, " Password gagal diubah !");
                    notif.showNotification();
                }
            } catch(Exception e) {
                System.err.print(e);
            }
        }
    }//GEN-LAST:event_buttonOKVerifyPasswordActionPerformed

    private void buttonCANCELVerifyPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCANCELVerifyPasswordActionPerformed
        messageType = MessageType.CANCEL;
        closeMessage();
    }//GEN-LAST:event_buttonCANCELVerifyPasswordActionPerformed

    public static enum MessageType {
        CANCEL, OK
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button buttonCANCELLupaPassword;
    private component.swing.button buttonCANCELVerifyPassword;
    private component.swing.button buttonOKLupaPassword;
    private component.swing.button buttonOKVerifyPassword;
    public static component.swing.textField fieldEmailLupaPassword;
    private component.swing.passwordField fieldNewVerifyPassword;
    private component.swing.textField fieldOldVerifyPassword;
    private component.swing.passwordField fieldReVerifyPassword;
    public static component.swing.textField fieldUsernameLupaPassword;
    private javax.swing.JPanel panelLupaPassword;
    private component.swing.panelRound panelRound2;
    private component.swing.panelRound panelRound3;
    private component.swing.panelRound panelRound4;
    private component.swing.panelRound panelRound5;
    private component.swing.panelRound panelRound6;
    private component.swing.panelRound panelRoundAction;
    private javax.swing.JPanel panelVerifyPassword;
    private javax.swing.JTextPane text;
    private javax.swing.JTextPane text1;
    private javax.swing.JLabel titleIcon;
    private javax.swing.JLabel titleIcon1;
    // End of variables declaration//GEN-END:variables
}
