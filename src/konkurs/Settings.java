package konkurs;

import java.io.Serializable;

public class Settings implements Serializable {

    // --------------------------------------------------------------------------------------------------------------------

    public boolean updatesEnabled;
    public LangType langInterface;

    // --------------------------------------------------------------------------------------------------------------------

    // Domyslne ustawienia
    public Settings() {
        this.updatesEnabled = true;
        this.langInterface = LangType.PL;
    }

    // --------------------------------------------------------------------------------------------------------------------

    // Niestandardowe ustawienia
    public Settings(boolean doUpdates, LangType lang) {
        this.updatesEnabled = doUpdates;
        this.langInterface = lang;
    }

    // --------------------------------------------------------------------------------------------------------------------

    public void setLangInterface(LangType langInterface) {
        this.langInterface = langInterface;
    }

    // --------------------------------------------------------------------------------------------------------------------

    public void setLangInterfaceByName(String langName) {
        switch(langName.toLowerCase())
        {
            case "polski":      setLangInterface(LangType.PL); break;
            case "english":     setLangInterface(LangType.EN); break;
            case "deutsch":     setLangInterface(LangType.DE); break;
            default:            setLangInterface(LangType.PL); break;
        }
    }
}
