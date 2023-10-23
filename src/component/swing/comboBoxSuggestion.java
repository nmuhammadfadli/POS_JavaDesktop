package component.swing;

import javax.swing.JComboBox;

public class comboBoxSuggestion<E> extends JComboBox<E> {

    public comboBoxSuggestion() {
        setUI(new comboSuggestionUI());
    }
}
