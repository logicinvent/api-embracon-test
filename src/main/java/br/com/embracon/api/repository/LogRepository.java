package br.com.embracon.api.repository;

import br.com.embracon.api.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    List<Log> findTop20ByUf(String uf);
}
