package in.uxdata.springpostgres.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class ShardRoutingDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> currentShard = new ThreadLocal<>();

    public static void setCurrentShard(String shardKey) {
        currentShard.set(shardKey);
    }

    public static void clear() {
        currentShard.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return currentShard.get();
    }
}
