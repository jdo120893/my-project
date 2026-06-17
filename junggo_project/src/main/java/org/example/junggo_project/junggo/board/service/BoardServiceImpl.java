package org.example.junggo_project.junggo.board.service;



import org.example.junggo_project.junggo.board.dao.BoardDAO;
import org.example.junggo_project.junggo.board.dao.BoardDAOImpl;
import org.example.junggo_project.junggo.board.dto.BoardDTO;

import java.util.List;

public class BoardServiceImpl implements BoardService{
    private BoardDAO boardDAO = new BoardDAOImpl();


    @Override
    public boolean insertBoard(BoardDTO boardDTO) {
//        BoardDTO dto = new BoardDTO();
//        dto.setUser_Id(user_id);
//        dto.setTitle(title);
//        dto.setText(text);
//        dto.setPrice(price);
//        dto.setCategory(category);

        return boardDAO.insertBoard(boardDTO);
    }

    public List<BoardDTO> selectBoard(){

        return boardDAO.selectBoard();
    }
}
