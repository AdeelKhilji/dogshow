package ca.sheridancollege.khiljimo.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.khiljimo.beans.DogBreed;

@Repository
public class DogBreedRepository 
{
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	public void addDogBreed(DogBreed dogBreed)
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO dogBreed (name) VALUES (:name)";
		
		parameters.addValue("name", dogBreed.getName());
		
		jdbc.update(query,parameters);
	}
	
	public ArrayList<DogBreed> getDogBreeds()
	{
		String query = "SELECT * FROM dogBreed";
		ArrayList<DogBreed> breeds = new ArrayList<DogBreed>();
		List<Map<String, Object>> rows = jdbc.queryForList(query, new HashMap<String,Object>());
		
		for(Map<String, Object> row: rows)
		{
			DogBreed d = new DogBreed();
			d.setId((int)row.get("id"));
			d.setName((String)row.get("name"));
			
			breeds.add(d);
		}
		return breeds;
	}

	public void deleteDogBreed(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "DELETE FROM DogBreed WHERE id=:id";
		parameters.addValue("id", id);
		
		jdbc.update(query, parameters);
	}
}
