package com.dineshonjava.model;

public class FinalResult {
	
	private String question;
	private String useranser;
	private String correctoption;
	private String iscorrect;
	
	
	public String getIscorrect() {
		return iscorrect;
	}
	public void setIscorrect(String iscorrect) {
		this.iscorrect = iscorrect;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getUseranser() {
		return useranser;
	}
	public void setUseranser(String useranser) {
		this.useranser = useranser;
	}
	public String getCorrectanswer() {
		return correctoption;
	}
	public void setCorrectanswer(String correctanswer) {
		this.correctoption = correctanswer;
	}
}
