//package com.ahmedSamir.ToDoApp.googleCalender;
//
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.google.api.services.calendar.Calendar;
//import com.google.api.services.calendar.model.Event;
//import com.google.api.services.calendar.model.Events;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.security.GeneralSecurityException;
//import java.util.List;
//
////@Service
//public class GoogleCalendarService {
//
//    private static final String APPLICATION_NAME = "ToDoApp";
//    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
//
//    public Calendar getCalendarService(OAuth2AuthorizedClient authorizedClient) throws GeneralSecurityException, IOException {
//        return new Calendar.Builder(
//                GoogleNetHttpTransport.newTrustedTransport(),
//                JSON_FACTORY,
//                request -> authorizedClient.getAccessToken().getTokenValue())
//                .setApplicationName(APPLICATION_NAME)
//                .build();
//    }
//
//    public List<Event> getUpcomingEvents(OAuth2AuthorizedClient authorizedClient) throws GeneralSecurityException, IOException {
//        Calendar service = getCalendarService(authorizedClient);
//        Events events = service.events().list("primary")
//                .setMaxResults(10)
//                .setTimeMin(new com.google.api.client.util.DateTime(System.currentTimeMillis()))
//                .setOrderBy("startTime")
//                .setSingleEvents(true)
//                .execute();
//        return events.getItems();
//    }
//}
