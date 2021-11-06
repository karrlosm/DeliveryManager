package Listeners.InfoPedidoView;

import Controllers.ControllerInfoPedidoView;
import Views.InfoPedidoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerButtons implements ActionListener {
        private ControllerInfoPedidoView controller;
        private InfoPedidoView info; 
    public ListenerButtons(InfoPedidoView infoPedidoView){
        this.controller = ControllerInfoPedidoView.getInstance(infoPedidoView);
        this.info = infoPedidoView;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton button = (JButton) actionEvent.getSource();
        if(button.getText().equals("Editar")){
            controller.update(info.getPedido());
        }else if(button.getText().equals("Deletar")){
            controller.delete(info.getPedido().getId());
        }else if (button.getText().equals("Voltar")){
            controller.voltar();
        }
    }
}
