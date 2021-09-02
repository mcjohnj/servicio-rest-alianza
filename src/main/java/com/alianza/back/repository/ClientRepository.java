package com.alianza.back.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alianza.back.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String>{

	public abstract ArrayList<Client> findBySharedKey(String sharedKey);
}
