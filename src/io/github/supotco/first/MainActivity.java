package io.github.supotco.first;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		final Intent gr = new Intent(this, GraphicsActivity.class);
		Button grButton = new Button(this);
		grButton.setText("Graphics");
		grButton.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v)
			{
				startActivity(gr);
			}
		});
		
		ViewGroup layout = (ViewGroup) findViewById(R.id.layout);
		layout.addView(grButton);
		
		
		return true;
	}
	
	public void sendMessage(View view)
	{
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra("message", message);
		startActivity(intent);
		
		
	}

}
