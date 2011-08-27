package ul.ceids.bounce.ball;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Prueba_CanvasActivity extends Activity implements OnSeekBarChangeListener{
    /** Called when the activity is first created. */
	private BouncingBall ball;
	
	private Timer timer;
	
	private int timeDraw=1;
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.ball = new BouncingBall(this);
        this.ball.setLayoutParams(new LinearLayout.LayoutParams(
				  LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
        
	    LinearLayout ll = (LinearLayout)findViewById(R.id.ll);
	    ll.addView(ball);	 
        
		SeekBar sb_velocity = (SeekBar) findViewById(R.id.sb_velocity);
		sb_velocity.setOnSeekBarChangeListener(this);
		sb_velocity.setMax(30);
		sb_velocity.setProgress(ball.velocity);
		SeekBar sb_size = (SeekBar) findViewById(R.id.sb_size);
		sb_size.setOnSeekBarChangeListener(this);
		sb_size.setMax(80);
		sb_size.setProgress(ball.radius);
		  
//        setContentView(new BouncingBall(this));
        
    }    

	@Override
	public void onProgressChanged(SeekBar view, int progress, boolean arg2) {
		// TODO Auto-generated method stub
		
		switch(view.getId()){
			case R.id.sb_size:
				if(progress == 0){
					return;
				}	
				this.ball.radius=progress;
				break;
			case R.id.sb_velocity:
				if(progress == 0){
					return;
				}
				this.ball.velocity=progress;				
			
		}
	
	}

	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
}