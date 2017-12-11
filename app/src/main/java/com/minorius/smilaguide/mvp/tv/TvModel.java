package com.minorius.smilaguide.mvp.tv;

import com.minorius.smilaguide.adapter.pojo.tv.TvChannel;
import com.minorius.smilaguide.adapter.pojo.tv.TvGroup;
import com.minorius.smilaguide.adapter.pojo.tv.TvMarker;

import java.util.ArrayList;

/**
 * Created by minorius on 05.09.2017.
 */

public class TvModel {

    public ArrayList<Object> getTvList(){

        ArrayList<Object> list = new ArrayList();

        list.add(new TvGroup("Дитячі"));
        list.add(getChildrenList());
        list.add(new TvGroup("Кіно"));
        list.add(getFilmList());
        list.add(new TvGroup("Музика"));
        list.add(getMusicList());
        list.add(new TvGroup("Новини"));
        list.add(getNewsList());
        list.add(new TvGroup("Пізнавальне"));
        list.add(getDiscovery());
        list.add(new TvGroup("Різне"));
        list.add(getAnother());
        list.add(new TvGroup("Спорт"));
        list.add(getSportList());
        list.add(new TvGroup("Ефірні"));
        list.add(getEfirList());
        list.add(new TvGroup("Юмор"));
        list.add(getHumorList());
        return list;
    }

    private ArrayList<TvMarker> getChildrenList(){
        ArrayList<TvMarker> list = new ArrayList<>();
        list.add(new TvChannel("Duck TV",           "tv_duck",          "http://stream17.koma.tv:9082/98-ducktv_2/index.m3u8"));
        list.add(new TvChannel("Gulli Girl",        "tv_gulligirl",     "http://stream17.koma.tv:9082/192-gulli_1/index.m3u8"));
        list.add(new TvChannel("Nick Junior",       "tv_nickjunior",    "http://stream17.koma.tv:9082/125-nickjunior_2/index.m3u8"));
        list.add(new TvChannel("Nickelodeon",       "tv_nickelodeon",   "http://stream16.koma.tv:9082/80-nickelodeon/index.m3u8"));
        list.add(new TvChannel("TiJi",              "tv_tiji",          "http://stream17.koma.tv:9082/193-tiji_2/index.m3u8"));
        list.add(new TvChannel("Детский мир",       "tv_detskijmir",    "http://stream16.koma.tv:9082/114-detmir_1/index.m3u8"));
        list.add(new TvChannel("Зоопарк",           "tv_zoopark",       "http://stream16.koma.tv:9082/85-zoopark/index.m3u8"));
        list.add(new TvChannel("Малятко TV",        "tv_malatko",       "http://stream16.koma.tv:9082/71-maliatkotv/index.m3u8"));
        list.add(new TvChannel("Оце",               "tv_oce",           "http://stream16.koma.tv:9082/36-qtv/index.m3u8"));
        list.add(new TvChannel("Піксель",           "tv_pixel",         "http://stream16.koma.tv:9082/67-pixel_1/index.m3u8"));
        list.add(new TvChannel("ПлюсПлюс",          "tv_plusplus",      "http://stream17.koma.tv:9082/12-plusplus_2/index.m3u8"));
        return list;
    }

