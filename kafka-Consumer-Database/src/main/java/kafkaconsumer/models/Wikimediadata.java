package kafkaconsumer.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table("wikimedia_data")  // Table name should match the database table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Wikimediadata {

    @Id  // Marks this field as the primary key
    private Long id;

    // No @Lob in Spring Data JDBC; just use a String for large text data
    private String wikimediaEventData;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the wikimediaEventData
	 */
	public String getWikimediaEventData() {
		return wikimediaEventData;
	}

	/**
	 * @param wikimediaEventData the wikimediaEventData to set
	 */
	public void setWikimediaEventData(String wikimediaEventData) {
		this.wikimediaEventData = wikimediaEventData;
	}
}
