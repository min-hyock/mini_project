package view;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import controller.QuizDAO;
import controller.RankDAO;
import controller.StudentDAO;
import model.QuizDTO;
import model.RankDTO;
import model.StudentDTO;

public class Main {

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      System.out.println();
      System.out.println("================== 슬기로운 자바생활 _〆(ﾟ▽ﾟ*) =================");
      System.out.println();
      System.out.println("      :::::::::::       :::       :::     :::        :::");
      System.out.println("         :+:         :+: :+:     :+:     :+:      :+: :+:");
      System.out.println("        +:+        +:+   +:+    +:+     +:+     +:+   +:+");
      System.out.println("       +#+        #++:++#++:   +#+     +:+    +#++:++#++: ");
      System.out.println("      +#+       +#+     +#+    +#+   +#+     +#+     +#+  ");
      System.out.println(" #+# #+#       #+#     #+#     #+#+#+#      #+#     #+# ");
      System.out.println(" #####        ###     ###       ###        ###     ###  ");
      System.out.println();
      System.out.println("================= _〆(ﾟ▽ﾟ*) 슬기로운 자바생활 ==================");

      while (true) {
         System.out.println();
         System.out.println();
         System.out.print("         [1]회원가입 [2]로그인 [3]랭킹 [4]종료 >> ");
         int choice = sc.nextInt();

         if (choice == 1) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("================= 회원 가입을 해보자 ＿〆(˘ᗜ˘) ================");
            System.out.print("ID 입력 : ");
            String id = sc.next();
            System.out.println();
            System.out.print("PW 입력 : ");
            String pw = sc.next();
            System.out.println();

            StudentDAO dao = new StudentDAO();
            StudentDTO dto = new StudentDTO(id, pw);
            int row = dao.join(dto);

            if (row > 0) {
               System.out.println();
               System.out.println("회원가입에 성공했다 !! (*•̀ᴗ•́*)و ̑̑");
               System.out.println();
               System.out.println();
               System.out.println("\t      메인 메뉴로 돌아갑니다 /ᐠ｡ꞈ｡ᐟ✿\\");
            } else {
               System.out.println();
               System.out.println("      이미 생생된 아이디입니다 새로운 아이디를 입력해주세요 ... ");
               System.out.println();
            }

         } else if (choice == 2) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("============ ♪¸¸.•*¨*•♫ 로그인을 해보자 ♫•*¨*•.¸¸♪ ============");
            System.out.println();
            System.out.print("ID 입력 : ");
            String id = sc.next();
            System.out.println();
            System.out.print("PW 입력 : ");
            String pw = sc.next();
            System.out.println();

