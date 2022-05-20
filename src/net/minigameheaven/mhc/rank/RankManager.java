package net.minigameheaven.mhc.rank;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RankManager {
	
	static Map<UUID, Rank> rankManager = new HashMap<UUID, Rank>();
	
	public static Rank getRank(UUID uuid) {
		return rankManager.get(uuid);
	}
	
	public static void setRank(UUID uuid, Rank rank) {
		rankManager.put(uuid, rank);
	}
}
