package com.coursemanager.service.impl;

import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.coursemanager.service.CourseManagerService;
import com.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class CourseManagerServiceImpl  implements CourseManagerService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @TccTransaction
    public Course createCourse(Course course) {
        Course result = mongoTemplate.insert(course);
        if(result!=null){
            return result;
        }
        return null;
    }

    /**
     * 确认事务方法，即提交事务
     * @param course
     */
    public void confirmmcreateCourse(Course course){
        System.out.println("提交事务管理");
    }

    public void cancelrmmcreateCourse(Course course){
        mongoTemplate.remove(course);
        System.out.println("回滚事务管理");
    }
}
