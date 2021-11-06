package Views;

import Components.ButtonComponent;
import DynamicLayout.DynamicLayout;
import Listeners.InfoPedidoView.ListenerButtons;
import Listeners.InfoPedidoView.ListenerInputs;
import Models.Pedido;
import Models.UserPedido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class InfoPedidoView {
    private final JFrame JANELA = new PadraoView();
    private JPanel panel;
    private Color cinza = new Color(80, 80, 80);
    private final Font FONT2 = new Font("Impact",Font.PLAIN,25);

    private Pedido pedido;
    private UserPedido user;

    public InfoPedidoView(Pedido pedido, UserPedido user) {
        this.pedido = pedido;
        this.user=user;
        addPainelInfo();
        addLabels();
        addInputs();
        this.addButtons();
        this.JANELA.setVisible(true);
    }

    public UserPedido getUser() {
        return user;
    }

    public Pedido getPedido() {
    	pedido.setNomeDoPedido(nomePedido.getText());
    	pedido.setDescricao(descricao.getText());
    	pedido.setComprador(nomeComprador.getText());
    	pedido.setPreco(Float.parseFloat(preco.getText()));
		return pedido;
	}

	private JTextField nomePedido;
    private JTextField nomeComprador;
    private JTextField preco;
    private JTextArea descricao;

    public void addPainelInfo(){
        panel = new JPanel();
        panel.setBounds(230,65,440,430);
        panel.setBackground(new Color(255, 210, 100));
        panel.setLayout(new DynamicLayout(440,630));
        panel.setPreferredSize(new Dimension(0, 630));
        JScrollPane scroll = new JScrollPane(panel);
        scroll.setBounds(230,65,440,430);
        scroll.getVerticalScrollBar().setUnitIncrement(10);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.JANELA.add(scroll);
    }
    public void addLabels(){
        JLabel nomeP = new JLabel("Nome do pedido:", JLabel.CENTER);
        JLabel nomeC = new JLabel("Nome do comprador:",JLabel.CENTER);
        JLabel preco = new JLabel("Preco (R$):", JLabel.CENTER);
        JLabel descricao = new JLabel ("Descricao:",JLabel.CENTER);

        nomeP.setBounds(5, 15, 435, 32);
        nomeP.setFont(FONT2);
        nomeP.setForeground(cinza);

        nomeC.setBounds(5, 105, 435, 32);
        nomeC.setFont(FONT2);
        nomeC.setForeground(cinza);

        preco.setBounds(5, 195, 435, 32);
        preco.setFont(FONT2);
        preco.setForeground(cinza);

        descricao.setBounds(5, 285, 435, 32);
        descricao.setFont(FONT2);
        descricao.setForeground(cinza);

        this.panel.add(nomeP);
        this.panel.add(nomeC);
        this.panel.add(preco);
        this.panel.add(descricao);
    }
    public void addInputs(){
        Color laranja = new Color(65, 64, 62);
        Color amarelin = new Color(249, 255, 145);
        nomePedido = new JTextField();
        nomePedido.setBounds(100, 45, 260, 40);
        nomePedido.setBackground(amarelin);
        nomePedido.setForeground(laranja);
        nomePedido.setFont(FONT2);
        nomePedido.setBorder(null);
        nomePedido.setHorizontalAlignment(JTextField.CENTER);
        nomePedido.setText(pedido.getNomeDoPedido());
        nomePedido.addKeyListener(new ListenerInputs()); 

        nomeComprador = new JTextField();
        nomeComprador.setBounds(100, 135, 260, 40);
        nomeComprador.setBackground(amarelin);
        nomeComprador.setForeground(laranja);
        nomeComprador.setFont(FONT2);
        nomeComprador.setBorder(null);
        nomeComprador.setHorizontalAlignment(JTextField.CENTER);
        nomeComprador.setText(pedido.getComprador());
        nomeComprador.addKeyListener(new ListenerInputs());

        preco = new JTextField();
        preco.setBounds(100, 225, 260, 40);
        preco.setBackground(amarelin);
        preco.setForeground(laranja);
        preco.setFont(FONT2);
        preco.setBorder(null);
        preco.setHorizontalAlignment(JTextField.CENTER);
        preco.setText(String.valueOf(pedido.getPreco()));
        preco.addKeyListener(new ListenerInputs());
        preco.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                String caracteres = "0123456789.";
                if(!caracteres.contains(keyEvent.getKeyChar()+"")){
                    keyEvent.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });


        descricao = new JTextArea();
        descricao.setBackground(amarelin);
        descricao.setForeground(laranja);
        descricao.setLineWrap(true);
        descricao.setFont(FONT2);
        descricao.setText(pedido.getDescricao());
        descricao.addKeyListener(new ListenerInputs());
        JScrollPane spDescricao = new JScrollPane( descricao );
        spDescricao.setBounds(100, 320,260, 105);//Adiciona Scroll a TextArea
        this.panel.add(spDescricao);

        this.panel.add(nomePedido);
        this.panel.add(nomeComprador);
        this.panel.add(preco);
        this.panel.add(spDescricao);
    }

    public void addButtons(){
        JButton editar = new ButtonComponent("Editar",10,"#000000");
        JButton deletar = new ButtonComponent("Deletar",10,"#000000");
        JButton voltar = new ButtonComponent("Voltar",10,"#000000");
        ListenerButtons listenerButtons = new ListenerButtons(this);

        editar.setBounds(125,450,210,40);
        editar.setFont(FONT2);
        editar.setForeground(Color.black);
        editar.setBackground(Color.decode("#00cc00"));
        editar.addActionListener(listenerButtons);

        deletar.setBounds(125,510,210,40);
        deletar.setForeground(Color.black);
        deletar.setBackground(Color.decode("#ff3333"));
        deletar.setFont(FONT2);
        deletar.addActionListener(listenerButtons);

        voltar.setBounds(125,565,210,40);
        voltar.setForeground(Color.black);
        voltar.setBackground(Color.decode("#66ccff"));
        voltar.setFont(FONT2);
        voltar.addActionListener(listenerButtons);


        this.panel.add(editar);
        this.panel.add(deletar);
        this.panel.add(voltar);
    }

    public JFrame getJANELA() {
        return JANELA;
    }
}
