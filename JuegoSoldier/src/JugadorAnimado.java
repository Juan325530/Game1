import java.util.HashMap;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class JugadorAnimado {
	private int x;
	private int y;
	private String indiceImagen;
	private int velocidad;
	private HashMap<String, Animacion> animaciones;
	private String animacionActual;
	private int puntuacion = 0;
	
	//Coordenadas para el fragmento de la imagen a pintar
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	
	public JugadorAnimado(int x, int y, String indiceImagen, int velocidad, String animacionActual) {
		super();
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		this.animacionActual = animacionActual;
		inicializarAnimaciones();
		
		
	}
	
	public String getAnimacionActual() {
		return animacionActual;
	}

	public void setAnimacionActual(String animacionActual) {
		this.animacionActual = animacionActual;
	}

	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
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
	public String getIndiceImagen() {
		return indiceImagen;
	}
	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}
	
	//Obtener las coordenas del fragmento de la imagen a pintar
	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animaciones.get(animacionActual).calcularFrame(t);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen =	 (int)coordenadasActuales.getHeight();
	}
	
	public void mover(){		
		if (this.x>=1100)
			this.x = -100;
		if (Juego.derecha)
			this.x+=velocidad;
		
		if (Juego.izquierda)
			this.x-=velocidad;
		
		if (Juego.arriba) {
			if (this.y>30)  
			this.y-=velocidad;
		}
		System.out.println(this.y);
	
		if (Juego.abajo) {
			if(this.y<401)
			this.y+=velocidad;
		}
			}
	
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				this.x, this.y,
				this.anchoImagen, this.altoImagen
		);
		//graficos.setFill(Color.RED);
		//graficos.fillRect(this.x, this.y, this.anchoImagen, this.altoImagen);
		graficos.fillText("Puntuacion " + puntuacion, 0, 70); // Posicion dle texto 
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}
	
	public void inicializarAnimaciones() {
			animaciones = new HashMap<String, Animacion>();				
			Rectangle coordenadasCorrer[]= {
					new Rectangle(20, 208, 23,46),
					new Rectangle(83,208, 27,46),
					new Rectangle	(147,208, 24,46),
					new Rectangle(211,208, 23,46),
					new Rectangle(273,208, 25,46),
					new Rectangle(338,209, 30,46),
					new Rectangle(401,209, 25,46),
					new Rectangle(467,207, 24,49),
					new Rectangle(531,208, 22,46)
					
					
				
			};
			
			
			Animacion animacionCorrer = new Animacion("correr",coordenadasCorrer,0.05); //Velocidad de megaman 
			animaciones.put("correr",animacionCorrer);
			
			Rectangle coordenadasDescanso[] = {
					new Rectangle(18, 206, 23,48),
					
			};
			Animacion animacionDescanso = new Animacion("descanso",coordenadasDescanso,0.5);
			animaciones.put("descanso",animacionDescanso);
	}
	
	public void verificarColisiones(Item item) {
		if (this.obtenerRectangulo().intersects(item.obtenerRectangulo().getBoundsInLocal())) {
				System.out.println("Estan colisionando");
				if (!item.isCapturado())
					this.puntuacion++;
				
				item.setCapturado(true);				
		}
	}
	public void verificarColisiones(Enemigos enemigo) {
		if (this.obtenerRectangulo().intersects(enemigo.obtenerRectangulo().getBoundsInLocal())) {
		
			System.out.println("estan colisionando");
		
				if (!enemigo.isCapturado())
				
				enemigo.setCapturado(true);		
				Juego.fin=true;
		
				
				
		}
	}					
			
		
		
		
		
	}