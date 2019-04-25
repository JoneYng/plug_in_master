package com.yunqixinxi.main.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author zhouxiang
 * @package com.yunqixinxi.main.view
 * @fileName DrawView
 * @date or  2019/4/18 上午8:37
 * @describe TODO 自定义view练习
 */
public class DrawView extends View {

    Paint paint = new Paint();

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.GREEN);
        canvas.drawCircle(150, 150, 150, paint);
    }
}