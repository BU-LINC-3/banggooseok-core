package kr.banggooseok.core.controller;

import kr.banggooseok.core.model.view.TestModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class TestController {

    @RequestMapping()
    public ModelAndView index() {
        TestModel model = new TestModel();

        model.setTitle("TestTitle");
        model.setBody("TestBody");

        return new ModelAndView("index", "model", model);
    }

}
