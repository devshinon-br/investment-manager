package com.keyla.rezende.repository

import com.keyla.rezende.model.AcoesModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface AcoesRepository extends JpaRepository<AcoesModel, Long> {
}



