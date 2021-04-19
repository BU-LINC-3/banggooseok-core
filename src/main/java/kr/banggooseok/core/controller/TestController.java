package kr.banggooseok.core.controller;

import kr.banggooseok.core.model.TestModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class TestController {

    @RequestMapping()
    public ModelAndView test() {
        TestModel model = new TestModel();

        model.setTitle("title");
        model.setBody("body");

        return new ModelAndView("index","model", model);
    }

}
