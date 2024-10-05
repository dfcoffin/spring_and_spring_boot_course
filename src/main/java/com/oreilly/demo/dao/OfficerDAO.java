package com.oreilly.demo.dao;

import com.oreilly.demo.entities.Officer;

import java.util.List;
import java.util.Optional;

/**
 * @author Donald F. Coffin, REMI Networks
 **/

public interface OfficerDAO {
	Officer save(Officer officer);

	Optional<Officer> findById(Integer id);

	List<Officer> findAll();

	long count();

	void delete(Officer officer);

	boolean existsById(Integer id);
}
