package model;

public class RankDTO {
	private int time;
	private int rank;
	private int score;
	private int ranking;
	private String nickname;
	
	public RankDTO(int ranking, String nickname, int time) {
		this.ranking = ranking;
		this.nickname = nickname;
		this.time = time;
	}
	public RankDTO( String nickname, int time) {
		this.nickname = nickname;
		this.time = time;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public RankDTO() {
	}

	public RankDTO(int time) {
		this.time = time;
	}

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
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
