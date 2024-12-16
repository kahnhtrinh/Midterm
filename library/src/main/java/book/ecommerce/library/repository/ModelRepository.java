package book.ecommerce.library.repository;


import book.ecommerce.library.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {
    Model findByName(String name);


    @Query("select m from Model m where 1=1 and is_deleted=0 and name=?1 and make_id=?2")
    public Model findByName2(String name, Long makeId);

    @Query("select m from Model m where 1=1 and is_deleted=0 and (make_id=?1)")
    public List<Model> getModels(Long makeId);

}