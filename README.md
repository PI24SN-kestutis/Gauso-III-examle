# GaussThirdMethodExplained.java
**Tema:** Gauso metodas (III būdas) — mokomasis Java pavyzdys

---

## 🧩 Aprašymas
Šis Java programos pavyzdys skirtas **Gauso metodo trečiajam būdui** (su pagrindinio elemento parinkimu po eilutės normalizavimo) pademonstruoti.  
Kodas parašytas **remiantis doc. dr. Rimos Kriauzienės** paskaitų ir pateiktų pavyzdžių medžiaga iš kurso
> *„Skaitiniai metodai – tiesioginiai tiesinių lygčių sistemų sprendimo metodai“*  
(Vilniaus kolegija, 2025).

---

## 🎯 Tikslas
Projektas sukurtas **mokymosi tikslais**, siekiant:
- perteikti **paprasčiausią Gauso metodo** skaičiavimo logiką,
- parodyti **trečiojo būdo žingsnius** (normalizavimas, eilučių ir stulpelių keitimas),
- suprasti **skaitinio stabilumo** svarbą,
- suteikti **vizualų supratimą** apie algoritmo eigą konsolėje.

---

## ⚙️ Funkcionalumas
Programa žingsnis po žingsnio atlieka Gauso metodo (III būdo) veiksmus:
1. **Normalizuoja eilutes** pagal didžiausią moduliu koeficientą;
2. **Parenka eilutę** su mažiausia koeficientų modulių suma (stabilumo tikslas);
3. **Pasirenka pagrindinį elementą** – didžiausią moduliu reikšmę eilutėje;
4. **Sukeičia stulpelius**, jei reikia išvengti dalybos iš mažo skaičiaus;
5. **Paaiškina kiekvieną keitimą** (kodėl keičiamos eilutės ar stulpeliai);
6. **Atlieka eliminaciją** ir **spausdina tarpinius rezultatus** su 1 s pauze;
7. Pabaigoje pateikia **galutinį trikampį pavidalą** ir **sprendinį (x₁, x₂, …)**.

---

## 🖥️ Paleidimas
1. Atsisiųskite failą `GaussThirdMethodExplained.java`.
2. Paleiskite jį bet kurioje Java aplinkoje (pvz., IntelliJ IDEA, Eclipse ar komandinėje eilutėje):
3. Programa žingsnis po žingsnio rodys matricas ir paaiškinimus konsolėje.
   Kiekvienas žingsnis bus atskirtas 1 sekundės pauze – kad galima būtų sekti skaičiavimų eigą.

---

## 📖 Pavyzdinė užduotis
Sprendžiama sistema:

{10, 1, -3, -5|25},
{-1, 6, 2, 2|6},
{-5, -1, 8, -1|-33},
{-1, -2, 2, 6|-26}

Sprendinys: {0,3,-4,-2}

## 🧠 Mokomasis tikslas
Šis pavyzdys nėra skirtas kompiuteriniam tikslumui ar našumui vertinti.
Jis parodo metodo loginę seką, kuri padeda studentams suvokti,
kaip atliekami elementarieji matricos pertvarkymai, ir kodėl pasirenkami tam tikri žingsniai (eilutės, stulpeliai, dalybos veiksmai).

##  ✍️ Autorių nuoroda
Parengta remiantis doc. dr. Rimos Kriauzienės dėstoma medžiaga
„Skaitiniai metodai – tiesioginiai tiesinių lygčių sistemų sprendimo metodai“,
Vilniaus kolegija, 2025.

## 📚 Naudojimas
Šį kodą galima naudoti:
1. laboratoriniams darbams,
2. mokomiesiems eksperimentams,
3. algoritmų vizualizacijai auditorijoje.

Licencija: Edukacinis naudojimas (non-commercial).
Autorius: Kęstutis Skrebė, remiantis akademine literatūra.


```bash
javac GaussThirdMethodExplained.java
java GaussThirdMethodExplained
