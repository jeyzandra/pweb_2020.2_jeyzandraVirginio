package br.com.jeyzandra.agropopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jeyzandra.agropopshop.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>  {

}