            long start = System.currentTimeMillis(); // 타이머 시작
            StudentDAO studentdao = new StudentDAO();
            StudentDTO studentdto = new StudentDTO(id, pw);
            String uName = studentdao.login(studentdto);
            if (uName != null) {
               System.out.println();
               System.out.println(uName + " 학우님 어서오세요 (*ˊᵕˋ*)ﾉ ~ ");
               int score = 0;
               QuizDAO quizdao = new QuizDAO();
               String answer = null;
               while (score < 10) {
                 System.out.println();
                  System.out.println("-슬기로운JAVA생활-");
                  System.out.println();
                  System.out.println();
                  System.out.println("<오늘은 스인재 첫 등원 날!>");
                  System.out.println();
                  System.out.println("⌜생각보다 일찍 도착해 버렸잖아? ๑ŐεŐ๑⌟");
                  System.out.println();
                  System.out.println();
                  System.out.println("두둥!!(つ❛ɞ❛⊂) 자리를 정할 수 있는 특권을 얻었다!!");
                  System.out.println();
                  System.out.println();
                  System.out.println("<자리를 선택해보자!>");
                  System.out.println();
                  System.out.println("① 짝이 있는 자리 ② 짝이 없는자리");
                  System.out.println();
                  System.out.print("당신의 선택은 ? \t >> \t");
                  int partner = sc.nextInt();
                  if (partner == 3) {
                     while (true) {

                        System.out.println();
                         System.out.println();
                         System.out.println("\t [ 다시 선택해 주세요 ] ");
                         System.out.println();
                         System.out.println();

                        System.out.println("① 짝이 있는 자리 ② 짝이 없는자리");
                        System.out.print("당신의 선택은 ? \t >> \t");
                        partner = sc.nextInt();

                        if (partner == 1 || partner == 2) {
                           break;
                        }

                     }
                  }
                  if (partner == 1) {
                     System.out.println();
                     System.out.println();
                     System.out.println("⌜엥 왜자리가 비어있지?⌟");
                     System.out.println();
                     System.out.println("짝꿍이 지각하여 혼자 수업을 듣게 됩니다...(Ｔ▽Ｔ)");
                     System.out.println();
                     System.out.println();

                     System.out.println("\t수업 시작 !");
                     System.out.println();
                     System.out.println();
                     System.out.println("\t┌─┐┌┬┐┌─┐┬─┐┌┬┐\r\n" + "\t└─┐ │ ├─┤├┬┘ │ \r\n" + "\t└─┘ ┴ ┴ ┴┴└─ ┴ ");
                     System.out.println();
                     System.out.println();
                     while (true) {
                        if (score >= 100) {
                           break;
                        }
                        QuizDTO java = quizdao.getJava();
                        QuizDTO db = quizdao.getDB();
                        QuizDTO nun = quizdao.getNun();

                        System.out.println();
                        System.out.println("\t 강사를 선택해 주세요 !");
                        System.out.println();
                        System.out.print("\t [1]강태우 \t[2]임경남 \t[3]김운비 >> \t");
                        int first_sel = sc.nextInt();
                        if (first_sel == 1) {
                           System.out.println();
                           System.out.println(" \t 태우쌤을 선택하셨습니다. ദ്ദി(˶˙ᵕ˙˶)\t ");
                           System.out.println();
                           System.out.println(" \t 다들 점심은 맛있게 드셨나요? \t ");
                           System.out.println(" \t 이제부터 실무에서 자주 사용되는 DB에 관한 문제를 풀어볼게요. ");
                           System.out.println();
                           System.out.println(" \t 각 문제의 배점은 10점이구요. ");
                           System.out.println(" \t tmi이긴 한데.. 아 좀 너무 tmi인가? 아니다 그냥 넘어갈게요 ~");

                           System.out.println();
                           System.out.println("\t 과목을 선택해주세요. ");
                           System.out.println();
                           System.out.print("\t [1]DB \t\t [2]이전 메뉴 >> \t ");
                           int in_one = sc.nextInt();
                           if (in_one == 1) {
                              System.out.println();
                              System.out.println("데이터베이스 문제를 선택 하셨습니다.");
                              System.out.println();
                              System.out.println("██████╗ ██████╗     ████████╗███████╗███████╗████████╗\r\n"
                                    + "██╔══██╗██╔══██╗    ╚══██╔══╝██╔════╝██╔════╝╚══██╔══╝\r\n"
                                    + "██║  ██║██████╔╝       ██║   █████╗  ███████╗   ██║   \r\n"
                                    + "██║  ██║██╔══██╗       ██║   ██╔══╝  ╚════██║   ██║   \r\n"
                                    + "██████╔╝██████╔╝       ██║   ███████╗███████║   ██║   \r\n"
                                    + "╚═════╝ ╚═════╝        ╚═╝   ╚══════╝╚══════╝   ╚═╝   \r\n");
                              System.out.println();
                              System.out.println();
                              System.out.println(
                                    "___________________________________________________________________________________________________________________________________________________");
                              System.out.println();
                              System.out.println("[문제]");
                              System.out.println();
                              System.out.println(db.getQuestion());
                              System.out.println(
                                    "___________________________________________________________________________________________________________________________________________________");
                              System.out.println();
                              System.out.print("\t 정답입력 >>\t");
                              answer = sc.next();
                              System.out.println();
                              if (db.getAnswer().equals(answer)) {
                                 System.out.println();
                                 System.out.println("\t 정답입니다! \t");
                                 System.out.println();
                                 System.out.println("\t 10점을 획득 하셨습니다.\t");
                                 score += 100;
                                 System.out.println();
                                 System.out.println("\t 현재점수는 " + score + "점 입니다.\t");
                                 System.out.println();
                                 System.out.println();
                              } else {
                                 System.out.println();
                                 System.out.println("\t 땡!  \t");
                                 System.out.println();
                                 System.out.println();
                              }
                           } else if (in_one == 2) {
                              System.out.println();
                              System.out.println("\t 이전 화면으로 돌아갑니다.");
                              System.out.println();
                           } else {
                              System.out.println();
                              System.out.println("\t 다시 선택해 주세요");
                              System.out.println();
                           }
                        }
                        if (first_sel == 2) {
                           System.out.println();
                           System.out.println(" \t 경남쌤을 선택하셨습니다. \t ");
                           System.out.println(" \t 반가워요 여러분~~ \t ");
                           System.out.println();
                           System.out.println("\t 답은 띄어쓰기없이 소문자로 입력하세요! \t");
                           System.out.println("\t 모든 문제의 배점은 각 10점 입니다. \t");
                           System.out.println();
                           System.out.println();

                           System.out.println("\t 과목을 선택해주세요!\t");
                           System.out.println();
                           System.out.println();

                           System.out.print("\t [1]java \t [2]python \t [3]이전 메뉴>> \t");
                           int in_two = sc.nextInt();

                           if (in_two == 1) {
                              System.out.println();
                              System.out.println("\t자바문제를 선택 하셨습니다.");
                              System.out.println();
                              System.out.println(
                                    "     ██╗ █████╗ ██╗   ██╗ █████╗     ████████╗███████╗███████╗████████╗\r\n"
                                          + "     ██║██╔══██╗██║   ██║██╔══██╗    ╚══██╔══╝██╔════╝██╔════╝╚══██╔══╝\r\n"
                                          + "     ██║███████║██║   ██║███████║       ██║   █████╗  ███████╗   ██║   \r\n"
                                          + "██   ██║██╔══██║╚██╗ ██╔╝██╔══██║       ██║   ██╔══╝  ╚════██║   ██║   \r\n"
                                          + "╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║       ██║   ███████╗███████║   ██║   \r\n"
                                          + " ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝       ╚═╝   ╚══════╝╚══════╝   ╚═╝   \r\n"
                                          + "                                                                       ");

                              System.out.println();
                              System.out.println(
                                    "___________________________________________________________________________________________________________________________________________________");
                              System.out.println();
                              System.out.println("[문제]");
                              System.out.println();
                              System.out.println(java.getQuestion());
                              System.out.println(
                                    "___________________________________________________________________________________________________________________________________________________");
                              System.out.println();
                              System.out.print("\t 정답입력 >>\t");
                              answer = sc.next();
                              System.out.println();
                              if (java.getAnswer().equals(answer)) {
                                 System.out.println("\t 정답입니다. \t");
                                 System.out.println();
                                 System.out.println("\t 10점을 획득 하셨습니다.\t");
                                 score += 10;
                                 System.out.println();
                                 System.out.println("\t 현재점수는 " + score + "점 입니다.\t");
                                 System.out.println();
                              } else {
                                System.out.println();
                                 System.out.println("\t 땡!  \t");
                                 System.out.println();
                              }
                           } else if (in_two == 2) {
                              System.out.println();
                              System.out.println("\t python문제를 선택 하셨습니다. \t");
                              System.out
                                    .println("  ___    ___    ____   ____   ___   ____   ___    __    _ ");
                              System.out.println(
                                    "/' _ '\\ /'_'\\ /' _ '\\/',_'_)/'__'\\/' _ '\\/',__) /'__'\\ | |");
                              System.out.println(
                                    "| ( ) |( (_) )| ( ) |\\__, \\(  ___/| ( ) |\\__, \\(  ___/ | |");
                              System.out.println(
                                    "(_) (_) \\___/ (_) (_)(____/ \\____)(_) (_)(____/`\\____) `ㅡ'  ");
                              System.out
                                    .println("                                                       (_)");

                              System.out.println(
                                    "___________________________________________________________________________________________________________________________________________________");
                              System.out.println();
                              System.out.println("[문제]");
                              System.out.println();
                              System.out.println(nun.getQuestion());
                              System.out.println(
                                    "___________________________________________________________________________________________________________________________________________________");
                              System.out.println();
                              System.out.print("\t 정답입력 >>\t");
                              answer = sc.next();
                              System.out.println();
                              if (nun.getAnswer().equals(answer)) {
                                 System.out.println();
                                 System.out.println("\t 정답입니다. \t");
                                 System.out.println();
                                 System.out.println("\t 10점을 획득 하셨습니다. \t");
                                 score += 2;
                                 System.out.println();
                                 System.out.println("\t 현재점수는 " + score + "점 입니다. \t");
                                 System.out.println();
                              } else {
                                 System.out.println();
                                 System.out.println("\t 땡!  \t");
                                 System.out.println();
                              }
                           } else if (in_two == 3) {
                              System.out.println();
                              System.out.println("\t 이전 화면으로 돌아갑니다.");
                              System.out.println();
                           } else {
                              System.out.println();
                              System.out.println("\t 다시 선택해 주세요 \t");
                              System.out.println();
                           }
                        }
                        if (first_sel == 3) {
                           System.out.println();
                           System.out.println(" \t 운비 쌤을 선택하셨습니다.");
                           System.out.println();

                           System.out.println(" \t 여러분 자바 너무 재미없지 않아요?  \t ");
                           System.out.println(" \t 저도 처음에 그랬어요~ 야구게임 할까요?  \t ");
                           System.out.println();
                           System.out.println("\t 답은 띄어쓰기없이 소문자로 입력하세요! \t");
                           System.out.println("\t 모든 문제의 배점은 각 10점 입니다. \t");

                           System.out.println();

                           System.out.println("\t 과목을 선택해 주세요!\t");
                           System.out.println();
                           System.out.print("\t [1]JAVA \t [2]C++ \t [3]이전 메뉴>> \t");
                           int in_three = sc.nextInt();
                           if (in_three == 1) {
                              System.out.println(
                                    "___________________________________________________________________________________________________________________________________________________");
                              System.out.println();
                              System.out.println("[문제]");
                              System.out.println();
                              System.out.println(java.getQuestion());
                              System.out.println(
                                    "___________________________________________________________________________________________________________________________________________________");
                              System.out.println();
                              System.out.print("\t 정답입력 >>\t");
                              String user_Answer = sc.next();
                              System.out.println();
                              if (java.getAnswer().equals(user_Answer)) {
                                 System.out.println();
                                 System.out.println("\t 정답입니다. \t");
                                 System.out.println();
                                 System.out.println("\t 10점을 획득 하셨습니다.\t");
                                 score += 10;
                                 System.out.println();
                                 System.out.println("\t 현재점수는 " + score + "점 입니다.\t");
                                 System.out.println();
                              } else {
                                 System.out.println();
                                 System.out.println("\t 땡!  \t");
                                 System.out.println();
                              }
                           } else if (in_three == 2) {
                              while (true) {
                                 quizdao.getJava();
                                 System.out.println();
                                 System.out.println("\t ==========================");
                                 System.out.println("\t 404 Not Found : catch java");
                                 System.out.println("\t ==========================");
                                 System.out.println();
                                 System.out.println("\t 수강할 과목을 다시 선택하세요");
                                 System.out.println();
                                 System.out.print("\t [1]JAVA \t [2]C++ \t [3]이전 메뉴>> \t");
                                 int in_four = sc.nextInt();

                                 if (in_four == 1) {
                                    System.out.println(
                                          "___________________________________________________________________________________________________________________________________________________");
                                    System.out.println();
                                    System.out.println("[문제]");
                                    System.out.println();
                                    System.out.println(java.getQuestion());
                                    System.out.println(
                                          "___________________________________________________________________________________________________________________________________________________");
                                    System.out.println();
                                    System.out.print("정답입력 >> ");
                                    String user_Answer = sc.next();
                                    System.out.println();
                                    if (java.getAnswer().equals(user_Answer)) {
                                       System.out.println();
                                       System.out.println("\t 정답입니다. \t");
                                       System.out.println();
                                       System.out.println("\t 10점을 획득 하셨습니다.\t");
                                       score += 10;
                                       System.out.println();
                                       System.out.println("\t 현재점수는 " + score + "점 입니다.\t");
                                       System.out.println();
                                       break;
                                    } else {
                                       System.out.println();
                                       System.out.println("\t 땡!  \t");
                                       System.out.println();
                                       break;
                                    }
                                 }
                              }

                           } else if (in_three == 3) {
                              System.out.println();
                              System.out.println("\t 이전 화면으로 돌아갑니다.");
                              System.out.println();
                           } else {
                              System.out.println();
                              System.out.println("\t 다시 선택해 주세요");
                              System.out.println();
                           }

                        }

                     }

                  } else if (partner == 2) {
                     System.out.println();
                     System.out.println("███████╗██╗   ██╗███████╗███╗   ██╗████████╗\r\n"
                           + "██╔════╝██║   ██║██╔════╝████╗  ██║╚══██╔══╝\r\n"
                           + "█████╗  ██║   ██║█████╗  ██╔██╗ ██║   ██║   \r\n"
                           + "██╔══╝  ╚██╗ ██╔╝██╔══╝  ██║╚██╗██║   ██║   \r\n"
                           + "███████╗ ╚████╔╝ ███████╗██║ ╚████║   ██║   \r\n"
                           + "╚══════╝  ╚═══╝  ╚══════╝╚═╝  ╚═══╝   ╚═╝   \r\n"
                           + "                                            ");
                     System.out.println("(드르륵).. 누군가 의자를 끌고 옆자리로 옵니다..");
                     System.out.println("<우민철 등장!!!>");
                     System.out.println("");
                     System.out.println("민철 : 안녕 ? ( ͡° ͜ʖ ͡°)━☆ﾟ.*･｡ﾟ ");
                     System.out.println();

                     System.out.println("<우민철에게 말을 걸어보자!>");
                     System.out.println();
                     System.out.println("① 바람 쐬러 갈까ṑṑṑ ? ② 마이쮸 먹을래ṑṑṑ? ");
                     System.out.println();
                     System.out.print("당신의 선택은 ? \t >> \t");
                     int one = sc.nextInt();
                     if (one != 1 && one != 2) {
                        while (true) {

                           System.out.println();
                           System.out.println();
                           System.out.println("\t [ 다시 선택해 주세요 ] ");
                           System.out.println();
                           System.out.println();

                           System.out.println("① 바람 쐬러 갈까ṑṑṑ ? ② 마이쮸 먹을래ṑṑṑ? ");
                           System.out.print("당신의 선택은 ? \t >> \t");
                           one = sc.nextInt();

                           if (one == 1 || one == 2) {
                              break;
                           }

                        }
                     }
                     if (one == 1) {
                       System.out.println();
                        score = score + 5;
                        System.out.println("<5점을 얻었습니다.>");
                        System.out.println("★현재점수 : " + score + "점★");
                        System.out.println("____________________________________________________");
                        System.out.println();
                        System.out.println("쉬는 시간이 되었습니다. 뭐라고 말을 걸어볼까요?");
                        System.out.println();
                        System.out.println("① 바람 쐬러 가자!! ? ② 돈까스 좋아해?!");
                        System.out.println();
                        System.out.print("당신의 선택은 ? \t >> \t");
                        int pork = sc.nextInt();
                        if (pork != 1 && pork != 2) {
                           while (true) {

                              System.out.println();
                               System.out.println();
                               System.out.println("\t [ 다시 선택해 주세요 ] ");
                               System.out.println();
                               System.out.println();

                              System.out.println("① 바람 쐬러 가자!! ? ② 돈까스 좋아해?!");
                              System.out.print("당신의 선택은 ? \t >> \t");
                              pork = sc.nextInt();
                              if (pork == 1 || pork == 2) {
                                 break;
                              }

                           }
                        }
                        if (pork == 1) {
                           System.out.println();
                           score = score + 5;
                           System.out.println("<5점을 얻었습니다.>");
                           System.out.println("★현재점수 : " + score + "점★");
                           System.out.println("____________________________________________________");
                           System.out.println();
                           System.out.println("점심 시간이 되었습니다.");
                           System.out.println();
                           System.out.println("'(꼬르륵..)민철이의 배꼽시계가 울린다.'");
                           System.out.println();
                           System.out.println("민철이에게 건넬 말은?");
                           System.out.println();
                           System.out.println("① 바람 쐬러 가실래요 ? ② 편의점 가실래요 ? ");
                           System.out.println();
                           System.out.print("당신의 선택은 ? \t >> \t");
                           int after = sc.nextInt();
                           if (after != 1 && after != 2) {
                              while (true) {
                                 System.out.println();
                                  System.out.println();
                                  System.out.println("\t [ 다시 선택해 주세요 ] ");
                                  System.out.println();
                                  System.out.println();

                                 System.out.println("① 바람 쐬러 가실래요 ? ② 편의점 가실래요 ? ");
                                 System.out.print("당신의 선택은 ? \t >> \t");
                                 after = sc.nextInt();
                                 if (after == 1 || after == 2) {
                                    break;
                                 }

                              }
                           }
                           if (after == 1) {
                              System.out.println();
                              score = score + 5;
                              System.out.println("<5점을 얻었습니다.>");
                              System.out.println("★현재점수 : " + score + "점★");
                              System.out.println("____________________________________________________");
                              System.out.println();
                           } else if (after == 2) {
                              System.out.println();
                              score = score + 3;
                              System.out.println("<3점을 얻었습니다.>");
                              System.out.println("★현재점수 : " + score + "점★");
                              System.out.println("____________________________________________________");
                              System.out.println();
                           } else {
                              System.out.println("다시 고민해보자.");
                           }
                        } else if (pork == 2) {
                           System.out.println();
                           score = score + 4;
                           System.out.println("<4점을 얻었습니다.>");
                           System.out.println("★현재점수 : " + score + "점★");
                           System.out.println("____________________________________________________");
                           System.out.println();
                           System.out.println("점심 시간이 되었습니다(๑ӦㅅӦ๑)");
                           System.out.println();
                           System.out.println("'(꼬르륵..)민철이의 배꼽시계가 울린다.'");
                           System.out.println();
                           System.out.println("민철이에게 건넬 말은?");
                           System.out.println();
                           System.out.println("① 바람 쐬러 가실래요 ? ② 편의점 가실래요 ? ");
                           System.out.println();
                           System.out.print("당신의 선택은 ? \t >> \t");
                           int after = sc.nextInt();
                           if (after == 1) {
                             System.out.println();
                              score = score + 5;
                              System.out.println("<5점을 얻었습니다!!>");
                              System.out.println("★현재점수 : " + score + "점★");
                              System.out.println("____________________________________________________");
                              System.out.println();
                           } else if (after == 2) {
                              score = score + 3;
                              System.out.println("<3점을 얻었습니다 ￣□￣>");
                              System.out.println("★현재점수 : " + score + "점★");
                              System.out.println("____________________________________________________");
                              System.out.println();
                           }
                        } else {
                           System.out.println("다시 고민해보자⊙︿⊙");
                        }

                     } else if (one == 2) {
                        System.out.println();
                        score = score + 3;
                        System.out.println("<3점을 얻었습니다!!>");
                        System.out.println("★현재점수 : " + score + "점★");
                        System.out.println("____________________________________________________");
                        System.out.println();
                        System.out.println("쉬는 시간이 되었습니다 . 민철이에게 말을 걸어봅시다!! ");
                        System.out.println();
                        System.out.println("① 바람 쐬러 가자!! ? ② 돈까스 좋아해?!!");
                        System.out.println();
                        System.out.print("당신의 선택은 ? \t >> \t");
                        int pork = sc.nextInt();
                        if (pork != 1 && pork != 2) {
                           while (true) {

                              System.out.println();
                               System.out.println();
                               System.out.println("\t [ 다시 선택해 주세요 ] ");
                               System.out.println();
                               System.out.println();

                              System.out.println("① 바람 쐬러 가자!! ? ② 돈까스 좋아해?!");
                              System.out.print("당신의 선택은 ? \t >> \t");
                              pork = sc.nextInt();
                              if (pork == 1 || pork == 2) {
                                 break;
                              }

                           }
                        }
                        if (pork == 1) {
                           System.out.println();
                           score = score + 5;
                           System.out.println("5점을 얻었습니다!!");
                           System.out.println("★현재점수 : " + score + "점★");
                           System.out.println("____________________________________________________");
                           System.out.println();
                           System.out.println("점심 시간이 되었습니다.");
                           System.out.println();
                           System.out.println("'(꼬르륵..)민철이의 배꼽시계가 울린다.'");
                           System.out.println();
                           System.out.println("민철이에게 건넬 말은?");
                           System.out.println();
                           System.out.println("① 바람 쐬러 가실래요 ? ② 편의점 가실래요 ? ");
                           System.out.println();
                           System.out.print("당신의 선택은 ? \t >> \t");
                           int after = sc.nextInt();
                           if (after != 1 && after != 2) {
                              while (true) {
                                 System.out.println();
                                  System.out.println();
                                  System.out.println("\t [ 다시 선택해 주세요 ] ");
                                  System.out.println();
                                  System.out.println();
                                 System.out.println("① 바람 쐬러 가실래요 ? ② 편의점 가실래요 ? ");
                                 System.out.print("당신의 선택은 ? \t >> \t");
                                 after = sc.nextInt();
                                 if (after == 1 || after == 2) {
                                    break;
                                 }

                              }
                           }
                           if (after == 1) {
                              System.out.println();
                              score = score + 5;
                              System.out.println("<5점을 얻었습니다!!>");
                              System.out.println("★현재점수 : " + score + "점★");
                              System.out.println("____________________________________________________");
                              System.out.println();
                           } else if (after == 2) {
                              System.out.println();
                              score = score + 3;
                              System.out.println("<3점을 얻었습니다!!>");
                              System.out.println("★현재점수 : " + score + "점★");
                              System.out.println("____________________________________________________");
                              System.out.println();
                           } else {
                              System.out.println("다시 고민해보자.");
                           }
                        } else if (pork == 2) {
                           System.out.println();
                           score = score + 4;
                           System.out.println("<4점을 얻었습니다!!>");
                           System.out.println("★현재점수 : " + score + "점★");
                           System.out.println("____________________________________________________");
                           System.out.println();
                           System.out.println("'(꼬르륵..)민철이의 배꼽시계가 울린다.'");
                           System.out.println();
                           System.out.println("점심 시간이 되었습니다.");
                           System.out.println();
                           System.out.println("민철이에게 건넬 말은?");
                           System.out.println();
                           System.out.println("① 바람 쐬러 가실래요 ? ② 편의점 가실래요 ? ");
                           System.out.println();
                           System.out.print("당신의 선택은 ? \t >> \t");
                           int after = sc.nextInt();
                           if (after != 1 && after != 2) {
                              while (true) {
                                 System.out.println();
                                  System.out.println();
                                  System.out.println("\t [ 다시 선택해 주세요 ] ");
                                  System.out.println();
                                  System.out.println();

                                 System.out.println("① 바람 쐬러 가실래요 ? ② 편의점 가실래요 ? ");
                                 System.out.print("당신의 선택은 ? \t >> \t");
                                 after = sc.nextInt();
                                 if (after == 1 || after == 2) {
                                    break;
                                 }

                              }
                           }
                           if (after == 1) {
                              System.out.println();
                              score = score + 5;
                              System.out.println("<5점을 얻었습니다!!>");
                              System.out.println("★현재점수 : " + score + "점★");
                              System.out.println("____________________________________________________");
                              System.out.println();
                              System.out.println();
                           } else if (after == 2) {
                              System.out.println();
                              score = score + 3;
                              System.out.println("<3점을 얻었습니다!!>");
                              System.out.println("★현재점수 : " + score + "점★");
                              System.out.println("____________________________________________________");
                              System.out.println();

                           } else {
                              System.out.println("다시 고민해보자!!");
                           }
                        }
                        
                     }
                     System.out.println();
                     System.out.println("\t민철이와 수다를 떨다보니 어느새 시간이 다 되었다!");
                     System.out.println();
                     System.out.println("\t이제 집중해서 수업을 들어보자 !!");
                     System.out.println();
                     System.out.println("\t화이팅 해야지♬");
                     System.out.println();
                     System.out.println();
                     System.out.println("\t수업 시작 !");
                     System.out.println();
                     System.out.println();
                     System.out.println("\t┌─┐┌┬┐┌─┐┬─┐┌┬┐\r\n" + "\t└─┐ │ ├─┤├┬┘ │ \r\n" + "\t└─┘ ┴ ┴ ┴┴└─ ┴ ");
                     System.out.println();
                     System.out.println();
                  }
                  while (true) {
                     if (score >= 100) {
                        System.out.println();
                        System.out.println(
                              " ██╗ ██████╗  ██████╗     ██╗     ██████╗██╗     ███████╗ █████╗ ██████╗ \r\n"
                                    + "███║██╔═████╗██╔═████╗    ██║    ██╔════╝██║     ██╔════╝██╔══██╗██╔══██╗\r\n"
                                    + "╚██║██║██╔██║██║██╔██║    ██║    ██║     ██║     █████╗  ███████║██████╔╝\r\n"
                                    + " ██║████╔╝██║████╔╝██║    ╚═╝    ██║     ██║     ██╔══╝  ██╔══██║██╔══██╗\r\n"
                                    + " ██║╚██████╔╝╚██████╔╝    ██╗    ╚██████╗███████╗███████╗██║  ██║██║  ██║\r\n"
                                    + " ╚═╝ ╚═════╝  ╚═════╝     ╚═╝     ╚═════╝╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝\r\n"
                                    + "                                                                         ");
                        System.out.println();
                        break;
                     }

                     QuizDTO java = quizdao.getJava();
                     QuizDTO db = quizdao.getDB();
                     QuizDTO nun = quizdao.getNun();

                     System.out.println();
                     System.out.println("\t 과목을 선택해 주세요");
                     System.out.println();
                     System.out.print("\t [1]강태우 \t[2]임경남 \t[3]김운비 >> \t");
                     int first_sel = sc.nextInt();
                     if (first_sel == 1) {
                        System.out.println();
                        System.out.println(" \t 태우쌤을 선택하셨습니다. ദ്ദി(˶˙ᵕ˙˶)\t ");
                        System.out.println();
                        System.out.println(" \t 다들 점심은 맛있게 드셨나요? \t ");
                        System.out.println(" \t 이제부터 실무에서 자주 사용되는 DB에 관한 문제를 풀어볼게요. ");
                        System.out.println(" \t 각 문제의 배점은 10점이구요. ");
                        System.out.println(" \t tmi이긴 한데.. 아 좀 너무 tmi인가? 아니다 그냥 넘어갈게요 ~");

                        System.out.println();
                        System.out.println("\t 과목을 선택해주세요. ");
                        System.out.print("\t [1]DB \t\t [2]이전 메뉴\t >> \t ");
                        int in_one = sc.nextInt();
                        if (in_one == 1) {
                           System.out.println();
                           System.out.println("데이터베이스 문제를 선택 하셨습니다.");
                           System.out.println();
                           System.out.println(
                                 "___________________________________________________________________________________________________________________________________________________");
                           System.out.println();
                           System.out.println("[문제]");
                           System.out.println();
                           System.out.println(db.getQuestion());
                           System.out.println(
                                 "___________________________________________________________________________________________________________________________________________________");
                           System.out.println();
                           System.out.print("\t 정답입력 >> \t");
                           answer = sc.next();
                           System.out.println();
                           if (db.getAnswer().equals(answer)) {
                              System.out.println();
                              System.out.println("\t 정답입니다. \t");
                              System.out.println("\t10점을 획득 하셨습니다.\t");
                              score += 10;
                              System.out.println("\t현재점수는 " + score + "점 입니다.\t");
                              System.out.println();
                           } else {
                              System.out.println();
                              System.out.println("\t땡! \t");
                              System.out.println();
                           }
                        } else if (in_one == 2) {
                           System.out.println();
                           System.out.println("\t 이전 화면으로 돌아갑니다.");
                           System.out.println();
                        } else {
                           System.out.println();
                           System.out.println("\t 다시 선택해 주세요");
                           System.out.println();
                        }
                     }
                     if (first_sel == 2) {
                        System.out.println();
                        System.out.println(" \t 경남쌤을 선택하셨습니다. \t ");
                        System.out.println(" \t 반가워요 여러분~~ \t ");

                        System.out.println("\t 모든 정답의 답은 띄어쓰기 없이 소문자로 입력하세요 \t");
                        System.out.println("\t 모든 문제의 배점은 10점 입니다. \t");
                        System.out.println();

                        System.out.println("\t 과목을 선택해주세요. \t");
                        System.out.println();

                        System.out.print("\t [1]java \t [2]python \t [3]이전 메뉴>> \t");
                        int in_two = sc.nextInt();

                        if (in_two == 1) {
                           System.out.println();
                           System.out.println("\t자바문제를 선택 하셨습니다.\t");
                           System.out.println();
                           System.out.println(
                                 "___________________________________________________________________________________________________________________________________________________");
                           System.out.println();
                           System.out.println("[문제]");
                           System.out.println();
                           System.out.println(java.getQuestion());
                           System.out.println(
                                 "___________________________________________________________________________________________________________________________________________________");
                           System.out.println();
                           System.out.print("\t 정답입력 >> \t");
                           answer = sc.next();
                           System.out.println();
                           if (java.getAnswer().equals(answer)) {
                              System.out.println();
                              System.out.println("\t 정답입니다. \t");
                              System.out.println("\t10점을 획득 하셨습니다.\t");
                              score += 10;
                              System.out.println("\t현재점수는 " + score + "점 입니다.\t");
                              System.out.println();
                              System.out.println("\t새로운 과목을 선택해 주세요!\t");
                           } else {
                              System.out.println();
                              System.out.println("\t 땡!");
                              System.out.println();
                           }
                        } else if (in_two == 2) {
                           System.out.println();
                           System.out.println("\t python문제를 선택 하셨습니다. \t");
                           System.out.println();
                           System.out.println(
                                 "___________________________________________________________________________________________________________________________________________________");
                           System.out.println();
                           System.out.println("[문제]");
                           System.out.println();
                           System.out.println(nun.getQuestion());
                           System.out.println(
                                 "___________________________________________________________________________________________________________________________________________________");
                           System.out.println();
                           System.out.print("\t 정답입력 >> \t");
                           answer = sc.next();
                           System.out.println();
                           if (nun.getAnswer().equals(answer)) {
                              System.out.println();
                              System.out.println("\t 정답입니다. \t");
                              System.out.println("\t 10점을 획득 하셨습니다. \t");
                              score += 2;
                              System.out.println("\t 현재점수는 " + score + "점 입니다. \t");
                              System.out.println();
                           } else {
                              System.out.println();
                              System.out.println("\t 땡!  \t");
                              System.out.println();
                           }
                        } else if (in_two == 3) {
                           System.out.println();
                           System.out.println("\t 이전 화면으로 돌아갑니다.");
                           System.out.println();
                        } else {
                           System.out.println();
                           System.out.println("\t 다시 선택해 주세요 \t");
                           System.out.println();
                        }
                     }
                     if (first_sel == 3) {
                        System.out.println("\t 운비 쌤을 선택하셨습니다");
                        System.out.println("\t 여러분 자바 너무 재미없지 않아요?  \t ");
                        System.out.println("\t 자바를 사랑하는 사람으로써... 저도 처음에 그랬어요ㅎㅎ  \t ");
                        System.out.println();
                        System.out.println("\t 답은 띄어쓰기없이 소문자로 입력하세요! \t");
                        System.out.println("\t 모든 문제의 배점은 각 10점 입니다. \t");
                        System.out.println();
                        System.out.print("\t [1]JAVA \t [2]C++ \t [3]이전 메뉴>> \t");
                        int in_three = sc.nextInt();
                        if (in_three == 1) {
                           System.out.println(
                                 "___________________________________________________________________________________________________________________________________________________");
                           System.out.println();
                           System.out.println("[문제]");
                           System.out.println();
                           System.out.println(java.getQuestion());
                           System.out.println(
                                 "___________________________________________________________________________________________________________________________________________________");
                           System.out.println();
                           System.out.print("\t 정답입력 >> \t");
                           String user_Answer = sc.next();
                           System.out.println();
                           if (java.getAnswer().equals(user_Answer)) {
                              System.out.println();
                              System.out.println("\t 정답입니다. \t");
                              System.out.println("\t10점을 획득 하셨습니다.\t");
                              score += 10;
                              System.out.println("\t현재점수는 " + score + "점 입니다.\t");
                              System.out.println();
                           } else {
                              System.out.println();
                              System.out.println("\t 땡!  \t");
                              System.out.println();
                           }
                        } else if (in_three == 2) {
                           while (true) {
                              quizdao.getJava();
                              System.out.println("\t==========================");
                              System.out.println("\t404 Not Found : catch java");
                              System.out.println("\t==========================");
                              System.out.println();
                              System.out.println("\t수강할 과목을 다시 선택하세요");
                              System.out.print("\t [1]JAVA \t[2]C++ \t [3]이전 메뉴>> \t");
                              int in_four = sc.nextInt();

                              if (in_four == 1) {
                                 System.out.println(
                                       "___________________________________________________________________________________________________________________________________________________");
                                 System.out.println();
                                 System.out.println("[문제]");
                                 System.out.println();
                                 System.out.println(java.getQuestion());
                                 System.out.println(
                                       "___________________________________________________________________________________________________________________________________________________");
                                 System.out.println();
                                 System.out.print("\t 정답입력 >> \t");
                                 String user_Answer = sc.next();
                                 System.out.println();
                                 if (java.getAnswer().equals(user_Answer)) {
                                    System.out.println();
                                    System.out.println("\t 정답입니다. \t");
                                    System.out.println("\t10점을 획득 하셨습니다.\t");
                                    score += 10;
                                    System.out.println("\t현재점수는 " + score + "점 입니다.\t");
                                    System.out.println();
                                    break;
                                 } else {
                                    System.out.println();
                                    System.out.println(" \t땡! \t");
                                    System.out.println();
                                    break;
                                 }
                              }
                           }

                        } else if (in_three == 3) {
                           System.out.println();
                           System.out.println("\t 이전 화면으로 돌아갑니다.");
                           System.out.println();
                        } else {
                           System.out.println();
                           System.out.println("\t 다시 선택해 주세요");
                           System.out.println();
                        }

                     }

                  }

               }
               ArrayList a = new ArrayList();
               for (int i = 0; i < 10000000; i++) {
                  a.add(new Random().nextInt());
               }
               long end = System.currentTimeMillis();
               int result = (int) (end - start);
               System.out.println("총 걸린 시간 : " + (result) / 1000 + "초"); // 최종 실행시간
               RankDTO dto = new RankDTO();
               System.out.println();
               System.out.print("랭킹에 등록하실 닉네임을 입력하세요 >> ");
               String nick = sc.next();
               dto.setNickname(nick);
               dto = new RankDTO(dto.getNickname(), result / 1000);
               RankDAO dao = new RankDAO();
               dao.getTimer(dto);
            } else {
               System.out.println("로그인에 실패했어요ㅠㅠ");
               System.out.println();
               System.out.println("아이디나 비밀번호를 다시 확인해주세요ｰ̀εｰ́");

            }

         } else if (choice == 3) {
            System.out.println();
            System.out.println();
            System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
            System.out.println("  _    _    _    _    _    _    _    _    _    _    _  \r\n"
                  + " / \\  / \\  / \\  / \\  / \\  / \\  / \\  / \\  / \\  / \\  / \\ \r\n"
                  + "( L )( E )( A )( D )( E )( R )( B )( O )( A )( R )( D )\r\n"
                  + " \\_/  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/ ");
            System.out.println();
            System.out.println("       RANKING \t         RECORD          NICKNAME");

            RankDAO dao = new RankDAO();
            ArrayList<RankDTO> list = dao.Ranking();

            for (RankDTO rank : list) {
               System.out.print("\t  " + rank.getRanking() + "\t");
               System.out.print("\t  " + rank.getTime() + "초" + "\t");
               System.out.println("\t  " + rank.getNickname());
               System.out.println("-----------------------------------------------------");
            }
            System.out.println();
            System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
            System.out.println();
            System.out.println("\t      메인 메뉴로 돌아갑니다 /ᐠ｡ꞈ｡ᐟ✿\\");

         } else if (choice == 4) {
            System.out.println();
            System.out.println();
            System.out.println("\t 종료할게요 ʢᵕᴗᵕʡ ");
            break;

         } else {
            System.out.println();
            System.out.println();
            System.out.println("\t 잘못 누르셨네요( Ĭ ^ Ĭ ) 처음으로 돌아갑니다~");

         }

      }

   }
}