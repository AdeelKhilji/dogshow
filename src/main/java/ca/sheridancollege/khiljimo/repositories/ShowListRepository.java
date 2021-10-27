package ca.sheridancollege.khiljimo.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.khiljimo.beans.DogInfo;

@Repository
public class ShowListRepository 
{
	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	public ArrayList<DogInfo> getDogsByBreed(String breed)
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM dogInfo WHERE breed=:breed";
		ArrayList<DogInfo> dogInfos = new ArrayList<DogInfo>();
		parameters.addValue("breed", breed);
		List<Map<String, Object>>rows = jdbc.queryForList(query, parameters);
		
		for(Map<String, Object> row: rows)
		{
			DogInfo i = new DogInfo();
			
			i.setBreed((String)row.get("breed"));
			
			dogInfos.add(i);
		}
		return dogInfos;
	}
	public ArrayList<DogInfo> getDogsByCM(String breed)
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM dogInfo WHERE breed=:breed AND classSpecialty=:classSpecialty AND gender=:gender";
		ArrayList<DogInfo> dogInfos = new ArrayList<DogInfo>();
		parameters.addValue("breed", breed);
		parameters.addValue("gender", "Male");
		parameters.addValue("classSpecialty", "class");
		List<Map<String, Object>>rows = jdbc.queryForList(query, parameters);
		
		for(Map<String, Object> row: rows)
		{
			DogInfo i = new DogInfo();
			i.setClassSpecialty((String)row.get("classSpecialty"));
			
			
			dogInfos.add(i);
		}
		return dogInfos;
	}
	public ArrayList<DogInfo> getDogsByCF(String breed)
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM dogInfo WHERE breed=:breed AND classSpecialty=:classSpecialty AND gender=:gender";
		ArrayList<DogInfo> dogInfos = new ArrayList<DogInfo>();
		parameters.addValue("breed", breed);
		parameters.addValue("gender", "Female");
		parameters.addValue("classSpecialty", "class");
		List<Map<String, Object>>rows = jdbc.queryForList(query, parameters);
		
		for(Map<String, Object> row: rows)
		{
			DogInfo i = new DogInfo();
			i.setClassSpecialty((String)row.get("classSpecialty"));
			
			
			dogInfos.add(i);
		}
		return dogInfos;
	}
	
	public ArrayList<DogInfo> getDogsBySM(String breed)
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM dogInfo WHERE breed=:breed AND classSpecialty=:classSpecialty AND gender=:gender";
		ArrayList<DogInfo> dogInfos = new ArrayList<DogInfo>();
		parameters.addValue("breed", breed);
		parameters.addValue("gender", "Male");
		parameters.addValue("classSpecialty", "specialty");
		List<Map<String, Object>>rows = jdbc.queryForList(query, parameters);
		
		for(Map<String, Object> row: rows)
		{
			DogInfo i = new DogInfo();
			i.setClassSpecialty((String)row.get("classSpecialty"));
			
			
			dogInfos.add(i);
		}
		return dogInfos;
	}
	public ArrayList<DogInfo> getDogsBySF(String breed)
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM dogInfo WHERE breed=:breed AND classSpecialty=:classSpecialty AND gender=:gender";
		ArrayList<DogInfo> dogInfos = new ArrayList<DogInfo>();
		parameters.addValue("breed", breed);
		parameters.addValue("gender", "Female");
		parameters.addValue("classSpecialty", "specialty");
		List<Map<String, Object>>rows = jdbc.queryForList(query, parameters);
		
		for(Map<String, Object> row: rows)
		{
			DogInfo i = new DogInfo();
			i.setClassSpecialty((String)row.get("classSpecialty"));
			
			
			dogInfos.add(i);
		}
		return dogInfos;
	}

}
