package com.ryverbank.cms;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;  

@RestController
public class CMSController {

    @Autowired
    private CMSRepository cmsRepository;

    public CMSController() {}
}