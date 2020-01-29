package modelo;
import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JLabel;

public class Sapito {
	String apariencia;
	int posX, posY;
	boolean moverArriba, moverAbajo, moverDerecha, moverIzquierda;
	int limX, limY;



	public Sapito(String apariencia, int posX, int posY) {
		super();
		this.apariencia = apariencia;
		this.posX = posX;
		this.posY = posY;
	}

	public Point posiciónInicial() {
		int x = ThreadLocalRandom.current().nextInt(0, limX);
		int y = ThreadLocalRandom.current().nextInt(0, limX);
		Point posInicial = new Point(x,y);
		return posInicial;
	}
	
	public void verificarMuros()
	{
//		if() {
//			
//		}
	}
	public String getApariencia() {
		return apariencia;
	}

	public void setApariencia(String apariencia) {
		this.apariencia = apariencia;
	}

	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public boolean isMoverArriba() {
		return moverArriba;
	}
	public void setMoverArriba(boolean moverArriba) {
		this.moverArriba = moverArriba;
	}
	public boolean isMoverAbajo() {
		return moverAbajo;
	}
	public void setMoverAbajo(boolean moverAbajo) {
		this.moverAbajo = moverAbajo;
	}
	public boolean isMoverDerecha() {
		return moverDerecha;
	}
	public void setMoverDerecha(boolean moverDerecha) {
		this.moverDerecha = moverDerecha;
	}
	public boolean isMoverIzquierda() {
		return moverIzquierda;
	}
	public void setMoverIzquierda(boolean moverIzquierda) {
		this.moverIzquierda = moverIzquierda;
	}
	public int getLimX() {
		return limX;
	}
	public void setLimX(int limX) {
		this.limX = limX;
	}
	public int getLimY() {
		return limY;
	}
	public void setLimY(int limY) {
		this.limY = limY;
	}
	
}
