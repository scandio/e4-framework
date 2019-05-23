package de.scandio.e4.testpackages.vanilla

import de.scandio.e4.testpackages.vanilla.virtualusers.*
import de.scandio.e4.worker.collections.ActionCollection
import de.scandio.e4.worker.interfaces.TestPackage
import de.scandio.e4.worker.collections.VirtualUserCollection

class VanillaTestPackage: TestPackage {

    override fun getSetupScenarios(): ActionCollection {
        val actions = ActionCollection()
        return actions
    }

    override fun getVirtualUsers(): VirtualUserCollection {
        val virtualUsers = VirtualUserCollection()
        virtualUsers.add(Commentor(), 0.05)
        virtualUsers.add(Reader(), 0.6)
        virtualUsers.add(Creator(), 0.05)
        virtualUsers.add(Searcher(), 0.1)
        virtualUsers.add(Editor(), 0.1)
        virtualUsers.add(Dashboarder(), 0.1)
        return virtualUsers
    }

}