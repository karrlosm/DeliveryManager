package Listeners.LoginView;

import Controllers.ControllerLoginView;
import Views.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerButtons implements ActionListener {
    private ControllerLoginView controller;

    public ListenerButtons(LoginView loginView) {

        this.controller= ControllerLoginView.getInstance(loginView);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton button = (JButton)actionEvent.getSource();
        if(button.getText().equals("Entrar")){
            controller.login();
        }else{
            controller.irParaTelaDeCadastro();
        }


    }
}
