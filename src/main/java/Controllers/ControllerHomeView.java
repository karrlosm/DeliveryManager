package Controllers;

import DAO.CRUDPedidoDAO;
import Models.Pedido;
import Models.UserPedido;
import Views.HomeView;
import Views.InfoPedidoView;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

public class ControllerHomeView {

    private static HomeView home;
    private Pedido pedido;
    private static ControllerHomeView instance;
    private CRUDPedidoDAO crud = CRUDPedidoDAO.getInstance();
    private ControllerHomeView(){

    }

    public static ControllerHomeView getInstance(HomeView homeView){
        if(instance == null){
            instance = new ControllerHomeView();
        }
        home=homeView;
        return instance;
    }




    public void iniciarInfoIntoJTable(){
        try{
            List<Pedido> pedidos = CRUDPedidoDAO.getInstance().read(home.getUser().getId());
			for (Pedido pedido:pedidos) {
                System.out.println(pedido.getNomeDoPedido());
                Object ob []={
                    pedido.getComprador(),
                    pedido.getNomeDoPedido(),
                    pedido.getDataDaCompra(),
                    pedido.getDescricao(),
                    pedido.getPreco()};
                    home.getDefaultTableModel().addRow(ob);
                }
                home.setPedidos(pedidos);
            }catch(Exception e){
                JOptionPane.showMessageDialog(home.getJANELA(),
					"Houve um problema",
					"Problema",
					JOptionPane.INFORMATION_MESSAGE);
            }
    }

    public void adicionarPedido(){
        try {
            pedido = new Pedido(
                    home.getNomePedido().getText(),
                    new Date(),
                    home.getNomeComprador().getText(),
                    Float.parseFloat(home.getPreco().getText()),
                    home.getDescricao().getText(),
                    home.getUser());

            crud.create(pedido);
            home.cleanTheForm(); //Método na home
            atualizarJTable();
            JOptionPane.showMessageDialog(
                    home.getJANELA(),
                    "Criado com sucesso",
                    "Adicionado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    home.getJANELA(),
                    "Houve um problema",
                    "Problema",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void colocaInformacoesNosCamposDaJanelaInfo(MouseEvent mouseEvent){
        JTable cedula =(JTable) mouseEvent.getSource();
        int i = cedula.getSelectedRow();

        Pedido pedido = home.getPedidos().get(i);
        home.getJANELA().dispose();
        new InfoPedidoView(pedido,home.getUser());
    }
    private void atualizarJTable() throws Exception {
        int qtdItens = home.getPedidos().size();

        if(qtdItens == 0){
            pedido = crud.read(pedido.getUserPedido().getId()).get(0);
        }else {
            long id = home.getPedidos().get(qtdItens-1).getId();
            pedido.setId(id+1);
        }
        Object ob []={
                pedido.getComprador(),
                pedido.getNomeDoPedido(),
                pedido.getDataDaCompra(),
                pedido.getDescricao(),
                pedido.getPreco()};

			home.getDefaultTableModel().addRow(ob);
	        home.getTable().validate();
	        home.getPedidos().add(pedido);
		}


    }

