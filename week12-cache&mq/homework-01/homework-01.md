redis-server redis6379.conf
redis-server redis6380.conf
slaveof 127.0.0.1 6379
redis-sentinel sentinel0.conf
redis-sentinel sentinel1.conf

6379 ^C
redis-server redis6379.conf
