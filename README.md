# springshard
## To practice Sharding and Partiotions
### Create two shards for the database store

```
createdb store_shard_1
createdb store_shard_2
```

### After connecting to shard 1 create partiotioned table 

```
CREATE TABLE orders (
    order_id INTEGER NOT NULL PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    order_status INTEGER NOT NULL,
    order_date DATE NOT NULL,
    required_date DATE,
    shipped_date DATE,
    store_id INTEGER NOT NULL,
    staff_id INTEGER NOT NULL,
    order_id_mod2 INTEGER GENERATED ALWAYS AS (order_id % 2) STORED,
    CHECK (order_id >= 1 AND order_id <= 9)
) PARTITION BY LIST (order_id_mod2);
```

-- Partition for odd order_ids (e.g., 1, 3, 5, 7, 9)
```
CREATE TABLE IF NOT EXISTS orders_p11 PARTITION OF orders
    FOR VALUES IN (1);
```

-- Partition for even order_ids (e.g., 2, 4, 6, 8)
```
CREATE TABLE IF NOT EXISTS orders_p12 PARTITION OF orders
    FOR VALUES IN (0);
```

### After connecting to shard 2 create partiotioned table 

```
CREATE TABLE orders (
    order_id INTEGER NOT NULL PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    order_status INTEGER NOT NULL,
    order_date DATE NOT NULL,
    required_date DATE,
    shipped_date DATE,
    store_id INTEGER NOT NULL,
    staff_id INTEGER NOT NULL,
    order_id_mod2 INTEGER GENERATED ALWAYS AS (order_id % 2) STORED,
    CHECK (order_id >= 11 AND order_id <= 20)
) PARTITION BY LIST (order_id_mod2);
```

-- Odd partition (mod 2 = 1)
```
CREATE TABLE orders_p21 PARTITION OF orders
    FOR VALUES IN (1);
```

-- Even partition (mod 2 = 0)
```
CREATE TABLE orders_p22 PARTITION OF orders
```
    FOR VALUES IN (0);
