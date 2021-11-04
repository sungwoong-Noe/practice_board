package com.board.practice_board.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor    //final필드가 포함된 생성자를 자동으로 생성해줌
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
