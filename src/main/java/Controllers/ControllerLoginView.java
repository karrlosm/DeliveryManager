package Controllers;

import DAO.CRUDUserDAO;
import Models.UserPedido;
import Views.CadastroView;
import Views.HomeView;
import Views.LoginView;

import javax.swing.*;

public class ControllerLoginView {

    private static ControllerLoginView instance;
    private static LoginView loginView;
    private CRUDUserDAO crud = CRUDUserDAO.getInstance();

    private ControllerLoginView(){

    }

    public static ControllerLoginView getInstance(LoginView login){
        if(instance == null){
            instance = new ControllerLoginView();
        }
        loginView = login;
        return instance;
    }

    public void irParaTelaDeCadastro(){
        loginView.getJANELA().dispose();
        new CadastroView();
    }
    public void login(){
        try {
            String emailDigitado = loginView.getEmail();
            String senhaDigitado = loginView.getSenha();

            UserPedido user = crud.getByEmail(emailDigitado);

            if(emailDigitado.equals(user.getEmail()) && senhaDigitado.equals(user.getSenha())){
                loginView.getJANELA().dispose();
                new HomeView(user);
            }else{
                JOptionPane.showMessageDialog(loginView.getJANELA(),"Login incorreto");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(loginView.getJANELA(),"Você não possui cadastro");
        }
    }
}
