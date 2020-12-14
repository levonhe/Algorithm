package com.example.react.repository;

import com.example.react.entity.Account;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends R2dbcRepository<Account,Integer> {
}
