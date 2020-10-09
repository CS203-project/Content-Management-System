package com.ryverbank.cms;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.factory.annotation.Autowired;  

import java.util.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CMSController {

    
    private CMSService cms;
    
    @Autowired
    public CMSController(CMSService cms) {
        this.cms = cms;
    }

    // CHECK PERMISSIONS
    // ONLY ANALYSTS AND MANAGERS CAN POST
    @PostMapping(path="/contents")
    public @ResponseBody String addContent (@RequestBody Content content) {
        // cms.save(content);
        // return "Saved new article";
        return cms.addContent(content);
    }

    @GetMapping(path="/contents")
    public @ResponseBody List<Content> getContents() {
        //  Iterable<Content> contents = cmsRepository.findAll();
        //  Iterator<Content> iter = contents.iterator();
        //  while (iter.hasNext()) {
        //      Content c = (Content) iter.next();
        //      if (!c.getApproved()) {
        //          iter.remove();
        //      }
         //}
         return cms.listContent();
    }

    @PutMapping("/content/{id}")
    public Content updateContent(@PathVariable Long id, @RequestBody Content newContentInfo){
        Content content = cms.updateContent(id, newContentInfo);
        if(content == null) throw new ContentNotFoundException(id);      
        return content;
    }

    @DeleteMapping("/content/{id}")
    public void deleteBook(@PathVariable Long id){
        try{
            cms.deleteContent(id);
         }catch(EmptyResultDataAccessException e) {
            throw new ContentNotFoundException(id);
         }
    }

}