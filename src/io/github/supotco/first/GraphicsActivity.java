package io.github.supotco.first;

import java.io.IOException;
import java.io.InputStream;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
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
		Bitmap bm;
		Canvas bufferCanvas;
		Bitmap castle;
		
		public DrawView(Context context)
		{
			super(context);
			dm = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(dm);
			bm = Bitmap.createBitmap(dm.widthPixels, dm.heightPixels, Bitmap.Config.ARGB_8888);
			bufferCanvas = new Canvas(bm);
			castle = loadBitmap(context, "castle.png");
		}
		
		@Override public void onDraw(final Canvas canvas)
		{
			canvas.drawBitmap(castle, 400,  400, null);
		}
	}
	
	public Bitmap loadBitmap(Context context, String file)
	{
		Bitmap bm = null;
		try {
		    AssetManager assets = context.getAssets();
		    InputStream istream = assets.open(file);
		    BitmapFactory.Options options = new BitmapFactory.Options();
		    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
		    bm = BitmapFactory.decodeStream(istream,null,options);
		    istream.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return bm;
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
