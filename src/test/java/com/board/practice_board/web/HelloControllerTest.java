package com.board.practice_board.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)    //스프링 부트와 junit 사이의 연결자 역할
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired  //빈을 주입 받는다.
    private MockMvc mvc;    //웹 API를 테스트할 때 사용한다, 스프링 Mvc 테스트의 시작점이다, 이 클래스를 통해 GET, POST 등에 대한 API를 테스트 할 수 있다.

    @Test
    public void hello가_리턴된다() throws Exception {

        String hello = "hello";

        mvc.perform(get("/hello"))  //MockMVC를 통해 /hello 주소로 get 요청을 한다. 체이닝을 지원하여 여러 검증 기능을 이어서 선언할 수 있다.
                .andExpect(status().isOk())     //Http 헤더의 상태를 검증한다, isOk : 200 인지 검증한다.
                .andExpect(content().string(hello));    //응답 본문 내용을 검증한다. 컨트롤러에서 hello를 리턴하기 때문에 값이 맞는지 검증한다.
    }

}
