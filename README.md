# sew-4bhit-l7b2

Andreas Sünder, 21.12.2022

Für dieses Projekt wurde der Pull-Ansatz des Observer-Patterns verwendet. Das liegt daran, dass alle Observer in einer Liste bzw. Map in der Tabelle gespeichert sind und diese Tabelle selber nicht weiß, welche Werte die einzelnen Formeln eigentlich brauchen. Dies müsste die Tabelle zuerst herausfinden. Mit dem Pull-Ansatz wird diese Verantwortung einzig und allein den Formeln übergeben, die sich dann selber die von ihnen benötigten Werte holen. Des Weiteren wäre der Pull-Ansatz besser für Implementierungen, die Formeln mit mehreren Referenzen auf andere Zellen (statt nur 2) vorsehen - denn damit ist die Parameteranzahl variabel.