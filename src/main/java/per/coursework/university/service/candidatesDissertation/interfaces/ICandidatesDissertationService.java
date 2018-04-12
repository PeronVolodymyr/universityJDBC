package per.coursework.university.service.candidatesDissertation.interfaces;

import per.coursework.university.model.CandidatesDissertation;

import java.sql.SQLException;
import java.util.List;

public interface ICandidatesDissertationService {

    public CandidatesDissertation insertCandidatesDissertation(CandidatesDissertation candidatesDissertation);
    public CandidatesDissertation getCandidatesDissertation(int id);
    public CandidatesDissertation updateCandidatesDissertation(CandidatesDissertation candidatesDissertation);
    public CandidatesDissertation deleteCandidatesDissertation(int id);
    public List<CandidatesDissertation> getAll() throws SQLException;
}
