package studio.tukan.v4t.app.server.core.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import studio.tukan.v4t.app.server.core.mapper.SignMapper;

@Service
public class SignService {

	
	@Autowired
	SignMapper signMapper;
	
	
	@Cacheable("sign")
	public int getSignTotal(int userid) {
		
		
		
		return signMapper.getAllSignByUserId(userid);
	}
	
	
	@CacheEvict(value = "sign",allEntries = true)
	public int doSign(int userid) {
		
		Date date = new Date(System.currentTimeMillis());
		
		
		int i = signMapper.getSignCountByUserIdAndDate(userid, date);
		
		if(i<=0) {
		
		boolean e = signMapper.addSignByUserId(userid,date);
		
		
		if(e) {
			
			i=100;
			
		}else {
			
			i=101;
			
		}
		
		
		}else {
			i=102;
		}
		
		
		return i;
	}
	

	
	
}
