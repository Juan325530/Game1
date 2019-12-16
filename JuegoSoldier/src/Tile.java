
import javafx.scene.canvas.GraphicsContext;

public class Tile extends Imagen{
	public Tile(int tipoTile, int x, int y, String indiceImagen, int velocidad) {
		super(tipoTile, x, y, indiceImagen, velocidad);
		x = super.getX();
		y = super.getY();
		indiceImagen = super.getIndiceImagen();
		velocidad = super.getVelocidad();
		tipoTile = super.getTipoTile();
		switch(tipoTile){
		case 1:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(0);
			super.setyImagen(0);
		break;
		case 2:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(353);
			super.setyImagen(449);
		break;
		case 3:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(161);
			super.setyImagen(257);
		break;
		case 4:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(191);
			super.setyImagen(225);
		break;
		case 5:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(513);
			super.setyImagen(289);
		break;
		case 6:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(350);
			super.setyImagen(97);
		break;
		case 7:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(642);
			super.setyImagen(63);
		break;
		case 8:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(565);
			super.setyImagen(333);
		break;
		case 9:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(223);
			super.setyImagen(449);
		break;
		case 10:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(513);
			super.setyImagen(65);
		break;
		case 11:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(161);
			super.setyImagen(353);
		break;
		case 12:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(100);
			super.setyImagen(385);
		break;
		case 13:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(130);
			super.setyImagen(385);
		break;
		case 14:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(641);
			super.setyImagen(98);
		break;
		case 15:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(610);
			super.setyImagen(609);
		break;
		case 16:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(419);
			super.setyImagen(385);
		break;
		case 17:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(704);
			super.setyImagen(321);
		break;
		case 18:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(256);
			super.setyImagen(129);
		break;
		case 19:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(34);
			super.setyImagen(1);
		break;
		case 20:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(256);
			super.setyImagen(225);
		break;
		case 21:
			super.setAltoImagen(32);
			super.setAnchoImagen(32);
			super.setxImagen(63);
			super.setyImagen(193);
		break;
		
		
		
		}
	}
	
	@Override 
	public void pintar(GraphicsContext graficos) {
			graficos.drawImage(
				Juego.imagenes.get(super.getIndiceImagen()),
						super.getxImagen(), super.getyImagen(),
						super.getAnchoImagen(), super.getAltoImagen(),
						super.getX(), super.getY(),super.getAnchoImagen(),
						super.getAltoImagen()
						);	
	}
	
}
