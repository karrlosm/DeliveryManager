package Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import Components.ButtonComponent;
import Components.JLabelIntoCell;
import Listeners.HomeView.ListenerButtons;
import DynamicLayout.DynamicLayout;
import Listeners.HomeView.ListenerJTable;
import Listeners.HomeView.ListenerWindow;
import Models.Pedido;
import Models.TableModelPedido;
import Models.UserPedido;

public class HomeView{
	//ListenerButtons = botao de adicionar
	private final PadraoView JANELA = new PadraoView();
	private JButton adicionar = new JButton("Adicionar");
	public final JPanel painelForm =  new JPanel();
	private JPanel painelPedidos;
	private final Font FONT2 = new Font("Arial",Font.BOLD,16);
	private final Font FONT = new Font("Impact",Font.PLAIN,25);
	private Color cinza = new Color(80, 80, 80);


	private DefaultTableModel defaultTableModel;
	private JTable table;
	private List<Pedido> pedidos;
	private UserPedido user;

	public HomeView(UserPedido user) {
		this.user=user;
		this.addPanelForm();
		this.addPanelPedidos();
		this.addPanelForm();
		this.addFormLabels();
		this.addInputs();
		this.addListenerInPreco();
		this.addButtons();
		this.addLabelNovoPedido();
		this.addLabelFeitos();
		this.addTable();
		this.addButtonLogout();
		this.JANELA.addWindowListener(new ListenerWindow(this));
		this.JANELA.setVisible(true);
	}

	private JTextField nomePedido;
	private JTextField nomeComprador;
	private JTextField preco;
	private JTextArea descricao;
	private void addPanelForm() {
        painelForm.setBounds(20,100,290,360);
        painelForm.setLayout(new DynamicLayout(290, 360));
        painelForm.setBackground(new Color(255, 210, 100));
        this.JANELA.add(this.painelForm);
	}


	private void addPanelPedidos() {
		painelPedidos = new JPanel();
        painelPedidos.setLayout(new DynamicLayout(560, 360));
        painelPedidos.setBounds(330,100,560,360);
        painelPedidos.setBackground(new Color(255, 210, 100));
        this.JANELA.add(this.painelPedidos);

	}

	private void addLabelNovoPedido() {
		JLabel novoPedido = new JLabel("Novo Pedido:");
		novoPedido.setFont(FONT);
		novoPedido.setForeground(new Color(80, 80, 80));
		novoPedido.setBounds(20, 60, 290, 40);
		this.JANELA.add(novoPedido);
	}

	private void addLabelFeitos() {
		JLabel pedidosFeitos = new JLabel("Pedidos feitos:");
		pedidosFeitos.setFont(FONT);
		pedidosFeitos.setForeground(new Color(80, 80, 80));
		pedidosFeitos.setBounds(330, 60, 535, 40);
		this.JANELA.add(pedidosFeitos);
	}

	private void addFormLabels() {
		JLabel nomeP = new JLabel("Nome do pedido:", JLabel.CENTER);
		JLabel nomeC = new JLabel("Nome do comprador:",JLabel.CENTER);
		JLabel preco = new JLabel("Preco (R$):", JLabel.CENTER);
		JLabel descricao = new JLabel ("Descricao:",JLabel.CENTER);

		nomeP.setBounds(0, 0, 290, 30);
		nomeP.setFont(FONT2);
		nomeP.setForeground(cinza);

		nomeC.setBounds(0, 60, 290, 30);
		nomeC.setFont(FONT2);
		nomeC.setForeground(cinza);

		preco.setBounds(0, 120, 290, 30);
		preco.setFont(FONT2);
		preco.setForeground(cinza);

		descricao.setBounds(0, 175, 290, 30);
		descricao.setFont(FONT2);
		descricao.setForeground(cinza);

		this.painelForm.add(nomeP);
		this.painelForm.add(nomeC);
		this.painelForm.add(preco);
		this.painelForm.add(descricao);

	}

