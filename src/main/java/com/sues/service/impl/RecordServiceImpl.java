package com.sues.service.impl;

import com.sues.entity.Record;
import com.sues.mapper.RecordMapper;
import com.sues.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public List<Record> getRecordList() {
        return recordMapper.getRecordList();
    }

    @Override
    public void deleteRecord(String ID){
        recordMapper.deleteRecord(ID);
    }

    @Override
    public void addRecord(String Amount, String CategoryID, String Type, String Status, String Note) {
        recordMapper.addRecord(Amount, CategoryID, Type, Status, Note);
    }

    @Override
    public void updateRecord(String id, String Amount, String CategoryID, String Type, String Status, String Note) {
        recordMapper.updateRecord(id, Amount, CategoryID, Type, Status, Note);
    }

    @Override
    public List<Record> getPreUpdateRecordList(String id) {
        return recordMapper.getPreUpdateRecordList(id);
    }

    @Override
    public List<Record> getRecordListBySearch(String search) {
        return recordMapper.getRecordListBySearch(search);
    }

    @Override
    public Double getSumOfAmount() {
        return recordMapper.getSumOfAmount();
    }

    @Override
    public int getCountOfAmount() {
        return recordMapper.getCountOfAmount();
    }
}
