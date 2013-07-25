package com.vinnymac.slidinglistexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.tjerkw.slideexpandable.library.ActionSlideExpandableListView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.expandable_list);
		ActionSlideExpandableListView list = (ActionSlideExpandableListView) this.findViewById(R.id.list);
		list.setAdapter(buildDummyData());
		list.setItemActionListener(new ActionSlideExpandableListView.OnActionClickListener() {

			@Override
			public void onClick(View listView, View buttonview, int position) {
				String actionName = "";
				if (buttonview.getId() == R.id.buttonOne) {
					actionName = "Button One";
				} else {
					actionName = "Button Two";
				}
				Toast.makeText(MainActivity.this, "Clicked Action: " + actionName + " in list item " + position,
						Toast.LENGTH_SHORT).show();
			}
		}, R.id.buttonOne, R.id.buttonTwo);
	}

	public ListAdapter buildDummyData() {
		final int SIZE = 20;
		String[] values = new String[SIZE];
		for (int i = 0; i < SIZE; i++) {
			values[i] = "Item " + i;
		}
		return new ArrayAdapter<String>(this, R.layout.list_item, R.id.text, values);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
