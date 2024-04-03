package com.art.artproject.controller;

import com.art.artproject.domain.TalentResponse;
import com.art.artproject.dto.NewFeedbackRequest;
import com.art.artproject.entity.Feedback;
import com.art.artproject.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<TalentResponse<Feedback>> giveFeedback(@RequestParam Long user_id, @RequestBody NewFeedbackRequest request){
        Feedback feedback = feedbackService.giveFeedback(user_id, request);
        TalentResponse response =
                new TalentResponse<>(feedback, "Success give feedback",HttpStatus.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<TalentResponse<List<Feedback>>> showAll(){
        List<Feedback> feedbacks=feedbackService.showAll();
        TalentResponse<List<Feedback>> response=
                new TalentResponse<>(feedbacks,"All feedbacks",HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteFeedback(@RequestParam Long id){
        feedbackService.delete(id);

        return new ResponseEntity<>(" Deleted By Id " + id, HttpStatus.NO_CONTENT);
    }

}
