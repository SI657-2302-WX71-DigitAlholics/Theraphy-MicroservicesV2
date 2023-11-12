package com.digitalholics.socialservice.mapping;



import com.digitalholics.socialservice.domain.model.entity.Review;
import com.digitalholics.socialservice.mapping.configuration.EnhancedModelMapper;
import com.digitalholics.socialservice.resource.CreateReviewResource;
import com.digitalholics.socialservice.resource.ReviewResource;
import com.digitalholics.socialservice.resource.UpdateReviewResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ReviewMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public ReviewResource toResource(Review model) {
        return mapper.map(model, ReviewResource.class);
    }

    public Review toModel(CreateReviewResource resource) {
        return mapper.map(resource, Review.class);
    }

    public Review toModel(UpdateReviewResource resource) {
        return mapper.map(resource, Review.class);
    }

    public Page<ReviewResource> modelListPage(List<Review> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ReviewResource.class), pageable, modelList.size());
    }
}
