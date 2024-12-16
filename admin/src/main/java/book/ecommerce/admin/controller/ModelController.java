package book.ecommerce.admin.controller;


import book.ecommerce.library.model.Make;
import book.ecommerce.library.model.Model;
import book.ecommerce.library.service.MakeService;
import book.ecommerce.library.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/model")
public class ModelController {

    @Autowired
    private MakeService makeService;

    @Autowired
    private ModelService modelService;


    private String add_edit_template="/model/add-edit-model";
    private String list_template="/model/list-model";
    private String list_redirect="redirect:/model/list";

    @GetMapping("/add")
    public String addModel(Model model2, org.springframework.ui.Model model){
        model.addAttribute("model", model2);

        List<Make> listMake = makeService.findAll();
        model.addAttribute("listMake", listMake);

        return add_edit_template;
    }

    @GetMapping("/edit/{id}")
    public String editModel(@PathVariable("id") int id, org.springframework.ui.Model model){
        Model model2 = modelService.get(id);
        model.addAttribute("model", model2);

        List<Make> listMake = makeService.findAll();
        model.addAttribute("listMake", listMake);

        return add_edit_template;
    }

    @PostMapping("/save")
    public String saveModel(@Valid @ModelAttribute("model") Model model2, BindingResult result, org.springframework.ui.Model model){
        model.addAttribute("model", model2);

        List<Make> listMake = makeService.findAll();
        model.addAttribute("listMake", listMake);

        if(result.hasErrors()){
            return add_edit_template;
        }
        modelService.save(model2);

        return list_redirect+"?success";
    }

    /*@GetMapping("/delete/{id}")
    public String deleteModel(@PathVariable("id") int id, org.springframework.ui.Model model) {
        modelService.delete(id);

        return list_redirect+"?deleted";
    }
*/
    @GetMapping("/list")
    public String listModel(org.springframework.ui.Model model) {
        List<Model> listModel = modelService.findAll();
        model.addAttribute("listModel", listModel);

        List<Make> listMake = makeService.findAll();
        model.addAttribute("listMake", listMake);

        return list_template;
    }
}