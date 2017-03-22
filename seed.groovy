seed #########################

#!groovy

import groovy.io.FileType
import hudson.FilePath
import hudson.*

def folderName = 'Demo'#####################
def giturl = 'https://github.com/pc-hard/demo2.git'###########################

folder(folderName) {
    displayName('Demo')##################
    description('Folder for Demo')#######################
}

pipelineJob("${folderName}/${folderName}-pipeline") {
    definition {
        cps {
            script(readFileFromWorkspace('jenkinsfile'))#################
            sandbox()
        }
    }
}

job("${folderName}/test") {
    logRotator(-1, 10)
    scm {
            git {
                remote {
                    url(giturl)
                }
            }
        }
     triggers {
        // githubPush()
        scm('H/2 * * * *')
    }
    steps{
        shell(readFileFromWorkspace('test.groovy'))
    }
}

job("${folderName}/build") {
    logRotator(-1, 10)
    triggers {
        // githubPush()
        scm('H/2 * * * *')
    }
    steps{
        shell(readFileFromWorkspace('build.groovy'))
    }
}

job("${folderName}/deploy") {
    logRotator(-1, 10)
    steps{
        shell(readFileFromWorkspace('deploy.groovy'))
    }
    triggers {
        // githubPush()
        scm('H/2 * * * *')
    }
}	