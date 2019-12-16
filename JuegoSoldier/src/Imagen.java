import javafx.scene.canvas.GraphicsContext;

public abstract  class Imagen {
	
		private int x;
		private int y;
		private int xImagen;
		private int yImagen;
		private int anchoImagen;
		private int altoImagen;
		private int tipoTile;
		private int velocidad;
		private String indiceImagen;
		
		public Imagen(int x, int y, int xImagen, int yImagen, int anchoImagen, int altoImagen, int tipoTile, int velocidad,
				String indiceImagen) {
			super();
			this.x = x;
			this.y = y;
			this.xImagen = xImagen;
			this.yImagen = yImagen;
			this.anchoImagen = anchoImagen;
			this.altoImagen = altoImagen;
			this.tipoTile = tipoTile;
			this.velocidad = velocidad;
			this.indiceImagen = indiceImagen;
		}
		public Imagen(int tipoTile, int x, int y, String indiceImagen,int velocidad) {
			super();
			this.tipoTile = tipoTile;
			this.x = x;
			this.y = y;
			this.indiceImagen = indiceImagen;
			this.velocidad = velocidad;
		}
		public Imagen(int x, int y, int xImagen, int yImagen, int anchoImagen, int altoImagen, String indiceImagen) {
			super();
			this.x = x;
			this.y = y;
			this.xImagen = xImagen;
			this.yImagen = yImagen;
			this.anchoImagen = anchoImagen;
			this.altoImagen = altoImagen;
			this.indiceImagen = indiceImagen;
		}
			
			public Imagen(int x, int y, int xImagen, int yImagen, String indiceImagen) {
				this.x = x;
				this.y = y;
				this.xImagen = xImagen;
				this.yImagen = yImagen;
				this.indiceImagen = indiceImagen;
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
			public int getAnchoImagen() {
				return anchoImagen;
			}
			public void setAnchoImagen(int anchoImagen) {
				this.anchoImagen = anchoImagen;
			}
			public int getAltoImagen() {
				return altoImagen;
			}
			public void setAltoImagen(int altoImagen) {
				this.altoImagen = altoImagen;
			}
			public int getTipoTile() {
				return tipoTile;
			}
			public void setTipoTile(int tipoTile) {
				this.tipoTile = tipoTile;
			}
			public int getVelocidad() {
				return velocidad;
			}
			public void setVelocidad(int velocidad) {
				this.velocidad = velocidad;
			}
			public String getIndiceImagen() {
				return indiceImagen;
			}
			public void setIndiceImagen(String indiceImagen) {
				this.indiceImagen = indiceImagen;
			}
			@Override
			public String toString() {
				return "Imagen [x=" + x + ", y=" + y + ", xImagen=" + xImagen + ", yImagen=" + yImagen
						+ ", anchoImagen=" + anchoImagen + ", altoImagen=" + altoImagen + ", tipoTile=" + tipoTile
						+ ", velocidad=" + velocidad + ", indiceImagen=" + indiceImagen + "]";
			}

			public void pintar(GraphicsContext graficos) {
				
			}
	
			
}