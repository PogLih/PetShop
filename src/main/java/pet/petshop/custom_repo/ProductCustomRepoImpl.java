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
    public List<Product> filter(String price, String category, String brand) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);
        Root<Product> productRoot = query.from(Product.class);

        if(!price.isEmpty()){
            Predicate predicate = null;
            if(price.startsWith("<")){
                predicate = cb.lessThan(productRoot.get("price"), Integer.parseInt(price.substring(1)));
            } else if(price.startsWith(">")){
               predicate = cb.greaterThan(productRoot.get("price"), Integer.parseInt(price.substring(1)));
            } else if(price.contains("-")){
                String[] arrPrice = price.split("-");
                predicate = cb.between(productRoot.get("price"), Integer.parseInt(arrPrice[0]), Integer.parseInt(arrPrice[1]));
            }
            query.where(predicate);
        }

        if(!category.isEmpty()){
            Predicate predicate = cb.equal(productRoot.get("cate"), Integer.parseInt(category));
            query.where(predicate);
        }

        if(!brand.isEmpty()){
            Predicate predicate = cb.like(productRoot.get("brand"), brand);
            query.where(predicate);
        }

        TypedQuery<Product> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
