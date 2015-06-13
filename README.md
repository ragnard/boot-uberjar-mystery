# boot uberjar mystery

This project demonstrates a weird issue I discovered when trying to
create an uberjar with boot.

The program consists of three namespaces:

- boot-uberjar-mystery.main:
  - creates and starts system
  - adds shutdown hook that stops system
- boot-uberjar-myster.system:
  - constructs a system with a single `TestComponent`
- boot-uberjar-myster.test-component:
  - a simple component that starts a thread on `start`
  - thread will print every 1s
  - interrupts and joins thread on `stop`

Expected behaviour when running program is that:

- system is started
- test-component is started
- thread prints every 1s
- if process is interrupted (ctrl-c etc), system is stopped gracefully


### leiningen

Step to build uberjar:

```
$ lein uberjar
Compiling boot-uberjar-mystery.main
Compiling boot-uberjar-mystery.system
Compiling boot-uberjar-mystery.test-component
Created /home/ragge/projects/github/uswitch/boot-uberjar-mystery/target/boot-uberjar-mystery-0.1.0-SNAPSHOT.jar
Created /home/ragge/projects/github/uswitch/boot-uberjar-mystery/target/boot-uberjar-mystery.jar
```

Running program:

```
$ java -cp target/boot-uberjar-mystery.jar boot_uberjar_mystery.main
Starting system
Creating system
Starting thread
System started
Thread running
Thread running
Thread running
Thread running
Thread running
^CStopping system
Stopping thread
Exception in thread "Thread-0" java.lang.InterruptedException: sleep interrupted
at java.lang.Thread.sleep(Native Method)
at boot_uberjar_mystery.test_component.TestComponent$fn__307.invoke(test_component.clj:15)
at clojure.lang.AFn.run(AFn.java:22)
at java.lang.Thread.run(Thread.java:745)
Thread stopped
System stopped
```

This is expected behaviour.

### boot

Step to build uberjar:

```
$ boot build
Compiling 1/1 boot-uberjar-mystery.main...
Writing pom.xml and pom.properties...
Adding uberjar entries...
Writing boot-uberjar-mystery.jar...
```

Running program (identical to leiningen):

```
$ java -cp target/boot-uberjar-mystery.jar boot_uberjar_mystery.main
Starting system
Creating system
System started
Stopping system
System stopped
```

This is not expected behaviour. System is created but component is not
started and therefore no thread is started so program terminates
immediately.

I suspect this has something to do with AOT and protocols, some kind
of mismatch between classfiles.
