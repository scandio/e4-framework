package de.scandio.e4.testpackages.pagebranching.actions

import de.scandio.e4.confluence.web.WebConfluence
import de.scandio.e4.worker.interfaces.Action
import de.scandio.e4.worker.interfaces.RestClient
import de.scandio.e4.worker.interfaces.WebClient
import java.util.*

/**
 * === CreateOverviewPageAction ===
 *
 * PageBranching CreateBranch action.
 *
 * Assumptions:
 * - Space with key $spaceKey
 * - Page with title $originPageTitle in space $spaceKey that has a few branches
 *
 * Procedure (SELENIUM):
 * - View page with title $originPageTitle in space $spaceKey
 * - Click "Edit" button
 * - When editor loaded, click "Insert" ("+") button > "Other macros"
 * - Search for macro using "page branching" string
 * - Click on macro in macro browser and click "Insert"
 * - Save page
 *
 * Result:
 * - Page with title "$originPageTitle" contains page-branching-overview macro at the top of the content
 *
 * @author Felix Grund
 */
class CreateOverviewPageAction(
        val spaceKey: String,
        val originPageTitle: String
) : Action {

    private var start: Long = 0
    private var end: Long = 0

    override fun execute(webClient: WebClient, restClient: RestClient) {
        val webConfluence = webClient as WebConfluence
        webConfluence.login()
        webConfluence.goToPage(spaceKey, originPageTitle)
        this.start = Date().time
        webConfluence.goToEditPage()
        webConfluence.insertMacro("page-branching-overview", "page branching")
        webConfluence.savePage()
        this.end = Date().time
    }

    override fun getTimeTaken(): Long {
        return this.end - this.start
    }


}