package org.example.junggo_project.junggo.board.service;


import org.example.junggo_project.junggo.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    boolean insertBoard(BoardDTO boardDTO);
    List<BoardDTO> selectBoard();

}
