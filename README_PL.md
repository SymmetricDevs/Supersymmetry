<blockquote>
  <details>
    <summary>
      <code>あ ←→ A</code>
    </summary>
    <!--Head-->
    &emsp;&ensp;<sub><b>Supersymmetry</b> supports the following languages. </sub>
    <br />
    <!--Body-->
    <br />
    &emsp;&ensp;Polski
    <br />
    &emsp;&ensp;<a href="/README_PT.md">Português</a>
    <br />
    &emsp;&ensp;<a href="/README.md">English</a>
  </details>
</blockquote>

# Supersymmetry
Supersymmetry jest złożonym, skoncentrowanym na technologii modpackiem, opartym na Gregtech-u, który integruje chemiczne oraz fizyczne procesy z rzeczywistości
do swojego postępu. To oznacza, że zawiera wiele różnych łańcuchów produkcyjnych imitujących procesy produkcji w rzeczywistym świecie.

Wiele rzeczy jest w trakcie fazy rozwoju, a elementy PvE takie jak czynniki środowiskowe oraz zajazdy wrogich frakcji są planowane. Chcemy mieć także własnego [moda kosmicznego](https://github.com/SymmetricDevs/GregicalityStarbound).

Postęp wykracza poza ramy systemu poziomów energii GT, gdyż modpack ma na celu przeciwstawienie się sztywnemu postępowi. Innowacja nie może być dyktowana przez siłę wyższą,
bo dzieje się dzięki badaniom i odkryciom.
## Obecna zawartość modpacka
Na wrzesień 2025, następujące systemy oraz mechaniki zostały dodane, bądź zmienione z stanu domyślnego:
- Nowe reaktory chemiczne,
- Broń i militaria (z modów TechGuns oraz ICBM),
- Nieskończone złoża rud z ich przetwarzaniem,
- Flotacja,
- Katalizatory,
- Duże zmniany w petrochemii, metalurgii oraz kriogenice:
    - Linie produkcyjne polimerów,
    - Nadprzewodniki.

Część modów (na przykład Applied Energistics 2, Stargate, TARDIS) są wymienione w modpacku, lecz ich zawartość nie jest dostępna lecz to ulegnie zmianie.
Na przykład AE2 będzie dostępne po możliwości lotów kosmicznych.

## Wizja modpacka
Paczka modów rozciąga się na różne poziomy technologii, od maszyny parowej do reaktorów jądrowych. Dodatkowo zawiera elementy fizyki teoretycznej, pozwalając graczowi
wykorzystać fenomeny, których Minecraft jeszcze nie widział.

Każdy mod został dostosowany do postępu w Gregtech-u. Przez to automatyzacja oraz masowa produkcja są konieczne, zachęcając do budowy dużych fabryk i systemów logistycznych
by transportować surowce i produkty.
Gracz będzie musiał wykorzystać Powierzchnię Ziemii oraz jej zasoby jako pierwsze, następnie zacząć stałą obecność w Kosmosie, wtem odkrywać Układ Słoneczny, by ostatecznie
wyruszyć w przestrzeń międzygwiezdną, eksplorować wiele różnych planet z ich unikalnymi wyzwaniami, generacją terenu oraz wrogami, z którymi musi się zmierzyć.

Modpack jest obecnie w fazie beta. Możesz dołączyć do servera discord tutaj:
https://discord.gg/BNbbK98rh6.

Gracze poszukujący serwera mogą sprawdzić #looking-for-group na Discordzie.

## Podziękowania  
Dziękujemy twórcom [Gregicality Community Pack](https://github.com/Gregicality/Gregicality-Community-Pack) za pozwolenie nam na użycie części ich skryptów.  
Skrypty dzięki [htmlcsjs](https://github.com/htmlcsjs).  
Modpack utworzony wokół pomysłów [Zalgo](https://github.com/Zalgo239), [Gaming](https://github.com/swagxdragonslayer46yt) oraz [planetme](https://github.com/planetme).  
[Core mod](https://github.com/SymmetricDevs/Susy-Core) zrobiony przez [MTBO](https://github.com/loxoDev), [beanie](https://github.com/BestMod), [Gaming](https://github.com/swagxdragonslayer46yt), [Eight](https://github.com/EightXOR8) oraz [bruberu](https://github.com/bruberu).  
Zadania głównie dzięki [Regian](https://github.com/Regian24).  
Tekstury głównie dzięki [GDCM05](https://github.com/gdcm05).  
Struktury i generacja terenu głównie dzięki [oliwier509](https://github.com/oliwier509).  
Część muzyki menu głównego (menu3.ogg oraz menu4.ogg) dzięki [Ayden George](https://www.youtube.com/@ayden_george_official).  

Specjalne podziękowania dla naszych wolontariuszy:
- tots • Research,
- Eight • Core mod,
- spacemarie • Zadania,
- Memeexp • Modele i tekstury,
- lewis • Research,
- graygloo • Research,
- scheelite • Zadania,
- StarL0st • [Mod kosmiczny](https://github.com/SymmetricDevs/GregicalityStarbound),
- super • Misc development,
- SuperObama • Konsultant,
- trainvoi • Research oraz Zadania,
- ZombieZilla • Research,
- Tian-mi • Chińskie tłumaczenie oraz misc development,
- RoqueSystem.exe (Roque_Crafter) • Tłumaczenie na portugalski,
- kubuus • Tłumaczenie na polski,
- Whatsapp • Struktury, tekstures oraz feedback,
- Science Demon • Praca nad Questbook-iem, tłumaczenie na niemiecki oraz naprawy błędów,
- [Siryeet3000](https://github.com/Siryeet3000) • Struktury,
- Celeryman • Struktury.

## Development Tips
> [Full Usage - Packwiz Tutorial](https://packwiz.infra.link/tutorials/creating/getting-started/)
- Add mod: `packwiz cf add <project name>` ([Full Usage](https://packwiz.infra.link/tutorials/creating/adding-mods/))
- Refresh Hash: `packwiz refresh`
- Print modlist: `packwiz list`
- Update pack version: rewrite version number in [pack.toml](pack.toml)
- Update mod version: `packwiz update <mod>/--all`
- Client only mod: [rewrite <mod>.pw.toml#side manually](https://packwiz.infra.link/reference/pack-format/mod-toml/#properties)

## Budowanie paczki
1. Wpisz `pip install requests`, by zainstalować wymagane pakiety.
2. Wpisz `python build/main.py`.
3. Sprawdź folder `buildOut`.