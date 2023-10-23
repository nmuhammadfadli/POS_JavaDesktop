package system.massage.popup;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import component.swing.glass;
import component.swing.scrollBarCustom;
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
import service.connect;
import system.notification.Notification;

public class dialogHomeProfile extends javax.swing.JDialog {

    private final JFrame fram;
    private Animator animator;
    private glass glass;
    private boolean show;
    private MessageType messageType = MessageType.CANCEL;

    public dialogHomeProfile(JFrame fram) {
        super(fram, true);
        this.fram = fram;
        initComponents();
        init();
        
        profile();
        
        jScrollPane1.setVerticalScrollBar(new scrollBarCustom());
        jScrollPane1.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
    }

    private void init() {
        setBackground(new Color(0, 0, 0, 0));
        StyledDocument docx = textPaneProfile.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        docx.setParagraphAttributes(0, docx.getLength(), center, false);
        textPaneProfile.setOpaque(false);
        textPaneProfile.setBackground(new Color(0, 0, 0, 0));
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

    public void showMessage(String message) {
        fram.setGlassPane(glass);
        glass.setVisible(true);
        textPaneProfile.setText(message);
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
    
//    public void oldPassword(){
//        String Password = fieldOldVerifyPassword.getLabelText();
//        
//        try{
//            Statement statement = (Statement)service.connect.GetConnection().createStatement();
//            statement.executeQuery("SELECT * FROM data_pengguna WHERE password= '"+ Password +"'");    
//        }
//        catch(Exception e){
//            System.out.print("Gagal terhubung");
//            JOptionPane.showMessageDialog(null,"Koneksi databases error");
//        }
//    }
    
    public void profile() {
        try{
            Statement getLogin = (Statement)connect.GetConnection().createStatement();
            ResultSet rest = getLogin.executeQuery("SELECT * FROM data_pengguna WHERE id_pengguna = '" + fieldIDPenggunaProfile.getText() + "'");
            if(rest.next()){
                fieldUsernameProfile.setText(rest.getString("username"));
                fieldPasswordProfile.setText(rest.getString("password"));
                fieldNamaProfile.setText(rest.getString("nama_pengguna"));
                fieldEmailProfile.setText(rest.getString("email"));
                fieldNoTelphoneProfile.setText(rest.getString("no_telphone"));
                textPaneAlamatProfile.setText(rest.getString("alamat"));   
                fieldTipeAkunProfile.setText(rest.getString("tipe_akun"));
                
            }
        } catch(Exception ex) {
            
        }
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldIDPenggunaProfile = new javax.swing.JTextField();
        panelGradient1 = new component.swing.panelGradient();
        panelRound1 = new component.swing.panelRound();
        imageItem2 = new component.swing.imageItem();
        imageItem1 = new component.swing.imageItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textPaneProfile = new javax.swing.JTextPane();
        button1 = new component.swing.button();
        button2 = new component.swing.button();
        titleIconProfile = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        fieldUsernameProfile = new component.swing.textFieldMain();
        fieldNamaProfile = new component.swing.textFieldMain();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldEmailProfile = new component.swing.textFieldMain();
        jLabel6 = new javax.swing.JLabel();
        fieldTipeAkunProfile = new component.swing.textFieldMain();
        fieldNoTelphoneProfile = new component.swing.textFieldMain();
        jLabel7 = new javax.swing.JLabel();
        fieldPasswordProfile = new component.swing.passwordFieldMain();
        fieldConfirmationPasswordProfile = new component.swing.passwordFieldMain();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelRound3 = new component.swing.panelRound();
        textPaneAlamatProfile = new javax.swing.JTextPane();
        buttonSimpanProfile = new component.swing.button();

        fieldIDPenggunaProfile.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGradient1.setRadius(45);
        panelGradient1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(242, 242, 242));
        panelRound1.setRound(35);
        panelRound1.setShadowSize(new java.awt.Insets(5, 5, 8, 5));
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imageItem2.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/user (1).png"))); // NOI18N
        imageItem2.setRound(20);
        panelRound1.add(imageItem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 100, 100));

        imageItem1.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/wallpaper/slide2.jpg"))); // NOI18N
        imageItem1.setRound(20);
        panelRound1.add(imageItem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 350, 230));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Username");
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 320, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tipe Akun");
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 320, -1));

        textPaneProfile.setEditable(false);
        textPaneProfile.setText("Change new password \nto old password.");
        textPaneProfile.setOpaque(false);
        panelRound1.add(textPaneProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 340, 70));

        button1.setText("Keluar");
        button1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelRound1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 120, 60));

        button2.setBackground(new java.awt.Color(204, 0, 0));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Log Out");
        button2.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        panelRound1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 230, 60));

        panelGradient1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 390, 540));

        titleIconProfile.setFont(new java.awt.Font("Dialog", 1, 35)); // NOI18N
        titleIconProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleIconProfile.setText("Change Your Profile User");
        titleIconProfile.setIconTextGap(15);
        panelGradient1.add(titleIconProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 540, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel3.setText("Username");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        fieldUsernameProfile.setBackground(new java.awt.Color(242, 242, 242));
        fieldUsernameProfile.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jPanel2.add(fieldUsernameProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 540, 60));

        fieldNamaProfile.setBackground(new java.awt.Color(242, 242, 242));
        fieldNamaProfile.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jPanel2.add(fieldNamaProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 540, 60));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel4.setText("Nama");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel5.setText("Email");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        fieldEmailProfile.setBackground(new java.awt.Color(242, 242, 242));
        fieldEmailProfile.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jPanel2.add(fieldEmailProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 540, 60));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel6.setText("Password");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        fieldTipeAkunProfile.setBackground(new java.awt.Color(242, 242, 242));
        fieldTipeAkunProfile.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jPanel2.add(fieldTipeAkunProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 540, 60));

        fieldNoTelphoneProfile.setBackground(new java.awt.Color(242, 242, 242));
        fieldNoTelphoneProfile.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jPanel2.add(fieldNoTelphoneProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 540, 60));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel7.setText("Ulangi Password");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        fieldPasswordProfile.setBackground(new java.awt.Color(242, 242, 242));
        fieldPasswordProfile.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jPanel2.add(fieldPasswordProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 540, 60));

        fieldConfirmationPasswordProfile.setBackground(new java.awt.Color(242, 242, 242));
        fieldConfirmationPasswordProfile.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jPanel2.add(fieldConfirmationPasswordProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 540, 60));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel8.setText("Tipe Akun");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel9.setText("No Telphone");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel10.setText("Alamat");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, -1, -1));

        panelRound3.setBackground(new java.awt.Color(242, 242, 242));

        textPaneAlamatProfile.setBackground(new java.awt.Color(242, 242, 242));
        textPaneAlamatProfile.setBorder(null);
        textPaneAlamatProfile.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(textPaneAlamatProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(textPaneAlamatProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel2.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 540, 160));

        buttonSimpanProfile.setText("Simpan Profile");
        buttonSimpanProfile.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonSimpanProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanProfileActionPerformed(evt);
            }
        });
        jPanel2.add(buttonSimpanProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 850, 150, 50));

        jScrollPane1.setViewportView(jPanel2);

        panelGradient1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 570, 460));

        getContentPane().add(panelGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        closeMessage();
    }//GEN-LAST:event_formMouseClicked

    private void buttonSimpanProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanProfileActionPerformed
        String IDPengguna = fieldIDPenggunaProfile.getText();
        String Username = fieldUsernameProfile.getText();
        String Name = fieldNamaProfile.getText();
        String Email = fieldEmailProfile.getText();
        String Password = fieldPasswordProfile.getText();
        String TipeAkun = fieldTipeAkunProfile.getText();
        String NoTelphone = fieldNoTelphoneProfile.getText();
        String Alamat = textPaneAlamatProfile.getText();

        if(Username.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Username Tidak Boleh Kosong"); 
            fieldUsernameProfile.requestFocus();
        } else if(Name.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Name Tidak Boleh Kosong"); 
            fieldNamaProfile.requestFocus();
        } else if(Email.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Email Tidak Boleh Kosong"); 
            fieldEmailProfile.requestFocus();
        } else if(Password.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Password Tidak Boleh Kosong"); 
            fieldPasswordProfile.requestFocus();
        } else{
            
            try{
                Statement statement = (Statement)connect.GetConnection().createStatement();
                statement.executeUpdate("UPDATE data_pengguna SET username='"+ Username +"', password='"+ Password +"', nama_pengguna='"+ Name +"', email='"+ Email +"', no_telphone='"+ NoTelphone +"',alamat='"+ Alamat +"' , tipe_akun='"+ TipeAkun +"' WHERE id_pengguna='"+ IDPengguna +"';");                   
                
//                DataTableManagementAkun();
//                main.gbrandapplication.homeLabelUsername.setText(Username);
                statement.close ();
            } catch (Exception t){
                JOptionPane.showMessageDialog(null, "data gagal disimpan");
            }
        
        }
    }//GEN-LAST:event_buttonSimpanProfileActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        closeMessage();
    }//GEN-LAST:event_button1ActionPerformed

    public static enum MessageType {
        CANCEL, OK
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button button1;
    private component.swing.button button2;
    private component.swing.button buttonSimpanProfile;
    public static component.swing.passwordFieldMain fieldConfirmationPasswordProfile;
    public static component.swing.textFieldMain fieldEmailProfile;
    public static javax.swing.JTextField fieldIDPenggunaProfile;
    public static component.swing.textFieldMain fieldNamaProfile;
    public static component.swing.textFieldMain fieldNoTelphoneProfile;
    public static component.swing.passwordFieldMain fieldPasswordProfile;
    public static component.swing.textFieldMain fieldTipeAkunProfile;
    public static component.swing.textFieldMain fieldUsernameProfile;
    private component.swing.imageItem imageItem1;
    private component.swing.imageItem imageItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private component.swing.panelGradient panelGradient1;
    private component.swing.panelRound panelRound1;
    private component.swing.panelRound panelRound3;
    public static javax.swing.JTextPane textPaneAlamatProfile;
    private javax.swing.JTextPane textPaneProfile;
    private javax.swing.JLabel titleIconProfile;
    // End of variables declaration//GEN-END:variables
}
