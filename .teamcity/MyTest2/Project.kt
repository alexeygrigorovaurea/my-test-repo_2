package MyTest2

import MyTest2.buildTypes.*
import MyTest2.vcsRoots.*
import MyTest2.vcsRoots.MyTest2_MyTestRepo2
import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.Project
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings.*
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.versionedSettings

object Project : Project({
    uuid = "d76cbaf8-b347-4d2d-b0dd-f5e0d43eacea"
    extId = "MyTest2"
    parentId = "_Root"
    name = "my-test_2"

    vcsRoot(MyTest2_MyTestRepo2)

    buildType(MyTest2_CiBuild2)

    features {
        versionedSettings {
            id = "PROJECT_EXT_2"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.PREFER_SETTINGS_FROM_VCS
            rootExtId = MyTest2_MyTestRepo2.extId
            showChanges = true
            settingsFormat = VersionedSettings.Format.KOTLIN
        }
    }
})
