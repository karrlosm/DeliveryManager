package Listeners;

import DAO.CRUDPedidoDAO;
import Views.HomeView;
import Views.LoginView;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ListenerSplashArtView implements WindowListener {
    @Override
    public void windowOpened(WindowEvent windowEvent) {
        JFrame janela = (JFrame) windowEvent.getSource();
        Thread thread = new Thread(() ->{
            try {
                CRUDPedidoDAO.getInstance();
                new LoginView();
                janela.dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        thread.start();
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }
}
