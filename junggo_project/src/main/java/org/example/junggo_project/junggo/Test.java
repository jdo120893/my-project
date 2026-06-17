package org.example.junggo_project.junggo;//package junggo;
//
//import junggo.board.dto.BoardDTO;
//import junggo.board.service.BoardService;
//import junggo.board.service.BoardServiceImpl;
//import junggo.user.dao.UserDAO;
//import junggo.user.dao.UserDAOImpl;
//import junggo.user.dto.UserDTO;
//import junggo.user.service.UserService;
//import junggo.user.service.UserServiceImpl;
//
//import java.util.List;
//
//public class Test {
////
//    private static UserService userService = new UserServiceImpl();
//    private static BoardService boardService = new BoardServiceImpl();
////
//    public static void main(String[] args) {

//        UserDTO udto = userService.login("jdo120893@gmail.com", "1234");
//        System.out.println(udto.getName());
//
//        List<BoardDTO> boards = boardService.selectBoard();
//        for (BoardDTO board : boards) {
//            System.out.println(board.getTitle());
//            System.out.println(board.getText());
//        }
//    }
//    }
//  테스트 해봐야함
//        UserDAO dao = new UserDAOImpl();
//        UserDTO udto = userService.login("jdo120893@gmail.com", "1234");
//        System.out.println(udto.getName());
//
//        BoardDTO board = new BoardDTO(udto.getId(), "제목1", "본문1", 100, 0 ,1);
//        boolean result = boardService.insertBoard(board);
//
//
//
//        if (result) {
//            System.out.println("성공");
//        } else {
//            System.out.println("실패");
//        }
//    }
//}


//
//        if (dto != null) {
//            // 객체가 정상적으로 반환된 경우
//            System.out.println("로그인 성공! 이름: " + dto.getName());
//        } else {
//            // DB에 데이터가 없거나 로그인이 실패한 경우
//            System.out.println("로그인 실패: 사용자 정보를 찾을 수 없습니다.");
//        }


//        UserDAOlmp1 dao = new UserDAOlmp1();
//        UserDTO dto = new UserDTO(3, "jdo120893@gmail.com", "1234", "joeng", "경기도", "010-9932-3537");
////
//        if (dao.insertUser(dto)) {
//            System.out.println("DB 저장 성공");
//        } else {
//            System.out.println("저장 실패");


//        int count = dao.updateMember(dto);
//        System.out.println(count+"건 수정완료!!");
//
//        dao.deleteMember(15);
//
//        MemberDTO resultDto = dao.getMember(3);
//        System.out.println(resultDto.getName());
//        System.out.println(resultDto);

//        List<UserDTO> userList = dao.getUsers();
//        for (UserDTO user : userList) {
//            System.out.println(user);



