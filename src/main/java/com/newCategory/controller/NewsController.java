package com.newCategory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.newCategory.entity.News;
import com.newCategory.service.NewsService;

@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("header", "New Category");
        return "home";
    }
    
    @GetMapping("/list")
    public String listNews(Model model) {
        model.addAttribute("newsList", newsService.getAllNews());
        return "list";
    }

    @GetMapping("/addnews")
    public String addNewsForm(Model model) {
        model.addAttribute("news", new News());
        return "addnews";
    }

    @PostMapping("/addnews")
    public String addNews(@ModelAttribute News news) {
        newsService.saveNews(news);
        return "redirect:/list";
    }
    
    
    @GetMapping("/viewNews/{id}")
    public String viewNews(@PathVariable("id") String id, Model model) {
    	News news = newsService.findbyId(id);
    	model.addAttribute("news", news);
    	return "viewNews";
    }
//    @GetMapping("/viewNews/{id}")
//    public String viewNews(@PathVariable("id") Long id, Model model) {
//        News news = newsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid news Id:" + id));
//        model.addAttribute("news", news);
//        return "view-news";
//    }

    
}