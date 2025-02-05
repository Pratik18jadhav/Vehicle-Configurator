package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class I18nController {

    @Autowired
    private MessageSource messageSource;
   
    // REST endpoint for greeting
    @GetMapping("/aboutus")
    public String getAboutus(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        // If no Accept-Language header is provided, default to English
        if (locale == null) {
            locale = Locale.ENGLISH;
        }

        // Retrieve the message based on the locale
        return messageSource.getMessage("aboutus", null, locale);
    }
    
    @GetMapping("/who")
    public String getWho(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        // If no Accept-Language header is provided, default to English
        if (locale == null) {
            locale = Locale.ENGLISH;
        }

        // Retrieve the message based on the locale
        return messageSource.getMessage("Who", null, locale);
    }
    
    @GetMapping("/whocontent")
    public String getWhocontent(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        // If no Accept-Language header is provided, default to English
        if (locale == null) {
            locale = Locale.ENGLISH;
        }

        // Retrieve the message based on the locale
        return messageSource.getMessage("WhoContent", null, locale);
    }
    
    @GetMapping("/technology")
    public String getTechnology(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        // If no Accept-Language header is provided, default to English
        if (locale == null) {
            locale = Locale.ENGLISH;
        }

        // Retrieve the message based on the locale
        return messageSource.getMessage("Technology", null, locale);
    }
    
    @GetMapping("/technologycontent")
    public String getTechnologyContent(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        // If no Accept-Language header is provided, default to English
        if (locale == null) {
            locale = Locale.ENGLISH;
        }

        // Retrieve the message based on the locale
        return messageSource.getMessage("TechnologyContent", null, locale);
    }
}