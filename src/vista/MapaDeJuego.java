package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controlador.Controlador;

public class MapaDeJuego extends JFrame implements KeyListener{
	JLabel[] panel;
	JButton sapito;
	JPanel p;
	int[][] consola;
	Controlador c= new Controlador();
	public MapaDeJuego(){

		this.consola = c.getTablero();
		panel = new JLabel[29];
		p = new JPanel();
		p.setLayout(null);
		setTitle("Bitsi Bitsi");
		setSize(920, 950);
		setResizable(true);
        addKeyListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				panel[i] = new JLabel();
				if(consola[i][j] == 0)
				{
					panel[i] = new JLabel(new ImageIcon("Nenufar.gif"));
					panel[i].setBounds(i*60,j*60,60,60);
				}
				if(consola[i][j] == 1)
				{
					panel[i] = new JLabel(new ImageIcon("Telaraña.gif"));
					panel[i].setBounds(i*60,j*60,60,60);
				}
				if(consola[i][j] == 2)
				{
					panel[i] = new JLabel(new ImageIcon("Mosca.gif"));
					panel[i].setBounds(i*60,j*60,60,60);
				}
				if(consola[i][j] == 3)
				{
					sapito = new JButton(new ImageIcon("Sapito.gif"));
					sapito.setBackground(Color.WHITE);
					sapito.setBorderPainted(false);
					sapito.addKeyListener(this);
					sapito.setBounds(i*60,j*60,60,60);
					add(sapito);
				}
				if(consola[i][j] == 4)
				{
					panel[i] = new JLabel(new ImageIcon("Araña.gif"));
					panel[i].setBounds(i*60,j*60,60,60);
				}
				
				
				add(panel[i]);
			}
		}

		add(p);
		setVisible(true);
	}
	
	public void actualizar()
	{
		
	}
	
	public JPanel getP() {
		return p;
	}
	public void setP(JPanel p) {
		this.p = p;
	}

	public void keyPressed(KeyEvent e) {
		 
		  int key = e.getKeyCode();
		  
		  if (key == KeyEvent.VK_D) {
			
			 JLabel jl = new JLabel(new ImageIcon("Nenufar.gif"));
			 jl.setBounds(c.getAr().getPosX()*60,c.getAr().getPosY()*60,60,60);
			 add(jl);
			 c.derecha();
			sapito.setBounds(c.getAr().getPosX()*60,c.getAr().getPosY()*60,60,60);
			}
		  if (key == KeyEvent.VK_A) {
			  JLabel jl = new JLabel(new ImageIcon("Nenufar.gif"));
				 jl.setBounds(c.getAr().getPosX()*60,c.getAr().getPosY()*60,60,60);
				 add(jl);
				 c.izquierda();
				sapito.setBounds(c.getAr().getPosX()*60,c.getAr().getPosY()*60,60,60);
				}
		  if (key == KeyEvent.VK_W) {
			  JLabel jl = new JLabel(new ImageIcon("Nenufar.gif"));
				 jl.setBounds(c.getAr().getPosX()*60,c.getAr().getPosY()*60,60,60);
				 add(jl);
				 c.arriba();
				sapito.setBounds(c.getAr().getPosX()*60,c.getAr().getPosY()*60,60,60);
				}
		  if (key == KeyEvent.VK_S) {
			  JLabel jl = new JLabel(new ImageIcon("Nenufar.gif"));
				 jl.setBounds(c.getAr().getPosX()*60,c.getAr().getPosY()*60,60,60);
				 add(jl);
				 c.abajo();
				sapito.setBounds(c.getAr().getPosX()*60,c.getAr().getPosY()*60,60,60);
				}
		  
		  if (key == KeyEvent.VK_ENTER) {
		 
		   System.out.println("Presionó Enter!" + (char) key);
		  }
		  if (key == KeyEvent.VK_SPACE) {
		 
		   System.out.println("Presionó Espacio!" + (char) key);
		  }
		 
		 }
		 
		 @Override
		 public void keyReleased(KeyEvent e) {
		  System.out.println("Soltó una tecla");
		 }
		 
		 @Override
		 public void keyTyped(KeyEvent e) {
		  System.out.println("Escribió una tecla");
		 }
}
