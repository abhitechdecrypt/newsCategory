package com.newCategory.repository;

import org.springframework.data.repository.CrudRepository;

import com.newCategory.entity.News;

public interface NewsRepository extends CrudRepository<News, String> {
	
//	public News findbyId(String id);
}