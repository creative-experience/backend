package br.com.finalproject.financeandstock.framework.adapter.out;

import br.com.finalproject.financeandstock.domain.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<UserModel, Long> {
    List<UserModel> findByEmail(String email);
}
