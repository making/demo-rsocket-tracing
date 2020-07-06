## Demo RSocket Tracing

Download [rsc](https://github.com/making/rsc/releases) CLI. 0.5.0+ is required.

Uses [Tracing (Zipkin) Metadata Extension](https://github.com/rsocket/rsocket/blob/master/Extensions/Tracing-Zipkin.md)

## Fire and Forget

```
$ rsc ws://localhost:8080/rsocket -r fnf --fnf  --trace --printB3 --zipkinUrl http://localhost:9411
b3=5f035f32dd21129b105564ef64c90731-105564ef64c90731-d
```

![image](https://user-images.githubusercontent.com/106908/86621713-a25d3200-bff9-11ea-9b20-61d9c15df91f.png)


## Request Response

```
$ rsc ws://localhost:8080/rsocket -r rr --trace --printB3 --zipkinUrl http://localhost:9411 
Hello World!
b3=5f035ed7dd21129b105564ef64c90731-105564ef64c90731-d
```

![image](https://user-images.githubusercontent.com/106908/86621556-5ad6a600-bff9-11ea-9040-8c300d2d8bcd.png)

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
b3=5f035e90dd21129b105564ef64c90731-105564ef64c90731-d
```

![image](https://user-images.githubusercontent.com/106908/86621466-37abf680-bff9-11ea-9d13-011d5beafd58.png)

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
b3=5f035e07dd21129b105564ef64c90731-105564ef64c90731-d
```

![image](https://user-images.githubusercontent.com/106908/86621357-04696780-bff9-11ea-8041-5c345b13ac63.png)
