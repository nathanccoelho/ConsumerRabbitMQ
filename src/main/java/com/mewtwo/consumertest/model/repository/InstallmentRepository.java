package com.mewtwo.consumertest.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mewtwo.consumertest.model.Installment;

public interface InstallmentRepository extends JpaRepository<Installment, Long>{

}
