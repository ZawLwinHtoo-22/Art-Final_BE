package com.art.artproject.service;

import com.art.artproject.dto.NewFeedbackRequest;
import com.art.artproject.entity.Feedback;
import jakarta.transaction.Transactional;

import java.util.List;


public interface FeedbackService {

    Feedback giveFeedback(Long user_id, NewFeedbackRequest feedbackRequest);
   List<Feedback> showAll();
    void delete(Long id);

}
