package fri.tik;

public interface Seznam<Tip> {
    // Dodajanje elementa v podatkovno strukturo
    void add(Tip e);

    // Odstranjevanje (in vračanje) prvega elementa iz pod. struk.
    Tip removeFirst();

    // Vračanje prvega elementa iz pod. struk.
    Tip getFirst();

    // Število elementov v podatkovni strukturi
    int size();

    // Globina podatkovne strukture
    int depth();

    // Ali je podakovna struktura prazna
    boolean isEmpty();

    // odstranjevanje (in vracanje) dolocenega elementa iz strukture
    Tip remove(Tip e);

    // ali element obstaja v strukturi
    boolean exists(Tip e);
}

/// bi mogl bit ze od prej ///
// TODO: testi za prioritetno vrsto (vaja 4)
// TODO: dodaj spremembe seznamUV (vaja 5)
// TODO: dopolni teste sklad in prioritetna vrsta (vaja 5)
// TODO: naredi BST (vaja 5)
// TODO: napisi teste za BST (vaja 5)
// TODO: napisi teste za SeznamUV (vaja 5)
// TODO: vticnik za pokritost kode (vaja 6)
// TODO: 100% pokritost kode (vaja 6)

/////////// 1. del ///////////
// TODO: dopolni seznam z metodo List<Tip> asList()
// TODO: dopolni podatkovne strukture z metodo List<Tip> asList()
// TODO: napisi teste za asList()

/////////// 2. del ///////////
// TODO: 2-3 drevo ki implementira vmesnik Seznam
// TODO: testi za 2-3 drevo

/////////// 3. del ///////////
// TODO: posodobi SeznamUV z 2-3 drevesom
// TODO: dodaj use23 v SeznamUV
// TODO: testi za posodobljen seznamUV

/////////// 4. del ///////////
// TODO: belezka: porabe casa, opravil, napak, projektni plan