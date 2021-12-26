pipelineJob('rest-api-test-ci') {
        definition {
            cpsScm {
            scm {
                git {
                remote {
                    url('https://github.com/robinch93/RestAssured-OkHttp-Maven-API-Test.git')
                }
                branch('*/master')
                }
            }
            lightweight()
            }
        }
    }
