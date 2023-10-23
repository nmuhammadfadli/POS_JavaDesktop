package component.swing;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class scrollBarCustom extends JScrollBar {

    public scrollBarCustom() {
        setUI(new modernScrollBar());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(180, 180, 180));
        setBackground(Color.WHITE);
    }
}
