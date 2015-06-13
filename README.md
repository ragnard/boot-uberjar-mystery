
### leiningen:

```
$ lein uberjar
Compiling boot-uberjar-mystery.main
Compiling boot-uberjar-mystery.system
Compiling boot-uberjar-mystery.test-component
Created /home/ragge/projects/github/uswitch/boot-uberjar-mystery/target/boot-uberjar-mystery-0.1.0-SNAPSHOT.jar
Created /home/ragge/projects/github/uswitch/boot-uberjar-mystery/target/boot-uberjar-mystery.jar
```

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


### boot

```
$ boot build
Compiling 1/1 boot-uberjar-mystery.main...
Writing pom.xml and pom.properties...
Adding uberjar entries...
Writing boot-uberjar-mystery.jar...
```

```
$ java -cp target/boot-uberjar-mystery.jar boot_uberjar_mystery.main
Starting system
Creating system
System started
Stopping system
System stopped
```

