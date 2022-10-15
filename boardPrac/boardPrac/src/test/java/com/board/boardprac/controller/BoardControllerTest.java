package com.board.boardprac.controller;

import com.board.boardprac.BoardPracApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.http.HttpResponse;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BoardPracApplication.class})
@Slf4j
public class BoardControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() {
        // 가짜 MVC에 WebApplicationContext 전달 후 환경 생성
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    @Disabled
    public void testList() throws Exception {
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).toString() //.andReturn().getModelAndView().toString()
        );
    }

    @Test
    @Disabled
    public void testRegister() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
                .param("title", "데스트")
                .param("content", "테스트")
                .param("writer", "cat")).toString();
    }

    @Test
//    @Disabled
    public void testGet() throws Exception {
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
                        .param("bno", "21")).andReturn().getResponse().getContentAsString() //.andReturn().getModelAndView().toString()
        );
    }

    @Test
//    @Disabled
    public void testModify() throws Exception {
//        String result =
                mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
                .param("bno", "2")
                .param("title", "데스트")
                .param("content", "테스트")
                .param("writer", "cat"));
                //.andReturn().getModelAndView().getModelMap().toString();
//        log.info(result);
    }

    @Test
    @Disabled
    public void testRemove() throws Exception {
        StringBuffer result = new StringBuffer();
        String res = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
                        .param("bno", "1"))
                .andReturn().getFlashMap().toString();
        log.info(res);
    }
}
