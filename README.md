## Demo RSocket Tracing

Download [rsc](https://github.com/making/rsc/releases) CLI. **0.9.1+** is required (to get it to work with HTTP instead of HTTPS).

Uses [Tracing (Zipkin) Metadata Extension](https://github.com/rsocket/rsocket/blob/master/Extensions/Tracing-Zipkin.md)

> Run Zipkin Server in advance as follows:
> 
> ```
> docker run --rm -p 9411:9411 openzipkin/zipkin-slim
> ```

## Fire and Forget

```
$ rsc ws://localhost:8080/rsocket -r fnf --fnf  --trace --printB3 --zipkinUrl http://localhost:9411
b3=60d948c6647069d1702285c4f51c2155-702285c4f51c2155-d
```

![image](https://user-images.githubusercontent.com/106908/123578351-9bce5880-d810-11eb-8ae3-cdf079db8314.png)


## Request Response

```
$ rsc ws://localhost:8080/rsocket -r rr --trace --printB3 --zipkinUrl http://localhost:9411 
Hello World!
b3=60d949274ef6766446fb6c5b36eee18a-46fb6c5b36eee18a-d
```

![image](https://user-images.githubusercontent.com/106908/123578413-bdc7db00-d810-11eb-83e5-4afbe205e27b.png)

## Request Stream

```
$ rsc ws://localhost:8080/rsocket -r rs --stream --trace --printB3 --zipkinUrl http://localhost:9411
H
e
l
l
o
 
W
o
r
l
d
!
b3=60d9497a50685780fca24d0c77f8dc4a-fca24d0c77f8dc4a-d
```

![image](https://user-images.githubusercontent.com/106908/123578486-f23b9700-d810-11eb-84a3-652a90efe002.png)

## Request Channel

```
$ rsc ws://localhost:8080/rsocket -r rc -d - --channel --trace --printB3 --zipkinUrl http://localhost:9411
world
Hello world!
demo
Hello demo!
test
Hello test!
(Ctrl+D)
b3=60d949a8b586bf31c059c3fa15390c62-c059c3fa15390c62-d
```

![image](https://user-images.githubusercontent.com/106908/123578567-1b5c2780-d811-11eb-8418-518c22052052.png)