package pet.petshop.custom_repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pet.petshop.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ProductCustomRepoImpl implements ProductCustomRepo{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Product> filter(String name, Integer category, Boolean status) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);
        Root<Product> productRoot = query.from(Product.class);

        if(!name.isEmpty()){
            Predicate predicate = cb.like(productRoot.get("name"), "%" + name + "%");
            query.where(predicate);

        }

        if(category != -1){
            Predicate predicate = cb.equal(productRoot.get("cate"), category);
            query.where(predicate);
        }

        TypedQuery<Product> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
