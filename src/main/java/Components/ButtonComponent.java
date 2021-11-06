package Components;

import javax.swing.*;
import java.awt.*;

public class ButtonComponent extends JButton {

    private int roundDosCantos;
    private String hexCorDaBorda;

    public ButtonComponent(String texto, int arredondamento, String hexCorDaBorda) {
        super.setText(texto);
        roundDosCantos = arredondamento;
        this.hexCorDaBorda = hexCorDaBorda;
        setOpaque(false);
        super.setHorizontalAlignment(JLabel.CENTER);
    }
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, roundDosCantos, roundDosCantos);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(Color.decode(hexCorDaBorda));
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, roundDosCantos, roundDosCantos);
    }

}
