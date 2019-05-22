package de.scandio.e4.testpackages.vanilla.scenarios

import de.scandio.atlassian.it.pocketquery.helpers.DomHelper
import de.scandio.e4.confluence.web.WebConfluence
import de.scandio.e4.worker.interfaces.RestClient
import de.scandio.e4.worker.interfaces.WebClient
import java.util.*

class ViewPageInfoScenario(
        spaceKey: String,
        pageTitle: String
) : ViewPageScenario(spaceKey, pageTitle) {

    override fun execute(webClient: WebClient, restClient: RestClient) {
        super.execute(webClient, restClient)
        val confluence = webClient as WebConfluence
        val dom = DomHelper(confluence)
        this.start = Date().time
        dom.click("#action-menu-link")
        dom.awaitElementClickable("#view-page-info-link")
        dom.click("#view-page-info-link")
        dom.awaitElementPresent(".pageInfoTable")
        confluence.takeScreenshot("pageinfo")
        this.end = Date().time
    }

}