package io.github.supotco.first;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class GraphicsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_graphics);
		// Show the Up button in the action bar.
		setupActionBar();
		
		setTitle("Graphics");
		setContentView(new DrawView(this));	
	}
	
	public class DrawView extends View {
		DisplayMetrics dm;
		
		public DrawView(Context c)
		{
			super(c);
			dm = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(dm);
		}
		
		@Override public void onDraw(final Canvas canvas)
		{
			super.onDraw(canvas);
			
			
			// white screen
			canvas.drawColor(Color.WHITE);
			
			// blue circle
			final Paint paint = new Paint();
			paint.setAntiAlias(true);
			paint.setColor(Color.BLACK);
			paint.setTextSize(40);
			
			int x = 1;
			int y = 1;
			
			for (int i = 0; i < 20; i++) {
				
				drawBox(x, y, 400, canvas, paint);
				System.out.println("Drawing");
				x *= 2;
				y *= 2;
				paint.setStrokeWidth(paint.getStrokeWidth() + 1);
			}
					
			
			
//			canvas.drawText("Width: " + dm.widthPixels, 50, 50, paint);
//			canvas.drawText("Height: " + dm.heightPixels, 50, 100, paint);
//			canvas.drawText("xdpi: " + dm.xdpi, 50, 150, paint);
//			canvas.drawText("ydpi: " + dm.ydpi, 50, 200, paint);
//			
//			drawBox(500, 500, 400, canvas, paint);
//			canvas.drawCircle(100, 100, 50, paint);
//			canvas.drawRect(300, 300, 600, 600, paint);
//			canvas.drawLine(500, 710, 1000, 250, paint);
		}
	}
	
	/**
	 * Draws a box
	 * @param x
	 * @param y
	 * @param r
	 * @param canvas
	 * @param paint
	 */
	public void drawBox(float x, float y, float r, Canvas canvas, Paint paint)
	{
		canvas.drawLine(x, y, x + r, y, paint);
		canvas.drawLine(x, y, x, y + r, paint);
		canvas.drawLine(x, y + r, x + r, y + r, paint);
		canvas.drawLine(x + r, y, x + r, y + r, paint);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.graphics, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
