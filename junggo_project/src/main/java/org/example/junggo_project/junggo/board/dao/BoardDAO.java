package org.example.junggo_project.junggo.board.dao;



import org.example.junggo_project.junggo.board.dto.BoardDTO;
import java.util.List;


public interface BoardDAO {
    boolean insertBoard(BoardDTO boardDTO);
    List<BoardDTO> selectBoard();
}
