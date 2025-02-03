package org.edu.projektbootsecurity.Controller;

import org.edu.projektbootsecurity.Model.ManagerInfo;
import org.edu.projektbootsecurity.Model.ManagerInfoController;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ManagerController {

    private final ManagerInfoController managerInfoController;

    public ManagerController(ManagerInfoController managerInfoController) {
        this.managerInfoController = managerInfoController;
    }


    @GetMapping("/manager")
    public String managerPage(Model model) {
        List<ManagerInfo> managerInfoList = managerInfoController.getManagerInfoList();
        model.addAttribute("managerInfo", managerInfoList);
        return "manager";
    }
}

