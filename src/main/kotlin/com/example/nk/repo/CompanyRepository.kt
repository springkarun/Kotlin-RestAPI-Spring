package com.example.nk.repo

import com.example.nk.model.Company
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CompanyRepository : JpaRepository<Company, Long>{


}