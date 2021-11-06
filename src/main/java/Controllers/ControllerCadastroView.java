package Controllers;


import DAO.CRUDUserDAO;
import Models.UserPedido;
import Views.CadastroView;
import Views.LoginView;

import javax.swing.*;

public class ControllerCadastroView {

    private static ControllerCadastroView instance;
    private static CadastroView cadastroView;
    private CRUDUserDAO crud = CRUDUserDAO.getInstance();

    private ControllerCadastroView(){

    }

    public static ControllerCadastroView getInstance(CadastroView cadastro){
        if(instance == null){
            instance = new ControllerCadastroView();
        }
        cadastroView = cadastro;
        return instance;
    }
    public void adicionarUser(){
        try {
            UserPedido user= new UserPedido(
                    cadastroView.getNome(),
                    cadastroView.getEmail(),
                    cadastroView.getSenha()
            );
            crud.create(user);
            JOptionPane.showMessageDialog(cadastroView.getJANELA(),"Usuário criado com sucesso");
            voltarParaTelaDeLogin();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(cadastroView.getJANELA(),"Houve um problema");
        }
    }
    public void voltarParaTelaDeLogin(){
        cadastroView.getJANELA().dispose();
        new LoginView();
    }

}
