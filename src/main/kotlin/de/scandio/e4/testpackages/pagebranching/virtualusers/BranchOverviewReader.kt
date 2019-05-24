package de.scandio.e4.testpackages.pagebranching.virtualusers

import de.scandio.e4.worker.collections.ActionCollection
import de.scandio.e4.worker.interfaces.VirtualUser


/**
 * PageBranching BranchMerger VirtualUser. Extends BranchCreator and creates
 * all branches that it will later merge first.
 *
 * Assumptions:
 * - Space with spacekey "PB"
 * - Page with title "PB Root Origin" in space "PB" containing a pagebranching-macro
 * - 5 branches of page "PB Root Origin" with branch names "Branch X", where X is the index of creation
 *
 * Preparation:
 * - NONE
 *
 * Actions (all SELENIUM):
 * - View page with title "PB Root Origin" in space "PB"
 *
 * @author Felix Grund
 */
class BranchOverviewReader : VirtualUser {

    override fun getActions(): ActionCollection {
        val actions = ActionCollection()
        return actions
    }

}