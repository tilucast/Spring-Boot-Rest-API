package br.com.springrestapi.curso_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springrestapi.curso_springboot.model.UserApp;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Long>{
}
