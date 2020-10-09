package com.ryverbank.cms;

import java.util.List;

public interface CMSService {
    List<Content> listContent();
    Content getContent(Long id);
    Content addContent(Content content);
    Content updateContent(Long id, Content content);

    /**
     * Change method's signature: do not return a value for delete operation
     * @param id
     */
    void deleteContent(Long id);
}