package com.oreilly.demo.dao;

import com.oreilly.demo.entities.Officer;
import com.oreilly.demo.entities.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Donald F. Coffin, REMI Networks
 **/
public interface OfficerRepository extends JpaRepository<Officer, Integer> {
	List<Officer> findAllByLastNameContainingAndRank(String last, Rank rank);
}
