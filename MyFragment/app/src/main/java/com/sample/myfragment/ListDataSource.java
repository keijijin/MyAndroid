package com.sample.myfragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListDataSource {
    public static List<String> getAllNames() {
        ArrayList<String> list = new ArrayList<>();
        list.add("胡椒");
        list.add("ターメリック");
        list.add("コリアンダー");
        list.add("生姜");
        list.add("ニンニク");
        list.add("サフラン");

        return list;
    }

    public static Map<String, String> getInfoByName(String name) {
        Map<String, String> info = new HashMap<>();
        switch(name) {
            case "胡椒":
                info.put(
                        name,
                        "こしょう科の常緑つる性の小高木。インド原産。実はえんどう豆ぐらいの大きさで、赤く熟す。辛い。");
                break;
            case "ターメリック":
                info.put(
                        name,
                        "ショウガ科の植物、鬱金(うこん)のこと。 また、その根茎を乾燥させた香辛料。 カレー、たくあん漬けなどの黄色い色づけに用いる。");
                break;
            case "コリアンダー":
                info.put(
                        name,
                        "せり科の一年生植物。茎・葉に独特の香気がある。果実は香味料または薬用に使う。香菜(シャンツァイ)。パクチー。");
                break;
            case "生姜":
                info.put(
                        name,
                        "ショウガ科ショウガ属の多年草であり、根茎部分は香辛料として食材に、また生薬として利用される。 熱帯アジア原産。");
                break;
            case "ニンニク":
                info.put(
                        name,
                        "ユリ科の多年草。高さ約60センチ。全体に強いにおいがある。地下の鱗茎 (りんけい) は灰白色で、数個の小鱗茎からなり、食用。強壮薬・香辛料などにも用いる。夏、茎の先に、長い包葉に包まれて白紫色の花が集まって咲く。花の間にむかごをつける。ガーリック。");
                break;
            case "サフラン":
                info.put(
                        name,
                        "糸状または粉状の、高価な香辛料。 植物のサフランの雌しべから得られる。");
                break;
            default:
                info = null;
                break;
        }
        return info;
    }
}
