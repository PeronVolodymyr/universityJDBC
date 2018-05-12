package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/candidate dissertation/insert")
    CandidatesDissertation insertCandidatesDissertation(@RequestBody CandidatesDissertation candidatesDissertation) throws SQLException {
        return candidatesDissertationService.insertCandidatesDissertation(candidatesDissertation);
    }

    @GetMapping("/candidate dissertation/delete")
    void deleteCandidatesDissertation(@RequestParam("id") int id) throws SQLException {
        candidatesDissertationService.deleteCandidatesDissertation(id);
    }

    @GetMapping("/candidate dissertation/get")
    CandidatesDissertation getCandidatesDissertationById(@RequestParam("id") int id) throws SQLException {
        return candidatesDissertationService.getCandidatesDissertation(id);
    }

    @RequestMapping("/candidate dissertation/update")
    CandidatesDissertation updateCandidatesDissertation(@RequestBody CandidatesDissertation candidatesDissertation, @RequestParam("id") int id) throws SQLException {
        candidatesDissertation.setId(id);
        return candidatesDissertationService.updateCandidatesDissertation(candidatesDissertation);
    }

}
