package model;

public class QuizDTO {

	private String question;
	private String answer;
	private int n_question;
	private int time;
	private String nickname;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public QuizDTO(String qustion, String answer) {
		this.question = qustion;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getN_question() {
		return n_question;
	}

	public void setN_question(int n_question) {
		this.n_question = n_question;
	}

}
