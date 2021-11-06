package Listeners.CadastroView;

import Controllers.ControllerCadastroView;
import Views.CadastroView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerButtons implements ActionListener {

    private ControllerCadastroView controller;
    public ListenerButtons(CadastroView cadastroView) {
        this.controller = ControllerCadastroView.getInstance(cadastroView);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton button = (JButton) actionEvent.getSource();
        if(button.getText().equals("Cadastrar")){
            controller.adicionarUser();
        }else{
            controller.voltarParaTelaDeLogin();
        }
    }
}
