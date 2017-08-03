package MyTest2.vcsRoots

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.vcs.GitVcsRoot

object MyTest2_MyTestRepo2 : GitVcsRoot({
    uuid = "15126092-a346-47a2-961e-2c098029b2c8"
    extId = "MyTest2_MyTestRepo2"
    name = "my-test-repo_2"
    url = "git@github.com:alexeygrigorovaurea/my-test-repo_2.git"
    branchSpec = "refs/heads/(*)"
    authMethod = uploadedKey {
        uploadedKey = "id_rsa"
    }
})
