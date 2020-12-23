package pet.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pet.petshop.entity.Product;

import pet.petshop.repository.ProductRespository;
import pet.petshop.repository.ProductRespository2;


@Service
public class ProductService {
    @Autowired
    private ProductRespository pr;
    @Autowired
    private ProductRespository2 pr1;
    public List<Product> listAll() {
        return pr.findAll();
    }
    public Page<Product> listAllPage(int pageNumber) {
    	Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, 12,sort);
    	return pr1.findAll(pageable);
    }
    
    public Page<Product> listAllPageAdminProduct(int pageNumber, String sortField, String sortDir) {
    	Sort sort = Sort.by(sortField);
    	sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, 6,sort);
    	return pr1.findAll(pageable);
    }
    public List<Product> searchByName(String search) {
        return pr.getProductsByNameContains(search);
    }

    public List<Product> getListProductByFilter(String price, String category, String branch) {
        return pr.filter(price, category, branch);
    }

    public Product save(Product product) {
        pr.save(product);
        return product;
    }

    public List<String> getListBranch() {
        return pr.getListBranch();
    }

    public Product get(Integer id) {
        return pr.findById(id).get();
    }

    public void delete(Integer id) {
        pr.deleteById(id);
    }
}
