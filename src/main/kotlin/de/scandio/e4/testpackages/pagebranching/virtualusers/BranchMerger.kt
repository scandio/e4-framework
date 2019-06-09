package de.scandio.e4.testpackages.pagebranching.virtualusers

import de.scandio.e4.testpackages.pagebranching.actions.MergeBranchAction
import de.scandio.e4.worker.collections.ActionCollection
import de.scandio.e4.worker.interfaces.RestClient
import de.scandio.e4.worker.interfaces.WebClient


/**
 * === BranchMerger ===
 *
 * PageBranching BranchMerger VirtualUser. Extends BranchCreator and creates
 * all branches that it will later merge first.
 *
 * Assumptions:
 * - Space with key "PB"
 *
 * Preparation:
 * - ALL PREPARATIONS AND ACTIONS FROM BranchCreator
 *
 * Actions (all SELENIUM):
 * - Merge all branches into their origin pages
 *
 * @author Felix Grund
 */
class BranchMerger : BranchCreator() {

    override fun getActions(): ActionCollection {
        val actions = ActionCollection()
        actions.add(MergeBranchAction("PB"))
        return actions
    }
}