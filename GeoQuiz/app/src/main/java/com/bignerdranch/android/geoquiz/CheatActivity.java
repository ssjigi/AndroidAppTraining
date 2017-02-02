package com.bignerdranch.android.geoquiz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private static final String TAG = "CheatActivity";
    private static final String KEY_ISSHOWN = "key_isshown";
    private static final String EXTRA_ANSWER = "com.bignerdranch.android.geoquiz.answer";
    private static final String EXTRA_SHOWN = "com.bignerdranch.android.geoquize.shown";

    private boolean mIsAnswerTrue;
    private boolean mIsAnswerShown;

    private TextView mAnswerTextView;
    private TextView mVersionTextView;
    private Button mShowAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: " + savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mIsAnswerTrue = getIntent().getBooleanExtra(EXTRA_ANSWER, false);

        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);

        mVersionTextView = (TextView) findViewById(R.id.versionTextView);
        mVersionTextView.setText(getString(R.string.api_level)+Build.VERSION.SDK);

        mShowAnswer = (Button) findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateAnswerTextView();
                setAnswerShowResult(true);
                hideShowAnswerButton();
            }
        });

        if (savedInstanceState != null) {
            boolean isAnswerShow = savedInstanceState.getBoolean(KEY_ISSHOWN);
            if (isAnswerShow) {
                updateAnswerTextView();
                setAnswerShowResult(savedInstanceState.getBoolean(KEY_ISSHOWN));
                mShowAnswer.setVisibility(View.INVISIBLE);
            }
        }
    }

    private void updateAnswerTextView() {
        if (mIsAnswerTrue) {
            mAnswerTextView.setText(R.string.true_button);
        } else {
            mAnswerTextView.setText(R.string.false_button);
        }
    }

    public static Intent newIntent(Context packageContext, boolean answer) {
        Log.d(TAG, "newIntent: packageContext = " + packageContext + ", answer = " + answer);
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER, answer);
        return i;
    }

    public static boolean getIntentBoolean(Intent i) {
        return i.getBooleanExtra(EXTRA_SHOWN, false);
    }

    public void setAnswerShowResult(boolean isAnswerShown) {
        Log.d(TAG, "setAnswerShowResult: mIsAnswerShown = " + isAnswerShown);
        this.mIsAnswerShown = isAnswerShown;
        Intent data = new Intent();
        data.putExtra(EXTRA_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: outState = " + outState + ", mIsAnswerShow = " + mIsAnswerShown);
        outState.putBoolean(KEY_ISSHOWN, mIsAnswerShown);
    }

    private void hideShowAnswerButton() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int cx = mShowAnswer.getWidth() / 2;
            int cy = mShowAnswer.getHeight() / 2;
            float radius = mShowAnswer.getWidth();
            Animator anim = ViewAnimationUtils.createCircularReveal(mShowAnswer, cx, cy, radius, 0);
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mShowAnswer.setVisibility(View.INVISIBLE);
                }
            });
            anim.start();
        } else {
            mShowAnswer.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
