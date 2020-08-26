package com.studentmanager.mapper;

import com.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {
    @Insert("insert into lcn_student(id,name,age,c_id) values(#{id},#{name},#{age},#{cid})")
    int insertStduent(Student student);
    @Select("select id,name,age,c_id from lcn_student where id = #{id}")
    Student selectById(Long id);
}
