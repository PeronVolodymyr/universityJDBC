package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.coursework.university.model.Session;
import per.coursework.university.service.session.SessionServiceImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SessionController {
    @Autowired
    private SessionServiceImpl sessionService;

    @RequestMapping("/session")
    public List<Session> showSession() throws SQLException {
        return sessionService.getAll();
    }
}
