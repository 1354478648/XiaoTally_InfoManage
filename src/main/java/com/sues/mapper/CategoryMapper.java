package com.sues.mapper;

import com.sues.entity.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {
    @Select("select ID, Name, Type, Status, CreatedAt, UpdatedAt from category")
    List<Category> getCategoryList();

    @Insert("insert into category(Name,Type,Status,CreatedAt,UpdatedAt) values(#{Name},#{Type},#{Status},NOW(),NOW())")
    void addCategory(@Param("Name")String Name, @Param("Type")String Type, @Param("Status")String Status);

    //删除
    @Delete("delete from category where id = #{id}")
    void deleteCategory(@Param("id")String id);

    //修改
    @Update("update category set Name = #{Name},Type = #{Type},Status = #{Status},UpdatedAt = NOW() where id = #{id}")
    void updateCategory(@Param("id")String id, @Param("Name")String Name, @Param("Type")String Type, @Param("Status")String Status);

    //修改页面：表单输入框里显示原来的数据，方便用户修改
    @Select("select Name,Type,Status from category where id =#{id}")
    List<Category> getPreUpdateCategoryList(@Param("id")String id);

    //查找
    @Select("select ID,Name,Type,Status,CreatedAt,UpdatedAt from category where ID = #{search} or Name = #{search} or Type = #{search} or Status = #{search} or CreatedAt = #{search} or UpdatedAt = #{search}")
    List<Category> getCategoryListBySearch(@Param("search")String search);
}
