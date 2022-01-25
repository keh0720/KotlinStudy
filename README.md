# Kotlin Study

## Compare R2dbc and JDBC

### Test environment

동일한 환경에서 같은 부하를 주입했을 때 성능을 비교해본다.

* MacBook Pro Apple M1 (8core), 16GB
* Test tool : vegeta

### R2dbc

1,446 TPS

```
→ vegeta attack -duration=10s -format=http -targets=createRealtimeaccept -rate=1500 | tee result.bin | vegeta report
Requests      [total, rate, throughput]         15000, 1500.09, 1446.15
Duration      [total, attack, wait]             10.001s, 9.999s, 1.66ms
Latencies     [min, mean, 50, 90, 95, 99, max]  14.334µs, 21.758ms, 1.719ms, 60.123ms, 94.559ms, 476.129ms, 735.018ms
Bytes In      [total, mean]                     1330596, 88.71
Bytes Out     [total, mean]                     1417374, 94.49
Success       [ratio]                           96.42%
Status Codes  [code:count]                      0:537  200:14463
Error Set:
Post "http://localhost:8080/realtimeaccept": dial tcp 0.0.0.0:0->[::1]:8080: socket: too many open files
Post "http://localhost:8080/realtimeaccept": dial tcp: lookup localhost: no such host
```

### JDBC

921TPS

```
→ vegeta attack -duration=10s -format=http -targets=createRealtimeaccept -rate=1500 | tee result.bin | vegeta report
Requests      [total, rate, throughput]         15001, 1500.13, 921.86
Duration      [total, attack, wait]             10.001s, 10s, 1.675ms
Latencies     [min, mean, 50, 90, 95, 99, max]  15.75µs, 75.419ms, 1.273ms, 25.655ms, 515.734ms, 1.633s, 2.575s
Bytes In      [total, mean]                     811360, 54.09
Bytes Out     [total, mean]                     903560, 60.23
Success       [ratio]                           61.46%
Status Codes  [code:count]                      0:5781  200:9220
Error Set:
Post "http://localhost:8080/realtimeaccept": dial tcp: lookup localhost: no such host
```