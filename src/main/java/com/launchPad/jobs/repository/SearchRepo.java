package com.launchPad.jobs.repository;

import com.launchPad.jobs.model.Post;

import java.util.List;

public interface SearchRepo {
     List<Post> findByText(String text);
}
