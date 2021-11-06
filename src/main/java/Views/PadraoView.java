package Views;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DynamicLayout.DynamicLayout;

public class PadraoView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel painelTitulo;

	public PadraoView() {
		Container div = this.getContentPane();
		this.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("img/icon.jpg"));
		this.setLayout(new DynamicLayout(900, 500));
		div.setBackground(new Color(249, 255, 145));
		this.setSize(900,500);
		this.setMinimumSize(new Dimension(700,400));
		this.setTitle("DeliveryManager ");
		this.addJPainelTitulo();
		this.addTitulo();
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void addJPainelTitulo(){
        painelTitulo = new JPanel();
        painelTitulo.setLayout(new DynamicLayout(900, 60));
        painelTitulo.setBounds(0,0,900,60);
        painelTitulo.setBackground(new Color(255, 179, 0));
        this.add(this.painelTitulo);

    }

	public JPanel getPainelTitulo() {
		return painelTitulo;
	}

	public void addTitulo(){
        Font font = new Font("Impact",Font.PLAIN,50);
        JLabel titulo = new JLabel("Delivery Manager");
        titulo.setBounds(20, 3, 600, 55);
        titulo.setForeground(new Color(30, 30, 30));
        titulo.setFont(font);
        this.painelTitulo.add(titulo);

    }


}
