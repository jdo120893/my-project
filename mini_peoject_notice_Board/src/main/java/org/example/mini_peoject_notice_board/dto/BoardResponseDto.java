package org.example.mini_peoject_notice_board.dto;

import lombok.Builder;
import lombok.Data;
import org.example.mini_peoject_notice_board.domain.Board;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@Data
@Builder
public class BoardResponseDto {

    private Long id;
    private String name;
    private String title;
    private String content;
    private String createdAt;
    private String updatedAt;
    private int viewCount;

    // 목록용 - yyyy/MM/dd
    public static BoardResponseDto from(Board board){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

//        // 💡 null 체크 안전장치 추가
//        String createdAtStr = board.getCreatedAt() != null ? board.getCreatedAt().format(formatter) : "";
//        String updatedAtStr = board.getUpdatedAt() != null ? board.getUpdatedAt().format(formatter) : "";

        return BoardResponseDto.builder()
                .id(board.getId())
                .name(board.getName())
                .title(board.getTitle())
                .content(board.getContent())
                .createdAt(formatDateTime(board.getCreatedAt(),formatter))
                .updatedAt(formatDateTime(board.getUpdatedAt(),formatter))
                .build();

    }

    // 상세용 - yyyy/MM/dd HH:mm
    public static BoardResponseDto fromDetail(Board board) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        return BoardResponseDto.builder()
                .id(board.getId())
                .name(board.getName())
                .title(board.getTitle())
                .content(board.getContent())
                .createdAt(formatDateTime(board.getCreatedAt(), formatter)) // 💡 분리한 메서드 사용
                .updatedAt(formatDateTime(board.getUpdatedAt(), formatter))
                .viewCount(board.getViewCount())
                .build();
    }

    // 💡 날짜 포맷팅 및 null 처리를 담당하는 공통 메서드
   private static String formatDateTime(LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        return localDateTime != null ? localDateTime.format(dateTimeFormatter) : "";
    }
}