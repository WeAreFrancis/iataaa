package com.wearefrancis.checkersmanager.controller;

import com.wearefrancis.checkersmanager.dto.entity.read.CreatedCheckersGameToReadDTO;
import com.wearefrancis.checkersmanager.service.CheckersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.wearefrancis.checkersmanager.Path.API_PATH;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CheckersManagerController.class)
public class CheckersManagerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CheckersService checkersService;

    @Test
    public void createCheckersGameWithGoodParametersShouldReturnIsCreated() throws Exception {
        // GIVEN
        String resquestBody = "{" +
                "\"difficulty\" : \"EASY\", " +
                "\"gameName\" : \"game1\"," +
                "\"playerName\" : \"player\"" +
         "}";

        given(this.checkersService.create(any())).willReturn(new CreatedCheckersGameToReadDTO());

        // WHEN
        ResultActions result = this.mvc.perform(post(API_PATH + "/checkers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(resquestBody));
        // THEN
        result.andExpect(status().isCreated());
    }

    @Test
    public void createCheckersGameWithoutPlayerNameShouldReturnBadRequest() throws Exception {
        // GIVEN
        String resquestBody = "{" +
                "\"difficulty\" : \"EASY\", " +
                "\"gameName\" : \"game1\"" +
                "}";

        given(this.checkersService.create(any())).willReturn(new CreatedCheckersGameToReadDTO());

        // WHEN
        ResultActions result = this.mvc.perform(post(API_PATH + "/checkers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(resquestBody));
        // THEN
        result.andExpect(status().isBadRequest());
    }

    @Test
    public void createCheckersGameWithoutGameNameShouldReturnBadRequest() throws Exception {
        // GIVEN
        String resquestBody = "{" +
                "\"difficulty\" : \"EASY\", " +
                "\"playerName\" : \"player\"" +
                "}";

        given(this.checkersService.create(any())).willReturn(new CreatedCheckersGameToReadDTO());

        // WHEN
        ResultActions result = this.mvc.perform(post(API_PATH + "/checkers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(resquestBody));
        // THEN
        result.andExpect(status().isBadRequest());
    }

    @Test
    public void createCheckersGameWithoutDifficultyShouldReturnBadRequest() throws Exception {
        // GIVEN
        String resquestBody = "{" +
                "\"gameName\" : \"game1\"," +
                "\"playerName\" : \"player\"" +
                "}";

        given(this.checkersService.create(any())).willReturn(new CreatedCheckersGameToReadDTO());

        // WHEN
        ResultActions result = this.mvc.perform(post(API_PATH + "/checkers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(resquestBody));
        // THEN
        result.andExpect(status().isBadRequest());
    }

}