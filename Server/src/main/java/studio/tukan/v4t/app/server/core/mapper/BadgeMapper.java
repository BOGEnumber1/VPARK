package studio.tukan.v4t.app.server.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import studio.tukan.v4t.app.server.core.domain.Badge;
import studio.tukan.v4t.app.server.core.domain.BadgeInf;

@Mapper
public interface BadgeMapper {

	@Select("select * from badge where userid = #{id}")
	/*
	@Results(id = "BadgeList", value = {
			@Result(property = "badgeInf", column = "badgeinfid", one = @One(select = "getBadgeInfById"), javaType = BadgeInf.class),
			@Result(column = "userid", property = "userid"), @Result(column = "getDate", property = "getdate") })
	*/
	public List<Badge> getBadgeListByUserId(int userid);

	@Select("select * from badgeinf where id = #{badgeinfid}")
	public BadgeInf getBadgeInfById(int badgeinfid);
	
	@Select("select count(*) from badgeinf where id = #{badgeinfid}")
	public int getBadgeCountByBadgeInfId(int badgeinfid);
	

	@Insert("insert into badge(userid,badgeinfid) values(#{id},#{badgeinfid})")
	public boolean addBadge(int id, int badgeinfid);

}
