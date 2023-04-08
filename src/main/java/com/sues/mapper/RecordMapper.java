package com.sues.mapper;

import com.sues.entity.Record;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RecordMapper {
    //展示所有记录
    @Select("select ID, Amount, CategoryID, Type, Status, CreatedAt, UpdatedAt, Note from record")
    List<Record> getRecordList();

    //删除记录
    @Delete("delete from record where ID = #{ID}")
    void deleteRecord(String ID);

    //添加记录
    @Insert("insert into record(Amount,CategoryID,Type,Status,CreatedAt,UpdatedAt,Note) values(#{Amount},#{CategoryID},#{Type},#{Status},NOW(),NOW(),#{Note})")
    void addRecord(@Param("Amount")String Amount, @Param("CategoryID")String CategoryID, @Param("Type")String Type, @Param("Status")String Status, @Param("Note")String Note);

    //修改记录
    @Update("update record set Amount = #{Amount},CategoryID = #{CategoryID},Type = #{Type},Status = #{Status},UpdatedAt = NOW(),Note = #{Note} where id = #{id}")
    void updateRecord(@Param("id")String id,@Param("Amount")String Amount,@Param("CategoryID")String CategoryID,@Param("Type")String Type,@Param("Status")String Status,@Param("Note")String Note);

    //在修改页面中显示未修改的数据
    @Select("select Amount,Type,Status,Note from record where id =#{id}")
    List<Record> getPreUpdateRecordList(@Param("id")String id);

    //查找记录
    @Select("select ID,Amount,CategoryID,Type,Status,CreatedAt,UpdatedAt,Note from record where ID = #{search} or Amount = #{search} or CategoryID = #{search} or Type = #{search} or Status = #{search} or CreatedAt = #{search} or UpdatedAt = #{search} or Note = #{search}")
    List<Record> getRecordListBySearch(@Param("search")String search);

    //查找总支出
    @Select("select SUM(Amount) from record")
    Double getSumOfAmount();

    //查找总支出笔数
    @Select("select COUNT(Amount) from record")
    int getCountOfAmount();
}
