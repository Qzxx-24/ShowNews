package com.qxx.controller;

import com.qxx.bean.News;
import com.qxx.bean.msg;
import com.qxx.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class NewsController {
    @Autowired
    NewsService newsService;

    @GetMapping("/getColumns.do")
    public msg getColumns(){
        Map<Integer, Object> columnsList = newsService.getColumns();
        return msg.success().add("columnList",columnsList);
    }
    @GetMapping("/getSection.do")
    public msg getSectionContent(Integer id){
        Map<Integer, Object> sectionContentList = newsService.getSectionContent(id);
        return msg.success().add("sectionContentList",sectionContentList);
    }
}
