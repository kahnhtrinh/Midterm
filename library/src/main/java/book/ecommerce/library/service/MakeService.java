package book.ecommerce.library.service;


import book.ecommerce.library.model.Make;
import book.ecommerce.library.repository.MakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MakeService {

    @Autowired
    private MakeRepository makeRepository;

    public List<Make> findAll() {
        return (List<Make>) makeRepository.findAll();
    }

    public Make findByName(String name) {
        return makeRepository.findByName(name);
    }

    public void save(Make product) {
        makeRepository.save(product);
    }

    public Make get(long  id) {
        return makeRepository.findById(id).get();
    }

    public void delete(long id) {
        makeRepository.deleteById(id);
    }
}