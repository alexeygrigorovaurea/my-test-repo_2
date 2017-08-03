package MyTest2.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.BuildFeature
import jetbrains.buildServer.configs.kotlin.v10.BuildFeature.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v10.failureConditions.BuildFailureOnMetric
import jetbrains.buildServer.configs.kotlin.v10.failureConditions.BuildFailureOnMetric.*
import jetbrains.buildServer.configs.kotlin.v10.failureConditions.failOnMetricChange
import jetbrains.buildServer.configs.kotlin.v10.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v10.triggers.VcsTrigger.*
import jetbrains.buildServer.configs.kotlin.v10.triggers.vcs

object MyTest2_CiBuild2 : BuildType({
    uuid = "058906fe-98df-4392-81dc-028cec63823c"
    extId = "MyTest2_CiBuild2"
    name = "ci build 2"

    vcs {
        root(MyTest2.vcsRoots.MyTest2_MyTestRepo2)

    }

    steps {
        script {
            scriptContent = "echo hello"
        }
    }

    triggers {
        vcs {
        }
    }

    failureConditions {
        failOnMetricChange {
            metric = BuildFailureOnMetric.MetricType.COVERAGE_LINE_PERCENTAGE
            units = BuildFailureOnMetric.MetricUnit.DEFAULT_UNIT
            comparison = BuildFailureOnMetric.MetricComparison.MORE
            compareTo = value()
            param("anchorBuild", "lastSuccessful")
        }
    }

    features {
        feature {
            type = "perfmon"
        }
    }
})
