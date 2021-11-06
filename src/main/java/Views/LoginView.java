package Views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import Components.ButtonComponent;
import DynamicLayout.DynamicLayout;
import Listeners.LoginView.ListenerButtons;

public class LoginView {
	
	private final JFrame JANELA = new PadraoView();
	private final JPanel painelForm =  new JPanel();
	private final Font FONT2 = new Font("Arial",Font.BOLD,16);
	private final Font FONT = new Font("Impact",Font.PLAIN,30);
	private Color cinza = new Color(80, 80, 80);
	private JTextField email;
	private JPasswordField senha;
	
	public String getEmail() {
		return email.getText();
	}

	public String getSenha() {
		return senha.getText();
	}

	public LoginView() {
		this.addPanelForm();
		this.addImgUser();
		this.addLabelsForm();
		this.addInputs();
		this.addButtons();
		this.JANELA.setVisible(true);
	}
	
	private void addImgUser(){
        JLabel label = new JLabel("",JLabel.CENTER);
        ImageIcon userImagem = new ImageIcon("img/user.jpg");
        label.setBounds(0,2,400,120);
        label.setIcon(userImagem);
        this.painelForm.add(label);
    }
	
	private void addPanelForm() {
        painelForm.setBounds(250,80,400,400);
        painelForm.setLayout(new DynamicLayout(400,400));
        painelForm.setBackground(new Color(255, 210, 100));
        this.JANELA.add(this.painelForm);
	}
	
	private void addLabelsForm() {
		JLabel login = new JLabel("Login", JLabel.CENTER);
		login.setFont(FONT);
		login.setForeground(cinza);
		login.setBounds(0,120,400,50);
		this.painelForm.add(login);
		
		JLabel email = new JLabel("E-mail: ",JLabel.RIGHT);
		email.setFont(FONT2);
		email.setForeground(cinza);
		email.setBounds(0,160,80,55);
		this.painelForm.add(email);
		
		JLabel senha = new JLabel("Senha: ",JLabel.RIGHT );
		senha.setFont(FONT2);
		senha.setForeground(cinza);
		senha.setBounds(0,215,80,55);
		this.painelForm.add(senha);
		
		JLabel ou = new JLabel("Ou", JLabel.CENTER);
		ou.setFont(FONT2);
		//ou.setOpaque(true);
		ou.setBackground(Color.BLUE);
		ou.setForeground(cinza);
		ou.setBounds(0,310,400,55);
		this.painelForm.add(ou);
		
		
	}
	
	private void addInputs() {
		Color laranja = new Color(65, 64, 62);
		Color amarelin = new Color(249, 255, 145);
		email = new JTextField();
		email.setBounds(80, 165, 300, 40);
		email.setBackground(amarelin);
        email.setForeground(laranja);
        email.setFont(FONT2);
        email.setBorder(null);
        this.painelForm.add(email);
        
        senha = new JPasswordField();
		senha.setBounds(80, 220, 300, 40);
		senha.setBackground(amarelin);
        senha.setForeground(laranja);
        senha.setFont(FONT2);
        senha.setBorder(null);
        this.painelForm.add(senha);
	}
	
	private void addButtons () {
		ListenerButtons listenerButtons = new ListenerButtons(this);

		JButton entrar = new ButtonComponent("Entrar",10,"#000000");
		entrar.setBounds(125, 280, 150, 40);
		entrar.setBackground(cinza);
		entrar.setForeground(new Color(255, 179, 0));
		entrar.setBorder(null);
		entrar.setFont(FONT);
		entrar.addActionListener(listenerButtons);
		this.painelForm.add(entrar);
		
		JButton cadastre = new ButtonComponent("Cadastre-se",10,"#000000");
		cadastre.setBounds(100, 350, 200, 40);
		cadastre.setBackground(cinza);
		cadastre.setForeground(new Color(255, 179, 0));
		cadastre.setBorder(null);
		cadastre.setFont(FONT);
		cadastre.addActionListener(listenerButtons);
		this.painelForm.add(cadastre);
		
	}

	public JFrame getJANELA() {
		return JANELA;
	}
}
