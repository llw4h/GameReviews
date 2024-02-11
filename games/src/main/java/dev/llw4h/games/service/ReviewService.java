package dev.llw4h.games.service;

import dev.llw4h.games.model.Review;

public interface ReviewService {
    Review createReview(String reviewBody, String appId);
}
