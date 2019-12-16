import java.util.ArrayList;

import java.util.HashMap;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Juego extends Application{
	private Scene escena;
	private Group root;
	private Canvas canvas;
	private GraphicsContext graficos;
	private int puntuacion = 0;
	//private Jugador jugador;
	private JugadorAnimado jugadorAnimado;
	public static boolean derecha=false;
	public static boolean izquierda=false;
	public static boolean arriba=false;
	public static boolean abajo=false;
	public static boolean fin= false;
	public static HashMap<String, Image> imagenes; //Shift+Ctrl+O
	//private ArrayList<Image> imagenes;
	private Item item;
	private Item item2;
	//private Item item3;
	private Fondo fondo1;
	
	private ArrayList<Tile> tiles;
	private ArrayList<Enemigos> enemix;
	
	private int[][] mapa = {
		
		
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,03,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,02,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,02,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,03,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,04,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,03,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,04,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,12,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,13,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,3,2,3,2,3,2,0,0,2,3,2,3,2,21,19,0,0,0,0},
			{2,12,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,13,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,02,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,02,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,03,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,04,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,03,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,04,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,12,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,13,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,3,2,3,2,3,2,0,0,2,3,2,3,2,21,19,0,0,0,0},
			{2,12,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,13,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,02,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,02,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,03,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,04,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,03,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,04,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,12,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,13,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,3,2,3,2,3,2,0,0,2,3,2,3,2,21,19,0,0,0,0},
			{2,12,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,13,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,02,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,02,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,03,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,04,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,03,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,04,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,12,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,13,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,3,2,3,2,3,2,0,0,2,3,2,3,2,21,19,0,0,0,0},
			{2,12,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,13,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,02,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,02,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,03,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,04,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,03,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,04,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,12,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,13,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,3,2,3,2,3,2,0,0,2,3,2,3,2,21,19,0,0,0,0},
			{2,12,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,13,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,21,19,0,0,0,0},
		
			
		
		
			
	};
	
			private int [][] mapaenemigo = {
					{3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,03,0,0,0,0,0,0,0,0,0},
					{3,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,3,0,0,0,03,0,0,0,0,0,0,0,0,0},
					{3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,03,0,0,0,0,0,0,0,0,0},
					{3,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,3,0,0,0,03,0,0,0,0,0,0,0,0,0},
					{3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,03,0,0,0,0,0,0,0,0,0},
					{3,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,3,0,0,0,03,0,0,0,0,0,0,0,0,0},
					{3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,03,0,0,0,0,0,0,0,0,0},
					{3,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,3,0,0,0,03,0,0,0,0,0,0,0,0,0},
					{3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,03,0,0,0,0,0,0,0,0,0},
					{3,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,3,0,0,0,03,0,0,0,0,0,0,0,0,0},
					{3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,03,0,0,0,0,0,0,0,0,0},
					{3,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,3,0,0,0,03,0,0,0,0,0,0,0,0,0},
					{3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,03,0,0,0,0,0,0,0,0,0},
					{3,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,3,0,0,0,03,0,0,0,0,0,0,0,0,0},
					
			
			
			};
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		graficos = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		ventana.setScene(escena);
		ventana.setTitle("SOLDIER");
		gestionarEventos();
		ventana.show();
		cicloJuego();		
	}
	
	public void inicializarComponentes() {
		//jugador = new Jugador(5,415,"soldier",1);
		jugadorAnimado = new JugadorAnimado(50,400,"soldier",1, "descanso");
		fondo1 = new Fondo(0,0,5,"fondo1");
		root = new Group();
		escena = new Scene(root,900,500);
		canvas  = new Canvas(1000,500);
		imagenes = new HashMap<String,Image>();
		item = new Item(100,200,0,0,"item"); //para generar puntuacion
		item2 = new Item(200,200,0,0,"item");
		cargarImagenes();
		
		cargarTiles();
		cargarenemigos ();
	}
	public void cargarenemigos () {         //ENEMINGOOOOOOOOOOOOOOOOW
		
		enemix = new ArrayList<Enemigos>();
		
		for(int i=0; i<mapaenemigo.length; i++) {
			for(int j=0; j<mapaenemigo[i].length; j++) {
				if (mapaenemigo[i][j]!=0)
					enemix.add(new Enemigos(mapaenemigo[i][j], i*71, j*53, "Enemigo",0));
			}
		}
	}
	
	public void cargarImagenes() {
		imagenes.put("soldier", new Image("soldier.png"));
		imagenes.put("soldier-furioso", new Image("soldier-furioso.png"));
		imagenes.put("tilemap", new Image("tilemap.png"));
		imagenes.put("soldier", new Image("soldier-furiosoOro.png"));
		imagenes.put("item", new Image("item.png"));
		imagenes.put("fondo1", new Image("background.jpg"));
		imagenes.put("Enemigo",new Image("Enemigo.png"));
		//imagenes.put("soldieroro", new Image("soldieroro.png"));
		
	}
	
	
	public void pintar() {
		graficos.setFill(Color.BLACK ); //COLOR DE FONDO 
		graficos.fillRect(0, 0, 1000, 500);
		graficos.setFill(Color.BLACK);
		graficos.fillText("Puntuacion: " + puntuacion, 10, 10);
		//jugador.pintar(graficos);
		fondo1.pintar(graficos);
		
		///Pintar tiles
		for (int i=0;i<tiles.size();i++)
		
		tiles.get(i).pintar(graficos);
		
		
		for (int i=0;i<enemix.size();i++)
			enemix.get(i).pintar(graficos);
		
		item.pintar(graficos);
		
		item2.pintar(graficos);
		
		//item3.pintar(graficos);
		
		jugadorAnimado.pintar(graficos);
	}
	
	public void cargarTiles() {
		tiles = new ArrayList<Tile>();
		for(int i=0; i<mapa.length; i++) {
			for(int j=0; j<mapa[i].length; j++) {
				if (mapa[i][j]!=0)
					tiles.add(new Tile(mapa[i][j], i*32, j*32, "tilemap",0));
			}
		}
	}
	
	public void gestionarEventos() {
		//Evento cuando se presiona una tecla
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
					//Aqui tengo que poner el codigo para identificar cuando se presiono una tecla
					switch (evento.getCode().toString()) {
						case "D": //derecha
							derecha=true;
							jugadorAnimado.setAnimacionActual("correr");
							break;
						case "A": //derecha
							izquierda=true;
							jugadorAnimado.setAnimacionActual("correr");
						break;
						case "W":
							arriba=true;
							jugadorAnimado.setAnimacionActual("correr");
							break;
						case "S":
							abajo=true;
							jugadorAnimado.setAnimacionActual("correr");
							break;
						case "SPACE":
							jugadorAnimado.setVelocidad(10);
							//jugadorAnimado.setIndiceImagen("soldier-furioso");
							break;
					}
			}			
		});
		
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				//Aqui tengo que poner el codigo para identificar cuando se solt� una tecla
				switch (evento.getCode().toString()) {
				case "D": //derecha
					derecha=false;
					jugadorAnimado.setAnimacionActual("descanso");
					break;
				case "A": //derecha
					izquierda=false;
					jugadorAnimado.setAnimacionActual("descanso");
				break;
				case "W":
					arriba=false;
					jugadorAnimado.setAnimacionActual("descanso");
					break;
				case "S":
					abajo=false;
					jugadorAnimado.setAnimacionActual("descanso");
					break;
				case "SPACE":
					jugadorAnimado.setVelocidad(1);
					//jugador.setIndiceImagen("soldier");
					break;
			}
				
			}
			
		});
		
	}
	
	public void cicloJuego() {
		long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {
			//Esta rutina simula un ciclo de 60FPS
			@Override
			public void handle(long tiempoActualNanoSegundos) {
				double t = (tiempoActualNanoSegundos - tiempoInicial) / 1000000000.0;
				if (!Juego.fin) {
					pintar();
					actualizar(t);
				}
				
				
			}
			
		};
		animationTimer.start(); //Inicia el ciclo
	}
	
	public void actualizar(double t) {
		jugadorAnimado.mover();
		jugadorAnimado.actualizarAnimacion(t);
					jugadorAnimado.verificarColisiones(item);
					jugadorAnimado.verificarColisiones(item2);
		fondo1.mover();
		
			//nuevo
			for(int i=0;i<enemix.size();i++)
				jugadorAnimado.verificarColisiones(enemix.get(i));			
		}
	} 



