package com.classmanager.mapper;

import com.pojo.Classes;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface ClassMapper {
    //新增
    @Insert("insert into lcn_class(id,class_name,create_time values(#{id},#{className},#{createDate})")
    //主键自增
    //@SelectKey(statement = "select @@identity as id",keyColumn = "id" , keyProperty = "id" , before = false,resultType = Long.class)
    int insertClass(Classes classes);
    //查询
    @Select("select id,class_name as className,createDate from lcn_class where id=#{id} ")
    Classes selectById(Long id);
}
