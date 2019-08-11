package studio.tukan.v4t.app.server.core.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String password;
	private String username;
	private String color;
	private String imghead;
	private String wallpaper;
	private Date registerDate;
	
	
}
