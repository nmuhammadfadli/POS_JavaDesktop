package component.model.titleBar;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;

public class buttonBar extends javax.swing.JPanel {

    public buttonBar() {
        initComponents();
        setOpaque(false);
        cmdClose.setIcon(iconClose.toIcon());
        cmdResize.setIcon(iconRestore.toIcon());
        cmdMinimize.setIcon(iconMinimize.toIcon());
        cmdMinimize.setFont(cmdMinimize.getFont().deriveFont(0, 3));
    }

    public void initEvent(JFrame fram) {
        fram.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent we) {
                if (we.getNewState() == JFrame.MAXIMIZED_BOTH) {
                    cmdResize.setIcon(iconMax.toIcon());
                } else if (we.getNewState() == JFrame.NORMAL) {
                    cmdResize.setIcon(iconRestore.toIcon());
                }
            }
        });
        cmdClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        cmdMinimize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fram.setState(JFrame.ICONIFIED);
            }
        });
        cmdResize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (fram.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                    fram.setExtendedState(JFrame.NORMAL);
                    main.gbrandapplication.imageItem.setRound(35);
                    main.gbrandapplication.backgroundPanel.setRadius(35);                    
                } else {
                    fram.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    main.gbrandapplication.imageItem.setRound(0);
                    main.gbrandapplication.backgroundPanel.setRadius(0);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconClose = new javaswingdev.GoogleMaterialIcon();
        iconMinimize = new javaswingdev.GoogleMaterialIcon();
        iconMax = new javaswingdev.GoogleMaterialIcon();
        iconRestore = new javaswingdev.GoogleMaterialIcon();
        cmdClose = new component.model.titleBar.buttonTitle();
        cmdResize = new component.model.titleBar.buttonTitle();
        cmdMinimize = new component.model.titleBar.buttonTitle();

        iconClose.setColor1(new java.awt.Color(111, 111, 111));
        iconClose.setColor2(new java.awt.Color(215, 215, 215));
        iconClose.setIcon(javaswingdev.GoogleMaterialDesignIcon.CLOSE);
        iconClose.setSize(18);

        iconMinimize.setColor1(new java.awt.Color(111, 111, 111));
        iconMinimize.setColor2(new java.awt.Color(215, 215, 215));
        iconMinimize.setIcon(javaswingdev.GoogleMaterialDesignIcon.REMOVE);
        iconMinimize.setSize(18);

        iconMax.setColor1(new java.awt.Color(111, 111, 111));
        iconMax.setColor2(new java.awt.Color(215, 215, 215));
        iconMax.setIcon(javaswingdev.GoogleMaterialDesignIcon.CONTENT_COPY);
        iconMax.setSize(16);

        iconRestore.setColor1(new java.awt.Color(111, 111, 111));
        iconRestore.setColor2(new java.awt.Color(215, 215, 215));
        iconRestore.setIcon(javaswingdev.GoogleMaterialDesignIcon.CROP_DIN);

        cmdClose.setHoverColor(new java.awt.Color(248, 248, 248));

        cmdResize.setHoverColor(new java.awt.Color(248, 248, 248));

        cmdMinimize.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 1, 1, 1));
        cmdMinimize.setHoverColor(new java.awt.Color(248, 248, 248));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cmdMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdResize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmdClose, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(cmdResize, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(cmdMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.model.titleBar.buttonTitle cmdClose;
    private component.model.titleBar.buttonTitle cmdMinimize;
    private component.model.titleBar.buttonTitle cmdResize;
    private javaswingdev.GoogleMaterialIcon iconClose;
    private javaswingdev.GoogleMaterialIcon iconMax;
    private javaswingdev.GoogleMaterialIcon iconMinimize;
    private javaswingdev.GoogleMaterialIcon iconRestore;
    // End of variables declaration//GEN-END:variables
}
