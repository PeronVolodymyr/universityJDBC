package per.coursework.university.service.doctoralDissertation.interfaces;

import per.coursework.university.model.DoctoralDissertation;

import java.sql.SQLException;
import java.util.List;

public interface IDoctoralDissertationService {

    public DoctoralDissertation insertDoctoralDissertation(DoctoralDissertation doctoralDissertation);
    public DoctoralDissertation getDoctoralDissertation(int id);
    public DoctoralDissertation updateDoctoralDissertation(DoctoralDissertation doctoralDissertation);
    public DoctoralDissertation deleteDoctoralDissertation(int id);
    public List<DoctoralDissertation> getAll() throws SQLException;
}
