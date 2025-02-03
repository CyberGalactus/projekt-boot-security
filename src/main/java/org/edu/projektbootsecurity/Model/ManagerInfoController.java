package org.edu.projektbootsecurity.Model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManagerInfoController {
    public List<ManagerInfo> getManagerInfoList() {
        List<ManagerInfo> infoList = new ArrayList<>();
        infoList.add(new ManagerInfo("Project Overview", "Details about ongoing projects."));
        infoList.add(new ManagerInfo("Budget Allocation", "Information about budget allocation."));
        infoList.add(new ManagerInfo("Team Performance", "Details about team performance metrics."));
        return infoList;
    }
}
