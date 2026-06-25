package org.example.tododb_swagger_project.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.tododb_swagger_project.dto.TodoUserRequestDto;
import org.example.tododb_swagger_project.dto.TodoUserResponseDto;
import org.example.tododb_swagger_project.service.TodoUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Todo", description = "할일 관리 API")
@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoUserController {

    private final TodoUserService todoUserService;

    @Operation(summary = "할일 추가", description = "새로운 할일을 추가합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "할일 추가 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TodoUserResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "요청 값이 올바르지 않음",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<TodoUserResponseDto> create(@Valid @RequestBody TodoUserRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoUserService.create(requestDto));
    }

    @Operation(summary = "전체 목록 조회", description = "할일 전체 목록을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "조회 성공",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TodoUserResponseDto.class)))
    @GetMapping
    public ResponseEntity<List<TodoUserResponseDto>> findAll() {
        return ResponseEntity.ok(todoUserService.findAll());
    }

    @Operation(summary = "단건 조회", description = "id로 할일 하나를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TodoUserResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "해당 할일 없음",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<TodoUserResponseDto> findById(@Parameter(description = "할일 ID", required = true)
                                                        @PathVariable Long id) {
        return ResponseEntity.ok(todoUserService.findById(id));
    }

    @Operation(summary = "할일 수정", description = "id로 할일을 수정합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "수정 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TodoUserResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "해당 할일 없음",
                    content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<TodoUserResponseDto> update(@Parameter(description = "할일 ID", required = true)
                                                      @PathVariable Long id,
                                                      @Valid @RequestBody TodoUserRequestDto requestDto) {
        return ResponseEntity.ok(todoUserService.update(id, requestDto));
    }

    @Operation(summary = "할일 삭제", description = "id로 할일을 삭제합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "삭제 성공"),
            @ApiResponse(responseCode = "404", description = "해당 할일 없음",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "할일 ID", required = true)
                                       @PathVariable Long id) {
        todoUserService.delete(id);
        return ResponseEntity.noContent().build();
    }
}