package org.edu.projektbootsecurity.Controller;

import org.edu.projektbootsecurity.Model.AdminDocument;
import org.edu.projektbootsecurity.Model.AdminDocumentController;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    private final AdminDocumentController adminDocumentController;

    public AdminController(AdminDocumentController adminDocumentController) {
        this.adminDocumentController = adminDocumentController;
    }


    @GetMapping("/admin")
    public String adminPage(Model model) {
        List<AdminDocument> documents = adminDocumentController.getAdminDocuments();
        model.addAttribute("documents", documents);
        return "admin";
    }
}
