package com.codegym.springformhealthdeclaration.controller;

import com.codegym.springformhealthdeclaration.model.Health;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/health")
public class HealthController {

    @GetMapping("/show-form")
    public String showForm(Model model) {
        model.addAttribute("health", new Health());
        return "health/create";
    }

    @PostMapping("/add-health")
    public String submit(@ModelAttribute("health") Health health, Model model) {
        model.addAttribute("fullName", health.getFullName());
        model.addAttribute("yearOfBirth", health.getYearOfBirth());
        model.addAttribute("gender", health.getGender());
        model.addAttribute("nationality", health.getNationality());
        model.addAttribute("idNumber", health.getIdNumber());
        model.addAttribute("travelInfo", health.getTravelInfo());
        model.addAttribute("vehicleNumber", health.getVehicleNumber());
        model.addAttribute("seatNumber", health.getSeatNumber());
        model.addAttribute("departureDate", health.getDepartureDate());
        model.addAttribute("endDate", health.getEndDate());
        model.addAttribute("visitedPlaces", health.getVisitedPlaces());
        model.addAttribute("address", health.getAddress());
        model.addAttribute("city", health.getCity());
        model.addAttribute("phone", health.getPhone());
        model.addAttribute("email", health.getEmail());
        model.addAttribute("sot", health.isSot());
        model.addAttribute("kho_tho", health.isKho_tho());
        model.addAttribute("dau_hong", health.isDau_hong());
        model.addAttribute("non_buon_non", health.isNon_buon_non());
        model.addAttribute("tieu_chay", health.isTieu_chay());
        model.addAttribute("xuat_huyet_ngoai_da", health.isXuat_huyet_ngoai_da());
        model.addAttribute("noi_ban_ngoai_da",  health.isNoi_ban_ngoai_da());
        model.addAttribute("phoi_nhiem_1",  health.isPhoi_nhiem_1());
        model.addAttribute("phoi_nhiem_2",  health.isPhoi_nhiem_2());
        return "health/info";
    }
}