    private ArrayList<TvMarker> getFilmList(){
        ArrayList<TvMarker> list = new ArrayList<>();
        list.add(new TvChannel("Bollywood HD",           "tv_bollywood",          "http://stream17.koma.tv:9082/173-bollywoodhd_2/index.m3u8"));
        list.add(new TvChannel("Sony Channel",           "tv_sony_channel",       "http://stream17.koma.tv:9082/181-set_2/index.m3u8"));
        list.add(new TvChannel("Sony Sci-Fi",            "tv_sony_sci_fi",        "http://stream17.koma.tv:9082/183-sonyscifi_2/index.m3u8"));
        list.add(new TvChannel("Sony Turbo",             "tv_sony_turbo",         "http://stream17.koma.tv:9082/182-sonyturbo_2/index.m3u8"));
        list.add(new TvChannel("TV1000 Action",          "tv_tv1000_action",      "http://stream16.koma.tv:9082/198-tv1000action_2/index.m3u8"));
        list.add(new TvChannel("TV1000 Comedy",          "tv_tv1000_comedy",      "http://stream16.koma.tv:9082/202-tv1000comedy_2/index.m3u8"));
        list.add(new TvChannel("TV1000 East",            "tv_tv1000_east",        "http://stream16.koma.tv:9082/206-tv1000east_2/index.m3u8"));
        list.add(new TvChannel("TV1000 World kino",      "tv_tv1000_world_kino",  "http://stream16.koma.tv:9082/205-tv1000worldkino_2/index.m3u8"));
        list.add(new TvChannel("ZeeTV",                  "tv_zeetv",              "http://stream16.koma.tv:9082/159-zeetv/index.m3u8"));
        list.add(new TvChannel("Еврокино",               "tv_evrokino",           "http://stream17.koma.tv:9082/162-eurokino/index.m3u8"));
        list.add(new TvChannel("Киномикс",               "tv_kinomix",            "http://stream17.koma.tv:9082/121-kinomix_2/index.m3u8"));
        list.add(new TvChannel("Кинохит",                "tv_kinohit",            "http://stream17.koma.tv:9082/116-kinohit_1/index.m3u8"));
        list.add(new TvChannel("Мужской",                "tv_muzskoy",            "http://stream17.koma.tv:9082/129-muzhskoy_1/index.m3u8"));
        list.add(new TvChannel("Наше любимое кино",      "tv_nashe_lubimoe_kino", "http://stream16.koma.tv:9082/115-nashekino_1/index.m3u8"));
        list.add(new TvChannel("Наше новое кино",        "tv_nashe_novoe_kino",   "http://stream17.koma.tv:9082/118-nashenovoekino_1/index.m3u8"));
        list.add(new TvChannel("TV XXl",                 "tv_xxi",                "http://stream16.koma.tv:9082/120-tv21_1/index.m3u8"));

        return list;
    }

    private ArrayList<TvMarker> getMusicList(){
        ArrayList<TvMarker> list = new ArrayList<>();

        list.add(new TvChannel("EU.Music",              "tv_eu_music",            "http://stream16.koma.tv:9082/52-eumusic_1/index.m3u8"));
        list.add(new TvChannel("M1",                    "tv_m1",                  "http://stream17.koma.tv:9082/24-m1/index.m3u8"));
        list.add(new TvChannel("M2",                    "tv_m2",                  "http://stream17.koma.tv:9082/27-m2/index.m3u8"));
        list.add(new TvChannel("MCM Top",               "tv_mcm_top",             "http://stream16.koma.tv:9082/197-mcmtop_2/index.m3u8"));
        list.add(new TvChannel("Mezzo",                 "tv_mezzo",               "http://stream16.koma.tv:9082/194-mezzo_2/index.m3u8"));
        list.add(new TvChannel("MTV Dance",             "tv_mtv_dance",           "http://stream17.koma.tv:9082/76-mtvdance/index.m3u8"));
        list.add(new TvChannel("MTV Hits",              "tv_mtv_hits",            "http://stream17.koma.tv:9082/77-mtvhits_1/index.m3u8"));
        list.add(new TvChannel("MTV Rocks",             "tv_mtv_rocks",           "http://stream17.koma.tv:9082/78-mtvrocks/index.m3u8"));
        list.add(new TvChannel("Music Box UA",          "tv_music_box_ua",        "http://stream16.koma.tv:9082/35-musicboxua_1/index.m3u8"));
        list.add(new TvChannel("OTV Music",             "tv_otv",                 "http://stream17.koma.tv:9082/15-otv/index.m3u8"));
        list.add(new TvChannel("VH1 Classic",           "tv_vh1_classic",         "http://stream17.koma.tv:9082/89-vh1classic/index.m3u8"));
        list.add(new TvChannel("VH1 Europe",            "tv_vh1_europe",          "http://stream17.koma.tv:9082/88-vh1/index.m3u8"));
        list.add(new TvChannel("Zoom",                  "tv_zoom",                "http://stream16.koma.tv:9082/75-zoom/index.m3u8"));
        list.add(new TvChannel("Europa Plus",           "tv_evropa_plus",         "http://stream16.koma.tv:9082/113-evropaplus_1/index.m3u8"));
        list.add(new TvChannel("ЕТНО HD",               "tv_etno",                "http://stream17.koma.tv:9082/184-etnohd_2/index.m3u8"));
        list.add(new TvChannel("Наш канал",             "tv_nash_kanal",          "http://stream17.koma.tv:9082/37-nashkanal/index.m3u8"));
        list.add(new TvChannel("Наше Music HD",         "tv_nashe_music_hd",      "http://stream17.koma.tv:9082/185-nashemusichd_2/index.m3u8"));

        return list;
    }

