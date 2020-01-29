package modelo;

import java.awt.Point;

public class Mosca {
	int posX, posY;
	String imagen;

	public Mosca(String imagen) {
		super();
		this.imagen = imagen;
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

	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
}
