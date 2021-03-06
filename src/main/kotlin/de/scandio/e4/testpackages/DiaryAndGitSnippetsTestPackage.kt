package de.scandio.e4.testpackages

import de.scandio.e4.testpackages.gitsnippets.actions.SetupDiaryMacroPagesAction
import de.scandio.e4.testpackages.gitsnippets.actions.SetupGitSnippets
import de.scandio.e4.testpackages.gitsnippets.actions.SetupGitSnippetsMacroPagesAction
import de.scandio.e4.testpackages.gitsnippets.virtualusers.DiaryEntryCreator
import de.scandio.e4.testpackages.gitsnippets.virtualusers.SpaceGroupCreator
import de.scandio.e4.testpackages.gitsnippets.virtualusers.GitSnippetsMacroPageReader
import de.scandio.e4.testpackages.vanilla.actions.CreatePageAction
import de.scandio.e4.testpackages.vanilla.actions.CreateSpaceAction
import de.scandio.e4.testpackages.vanilla.virtualusers.*
import de.scandio.e4.worker.client.ApplicationName
import de.scandio.e4.worker.collections.ActionCollection
import de.scandio.e4.worker.interfaces.TestPackage
import de.scandio.e4.worker.collections.VirtualUserCollection

class DiaryAndGitSnippetsTestPackage: TestPackage {

    override fun getSetupActions(): ActionCollection {
        val actions = ActionCollection()

        actions.add(CreateSpaceAction("GS", "Git Snippets", true))
        actions.add(SetupGitSnippets())
        actions.add(CreatePageAction("GS", "macros", "<ac:structured-macro ac:name=\"children\" />", true))
        actions.add(SetupGitSnippetsMacroPagesAction("GS", "macros", 100))

        actions.add(CreateSpaceAction("DR", "Diary", true))
        actions.add(CreatePageAction("DR", "macros", "<ac:structured-macro ac:name=\"children\" />", true))
        actions.add(SetupDiaryMacroPagesAction("DR", "macros", 100))

        return actions
    }

    override fun getVirtualUsers(): VirtualUserCollection {
        val virtualUsers = VirtualUserCollection()
        // 0.80
        virtualUsers.add(Commentor::class.java, 0.08)
        virtualUsers.add(Reader::class.java, 0.28)
        virtualUsers.add(Creator::class.java, 0.1)
        virtualUsers.add(Searcher::class.java, 0.12)
        virtualUsers.add(Editor::class.java, 0.1)
        virtualUsers.add(Dashboarder::class.java, 0.12)

        // 0.2
        virtualUsers.add(GitSnippetsMacroPageReader::class.java, 0.08)
        virtualUsers.add(DiaryEntryCreator::class.java, 0.04)
        virtualUsers.add(SpaceGroupCreator::class.java, 0.08)
        return virtualUsers
    }

    override fun getApplicationName(): ApplicationName {
        return ApplicationName.confluence
    }

}