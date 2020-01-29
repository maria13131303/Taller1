package controlador;

import javax.swing.ImageIcon;

import modelo.Sapito;
import modelo.Mosca;
import vista.InterfazBitsi;
import vista.MapaDeJuego;

public class Controlador {
	int[][] tablero;
	int dificultad;
	Mosca[] moscas;
	Sapito ar;
	MapaDeJuego mj;
	
	public Controlador(){
		inicio();
		generarMoscas();
	}
	
	public void inicio()
	{
		dificultad = 3;
		moscas = new Mosca[dificultad];
		tablero = new int[15][15];
		String img = "Mosca.gif";
		ar = new Sapito(img,1,1);
		generarRana();
		generarMuros(dificultad, tablero);
		while(asegurarCamino() == false)
		{
			inicio();
		}
	}
	
	public void generarRana()
	{

			tablero[ar.getPosX()][ar.getPosY()] = 3;
	}
	
	public void derecha()
	{
			ar.setPosX(ar.getPosX()+1);
			ar.setPosY(ar.getPosY());
			tablero[ar.getPosX()][ar.getPosY()] = 3;

	}
	
	public void izquierda()
	{
			ar.setPosX(ar.getPosX()-1);
			ar.setPosY(ar.getPosY());
			tablero[ar.getPosX()][ar.getPosY()] = 3;
	}
	
	public void arriba()
	{
			ar.setPosX(ar.getPosX());
			ar.setPosY(ar.getPosY()-1);
			tablero[ar.getPosX()][ar.getPosY()] = 3;
	}
	
	public void abajo()
	{
			ar.setPosX(ar.getPosX());
			ar.setPosY(ar.getPosY()+1);
			tablero[ar.getPosX()][ar.getPosY()] = 3;
	}
	
	public int[][] generarMuros(int dificultad, int[][] tablero)
	{
		int x, y;
		for (int i = 0; i < 15; i++) 
		{
			for (int j = 0; j < 15; j++) 
			{
				if(i ==0 || i == 14 || j ==0 || j == 14 )
				{
					tablero[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < dificultad*15; i++) 
		{
			x = (int) (Math.random()*15)+0;
			y = (int) (Math.random()*15)+0;
			while (tablero[x][y]!=0) 
			{
				x = (int) (Math.random()*15)+0;
				y = (int) (Math.random()*15)+0;
			}
			tablero[x][y] = 1;
		}
		tablero[13][13] = 0;
		return tablero;
	}
	
	public void generarMoscas()
	{
		int x,y;
		
		for (int i = 0; i < dificultad*2; i++) {
			x = (int) (Math.random()*15)+0;
			y = (int) (Math.random()*15)+0;
			while(tablero[x][y] != 0 || tablero[x+1][y]!=0 || tablero[x-1][y]!=0||
					tablero[x][y+1]!=0 || tablero[x][y-1]!=0 || tablero[x+1][y+1]==2|| 
					tablero[x-1][y-1]==2 || tablero[x+1][y-1]==2 || tablero[x-1][y+1]==2) {
				x = (int) (Math.random()*15)+0;
				y = (int) (Math.random()*15)+0;
			}
			tablero[x][y] = 2;
		}
	}
	
	public boolean asegurarCaminoVisual()
	{
		int x = ar.getPosX();
		int y = ar.getPosY();
		int mov = 0;
		boolean posible = false;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if(tablero[i][j]==2)
				{
					tablero[i][j]=0;
				}
			}
		}
			while(mov < dificultad*40) 
			{
				if (y == 13 && x < 13 && tablero[x][y+1]!=1) 
				{
					x++;
					tablero[x][y] = 2;
					actualizarMapa();
					mov++;
				}
				
				if (x == 13 && y < 13 && tablero[x][y+1]!=1) 
				{
					y++;
					tablero[x][y] = 2;
					actualizarMapa();
					mov++;
				}
						
				if(x+1<14 && tablero[x+1][y]!=1)
				{
				x++;
				tablero[x][y] = 2;
				actualizarMapa();
				mov++;
				}
				else
				{
					if(x-1>0 && tablero[x-1][y]!=1)
					{
					x--;
					tablero[x][y] = 2;
					actualizarMapa();
					mov++;
					}
				}
				
				
				if(y+1<14 && tablero[x][y+1]!=1)
				{
				y++;
				tablero[x][y] = 2;
				actualizarMapa();
				mov++;
				}
				else
				{
					if(y-1>0 && tablero[x][y-1]!=1)
					{
						y--;
						tablero[x][y] = 2;
						actualizarMapa();
						mov++;
					}	
				}
				
				if (y == 13 && x == 13) 
				{
					posible = true;
					actualizarMapa();
					mov = 999;
				}
				mov++;
		}
			
			tablero[x][y] = 3;
			return posible;
	}

	public boolean asegurarCamino()
	{
		int x = ar.getPosX();
		int y = ar.getPosY();
		int mov = 0;
		boolean posible = false;
			while(mov < dificultad*40) 
			{
				if (y == 13 && x < 13 && tablero[x][y+1]!=1) 
				{
					x++;
					mov++;
				}
				
				if (x == 13 && y < 13 && tablero[x][y+1]!=1) 
				{
					y++;
					mov++;
				}
						
				if(x+1<14 && tablero[x+1][y]!=1)
				{
				x++;
				mov++;
				}
				else
				{
					if(x-1>0 && tablero[x-1][y]!=1)
					{
					x--;
					mov++;
					}
				}
				
				
				if(y+1<14 && tablero[x][y+1]!=1)
				{
				y++;
				mov++;
				}
				else
				{
					if(y-1>0 && tablero[x][y-1]!=1)
					{
						y--;
						mov++;
					}	
				}
				
				if (y == 13 && x == 13) 
				{
					posible = true;

					mov = 999;
				}
				mov++;
		}
			
			tablero[x][y] = 4;
			return posible;
	}
	public void actualizarMapa()
	{
		mj = new MapaDeJuego();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Sapito getAr() {
		return ar;
	}

	public void setAr(Sapito ar) {
		this.ar = ar;
	}

	public int[][] getTablero() {
		return tablero;
	}

	public void setTablero(int[][] tablero) {
		this.tablero = tablero;
	}
	
}
