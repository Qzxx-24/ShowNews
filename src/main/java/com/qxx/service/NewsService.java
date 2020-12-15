package com.qxx.service;

import com.qxx.bean.News;
import com.qxx.bean.NewsExample;
import com.qxx.dao.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsService {
    @Autowired
    NewsMapper newsMapper;

    public Map<Integer,Object> getColumns() {
        NewsExample newsExample = new NewsExample();
        NewsExample.Criteria criteria = newsExample.createCriteria();
        criteria.andPidEqualTo(0);
        criteria.andShowTypeEqualTo("0");
        List<News> type0List = newsMapper.selectByExample(newsExample);
        NewsExample newsExample2 = new NewsExample();
        NewsExample.Criteria criteria2 = newsExample2.createCriteria();
        criteria2.andPidEqualTo(0);
        criteria2.andShowTypeEqualTo("-1");
        List<News> typeSpecialList = newsMapper.selectByExample(newsExample2);
        Map<Integer,Object> map = new HashMap<>();
        map.put(0,type0List);
        map.put(-1,typeSpecialList);
        return map;
    }

    public List<News> getAll() {
        NewsExample newsExample = new NewsExample();
        return newsMapper.selectByExample(newsExample);
    }

    public Map<Integer, Object> getSectionContent(Integer id){
        NewsExample newsExample = new NewsExample();
        NewsExample.Criteria criteria = newsExample.createCriteria();
        criteria.andPidEqualTo(id);
        criteria.andShowTypeEqualTo("1");
        List<News> type1List = newsMapper.selectByExample(newsExample);
        NewsExample newsExample2 = new NewsExample();
        NewsExample.Criteria criteria2 = newsExample2.createCriteria();
        criteria2.andPidEqualTo(id);
        criteria2.andShowTypeEqualTo("2");
        List<News> type2List = newsMapper.selectByExample(newsExample2);
        Map<Integer,Object> map = new HashMap<>();
        map.put(1,type1List);
        map.put(2,type2List);
        return map;
    }
}
