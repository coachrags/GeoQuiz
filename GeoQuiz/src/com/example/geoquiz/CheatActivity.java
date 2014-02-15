package com.example.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {
	
	public static final String EXTRA_ANSWER_IS_TRUE = "com.example.geoquiz.answer_is_true";
	public static final String EXTRA_ANSWER_SHOWN = "com.example.geoquiz.answer_shown";
	private boolean mAnswerIsTrue;
	private boolean mCheater;
	private TextView mAnswerTextView;
	private Button mShowAnswer;

	
	private void setAnswerShownResult (boolean isAnswerShown) {
		Intent data = new Intent();
		data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
		setResult(RESULT_OK, data);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat);
		
		mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
		mAnswerTextView = (TextView)findViewById(R.id.answerTextView);
		
		mCheater = false;
		if (savedInstanceState != null)
		{
			mCheater = savedInstanceState.getBoolean(EXTRA_ANSWER_SHOWN, false);
			setAnswerShownResult(mCheater);
			if (mAnswerIsTrue) {
				if (mCheater)
				{
					mAnswerTextView.setText(R.string.true_button);
				}
			}
			else {
				if (mCheater)
				{
					mAnswerTextView.setText(R.string.false_button);
				}
			}
		}
		else
		{
			//Answer will not be shown until the user presses the button
			setAnswerShownResult(mCheater);
		}
		
		
		
		mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
		mShowAnswer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mAnswerIsTrue) {
					mAnswerTextView.setText(R.string.true_button);
				}
				else {
					mAnswerTextView.setText(R.string.false_button);
				}
				setAnswerShownResult(true);
				mCheater = true;
				
			}
		});
		
	}		
	
	
	@Override
	public void onSaveInstanceState (Bundle savedInstanceState)
	{
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putBoolean(EXTRA_ANSWER_SHOWN, mCheater);
	}
}

