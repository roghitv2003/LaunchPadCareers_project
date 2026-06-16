package com.launchPad.jobs.repository;

import com.launchPad.jobs.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepo extends MongoRepository<Post,String> {

}
