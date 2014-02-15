package com.example.geoquiz;

public class TrueFalse {
	
	private int mQuestion;
	private boolean mTrueQuestion;
	private boolean mHasCheated;
	
	public TrueFalse(int question, boolean trueQuestion) {
		mQuestion = question;
		mTrueQuestion = trueQuestion;
		mHasCheated = false;
	}

	public int getQuestion() {
		return mQuestion;
	}

	public void setQuestion(int question) {
		mQuestion = question;
	}

	public boolean isTrueQuestion() {
		return mTrueQuestion;
	}

	public void setTrueQuestion(boolean trueQuestion) {
		mTrueQuestion = trueQuestion;
	}
	
	public boolean hasCheated() {
		return mHasCheated;
	}

	public void setHasCheated(boolean cheat) {
		mHasCheated = cheat;
	}
	
	
}
