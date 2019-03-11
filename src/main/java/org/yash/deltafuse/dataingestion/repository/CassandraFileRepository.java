package org.yash.deltafuse.dataingestion.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.yash.deltafuse.dataingestion.model.FileData;

@Repository
public interface CassandraFileRepository extends CassandraRepository<FileData, UUID> {

	/*
	 * List<Person> findByKeyFirstName(final String firstName);
	 * 
	 * List<Person> findByKeyFirstNameAndKeyDateOfBirthGreaterThan( final String
	 * firstName, final LocalDateTime dateOfBirth);
	 * 
	 * @Query(allowFiltering = true) List<Person> findByLastName(final String
	 * lastName);
	 */
}
