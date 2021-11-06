package Listeners.HomeView;

import Controllers.ControllerHomeView;
import Views.HomeView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class ListenerJTable implements MouseListener {
    ControllerHomeView controller;

    public ListenerJTable(HomeView home){
        this.controller= ControllerHomeView.getInstance(home);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() == 2){
            controller.colocaInformacoesNosCamposDaJanelaInfo(mouseEvent);
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
