//package mk.finki.ukim.mk.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import mk.finki.ukim.mk.lab.model.EventBooking;
//import mk.finki.ukim.mk.lab.service.EventBookingService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "EventBookingServlet", urlPatterns = {"/eventBooking"})
//public class EventBookingServlet extends HttpServlet {
//
//    private final EventBookingService eventBookingService;
//    private final SpringTemplateEngine templateEngine;
//
//    public EventBookingServlet(EventBookingService eventBookingService, SpringTemplateEngine templateEngine) {
//        this.eventBookingService = eventBookingService;
//        this.templateEngine = templateEngine;
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String eventName = request.getParameter("eventName");
//        String attendeeName = request.getParameter("attendeeName");
//        String attendeeAddress = request.getRemoteAddr();
//        int numTickets = Integer.parseInt(request.getParameter("numTickets"));
//
//        eventBookingService.placeBooking(eventName, attendeeName, attendeeAddress, numTickets);
//
//        List<EventBooking> bookings = eventBookingService.listAll();
//
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(request, response);
//        WebContext context = new WebContext(webExchange);
//        context.setVariable("bookings", bookings);
//
//
//        templateEngine.process("bookingConfirmation.html", context, response.getWriter());
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String search = req.getParameter("searchText");
//
//        List<EventBooking> bookings = eventBookingService.searchEvents(search);
//
//        System.out.println(bookings);
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req , resp);
//        WebContext context = new WebContext(webExchange);
//        context.setVariable("bookings", bookings);
//
//        templateEngine.process("bookingConfirmation.html", context, resp.getWriter());
//    }
//}
