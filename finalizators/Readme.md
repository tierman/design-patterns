# Wstęp
Finalizatory są nieprzewidywalne, często niebezpieczne i zwykle niepotrzebne.
Ich zastosowanie może powodować nieprawidłową pracę programu, problemy
z przenośnością i obniżenie wydajności.

Java 9 zastępuje finalizatory oczyszczaczami.
Choć są mniej niebezpieczne od finalizatorów, to nadal są nieprzewidywalne,
powolne i zwykle niepotrzebne.

# Metoda finalize() z klasy Object
Metoda finalize() jest uruchamiana przez GC, tuż przed usunięciem obiektu. Jednak nie jest to pewnik, że finalize() zostanie w ogóle uruchomiona.
## Nieprzewidywalność. 
Nie wiemy, kiedy GC postanowi uruchomić metodę.
Samo uruchomienie GC jest zależne od implementacji JVM, jak również od systemu, na którym została ona uruchomiona. 

Niezamierzone różne zachowanie na różnych środowiskach nie jest dobrą praktyką.

# Metoda Cleaner clean()
[Proper use cleaner](/finalizators/src/main/java/pl/dp/cleaners/ProperUseCleaner.java)

# Podsumowanie
Nie należy korzystać z oczyszczaczy, a w przypadku Javy 8 lub
wcześniejszej — z finalizatorów, poza mechanizmami „siatek bezpieczeństwa”
lub zwalniania niekrytycznych zasobów systemu operacyjnego. Nawet wtedy
pamiętaj jednak o nieokreśloności i wpływie na wydajność.

## JVM params
-XX:+UseSerialGC -Xms1024m -Xmx1024m -verbose:gc -XX:+PrintGCDetails