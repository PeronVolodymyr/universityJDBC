package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.coursework.university.model.FormOfControl;
import per.coursework.university.service.formOfControl.FormOfControlServiceImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FormOfControlController {
    @Autowired
    private FormOfControlServiceImpl formOfControlService;

    @RequestMapping("/forms of control")
    List<FormOfControl> showFormsOfControl() throws SQLException {
        return formOfControlService.getAll();
    }
}
