package ca.sheridancollege.khiljimo.beans;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class DogInfo 
{
	private int entryNumber;
	private String name;
	private String ownerName;
	private String breed;
	private String gender;
	private String classSpecialty;
}
