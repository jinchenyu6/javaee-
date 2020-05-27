package com.example.demo.db.service;


import com.example.demo.db.mapper.HomeworkMapper;
import com.example.demo.db.model.Homework;
import org.springframework.stereotype.Service;

@Service
public class HomeworkService extends BaseService<Homework, Long, HomeworkMapper> {
}
