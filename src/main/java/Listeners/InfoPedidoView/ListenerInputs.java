package Listeners.InfoPedidoView;

import Controllers.ControllerInfoPedidoView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ListenerInputs implements KeyListener {

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        ControllerInfoPedidoView.foiAlterado();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
