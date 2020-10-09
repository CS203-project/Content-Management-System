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

    
    // @Override
    // public Book getBook(Long id){
    //     // Using Java Optional, as "findById" of Spring JPA returns an Optional object
    //     // Optional forces developers to explicitly handle the case of non-existent values
    //     // Here is an implementation using lambda expression to extract the value from Optional<Book>
    //     return books.findById(id).map(book -> {
    //         return book;
    //     }).orElse(null);
    //     // Optional <Book> o = books.findById(id);
    //     //if(o.isPresent())
    //     //return o.get();
    //     //else 
    //     //return null;
    // }
    
    @Override
    public Content addContent(Content content) {
        return cms.save(content);
    }
    
    @Override
    public Content updateContent(Long id, Content newContentInfo){
        // return cms.findById(id).map(book -> {book.setTitle(newContentInfo.getTitle());
        //     return cms.save(Content);
        // }).orElse(null);

        Optional<Content> c = cms.findById(id);
        if (c.isPresent()){
            Content content = c.get();
            c.setTitle(newContentInfo.getTitle());
            return cms.save(content);
        }else
            return null; 
    }

    /**
     * Remove a book with the given id
     * Spring Data JPA does not return a value for delete operation
     * Cascading: removing a book will also remove all its associated reviews
     */
    @Override
    public void deleteContent(Long id){
        cms.deleteById(id);
    }
}