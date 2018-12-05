package sjtu.edu.uavm_a6;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;


import java.util.ArrayList;
import java.util.List;

public class CircleImageLayout extends LinearLayout {
    private double mAngle = 0;//初始角度
    private int mX, mY;//子控件位置
    private int mWidth, mHeight;//控件长宽
    private int mRadius;//子控件距离控件圆心位置
    private int mCount;
    private List<ImageButton> mCircleImageButtonList;
    private ImageButton mCircleImageButton;

    public CircleImageLayout(Context context) {
        super(context);
    }

    public CircleImageLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleImageLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mCircleImageButtonList = new ArrayList<ImageButton>();
    }

    /**
     * 设置子控件到控件圆心的位置
     */
    public void setRadius(int radius) {
        mRadius = radius;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        initDraw();
    }

    public void initDraw() {
        mCount = getChildCount();
        for (int i = 0; i < mCount; i++) {
            View child = getChildAt(i);
            child.getWidth();
            child.getHeight();
            if (i == 0) {
                mX = mWidth / 2;
                mY = mHeight / 2;
            } else {
                mAngle = 180 - 180 / (mCount - 1) * (i - 1);
                mX = (int) (mWidth / 2 + Math.cos(Math.toRadians(mAngle)) * mRadius);
                mY = (int) (mHeight / 2 - Math.sin(Math.toRadians(mAngle)) * mRadius);
            }
            child.layout(mX - child.getWidth() / 2, mY - child.getHeight() / 2, mX + child.getWidth() / 2, mY + child.getHeight() / 2);
        }
    }

    /**
     * 初始化环绕数量半径
     */
    public void init(int count, int radius) {
        mRadius = radius;
        for (int i = 0; i < count + 1; i++) {
            ImageButton imageView = new ImageButton(getContext());
            if (i == 0) {
                //i为0时为圆型头像
                View view = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, null, true);
                //mCircleImageButton = (ImageButton) view.findViewById(R.id.iv_header);
                addView(view);
            } else {
                //addView(imageView, MeasureUtil.dip2px(15), MeasureUtil.dip2px(15));00
                mCircleImageButtonList.add(imageView);
            }
        }
    }
}