    private ArrayList<TvMarker> getHumorList(){
        ArrayList<TvMarker> list = new ArrayList<>();
        list.add(new TvChannel("Kvartal TV",            "tv_kvartal",            "http://stream17.koma.tv:9082/152-kvartal_2/index.m3u8"));
        list.add(new TvChannel("НЛО TV",                "tv_nlo",                "http://stream17.koma.tv:9082/20-nlotv_1/index.m3u8"));
        list.add(new TvChannel("Сонце",                 "tv_sonce",              "http://stream17.koma.tv:9082/19-sonce_1/index.m3u8"));
        return list;
    }

    private ArrayList<TvMarker> getNewsList(){
        ArrayList<TvMarker> list = new ArrayList<>();
        list.add(new TvChannel("1+1",                 "tv_1plus1",          "http://stream17.koma.tv:9082/11-1plus1/index.m3u8"));
        list.add(new TvChannel("112 Україна",         "tv_112",             "http://stream16.koma.tv:9082/48-112chanel_2/index.m3u8"));
        list.add(new TvChannel("24 Телеканал новин",  "tv_24_news",         "http://stream17.koma.tv:9082/28-24tv_1/index.m3u8"));
        list.add(new TvChannel("5 канал",             "tv_5kanal",          "http://stream16.koma.tv:9082/45-5kanal_1/index.m3u8"));
        list.add(new TvChannel("BBC World News",      "tv_bbc_world_news",  "http://stream16.koma.tv:9082/189-bbcworld_2/index.m3u8"));
        list.add(new TvChannel("France 24",           "tv_france_24",       "http://stream17.koma.tv:9082/190-france24/index.m3u8"));
        list.add(new TvChannel("News Network",        "tv_news_network",    "http://stream16.koma.tv:9082/93-newsnetwork_2/index.m3u8"));
        list.add(new TvChannel("NewsOne",             "tv_news_one",        "http://stream16.koma.tv:9082/51-newsone_1/index.m3u8"));
        list.add(new TvChannel("Громадське ТВ",       "tv_gromadske",       "http://stream16.koma.tv:9082/gromadske/index.m3u8"));
        list.add(new TvChannel("Еспресо",             "tv_espreso",         "http://stream17.koma.tv:9082/50-espresotv_1/index.m3u8"));
        list.add(new TvChannel("Культура",            "tv_ua_kult",         "http://stream16.koma.tv:9082/32-kultura_2/index.m3u8"));
        list.add(new TvChannel("ТРК Україна",         "tv_trk_ukr",         "http://stream17.koma.tv:9082/58-trkukraina_1/index.m3u8"));
        return list;
    }

