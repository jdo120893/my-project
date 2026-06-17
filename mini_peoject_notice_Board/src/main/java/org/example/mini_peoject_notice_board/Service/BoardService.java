package org.example.mini_peoject_notice_board.Service;

import lombok.RequiredArgsConstructor;
import org.example.mini_peoject_notice_board.domain.Board;
import org.example.mini_peoject_notice_board.dto.BoardRequestDto;
import org.example.mini_peoject_notice_board.dto.BoardResponseDto;
import org.example.mini_peoject_notice_board.exception.BoardNotFoundException;
import org.example.mini_peoject_notice_board.exception.PasswordMismatchException;
import org.example.mini_peoject_notice_board.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional // 기본적으로 모든 메서드에 트랜잭션 적용
public class BoardService {

    private final BoardRepository boardRepository;

    // 내부 전용 엔티티 조회 메서드 (조회수 증가 X)
    @Transactional(readOnly = true)
    public Board findBoardById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException(id));
    }

    // 목록 조회 (DTO 변환은 Controller나 Service 어디서든 가능하나 여기선 Page<Board> 유지)
    @Transactional(readOnly = true)
    public Page<Board> getBoards(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
        return boardRepository.findAll(pageable);
    }

    // 상세 조회 (이때만 조회수 증가!)
    public Board getBoardDetail(Long id) {
        Board board = findBoardById(id);
        board.setViewCount(board.getViewCount() + 1);
        return boardRepository.save(board); // 변경 사항 저장
    }

    public Board saveBoard(BoardRequestDto requestDto) {
        Board board = new Board(
                requestDto.getName(),
                requestDto.getTitle(),
                requestDto.getContent(),
                requestDto.getPassword()
        );
        return boardRepository.save(board);
    }

    public void updateBoard(Long id, BoardRequestDto requestDto, String password) {
        Board existing = findBoardById(id); // 조회수 증가 없는 메서드 호출
        if (!existing.getPassword().equals(password)) {
            throw new PasswordMismatchException();
        }
        existing.setName(requestDto.getName());
        existing.setTitle(requestDto.getTitle());
        existing.setContent(requestDto.getContent());
        existing.setUpdatedAt(java.time.LocalDateTime.now());
        boardRepository.save(existing);
    }

    public void deleteBoard(Long id, String password) {
        Board existing = findBoardById(id); // 조회수 증가 없는 메서드 호출
        if (!existing.getPassword().equals(password)) {
            throw new PasswordMismatchException();
        }
        boardRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Page<Board> searchBoard(String type, String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));

        if(type == null || type.isBlank() || keyword == null || keyword.isBlank()) {
            return boardRepository.findAll(pageable);
        }

        return switch (type) {
            case "title"   -> boardRepository.findByTitleContaining(keyword, pageable);
            case "content" -> boardRepository.findByContentContaining(keyword, pageable);
            case "name"    -> boardRepository.findByNameContaining(keyword, pageable);
            default        -> boardRepository.findAll(pageable);
        };
    }
}