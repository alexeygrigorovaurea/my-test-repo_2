#!groovy
def BUILD_SERVER='tcp://dlb1.aureacentral.com:2375'
def BUILDER_IMAGE_NAME='registry2.swarm.devfactory.com/ignite/infobright-db-release-centos7-builder-thirdparty:latest'

//not sure if this works in non-declarative pipeline
node ('docker') {
    timestamps { 
	stage 'just do'
        checkout scm
        step([$class: 'XUnitBuilder',
              thresholds: [[$class: 'FailedThreshold', failureThreshold: '1']],
              tools: [[$class: 'UnitTestJunitHudsonTestType', pattern: "**.xml"]]])
        archiveArtifacts artifacts: '**/.teamcity/'
	cobertura autoUpdateStability: false, coberturaReportFile: '**/coverage.xml', conditionalCoverageTargets: '70, 0, 0', failUnhealthy: false, failUnstable: false, lineCoverageTargets: '80, 0, 0', maxNumberOfBuilds: 0, methodCoverageTargets: '80, 0, 0', onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false
	
    }
}