	private void addInputs() {
		Color laranja = new Color(65, 64, 62);
		Color amarelin = new Color(249, 255, 145);
		nomePedido = new JTextField();
		nomePedido.setBounds(40, 30, 220, 30);
		nomePedido.setBackground(amarelin);
        nomePedido.setForeground(laranja);
        nomePedido.setFont(FONT2);
        nomePedido.setBorder(null);
		nomePedido.setHorizontalAlignment(JTextField.CENTER);

        nomeComprador = new JTextField();
        nomeComprador.setBounds(40, 85, 220, 30);
        nomeComprador.setBackground(amarelin);
        nomeComprador.setForeground(laranja);
        nomeComprador.setFont(FONT2);
        nomeComprador.setBorder(null);
		nomeComprador.setHorizontalAlignment(JTextField.CENTER);

        preco = new JTextField();
        preco.setBounds(40, 145, 220, 30);
        preco.setBackground(amarelin);
        preco.setForeground(laranja);
        preco.setFont(FONT2);
        preco.setBorder(null);
		preco.setHorizontalAlignment(JTextField.CENTER);

        descricao = new JTextArea();
        descricao.setBackground(amarelin);
        descricao.setForeground(laranja);
		descricao.setLineWrap(true);
        descricao.setFont(FONT2);
		JScrollPane spDescricao = new JScrollPane( descricao );
		spDescricao.setBounds(40, 200,220, 90);//Adiciona Scroll a TextArea
		this.JANELA.getContentPane().add(spDescricao); //

        this.painelForm.add(nomePedido);
        this.painelForm.add(nomeComprador);
        this.painelForm.add(preco);
        this.painelForm.add(spDescricao);
	}

	private void addButtons() {
		adicionar.setBounds(48, 303, 200, 45);
		adicionar.setBackground(cinza);
		adicionar.setForeground(new Color(255, 179, 0));
		adicionar.setBorder(null);
		adicionar.setFont(FONT);
		adicionar.addActionListener(new ListenerButtons(this));
		this.painelForm.add(adicionar);
	}

	public JFrame getJANELA() {
		return JANELA;
	}

	public void cleanTheForm(){
		this.nomePedido.setText("");
		this.nomeComprador.setText("");
		this.preco.setText("");
		this.descricao.setText("");
	}

	private void addListenerInPreco(){ //Permiss�o de apenas n�meros ou .
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
	}

	//reunião
	private void addTable(){
		this.defaultTableModel = new TableModelPedido();

		this.defaultTableModel.addColumn("Comprador");
		this.defaultTableModel.addColumn("Nome do pedido");
		this.defaultTableModel.addColumn("Data");
		this.defaultTableModel.addColumn("Descrição");
		this.defaultTableModel.addColumn("Preço");

		table = new JTable(this.defaultTableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		for(int i =0; i <=4; i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(170);
		}
		table.setBackground(new Color(255, 210, 100));
		table.setSelectionBackground(new Color(234, 180, 49));
		table.setForeground(Color.BLACK);
		table.setDefaultRenderer(Object.class, new JLabelIntoCell());
		table.setLayout(new DynamicLayout(560,360));
		table.getTableHeader().setFont(new Font("Impact",Font.PLAIN,15));
		table.getTableHeader().setBackground(Color.decode("#404040"));
		table.getTableHeader().setForeground(new Color(255, 179, 0));
		table.getTableHeader().setFont(new Font("Arial",Font.BOLD,14));
		table.getTableHeader().setReorderingAllowed(false);
		table.addMouseListener(new ListenerJTable(this));



		JScrollPane scroll = new JScrollPane(table);
		scroll.getViewport().setBackground(new Color(255, 210, 100));
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(0,0,560,360);


		this.painelPedidos.add(scroll);
	}

	private void addButtonLogout(){
		JPanel painel = this.JANELA.getPainelTitulo();
		JButton sair = new ButtonComponent("Sair",10,"#000000");
		sair.setBackground(cinza);
		sair.setFont(new Font("Impact",Font.PLAIN,17));
		sair.setForeground(new Color(255, 179, 0));
		sair.setBounds(790,10,100,40);
		sair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				JANELA.dispose();
				new LoginView();
			}
		});
		painel.add(sair);

	}

	public UserPedido getUser() {
		return user;
	}

	public List<Pedido> getPedidos(){
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	

	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}

	public JTable getTable() {
		return table;
	}

	public JTextField getNomePedido() {
		return nomePedido;
	}

	public JTextField getNomeComprador() {
		return nomeComprador;
	}

	public JTextField getPreco() {
		return preco;
	}

	public JTextArea getDescricao() {
		return descricao;
	}
}
