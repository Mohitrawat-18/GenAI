package com.demo.basic_genai_project;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TwiggyService {

    private final ChatClient chatClient;
    private List<Message> history = new ArrayList<>();

    public TwiggyService(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    public String chat(String message){

        String prompt = """ 
        You are a customer support executive of our food delivery
        application called Twiggy.Respond to customer query professionally.
        
        If user is furious or angry or have any issue use words like
        I understand your concern, or I am sorry you have to through this
        and so on. Then solve customer query and give a response. 
        
        Always respond in not more than one line.
       
        Do not respond to any other message which is not related to 
        ordering food query, refund query, order tracking status query
        or company policy query. if below message ask an other information
        other than food delivery just respond this is beyond my 
        capability.
        
        Below is customer query : 
        """ + message;

        history.add(new UserMessage(prompt));

        String output =  chatClient.prompt()
                .messages(history)
                .call()
                .content();

        history.add(new AssistantMessage(output));

        return output;
    }
}
