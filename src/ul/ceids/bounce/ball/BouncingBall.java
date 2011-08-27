package ul.ceids.bounce.ball;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class BouncingBall extends View{

	//Velocidad de cambio
	public int velocity=10;
	
	//Estado de la pelota si está dentor o afuera del View
	private boolean  leftRight = true;
	private boolean  upDown = true;
	
	//Posicion de la pelota
	private int pointX=100;
	private int pointY=100;
	
	//Radio del circulo
	public int radius=20;
	
	//Matriz de colores
	private int r=0;
	private int g=0;
	private int b=0;
	
	//Clase para definir color
	private Paint paint;
	
	public BouncingBall(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.paint = new Paint();
		this.paint.setColor(Color.WHITE);
	}
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
				
		
		if (leftRight) {
			// a la derecha
			pointX += velocity;
			
			if (pointX >= getWidth() - radius) {
				leftRight = false;
				this.changeColorRandom();
			}
		} else {
			// a la izquierda
			pointX -= velocity;
			if (pointX <= radius) {
				leftRight = true;
				this.changeColorRandom();
			}
		}

		//Movimiento de la pelota de arriba hacia abajo
		if (upDown) {
			// hacia arriba
			pointY += velocity;
			if (pointY >= getHeight() - radius) {
				upDown = false;
				this.changeColorRandom();
			}			
		} else {
			// hacia abajo
			pointY -= velocity;
			if (pointY <= radius) {
				upDown = true;
				this.changeColorRandom();
			}			
		}
		
		canvas.drawCircle(pointX, pointY, radius, paint);
		invalidate();
	}

	public void changeColorRandom(){
		
		//Generador de numeros aleatorios 
			Random random = new Random();
				
			int alfa = 255;		
			r = random.nextInt(255);
			g = random.nextInt(255);
			b = random.nextInt(255);
				
		//Definir los colores
			paint.setColor(Color.argb(alfa, r, g, b));
		
	}
	
}
