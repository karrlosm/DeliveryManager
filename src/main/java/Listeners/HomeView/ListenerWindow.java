package Listeners.HomeView;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import Controllers.ControllerHomeView;
import Views.HomeView;
public class ListenerWindow implements WindowListener{
    

    private ControllerHomeView controller;
    
    public ListenerWindow(HomeView home) {
        this.controller =  ControllerHomeView.getInstance(home);
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        controller.iniciarInfoIntoJTable();
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
         // TODO Auto-generated method stub
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }


}