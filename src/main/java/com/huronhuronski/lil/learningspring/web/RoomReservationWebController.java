package com.huronhuronski.lil.learningspring.web;

import com.huronhuronski.lil.learningspring.business.domain.RoomReservation;
import com.huronhuronski.lil.learningspring.business.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class RoomReservationWebController {
    private final ReservationService reservationService;

    public RoomReservationWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getReservations(@RequestParam(value="date", required=false)String dateString, Model model) {
        Date date = DateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations", roomReservations);
        return "reservations";
    }

}
