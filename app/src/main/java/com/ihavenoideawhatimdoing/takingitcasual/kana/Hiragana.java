package com.ihavenoideawhatimdoing.takingitcasual.kana;

public class Hiragana {

    public static final String[][] hiraTable = {
            {"a", "3042"},
            {"i", "3044"},
            {"u", "3046"},
            {"e", "3048"},
            {"o", "304a"},

            {"ka", "304b"},
            {"ki", "304d"},
            {"ku", "304f"},
            {"ke", "3051"},
            {"ko", "3053"},

            {"ga", "304c"},
            {"gi", "304e"},
            {"gu", "3050"},
            {"ge", "3052"},
            {"go", "3054"},

            {"sa", "3055"},
            {"shi", "3057"},
            {"su", "3059"},
            {"se", "305b"},
            {"so", "305d"},

            {"za", "3056"},
            {"ji", "3058"},
            {"zu", "305a"},
            {"ze", "305c"},
            {"zo", "305e"},

            {"ta", "305f"},
            {"chi", "3061"},
            {"tsu", "3064"},
            {"te", "3066"},
            {"to", "3068"},

            {"da", "3060"},
            {"di", "3062"},
            {"du", "3065"},
            {"de", "3067"},
            {"do", "3069"},

            {"na", "306a"},
            {"ni", "306b"},
            {"nu", "306c"},
            {"ne", "306d"},
            {"no", "306e"},

            {"ha", "306f"},
            {"hi", "3072"},
            {"fu", "3075"},
            {"he", "3078"},
            {"ho", "307b"},

            {"ba", "3070"},
            {"bi", "3073"},
            {"bu", "3076"},
            {"be", "3079"},
            {"bo", "307c"},

            {"pa", "3071"},
            {"pi", "3074"},
            {"pu", "3077"},
            {"pe", "307a"},
            {"po", "307d"},

            {"ma", "307e"},
            {"mi", "307f"},
            {"mu", "3080"},
            {"me", "3081"},
            {"mo", "3082"},

            {"ya", "3084"},
            {"", "0000"},
            {"yu", "3086"},
            {"", "0000"},
            {"yo", "3088"},

            {"ra", "3089"},
            {"ri", "308a"},
            {"ru", "308b"},
            {"re", "308c"},
            {"ro", "308d"},

            {"wa", "308f"},
            {"wi", "3090"},
            {"", "0000"},
            {"we", "3091"},
            {"wo", "3092"},

            {"n", "3093"},
            {"vu", "3094"},
            {"", "0000"},
            {"", "0000"},
            {"", "0000"},
    };

    public static final String[][] miniHira = {
            {"a", "3041"},
            {"i", "3043"},
            {"u", "3045"},
            {"e", "3047"},
            {"o", "3049"},

            {"ya", "3083"},
            {"", "0000"},
            {"yu", "3085"},
            {"", "0000"},
            {"yo", "3087"},

            {"tsu", "3063"},
            {"", "0000"},
            {"", "0000"},
            {"", "0000"},
            {"", "0000"},
    };

    public static String IndexToSound(int index){
        return hiraTable[index][0];
    }
    public static String IndexToHex(int index){
        return hiraTable[index][1];
    }
    public static String SoundToHex(String sound){
        for(String[] kana : hiraTable){
            if(sound.equals(kana[0])){
                return kana[1];
            }
        }
        return "fail";
    }

}
