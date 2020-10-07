package com.ryverbank.cms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;  

import java.util.*;

@RestController
public class CMSController {

    @Autowired
    private CMSRepository cmsRepository;

    public CMSController() {}

    // CHECK PERMISSIONS
    // ONLY ANALYSTS AND MANAGERS CAN POST
    @PostMapping(path="/contents")
    public @ResponseBody String addContent (@RequestBody Content content) {
        cmsRepository.save(content);
        return "Saved new article";
    }

    @GetMapping(path="/contents")
    public @ResponseBody Iterable<Content> getContents() {
         Iterable<Content> contents = cmsRepository.findAll();
         Iterator<Content> iter = contents.iterator();
         while (iter.hasNext()) {
             Content c = (Content) iter.next();
             if (!c.getApproved()) {
                 iter.remove();
             }
         }
         return contents;
    }
}