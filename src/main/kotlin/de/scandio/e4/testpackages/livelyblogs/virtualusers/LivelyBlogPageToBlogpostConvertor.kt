package de.scandio.e4.testpackages.livelyblogs.virtualusers

import de.scandio.e4.testpackages.livelyblogs.actions.ConvertRandomPageToBlogPost
import de.scandio.e4.testpackages.livelyblogs.actions.SearchBlogpostOverview
import de.scandio.e4.worker.collections.ActionCollection
import de.scandio.e4.worker.interfaces.RestClient
import de.scandio.e4.worker.interfaces.VirtualUser

class LivelyBlogPageToBlogpostConvertor : VirtualUser() {

    override fun getActions(): ActionCollection {
        val actions = ActionCollection()
        actions.add(ConvertRandomPageToBlogPost())
        return actions
    }

}