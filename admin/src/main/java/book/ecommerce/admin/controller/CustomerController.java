package book.ecommerce.admin.controller;

import book.ecommerce.library.model.*;
import book.ecommerce.library.service.CountryService;
import book.ecommerce.library.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CountryService countryService;
    @GetMapping("/list")
    public String listUser(Model model){
        List<Customer> customerList = customerService.findAll();

        model.addAttribute("customerList", customerList);
        return "customer/list-customer";
    }

    @GetMapping("/edit/{id}")
    public String editCustomer(Model model, @PathVariable Long id){
        Customer customer = customerService.findById(id);
        List<Country> countries = countryService.findAll();
        model.addAttribute("customer", customer);
        model.addAttribute("countries", countries);
        return "customer/add-edit-customer";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model){
        model.addAttribute("customer", customer);
        List<Country> countries = countryService.findAll();
        model.addAttribute("customer", customer);
        model.addAttribute("countries", countries);

        if(result.hasErrors()){
            return "customer/add-edit-customer";
        }
        customerService.save(customer);
        return "redirect:/customer/list?success";
    }
}
