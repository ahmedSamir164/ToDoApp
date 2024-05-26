//package com.ahmedSamir.ToDoApp.googleCalender;
//import com.google.api.services.calendar.model.Event;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
//import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
//import org.springframework.security.oauth2.core.OAuth2AccessToken;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.io.IOException;
//import java.security.GeneralSecurityException;
//import java.util.List;
//
////@Controller
//@RequestMapping("/calendar")
//public class CalendarController {
//
//    @Autowired
//    private GoogleCalendarService calendarService;
//
//    @GetMapping
//    @ResponseBody
//    public List<Event> getEvents(@RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient authorizedClient) throws GeneralSecurityException, IOException {
//        OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
//        System.out.println(accessToken);
//        return calendarService.getUpcomingEvents(authorizedClient);
//    }
//}

