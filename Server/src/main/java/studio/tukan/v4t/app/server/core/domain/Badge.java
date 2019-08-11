package studio.tukan.v4t.app.server.core.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Badge {

	private int userid;
	private int badgeinfid;
	
	private BadgeInf badgeInf;
	private Date getDate;
	
	
	
	public Badge(int userid, int badgeinfid, Date getDate) {
		super();
		this.userid = userid;
		this.badgeinfid = badgeinfid;
		this.getDate = getDate;
	}
	
	
	
	
}
