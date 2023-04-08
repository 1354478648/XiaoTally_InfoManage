package com.sues.service;

import com.sues.entity.Record;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordService {
    List<Record> getRecordList();

    void deleteRecord(String ID);

    void addRecord(String Amount, String CategoryID, String Type, String Status, String Note);

    void updateRecord(String id,String Amount,String CategoryID,String Type,String Status,String Note);

    List<Record> getPreUpdateRecordList(String id);

    List<Record> getRecordListBySearch(String search);

    Double getSumOfAmount();

    int getCountOfAmount();
}
