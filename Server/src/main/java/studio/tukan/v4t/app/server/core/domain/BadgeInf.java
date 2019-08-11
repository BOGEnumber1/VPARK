package studio.tukan.v4t.app.server.core.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BadgeInf {

	private int id;
	private String image;
	private String name;
	private String description;
}
