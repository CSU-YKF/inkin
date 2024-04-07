package cn.csu.ykf.inkin.console.cache;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import cn.csu.ykf.inkin.common.model.session.UserSession;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SessionCache {

    @Getter
    private static final SessionCache INSTANCE = new SessionCache();

    private final Cache<String, UserSession> cache = Caffeine.newBuilder()
        .expireAfterAccess(24, TimeUnit.HOURS)
        .build();

    public String insertNewSession(UserSession userSession) {
        String token = UUID.randomUUID().toString();
        userSession.setToken(token);
        cache.put(token, userSession);
        return token;
    }

    public UserSession getSession(String token) {
        return cache.getIfPresent(token);
    }
}
