package de.scandio.e4.testpackages.vanilla.virtualusers

import de.scandio.e4.testpackages.vanilla.scenarios.ViewPageScenario
import de.scandio.e4.worker.collections.ScenarioCollection
import de.scandio.e4.worker.interfaces.Scenario
import de.scandio.e4.worker.interfaces.VirtualUser


/**
 * Confluence Reader Scenario.
 *
 * Assumptions:
 * - Space with key "E4"
 * - 3 Pages with titles "E4 Reader Page 1", "E4 Reader Page 2", "E4 Reader Page 3"
 * - 2 Blogposts with creation date "2019/05/21" and titles
 *   "E4 Reader Blogpost 1", "E4 Reader Blogpost 2"
 *
 * Actions:
 * - Read page in space "E4" with title "E4 Reader Page 1"
 * - Read page in space "E4" with title "E4 Reader Page 2"
 * - Read page in space "E4" with title "E4 Reader Page 3"
 * - Read blogpost in space "E4" with title "E4 Reader Blogpost 1" and date "2019/05/21"
 * - Read blogpost in space "E4" with title "E4 Reader Blogpost 2" and date "2019/05/21"
 * - Check page restrictions on page in "E4" with title "E4 Reader Page 1"
 * - View page status of page in "E4" with title "E4 Reader Page 1"
 *
 * @author Felix Grund
 */
class Reader : VirtualUser {

    override fun getScenarios(): MutableList<Scenario> {
        val scenarios = ScenarioCollection()
        val spaceKey = "E4"
        scenarios.add(ViewPageScenario(spaceKey, "E4 Reader Page 1"))
//        list.add(ViewPageScenario(spaceKey, "E4 Reader Page 2"))
//        list.add(ViewPageScenario(spaceKey, "E4 Reader Page 3"))
//        list.add(ViewBlogpostScenario(spaceKey, "E4 Reader Blogpost 1","2019/05/21"))
//        list.add(ViewBlogpostScenario(spaceKey, "E4 Reader Blogpost 2","2019/05/21"))
//        list.add(CheckPageRestrictionsScenario(spaceKey, "E4 Reader Page 1"))
//        list.add(ViewPageInfoScenario(spaceKey, "E4 Reader Page 1"))
        return scenarios
    }
}