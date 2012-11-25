package com.tapjacking.framework;

import java.util.ArrayList;
import android.content.Intent;
import android.graphics.Point;
import android.view.View;
import com.tapjacking.framework.R;

public abstract class FrameworkPayload {
	
	public abstract Intent getIntent();
	public abstract int getSleep();

	protected ArrayList<Point> positions = new ArrayList<Point>();
	protected int currentPosition = 0;

	public Point getFirst() {
		if(!this.positions.isEmpty()) {
			currentPosition++;
			return this.positions.get(0);
		}
		return new Point(0, 0);
	};

	public int getNumMoves() {return this.positions.size(); }

	public boolean moveImage(View viewBug) {
		if(viewBug.getId() == R.id.image) {
			if(currentPosition > 0 && currentPosition < this.positions.size()) {
				Point p = this.positions.get(currentPosition++);
				viewBug.setPadding(p.x, p.y, 0, 0);
			} else {
				View aux = viewBug.getRootView().findViewById(R.id.fin);
				aux.setVisibility(View.VISIBLE);
			}
			return true;
		}
		return false;
	}
}