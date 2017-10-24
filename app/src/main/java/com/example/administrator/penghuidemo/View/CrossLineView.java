package com.example.administrator.penghuidemo.View;



import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.example.administrator.penghuidemo.utils.DensityUtil;

/**
 * 自定义水平方向的时间轴
 *
 */
public class CrossLineView extends View {

	private String[] strStates = { "等待派单", "已派单", "维修中", "已完成", "已评价" };
private String[] time={"08-23","08-24","08-25","08-26","08-27"};
	private int screenWidth = 0;
	private int screenHeight = 0;

	/** 图片的宽高 */
	private int picWidth = 0;

	/** 绘制直线与圆点的画笔 */
	private Paint m_LinePaint;
	private Context m_Context;
	private int lineStartX, lineEndX, lineStartY, lineEndY;
	// 横向轴的长度
	private int lineLength = 0;
	private int circleX = 0;

	private int circleY = 0;
	private int circleRadius =0;
	/** 线的默认颜色 */
	private int defaultColor = 0xFFB6B6B6;
	/** 圆圈的颜色 */
	private int circleColor = 0xFFD7D7D7;
	/** 选中的颜色 */
	private int selectorColor = 0xFFFF6D5E;
	/** 绘制文字的画笔 */
	private Paint m_TextPaint;
	/** 申请进度 */
	private int nSchedule = 3;

	public CrossLineView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		initData(context);
	}

	public CrossLineView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		initData(context);
	}

	public CrossLineView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initData(context);
	}

	private void initData(Context ctx) {
		// TODO Auto-generated method stub
		// 获取屏幕宽高（方法1）
		m_Context = ctx;
		WindowManager wm = (WindowManager) m_Context
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		screenHeight = display.getHeight();
		screenWidth = display.getWidth();
		m_LinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		m_TextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		m_TextPaint.setColor(0xff151515);
		m_TextPaint.setTextSize(DensityUtil.sp2px(m_Context, 10));
		picWidth = DensityUtil.dip2px(m_Context, 24);
		circleRadius = DensityUtil.dip2px(m_Context, 6);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		m_LinePaint.setColor(defaultColor);
		m_LinePaint.setStyle(Style.STROKE);
		m_LinePaint.setStrokeWidth(DensityUtil.dip2px(m_Context, 4));
		lineStartX = DensityUtil.dip2px(m_Context, 20)+10;
		lineEndX = screenWidth - lineStartX+10;
		lineStartY = lineEndY = lineStartX;

		canvas.drawLine(lineStartX, lineStartY, lineEndX, lineStartY,
				m_LinePaint);
		lineLength = lineEndX - lineStartX;
		m_LinePaint.setStyle(Style.FILL);
		String str = "";
		if(nSchedule>4){
			nSchedule = 4;
		}
		for (int i = 0; i < strStates.length; i++) {
			str = strStates[i];
			circleY = lineStartY;
			if (i <= nSchedule) {
				m_LinePaint.setColor(selectorColor);
			} else {
				m_LinePaint.setColor(circleColor);
			}
			if (i == 0) {// 第一个 默认为选中状态
				circleX = lineStartX;
				m_LinePaint.setColor(selectorColor);
				// canvas.drawCircle(circleX, circleY, 10, m_LinePaint);
				canvas.drawCircle(circleX, circleY, circleRadius, m_LinePaint);
//				drawImage(canvas, bm, circleX- picWidth/2, circleY - picWidth/2, picWidth, picWidth);
				m_TextPaint.setTextAlign(Align.CENTER);
			} else if (i == (strStates.length - 1)) {// 最后一个
				circleX = lineEndX - 2;
				if(i<= nSchedule){
					canvas.drawCircle(circleX, circleY, circleRadius, m_LinePaint);
				}else{
					canvas.drawCircle(circleX, circleY, circleRadius, m_LinePaint);
				}
			} else {
				circleX += lineLength / 4;
				if(i<= nSchedule){
					canvas.drawCircle(circleX, circleY, circleRadius, m_LinePaint);
				}else{
					canvas.drawCircle(circleX, circleY, circleRadius, m_LinePaint);
				}
			}

//			canvas.drawText(str, circleX, circleY -DensityUtil.dip2px(m_Context, 16), m_TextPaint);
			canvas.drawText(time[i], circleX, circleY +DensityUtil.dip2px(m_Context, 26), m_TextPaint);
			// Log.i("LoanScheduleView", "circleX = " + circleX + " circleY = "
			// + circleY);
		}

		if (nSchedule >= 1) {
			m_LinePaint.setColor(selectorColor);
			canvas.drawLine(lineStartX, lineStartY, lineStartX + lineLength / 4
					* nSchedule, lineEndY, m_LinePaint);
		}
	}

	/*private Bitmap getBitmap(int i) {
		// TODO Auto-generated method stub
		int id = 0;
		switch (i) {
			case 0:
				id = R.mipmap.loan_sq;
				break;
			case 1:
				id = R.mipmap.loan_sh;
				break;
			case 2:
				id = R.mipmap.loan_ddfk;
				break;
			case 3:
				id = R.mipmap.loan_fk;
				break;
			case 4:
				id = R.mipmap.loan_hk;
				break;

			default:
				break;
		}
		return BitmapUtils.decodeResource(m_Context,
				id);
	}*/

	/**
	 * 功能:设置时间进度
	 *
	 * @param state
	 *            状态 从0开始
	 */
	public void setTimeLineSchedule(int state) {
		this.nSchedule = state;
	}

//	@Override
//	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//		// TODO Auto-generated method stub
//		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//		setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
//		screenHeight = getHeight();
//		screenWidth = getWidth();
//	}

	/** ---------------------------------
	 * 绘制图片
	 *
	 * @return      null
	------------------------------------*/

	public static void drawImage(Canvas canvas, Bitmap blt, int x, int y,
								 int w, int h) {
		Rect dst = new Rect();// 屏幕 >>目标矩形
		dst.left = x;
		dst.top = y;
		dst.right = x + w;
		dst.bottom = y + h;
		// 画出指定的位图，位图将自动--》缩放/自动转换，以填补目标矩形
		// 这个方法的意思就像 将一个位图按照需求重画一遍，画后的位图就是我们需要的了
		canvas.drawBitmap(blt, null, dst, null);
		dst = null;
	}

}
