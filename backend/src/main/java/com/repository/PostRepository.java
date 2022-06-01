/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repository;

/**
 *
 * @author Kone Adama
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.model.Post;
import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<Post, String> {

    List<Post> findAllByTitleContaining(String title);

    public Optional<Post> findById(int id);
}