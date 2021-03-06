package de.scandio.e4.testpackages.pocketquery.pqconf

import de.scandio.e4.clients.web.WebConfluence
import de.scandio.e4.helpers.DomHelper
import de.scandio.e4.testpackages.pocketquery.PocketQuerySeleniumHelper
import de.scandio.e4.worker.interfaces.WebClient
import java.util.*

class PocketQueryConfluenceSeleniumHelper(
        webClient: WebClient,
        dom: DomHelper,
        val pqSpaceKey: String
) : PocketQuerySeleniumHelper(webClient, dom) {

    fun insertPocketQueryMacro(
            queryName: String, paramsToCheck: List<String> = arrayListOf(),
            queryParameters: Map<String, String> = mapOf()) {

        val webConfluence = webClient as WebConfluence
        webConfluence.openMacroBrowser("pocketquery", "pocketquery")
        dom.awaitElementPresent("#macro-param-name")
        dom.awaitMilliseconds(200) // FIXME need to wait for the macro browser content to be properly loaded
        setQueryInMacroBrowser(queryName)
        webConfluence.debugScreen("insertPocketQueryMacro-beforeMacroParamsCheckboxesCheck")
        for (macroParam in paramsToCheck) {
            dom.click("#macro-param-$macroParam")
        }
        webConfluence.debugScreen("insertPocketQueryMacro-beforeQueryParametersInsert")
        for (paramKey in queryParameters.keys) {
            val paramValue = queryParameters[paramKey]
            dom.insertText("#pocket-param-$paramKey", paramValue!!)
        }
        webConfluence.debugScreen("insertPocketQueryMacro-beforeSave")
        webConfluence.saveMacroBrowser()
    }

    fun setQueryInMacroBrowser(queryName: String) {
        webConfluence().debugScreen("setQueryInMacroBrowser-1")
        setSelect2Option("#query-name-select", queryName)
        webConfluence().debugScreen("setQueryInMacroBrowser-2")
    }

    fun createPocketQueryPage(
            queryName: String, macroParamsToCheck: List<String> = arrayListOf(),
            queryParameters: Map<String, String> = mapOf()) {

        val pageTitle = "PQ TestBasicSqlSetup (${Date().time})"
        webConfluence().createDefaultPage(pqSpaceKey, pageTitle)
        webConfluence().goToEditPage()
        insertPocketQueryMacro(queryName, macroParamsToCheck, queryParameters)
        webConfluence().savePage()
    }

    private fun webConfluence() : WebConfluence {
        return this.webClient!! as WebConfluence
    }

}