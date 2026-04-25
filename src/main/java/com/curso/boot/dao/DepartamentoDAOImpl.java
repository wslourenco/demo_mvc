package com.curso.boot.dao;

import org.springframework.stereotype.Repository;
import com.curso.boot.domain.Departamento;

@Repository
public class DepartamentoDAOImpl extends AbstractDAO<Departamento, Long> implements DepartamentoDAO {

    @Override
    public boolean departamentoTemCargo(Long id) {
        Long quantidade = getEntityManager()
                .createQuery("select count(c) from Cargo c where c.departamento.id = :id", Long.class)
                .setParameter("id", id)
                .getSingleResult();

        return quantidade != null && quantidade > 0;
    }

}
