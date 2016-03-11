package com.example.customeview;

import java.util.Random;

import android.R.color;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Paint.Style;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class BitmapUtils {
	private static BitmapUtils bUtils;
	public static BitmapUtils getInstance(){
		if(bUtils==null)
			bUtils=new BitmapUtils();
		return bUtils;
	}
	private static final char[] CHARS = {  
	        '1','2', '3', '4', '5', '6', '7', '8', '9',  
	        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm',   
	        'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',  
	        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',   
	        'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'  
	    }; 
	// default settings
	private static final int DEFAULT_CODE_LENGTH = 4;
	private static final int DEFAULT_FONT_SIZE = 20;
	private static final int DEFAULT_LINE_NUMBER = 3;
	private static final int BASE_PADDING_LEFT = 15, RANGE_PADDING_LEFT = 10, BASE_PADDING_TOP = 15, RANGE_PADDING_TOP = 10;
	private static final int DEFAULT_WIDTH = 100, DEFAULT_HEIGHT = 30;

	// settings decided by the layout xml
	// canvas width and height
	private int width = DEFAULT_WIDTH, height = DEFAULT_HEIGHT;

	// random word space and pading_top
	private int base_padding_left = BASE_PADDING_LEFT, range_padding_left = RANGE_PADDING_LEFT, base_padding_top = BASE_PADDING_TOP,
			range_padding_top = RANGE_PADDING_TOP;

	// number of chars, lines; font size
	private int codeLength = DEFAULT_CODE_LENGTH, line_number = DEFAULT_LINE_NUMBER, font_size = DEFAULT_FONT_SIZE;

	// variables
	private int padding_left, padding_top;
	private String verificationCode="";
	Random random = new Random();

	public Bitmap createBitmap(String res[]) {
		padding_left = 0;

		Bitmap bp = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		Canvas c = new Canvas(bp);
		c.drawColor(Color.WHITE);
		Paint paint = new Paint();
		paint.setTextSize(font_size);

		for (int i = 0; i < res.length; i++) {
			randomTextStyle(paint);
			randomPadding();
			c.drawText(res[i] + "", padding_left, padding_top, paint);
		}

		for (int i = 0; i < line_number; i++) {
			drawLine(c, paint);
		}

		c.save(Canvas.ALL_SAVE_FLAG);// 保存
		c.restore();//
		return bp;
	}
	public Bitmap createBitmap(){
		return createBitmap(createCode());
	}
	public String getVerificationCode(){
		return verificationCode;
	}
	private String[] createCode() {  
        StringBuilder buffer = new StringBuilder();
        buffer.append(CHARS[random.nextInt(CHARS.length)]);  
        for (int i = 0; i < codeLength-1; i++) { 
            buffer.append(","+CHARS[random.nextInt(CHARS.length)]);
        }
        verificationCode=buffer.toString().replace(",", "");
        return buffer.toString().split(",");  
    }  

	private void drawLine(Canvas canvas, Paint paint) {
		int color = randomColor();
		int startX = random.nextInt(width);
		int startY = random.nextInt(height);
		int stopX = random.nextInt(width);
		int stopY = random.nextInt(height);
		paint.setStrokeWidth(1);
		paint.setColor(color);
		canvas.drawLine(startX, startY, stopX, stopY, paint);
	}

	private int randomColor() {
		return randomColor(1);
	}

	private int randomColor(int rate) {
		int red = random.nextInt(256) / rate;
		int green = random.nextInt(256) / rate;
		int blue = random.nextInt(256) / rate;
		return Color.rgb(red, green, blue);
	}

	private void randomTextStyle(Paint paint) {
//		int color = randomColor();
		paint.setColor(Color.parseColor("#CE2F4D"));//设置默认红色
		paint.setFakeBoldText(random.nextBoolean()); // true为粗体，false为非粗体
		float skewX = random.nextInt(11) / 10;
		skewX = random.nextBoolean() ? skewX : -skewX;
		paint.setTextSkewX(skewX); // float类型参数，负数表示右斜，整数左斜
		// paint.setUnderlineText(true); //true为下划线，false为非下划线
		// paint.setStrikeThruText(true); //true为删除线，false为非删除线
	}

	private void randomPadding() {
		padding_left += base_padding_left + random.nextInt(range_padding_left);
		padding_top = base_padding_top + random.nextInt(range_padding_top);
	}
	public Bitmap createButton(int width,int height,int color){
		Bitmap bp = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		Canvas c = new Canvas(bp);
		c.drawColor(Color.TRANSPARENT);
		RectF rectF=new RectF();
		rectF.left=1;
		rectF.bottom=height-1;
		rectF.top=1;
		rectF.right=width/2;
		Paint paint=new Paint();
		paint.setColor(color);
		paint.setStyle(Style.FILL_AND_STROKE);
		c.drawArc(rectF, 90, 180, false, paint);
//		rectF.right=width-1;
//		rectF.left=width*3/4-1;
		rectF.left=width/4;
		rectF.top=0;
		rectF.right=width*3/4;
		rectF.bottom=height;
		c.drawRect(rectF, paint);
		RectF rectF2=new RectF();
		rectF2.left=width/2;
		rectF2.bottom=height-1;
		rectF2.top=1;
		rectF2.right=width-1;
		c.drawArc(rectF2, -90, 180, true, paint);
		c.save(Canvas.ALL_SAVE_FLAG);// 保存
		c.restore();//
		return bp;
	}
	
}
