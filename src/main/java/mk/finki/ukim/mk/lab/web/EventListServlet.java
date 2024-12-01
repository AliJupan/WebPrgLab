//package mk.finki.ukim.mk.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import mk.finki.ukim.mk.lab.model.Event;
//import mk.finki.ukim.mk.lab.service.EventService;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "EventListServlet", urlPatterns = { "/*" , "/servlet/event-list"})
//public class EventListServlet extends HttpServlet {
//
//    private final EventService eventService;
//    private final SpringTemplateEngine templateEngine;
//
//    public EventListServlet(EventService eventService, SpringTemplateEngine templateEngine) {
//        this.eventService = eventService;
//        this.templateEngine = templateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        handleEventRequest(request, response, null);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String searchText = req.getParameter("searchText");
//        handleEventRequest(req, resp, searchText);
//    }
//
//    private void handleEventRequest(HttpServletRequest request, HttpServletResponse response, String searchText) throws IOException {
//        List<Event> events;
//
//        if (searchText != null && !searchText.trim().isEmpty()) {
//            events = eventService.searchEvents(searchText);
//        } else {
//            events = eventService.listAll();
//        }
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(request, response);
//        WebContext context = new WebContext(webExchange);
//        context.setVariable("events", events);
//        context.setVariable("searchText", searchText);
//
//        templateEngine.process("listEvents.html", context, response.getWriter());
//    }
//}
