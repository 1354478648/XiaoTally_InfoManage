package com.sues.controller;


import com.sues.entity.Record;
import com.sues.service.CategoryService;
import com.sues.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping("/deleteRecord")
    public String deleteRecord(@RequestParam("id") String id){
        recordService.deleteRecord(id);
        return "redirect:/record";
    }

    @PostMapping("/addRecord")
    public String addRecord(String Amount, String CategoryID, String Type, String Status, String Note){
        recordService.addRecord(Amount, CategoryID, Type, Status, Note);
        return "redirect:/record";
    }

    @PostMapping("/updateRecord")
    public String updateRecord(String id, String Amount, String CategoryID, String Type, String Status, String Note){
        recordService.updateRecord(id, Amount, CategoryID, Type, Status, Note);
        return "redirect:/record";
    }

    @GetMapping("/searchRecord")
    public String searchRecord(@RequestParam("search")String search, Model model){
        List<Record> searchResults = recordService.getRecordListBySearch(search);
        model.addAttribute("searchResults", searchResults);
        return "forward:/record";
    }
}
