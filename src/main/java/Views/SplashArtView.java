package Views;

import Listeners.ListenerSplashArtView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SplashArtView {
    private final JFrame JANELA;

    public SplashArtView(){
        this.JANELA = new JFrame();
        this.configuracaoSplash();
        this.addIconCenter();
        JANELA.addWindowListener(new ListenerSplashArtView());
        JANELA.setVisible(true);
        

    }
    private void configuracaoSplash(){
        Container div = JANELA.getContentPane();
        div.setBackground(new Color(249, 255, 145));
        JANELA.setLayout(null);
        JANELA.setSize(600,400);
        JANELA.setResizable(false);
        JANELA.setLocationRelativeTo(null);
        JANELA.setUndecorated(true);
        JANELA.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("img/icon.jpg"));
    }
    
    private void addIconCenter() {
    	BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("img/icon.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture), JLabel.CENTER);
			picLabel.setBounds(172, 72, 256, 256);
			JANELA.add(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }


}
