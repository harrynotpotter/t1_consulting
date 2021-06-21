package com.example.t1_consulting.controllers;

import com.example.t1_consulting.services.NoteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = {NoteController.class})
@DirtiesContext
//@ExtendWith(MockitoExtension.class)
class NoteControllerTest {

    @Autowired
    MockMvc mvc;
    @MockBean
    NoteService noteService;

    @Test
    void addNote() throws Exception{
        String json = "{\n" +
                "  \"date\":\"2021-06-21\",\n" +
                "  \"name\":\"dfsdsdfds\",\n" +
                "  \"text\":\"ewewewew\"\n" +
                "}";

        mvc.perform(post("/notes/add")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    void changeNote() throws Exception{

        String json = "{\n" +
                "  \"id\": \"1\",\n" +
                "  \"date\":\"2021-06-21\",\n" +
                "  \"name\":\"dfsdsdfds\",\n" +
                "  \"text\":\"ewewewew\"\n" +
                "}";

        mvc.perform(post("/notes/update")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    void deleteProduct() throws Exception {

        mvc.perform(get("/notes/delete/1")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void getNotes() throws Exception{
        String json = "{\n" +
                "  \"date\":\"2021-06-21\"\n" +
                "}";

        mvc.perform(post("/notes/")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    void getNotesLike() throws Exception{
        String json = "{\n" +
                "  \"text\":\"ewew\"\n" +
                "}";


        mvc.perform(post("/notes/like")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isOk());
    }
}