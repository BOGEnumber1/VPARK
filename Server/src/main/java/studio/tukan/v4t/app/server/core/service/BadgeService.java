package studio.tukan.v4t.app.server.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import studio.tukan.v4t.app.server.core.domain.Badge;
import studio.tukan.v4t.app.server.core.mapper.BadgeMapper;
import studio.tukan.v4t.app.server.core.mapper.SignMapper;

@Service
public class BadgeService {

	@Autowired
	BadgeMapper badgeMapper;

	@Cacheable("badge")
	public List<Badge> getBadgeListByUserId(int id) {

		List<Badge> e = badgeMapper.getBadgeListByUserId(id);

		for (int i = 0; i < e.size(); i++) {

			e.get(i).setBadgeInf(badgeMapper.getBadgeInfById(e.get(i).getBadgeinfid()));

		}

		return e;

	}

	@CacheEvict(value = "badge", allEntries = true)
	public boolean addBadge(int userid, int badgeinfid) {

		return badgeMapper.addBadge(userid, badgeinfid);

	}
	
	@Cacheable("badge")
	public int getBadgeCount(int badgeinfid) {
		
		
		return badgeMapper.getBadgeCountByBadgeInfId(badgeinfid);
		
	}

}
