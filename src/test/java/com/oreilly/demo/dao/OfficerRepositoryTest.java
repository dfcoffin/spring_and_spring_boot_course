package com.oreilly.demo.dao;

import com.oreilly.demo.entities.Officer;
import com.oreilly.demo.entities.Rank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Donald F. Coffin, REMI Networks
 **/

@SpringBootTest
@Transactional
class OfficerRepositoryTest {
	@Autowired
	private OfficerRepository dao;

	@Autowired
	private JdbcTemplate template;

	// Retrieves the current list of IDs from the officers table
	private List<Integer> ids() {
		return template.query("SELECT id FROM officers",
				(rs, num) -> rs.getInt("id"));
	}

	@Test
	void save() {
		Officer officer = new Officer(null, Rank.ENSIGN,
				"Wesley", "Crusher");
		officer = dao.save(officer);
		assertNotNull(officer.getId());
	}

	@Test
	void findByIdThatExists() {
		ids().forEach(id -> {
			Optional<Officer> officer = dao.findById(id);
			assertTrue(officer.isPresent());
			assertEquals(id, officer.get().getId());
		});
	}

	@Test
	void findByIdThatDoesNotExist() {
		assertThat(ids()).doesNotContain(999);
		Optional<Officer> officer = dao.findById(999);
		assertFalse(officer.isPresent());
	}

	@Test
	void count() {
		assertEquals(ids().size(), dao.count());
	}

	@Test
	void findAll() {
		List<String> dbNames = dao.findAll().stream()
				.map(Officer::getLastName)
				.toList();
		assertThat(dbNames).containsAll(List.of(
				"Archer", "Burnham", "Freeman", "Janeway",
				"Kirk", "Picard", "Pike", "Sisko"));
	}

	@Test
	void delete() {
		ids().forEach(id -> {
			Optional<Officer> officer = dao.findById(id);
			assertTrue(officer.isPresent());
			dao.delete(officer.get());
		});
		assertEquals(0, dao.count());
	}

	@Test
	void existsById() {
		ids().forEach(id -> assertTrue(dao.existsById(id)));
	}

	@Test
	void findAllByLastNameContainingAndRank() {
		List<Officer> officers = dao.findAllByLastNameContainingAndRank("i", Rank.CAPTAIN);
		assertThat(officers).hasSize(4);
		assertThat(officers.stream().map(Officer::getLastName))
				.containsExactlyInAnyOrder("Kirk", "Picard", "Pike", "Sisko");
	}
}