    private ArrayList<TvMarker> getDiscovery(){
        ArrayList<TvMarker> list = new ArrayList<>();
        list.add(new TvChannel("CNL",                   "tv_cnl",               "http://stream17.koma.tv:9082/92-cnl/index.m3u8"));
        list.add(new TvChannel("Food Network",          "tv_food_network",      "http://stream17.koma.tv:9082/171-foodnetwork_2/index.m3u8"));
        list.add(new TvChannel("Fox",                   "tv_fox",               "http://stream16.koma.tv:9082/167-fox/index.m3u8"));
        list.add(new TvChannel("History",               "tv_history",           "http://stream16.koma.tv:9082/136-history_2/index.m3u8"));
        list.add(new TvChannel("Nat Geo Wild",          "tv_nat_geo",           "http://stream16.koma.tv:9082/94-natgeowild_2/index.m3u8"));
        list.add(new TvChannel("National Geographic",   "tv_natgeographic",     "http://stream16.koma.tv:9082/87-natgeographic_1/index.m3u8"));
        list.add(new TvChannel("RTi",                   "tv_rti",               "http://stream17.koma.tv:9082/99-rti/index.m3u8"));
        list.add(new TvChannel("Travel",                "tv_travel",            "http://stream17.koma.tv:9082/55-travelch_1/index.m3u8"));
        list.add(new TvChannel("Viasat Explore",        "tv_viasat_explore",    "http://stream16.koma.tv:9082/201-viasatexplore_2/index.m3u8"));
        list.add(new TvChannel("Viasat History",        "tv_viasat_history",    "http://stream16.koma.tv:9082/200-viasathistory_2/index.m3u8"));
        list.add(new TvChannel("Viasat Nature",         "tv_viasat_nature",     "http://stream16.koma.tv:9082/199-viasatnature_2/index.m3u8"));
        list.add(new TvChannel("Мега",                  "tv_mega",              "http://stream16.koma.tv:9082/63-mega_1/index.m3u8"));
        list.add(new TvChannel("Наука",                 "tv_nauka",             "http://stream16.koma.tv:9082/207-nauka_1/index.m3u8"));
        list.add(new TvChannel("Перший автомобільний",  "tv_avto",              "http://stream16.koma.tv:9082/14-1avtomobilniy_2/index.m3u8"));
        list.add(new TvChannel("Терра",                 "tv_terra",             "http://stream16.koma.tv:9082/208-terra_1/index.m3u8"));
        list.add(new TvChannel("Трофей",                "tv_trofey",            "http://stream16.koma.tv:9082/79-trofey/index.m3u8"));
        list.add(new TvChannel("Фауна",                 "tv_fauna",             "http://stream16.koma.tv:9082/209-fauna_1/index.m3u8"));
        return list;
    }

    private ArrayList<TvMarker> getAnother(){
        ArrayList<TvMarker> list = new ArrayList<>();
        list.add(new TvChannel("AMC MGM",                   "tv_amc",               "http://stream17.koma.tv:9082/172-amc/index.m3u8"));
        list.add(new TvChannel("Fashion One HD",            "tv_fashion_one",       "http://stream17.koma.tv:9082/127-fashiononehd_2/index.m3u8"));
        list.add(new TvChannel("Fashion TV HD",             "tv_fashion_tv",        "http://stream17.koma.tv:9082/166-fashiontvhd_1/index.m3u8"));
        list.add(new TvChannel("Maxxi-TV",                  "tv_maxi_tv",           "http://stream16.koma.tv:9082/70-maxxitv/index.m3u8"));
        list.add(new TvChannel("Milady",                    "tv_milady",            "http://stream17.koma.tv:9082/29-milady/index.m3u8"));
        list.add(new TvChannel("World Fashion",             "tv_fasion_world",      "http://stream17.koma.tv:9082/122-worldfashion_2/index.m3u8"));
        list.add(new TvChannel("Бігуді",                    "tv_bigudi",            "http://stream17.koma.tv:9082/25-bigudi_2/index.m3u8"));
        list.add(new TvChannel("Вікка",                     "tv_vika",              "http://stream17.koma.tv:9082/04-vikka_2/index.m3u8"));
        list.add(new TvChannel("Ескулап",                   "tv_esculap",           "http://stream17.koma.tv:9082/59-eskulap_2/index.m3u8"));
        list.add(new TvChannel("К1",                        "tv_k1",                "http://stream17.koma.tv:9082/61-k1_1/index.m3u8"));
        list.add(new TvChannel("К2",                        "tv_k2",                "http://stream16.koma.tv:9082/62-k2_1/index.m3u8"));
        list.add(new TvChannel("Київ TV",                   "tv_kyiv",              "http://stream16.koma.tv:9082/8-kyiv_2/index.m3u8"));
        list.add(new TvChannel("КРТ",                       "tv_krt",               "http://stream17.koma.tv:9082/21-krt/index.m3u8"));
        list.add(new TvChannel("СК1 Житомир",               "tv_sk1",               "http://stream17.koma.tv:9082/sk1zt/index.m3u8"));
        list.add(new TvChannel("ТЕТ",                       "tv_tet",               "http://stream16.koma.tv:9082/41-tet_1/index.m3u8"));
        return list;
    }

