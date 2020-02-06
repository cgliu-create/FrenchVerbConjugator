public class VerbConjugator implements Conjugation{
    /*
    this is the Present Form
    */
// needs to detemine other irreg verbs
    public final String[] er = {"e", "es", "e", "ons", "ez", "ent", "é"};
    public final String[] ir = {"is", "is", "it", "issons", "issez", "issent", "i"};
    public final String[] re = {"s", "s", "", "ons", "ez", "ent", "u"};
    @Override
    public String conjPresentForm(String verb, String form) {
        // check if irreg
        IrregVerb run = new IrregVerb();
        if(run.checkIfIrreg(verb)){
            return run.conjIrregPresentForm(verb, form);
        }
        String[] x = new String[7];
        // take off ending and determine verb type
        String stem = verb.substring(0, verb.length()-2);
        if(verb.substring(verb.length()-2).equalsIgnoreCase("er")){
            for(int i = 0; i<7; i++){
                x[i] = er[i];
            }
        }
        if(verb.substring(verb.length()-2).equalsIgnoreCase("ir")){
            for(int i = 0; i<7; i++){
                x[i] = ir[i];
            }
        }
        if(verb.substring(verb.length()-2).equalsIgnoreCase("re")){
            for(int i = 0; i<7; i++){
                x[i] = re[i];
            }
        }
        // add appropriate ending
        Verb je = new Verb("Je", stem + x[0]);
        Verb tu = new Verb("Tu", stem + x[1]);
        Verb ilelleon = new Verb("Il/Elle/On", stem + x[2]);
        Verb nous = new Verb("Nous", stem + x[3]);
        // exceptions for GER and CER
        if(verb.substring(verb.length()-3).equalsIgnoreCase("ger")){
            nous = new Verb("Nous", stem + "e" + x[3]);
        }
        if(verb.substring(verb.length()-3).equalsIgnoreCase("cer")){
            nous = new Verb("Nous", stem.substring(0, stem.length()-1) + "ç" + x[3]);
        }
        Verb vous = new Verb("Vous", stem + x[4]);
        Verb ilselles = new Verb("Ils/Elles", stem + x[5]);
        // return requested form
        if(form.equalsIgnoreCase("Je")){
            return je.toString();
        }
        if(form.equalsIgnoreCase("Tu")){
            return tu.toString();
        }
        if(form.equalsIgnoreCase("Il") || form.equalsIgnoreCase("Elle") || form.equalsIgnoreCase("On")){
            return ilelleon.toString();
        }
        if(form.equalsIgnoreCase("Nous")){
            return nous.toString();
        }
        if(form.equalsIgnoreCase("Vous")){
            return vous.toString();
        }
        if(form.equalsIgnoreCase("Ils") || form.equalsIgnoreCase("Elles")){
            return ilselles.toString();
        }
        // return list
        VerbList verbs = new VerbList();
        verbs.add(je);
        verbs.add(tu);
        verbs.add(ilelleon);
        verbs.add(nous);
        verbs.add(vous);
        verbs.add(ilselles);
        return verbs.toString();
    }
    /*
    this is the Imparfait Form
    */
    @Override
    public String conjImparfaitForm(String verb, String form) {
        VerbConjugator run = new VerbConjugator();
        // determine stem from present nous form - ons
        String temp = run.conjPresentForm(verb, "Nous").trim();
        String isolate = temp.substring(temp.indexOf("s")+1);
        String stem = isolate.substring(0, isolate.lastIndexOf("ons"));//fixed
        // exception 
        if(verb.equalsIgnoreCase("etre") || verb.equalsIgnoreCase("être")){
            stem = "ét";
        }
        // add appropriate ending
        Verb je = new Verb("Je", stem + "ais");
        Verb tu = new Verb("Tu", stem + "ais");
        Verb ilelleon = new Verb("Il/Elle/On", stem + "ait");
        Verb nous = new Verb("Nous", stem + "ions");
        Verb vous = new Verb("Vous", stem + "iez");
        Verb ilselles = new Verb("Ils/Elles", stem + "aient");
        // return requested form
        if(form.equalsIgnoreCase("Je")){
            return je.toString();
        }
        if(form.equalsIgnoreCase("Tu")){
            return tu.toString();
        }
        if(form.equalsIgnoreCase("Il") || form.equalsIgnoreCase("Elle") || form.equalsIgnoreCase("On")){
            return ilelleon.toString();
        }
        if(form.equalsIgnoreCase("Nous")){
            return nous.toString();
        }
        if(form.equalsIgnoreCase("Vous")){
            return vous.toString();
        }
        if(form.equalsIgnoreCase("Ils") || form.equalsIgnoreCase("Elles")){
            return ilselles.toString();
        }
        // return list
        VerbList verbs = new VerbList();
        verbs.add(je);
        verbs.add(tu);
        verbs.add(ilelleon);
        verbs.add(nous);
        verbs.add(vous);
        verbs.add(ilselles);
        return verbs.toString();
    }

    /*
    this is the Passé Composé Form
    */
// needs to determin those that use etre, and those with irreg pp
    @Override
    public String conjPasseCompose(String verb, String form) {
        // take off ending and determine verb type
        String[] x = new String[7];
        String stem = verb.substring(0, verb.length()-2);
        // add appropriate ending
        if(verb.substring(verb.length()-2).equalsIgnoreCase("er")){
            for(int i = 0; i<7; i++){
                x[i] = er[i];
            }
        }
        if(verb.substring(verb.length()-2).equalsIgnoreCase("ir")){
            for(int i = 0; i<7; i++){
                x[i] = ir[i];
            }
        }
        if(verb.substring(verb.length()-2).equalsIgnoreCase("re")){
            for(int i = 0; i<7; i++){
                x[i] = re[i];
            }
        }
        String pp = stem + x[6]; 
        // determine helping verb
        String jef = "Je ai";
        String tuf = "Tu as";
        String ilelleonf = "Il/Elle/On a";
        String nousf = "Nous avons";
        String vousf = "Vous avez";
        String ilsellesf = "Ils/Elles ont";
        // check if irreg
        IrregVerb run = new IrregVerb();
        if(run.checkIfIrreg(verb)){
            String ln = run.conjIrregAvoirorEtre(verb);
            if(ln.substring(0, ln.indexOf('/')).equalsIgnoreCase("etre")){
                jef = "Je suis";
                tuf = "Tu es";
                ilelleonf = "Il/Elle/On est";
                nousf = "Nous sommes";
                vousf = "Vous êtes";
                ilsellesf = "Ils/Elles sont";
            }
            pp = ln.substring(ln.indexOf('/')+1);
        }
        // add past participle
        Verb je = new Verb(jef, pp);
        Verb tu = new Verb(tuf, pp);
        Verb ilelleon = new Verb(ilelleonf, pp);
        Verb nous = new Verb(nousf, pp);
        Verb vous = new Verb(vousf, pp);
        Verb ilselles = new Verb(ilsellesf, pp);
       // return requested form
        if(form.equalsIgnoreCase("Je")){
        return je.toString();
        }
        if(form.equalsIgnoreCase("Tu")){
            return tu.toString();
        }
        if(form.equalsIgnoreCase("Il") || form.equalsIgnoreCase("Elle") || form.equalsIgnoreCase("On")){
        return ilelleon.toString();
        }
        if(form.equalsIgnoreCase("Nous")){
        return nous.toString();
        }
        if(form.equalsIgnoreCase("Vous")){
        return vous.toString();
        }
        if(form.equalsIgnoreCase("Ils") || form.equalsIgnoreCase("Elles")){
        return ilselles.toString();
        }
        // return list
        VerbList verbs = new VerbList();
        verbs.add(je);
        verbs.add(tu);
        verbs.add(ilelleon);
        verbs.add(nous);
        verbs.add(vous);
        verbs.add(ilselles);
        return verbs.toString();
    }
    /*
    this is the Conditional Form
    */
    @Override
    public String conjConditionnelForm(String verb, String form, boolean past) {
        String stem = verb;
        // check if irreg
        IrregVerb run = new IrregVerb();
        if(run.checkIfIrreg(verb)){
            String ln = run.checkStemIrregConditionnelFutur(verb);
            stem = ln;
        }
        // add appropriate ending
        Verb je = new Verb("Je", stem + "ais");
        Verb tu = new Verb("Tu", stem + "ais");
        Verb ilelleon = new Verb("Il/Elle/On", stem + "ait");
        Verb nous = new Verb("Nous", stem + "ions");
        Verb vous = new Verb("Vous", stem + "iez");
        Verb ilselles = new Verb("Ils/Elles", stem + "aient");
        // return requested form
        if(form.equalsIgnoreCase("Je")){
            return je.toString();
        }
        if(form.equalsIgnoreCase("Tu")){
            return tu.toString();
        }
        if(form.equalsIgnoreCase("Il") || form.equalsIgnoreCase("Elle") || form.equalsIgnoreCase("On")){
            return ilelleon.toString();
        }
        if(form.equalsIgnoreCase("Nous")){
            return nous.toString();
        }
        if(form.equalsIgnoreCase("Vous")){
            return vous.toString();
        }
        if(form.equalsIgnoreCase("Ils") || form.equalsIgnoreCase("Elles")){
            return ilselles.toString();
        }
        // return list
        VerbList verbs = new VerbList();
        verbs.add(je);
        verbs.add(tu);
        verbs.add(ilelleon);
        verbs.add(nous);
        verbs.add(vous);
        verbs.add(ilselles);
        return verbs.toString();
    }
 // needs to include irreg verb stems
    @Override
    public String conjFuturSimpleForm(String verb, String form) {
        String stem = verb;
        // check if irreg
        IrregVerb run = new IrregVerb();
        if(run.checkIfIrreg(verb)){
            String ln = run.checkStemIrregConditionnelFutur(verb);
            stem = ln;
        }
        // add appropriate ending
        Verb je = new Verb("Je", stem + "ai");
        Verb tu = new Verb("Tu", stem + "as");
        Verb ilelleon = new Verb("Il/Elle/On", stem + "a");
        Verb nous = new Verb("Nous", stem + "ons");
        Verb vous = new Verb("Vous", stem + "ez");
        Verb ilselles = new Verb("Ils/Elles", stem + "ont");
        // return requested form
        if(form.equalsIgnoreCase("Je")){
            return je.toString();
        }
        if(form.equalsIgnoreCase("Tu")){
            return tu.toString();
        }
        if(form.equalsIgnoreCase("Il") || form.equalsIgnoreCase("Elle") || form.equalsIgnoreCase("On")){
            return ilelleon.toString();
        }
        if(form.equalsIgnoreCase("Nous")){
            return nous.toString();
        }
        if(form.equalsIgnoreCase("Vous")){
            return vous.toString();
        }
        if(form.equalsIgnoreCase("Ils") || form.equalsIgnoreCase("Elles")){
            return ilselles.toString();
        }
        // return list
        VerbList verbs = new VerbList();
        verbs.add(je);
        verbs.add(tu);
        verbs.add(ilelleon);
        verbs.add(nous);
        verbs.add(vous);
        verbs.add(ilselles);
        return verbs.toString();
    }
    /*
    this is the Imperative Form
    */
    @Override
    public String conjImperatifForm(String verb, String form) {
        // tu, nous, and vous form with a !
        String tuf = conjPresentForm(verb, "tu");
        String tuc = tuf.substring(tuf.indexOf("Tu")+2);
        String nousf = conjPresentForm(verb, "nous");
        String nousc = nousf.substring(nousf.indexOf("Nous")+4);
        String vousf = conjPresentForm(verb, "vous");
        String vousc = vousf.substring(vousf.indexOf("Vous")+4);
        // (tu), (nous), (vous)
        Verb tu = new Verb("(Tu)", tuc+"!");
        Verb nous = new Verb("(Nous)", nousc+"!");
        Verb vous = new Verb("(Vous)", vousc+"!");
        VerbList verbs = new VerbList();
        verbs.add(tu);
        verbs.add(nous);
        verbs.add(vous);
        if(form.equalsIgnoreCase("Tu")){
            return tu.toString();
        }
        if(form.equalsIgnoreCase("Nous")){
            return nous.toString();
        }
        if(form.equalsIgnoreCase("Vous")){
            return vous.toString();
        }
        return verbs.toString();
    }
    /*
    this is the Plus que Parfait Form
    */
    @Override
    public String conjPlusQueParfaitForm(String verb, String form) {
        VerbConjugator run = new VerbConjugator();
        // check if irreg
        IrregVerb go = new IrregVerb();
        // helping verb imparfait
        String hverb = "avoir";
        String pp = "";
        if(go.checkIfIrreg(verb)){
            String ln = go.conjIrregAvoirorEtre(verb);
            if(ln.substring(0, ln.indexOf('/')).equalsIgnoreCase("etre")){
                hverb = "etre";
            }
            pp = ln.substring(ln.indexOf('/')+1);
        }
        if(!(go.checkIfIrreg(verb))){
             // passecompse form and isolate past participle
            String spc = run.conjPasseCompose(verb, "je");
            pp = spc.substring(spc.indexOf("ai")+2); // fixed bug
        }
        String jef = run.conjImparfaitForm(hverb,"je");
        String tuf = run.conjImparfaitForm(hverb,"tu");
        String ilelleonf = run.conjImparfaitForm(hverb,"il");
        String nousf = run.conjImparfaitForm(hverb,"nous");
        String vousf = run.conjImparfaitForm(hverb,"vous");
        String ilsellesf = run.conjImparfaitForm(hverb,"ils");
        // add past participle
        Verb je = new Verb(jef, pp);
        Verb tu = new Verb(tuf, pp);
        Verb ilelleon = new Verb(ilelleonf, pp);
        Verb nous = new Verb(nousf, pp);
        Verb vous = new Verb(vousf, pp);
        Verb ilselles = new Verb(ilsellesf, pp);
        // return requested form
        if(form.equalsIgnoreCase("Je")){
            return je.toString();
        }
        if(form.equalsIgnoreCase("Tu")){
            return tu.toString();
        }
        if(form.equalsIgnoreCase("Il") || form.equalsIgnoreCase("Elle") || form.equalsIgnoreCase("On")){
            return ilelleon.toString();
         }
        if(form.equalsIgnoreCase("Nous")){
            return nous.toString();
        }
        if(form.equalsIgnoreCase("Vous")){
            return vous.toString();
        }
        if(form.equalsIgnoreCase("Ils") || form.equalsIgnoreCase("Elles")){
            return ilselles.toString();
        }
        // return list
        VerbList verbs = new VerbList();
        verbs.add(je);
        verbs.add(tu);
        verbs.add(ilelleon);
        verbs.add(nous);
        verbs.add(vous);
        verbs.add(ilselles);
        return verbs.toString();
    }
    /*
    this is the Futur Anterieur Form
    */
    @Override
    public String conjFuturAnterieurForm(String verb, String form) {
        VerbConjugator run = new VerbConjugator();
        // check if irreg
        IrregVerb go = new IrregVerb();
        // helping verb futur
        String hverb = "avoir";
        String pp = "";
        if(go.checkIfIrreg(verb)){
            String ln = go.conjIrregAvoirorEtre(verb);
            if(ln.charAt(0) != 'a'){
                hverb = "etre";
            }
            pp = ln.substring(ln.indexOf('/')+1);
        }
        if(!(go.checkIfIrreg(verb))){
             // passecompse form and isolate past participle
            String spc = run.conjPasseCompose(verb, "je");
            pp = spc.substring(spc.indexOf("ai")+2); // fixed bug
        }
        String jef = run.conjFuturSimpleForm(hverb,"je");
        String tuf = run.conjFuturSimpleForm(hverb,"tu");
        String ilelleonf = run.conjFuturSimpleForm(hverb,"il");
        String nousf = run.conjFuturSimpleForm(hverb,"nous");
        String vousf = run.conjFuturSimpleForm(hverb,"vous");
        String ilsellesf = run.conjFuturSimpleForm(hverb,"ils");
        // add past participle
        Verb je = new Verb(jef, pp);
        Verb tu = new Verb(tuf, pp);
        Verb ilelleon = new Verb(ilelleonf, pp);
        Verb nous = new Verb(nousf, pp);
        Verb vous = new Verb(vousf, pp);
        Verb ilselles = new Verb(ilsellesf, pp);
        // return requested form
        if(form.equalsIgnoreCase("Je")){
            return je.toString();
        }
        if(form.equalsIgnoreCase("Tu")){
            return tu.toString();
        }
        if(form.equalsIgnoreCase("Il") || form.equalsIgnoreCase("Elle") || form.equalsIgnoreCase("On")){
            return ilelleon.toString();
         }
        if(form.equalsIgnoreCase("Nous")){
            return nous.toString();
        }
        if(form.equalsIgnoreCase("Vous")){
            return vous.toString();
        }
        if(form.equalsIgnoreCase("Ils") || form.equalsIgnoreCase("Elles")){
            return ilselles.toString();
        }
        // return list
        VerbList verbs = new VerbList();
        verbs.add(je);
        verbs.add(tu);
        verbs.add(ilelleon);
        verbs.add(nous);
        verbs.add(vous);
        verbs.add(ilselles);
        return verbs.toString();
    }

    /*
    this is the Futur Proche Form
    */
    @Override
    public String conjFuturProcheForm(String verb, String form) {
         // helping verb
         String jef = "Je vais";
         String tuf = "Tu vas";
         String ilelleonf = "Il/Elle/On va";
         String nousf = "Nous allons";
         String vousf = "Vous allez";
         String ilsellesf = "Ils/Elles vont";
         // add infinitive
         Verb je = new Verb(jef, verb);
         Verb tu = new Verb(tuf, verb);
         Verb ilelleon = new Verb(ilelleonf, verb);
         Verb nous = new Verb(nousf, verb);
         Verb vous = new Verb(vousf, verb);
         Verb ilselles = new Verb(ilsellesf, verb);
        // return requested form
         if(form.equalsIgnoreCase("Je")){
         return je.toString();
         }
         if(form.equalsIgnoreCase("Tu")){
             return tu.toString();
         }
         if(form.equalsIgnoreCase("Il") || form.equalsIgnoreCase("Elle") || form.equalsIgnoreCase("On")){
         return ilelleon.toString();
         }
         if(form.equalsIgnoreCase("Nous")){
         return nous.toString();
         }
         if(form.equalsIgnoreCase("Vous")){
         return vous.toString();
         }
         if(form.equalsIgnoreCase("Ils") || form.equalsIgnoreCase("Elles")){
         return ilselles.toString();
         }
         // return list
         VerbList verbs = new VerbList();
         verbs.add(je);
         verbs.add(tu);
         verbs.add(ilelleon);
         verbs.add(nous);
         verbs.add(vous);
         verbs.add(ilselles);
         return verbs.toString();
    }
    /*
    this is the Subjonctif
    */
    @Override
    public String conjSubjonctifForm(String verb, String form, boolean past) {
        VerbConjugator run = new VerbConjugator();
        // determine stem from present ils form - ent
        String temp = run.conjPresentForm(verb, "ils").trim();
        String isolate = temp.substring(temp.indexOf("s")+1);
        isolate = isolate.substring(isolate.indexOf("s")+1); //fixed
        String stem = isolate.substring(0, isolate.lastIndexOf("ent"));
        String stema = stem;
        String stemb = stem;
        String enda = "e";
        String endb = "es";
        String endc = "e";
        String endd = "ions";
        String ende = "iez";
        String endf = "ent";
        // check if irreg
        IrregVerb irun = new IrregVerb();
        if(irun.checkIfIrreg(verb)){
            String ln = irun.conjIrregAvoirorEtre(verb);
            if(ln.contains("1")){
                enda = ln.substring(ln.indexOf('1')+1, ln.indexOf('2'));
                endb = ln.substring(ln.indexOf('2')+1, ln.indexOf('3'));
                endc = ln.substring(ln.indexOf('3')+1, ln.indexOf('4'));
                endd = ln.substring(ln.indexOf('4')+1, ln.indexOf('5'));
                ende = ln.substring(ln.indexOf('5')+1, ln.indexOf('6'));
                endf = ln.substring(ln.indexOf('6')+1);
            }
            if(!(ln.contains("1"))){
                stema = ln.substring(0, ln.indexOf('/'));
                stemb = ln.substring(ln.indexOf('X'));
            }
        }
        // add appropriate ending
        Verb je = new Verb("Je", stema + enda);
        Verb tu = new Verb("Tu", stema + endb);
        Verb ilelleon = new Verb("Il/Elle/On", stem + endc);
        Verb nous = new Verb("Nous", stemb + endd);
        Verb vous = new Verb("Vous", stemb + ende);
        Verb ilselles = new Verb("Ils/Elles", stemb + endf);
        // return requested form
        if(form.equalsIgnoreCase("Je")){
            return je.toString();
        }
        if(form.equalsIgnoreCase("Tu")){
            return tu.toString();
        }
        if(form.equalsIgnoreCase("Il") || form.equalsIgnoreCase("Elle") || form.equalsIgnoreCase("On")){
            return ilelleon.toString();
        }
        if(form.equalsIgnoreCase("Nous")){
            return nous.toString();
        }
        if(form.equalsIgnoreCase("Vous")){
            return vous.toString();
        }
        if(form.equalsIgnoreCase("Ils") || form.equalsIgnoreCase("Elles")){
            return ilselles.toString();
        }
        // return list
        VerbList verbs = new VerbList();
        verbs.add(je);
        verbs.add(tu);
        verbs.add(ilelleon);
        verbs.add(nous);
        verbs.add(vous);
        verbs.add(ilselles);
        return verbs.toString();
    }
}