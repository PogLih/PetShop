package pet.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pet.petshop.entity.Blog;
import pet.petshop.entity.Services;
import pet.petshop.repository.blogRespository;
import pet.petshop.repository.blogRespository2;

@Service
public class BlogService {
	@Autowired
	private blogRespository bpo;
	
	@Autowired
	private blogRespository2 bpo2;
	public Page<Blog> listAllPageBlog(int pageNumber) {
    	Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, 6,sort);
    	return bpo2.findAll(pageable);
    }
  
  public Page<Blog> listAllPageAdminBlog(int pageNumber, String sortField, String sortDir) {
    	Sort sort = Sort.by(sortField);
    	sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, 6,sort);
    	return bpo2.findAll(pageable);
    }
	public List<Blog> listALL(){
		return bpo.findAll();
	}
	
	public Blog save(Blog blog) {
		return bpo.save(blog);
	}
	
	public Blog get(Integer id) {
		return bpo.findById(id).get();
	}
	
	public void delete(Integer id) {
		bpo.deleteById(id);
	}
}
