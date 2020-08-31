package com.wechall.admin.global.util;

import javax.servlet.ServletContext;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ImageStoreServiceTest {

    @Mock
    ServletContext context;

    ImageStoreService imageStoreService = new ImageStoreService(context);

    @Test
    public void copyFile(){
        try{
            imageStoreService.copyFile("/Users/songtaeheon/Documents/2020-1/weChall/admin_wechall_challenge/src/main/webapp/resources/temp/8344f765-afa0-4b84-a848-8948a98e34f4_스크린샷 2020-05-16 오후 12.33.17.png", "/resources/image/post");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}