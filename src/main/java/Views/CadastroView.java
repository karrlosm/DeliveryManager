package Views;

import Components.ButtonComponent;

import DynamicLayout.DynamicLayout;
import Listeners.CadastroView.ListenerButtons;

import javax.swing.*;
import java.awt.*;

public class CadastroView {

    private final PadraoView JANELA = new PadraoView();
    private final Font FONT2 = new Font("Arial",Font.BOLD,16);
    private final Font FONT = new Font("Impact",Font.PLAIN,35);
    private final Color CINZA = new Color(80, 80, 80);
    private JPanel painelForm;

    private JTextField nome,email,senha;

    public CadastroView() {
        this.addPainel();
        this.addImgUser();
        this.addLabels();
        this.addForm();
        this.addJButtons();
        this.JANELA.setVisible(true);
    }



    private void addPainel(){
        this.painelForm = new JPanel();
        this.painelForm.setBounds(260,80,400,400);
        this.painelForm.setLayout(new DynamicLayout(400,400));
        this.painelForm.setBackground(new Color(255, 210, 100));

        this.JANELA.add(painelForm);
    }

    private void addImgUser(){
        JLabel label = new JLabel("",JLabel.CENTER);
        ImageIcon userImagem = new ImageIcon("img/user.jpg");
        label.setBounds(10,10,390,120);
        label.setIcon(userImagem);
        this.painelForm.add(label);
    }
    private void addForm(){
        Color laranja = new Color(65, 64, 62);
        Color amarelin = new Color(246, 252, 151);
        this.nome  = new JTextField();
        this.email = new JTextField();
        this.senha = new JTextField();

        nome.setBounds(190,140,205,30);
        nome.setFont(FONT2);
        nome.setBackground(amarelin);
        nome.setForeground(laranja);
        nome.setBorder(null);

        email.setBounds(190,195,205,30);
        email.setFont(FONT2);
        email.setBackground(amarelin);
        email.setForeground(laranja);
        email.setBorder(null);

        senha.setBounds(190,250,205,30);
        senha.setFont(FONT2);
        senha.setBackground(amarelin);
        senha.setForeground(laranja);
        senha.setBorder(null);

        this.painelForm.add(nome);
        this.painelForm.add(email);
        this.painelForm.add(senha);

    }

    private void addLabels(){
        JLabel nome,email,senha;
        nome= new JLabel("Digite seu nome:",JLabel.CENTER);
        email = new JLabel("Digite seu email:", JLabel.CENTER);
        senha = new JLabel("Digite sua senha:", JLabel.CENTER);

        nome.setBounds(0,140,180,30);
        nome.setFont(FONT2);


        email.setBounds(0,195,180,30);
        email.setFont(FONT2);


        senha.setBounds(0,250,180,30);
        senha.setFont(FONT2);



        this.painelForm.add(nome);
        this.painelForm.add(email);
        this.painelForm.add(senha);

    }

    private void addJButtons(){
        ListenerButtons listenerButtons = new ListenerButtons(this);
        JButton cadastrar = new ButtonComponent("Cadastrar",15,"#000000");
        JButton voltar = new ButtonComponent("Tenho cadastro",15,"#000000");

        cadastrar.setBounds(50,300,300,40);
        cadastrar.setBackground(CINZA);
        cadastrar.setForeground(new Color(255, 179, 0));
        cadastrar.addActionListener(listenerButtons);
        cadastrar.setFont(FONT);

        voltar.setBounds(50,355,300,40);
        voltar.setBackground(CINZA);
        voltar.setForeground(new Color(255, 179, 0));
        voltar.addActionListener(listenerButtons);
        voltar.setFont(FONT);

        this.painelForm.add(cadastrar);
        this.painelForm.add(voltar);
    }


    public String getNome() {
        return nome.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getSenha() {
        return senha.getText();
    }

    public PadraoView getJANELA() {
        return JANELA;
    }
}
