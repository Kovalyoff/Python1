#!groovy

import groovy.io.FileType
import hudson.FilePath
import hudson.*

def folderName = 'Python'
def giturl = 'https://github.com/Kovalyoff/Python1.git'

folder(folderName) {
    displayName('Python')
    description('Folder for Python')
}

pipelineJob("${folderName}/${folderName}-pipeline") {
    definition {
        cps {
            script(readFileFromWorkspace('jenkinsfile'))
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
