package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/session/insert")
    Session insertSession(@RequestBody Session session) throws SQLException {
        return sessionService.insertSession(session);
    }

    @GetMapping("/session/delete")
    void deleteSession(@RequestParam("id") int id) throws SQLException {
        sessionService.deleteSession(id);
    }

    @GetMapping("/session/get")
    Session getSessionById(@RequestParam("id") int id) throws SQLException {
        return sessionService.getSession(id);
    }

    @RequestMapping("/session/update")
    Session updateSession(@RequestBody Session session, @RequestParam("id") int id) throws SQLException {
        session.setId(id);
        return sessionService.updateSession(session);
    }
}
