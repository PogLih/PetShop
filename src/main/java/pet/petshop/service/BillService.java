package pet.petshop.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.petshop.dto.BillDTO;

import pet.petshop.dto.BillStatusDTO;
import pet.petshop.entity.Bill;
import pet.petshop.entity.User;
import pet.petshop.repository.BillRepository;
import pet.petshop.repository.BillRepository2;

@Service
@Transactional
public class BillService {

    @Autowired
    private BillRepository br;

    @Autowired
    private BillRepository2 br2;

    public List<Bill> listAll() {
        return br.findAll();
    }

    public Page<Bill> listAllPageAdminBill(int pageNumber, String sortField, String sortDir) {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, 6, sort);
        return br2.findAll(pageable);
    }


    public void save(Bill bill) {
        br.save(bill);
    }

    public Bill get(int id) {
        return br.findById(id).get();
    }

    public void delete(int id) {
        br.deleteById(id);
    }

    public List<Bill> BillByUser(User user) {
        return br.findByUser(user);
    }


    public List<BillDTO> listBillDTO() {
        List<BillDTO> list = new ArrayList<BillDTO>();
        for (Bill bd : br.followmoth()) {
            BillDTO BillDTO = new BillDTO();
            BillDTO.setId(bd.getId());
            BillDTO.setUserid(bd.getUserid());
            BillDTO.setDate(Integer.parseInt(new SimpleDateFormat("MM").format(bd.getDate())));
            BillDTO.setStatus(bd.getStatus());
            BillDTO.setTotalprice(bd.getTotalprice());
            list.add(BillDTO);
        }
        return list;
    }
    
    public List<BillStatusDTO> countstatus() {
        List<BillStatusDTO> list = new ArrayList<BillStatusDTO>();
        for (Bill bd : br.countstatus()) {
            BillStatusDTO BillStatusDTO = new BillStatusDTO();
            BillStatusDTO.setId(bd.getId());
            BillStatusDTO.setUserid(bd.getUserid());
            BillStatusDTO.setDate(bd.getDate());
            BillStatusDTO.setStatus(bd.getStatus());
            BillStatusDTO.setTotalprice(bd.getTotalprice());
            list.add(BillStatusDTO);
        }
        return list;
    }
}
