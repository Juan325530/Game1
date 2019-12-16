import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Enemigos {
	private int x;
	private int y;
	//Parametros dentro de la imagen principal
	private int altoImagen;
	private int anchoImagen;
	private int xImagen;
	private int yImagen;
	private String indiceImagen;
	private int velocidad;
	private boolean capturado;
	
	public Enemigos(int x, int y, int anchoImagen, int altoImagen, int xImagen, int yImagen, String indiceImagen,
			int velocidad) {
		super();
		this.x = x;
		this.y = y;
		this.altoImagen = altoImagen;
		this.anchoImagen = anchoImagen;
		this.xImagen = xImagen;
		this.yImagen = yImagen;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
	}
	
	public Enemigos(int tipoTile,int x, int y, String indiceImagen, int velocidad){
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		//this.invertir = invertir;
		switch(tipoTile){
			case 1: 
				this.altoImagen = 53;
				this.anchoImagen = 72;
				this.xImagen = 6;
				this.yImagen = 76;
			break;
			case 2: 
				this.altoImagen = 53;
				this.anchoImagen = 72;
				this.xImagen = 64;
				this.yImagen = 78;
			break;
			case 3: 
				this.altoImagen = 53;
				this.anchoImagen = 72;
				this.xImagen = 124;
				this.yImagen = 80;
			break;
	
		}
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getAltoImagen() {
		return altoImagen;
	}
	public void setAltoImagen(int altoImagen) {
		this.altoImagen = altoImagen;
	}
	public int getAnchoImagen() {
		return anchoImagen;
	}
	public void setAnchoImagen(int anchoImagen) {
		this.anchoImagen = anchoImagen;
	}
	public int getxImagen() {
		return xImagen;
	}
	public void setxImagen(int xImagen) {
		this.xImagen = xImagen;
	}
	public int getyImagen() {
		return yImagen;
	}
	public void setyImagen(int yImagen) {
		this.yImagen = yImagen;
	}
	public String getIndiceImagen() {
		return indiceImagen;
	}
	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public void pintar(GraphicsContext graficos) {
			graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen, 
				this.x--, this.y,
				this.anchoImagen, this.altoImagen
			);
			
			/*
			 * graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen, 
				this.x + (invertir==-1?70:0), this.y,
				this.anchoImagen*invertir, this.altoImagen
			);*/
		
	}
	
	
	


/*
if (condicion)
	verdadero
else 
	falso
	
	
condicion?verdadero:falso;*/
public Rectangle obtenerRectangulo() {
	return new Rectangle(this.x, this.y, 72,53);
}

public boolean isCapturado() {
	return capturado;
}

public void setCapturado(boolean capturado) {
	this.capturado = capturado;
}
}