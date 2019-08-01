package com.example.vertxVKR.handlers

import com.google.gson.Gson
import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.util.FileManager
import io.vertx.core.Handler
import io.vertx.ext.web.RoutingContext
import org.jsoup.Jsoup

class MainHandler : Handler<RoutingContext> {

    init {
//        sparqlExec()
    }

    override fun handle(event: RoutingContext) {
        event.request().bodyHandler { requestBody ->
            try {
                endResponse(event, sparqlExec())
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }

    private fun endResponse(event: RoutingContext, sparqlTest: Boolean) {

        val HTMLSTring = "<div id=\"bkimg_c\" tabindex=\"0\" class=\"icon i_1\" name=\"1. Общие положения\"></div></a><span class=\"hl\">1. Общие положения</span></span></div><div id=\"p80\" class=\"U\"><span class=\"blk\"><span class=\"nobr\">&nbsp;</span></span></div><div id=\"p81\" style=\"text-indent:27pt;\" class=\"U\"><span class=\"blk\"><a href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=query&amp;REFDOC=312940&amp;REFBASE=LAW&amp;REFPAGE=0&amp;REFTYPE=CDLT_CHILDLESS_CONTENTS_ITEM_MAIN_BACKREFS_P&amp;ts=946115620589141422&amp;mode=backrefs&amp;REFDST=100017\" class=\"backref\"><div id=\"bkimg_cr\" tabindex=\"0\" class=\"icon i_2\" name=\"Пункт 1.1\"></div></a>1.1. Настоящие Правила дорожного движения &lt;*&gt; устанавливают единый порядок дорожного движения на всей территории Российской Федерации. Другие нормативные акты, касающиеся дорожного движения, должны основываться на требованиях Правил и не противоречить им.</span></div><div id=\"p82\" style=\"text-indent:27pt;\" class=\"U MPP\"><span class=\"blk\">--------------------------------</span></div><div id=\"p83\" style=\"text-indent:27pt;\" class=\"U MPP\"><span class=\"blk\">&lt;*&gt; В дальнейшем - Правила.</span></div><div id=\"p84\" class=\"U\"><span class=\"blk\"><span class=\"nobr\">&nbsp;</span></span></div><div id=\"p85\" style=\"text-indent:27pt;\" class=\"U\"><span class=\"blk\"><a href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=query&amp;REFDOC=312940&amp;REFBASE=LAW&amp;REFPAGE=0&amp;REFTYPE=CDLT_CHILDLESS_CONTENTS_ITEM_MAIN_BACKREFS_P&amp;ts=2081115620589149818&amp;mode=backrefs&amp;REFDST=100020\" class=\"backref\"><div id=\"bkimg_cr\" tabindex=\"0\" class=\"icon i_2\" name=\"Пункт 1.2\"></div></a>1.2. В Правилах используются следующие основные понятия и термины:</span></div><div id=\"p86\" style=\"text-indent:27pt;\" class=\"U MPP\"><span class=\"blk\"><a href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=query&amp;REFDOC=312940&amp;REFBASE=LAW&amp;REFPAGE=0&amp;REFTYPE=CDLT_MAIN_BACKREFS&amp;ts=929715620589146472&amp;mode=backrefs&amp;REFDST=100902\" class=\"backref\"><div id=\"bkimg_f\" tabindex=\"0\" class=\"icon i_2\"></div></a>\"Автомагистраль\" - дорога, обозначенная знаком <a nb=\"LAW\" nd=\"312940\" anchorstorage=\"1\" dst=\"1333\" fld=\"text\" o=\"47\" href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=doc&amp;base=LAW&amp;n=312940&amp;dst=100992&amp;fld=134\" tref=\"134:100992\" id=\"r\">5.1</a> &lt;*&gt; и имеющая для каждого направления движения проезжие части, отделенные друг от друга разделительной полосой (а при ее отсутствии - дорожным ограждением), без пересечений в одном уровне с другими дорогами, железнодорожными или трамвайными путями, пешеходными или велосипедными дорожками.</span></div><div class=\"insert red pmrf\" p=\"87\"><div id=\"p87\" class=\"U\"><span class=\"blk\">(в ред. <a nb=\"LAW\" nd=\"57209\" anchorstorage=\"1\" o=\"8\" href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=doc&amp;base=LAW&amp;n=57209&amp;dst=100012&amp;fld=134&amp;REFFIELD=134&amp;REFDST=1000000067&amp;REFDOC=312940&amp;REFBASE=LAW&amp;stat=refcode%3D19827%3Bdstident%3D100012%3Bindex%3D87\" tref=\"134:100012\" id=\"r\">Постановления</a> Правительства РФ от 14.12.2005 N 767)</span></div></div><div class=\"insert pmr pmrl\" p=\"88\"><div id=\"p88\" class=\"UP\"><span class=\"blk\">(см. текст в предыдущей <a nb=\"LAW\" nd=\"44495\" anchorstorage=\"1\" o=\"24\" rightposition=\"59\" rightedition=\"d\" leftposition=\"8\" leftedition=\"n\" href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=doc&amp;base=LAW&amp;n=44495&amp;div=LAW&amp;diff=312940&amp;from=312940-88\" tref=\"134:100021:diff\" id=\"r\">редакции)</a></span></div></div><div id=\"p89\" style=\"text-indent:27pt;\" class=\"U MPP\"><span class=\"blk\">--------------------------------</span></div><div id=\"p90\" style=\"text-indent:27pt;\" class=\"U MPP\"><span class=\"blk\">&lt;*&gt; Здесь и далее приводится нумерация дорожных знаков согласно <a nb=\"LAW\" nd=\"312940\" anchorstorage=\"1\" dst=\"1052\" fld=\"text\" o=\"64\" href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=doc&amp;base=LAW&amp;n=312940&amp;dst=100470&amp;fld=134\" tref=\"134:100470\" id=\"r\">Приложению 1.</a></span></div><div id=\"p91\" class=\"U\"><span class=\"blk\"><span class=\"nobr\">&nbsp;</span></span></div><div id=\"p92\" style=\"text-indent:27pt;\" class=\"U\"><span class=\"blk\"><a href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=query&amp;REFDOC=312940&amp;REFBASE=LAW&amp;REFPAGE=0&amp;REFTYPE=CDLT_MAIN_BACKREFS&amp;ts=13802156205891425068&amp;mode=backrefs&amp;REFDST=1\" class=\"backref\"><div id=\"bkimg_f\" tabindex=\"0\" class=\"icon i_2\"></div></a>\"Автопоезд\" - механическое транспортное средство, сцепленное с прицепом (прицепами).</span></div><div class=\"insert red pmrf pmrl\" p=\"93\"><div id=\"p93\" class=\"U\"><span class=\"blk\">(абзац введен <a nb=\"LAW\" nd=\"44475\" anchorstorage=\"1\" o=\"14\" href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=doc&amp;base=LAW&amp;n=44475&amp;dst=100013&amp;fld=134&amp;REFFIELD=134&amp;REFDST=1000000070&amp;REFDOC=312940&amp;REFBASE=LAW&amp;stat=refcode%3D19827%3Bdstident%3D100013%3Bindex%3D93\" tref=\"134:100013\" id=\"r\">Постановлением</a> Правительства РФ от 25.09.2003 N 595)</span></div></div><div id=\"p94\" style=\"text-indent:27pt;\" class=\"U MPP\"><span class=\"blk\"><a href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=query&amp;REFDOC=312940&amp;REFBASE=LAW&amp;REFPAGE=0&amp;REFTYPE=CDLT_MAIN_BACKREFS&amp;ts=1164156205891422704&amp;mode=backrefs&amp;REFDST=205\" class=\"backref\"><div id=\"bkimg_f\" tabindex=\"0\" class=\"icon i_2\"></div></a>\"Велосипед\" - транспортное средство, кроме инвалидных колясок, которое имеет по крайней мере два колеса и приводится в движение как правило мускульной энергией лиц, находящихся на этом транспортном средстве, в частности при помощи педалей или рукояток, и может также иметь электродвигатель номинальной максимальной мощностью в режиме длительной нагрузки, не превышающей 0,25 кВт, автоматически отключающийся на скорости более 25 км/ч.</span></div><div class=\"insert red pmrf\" p=\"95\"><div id=\"p95\" class=\"U\"><span class=\"blk\">(в ред. <a nb=\"LAW\" nd=\"160988\" anchorstorage=\"1\" o=\"8\" href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=doc&amp;base=LAW&amp;n=160988&amp;dst=100011&amp;fld=134&amp;REFFIELD=134&amp;REFDST=1000000071&amp;REFDOC=312940&amp;REFBASE=LAW&amp;stat=refcode%3D19827%3Bdstident%3D100011%3Bindex%3D95\" tref=\"134:100011\" id=\"r\">Постановления</a> Правительства РФ от 22.03.2014 N 221)</span></div></div><div class=\"insert pmr pmrl\" p=\"96\"><div id=\"p96\" class=\"UP\"><span class=\"blk\">(см. текст в предыдущей <a nb=\"LAW\" nd=\"156134\" anchorstorage=\"1\" o=\"24\" rightposition=\"59\" rightedition=\"d\" leftposition=\"27\" leftedition=\"n\" href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=doc&amp;base=LAW&amp;n=156134&amp;div=LAW&amp;diff=312940&amp;from=312940-96\" tref=\"134:100024:diff\" id=\"r\">редакции</a>)</span></div></div><div id=\"p97\" style=\"text-indent:27pt;\" class=\"U MPP\"><span class=\"blk\">\"Велосипедист\" - лицо, управляющее велосипедом.</span></div><div class=\"insert red pmrf pmrl\" p=\"98\"><div id=\"p98\" class=\"U\"><span class=\"blk\">(абзац введен <a nb=\"LAW\" nd=\"160988\" anchorstorage=\"1\" o=\"14\" href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=doc&amp;base=LAW&amp;n=160988&amp;dst=100020&amp;fld=134&amp;REFFIELD=134&amp;REFDST=1000000073&amp;REFDOC=312940&amp;REFBASE=LAW&amp;stat=refcode%3D19827%3Bdstident%3D100020%3Bindex%3D98\" tref=\"134:100020\" id=\"r\">Постановлением</a> Правительства РФ от 22.03.2014 N 221)</span></div></div><div id=\"p99\" style=\"text-indent:27pt;\" class=\"U MPP\"><span class=\"blk\"><a href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=query&amp;REFDOC=312940&amp;REFBASE=LAW&amp;REFPAGE=0&amp;REFTYPE=CDLT_MAIN_BACKREFS&amp;ts=1221156205891413092&amp;mode=backrefs&amp;REFDST=207\" class=\"backref\"><div id=\"bkimg_f\" tabindex=\"0\" class=\"icon i_2\"></div></a>\"Велосипедная дорожка\" - конструктивно отделенный от проезжей части и тротуара элемент дороги (либо отдельная дорога), предназначенный для движения велосипедистов и обозначенный <a nb=\"LAW\" nd=\"312940\" anchorstorage=\"1\" dst=\"1299\" fld=\"text\" o=\"178\" href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=doc&amp;base=LAW&amp;n=312940&amp;dst=264&amp;fld=134\" tref=\"134:264\" id=\"r\">знаком 4.4.1</a>.</span></div><div class=\"insert red pmrf pmrl\" p=\"100\"><div id=\"p100\" class=\"U\"><span class=\"blk\">(абзац введен <a nb=\"LAW\" nd=\"160988\" anchorstorage=\"1\" o=\"14\" href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=doc&amp;base=LAW&amp;n=160988&amp;dst=100022&amp;fld=134&amp;REFFIELD=134&amp;REFDST=1000000074&amp;REFDOC=312940&amp;REFBASE=LAW&amp;stat=refcode%3D19827%3Bdstident%3D100022%3Bindex%3D100\" tref=\"134:100022\" id=\"r\">Постановлением</a> Правительства РФ от 22.03.2014 N 221)</span></div></div><div id=\"p101\" style=\"text-indent:27pt;\" class=\"U MPP\"><span class=\"blk\">\"Велосипедная зона\" - территория, предназначенная для движения велосипедистов, начало и конец которой обозначены соответственно знаками <a nb=\"LAW\" nd=\"312940\" anchorstorage=\"1\" dst=\"1407\" fld=\"text\" o=\"136\" href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=doc&amp;base=LAW&amp;n=312940&amp;dst=511&amp;fld=134\" tref=\"134:511\" id=\"r\">5.33.1</a> и <a nb=\"LAW\" nd=\"312940\" anchorstorage=\"1\" dst=\"1410\" fld=\"text\" o=\"145\" href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=doc&amp;base=LAW&amp;n=312940&amp;dst=512&amp;fld=134\" tref=\"134:512\" id=\"r\">5.34.1</a>.</span></div><div class=\"insert red pmrf pmrl\" p=\"102\"><div id=\"p102\" class=\"U\"><span class=\"blk\">(абзац введен <a nb=\"LAW\" nd=\"312843\" anchorstorage=\"1\" o=\"14\" href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=doc&amp;base=LAW&amp;n=312843&amp;dst=100011&amp;fld=134&amp;REFFIELD=134&amp;REFDST=1000000075&amp;REFDOC=312940&amp;REFBASE=LAW&amp;stat=refcode%3D19827%3Bdstident%3D100011%3Bindex%3D102\" tref=\"134:100011\" id=\"r\">Постановлением</a> Правительства РФ от 04.12.2018 N 1478)</span></div></div><div id=\"p103\" style=\"text-indent:27pt;\" class=\"U MPP\"><span class=\"blk\"><a href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=query&amp;REFDOC=312940&amp;REFBASE=LAW&amp;REFPAGE=0&amp;REFTYPE=CDLT_MAIN_BACKREFS&amp;ts=1618156205891423505&amp;mode=backrefs&amp;REFDST=100025\" class=\"backref\"><div id=\"bkimg_f\" tabindex=\"0\" class=\"icon i_2\"></div></a>\"Водитель\" - лицо, управляющее каким-либо транспортным средством, погонщик, ведущий по дороге вьючных, верховых животных или стадо. К водителю приравнивается обучающий вождению.</span></div><div id=\"p104\" style=\"text-indent:27pt;\" class=\"U MPP\"><span class=\"blk\"><a href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=query&amp;REFDOC=312940&amp;REFBASE=LAW&amp;REFPAGE=0&amp;REFTYPE=CDLT_MAIN_BACKREFS&amp;ts=25225156205891432144&amp;mode=backrefs&amp;REFDST=100026\" class=\"backref\"><div id=\"bkimg_f\" tabindex=\"0\" class=\"icon i_2\"></div></a>\"Вынужденная остановка\" - прекращение движения транспортного средства из-за его технической неисправности или опасности, создаваемой перевозимым грузом, состоянием водителя (пассажира) или появлением препятствия на дороге.</span></div><div id=\"p105\" style=\"text-indent:27pt;\" class=\"U MPP\"><span class=\"blk\"><a href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=query&amp;REFDOC=312940&amp;REFBASE=LAW&amp;REFPAGE=0&amp;REFTYPE=CDLT_MAIN_BACKREFS&amp;ts=1826715620589141717&amp;mode=backrefs&amp;REFDST=101153\" class=\"backref\"><div id=\"bkimg_f\" tabindex=\"0\" class=\"icon i_2\"></div></a>\"Гибридный автомобиль\" - транспортное средство, имеющее не менее 2 различных преобразователей энергии (двигателей) и 2 различных (бортовых) систем аккумулирования энергии для целей приведения в движение транспортного средства.</span></div><div class=\"insert red pmrf pmrl\" p=\"106\"><div id=\"p106\" class=\"U\"><span class=\"blk\">(абзац введен <a nb=\"LAW\" nd=\"220068\" anchorstorage=\"1\" o=\"14\" href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=doc&amp;base=LAW&amp;n=220068&amp;dst=100012&amp;fld=134&amp;REFFIELD=134&amp;REFDST=1000000076&amp;REFDOC=312940&amp;REFBASE=LAW&amp;stat=refcode%3D19827%3Bdstident%3D100012%3Bindex%3D106\" tref=\"134:100012\" id=\"r\">Постановлением</a> Правительства РФ от 12.07.2017 N 832)</span></div></div><div id=\"p107\" style=\"text-indent:27pt;\" class=\"U MPP\"><span class=\"blk\"><a href=\"../cgi/online.cgi?rnd=F5D321B84FBB9CAAB1D30178C0BF5F3B&amp;req=query&amp;REFDOC=312940&amp;REFBAS"

        val html = Jsoup.parse(HTMLSTring)
        html.allElements



        val response = event.response()
        val resp = if (sparqlTest){
            "success"
        } else {
            "fail"
        }
        val jsonResponseBody = Gson().toJson(resp)
        response.end(jsonResponseBody)
    }

    private fun sparqlExec(): Boolean {
        FileManager.get().addLocatorClassLoader(MainHandler::class.java.classLoader)
        val file = FileManager.get().loadModel("C:\\Users\\Anton\\IdeaProjects\\art\\src\\main\\resources\\iot_vkr2.owl")

        val queryStr = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
                "PREFIX iot: <http://webprotege.stanford.edu/project/co6WD6WelXsz2DLygYbnb#>\n" +
                "SELECT ?x\n" +
                "WHERE {\n" +
                "?x iot:измеряет iot:вибрация.\n" +
                "?x rdf:type ?x\n" +
                "}"

        val query = QueryFactory.create(queryStr)
        val qexec = QueryExecutionFactory.create(query, file)
        try {
            val results = qexec.execSelect()
            while (results.hasNext()) {
                val soln = results.nextSolution()
                System.out.println("x == " + soln.get("x").toString())
                System.out.println("")
            }

        } catch (e: Throwable) {
            System.out.println("error")
            return false
        } finally {
            qexec.close()
        }
        return true
    }

}