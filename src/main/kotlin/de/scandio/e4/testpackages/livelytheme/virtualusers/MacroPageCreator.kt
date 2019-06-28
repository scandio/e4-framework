package de.scandio.e4.testpackages.livelytheme.virtualusers

import de.scandio.e4.testpackages.livelytheme.actions.CreateRandomLivelyThemeMacroPage
import de.scandio.e4.worker.collections.ActionCollection
import de.scandio.e4.worker.interfaces.VirtualUser


/**
 * === MacroPageCreator ===
 *
 * LivelyTheme MacroPageCreator VirtualUser.
 *
 * Assumptions:
 * - Lively Theme app installed
 * - Lively Theme set as global theme
 * - Space with spacekey "LT"
 *
 * Preparation:
 * - NONE
 *
 * Actions:
 * - Create page with a random Lively Theme macro in space "LT"
 *
 * @author Felix Grund
 */
open class MacroPageCreator : VirtualUser() {

    override fun getActions(): ActionCollection {
        val actions = ActionCollection()
        actions.add(CreateRandomLivelyThemeMacroPage("LT"))
        return actions
    }

}