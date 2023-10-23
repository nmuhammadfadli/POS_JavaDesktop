package component.model.titleBar;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class titleBar extends javax.swing.JPanel {

    private componentResizer resize;
    private int x;
    private int y;

    public titleBar() {
        initComponents();
        setOpaque(false);
    }

    public void init(JFrame fram) {
        resize = new componentResizer();
        resize.setSnapSize(new Dimension(10, 10));
        resize.setMinimumSize(new Dimension(1050, 650));
        resize.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        resize.registerComponent(fram);
        initMoving(fram);
        buttonBar.initEvent(fram);
    }

    private void initMoving(JFrame fram) {
        panelMove.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (fram.getExtendedState() != JFrame.MAXIMIZED_BOTH && SwingUtilities.isLeftMouseButton(me)) {
                    x = me.getX() + 3;
                    y = me.getY() + 3;
                    main.gbrandapplication.imageItem.setRound(35);
                    main.gbrandapplication.backgroundPanel.setRadius(35);
                }
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me) && me.getClickCount() == 2) {
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
            }

        });
        panelMove.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    if (fram.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                        fram.setExtendedState(JFrame.NORMAL);
                        main.gbrandapplication.imageItem.setRound(35);
                        main.gbrandapplication.backgroundPanel.setRadius(35);
                    }
                    fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMove = new javax.swing.JPanel();
        buttonBar = new component.model.titleBar.buttonBar();

        setBackground(new java.awt.Color(50, 50, 50));

        panelMove.setOpaque(false);

        javax.swing.GroupLayout panelMoveLayout = new javax.swing.GroupLayout(panelMove);
        panelMove.setLayout(panelMoveLayout);
        panelMoveLayout.setHorizontalGroup(
            panelMoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 909, Short.MAX_VALUE)
        );
        panelMoveLayout.setVerticalGroup(
            panelMoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelMove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.model.titleBar.buttonBar buttonBar;
    private javax.swing.JPanel panelMove;
    // End of variables declaration//GEN-END:variables
}
