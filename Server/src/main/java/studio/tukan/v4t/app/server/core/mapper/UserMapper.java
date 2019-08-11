package studio.tukan.v4t.app.server.core.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import studio.tukan.v4t.app.server.core.domain.User;

@Mapper
public interface UserMapper {

	
	@Select("select * from user where id = #{id} and password = #{password}")
	public User getUserByIdAndPassword(int id,String password);
	
	@Select("select * from user where id = #{id}")
	public User getUserById(int id);	
	
	@Insert("insert into user(username,password) values(#{username},#{password})")
	@Options(useGeneratedKeys = true, keyColumn = "id",keyProperty = "id")
	public int insertUserByPassword(User e);
	
	@Update("update user set password = #{password} where id = #{id}")
	public boolean updateUserPasswordById(String password,int id); 
	
	@Update("update user set username =  #{username} where id = #{id}")
	public boolean updateUsernameById(String username,int id);
	
	@Update("update user set imghead = #{imghead} where id = #{id}")
	public boolean updateUserImgheadById(String imghead,int id);
	
	@Update("update user set wallpaper = #{wallpaper} where id = #{id}")
	public boolean updateUserWallpaperById(String wallpaper,int id);
	
	@Update("update user set color = #{color} where id = #{id}")
	public boolean updateUserColorById(String color,int id);
	
	
}
