package com.ryverbank.cms;

import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class CMSServiceImpl implements CMSService {
   
    private CMSRepository cms;
    

    public CMSServiceImpl(CMSRepository cms){
        this.cms = cms;
    }

    @Override
    public List<Content> listContent() {
        return cms.findAll();
    }

    //i don't get how implement this properly, check if you can do it. 
    public boolean contentApproved(Long id, boolean isApproved){
        id.approved = isApproved;
    }
    
    @Override
    // not checking if content exists already, it should (?)
    public Content addContent(Content content) {
        return cms.save(content);
    }
    
    @Override
    public Content updateContent(Long id, Content newContentInfo){
       
        Optional<Content> c = cms.findById(id);
        if (c.isPresent()){
            Content content = c.get();
            c.setTitle(newContentInfo.getTitle());
            return cms.save(content);
        }else
            return null; 
    }

 
    @Override
    public void deleteContent(Long id){
        cms.deleteById(id);
    }
}