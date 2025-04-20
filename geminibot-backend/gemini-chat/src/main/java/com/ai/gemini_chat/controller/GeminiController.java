package com.ai.gemini_chat.controller;

import com.ai.gemini_chat.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/chat")
public class GeminiController {

    private final ChatService chatService;

    @PostMapping("/question")
    public ResponseEntity<String> askQuestion(@RequestBody Map<String,String> payload){
        String question = payload.get("question");
        String answer=chatService.getAnswer(question);
        return ResponseEntity.ok(answer);
    }
}
