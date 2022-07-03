# Metoda finalize() z klasy Object
Metoda finalize() jest uruchamiana przez GC, tuż przed usunięciem obiektu. Jednak nie jest to pewnik, że finalize() zostanie w ogóle uruchomiona.
## Nieprzewidywalność. 
Nie wiemy, kiedy GC postanowi uruchomić metodę.
Samo uruchomienie GC jest zależne od implementacji JVM, jak również od systemu, na którym została ona uruchomiona. 

Niezamierzone różne zachowanie na różnych środowiskach nie jest dobrą praktyką.

# Metoda clean()


## JVM params
-XX:+UseSerialGC -Xms1024m -Xmx1024m -verbose:gc -XX:+PrintGCDetails