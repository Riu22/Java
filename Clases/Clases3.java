/*
3- Resumeix aquest article: https://en.wikipedia.org/wiki/Garbage_collection_(computer_science)
 */

/*
L'article tracta sobre el maneig de la memòria amb el mètode garbage que és directament que les zones que no són completament necessàries perquè ocupin memòria es
buiden per a impedir excessiu consum de memòria RAM,aquest mètode de maneig de la memòria l'invento John McCarthy en el 1959 que gràcies a ell els programadors no
havien de fer de manera manual la distribució de memòria, sinó que es fa de manera automàtica per a simplificar el treballAlguns llenguatges com a C(amb les seves variants), Java i Go
necessiten un maneig de la memòria de manera manual encara que està implementat el mètode Garbage, ja que coexisteixen per a permetre que es manipuli la memòria de manera manual i que s'alliberi
de manera automàtica de ser necessari implementar aquest mètode, una dels avantatges del mètode Garbage és que pot evitar molts dels bugs referents a l'ús de la memòria, ja que
no hi hauria el problema d'alliberar una secció de la memòria que ja està alliberada causant problemes en intentar fer això, perquè amb l'arribada del mètode Garbage això es va acabar, encara
hi ha diferents bugs però no relacionats amb el d'alliberar memòria que ja està alliberada.
El recol·lector d'escombraries (GC) consumeix recursos, la qual cosa pot afectar el rendiment en evitar la gestió manual de memòria. Un estudi va indicar que requereix cinc vegades més memòria
per a igualar el rendiment d'una gestió manual idealitzada, encara que això es va basar en escenaris específics. A més, el GC pot causar pauses impredictibles, problemàtiques en temps real o aplicacions
interactives, motiu pel qual Apple no ho va implementar en iOS. Recol·lectors concurrents i en temps real mitiguen aquests problemes amb uns certs compromisos.
Tracing garbage collection és el tipus més comú de garbage collection, tant que el terme "garbage collection" sol referir-se específicament a aquesta tècnica en lloc d'altres mètodes com el reference counting.
La seva estratègia principal consisteix a determinar quins objectes han de ser recol·lectats rastrejant quins són assolibles a través d'una cadena de referències des d'uns certs root objects, considerant la resta
com garbage i recol·lectant-los. No obstant això, existeixen nombrosos algorismes per a implementar-la, amb una àmplia varietat de complexitat i característiques de rendiment.
 */