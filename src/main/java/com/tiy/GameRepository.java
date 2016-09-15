package com.tiy;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Brett on 9/15/16.
 */
public interface GameRepository extends CrudRepository<Game, Integer> {

	List<Game> findByGenre(String genre); //lowercase "f" in find, By, Genre is the column in question
	//Specifically, what column do you want to use

	@Query("SELECT g FROM Game g WHERE g.name LIKE ?1%") // Selecting from the Entity (game), not the Table (games)
	List<Game> findByNameStartsWith(String name);

	List<Game> findByReleaseYear(int year);

	List<Game> findByUser(User user);


}
