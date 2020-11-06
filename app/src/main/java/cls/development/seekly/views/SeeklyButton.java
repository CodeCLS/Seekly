package cls.development.seekly.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import cls.development.seekly.R;

public class SeeklyButton extends View{
    private final int RADIUS_BUTTON_BACKGROUND = 20;
    private String textButton;
    public SeeklyButton(Context context) {
        super(context);
        init();
    }


    public SeeklyButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public SeeklyButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public SeeklyButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();

    }

    private void init() {


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = createPaintForBackground();
        RectF rectRoundBackground = createRoundRectBackground();
        Paint textPaint = createPaintForText();
        int xPos = (getWidth() / 2);
        int yPos = (int) ((getHeight() / 2) - ((textPaint.descent() + textPaint.ascent()) / 2)) ;
        //((textPaint.descent() + textPaint.ascent()) / 2) is the distance from the baseline to the center.

        canvas.drawText(textButton, xPos, yPos, textPaint);
        canvas.drawRoundRect(rectRoundBackground,RADIUS_BUTTON_BACKGROUND,RADIUS_BUTTON_BACKGROUND,paint);

    }

    private Paint createPaintForText() {
        Paint textPaint = new Paint();
        textPaint.setTextAlign(Paint.Align.CENTER);
        return textPaint;
    }

    private Paint createPaintForBackground() {
        Paint paint = new Paint();
        paint.setColor(ContextCompat.getColor(getContext(), R.color.orangePrimary));
        return null;
    }

    private RectF createRoundRectBackground() {
        return new RectF(0,0,getWidth(),getHeight());

    }
    public void setText(String text){
        this.textButton = text;
        this.postInvalidate();


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_UP:

            case MotionEvent.ACTION_DOWN:

        }
        return super.onTouchEvent(event);
    }
}
