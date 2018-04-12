package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.coursework.university.model.CandidatesDissertation;
import per.coursework.university.service.candidatesDissertation.CandidatesDissertationServiceImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CandidatesDissertationController {
    @Autowired
    private CandidatesDissertationServiceImpl candidatesDissertationService;

    @RequestMapping("/candidates dissertations")
    List<CandidatesDissertation> showCandidatesDissertations() throws SQLException {
        return candidatesDissertationService.getAll();
    }
}
