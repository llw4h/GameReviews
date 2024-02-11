package dev.llw4h.games.service;

import dev.llw4h.games.model.Game;
import dev.llw4h.games.model.Review;
import dev.llw4h.games.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Review createReview(String reviewBody,String appId){
        Review review = reviewRepository.insert(new Review(reviewBody));


        mongoTemplate.update(Game.class)
                .matching(Criteria.where("appId").is(appId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
