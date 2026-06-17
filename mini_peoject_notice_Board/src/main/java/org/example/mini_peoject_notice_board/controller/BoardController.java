package org.example.mini_peoject_notice_board.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.mini_peoject_notice_board.Service.BoardService;
import org.example.mini_peoject_notice_board.domain.Board;
import org.example.mini_peoject_notice_board.dto.BoardRequestDto;
import org.example.mini_peoject_notice_board.dto.BoardResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "10") int size) {
        // 응답용 DTO 변환을 컨트롤러단에서 처리해도 좋습니다.
        Page<BoardResponseDto> boards = boardService.getBoards(page, size).map(BoardResponseDto::from);
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/view/{id}")
    public String listView(@PathVariable Long id, Model model) {
        Board board = boardService.getBoardDetail(id); // 조회수 증가하는 상세 조회 호출
        model.addAttribute("boards", BoardResponseDto.fromDetail(board));
        return "board/view";
    }

    @GetMapping("/writeform")
    public String writeForm(Model model) {
        model.addAttribute("boardRequestDto", new BoardRequestDto());
        return "board/writeForm";
    }

    @PostMapping("/write")
    public String write(@Valid @ModelAttribute("boardRequestDto") BoardRequestDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "board/writeForm";
        }
        boardService.saveBoard(dto);
        return "redirect:/list";
    }

    @GetMapping("/updateform/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        Board board = boardService.findBoardById(id); // 조회수 증가 없음
        model.addAttribute("boards", board);
        return "board/updateform";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute("boards") BoardRequestDto dto,
                         BindingResult bindingResult,
                         @RequestParam String password,
                         Model model) {
        if (bindingResult.hasErrors()) {
            return "board/updateform";
        }
        try {
            boardService.updateBoard(id, dto, password);
            return "redirect:/view/" + id;
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("boards", boardService.findBoardById(id)); // 예외 발생 시에도 조회수 유지
            return "board/updateform";
        }
    }

    @GetMapping("/deleteform/{id}")
    public String deleteForm(@PathVariable Long id, Model model) {
        model.addAttribute("boards", boardService.findBoardById(id));
        return "board/deleteform";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id,
                         @RequestParam String password,
                         Model model) {
        try {
            boardService.deleteBoard(id, password);
            return "redirect:/list";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("boards", boardService.findBoardById(id));
            return "board/deleteform";
        }
    }

    @GetMapping("/search")
    public String search(@RequestParam String type,
                         @RequestParam String keyword,
                         @RequestParam(defaultValue = "0") int page,
                         @RequestParam(defaultValue = "10") int size,
                         Model model) {
        Page<BoardResponseDto> boards = boardService.searchBoard(type, keyword, page, size).map(BoardResponseDto::from);
        model.addAttribute("boards", boards);
        model.addAttribute("type", type);
        model.addAttribute("keyword", keyword);
        return "board/list";
    }
}