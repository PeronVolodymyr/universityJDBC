package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/form of control/insert")
    FormOfControl insertOneFormOfControl(@RequestBody FormOfControl formOfControl) throws SQLException {
        return formOfControlService.insertFormOfControl(formOfControl);
    }

    @GetMapping("/form of control/delete")
    void deleteFormOfControl(@RequestParam("id") int id) throws SQLException {
        formOfControlService.deleteFormOfControl(id);
    }

    @RequestMapping("/form of control/update")
    FormOfControl updateFormOfControl(@RequestBody FormOfControl formOfControl, @RequestParam("id") int id) throws SQLException {
        formOfControl.setId(id);
        return formOfControlService.updateFormOfControl(formOfControl);
    }

    @GetMapping("/form of control/get")
    FormOfControl getFormOfControlById(@RequestParam("id") int id) throws SQLException {
        return formOfControlService.getFormOfControl(id);
    }
}
