package com.waysoonprogramms.globalreading;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class Level1 extends AppCompatActivity {

    private View imageView;
    private View imageView2;
    private View imageView3;
    private View imageView4;
    private View imageView5;
    private View imageView6;
    private View textView1;
    private View textView2;
    private View textView3;
    private View textView4;
    private View textView5;
    private View textView6;
    private View textView1a;
    private View textView2a;
    private View textView3a;
    private View textView4a;
    private View textView5a;
    private View textView6a;

    private View container;
    private MediaPlayer good;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        textView1 = findViewById(R.id.textView5);
        textView1.setOnTouchListener(touchListener);

        textView2 = findViewById(R.id.textView11);
        textView2.setOnTouchListener(touchListener);

        textView3 = findViewById(R.id.textView7);
        textView3.setOnTouchListener(touchListener);

        textView4 = findViewById(R.id.textView10);
        textView4.setOnTouchListener(touchListener);

        textView5 = findViewById(R.id.textView8);
        textView5.setOnTouchListener(touchListener);

        textView6 = findViewById(R.id.textView9);
        textView6.setOnTouchListener(touchListener);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);

        container = findViewById(R.id.container);

        textView1a = findViewById(R.id.textView4);
        textView2a = findViewById(R.id.textView6);
        textView3a = findViewById(R.id.textView12);
        textView4a = findViewById(R.id.textView15);
        textView5a = findViewById(R.id.textView14);
        textView6a = findViewById(R.id.textView13);
    }

    private int xDelta, yDelta, topA, leftA, rightA, bottomA;
    private int topB, leftB, rightB, bottomB;
    private int topC, leftC, rightC, bottomC;
    private int topD, leftD, rightD, bottomD;
    private int topF, leftF, rightF, bottomF;
    private int topG, leftG, rightG, bottomG;
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

            topB = imageView2.getTop();
            leftB = imageView2.getLeft();
            rightB = imageView2.getRight();
            bottomB = imageView2.getBottom();

            topC = imageView3.getTop();
            leftC = imageView3.getLeft();
            rightC = imageView3.getRight();
            bottomC = imageView3.getBottom();

            topD = imageView4.getTop();
            leftD = imageView4.getLeft();
            rightD = imageView4.getRight();
            bottomD = imageView4.getBottom();

            topF = imageView5.getTop();
            leftF = imageView5.getLeft();
            rightF = imageView5.getRight();
            bottomF = imageView5.getBottom();

            topG = imageView6.getTop();
            leftG = imageView6.getLeft();
            rightG = imageView6.getRight();
            bottomG = imageView6.getBottom();

            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN: {
                    FrameLayout.LayoutParams lParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    xDelta = x - lParams.leftMargin;
                    yDelta = y - lParams.topMargin;
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    pickTrigger(view);
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

        private void pickTrigger(View view) {
            good = MediaPlayer.create(Level1.this, R.raw.good_answ);
            if (view.getLeft() >= leftA
                    && view.getRight() <= rightA
                    && view.getTop() >= topA
                    && view.getBottom() <= bottomA
                    && view == textView1) {
                view.setVisibility(View.INVISIBLE);
                textView1a.setVisibility(View.VISIBLE);
                goodSoundPlay();
                viewVisible--;
            }
            if (view.getLeft() >= leftB
                    && view.getRight() <= rightB
                    && view.getTop() >= topB
                    && view.getBottom() <= bottomB
                    && view == textView2) {
                view.setVisibility(View.INVISIBLE);
                textView2a.setVisibility(View.VISIBLE);
                goodSoundPlay();
                viewVisible--;
            }
            if (view.getLeft() >= leftC
                    && view.getRight() <= rightC
                    && view.getTop() >= topC
                    && view.getBottom() <= bottomC
                    && view == textView3) {
                view.setVisibility(View.INVISIBLE);
                textView3a.setVisibility(View.VISIBLE);
                goodSoundPlay();
                viewVisible--;
            }
            if (view.getLeft() >= leftD
                    && view.getRight() <= rightD
                    && view.getTop() >= topD
                    && view.getBottom() <= bottomD
                    && view == textView4) {
                view.setVisibility(View.INVISIBLE);
                textView4a.setVisibility(View.VISIBLE);
                goodSoundPlay();
                viewVisible--;
            }
            if (view.getLeft() >= leftF
                    && view.getRight() <= rightF
                    && view.getTop() >= topF
                    && view.getBottom() <= bottomF
                    && view == textView5) {
                view.setVisibility(View.INVISIBLE);
                textView5a.setVisibility(View.VISIBLE);
                goodSoundPlay();
                viewVisible--;
            }
            if (view.getLeft() >= leftG
                    && view.getRight() <= rightG
                    && view.getTop() >= topG
                    && view.getBottom() <= bottomG
                    && view == textView6) {
                view.setVisibility(View.INVISIBLE);
                textView6a.setVisibility(View.VISIBLE);
                goodSoundPlay();
                viewVisible--;
            }
            if (viewVisible == 0) {
                showWin();
            }
        }

        private void goodSoundPlay() {
            if (good.isPlaying()) {
                good.stop();
            }
            good.start();
        }

        private void showWin() {
            AlertDialog.Builder builder = new AlertDialog.Builder(Level1.this);
            builder.setTitle("Умница! Так держать!")
                    .setMessage("Все правильно!")
                    .setCancelable(true)
                    .setPositiveButton("На главную", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Level1.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
            builder.show();
        }
    };
}