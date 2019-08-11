package studio.tukan.v4t.app.server.core.mapper;

import java.sql.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SignMapper {

	@Select("select count(*) from sign where id = #{id}")
	public int getAllSignByUserId(int id);
	
	@Insert("Insert into sign(id,date) values(#{id},#{date})")
	public boolean addSignByUserId(int id,Date date);
	
	@Select("select count(*) from sign where id = #{id} and date = #{date}")
	public int getSignCountByUserIdAndDate(int id,Date date);
	
}
