package org.example.springmvc.controller;

import jakarta.validation.Valid;
import lombok.Value;
import org.example.springmvc.domain.ContactFormDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactFormController {

    @GetMapping("/contact")
    public String contact(Model model) {

        model.addAttribute("contactForm",new ContactFormDTO());
        return "contact/form";
    }

    @PostMapping("/contact")
    public String contact2(@ModelAttribute ContactFormDTO contactFormDTO,
                           RedirectAttributes redirectAttrs) {


        redirectAttrs.addFlashAttribute("name",contactFormDTO.getName());
        redirectAttrs.addFlashAttribute("email",contactFormDTO.getEmail());
        redirectAttrs.addFlashAttribute("message",contactFormDTO.getMessage());
        redirectAttrs.addFlashAttribute("successMessage",
                "문의가 성공적으로 접수되었습니다.");

        return "redirect:/contact/success";
    }

    @GetMapping("/contact/success")
    public String success() {
        return "contact/success";
    }
}
