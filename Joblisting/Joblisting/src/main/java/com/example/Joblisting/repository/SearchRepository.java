package com.example.Joblisting.repository;

import com.example.Joblisting.model.Post;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public interface SearchRepository {


    List<Post> findByText(String text);
}
