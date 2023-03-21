package model;

public class StudentDTO {

   private String id;
   private String pw;
   private String question;
   private String answer;
   private int n_question;
   private int time;
   private int rank;
   private int score;
   private int java;
   
   public StudentDTO(int java) {
      this.java = java;
   }

   public int getJava() {
      return java;
   }

   public void setJava(int java) {
      this.java = java;
   }

   public StudentDTO(String id, String pw, String question, String answer, int n_question, int time,
         int rank, int score) {
      this.id = id;
      this.pw = pw;
      this.question = question;
      this.answer = answer;
      this.n_question = n_question;
      this.time = time;
      this.rank = rank;
      this.score = score;
   }


   public StudentDTO(String id, String pw) {
      this.id = id;
      this.pw = pw;
   }

   public StudentDTO(String question) {
      this.question = question;
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

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getPw() {
      return pw;
   }

   public void setPw(String pw) {
      this.pw = pw;
   }

   public String getid() {
      return id;
   }

   public void setid(String id) {
      this.id = id;
   }

}