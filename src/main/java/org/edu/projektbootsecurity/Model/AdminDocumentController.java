package org.edu.projektbootsecurity.Model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminDocumentController {
    public List<AdminDocument> getAdminDocuments() {
        List<AdminDocument> documents = new ArrayList<>();
        documents.add(new AdminDocument("Admin Report", "Details about the admin report."));
        documents.add(new AdminDocument("System Logs", "Details about the system logs."));
        documents.add(new AdminDocument("Audit Trail", "Details about the audit trail."));
        return documents;
    }
}
