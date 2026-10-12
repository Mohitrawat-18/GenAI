package com.demo.basic_genai_project;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class SummarizeService {

    private final ChatClient chatClient;

    public SummarizeService(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    public String summarize(String ticket){

        String output =  chatClient.prompt()
                .user("Summarize this support in two lines : \n\n" + ticket)
                .call()
                .content();

        return output;
    }
}
