package de.scandio.e4.testpackages.vanilla.scenarios

import de.scandio.atlassian.it.pocketquery.helpers.DomHelper
import de.scandio.e4.confluence.web.WebConfluence
import de.scandio.e4.worker.interfaces.RestClient
import de.scandio.e4.worker.interfaces.Scenario
import de.scandio.e4.worker.interfaces.WebClient
import java.net.URLEncoder
import java.util.*

open class ViewPageScenario (

    val spaceKey: String,
    val pageTitle: String
    ) : Scenario {

    protected var start: Long = 0
    protected var end: Long = 0

    override fun execute(webClient: WebClient, restClient: RestClient) {
        val confluence = webClient as WebConfluence
        val encodedPageTitle = URLEncoder.encode(pageTitle, "utf-8")
        confluence.login()
        confluence.takeScreenshot("after-login")

        this.start = Date().time
        confluence.goToPage(spaceKey, pageTitle)
        this.end = Date().time
        confluence.takeScreenshot("view-page-$spaceKey-$encodedPageTitle")
    }

    override fun getTimeTaken(): Long {
        return this.end - this.start
    }

}