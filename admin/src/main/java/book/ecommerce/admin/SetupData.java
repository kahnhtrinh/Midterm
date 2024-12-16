package book.ecommerce.admin;


import book.ecommerce.library.model.*;
import book.ecommerce.library.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class SetupData implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = false;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private MakeRepository makeRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (alreadySetup)
            return;

        //Setup roles
        createRoleIfNotFound("ADMIN");
        createRoleIfNotFound("CUSTOMER");

        //Setup categories
        createCategoryIfNotFound(new Category("Văn Học", ""));
        createCategoryIfNotFound(new Category("Kinh Tế", ""));
        createCategoryIfNotFound(new Category("Thiếu Nhi", ""));
        createCategoryIfNotFound(new Category("Giáo Khoa", ""));
        createCategoryIfNotFound(new Category("Ngoại Ngữ", ""));
        createCategoryIfNotFound(new Category("Tâm Lý - Kỹ Năng Sống", ""));
        createCategoryIfNotFound(new Category("Nuôi Dạy Con", ""));
        createCategoryIfNotFound(new Category("Tiểu Sử - Hồi Ký", ""));

        //Setup Countries
        createCountryIfNotFound(new Country("VN", "Việt Nam"));
        createCountryIfNotFound(new Country("US", "United States"));
        createCountryIfNotFound(new Country("GB", "United Kingdom"));
        createCountryIfNotFound(new Country("FR", "France"));
        createCountryIfNotFound(new Country("CN", "China"));
        createCountryIfNotFound(new Country("AU", "Australia"));

        //Setup Make
        Make make1 = createMakeIfNotFound(new Make("William Shakespeare"));

        Make make2 = createMakeIfNotFound(new Make("Nguyễn Du"));

        Make make3 = createMakeIfNotFound(new Make("Nam Cao"));

        Make make4 = createMakeIfNotFound(new Make("Nguyễn Nhật Ánh"));

        Make make5 = createMakeIfNotFound(new Make("Arthur Conan Doyle"));

        Make make6 = createMakeIfNotFound(new Make("Dr. Seuss"));

        Make make7 = createMakeIfNotFound(new Make("Roald Dahl"));

        //Setup model
        createModelIfNotFound(new Model("Penguin Classics", make1));
        createModelIfNotFound(new Model("Oxford University Press", make1));
        createModelIfNotFound(new Model("Cambridge University Press", make1));

        createModelIfNotFound(new Model("Nhà xuất bản Giáo dục Việt Nam", make2));
        createModelIfNotFound(new Model("Nhà xuất bản Văn học", make3));
        createModelIfNotFound(new Model("Nhà xuất bản Trẻ", make4));
        createModelIfNotFound(new Model("Penguin Classics", make5));
        createModelIfNotFound(new Model("Oxford University Press", make5));
        createModelIfNotFound(new Model("Random House", make6));
        createModelIfNotFound(new Model("Puffin Books", make7));
        createModelIfNotFound(new Model("Alfred A. Knopf", make7));

    }

    @Transactional
    Role createRoleIfNotFound(String name) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            roleRepository.save(role);

            //return saved object
            role = roleRepository.findByName(name);
        }
        return role;
    }

    @Transactional
    Category createCategoryIfNotFound(Category category) {
        Category category1 = categoryRepository.findByName(category.getName());
        if (category1 == null) {
            categoryRepository.save(category);

            //return saved object
            category1 = categoryRepository.findByName(category.getName());
        }
        return category1;
    }

    @Transactional
    Country createCountryIfNotFound(Country country) {
        Country country1 = countryRepository.findByName(country.getName());
        if (country1 == null) {
            countryRepository.save(country);

            //return saved object
            country1 = countryRepository.findByName(country.getName());
        }
        return country1;
    }

    @Transactional
    Make createMakeIfNotFound(Make make) {
        Make make1 = makeRepository.findByName(make.getName());
        if (make1 == null) {
            makeRepository.save(make);
            //return saved object
            make1 = makeRepository.findByName(make.getName());
        }

        return make1;
    }

    @Transactional
    Model createModelIfNotFound(Model model) {
        Model model1 = modelRepository.findByName2(model.getName(), model.getMake().getId());
        if (model1 == null) {
            modelRepository.save(model);

            //return saved object
            model1 = modelRepository.findByName2(model.getName(), model.getMake().getId());
        }
        return model1;
    }
}
