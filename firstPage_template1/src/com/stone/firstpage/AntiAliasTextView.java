package com.stone.firstpage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * ��Ҫ�ǿ�������õ�View�����Լ̳���LinearLayout��viewGroup���͵���ͼ ��������
 * 
 * @author Sistone.zhang
 * 
 */
@SuppressLint("DrawAllocation")
public class AntiAliasTextView extends TextView {
	private Path path;
	private Paint paint;

	public AntiAliasTextView(Context context) {
		this(context, null);
	}

	public AntiAliasTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public AntiAliasTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		paint = new Paint();
		paint.setAntiAlias(true);
		paint.setColor(Color.WHITE);
		paint.setStrokeWidth(6);
		paint.setStyle(Paint.Style.STROKE);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.setDrawFilter(new PaintFlagsDrawFilter(0,
				Paint.FILTER_BITMAP_FLAG | Paint.ANTI_ALIAS_FLAG));
		super.onDraw(canvas);

		// ���
		if (path == null) {
			path = new Path();
			path.moveTo(0, 0);
			path.lineTo(getWidth(), 0);
			path.lineTo(getWidth(), getHeight());
			path.lineTo(0, getHeight());
			path.close();
		}

		canvas.drawPath(path, paint);
	}
}
