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
public class DogInfoRepository 
{
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	public ArrayList<DogInfo> getListOfDogs()
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM DOGINFO";
		ArrayList<DogInfo> listOfDogs = new ArrayList<DogInfo>();
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		
		for(Map<String, Object> row: rows)
		{
			DogInfo i = new DogInfo();
			i.setEntryNumber((int)row.get("entryNumber"));
			i.setName((String)row.get("name"));
			i.setOwnerName((String)row.get("ownerName"));
			i.setBreed((String)row.get("breed"));
			i.setGender((String)row.get("gender"));
			i.setClassSpecialty((String)row.get("classSpecialty"));
			
			listOfDogs.add(i);
		}
		return listOfDogs;
	}

	public void addDog(DogInfo dogInfo) 
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO dogInfo (name, ownerName, breed, gender, classSpecialty)"
				+ "VALUES (:name, :ownerName, :breed, :gender, :classSpecialty)";

		parameters.addValue("name", dogInfo.getName());
		parameters.addValue("ownerName", dogInfo.getOwnerName());
		parameters.addValue("breed", dogInfo.getBreed());
		parameters.addValue("gender", dogInfo.getGender());
		parameters.addValue("classSpecialty", dogInfo.getClassSpecialty());
		
		jdbc.update(query, parameters);
	}

	public DogInfo getDogById(int id) 
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM dogInfo WHERE entryNumber=:entryNumber";
		ArrayList<DogInfo> dogInfos = new ArrayList<DogInfo>();
		parameters.addValue("entryNumber", id);
		List<Map<String, Object>>rows = jdbc.queryForList(query, parameters);
		
		for(Map<String, Object> row: rows)
		{
			DogInfo i = new DogInfo();
			i.setEntryNumber((int)row.get("entryNumber"));
			i.setName((String)row.get("name"));
			i.setOwnerName((String)row.get("ownerName"));
			i.setBreed((String)row.get("breed"));
			i.setGender((String)row.get("gender"));
			i.setClassSpecialty((String)row.get("classSpecialty"));
			
			dogInfos.add(i);
		}
		if(dogInfos.isEmpty())
		{
			return null;	
		}
		else
		{
			return dogInfos.get(0);
		}
	}
	
	public void updateDogInfo(DogInfo dogInfo)
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "UPDATE dogInfo SET name=:name, "
				+ "ownerName=:ownerName, breed=:breed, "
				+ "gender=:gender, classSpecialty=:classSpecialty WHERE entryNumber=:entryNumber";
		
		parameters.addValue("entryNumber", dogInfo.getEntryNumber());
		parameters.addValue("name", dogInfo.getName());
		parameters.addValue("ownerName", dogInfo.getOwnerName());
		parameters.addValue("breed", dogInfo.getBreed());
		parameters.addValue("gender", dogInfo.getGender());
		parameters.addValue("classSpecialty", dogInfo.getClassSpecialty());
		
		jdbc.update(query, parameters);
	}
	
	public void deleteDogInfo(int id)
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "DELETE FROM dogInfo WHERE entryNumber=:entryNumber";
		parameters.addValue("entryNumber", id);
		
		jdbc.update(query, parameters);
	}
	
}