    private ArrayList<TvMarker> getSportList(){
        ArrayList<TvMarker> list = new ArrayList<>();
        list.add(new TvChannel("Extreme sports",            "tv_extreme",                 "http://stream17.koma.tv:9082/95-extremesports_1/index.m3u8"));
        list.add(new TvChannel("Viasat sport",              "tv_viasat_sport",            "http://stream16.koma.tv:9082/203-viasatsport_2/index.m3u8"));
        list.add(new TvChannel("XSPORT.ua",                 "tv_xsport",                  "http://stream17.koma.tv:9082/82-xsport_1/index.m3u8"));
        list.add(new TvChannel("Футбол 1",                  "tv_football_1",              "http://stream16.koma.tv:9082/56-football1_2/index.m3u8"));
        list.add(new TvChannel("Футбол 2",                  "tv_football_2",              "http://stream16.koma.tv:9082/57-football2_2/index.m3u8"));
        return list;
    }

    private ArrayList<TvMarker> getEfirList(){
        ArrayList<TvMarker> list = new ArrayList<>();
        list.add(new TvChannel("2+2",                   "tv_2plus2",                     "http://stream16.koma.tv:9082/42-2plus2_2/index.m3u8"));
        list.add(new TvChannel("Enter-фильм",           "tv_enter_film",                 "http://stream16.koma.tv:9082/73-enterfilm_1/index.m3u8"));
        list.add(new TvChannel("ICTV",                  "tv_ictv",                       "http://stream16.koma.tv:9082/33-ictv_1/index.m3u8"));
        list.add(new TvChannel("UA:Крим",               "tv_krym",                       "http://stream16.koma.tv:9082/7-uakrym_1/index.m3u8"));
        list.add(new TvChannel("UA:Перший",             "tv_pershuy_natsional",          "http://stream16.koma.tv:9082/31-pershiynats_1/index.m3u8"));
        list.add(new TvChannel("ZIK",                   "tv_zik",                        "http://stream17.koma.tv:9082/53-zik_1/index.m3u8"));
        list.add(new TvChannel("Індіго",                "tv_indigo",                     "http://stream17.koma.tv:9082/17-indigo_1/index.m3u8"));
        list.add(new TvChannel("Інтер",                 "tv_inter",                      "http://stream16.koma.tv:9082/74-inter/index.m3u8"));
        list.add(new TvChannel("Новий канал",           "tv_noviy",                      "http://stream16.koma.tv:9082/26-novytv_1/index.m3u8"));
        list.add(new TvChannel("НТН",                   "tv_ntn",                        "http://stream17.koma.tv:9082/64-ntn_1/index.m3u8"));
        list.add(new TvChannel("Рось",                  "tv_ros",                        "http://stream17.koma.tv:9082/03-ros_2/index.m3u8"));
        list.add(new TvChannel("СТБ",                   "tv_stb",                        "http://stream16.koma.tv:9082/23-stb_1/index.m3u8"));
        return list;
    }

}
