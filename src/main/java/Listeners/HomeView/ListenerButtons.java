package Listeners.HomeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import Controllers.ControllerHomeView;

import Views.HomeView;

public class ListenerButtons implements ActionListener {

	private ControllerHomeView controllerHomeView;
	public ListenerButtons(HomeView home) {
		this.controllerHomeView =ControllerHomeView.getInstance(home);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botao = (JButton) e.getSource();
		controllerHomeView.adicionarPedido();

	}

}

