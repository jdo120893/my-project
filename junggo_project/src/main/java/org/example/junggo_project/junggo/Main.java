package org.example.junggo_project.junggo;


import org.example.junggo_project.junggo.board.dto.BoardDTO;
import org.example.junggo_project.junggo.board.service.BoardService;
import org.example.junggo_project.junggo.board.service.BoardServiceImpl;
import org.example.junggo_project.junggo.user.dto.UserDTO;
import org.example.junggo_project.junggo.user.service.UserService;
import org.example.junggo_project.junggo.user.service.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static UserService userService = new UserServiceImpl();
    private static BoardService boardService = new BoardServiceImpl();

    public static void printMenu(){
        System.out.println("===============");
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("3. 종료");
        System.out.println("===============");
    }

    public static void printSubMenu(){
        System.out.println("==============");
        System.out.println("1. 글 목록 보기");
        System.out.println("2. 글 작성");
        System.out.println("3. 로그아웃");
        System.out.println("=============");
    }

    public static void signUp(Scanner sc){
        UserDTO dto = new UserDTO();
        System.out.print("회원 정보를 입력해주세요.");
        System.out.print("이메일:");
        dto.setEmail(sc.nextLine());
        System.out.print("비밀번호:");
        dto.setPassword(sc.nextLine());
        System.out.print("이름:");
        dto.setName(sc.nextLine());
        System.out.print("주소:");
        dto.setAddress(sc.nextLine());
        System.out.print("전화번호:");
        dto.setPhone_number(sc.nextLine());
        userService.insertUser(dto);
    }
    public static UserDTO login(Scanner sc){
        System.out.println("====로그인====");
        System.out.println("이메일");
        String email = sc.nextLine();
        System.out.println("비밀번호");
        String password = sc.nextLine();
        return userService.login(email,password);
    }

    public static void write(Scanner sc, UserDTO udto){
        sc.nextLine();
        BoardDTO bdto = new BoardDTO();
        bdto.setUser_id(udto.getId());
        System.out.println("글 제목: ");
        bdto.setTitle(sc.nextLine());
        System.out.println("본문: ");
        bdto.setText(sc.nextLine());
        System.out.println("가격: ");
        bdto.setPrice(sc.nextInt());
        sc.nextLine();
        System.out.println("카테고리: ");
        bdto.setCategory(sc.nextInt());
        sc.nextLine();
        boolean result = boardService.insertBoard(bdto);
        if(result){
            System.out.println("글 등록 성공!");
        }else {
            System.out.println("글 등록 실패");
        }

    }

    public static void main(String[] args) {
        UserDTO udto = null;
        Scanner sc = new Scanner(System.in);
        while (true){
            printMenu();
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("=====로그인====");
                    System.out.println("이메일 입력");
                    String email = sc.nextLine();
                    System.out.println("비밀번호 입력");
                    String password = sc.nextLine();
                    udto = userService.login(email, password);
                    if(udto != null) {
                        boolean logout = true;
                        while (logout) {
                            printSubMenu();
                            int subMenuchoice = sc.nextInt();
                            sc.nextLine();
                            switch (subMenuchoice) {
                                case 1:
                                    List<BoardDTO> boards = boardService.selectBoard();
                                    for(BoardDTO board : boards){
                                        System.out.println(board.toString());
                                    }
                                    break;
                                case 2:
                                    write(sc, udto);
                                    break;
                                case 3:
                                    System.out.println("로그아웃");
                                    logout = false;
                                    break;
                                default:
                                    System.out.println("잘못된 번호");
                            }
                        }
                    }
                    break;
                case 2:
                    signUp(sc);

                    System.out.println("회원가입이 완료되었습니다.");
                    break;
                case 3:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못된 번호");
            }
        }
    }
}
