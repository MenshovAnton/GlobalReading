package com.waysoonprogramms.globalreading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class Level1 extends AppCompatActivity {

    private View imageView;
    private View textView1;
    private View textView1a;
    private View container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        textView1 = findViewById(R.id.textView5);
        textView1.setOnTouchListener(touchListener);

        imageView = findViewById(R.id.imageView);
        container = findViewById(R.id.container);
        textView1a = findViewById(R.id.textView4);
    }

    private int xDelta, yDelta, topA, leftA, rightA, bottomA;
    private int viewVisible = 6;


    private View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent event) {
            final int x = (int) event.getRawX();
            final int y = (int) event.getRawY();

            topA = imageView.getTop();
            leftA = imageView.getLeft();
            rightA = imageView.getRight();
            bottomA = imageView.getBottom();

            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN: {
                    FrameLayout.LayoutParams lParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    xDelta = x - lParams.leftMargin;
                    yDelta = y - lParams.topMargin;
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    if (view.getLeft() >= leftA
                            && view.getRight() <= rightA
                            && view.getTop() >= topA
                            && view.getBottom() <= bottomA) {
                        view.setVisibility(View.INVISIBLE);
                        textView1a.setVisibility(View.VISIBLE);
                        viewVisible--;
                    }
                    break;
                }
                case MotionEvent.ACTION_MOVE: {
                    if (x - xDelta + view.getWidth() <= container.getWidth()
                            && y - yDelta + view.getHeight() <= container.getHeight()
                            && x - xDelta >= 0
                            && y - yDelta >= 0) {
                        FrameLayout.LayoutParams layoutParams =
                                (FrameLayout.LayoutParams) view.getLayoutParams();
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;
                        view.setLayoutParams(layoutParams);
                    }

                    break;
                }
            }
            container.invalidate();
            return true;
        }
    };
}