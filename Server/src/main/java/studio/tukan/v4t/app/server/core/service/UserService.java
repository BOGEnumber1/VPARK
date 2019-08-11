package studio.tukan.v4t.app.server.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import studio.tukan.v4t.app.server.core.domain.User;
import studio.tukan.v4t.app.server.core.mapper.UserMapper;
import studio.tukan.v4t.app.server.core.utils.EncryptUtils;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	@CachePut(value="user",key = "#id")
	public User getUserByIdAndPassword(int id, String password) {

		String SHA512 = EncryptUtils.SHA512(password);
		User e = userMapper.getUserByIdAndPassword(id, SHA512);
		e.setPassword(null);
		return e;
	}

	public boolean updateUserPassword(int id, String password) {

		String SHA512 = EncryptUtils.SHA512(password);
		boolean e = userMapper.updateUserPasswordById(SHA512, id);
		return e;
	}
	
	@CacheEvict(value = "user",allEntries = true)
	public boolean changeUserImgHead(int id,String imghead) {
		
		boolean e = userMapper.updateUserImgheadById(imghead, id);
		return e;
		
	}
	
	
	public int insertUserByPassword(User e) {
	
		e.setPassword(EncryptUtils.SHA512(e.getPassword()));
		int i = userMapper.insertUserByPassword(e);
		return i;
	}
	
	@Cacheable(value="user",key = "#id")
	public User getUserById(int id) {
		User e=userMapper.getUserById(id);
		e.setPassword(null);
		return e;
	}	
	
	
	@CacheEvict(value = "user",allEntries = true)
	public boolean UpdateImghead(String imghead,int id) {
		boolean e = userMapper.updateUserImgheadById(imghead, id);
		return e;
	}
	
	@CacheEvict(value = "user",allEntries = true)
	public boolean UpdateColor(String color,int id) {
		boolean e = userMapper.updateUserColorById(color, id);
		return e;
	}
	
	@CacheEvict(value = "user",allEntries = true)
	public boolean UpdateWallpaper(String wallpaper,int id) {
		boolean e = userMapper.updateUserWallpaperById(wallpaper, id);
		return e;
	}
	
	@CacheEvict(value = "user",allEntries = true)
	public boolean UpdateUsername(String username,int id) {
		boolean e = userMapper.updateUsernameById(username, id);
		return e;
	}

}
