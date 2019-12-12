package com.wexalian.jtrakt.http.query;

import java.util.HashMap;

public enum Language
{
    ABKHAZIAN("ab", "Abkhazian"),
    AFAR("aa", "Afar"),
    AFRIKAANS("af", "Afrikaans"),
    AKAN("ak", "Akan"),
    ALBANIAN("sq", "Albanian"),
    AMHARIC("am", "Amharic"),
    ARABIC("ar", "Arabic"),
    ARAGONESE("an", "Aragonese"),
    ARMENIAN("hy", "Armenian"),
    ASSAMESE("as", "Assamese"),
    AVARIC("av", "Avaric"),
    AYMARA("ay", "Aymara"),
    AZERBAIJANI("az", "Azerbaijani"),
    BAMBARA("bm", "Bambara"),
    BASHKIR("ba", "Bashkir"),
    BASQUE("eu", "Basque"),
    BELARUSIAN("be", "Belarusian"),
    BENGALI("bn", "Bengali"),
    BOKMAL_NORWEGIAN("nb", "Bokmål, Norwegian; Norwegian Bokmål"),
    BOSNIAN("bs", "Bosnian"),
    BULGARIAN("bg", "Bulgarian"),
    BURMESE("my", "Burmese"),
    CATALAN("ca", "Catalan; Valencian"),
    CENTRAL_KHMER("km", "Central Khmer"),
    CHAMORRO("ch", "Chamorro"),
    CHECHEN("ce", "Chechen"),
    CHICHEWA("ny", "Chichewa; Chewa; Nyanja"),
    CHINESE("zh", "Chinese"),
    CORNISH("kw", "Cornish"),
    CORSICAN("co", "Corsican"),
    CREE("cr", "Cree"),
    CROATIAN("hr", "Croatian"),
    CZECH("cs", "Czech"),
    DANISH("da", "Danish"),
    DIVEHI("dv", "Divehi; Dhivehi; Maldivian"),
    DUTCH("nl", "Dutch; Flemish"),
    DZONGKHA("dz", "Dzongkha"),
    ENGLISH("en", "English"),
    ESPERANTO("eo", "Esperanto"),
    ESTONIAN("et", "Estonian"),
    FAROESE("fo", "Faroese"),
    FINNISH("fi", "Finnish"),
    FRENCH("fr", "French"),
    FULAH("ff", "Fulah"),
    GAELIC("gd", "Gaelic; Scottish Gaelic"),
    GALICIAN("gl", "Galician"),
    GANDA("lg", "Ganda"),
    GEORGIAN("ka", "Georgian"),
    GERMAN("de", "German"),
    GREEK("el", "Greek, Modern (1453-)"),
    GUARANI("gn", "Guarani"),
    GUJARATI("gu", "Gujarati"),
    HAITIAN("ht", "Haitan; Haitan Creole"),
    HAUSA("ha", "Hausa"),
    HEBREW("he", "Hebrew"),
    HERERO("hz", "Herero"),
    HINDI("hi", "Hindi"),
    HIRI_MOTU("ho", "Hiri Motu"),
    HUNGARIAN("hu", "Hungarian"),
    ICELANDIC("is", "Icelandic"),
    IGBO("ig", "Igbo"),
    INDONESIAN("id", "Indonesian"),
    INTERLINGUA("ia", "Interlingua (International Auxiliary Language Association)"),
    INTERLINGUE("ie", "Interlingue; Occidental"),
    INUKTITUT("iu", "Inuktitut"),
    INUPIAQ("ik", "Inupiaq"),
    IRISH("ga", "Irish"),
    ITALIAN("it", "Italian"),
    JAPANESE("ja", "Japanese"),
    JAVANESE("jv", "Javanese"),
    KALAALLISUT("kl", "Kalaallisut; Greenlandic"),
    KANNADA("kn", "Kannada"),
    KASHMIRI("ks", "Kashmiri"),
    KAZAKH("kk", "Kazakh"),
    KINYARWANDA("rw", "Kinyarwanda"),
    KIRGHIZ("ky", "Kirghiz; Kyrghyz"),
    KONGO("kg", "Kongo"),
    KOREAN("ko", "Korean"),
    KURDISH("ku", "Kurdisch"),
    LAO("lo", "Lao"),
    LATIN("la", "Latin"),
    LATVIAN("lv", "Latvian"),
    LINGALA("ln", "Lingala"),
    LITHUANIAN("lt", "Lithuanian"),
    LUXEMBOURGISCH("lb", "Luxembourgisch; Letzeburgesch"),
    MACEDONIAN("mk", "Macedonian"),
    MALAGASY("mg", "Malagasy"),
    MALAY("ms", "Malay"),
    MALAYALAM("ml", "Malayalan"),
    MALTESE("mt", "Maltese"),
    MAORI("mi", "Maori"),
    MARATHI("mr", "Marathi"),
    MARSHALLESE("mh", "Marshallese"),
    MONGOLIAN("mn", "Mongolian"),
    NAVAHO("nv", "Navajo; Navaho"),
    NEPALI("ne", "Nepali"),
    NORTHERN_SAMI("se", "Northern Sami"),
    NORWEGIAN("no", "Norwegian"),
    NYNNORSK_NORWEGIAN("nn", "Norwegian Nynorsk; Nynorsk, Norwegian"),
    OCCITAN("oc", "Occitan (post 1500); Provençal"),
    OJIBWA("oj", "Ojibwa"),
    ORIYA("or", "Oriya"),
    OSSETIAN("os", "Ossetan; Ossetic"),
    PALI("pi", "Pali"),
    PANJABI("pa", "Panjabi; Punjabi"),
    PERSIAN("fa", "Persian"),
    POLISH("pl", "Polish"),
    PORTUGUESE("[t", "Porteguese"),
    PUSHTO("ps", "Pushto; Pashto"),
    QUECHUA("qu", "Quechua"),
    ROMANIAN("ro", "Romanian; Moldavian; Moldovan"),
    RUNDI("rn", "Rundi"),
    RUSSIAN("ru", "Russian"),
    SAMOAN("sm", "Samoan"),
    SANGO("sg", "Sango"),
    SANSKRIT("sa", "Sanskrit"),
    SERBIAN("sr", "Serbian"),
    SHONA("sn", "Shona"),
    SINDHI("sd", "Sindhi"),
    SINHALA("si", "Sinhala; Sinhalese"),
    SLOVAK("sk", "Slovak"),
    SLOVENIAN("sl", "Slovenian"),
    SOMALI("so", "Somali"),
    SPANISH("es", "Spanish; Castilian"),
    SUNDANESE("su", "Sundanese"),
    SWAHILI("sw", "Swahili"),
    SWATI("ss", "Swati"),
    SWEDISH("sv", "Swedisch"),
    TAGALOG("tl", "Tagalog"),
    TAHITIAN("ty", "Tahitian"),
    TAJIK("tg", "Tajik"),
    TAMIL("ta", "Tamil"),
    TATAR("tt", "Tatar"),
    TELUGU("te", "Telugu"),
    THAI("th", "Thai"),
    TIBETAN("bo", "Tibetan"),
    TONGA("to", "Tonga (Tonga Islands)"),
    TURKISH("tr", "Turkish"),
    TURKMEN("tk", "Turkmen"),
    UYGHUR("ug", "Uighur; Uyghur"),
    UKRAINIAN("uk", "Ukranian"),
    URDU("ur", "Urdu"),
    UZBEK("uz", "Uzbek"),
    VENDA("ve", "Venda"),
    VIETNAMESE("vi", "Vietnamese"),
    WELSH("cy", "Welsh"),
    WESTERN_FRISIAN("fy", "Western Frisian"),
    WOLOF("wo", "Wolof"),
    XHOSA("xh", "Xhosa"),
    YIDDISH("yi", "Yiddish"),
    YORUBA("yo", "Yoruba"),
    ZHUANG("za", "Zhuang; Chuang"),
    ZULU("zu", "Zulu");
    
    private static final HashMap<String, Language> STRING_MAPPING = new HashMap<>();
    
    static
    {
        for (Language language : values())
        {
            STRING_MAPPING.put(language.toString(), language);
        }
    }
    
    private final String code;
    private final String name;
    
    Language(String code, String name)
    {
        this.code = code;
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    @Override
    public String toString()
    {
        return getCode();
    }
    
    public String getCode()
    {
        return code;
    }
    
    public static Language fromCode(String code)
    {
        return STRING_MAPPING.get(code);
    }
}
