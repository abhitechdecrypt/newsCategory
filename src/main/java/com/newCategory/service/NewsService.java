package com.newCategory.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newCategory.entity.News;
import com.newCategory.repository.NewsRepository;

@Service
public class NewsService {
	@Autowired
	private NewsRepository newsRepository;

	public Iterable<News> getAllNews() {
		return newsRepository.findAll();
	}

	public void saveNews(News news) {
		news.setId(UUID.randomUUID().toString());
		news.setImageUrl("/images/image10.jpeg");
		newsRepository.save(news);
	}

	public News findbyId(String id) {
		News news = newsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid news Id:" + id));

		return news;
	}
}