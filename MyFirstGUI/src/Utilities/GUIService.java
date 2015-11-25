package Utilities;

import java.awt.*;

/**
 * Created by Daniel Shchepetov on 24.11.2015.
 */
public class GUIService {
    public static GridBagConstraints setLabelConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 2, 2, 2);
        c.anchor = GridBagConstraints.BASELINE_LEADING;
        c.weightx = 0.0;


        return c;
    }

    public  static GridBagConstraints setTextFieldConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 2, 2, 2);
        c.anchor = GridBagConstraints.BASELINE;
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = GridBagConstraints.REMAINDER;
        return c;
    }

    public static GridBagConstraints setTopLabelConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.BASELINE_LEADING;
        c.weightx = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        return c;
    }



}
